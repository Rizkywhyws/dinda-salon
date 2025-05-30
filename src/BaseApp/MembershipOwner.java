package BaseApp;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import java.awt.Dimension;
import java.awt.FlowLayout;
public class MembershipOwner extends javax.swing.JFrame {
    

    public MembershipOwner() {
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
       
        
        tb_member.setRowHeight(27);
        tb_member.getColumnModel().getColumn(0).setPreferredWidth(90); 
        tb_member.getColumnModel().getColumn(1).setPreferredWidth(165); 
        tb_member.getColumnModel().getColumn(2).setPreferredWidth(100); 
        tb_member.getColumnModel().getColumn(3).setPreferredWidth(170);  
        tb_member.getColumnModel().getColumn(4).setPreferredWidth(220);
        tampilData();

        }
  private void tampilData() {
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("ID Member");
    model.addColumn("Nama");
    model.addColumn("Jenis Kelamin");
    model.addColumn("No Telepon");
    model.addColumn("Alamat");
    model.addColumn("Poin");

    try {
        Connection conn = Data.configDB();
        String sql = "SELECT * FROM member";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getString("id_member"),
                rs.getString("nama_member"),
                rs.getString("jenis_kelamin"),
                rs.getString("notelp_member"),
                rs.getString("alamat_member"),
                rs.getInt("poin_member")
            });
        }
        tb_member.setModel(model);
        tb_member.setRowHeight(25);
        tb_member.getColumnModel().getColumn(0).setPreferredWidth(100); 
        tb_member.getColumnModel().getColumn(1).setPreferredWidth(250); 
        tb_member.getColumnModel().getColumn(2).setPreferredWidth(100); 
        tb_member.getColumnModel().getColumn(3).setPreferredWidth(80);  
        tb_member.getColumnModel().getColumn(4).setPreferredWidth(200);
    } catch (SQLException e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Gagal menampilkan data: " + e.getMessage());
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnmembership = new javax.swing.JButton();
        btnlaporan = new javax.swing.JButton();
        btnpegawai = new javax.swing.JButton();
        btnback = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_member = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnmembership.setContentAreaFilled(false);
        btnmembership.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btnmembership.png"))); // NOI18N
        btnmembership.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bgmembership.png"))); // NOI18N
        btnmembership.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmembershipActionPerformed(evt);
            }
        });
        jPanel1.add(btnmembership, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 90, 90));
        btnmembership.setBorderPainted(false);

        btnlaporan.setContentAreaFilled(false);
        btnlaporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btnlaporan.png"))); // NOI18N
        btnlaporan.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bglaporan.png"))); // NOI18N
        btnlaporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlaporanActionPerformed(evt);
            }
        });
        jPanel1.add(btnlaporan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 90, 90));
        btnlaporan.setBorderPainted(false);

        btnpegawai.setContentAreaFilled(false);
        btnpegawai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btnpegawai.png"))); // NOI18N
        btnpegawai.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bgpegawai.png"))); // NOI18N
        btnpegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpegawaiActionPerformed(evt);
            }
        });
        jPanel1.add(btnpegawai, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 90, 90));
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

        tb_member.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        tb_member.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id Member", "Nama Member", "Jenis Kelamin", "No Telp", "Alamat", "Poin"
            }
        ));
        tb_member.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(tb_member);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 1110, 610));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Frame/MembershipOwner.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 980));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnmembershipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmembershipActionPerformed
        // TODO add your handling code here:
        MembershipAdmin n = new MembershipAdmin();
        n.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnmembershipActionPerformed

    private void btnlaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlaporanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnlaporanActionPerformed

    private void btnpegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpegawaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnpegawaiActionPerformed

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        // TODO add your handling code here:
        new DashboardOwner().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnbackActionPerformed

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
            java.util.logging.Logger.getLogger(MembershipOwner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MembershipOwner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MembershipOwner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MembershipOwner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MembershipOwner().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnback;
    private javax.swing.JButton btnlaporan;
    private javax.swing.JButton btnmembership;
    private javax.swing.JButton btnpegawai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_member;
    // End of variables declaration//GEN-END:variables
}
