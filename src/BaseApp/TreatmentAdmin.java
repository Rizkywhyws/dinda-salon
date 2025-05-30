package BaseApp;

import java.awt.Color;
import java.awt.Component;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;


public class TreatmentAdmin extends javax.swing.JFrame {

    public TreatmentAdmin() {
        setUndecorated(true);
        initComponents();
        kategori.setOpaque(false);
        kategori.setBackground(new Color(0, 0, 0, 0));
        kategori.setForeground(Color.WHITE);
        kategori.setBorder(null);
        //buat dropdown transparan
        kategori.setRenderer(new DefaultListCellRenderer() {
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
        
        try {
        loadKategori();
        } catch (Exception e) {
        e.printStackTrace();
        }

    // Pasang model dengan 3 kolom: Kategori, Nama, Harga
    DefaultTableModel model = new DefaultTableModel(
        new Object[][] {},
        new String[] { "Kategori", "Nama", "Harga" }
    ) {
        Class<?>[] types = new Class[] { String.class, String.class, Integer.class };
        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return types[columnIndex];
        }
    };
    tbl_treatment.setModel(model);
    tbl_treatment.setRowHeight(25);
    loadDataToTable();
    DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
    leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
    tbl_treatment.getColumnModel().getColumn(1).setCellRenderer(leftRenderer);
    tbl_treatment.getColumnModel().getColumn(2).setCellRenderer(leftRenderer);

    tbl_treatment.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent e) {
            int row = tbl_treatment.getSelectedRow();
            if (row != -1) {
                // NOTE: getModel().getValueAt merujuk ke kolom model, bukan view
                String kategoriTr = (String) tbl_treatment.getModel().getValueAt(row, 0);
                String nama       = (String) tbl_treatment.getModel().getValueAt(row, 1);
                Integer harga     = (Integer) tbl_treatment.getModel().getValueAt(row, 2);
                
                // Loop semua item di combobox
                for (int i = 0; i < kategori.getItemCount(); i++) {
                String item = kategori.getItemAt(i).toString();
                if (item.startsWith(kategoriTr + " -")) {
                kategori.setSelectedIndex(i);
                break;
            }
        }
                txt_namatreatment.setText(nama);
                txt_hargatreatment.setText(harga.toString());
                
            }
        }
    });

        int colCount = tbl_treatment.getColumnModel().getColumnCount();
        for (int i = colCount - 1; i >= 0; i--) {
    }
        }
    
    
    private void loadDataToTable() {
    DefaultTableModel model = (DefaultTableModel) tbl_treatment.getModel();
    model.setRowCount(0); // Bersihkan tabel dulu
    
    String sql =
      "SELECT k.keterangan AS kategori, l.nama_layanan AS nama, l.harga_layanan AS harga " +
      "FROM layanan l " +
      "JOIN kategori_layanan k ON l.id_kategori = k.id_kategori";
    
    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dinda_salon", "root", "")) {
        Statement stmt = con.createStatement();
        ResultSet rs = con.createStatement().executeQuery("SELECT * FROM layanan");

        while (rs.next()) {
            String kategori_tr = rs.getString("id_kategori");       
            String nama = rs.getString("nama_layanan");     
            int harga = rs.getInt("harga_layanan");                 
            model.addRow(new Object[]{
                kategori_tr, nama, harga
            });
        }

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this,
            "Gagal load data treatment:\n" + ex.getMessage(),
            "Error", JOptionPane.ERROR_MESSAGE);
    }
}
     private void clearForm() {
    kategori.setSelectedIndex(-1);
    txt_namatreatment.setText("");
    txt_hargatreatment.setText("");
    tbl_treatment.clearSelection();
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify thiohhs code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnproduk = new javax.swing.JButton();
        btnsupplieradmin = new javax.swing.JButton();
        btnpembelianadmin = new javax.swing.JButton();
        btnmembershipadmin = new javax.swing.JButton();
        btnlaporanadmin = new javax.swing.JButton();
        btnpegawaiadmin = new javax.swing.JButton();
        btnback = new javax.swing.JButton();
        btnedit = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        btnsimpan = new javax.swing.JButton();
        txt_namatreatment = new javax.swing.JTextField();
        txt_hargatreatment = new javax.swing.JTextField();
        kategori = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_treatment = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnproduk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btnproduk.png"))); // NOI18N
        btnproduk.setContentAreaFilled(false);
        btnproduk.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bgproduk.png"))); // NOI18N
        btnproduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprodukActionPerformed(evt);
            }
        });
        jPanel1.add(btnproduk, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, 90));
        btnproduk.setBorderPainted(false);

        btnsupplieradmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btnsupplier.png"))); // NOI18N
        btnsupplieradmin.setContentAreaFilled(false);
        btnsupplieradmin.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bgsupplier.png"))); // NOI18N
        btnsupplieradmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsupplieradminActionPerformed(evt);
            }
        });
        jPanel1.add(btnsupplieradmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 100, 90));
        btnsupplieradmin.setBorderPainted(false);

        btnpembelianadmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btnpembelian.png"))); // NOI18N
        btnpembelianadmin.setContentAreaFilled(false);
        btnpembelianadmin.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bgpembelian.png"))); // NOI18N
        btnpembelianadmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpembelianadminActionPerformed(evt);
            }
        });
        jPanel1.add(btnpembelianadmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 100, -1));
        btnpembelianadmin.setBorderPainted(false);

        btnmembershipadmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btnmembership.png"))); // NOI18N
        btnmembershipadmin.setContentAreaFilled(false);
        btnmembershipadmin.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bgmembership.png"))); // NOI18N
        btnmembershipadmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmembershipadminActionPerformed(evt);
            }
        });
        jPanel1.add(btnmembershipadmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 285, 100, -1));
        btnmembershipadmin.setContentAreaFilled(false);

        btnlaporanadmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btnlaporan.png"))); // NOI18N
        btnlaporanadmin.setContentAreaFilled(false);
        btnlaporanadmin.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bglaporan.png"))); // NOI18N
        btnlaporanadmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlaporanadminActionPerformed(evt);
            }
        });
        jPanel1.add(btnlaporanadmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 100, 90));
        btnlaporanadmin.setContentAreaFilled(false);

        btnpegawaiadmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btnpegawai.png"))); // NOI18N
        btnpegawaiadmin.setContentAreaFilled(false);
        btnpegawaiadmin.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bgpegawai.png"))); // NOI18N
        btnpegawaiadmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpegawaiadminActionPerformed(evt);
            }
        });
        jPanel1.add(btnpegawaiadmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 100, 90));
        btnpegawaiadmin.setContentAreaFilled(false);

        btnback.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/back.png"))); // NOI18N
        btnback.setContentAreaFilled(false);
        btnback.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/back1.png"))); // NOI18N
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });
        jPanel1.add(btnback, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 880, 100, -1));
        btnback.setBorderPainted(false);

        btnedit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btnedit.png"))); // NOI18N
        btnedit.setContentAreaFilled(false);
        btnedit.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bgedit.png"))); // NOI18N
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });
        jPanel1.add(btnedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 890, -1, -1));
        btnedit.setBorderPainted(false);

        btnhapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btndelete.png"))); // NOI18N
        btnhapus.setContentAreaFilled(false);
        btnhapus.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bgdelete.png"))); // NOI18N
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });
        jPanel1.add(btnhapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 890, -1, -1));
        btnhapus.setBorderPainted(false);

        btnsimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btnsave.png"))); // NOI18N
        btnsimpan.setContentAreaFilled(false);
        btnsimpan.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bgsave.png"))); // NOI18N
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });
        jPanel1.add(btnsimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 890, -1, -1));
        btnsimpan.setBorderPainted(false);

        txt_namatreatment.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        txt_namatreatment.setBorder(null);
        jPanel1.add(txt_namatreatment, new org.netbeans.lib.awtextra.AbsoluteConstraints(912, 402, 390, 30));

        txt_hargatreatment.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        txt_hargatreatment.setBorder(null);
        jPanel1.add(txt_hargatreatment, new org.netbeans.lib.awtextra.AbsoluteConstraints(912, 496, 390, 30));

        kategori.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        kategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Kategori---", "Perawatan Wajah", "Perawatan Rambut", "Make Up" }));
        kategori.setBorder(null);
        kategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kategoriActionPerformed(evt);
            }
        });
        jPanel1.add(kategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 309, 390, 30));

        tbl_treatment.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        tbl_treatment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Kategori", "Nama Treatment", "Harga Treatment"
            }
        ));
        jScrollPane2.setViewportView(tbl_treatment);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 670, 540));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Frame/treatment.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 980));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnprodukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprodukActionPerformed
       new ProdukAdmin().setVisible(true);
       dispose();
    }//GEN-LAST:event_btnprodukActionPerformed

    private void btnsupplieradminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsupplieradminActionPerformed
       new SupplierAdmin().setVisible(true);
       dispose();
    }//GEN-LAST:event_btnsupplieradminActionPerformed

    private void btnpembelianadminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpembelianadminActionPerformed
        try {
            // TODO add your handling code here:
            new PembelianAdmin().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(TreatmentAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
       dispose();
    }//GEN-LAST:event_btnpembelianadminActionPerformed

    private void btnpegawaiadminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpegawaiadminActionPerformed
       
    }//GEN-LAST:event_btnpegawaiadminActionPerformed

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
      new DashboardAdmin().setVisible(true);
      dispose();
    }//GEN-LAST:event_btnbackActionPerformed

    private void kategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kategoriActionPerformed
        // TODO add your handling code here:
        
        try {  
    String selected = (String) kategori.getSelectedItem();  

    if (selected == null || selected.equals("---Kategori---")) {  
        System.out.println("Silakan pilih kategori yang benar.");  
        return;  
    }  

    String[] parts = selected.split(" - ", 2);  

    if (parts.length < 2) {  
        JOptionPane.showMessageDialog(  this,"Format kategori tidak valid:\n" + selected,  "Error",  JOptionPane.ERROR_MESSAGE  );  
        return;  
    }  

    String id   = parts[0].trim();  
    String nama = parts[1].trim();  

    System.out.println("ID kategori: " + id);  
    System.out.println("Nama kategori: " + nama);  
} catch (Exception e) {  
    e.printStackTrace();  
}
    }//GEN-LAST:event_kategoriActionPerformed

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
        // TODO add your handling code here:
        
         String username = SessionLogin.getUsername();
    if (username == null || username.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Username tidak ditemukan. Silakan login kembali!");
        return;
    }
        // 1) Ambil dan validasi pilihan kategori
    String selected = (String) kategori.getSelectedItem();
    if (selected == null || selected.startsWith("---")) {
        JOptionPane.showMessageDialog(this,"Silakan pilih kategori layanan!","Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    }
    
   
    String[] parts = selected.split(" - ", 2);
    int idKategori = Integer.parseInt(parts[0].trim());

    String nama   = txt_namatreatment.getText().trim();
    String harga  = txt_hargatreatment.getText().trim();

    if (nama.isEmpty() || harga.isEmpty()) {
        JOptionPane.showMessageDialog(this,"Harap isi nama dan harga treatment!","Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    }
  

    int hargaInt;
    try {
        hargaInt = Integer.parseInt(harga);
    } catch (NumberFormatException ex) {JOptionPane.showMessageDialog(this, "Harga treatment harus berupa angka!","Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // 3) Siapkan koneksi dan statement
    String url  = "jdbc:mysql://localhost:3306/dinda_salon";
    String user = "root";
    String pw   = "";
    String sql  = "INSERT INTO layanan (id_kategori, nama_layanan, harga_layanan) "
                + "VALUES (?, ?, ?)";

    try (Connection con = DriverManager.getConnection(url, user, pw);
         PreparedStatement pst = con.prepareStatement(sql)) {

        pst.setInt   (1, idKategori);
        pst.setString(2, nama);
        pst.setInt   (3, hargaInt);

        int rows = pst.executeUpdate();
        if (rows > 0) {JOptionPane.showMessageDialog(this,"Treatment berhasil disimpan!","Sukses", JOptionPane.INFORMATION_MESSAGE);

            loadDataToTable();

            kategori.setSelectedIndex(0);  // reset ComboBox ke "---Kategori---"
            txt_namatreatment.setText("");
            txt_hargatreatment.setText("");
        } else{ JOptionPane.showMessageDialog(this,"Gagal menyimpan treatment!", "Error", JOptionPane.ERROR_MESSAGE);
    }

    } catch (SQLException ex) { ex.printStackTrace();
      JOptionPane.showMessageDialog(this,"Error saat menyimpan treatment:\n" + ex.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        // TODO add your handling code here:
    String kategori_tr = (String) kategori.getSelectedItem();
    String nama = txt_namatreatment.getText().trim();
    String hs   = txt_hargatreatment.getText().trim();

    if (kategori_tr.isEmpty()||nama.isEmpty()||hs.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Harap pilih data dan isi semua kolom!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    String username = SessionLogin.getUsername();
    if (username == null || username.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Username tidak ditemukan. Silakan login kembali!");
        return;
    }

    int harga;
    try { harga = Integer.parseInt(hs); }
    catch (NumberFormatException ex) {JOptionPane.showMessageDialog(this, "Harga harus angka!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

     String sql = """
                    UPDATE layanan l
                    JOIN kategori_layanan p ON l.id_kategori = p.id_kategori
                    SET l.nama_layanan = ?,
                        l.harga_layanan = ?
                    WHERE l.id_kategori = ?
                  """;
     
    try ( Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dinda_salon","root","");
        PreparedStatement pst = con.prepareStatement(sql)) {
        pst.setString(1, nama);
        pst.setInt   (2, harga);
        pst.setString(3, kategori_tr);

        if (pst.executeUpdate() > 0) {JOptionPane.showMessageDialog(this, "Data berhasil diubah!", "Sukses",
            JOptionPane.INFORMATION_MESSAGE);
            loadDataToTable();
            clearForm();
        } else {JOptionPane.showMessageDialog(this,"Data tidak ditemukan!", "Info",
            JOptionPane.INFORMATION_MESSAGE);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this,"SQL Error:\n"+ex.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btneditActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        // TODO add your handling code here:
         String selected = (String) kategori.getSelectedItem();
    if (selected == null || selected.startsWith("---")) {
        JOptionPane.showMessageDialog(this, "Silakan pilih kategori layanan!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    }

    // Ekstrak ID kategori
    String[] parts = selected.split(" - ", 2);
    int idKategori = Integer.parseInt(parts[0].trim());

    String username = SessionLogin.getUsername();
    if (username == null || username.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Username tidak ditemukan. Silakan login kembali!");
        return;
    }
    
    // Validasi nama treatment
    String nama = txt_namatreatment.getText().trim();
    if (nama.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Harap pilih treatment yang akan dihapus!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    }

    // Konfirmasi penghapusan
    int konfirmasi = JOptionPane.showConfirmDialog(this, 
        "Apakah Anda yakin ingin menghapus treatment: " + nama + "?", 
        "Konfirmasi Hapus", 
        JOptionPane.YES_NO_OPTION);
    
    if (konfirmasi != JOptionPane.YES_OPTION) {
        return;
    }

    // Persiapan query SQL untuk menghapus
    String sql = "DELETE FROM layanan WHERE id_kategori = ? AND nama_layanan = ?";

    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dinda_salon", "root", "");
         PreparedStatement pst = con.prepareStatement(sql)) {
        
        pst.setInt(1, idKategori);
        pst.setString(2, nama);

        int rows = pst.executeUpdate();
        if (rows > 0) {
            JOptionPane.showMessageDialog(this, "Treatment berhasil dihapus!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            
            // Refresh tabel dan reset form
            loadDataToTable();
            clearForm();
        } else {
            JOptionPane.showMessageDialog(this, "Tidak ada treatment yang dihapus!", "Info", JOptionPane.INFORMATION_MESSAGE);
        }

    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error saat menghapus treatment:\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnhapusActionPerformed

    private void btnmembershipadminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmembershipadminActionPerformed
        // TODO add your handling code here:
        new MembershipAdmin().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnmembershipadminActionPerformed

    private void btnlaporanadminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlaporanadminActionPerformed
        // TODO add your handling code here:
        new Laporan1().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnlaporanadminActionPerformed

    private void loadKategori() throws java.sql.SQLException {
    String url = "jdbc:mysql://localhost:3306/dinda_salon";
    String user = "root";
    String pw = "";
    String query = "SELECT id_kategori, keterangan FROM kategori_layanan";

    try (Connection conn = DriverManager.getConnection(url, user, pw);
         java.sql.Statement stmt = conn.createStatement();
         java.sql.ResultSet rs = stmt.executeQuery(query)) 
    {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        model.addElement("---Kategori---");

        while (rs.next()) {
            String id = rs.getString("id_kategori");
            String nama = rs.getString("keterangan");
            model.addElement(id + " - " + nama);
        }

        kategori.setModel(model); // Ganti 'kategori' sesuai nama JComboBox-mu
    }
}
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
            java.util.logging.Logger.getLogger(TreatmentAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TreatmentAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TreatmentAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TreatmentAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TreatmentAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnback;
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnlaporanadmin;
    private javax.swing.JButton btnmembershipadmin;
    private javax.swing.JButton btnpegawaiadmin;
    private javax.swing.JButton btnpembelianadmin;
    private javax.swing.JButton btnproduk;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JButton btnsupplieradmin;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> kategori;
    private javax.swing.JTable tbl_treatment;
    private javax.swing.JTextField txt_hargatreatment;
    private javax.swing.JTextField txt_namatreatment;
    // End of variables declaration//GEN-END:variables
}
