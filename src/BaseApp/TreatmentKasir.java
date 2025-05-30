package BaseApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TreatmentKasir extends javax.swing.JFrame {

    public TreatmentKasir() {
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
        
        
        
        tb_treatment.setRowHeight(27);
        loadDataToTable();
    }

    
    
    private void loadDataToTable() {
    DefaultTableModel model = (DefaultTableModel) tb_treatment.getModel();
    model.setRowCount(0); // Bersihkan tabel dulu
    
    String sql =
      "SELECT k.keterangan AS kategori, l.nama_layanan AS nama, l.harga_layanan AS harga " +
      "FROM layanan l " +
      "JOIN kategori_layanan k ON l.id_kategori = k.id_kategori";
    
    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dinda_salon", "root", "")) {
        Statement stmt = con.createStatement();
        ResultSet rs = con.createStatement().executeQuery("SELECT * FROM layanan");

        while (rs.next()) {
            String kategori_tr = rs.getString("id_kategori");       // Ambil kategori
            String nama = rs.getString("nama_layanan");     // Ambil nama treatment
            int harga = rs.getInt("harga_layanan");                   // Ambil harga treatment
            model.addRow(new Object[]{
                kategori_tr, nama, harga
            });
        }

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this,"Gagal load data treatment:\n" + ex.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btntransaksi = new javax.swing.JButton();
        btnproduk = new javax.swing.JButton();
        btnpembelian = new javax.swing.JButton();
        btnmembership = new javax.swing.JButton();
        btnback = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_treatment = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btntransaksi.setContentAreaFilled(false);
        btntransaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btntransaksi.png"))); // NOI18N
        btntransaksi.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bgtransaksi.png"))); // NOI18N
        btntransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntransaksiActionPerformed(evt);
            }
        });
        jPanel1.add(btntransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 90, 90));
        btntransaksi.setBorderPainted(false);

        btnproduk.setContentAreaFilled(false);
        btnproduk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btnproduk.png"))); // NOI18N
        btnproduk.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bgproduk.png"))); // NOI18N
        btnproduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprodukActionPerformed(evt);
            }
        });
        jPanel1.add(btnproduk, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 90, 90));
        btnproduk.setBorderPainted(false);

        btnpembelian.setContentAreaFilled(false);
        btnpembelian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btnpembelian.png"))); // NOI18N
        btnpembelian.setToolTipText("");
        btnpembelian.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bgpembelian.png"))); // NOI18N
        btnpembelian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpembelianActionPerformed(evt);
            }
        });
        jPanel1.add(btnpembelian, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 90, 90));
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

        btnback.setContentAreaFilled(false);
        btnback.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/back.png"))); // NOI18N
        btnback.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/back1.png"))); // NOI18N
        btnback.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnbackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnbackMouseExited(evt);
            }
        });
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });
        jPanel1.add(btnback, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 880, 90, 80));
        btnback.setBorderPainted(false);

        tb_treatment.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        tb_treatment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Kategori", "Nama Treatment", "Harga Treatment"
            }
        ));
        jScrollPane1.setViewportView(tb_treatment);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 1080, 590));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Frame/TreatmentKasir.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 970));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btntransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntransaksiActionPerformed
        // TODO add your handling code here:
        new TransaksiKasir().setVisible(true);
        dispose();
    }//GEN-LAST:event_btntransaksiActionPerformed

    private void btnprodukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprodukActionPerformed
        // TODO add your handling code here:
        new ProdukKasir().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnprodukActionPerformed

    private void btnpembelianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpembelianActionPerformed
        // TODO add your handling code here:
        new PembelianKasir().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnpembelianActionPerformed

    private void btnmembershipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmembershipActionPerformed
        // TODO add your handling code here:
        new MemberKasir().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnmembershipActionPerformed

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        // TODO add your handling code here:
        new DashboardKasir().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnbackActionPerformed

    private void btnbackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbackMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnbackMouseEntered

    private void btnbackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbackMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnbackMouseExited

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
            java.util.logging.Logger.getLogger(TreatmentKasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TreatmentKasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TreatmentKasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TreatmentKasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TreatmentKasir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnback;
    private javax.swing.JButton btnmembership;
    private javax.swing.JButton btnpembelian;
    private javax.swing.JButton btnproduk;
    private javax.swing.JButton btntransaksi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_treatment;
    // End of variables declaration//GEN-END:variables
}
