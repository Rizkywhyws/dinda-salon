package BaseApp;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Statement;
import BaseApp.Data;
import java.awt.Color;
import java.awt.Component;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class SupplierAdmin extends javax.swing.JFrame {
        Connection conn;
        private DefaultTableModel model;
        int selectedRow = -1;

    public SupplierAdmin() {
        setUndecorated(true);
        initComponents();
        cmbx_negara.setOpaque(false);
        cmbx_negara.setBackground(new Color(0, 0, 0, 0));
        cmbx_negara.setForeground(Color.WHITE);
        cmbx_negara.setBorder(null);
        //buat dropdown transparan
        cmbx_negara.setRenderer(new DefaultListCellRenderer() {
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
        
        new NegaraAPI(cmbx_negara);
       

        model = (DefaultTableModel) tb_supplier.getModel();
        tampilData();

       tb_supplier.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selectedRow = tb_supplier.getSelectedRow();
                if (selectedRow != -1) {
                    DefaultTableModel model = (DefaultTableModel) tb_supplier.getModel();
                    txtsupplier.setText(String.valueOf(model.getValueAt(selectedRow, 0)));
                    txttelp.setText(String.valueOf(model.getValueAt(selectedRow, 1)));
                    
                }
            }
        });
        tb_supplier.setRowHeight(25);
    }
    
    
    private void tampilData() {
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("Nama Supplier");
    model.addColumn("No Telepon");

    try {
        Connection conn = Data.configDB();
        String sql = "SELECT * FROM supplier";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getString("nama_supplier"),
                rs.getString("notelp_supplier"),
            });
        }
        tb_supplier.setModel(model);
        tb_supplier.setRowHeight(27);
    } catch (SQLException e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Gagal menampilkan data: " + e.getMessage());
    }
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnedit = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        btnsave = new javax.swing.JButton();
        btntreatment = new javax.swing.JButton();
        btnproduk = new javax.swing.JButton();
        btnpembelian = new javax.swing.JButton();
        btnmembership = new javax.swing.JButton();
        btnlaporan = new javax.swing.JButton();
        btnpegawai = new javax.swing.JButton();
        btnback = new javax.swing.JButton();
        txtsupplier = new javax.swing.JTextField();
        txttelp = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_supplier = new javax.swing.JTable();
        cmbx_negara = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnedit.setContentAreaFilled(false);
        btnedit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btnedit.png"))); // NOI18N
        btnedit.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bgedit.png"))); // NOI18N
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });
        jPanel1.add(btnedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 900, 190, -1));
        btnedit.setBorderPainted(false);

        btndelete.setContentAreaFilled(false);
        btndelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btndelete.png"))); // NOI18N
        btndelete.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bgdelete.png"))); // NOI18N
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btndelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 900, 190, -1));
        btndelete.setBorderPainted(false);

        btnsave.setContentAreaFilled(false);
        btnsave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btnsave.png"))); // NOI18N
        btnsave.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bgsave.png"))); // NOI18N
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });
        jPanel1.add(btnsave, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 900, 370, -1));
        btnsave.setBorderPainted(false);

        btntreatment.setContentAreaFilled(false);
        btntreatment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btntreatment.png"))); // NOI18N
        btntreatment.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bgtreatment.png"))); // NOI18N
        btntreatment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntreatmentActionPerformed(evt);
            }
        });
        jPanel1.add(btntreatment, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 90, 90));
        btntreatment.setBorderPainted(false);

        btnproduk.setContentAreaFilled(false);
        btnproduk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btnproduk.png"))); // NOI18N
        btnproduk.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bgproduk.png"))); // NOI18N
        btnproduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprodukActionPerformed(evt);
            }
        });
        jPanel1.add(btnproduk, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 90, 90));
        btnproduk.setBorderPainted(false);

        btnpembelian.setContentAreaFilled(false);
        btnpembelian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btnpembelian.png"))); // NOI18N
        btnpembelian.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bgpembelian.png"))); // NOI18N
        btnpembelian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpembelianActionPerformed(evt);
            }
        });
        jPanel1.add(btnpembelian, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 90, 90));
        btnpembelian.setBorderPainted(false);

        btnmembership.setContentAreaFilled(false);
        btnmembership.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btnmembership.png"))); // NOI18N
        btnmembership.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bgmembership.png"))); // NOI18N
        btnmembership.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmembershipActionPerformed(evt);
            }
        });
        jPanel1.add(btnmembership, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 90, 90));
        btnmembership.setBorderPainted(false);

        btnlaporan.setContentAreaFilled(false);
        btnlaporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btnlaporan.png"))); // NOI18N
        btnlaporan.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bglaporan.png"))); // NOI18N
        btnlaporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlaporanActionPerformed(evt);
            }
        });
        jPanel1.add(btnlaporan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 90, 90));
        btnlaporan.setBorderPainted(false);

        btnpegawai.setContentAreaFilled(false);
        btnpegawai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btnpegawai.png"))); // NOI18N
        btnpegawai.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bgpegawai.png"))); // NOI18N
        btnpegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpegawaiActionPerformed(evt);
            }
        });
        jPanel1.add(btnpegawai, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 90, 90));
        btnpegawai.setBorderPainted(false);

        btnback.setContentAreaFilled(false);
        btnback.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/back.png"))); // NOI18N
        btnback.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/back1.png"))); // NOI18N
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });
        jPanel1.add(btnback, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 880, 90, -1));
        btnback.setBorderPainted(false);

        txtsupplier.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        txtsupplier.setBorder(null);
        jPanel1.add(txtsupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 313, 390, 20));

        txttelp.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        txttelp.setBorder(null);
        txttelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelpActionPerformed(evt);
            }
        });
        jPanel1.add(txttelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 413, 130, 20));

        tb_supplier.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        tb_supplier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nama Supplier", "No Telepon"
            }
        ));
        tb_supplier.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(tb_supplier);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 670, 550));

        cmbx_negara.setFont(new java.awt.Font("Dubai Medium", 0, 13)); // NOI18N
        jPanel1.add(cmbx_negara, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 408, 250, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Frame/Supplier.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 980));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btntreatmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntreatmentActionPerformed
        // TODO add your handling code here:
        new TreatmentAdmin().setVisible(true);
        dispose();
    }//GEN-LAST:event_btntreatmentActionPerformed

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        // TODO add your handling code here:
              String username = SessionLogin.getUsername();
    if (username == null || username.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Username tidak ditemukan. Silakan login kembali!");
        return;
    }
        if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Pilih data yang ingin diubah");
        return;
    }

        String namaBaru = txtsupplier.getText();
        String telpBaru = txttelp.getText();
        String namaLama = tb_supplier.getValueAt(selectedRow, 0).toString();

    try {
        conn = Data.configDB(); 
        String sql = "UPDATE supplier SET nama_supplier=?, notelp_supplier=? WHERE nama_supplier=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, namaBaru);
        pst.setString(2, telpBaru);
        pst.setString(3, namaLama);
        pst.executeUpdate();
        JOptionPane.showMessageDialog(this, "Data berhasil diperbarui");
        tampilData();
        txtsupplier.setText("");
        txttelp.setText("");
        selectedRow = -1;
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Gagal mengedit data: " + e.getMessage());
    }
    }//GEN-LAST:event_btneditActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        // TODO add your handling code here:
        
              String username = SessionLogin.getUsername();
    if (username == null || username.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Username tidak ditemukan. Silakan login kembali!");
        return;
    }
        if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Pilih data yang ingin dihapus");
        return;
    }
        

    int confirm = JOptionPane.showConfirmDialog(this, "Yakin ingin menghapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        String nama = tb_supplier.getValueAt(selectedRow, 0).toString();
        try {
            conn = Data.configDB(); 
            String sql = "DELETE FROM supplier WHERE nama_supplier=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, nama);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data berhasil dihapus");
            tampilData();
            txtsupplier.setText("");
            txttelp.setText("");
            selectedRow = -1;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal menghapus data: " + e.getMessage());
        }
    }
    }//GEN-LAST:event_btndeleteActionPerformed

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        // TODO add your handling code here:
        String nama = txtsupplier.getText();
        String telp = txttelp.getText();
        
        String username = SessionLogin.getUsername();
    if (username == null || username.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Username tidak ditemukan. Silakan login kembali!");
        return;
    }

        if (nama.isEmpty() || telp.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Data tidak boleh kosong");
            return;
        }

        try {
            conn = Data.configDB(); 
            String sql = "INSERT INTO supplier(nama_supplier, notelp_supplier) VALUES (?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, nama);
            pst.setString(2, telp);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data berhasil disimpan");
            tampilData();
            txtsupplier.setText("");
            txttelp.setText(""); 
            tb_supplier.clearSelection(); 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal menyimpan data: " + e.getMessage());
        }
    }//GEN-LAST:event_btnsaveActionPerformed

    private void btnprodukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprodukActionPerformed
        // TODO add your handling code here:
        new ProdukAdmin().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnprodukActionPerformed

    private void btnpembelianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpembelianActionPerformed
            try {
                // TODO add your handling code here:
                new PembelianAdmin().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(SupplierAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        dispose();
    }//GEN-LAST:event_btnpembelianActionPerformed

    private void btnmembershipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmembershipActionPerformed
        // TODO add your handling code here:
        new MembershipAdmin().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnmembershipActionPerformed

    private void btnlaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlaporanActionPerformed
        // TODO add your handling code here:
        new Laporan1().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnlaporanActionPerformed

    private void btnpegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpegawaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnpegawaiActionPerformed

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        // TODO add your handling code here:
       new DashboardAdmin().setVisible(true);
       dispose();
    }//GEN-LAST:event_btnbackActionPerformed

    private void txttelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttelpActionPerformed

    public static void main(String args[]) {
        System.setProperty("sun.java2d.uiScale", "1");
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
            java.util.logging.Logger.getLogger(SupplierAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SupplierAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SupplierAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SupplierAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SupplierAdmin().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnback;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btnlaporan;
    private javax.swing.JButton btnmembership;
    private javax.swing.JButton btnpegawai;
    private javax.swing.JButton btnpembelian;
    private javax.swing.JButton btnproduk;
    private javax.swing.JButton btnsave;
    private javax.swing.JButton btntreatment;
    private javax.swing.JComboBox<String> cmbx_negara;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_supplier;
    private javax.swing.JTextField txtsupplier;
    private javax.swing.JTextField txttelp;
    // End of variables declaration//GEN-END:variables
}
