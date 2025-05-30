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
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.client.j2se.MatrixToImageWriter;
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
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
public class ProdukKasir extends javax.swing.JFrame {
    private final String OUTPUT_DIR = "D:/Barcode/";
    private BufferedImage generateBarcodeWithText(String data) throws Exception {
        BitMatrix matrix = new MultiFormatWriter().encode(data, BarcodeFormat.CODE_128, 300, 100);
        BufferedImage barcodeImage = MatrixToImageWriter.toBufferedImage(matrix);

        int width  = barcodeImage.getWidth();
        int height = barcodeImage.getHeight() + 30;
        BufferedImage combined = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics2D g = combined.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);
        g.drawImage(barcodeImage, 0, 0, null);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 18));
        FontMetrics fm = g.getFontMetrics();
        int textWidth = fm.stringWidth(data);
        int x = (width - textWidth) / 2;
        int y = barcodeImage.getHeight() + fm.getAscent() + 2; 
        g.drawString(data, x, y);

        g.dispose();
        return combined;
    }
    private JLabel lblBarcodePreview;

    public ProdukKasir() {
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
        

        tb_Produk.setModel(new DefaultTableModel(
       new Object[][] {},
       new String[]{ "Kode", "Nama", "Harga", "Stok", "Barcode", "Raw" }
     ) {
       Class<?>[] types = {
           String.class, String.class, Integer.class, String.class, ImageIcon.class, String.class};
       @Override public Class<?> getColumnClass(int col) { 
           return types[col]; }
     });
     // setelah setup kolom, sembunyikan kolom ke-5 (index 5):
     tb_Produk.removeColumn(tb_Produk.getColumnModel().getColumn(5));
        
     DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
    leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
    tb_Produk.getColumnModel().getColumn(1).setCellRenderer(leftRenderer); 
    tb_Produk.getColumnModel().getColumn(2).setCellRenderer(leftRenderer); 
    tb_Produk.getColumnModel().getColumn(3).setCellRenderer(leftRenderer); 
        tb_Produk.setRowHeight(27);
        tampilData();

        }
    private ImageIcon generateBarcodeImage(String data) {
    try {
        BitMatrix matrix = new MultiFormatWriter().encode(data, BarcodeFormat.CODE_128, 150, 50);
        BufferedImage image = MatrixToImageWriter.toBufferedImage(matrix);
        return new ImageIcon(image.getScaledInstance(150, 50, Image.SCALE_SMOOTH));
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
    
}
  private void tampilData() {
        DefaultTableModel model = (DefaultTableModel) tb_Produk.getModel();
        model.setRowCount(0);
        try ( Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dinda_salon", "root", "")) {
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM produk");
            while (rs.next()) {
                String kode = rs.getString("kd_produk");
                String nama = rs.getString("nama_produk");
                int harga   = rs.getInt   ("harga_produk");
                String stok = rs.getString("stok");
                String bc   = rs.getString("barcode");
                model.addRow(new Object[]{
                    kode, nama, harga, stok, generateBarcodeImage(bc), bc
                });
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Gagal load data:\n" + ex.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btntreatment = new javax.swing.JButton();
        btnpembelian = new javax.swing.JButton();
        btnmembership = new javax.swing.JButton();
        btntransaksi = new javax.swing.JButton();
        btnback = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_Produk = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        btntransaksi.setContentAreaFilled(false);
        btntransaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btntransaksi.png"))); // NOI18N
        btntransaksi.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bgtransaksi.png"))); // NOI18N
        btntransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntransaksiActionPerformed(evt);
            }
        });
        jPanel1.add(btntransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 90, 90));
        btntransaksi.setBorderPainted(false);

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

        tb_Produk.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        tb_Produk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Kode Produk", "Nama Produk", "Harga ", "Stok", "Barcode"
            }
        ));
        tb_Produk.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(tb_Produk);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 1110, 600));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Frame/ProdukKasir.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 980));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btntreatmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntreatmentActionPerformed
        // TODO add your handling code here:
        new TreatmentKasir().setVisible(true);
        dispose();
    }//GEN-LAST:event_btntreatmentActionPerformed

    private void btnpembelianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpembelianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnpembelianActionPerformed

    private void btnmembershipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmembershipActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnmembershipActionPerformed

    private void btntransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntransaksiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btntransaksiActionPerformed

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        // TODO add your handling code here:
        new DashboardKasir().setVisible(true);
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
            java.util.logging.Logger.getLogger(ProdukKasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProdukKasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProdukKasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProdukKasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProdukKasir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnback;
    private javax.swing.JButton btnmembership;
    private javax.swing.JButton btnpembelian;
    private javax.swing.JButton btntransaksi;
    private javax.swing.JButton btntreatment;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_Produk;
    // End of variables declaration//GEN-END:variables
}
