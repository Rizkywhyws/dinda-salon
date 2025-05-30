package BaseApp;

import java.awt.Color;
import java.awt.Component;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PembelianAdmin extends javax.swing.JFrame {
    
    public PembelianAdmin() throws SQLException {
        setUndecorated(true);
        initComponents();
        cmbx_supplier.setOpaque(false);
        cmbx_produk.setOpaque(false);
        cmbx_supplier.setBackground(new Color(0, 0, 0, 0));
        cmbx_produk.setBackground(new Color(0, 0, 0, 0));
        cmbx_supplier.setForeground(Color.WHITE);
        cmbx_produk.setForeground(Color.WHITE);
        cmbx_supplier.setBorder(null);
        cmbx_produk.setBorder(null);
        cmbx_supplier.setRenderer(new DefaultListCellRenderer() {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value,int index, boolean isSelected, boolean cellHasFocus) {
            Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (c instanceof JComponent) {
                ((JComponent) c).setOpaque(false);
            }
            return c;
}
});
         cmbx_produk.setRenderer(new DefaultListCellRenderer() {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value,int index, boolean isSelected, boolean cellHasFocus) {
            Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (c instanceof JComponent) {
                ((JComponent) c).setOpaque(false);
            }
            return c;
}
});
        setLocationRelativeTo(null);
       // Saat klik tabel, isi textfield dan combobox
tb_pembelian.getSelectionModel().addListSelectionListener(e -> {
    if (!e.getValueIsAdjusting() && tb_pembelian.getSelectedRow() != -1) {
        int selectedRow = tb_pembelian.getSelectedRow();

        String idBeli = tb_pembelian.getValueAt(selectedRow, 0).toString();

        // Ambil nilai dari kolom tabel
        String supplier = tb_pembelian.getValueAt(selectedRow, 1).toString();
        String produk = tb_pembelian.getValueAt(selectedRow, 2).toString();
        String jumlah = tb_pembelian.getValueAt(selectedRow, 3).toString();
        String total = tb_pembelian.getValueAt(selectedRow, 4).toString();

        // Set combo box sesuai nama
        for (int i = 0; i < cmbx_supplier.getItemCount(); i++) {
            if (cmbx_supplier.getItemAt(i).toString().contains(supplier)) {
                cmbx_supplier.setSelectedIndex(i);
                break;
            }
        }

        for (int i = 0; i < cmbx_produk.getItemCount(); i++) {
            if (cmbx_produk.getItemAt(i).toString().contains(produk)) {
                cmbx_produk.setSelectedIndex(i);
                break;
            }
        }

        // Set textfield
        txt_jumlah.setText(jumlah);

        try {
            int totalInt = Integer.parseInt(total);
            int jumlahInt = Integer.parseInt(jumlah);
            int harga = jumlahInt != 0 ? totalInt / jumlahInt : 0;
            txt_harga.setText(String.valueOf(harga));
        } catch (NumberFormatException ex) {
            txt_harga.setText("");
        }

        txttotalbeli.setText(total);
    }
});


        
            javax.swing.event.DocumentListener autoHitungListener = new javax.swing.event.DocumentListener() {
        private void updateTotal() {
            try {
                int jumlah = Integer.parseInt(txt_harga.getText());
                int subtotal = Integer.parseInt(txt_jumlah.getText());
                int total = jumlah * subtotal;
                txttotalbeli.setText(String.valueOf(total));
            } catch (NumberFormatException e) {
                txttotalbeli.setText("");
            }
        }
        

        @Override
        public void insertUpdate(javax.swing.event.DocumentEvent e) {
            updateTotal();
        }

        @Override
        public void removeUpdate(javax.swing.event.DocumentEvent e) {
            updateTotal();
        }

        @Override
        public void changedUpdate(javax.swing.event.DocumentEvent e) {
            updateTotal();
        }
    };

    txt_harga.getDocument().addDocumentListener(autoHitungListener);
    txt_jumlah.getDocument().addDocumentListener(autoHitungListener);
        
    DefaultTableModel model = new DefaultTableModel(new Object[][]{}, new String[]{
    "ID_Beli", "Supplier","Produk", "Jumlah", "Total", "Tanggal"
}) {
    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }
};
        tb_pembelian.setModel(model);

        // Sembunyikan kolom ID_Beli agar tidak terlihat di GUI
        tb_pembelian.getColumnModel().getColumn(0).setMinWidth(0);
        tb_pembelian.getColumnModel().getColumn(0).setMaxWidth(0);
        tb_pembelian.getColumnModel().getColumn(0).setWidth(0);
        tb_pembelian.getColumnModel().getColumn(0).setPreferredWidth(0);
 
       tb_pembelian.setRowHeight(27);
       LoadData();
      try{
          loadProduct();
          loadSupplier();
      }catch (SQLException ex){
          ex.printStackTrace();
      }
    // Perbaikan untuk ListSelectionListener pada tabel


 }
    
public void LoadData() {
        String url = "jdbc:mysql://localhost:3306/dinda_salon";
        String user = "root";
        String pw = "";
        String query = "SELECT pembelian.id_beli, supplier.nama_supplier, produk.nama_produk, detail_pembelian.jumlah_beli, pembelian.total_beli, pembelian.tgl_beli " +
                   "FROM detail_pembelian " +
                   "JOIN pembelian ON detail_pembelian.id_beli = pembelian.id_beli " +
                   "JOIN produk ON detail_pembelian.kd_produk = produk.kd_produk " +
                   "JOIN supplier ON pembelian.id_supplier = supplier.id_supplier";

         try  {
             Connection conn = DriverManager.getConnection(url, user, pw);
              Statement stm = conn.createStatement();
              ResultSet rs = stm.executeQuery(query);
             DefaultTableModel model = (DefaultTableModel) tb_pembelian.getModel();
             model.setRowCount(0);

             while (rs.next()) {
                 Object[] row = {
                     rs.getString("id_beli"),
                     rs.getString("nama_supplier"),
                     rs.getString("nama_produk"),
                     rs.getInt("jumlah_beli"),
                     rs.getDouble("total_beli"),
                     rs.getDate("tgl_beli")
                 };
                 model.addRow(row);
             }
         } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "Gagal tampil data! Error: " + e.getMessage());
         }
     }




  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btntreatment = new javax.swing.JButton();
        btnproduk = new javax.swing.JButton();
        btnsupplier = new javax.swing.JButton();
        btnmembership = new javax.swing.JButton();
        btnlaporan = new javax.swing.JButton();
        btnpegawai = new javax.swing.JButton();
        btnback = new javax.swing.JButton();
        btnsave = new javax.swing.JButton();
        cmbx_supplier = new javax.swing.JComboBox<>();
        cmbx_produk = new javax.swing.JComboBox<>();
        txt_harga = new javax.swing.JTextField();
        txt_jumlah = new javax.swing.JTextField();
        txttotalbeli = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_pembelian = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btntreatment.setContentAreaFilled(false);
        btntreatment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btntreatment.png"))); // NOI18N
        btntreatment.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bgtreatment.png"))); // NOI18N
        btntreatment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btntreatmentMouseEntered(evt);
            }
        });
        btntreatment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntreatmentActionPerformed(evt);
            }
        });
        jPanel1.add(btntreatment, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 90, 90));

        btnproduk.setContentAreaFilled(false);
        btnproduk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btnproduk.png"))); // NOI18N
        btnproduk.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bgproduk.png"))); // NOI18N
        btnproduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprodukActionPerformed(evt);
            }
        });
        jPanel1.add(btnproduk, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 90, 90));

        btnsupplier.setContentAreaFilled(false);
        btnsupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btnsupplier.png"))); // NOI18N
        btnsupplier.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bgsupplier.png"))); // NOI18N
        btnsupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsupplierActionPerformed(evt);
            }
        });
        jPanel1.add(btnsupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 90, 90));

        btnmembership.setContentAreaFilled(false);
        btnmembership.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btnmembership.png"))); // NOI18N
        btnmembership.setToolTipText("");
        btnmembership.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bgmembership.png"))); // NOI18N
        btnmembership.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmembershipActionPerformed(evt);
            }
        });
        jPanel1.add(btnmembership, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 90, 90));

        btnlaporan.setContentAreaFilled(false);
        btnlaporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btnlaporan.png"))); // NOI18N
        btnlaporan.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bglaporan.png"))); // NOI18N
        btnlaporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlaporanActionPerformed(evt);
            }
        });
        jPanel1.add(btnlaporan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 90, 90));

        btnpegawai.setContentAreaFilled(false);
        btnpegawai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btnpegawai.png"))); // NOI18N
        btnpegawai.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bgpegawai.png"))); // NOI18N
        btnpegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpegawaiActionPerformed(evt);
            }
        });
        jPanel1.add(btnpegawai, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 90, 90));

        btnback.setContentAreaFilled(false);
        btnback.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/back.png"))); // NOI18N
        btnback.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/back1.png"))); // NOI18N
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });
        jPanel1.add(btnback, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 880, 90, -1));

        btnsave.setContentAreaFilled(false);
        btnsave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btnsave.png"))); // NOI18N
        btnsave.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bgsave.png"))); // NOI18N
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });
        jPanel1.add(btnsave, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 890, -1, -1));

        cmbx_supplier.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        cmbx_supplier.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih nama supplier" }));
        cmbx_supplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbx_supplierActionPerformed(evt);
            }
        });
        jPanel1.add(cmbx_supplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 300, 390, 30));

        cmbx_produk.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        cmbx_produk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih produk" }));
        cmbx_produk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbx_produkActionPerformed(evt);
            }
        });
        jPanel1.add(cmbx_produk, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 390, 390, 30));

        txt_harga.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        txt_harga.setBorder(null);
        jPanel1.add(txt_harga, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 470, 390, 30));

        txt_jumlah.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        txt_jumlah.setBorder(null);
        jPanel1.add(txt_jumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 560, 390, 30));

        txttotalbeli.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        txttotalbeli.setBorder(null);
        jPanel1.add(txttotalbeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 647, 390, 30));

        tb_pembelian.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        tb_pembelian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Supplier", "Produk", "Jumlah", "Total", "Tanggal"
            }
        ));
        jScrollPane1.setViewportView(tb_pembelian);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 670, 550));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Frame/Pembelian.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 980));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btntreatmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntreatmentActionPerformed
        // TODO add your handling code here:
        new TreatmentAdmin().setVisible(true);
        dispose();
    }//GEN-LAST:event_btntreatmentActionPerformed

    private void btntreatmentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btntreatmentMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btntreatmentMouseEntered

    private void btnprodukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprodukActionPerformed
        // TODO add your handling code here:
        new ProdukAdmin().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnprodukActionPerformed

    private void btnsupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsupplierActionPerformed
        // TODO add your handling code here:
        new SupplierAdmin().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnsupplierActionPerformed

    private void btnmembershipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmembershipActionPerformed
        // TODO add your handling code here:
        new MembershipAdmin().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnmembershipActionPerformed

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        // TODO add your handling code here:
        new DashboardAdmin().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnbackActionPerformed

    private void btnpegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpegawaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnpegawaiActionPerformed

    private void btnlaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlaporanActionPerformed
        // TODO add your handling code here:
        new Laporan1().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnlaporanActionPerformed

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        // TODO add your handling code here:
            int idUser = SessionLogin.getIdUser();
          if (idUser == 0) {
              JOptionPane.showMessageDialog(this, "User belum login, silakan login kembali!", "ERROR", JOptionPane.WARNING_MESSAGE);
              return;
          }

          try {
              // Validasi agar inputan diisi oleh user
              if (cmbx_supplier.getSelectedIndex() == 0 || cmbx_produk.getSelectedIndex() == 0) {
                  JOptionPane.showMessageDialog(this, "Harap Pilih Salah Satu!", "ERROR", JOptionPane.WARNING_MESSAGE);
                  return;
              }
              if (txt_harga.getText().isEmpty() || txt_jumlah.getText().isEmpty() || txttotalbeli.getText().isEmpty()) {
                  JOptionPane.showMessageDialog(this, "Harap Jangan Dikosongi!", "ERROR", JOptionPane.WARNING_MESSAGE);
                  return;
              }


              // Proses inisialisasi 
              int idSupplier = getIdFromComboBoxSupp(cmbx_supplier);
              String idProduk = getIdFromComboBox(cmbx_produk);
              String jumlah = txt_harga.getText();
              String total = txttotalbeli.getText();
              LocalDate tgl_beli = LocalDate.now();

              SimpanTransaksi(idSupplier, idProduk, jumlah, total, idUser, tgl_beli);

          } catch (Exception e) {
              JOptionPane.showMessageDialog(this, "YAHH Gagal melakukan transaksi!", "ERROR", JOptionPane.ERROR_MESSAGE);
          }

    }//GEN-LAST:event_btnsaveActionPerformed

    private void cmbx_supplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbx_supplierActionPerformed
        // TODO add your handling code here:
         try {
            String selectedItem = (String) cmbx_supplier.getSelectedItem();
            if (selectedItem == null || selectedItem.equals("0 - Pilih Jenis")) {
                return;
            }

            // More robust parsing of the selected item
            String[] parts = selectedItem.split(" - ", 2);
            if (parts.length < 2) {
                throw new IllegalArgumentException("Format item tidak valid");
            }

            int selectedId = Integer.parseInt(parts[0].trim());
            String selectedName = parts[1].trim();

            // For debugging (remove in production)
            System.out.println("Supplier terpilih - ID: " + selectedId + ", Nama: " + selectedName);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Format ID supplier tidak valid", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_cmbx_supplierActionPerformed

    private void cmbx_produkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbx_produkActionPerformed
        // TODO add your handling code here:
        String idProduk = getIdFromComboBox(cmbx_produk);
        if (!idProduk.isEmpty() && !idProduk.equals("0")) {
            loadHarga(idProduk);
            System.out.println("ID yang dipilih: " + idProduk);
        } else {
            txt_harga.setText("0");
        }
    }//GEN-LAST:event_cmbx_produkActionPerformed
    private void SimpanTransaksi(int idSupplier, String idProduk, String jumlah, String total, int idUser, LocalDate tgl_beli) {
    Connection conn = null;
    PreparedStatement stmt1 = null;
    PreparedStatement stmt2 = null;
    
    try {
        String url = "jdbc:mysql://localhost:3306/dinda_salon";
        String user = "root";
        String pw = "";
        conn = DriverManager.getConnection(url, user, pw);
        
        // Mengaktifkan auto-commit untuk memulai transaksi
        conn.setAutoCommit(false);
        
        // Query untuk menambah data ke tabel pembelian
        String insert1 = "INSERT INTO pembelian (id_user, id_supplier, tgl_beli, total_beli) VALUES (?, ?, ?, ?)";
        stmt1 = conn.prepareStatement(insert1, Statement.RETURN_GENERATED_KEYS);
        stmt1.setInt(1, idUser);
        stmt1.setInt(2, idSupplier);
        stmt1.setDate(3, java.sql.Date.valueOf(tgl_beli));
        stmt1.setDouble(4, Double.parseDouble(total));

        int affectedRows = stmt1.executeUpdate();
        
        int idTrans = 0;
        if (affectedRows > 0) {
            try (ResultSet generatedKeys = stmt1.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    idTrans = generatedKeys.getInt(1);
                }
            } 
        }
        
        // Jika tidak ada id, maka batalkan transaksi
        if (idTrans == 0) {
            throw new SQLException("Menyimpan transaksi gagal, Id transaksi tidak tersedia!");
        }
        
        // Query untuk menambah ke detail pembelian
        String insert2 = "INSERT INTO detail_pembelian (id_beli, kd_produk, jumlah_beli) VALUES (?, ?, ?)";
        stmt2 = conn.prepareStatement(insert2);
        stmt2.setInt(1, idTrans);
        stmt2.setString(2, idProduk);
        stmt2.setInt(3, Integer.parseInt(jumlah));
        
        int result = stmt2.executeUpdate();
       
        conn.commit();
        
        if (result > 0) {
            JOptionPane.showMessageDialog(this, "Transaksi berhasil ditambahkan.", "Sukses", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Gagal menambahkan transaksi. Coba lagi.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        LoadData(); // Refresh data table
        
    } catch (Exception e) {
        // Jika ada kesalahan, rollback transaksi
        if (conn != null) {
            try {
                System.out.println("Terjadi kesalahan, transaksi dibatalkan!");
                conn.rollback();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    } finally {
        // Tutup koneksi
        try {
            if (stmt2 != null) stmt2.close();
            if (stmt1 != null) stmt1.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
     private String getIdFromComboBox(javax.swing.JComboBox<String> comboBox){
        String selectedItem = (String) comboBox.getSelectedItem();
        System.out.println("Selected item dari comboBox: " + selectedItem);

        if (selectedItem != null && selectedItem.contains(" - ")) {
            String[] parts = selectedItem.split(" - ", 2);
            return parts[0];
        }

        System.out.println("ID tidak valid / tidak ditemukan");
        return "";
    }

    private int getIdFromComboBoxSupp(javax.swing.JComboBox<String> comboBox){
        String selectedItem = (String) comboBox.getSelectedItem();
        if (selectedItem != null && selectedItem.contains(" - ")) {
            String[] parts = selectedItem.split(" - ", 2);
            return Integer.parseInt(parts[0]);
        }
        return 0;
    }
    
    
    private void loadProduct() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/dinda_salon";
        String user = "root";
        String pw = "";
        String query = "SELECT kd_produk, nama_produk FROM produk";

        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        model.addElement("0 - Pilih Produk");

        try (Connection conn = DriverManager.getConnection(url, user, pw);
             java.sql.Statement stmt = conn.createStatement();
             java.sql.ResultSet rs = stmt.executeQuery(query)) {

            while(rs.next()) {
                String id = rs.getString("kd_produk");
                String nama = rs.getString("nama_produk");
                model.addElement(id + " - " + nama);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, 
                "Gagal memuat data supplier:\n" + e.getMessage(), 
                "Database Error", 
                JOptionPane.ERROR_MESSAGE);
            throw e;
        }

        cmbx_produk.setModel(model);
    }

    // 2. loadHarga sekarang terima ID langsung
    private void loadHarga(String idProduk) {
        String url = "jdbc:mysql://localhost:3306/dinda_salon";
        String user = "root";
        String pw = "";
        String query = "SELECT harga_produk FROM produk WHERE kd_produk = ?";
        try (Connection conn = DriverManager.getConnection(url, user, pw);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, idProduk);
            try (ResultSet rs = pstmt.executeQuery()) {
                txt_harga.setText(rs.next() 
                    ? String.valueOf(rs.getInt("harga_produk")) 
                    : "0"
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            txt_harga.setText("0");
        }
    }
    
   
    //proses hitung total transaksi
    private void hitung_Total(){
        try {
            
            int jumlah = txt_jumlah.getText().isEmpty() ? 0 : Integer.parseInt(txt_jumlah.getText());
            int harga = txt_harga.getText().isEmpty() ? 0 : Integer.parseInt(txt_harga.getText());
            
            //hitung total
            int total = jumlah * harga;
            txttotalbeli.setText(String.valueOf(total));
        } catch (Exception e) {
            txttotalbeli.setText("0");
        }
    }
    private void loadSupplier() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/dinda_salon";
        String user = "root";
        String pw = "";
        String query = "SELECT id_supplier, nama_supplier FROM supplier ORDER BY nama_supplier";

        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        model.addElement("0 - Pilih Jenis");

        try (Connection conn = DriverManager.getConnection(url, user, pw);
             java.sql.Statement stmt = conn.createStatement();
             java.sql.ResultSet rs = stmt.executeQuery(query)) {

            while(rs.next()) {
                int id = rs.getInt("id_supplier");
                String nama = rs.getString("nama_supplier");
                model.addElement(id + " - " + nama);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, 
                "Gagal memuat data supplier:\n" + e.getMessage(), 
                "Database Error", 
                JOptionPane.ERROR_MESSAGE);
            throw e;
        }

        cmbx_supplier.setModel(model);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.setProperty("sun.java2d.uiScale", "1");
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PembelianAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PembelianAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PembelianAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PembelianAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new PembelianAdmin().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(PembelianAdmin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnback;
    private javax.swing.JButton btnlaporan;
    private javax.swing.JButton btnmembership;
    private javax.swing.JButton btnpegawai;
    private javax.swing.JButton btnproduk;
    private javax.swing.JButton btnsave;
    private javax.swing.JButton btnsupplier;
    private javax.swing.JButton btntreatment;
    private javax.swing.JComboBox<String> cmbx_produk;
    private javax.swing.JComboBox<String> cmbx_supplier;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_pembelian;
    private javax.swing.JTextField txt_harga;
    private javax.swing.JTextField txt_jumlah;
    private javax.swing.JTextField txttotalbeli;
    // End of variables declaration//GEN-END:variables
}
