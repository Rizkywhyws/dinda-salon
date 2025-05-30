package admin;

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
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;


public class treatment extends javax.swing.JFrame {

    public treatment() {
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
        
        try {
        loadKategori();
        } catch (Exception e) {
        e.printStackTrace();
        }
    
    // Buat combobox transparan
    kategori.setOpaque(false);
    kategori.setBackground(new Color(0, 0, 0, 0));
    kategori.setForeground(Color.WHITE);
    kategori.setBorder(null);
    //buat dropdown transparan
    kategori.setRenderer(new DefaultListCellRenderer() {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value,
                                                      int index, boolean isSelected, boolean cellHasFocus) {
            Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (c instanceof JComponent) {
                ((JComponent) c).setOpaque(false);
            }
            return c;
        }
    });

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

    // Isi data
    tbl_treatment.setRowHeight(25);
    loadDataToTable();

    // Sembunyikan kolom pertama (Kategori/ID)
    DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
    leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
    tbl_treatment.getColumnModel()
                 .getColumn(1)
                 .setCellRenderer(leftRenderer);

    // Pasang listener klik baris
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

                txt_nama.setText(nama);
                txt_harga.setText(harga.toString());
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
    
    try (Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/dinda_salon", "root", "")) {
        Statement stmt = con.createStatement();
        ResultSet rs = con.createStatement()
            .executeQuery("SELECT * FROM layanan");

        while (rs.next()) {
            String kategori_tr = rs.getString("id_kategori");       // Ambil kategori
            String nama = rs.getString("nama_layanan");     // Ambil nama treatment
            int harga = rs.getInt("harga_layanan");                   // Ambil harga treatment
            
            

            // Tambahkan ke tabel
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
    txt_nama.setText("");
    txt_harga.setText("");
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
        btntreatment = new javax.swing.JButton();
        btnproduk = new javax.swing.JButton();
        btnsupplier = new javax.swing.JButton();
        btnpembelian = new javax.swing.JButton();
        btnmembership = new javax.swing.JButton();
        btnlaporan = new javax.swing.JButton();
        btnback = new javax.swing.JButton();
        btnpegawai = new javax.swing.JButton();
        btnedit = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        btnsimpan = new javax.swing.JButton();
        txt_nama = new javax.swing.JTextField();
        txt_harga = new javax.swing.JTextField();
        kategori = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_treatment = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btntreatment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/button/btntreatment.png"))); // NOI18N
        btntreatment.setContentAreaFilled(false);
        btntreatment.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/button/bgtreatment.png"))); // NOI18N
        btntreatment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntreatmentActionPerformed(evt);
            }
        });
        jPanel1.add(btntreatment, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        btntreatment.setBorderPainted(false);

        btnproduk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/button/btnproduk.png"))); // NOI18N
        btnproduk.setContentAreaFilled(false);
        btnproduk.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/button/bgproduk.png"))); // NOI18N
        btnproduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprodukActionPerformed(evt);
            }
        });
        jPanel1.add(btnproduk, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));
        btnproduk.setBorderPainted(false);

        btnsupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/button/btnsupplier.png"))); // NOI18N
        btnsupplier.setContentAreaFilled(false);
        btnsupplier.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/button/bgsupplier.png"))); // NOI18N
        btnsupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsupplierActionPerformed(evt);
            }
        });
        jPanel1.add(btnsupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));
        btnsupplier.setBorderPainted(false);

        btnpembelian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/button/btnpembelian.png"))); // NOI18N
        btnpembelian.setContentAreaFilled(false);
        btnpembelian.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/button/bgpembelian.png"))); // NOI18N
        jPanel1.add(btnpembelian, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));
        btnpembelian.setContentAreaFilled(false);

        btnmembership.setIcon(new javax.swing.ImageIcon(getClass().getResource("/button/btnmembership.png"))); // NOI18N
        btnmembership.setContentAreaFilled(false);
        btnmembership.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/button/bgmembership.png"))); // NOI18N
        jPanel1.add(btnmembership, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, -1, -1));
        btnmembership.setContentAreaFilled(false);

        btnlaporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/button/btnlaporan.png"))); // NOI18N
        btnlaporan.setContentAreaFilled(false);
        btnlaporan.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/button/bglaporan.png"))); // NOI18N
        btnlaporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlaporanActionPerformed(evt);
            }
        });
        jPanel1.add(btnlaporan, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, -1, -1));
        btnlaporan.setContentAreaFilled(false);

        btnback.setIcon(new javax.swing.ImageIcon(getClass().getResource("/button/back.png"))); // NOI18N
        btnback.setContentAreaFilled(false);
        btnback.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/button/back1.png"))); // NOI18N
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });
        jPanel1.add(btnback, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 870, -1, -1));
        btnback.setBorderPainted(false);

        btnpegawai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/button/btnpegawai.png"))); // NOI18N
        btnpegawai.setContentAreaFilled(false);
        btnpegawai.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/button/bgpegawai.png"))); // NOI18N
        jPanel1.add(btnpegawai, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 550, -1, -1));
        btnpegawai.setBorderPainted(false);

        btnedit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/button/btnedit.png"))); // NOI18N
        btnedit.setContentAreaFilled(false);
        btnedit.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/button/bgedit.png"))); // NOI18N
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });
        jPanel1.add(btnedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 870, -1, -1));
        btnedit.setBorderPainted(false);

        btnhapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/button/btndelete.png"))); // NOI18N
        btnhapus.setContentAreaFilled(false);
        btnhapus.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/button/bgdelete.png"))); // NOI18N
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });
        jPanel1.add(btnhapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 870, -1, -1));
        btnhapus.setBorderPainted(false);

        btnsimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/button/btnsave.png"))); // NOI18N
        btnsimpan.setContentAreaFilled(false);
        btnsimpan.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/button/bgsave.png"))); // NOI18N
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });
        jPanel1.add(btnsimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 870, -1, -1));
        btnsimpan.setBorderPainted(false);

        txt_nama.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        txt_nama.setBorder(null);
        jPanel1.add(txt_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(912, 402, 390, 30));

        txt_harga.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        txt_harga.setBorder(null);
        jPanel1.add(txt_harga, new org.netbeans.lib.awtextra.AbsoluteConstraints(912, 496, 390, 30));

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

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 650, 540));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/treatment.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 980));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btntreatmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntreatmentActionPerformed
        new treatment().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btntreatmentActionPerformed

    private void btnprodukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprodukActionPerformed
        new produk().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnprodukActionPerformed

    private void btnsupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsupplierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnsupplierActionPerformed

    private void btnlaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlaporanActionPerformed
        new laporan1().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnlaporanActionPerformed

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        new dashboard().setVisible(true);
        this.dispose();
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
        JOptionPane.showMessageDialog(  
            this,  
            "Format kategori tidak valid:\n" + selected,  
            "Error",  
            JOptionPane.ERROR_MESSAGE  
        );  
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
        // 1) Ambil dan validasi pilihan kategori
    String selected = (String) kategori.getSelectedItem();
    if (selected == null || selected.startsWith("---")) {
        JOptionPane.showMessageDialog(this,
            "Silakan pilih kategori layanan!",
            "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    }
    // Split "id - keterangan" menjadi [id, keterangan]
    String[] parts = selected.split(" - ", 2);
    int idKategori = Integer.parseInt(parts[0].trim());

    // 2) Ambil dan validasi nama & harga treatment
    String nama   = txt_nama.getText().trim();
    String harga  = txt_harga.getText().trim();

    if (nama.isEmpty() || harga.isEmpty()) {
        JOptionPane.showMessageDialog(this,
            "Harap isi nama dan harga treatment!",
            "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    }

    int hargaInt;
    try {
        hargaInt = Integer.parseInt(harga);
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this,
            "Harga treatment harus berupa angka!",
            "Error", JOptionPane.ERROR_MESSAGE);
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
        if (rows > 0) {
            JOptionPane.showMessageDialog(this,
                "Treatment berhasil disimpan!",
                "Sukses", JOptionPane.INFORMATION_MESSAGE);

            // reload JTable
            loadDataToTable();

            // clear form
            kategori.setSelectedIndex(0);  // reset ComboBox ke "---Kategori---"
            txt_nama.setText("");
            txt_harga.setText("");
        } else {
            JOptionPane.showMessageDialog(this,
                "Gagal menyimpan treatment!",
                "Error", JOptionPane.ERROR_MESSAGE);
        }

    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this,
            "Error saat menyimpan treatment:\n" + ex.getMessage(),
            "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        // TODO add your handling code here:
    String kategori_tr = (String) kategori.getSelectedItem();
    String nama = txt_nama.getText().trim();
    String hs   = txt_harga.getText().trim();

    if (kategori_tr.isEmpty()||nama.isEmpty()||hs.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Harap pilih data dan isi semua kolom!", "Peringatan", JOptionPane.WARNING_MESSAGE);
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
     
    try ( Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/dinda_salon","root","");
          PreparedStatement pst = con.prepareStatement(sql)) {

        pst.setString(1, nama);
        pst.setInt   (2, harga);
        pst.setString(3, kategori_tr);

        if (pst.executeUpdate() > 0) {
            JOptionPane.showMessageDialog(this,
              "Data berhasil diubah!", "Sukses",
              JOptionPane.INFORMATION_MESSAGE);
            loadDataToTable();
            clearForm();
        } else {
            JOptionPane.showMessageDialog(this,
              "Data tidak ditemukan!", "Info",
              JOptionPane.INFORMATION_MESSAGE);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this,
          "SQL Error:\n"+ex.getMessage(),
          "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btneditActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        // TODO add your handling code here:
        String nama = txt_nama.getText().trim();

if (nama.isEmpty()) {
    JOptionPane.showMessageDialog(this,
        "Pilih data yang akan dihapus terlebih dahulu!",
        "Peringatan",
        JOptionPane.WARNING_MESSAGE);
    return;
}

try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dinda_salon", "root", "")) {

    // Langkah 1: Cari ID berdasarkan nama layanan
    String sqlSelect = "SELECT id_layanan FROM layanan WHERE nama_layanan = ?";
    try (PreparedStatement pstSelect = con.prepareStatement(sqlSelect)) {
        pstSelect.setString(1, nama);
        ResultSet rs = pstSelect.executeQuery();

        if (!rs.next()) {
            JOptionPane.showMessageDialog(this,
                "Data tidak ditemukan di database!",
                "Info",
                JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        int id = rs.getInt("id_layanan");

        // Konfirmasi penghapusan
        int konfirmasi = JOptionPane.showConfirmDialog(this,
            "Yakin ingin menghapus layanan dengan nama = " + nama + "?",
            "Konfirmasi",
            JOptionPane.YES_NO_OPTION);

        if (konfirmasi != JOptionPane.YES_OPTION) return;

        // Langkah 2: Hapus berdasarkan id_layanan
        String sqlDelete = "DELETE FROM layanan WHERE id_layanan = ?";
        try (PreparedStatement pstDelete = con.prepareStatement(sqlDelete)) {
            pstDelete.setInt(1, id);
            pstDelete.executeUpdate();
            JOptionPane.showMessageDialog(this,
                "Data berhasil dihapus!",
                "Sukses",
                JOptionPane.INFORMATION_MESSAGE);
            loadDataToTable();
            clearForm();
        }
    }

} catch (SQLException ex) {
    ex.printStackTrace();
    JOptionPane.showMessageDialog(this,
        "Terjadi kesalahan pada database:\n" + ex.getMessage(),
        "Error",
        JOptionPane.ERROR_MESSAGE);
}

    }//GEN-LAST:event_btnhapusActionPerformed

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
            java.util.logging.Logger.getLogger(treatment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(treatment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(treatment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(treatment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new treatment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnback;
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnlaporan;
    private javax.swing.JButton btnmembership;
    private javax.swing.JButton btnpegawai;
    private javax.swing.JButton btnpembelian;
    private javax.swing.JButton btnproduk;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JButton btnsupplier;
    private javax.swing.JButton btntreatment;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> kategori;
    private javax.swing.JTable tbl_treatment;
    private javax.swing.JTextField txt_harga;
    private javax.swing.JTextField txt_nama;
    // End of variables declaration//GEN-END:variables
}
