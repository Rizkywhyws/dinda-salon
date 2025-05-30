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
import javax.swing.table.DefaultTableModel;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ProdukAdmin extends javax.swing.JFrame {
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

    public ProdukAdmin() {
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
        
        loadDataToTable();
        
        lblBarcodePreview = new JLabel();
        lblBarcodePreview.setPreferredSize(new Dimension(300, 100));
        lblBarcodePreview.setBorder(BorderFactory.createTitledBorder("Preview Barcode"));

        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(lblBarcodePreview);

        tbl_produk.addMouseListener(new java.awt.event.MouseAdapter() {
    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        int row = tbl_produk.getSelectedRow();
        if (row != -1) {
            txt_kdproduk.setText(tbl_produk.getValueAt(row, 0).toString());
            txt_namaproduk.setText(tbl_produk.getValueAt(row, 1).toString());
            txt_hargaproduk.setText(tbl_produk.getValueAt(row, 2).toString());
            txt_stok.setText  (tbl_produk.getValueAt(row, 3).toString());
            txt_barcode.setText(""); 
            String raw = (String) tbl_produk.getModel().getValueAt(tbl_produk.convertRowIndexToModel(row),5); 
            txt_barcode.setText(raw);
            
        }
    }
});
        tbl_produk.setRowHeight(27);
         tbl_produk.setModel(new DefaultTableModel(
          new Object [][] {},
          new String [] { "Kode Produk", "Nama Produk", "Harga", "Stok", "Barcode" , "Raw"}
      ) {
          Class[] types = new Class [] {
              String.class, String.class, Integer.class, String.class, ImageIcon.class, String.class
          };
          @Override
          public Class<?> getColumnClass(int columnIndex) {
              return types[columnIndex];
          }
      });
         tbl_produk.removeColumn(tbl_produk.getColumnModel().getColumn(5));
          loadDataToTable();
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
    private void loadDataToTable() {
        DefaultTableModel model = (DefaultTableModel) tbl_produk.getModel();
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
                    kode, nama, harga, stok, generateBarcodeImage(bc),bc
                });
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Gagal load data:\n" + ex.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
        }
    }
  private void clearForm() {
    txt_kdproduk.setText("");
    txt_namaproduk.setText("");
    txt_hargaproduk.setText("");
    txt_stok.setText("");
    txt_barcode.setText("");
    tbl_produk.clearSelection();
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btntreatment = new javax.swing.JButton();
        btnsupplieradmin = new javax.swing.JButton();
        btnpembelianadmin = new javax.swing.JButton();
        btnmembershipadmin = new javax.swing.JButton();
        btnlaporanadmin = new javax.swing.JButton();
        btnpegawaiadmin = new javax.swing.JButton();
        btnback = new javax.swing.JButton();
        btnsimpan = new javax.swing.JButton();
        btnedit = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        txt_kdproduk = new javax.swing.JTextField();
        txt_namaproduk = new javax.swing.JTextField();
        txt_hargaproduk = new javax.swing.JTextField();
        txt_stok = new javax.swing.JTextField();
        txt_barcode = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_produk = new javax.swing.JTable();
        btnprint = new javax.swing.JButton();
        btngenerate = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btntreatment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btntreatment.png"))); // NOI18N
        btntreatment.setContentAreaFilled(false);
        btntreatment.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bgtreatment.png"))); // NOI18N
        btntreatment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntreatmentActionPerformed(evt);
            }
        });
        jPanel1.add(btntreatment, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 90, 90));
        btntreatment.setBorderPainted(false);

        btnsupplieradmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btnsupplier.png"))); // NOI18N
        btnsupplieradmin.setContentAreaFilled(false);
        btnsupplieradmin.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bgsupplier.png"))); // NOI18N
        btnsupplieradmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsupplieradminActionPerformed(evt);
            }
        });
        jPanel1.add(btnsupplieradmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 90, 90));
        btnsupplieradmin.setBorderPainted(false);

        btnpembelianadmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btnpembelian.png"))); // NOI18N
        btnpembelianadmin.setContentAreaFilled(false);
        btnpembelianadmin.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bgpembelian.png"))); // NOI18N
        btnpembelianadmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpembelianadminActionPerformed(evt);
            }
        });
        jPanel1.add(btnpembelianadmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 90, 90));
        btnpembelianadmin.setBorderPainted(false);

        btnmembershipadmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btnmembership.png"))); // NOI18N
        btnmembershipadmin.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bgmembership.png"))); // NOI18N
        jPanel1.add(btnmembershipadmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 90, 90));
        btnmembershipadmin.setContentAreaFilled(false);

        btnlaporanadmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btnlaporan.png"))); // NOI18N
        btnlaporanadmin.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bglaporan.png"))); // NOI18N
        jPanel1.add(btnlaporanadmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 90, 90));
        btnlaporanadmin.setContentAreaFilled(false);

        btnpegawaiadmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btnpegawai.png"))); // NOI18N
        btnpegawaiadmin.setContentAreaFilled(false);
        btnpegawaiadmin.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bgpegawai.png"))); // NOI18N
        btnpegawaiadmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpegawaiadminActionPerformed(evt);
            }
        });
        jPanel1.add(btnpegawaiadmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 90, 90));
        btnpegawaiadmin.setContentAreaFilled(false);

        btnback.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/back.png"))); // NOI18N
        btnback.setContentAreaFilled(false);
        btnback.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/back1.png"))); // NOI18N
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });
        jPanel1.add(btnback, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 880, 90, -1));
        btnback.setBorderPainted(false);

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

        btnedit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btnedit.png"))); // NOI18N
        btnedit.setContentAreaFilled(false);
        btnedit.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bgedit.png"))); // NOI18N
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });
        jPanel1.add(btnedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 890, -1, -1));
        btnedit.setBorderPainted(false);

        btnhapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btndelete.png"))); // NOI18N
        btnhapus.setContentAreaFilled(false);
        btnhapus.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bgdelete.png"))); // NOI18N
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });
        jPanel1.add(btnhapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 890, -1, -1));
        btnhapus.setBorderPainted(false);

        txt_kdproduk.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        txt_kdproduk.setBorder(null);
        jPanel1.add(txt_kdproduk, new org.netbeans.lib.awtextra.AbsoluteConstraints(912, 308, 390, 30));

        txt_namaproduk.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        txt_namaproduk.setBorder(null);
        jPanel1.add(txt_namaproduk, new org.netbeans.lib.awtextra.AbsoluteConstraints(912, 393, 390, 30));

        txt_hargaproduk.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        txt_hargaproduk.setBorder(null);
        jPanel1.add(txt_hargaproduk, new org.netbeans.lib.awtextra.AbsoluteConstraints(912, 477, 390, 30));

        txt_stok.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        txt_stok.setBorder(null);
        jPanel1.add(txt_stok, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 560, 390, 30));

        txt_barcode.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        txt_barcode.setBorder(null);
        txt_barcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_barcodeActionPerformed(evt);
            }
        });
        jPanel1.add(txt_barcode, new org.netbeans.lib.awtextra.AbsoluteConstraints(912, 643, 390, 30));

        tbl_produk.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        tbl_produk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Kode Produk", "Nama Produk", "Harga Produk", "Stok", "Barcode"
            }
        ));
        jScrollPane1.setViewportView(tbl_produk);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 660, 560));

        btnprint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btnprint.png"))); // NOI18N
        btnprint.setContentAreaFilled(false);
        btnprint.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bgprint.png"))); // NOI18N
        btnprint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprintActionPerformed(evt);
            }
        });
        jPanel1.add(btnprint, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 820, -1, -1));
        btnprint.setBorderPainted(false);

        btngenerate.setContentAreaFilled(false);
        btngenerate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btngenerate.png"))); // NOI18N
        btngenerate.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bggenerate.png"))); // NOI18N
        btngenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngenerateActionPerformed(evt);
            }
        });
        jPanel1.add(btngenerate, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 690, 210, -1));
        btngenerate.setBorderPainted(false);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Frame/Produk .png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 970));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btntreatmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntreatmentActionPerformed
        new TreatmentAdmin().setVisible(true);
        dispose();
    }//GEN-LAST:event_btntreatmentActionPerformed

    private void btnsupplieradminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsupplieradminActionPerformed
        new SupplierAdmin().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnsupplieradminActionPerformed

    private void btnpembelianadminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpembelianadminActionPerformed
        try {
            // TODO add your handling code here:
            new PembelianAdmin().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(ProdukAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }//GEN-LAST:event_btnpembelianadminActionPerformed

    private void btnpegawaiadminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpegawaiadminActionPerformed
        
    }//GEN-LAST:event_btnpegawaiadminActionPerformed

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
       new DashboardAdmin().setVisible(true);
       dispose();
    }//GEN-LAST:event_btnbackActionPerformed

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
        // TODO add your handling code here:
        String kode = txt_kdproduk.getText().trim();
        String nama = txt_namaproduk.getText().trim();
        String harga = txt_hargaproduk.getText().trim();  
        String stok = txt_stok.getText().trim();
        String barcodeText = txt_barcode.getText().trim();
        
        String username = SessionLogin.getUsername();
    if (username == null || username.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Username tidak ditemukan. Silakan login kembali!");
        return;
    }

    if (kode.isEmpty() || nama.isEmpty() || harga.isEmpty() || stok.isEmpty() || barcodeText.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Harap isi semua kolom!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    }

    try {
        int hargaInt = Integer.parseInt(harga);

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dinda_salon", "root", "");
        String sql = "INSERT INTO produk (kd_produk, nama_produk, harga_produk, stok, barcode) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setString(1, kode);
        pst.setString(2, nama);
        pst.setInt(3, hargaInt);
        pst.setString(4, stok);
        pst.setString(5, barcodeText);

        int rowsAffected = pst.executeUpdate();

        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(this, "Data berhasil disimpan!", "Simpan Data", JOptionPane.INFORMATION_MESSAGE);
            DefaultTableModel model = (DefaultTableModel) tbl_produk.getModel();

            loadDataToTable();

            txt_kdproduk.setText("");
            txt_namaproduk.setText("");
            txt_hargaproduk.setText("");
            txt_stok.setText("");
            txt_barcode.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Gagal menyimpan data!", "Error", JOptionPane.ERROR_MESSAGE);
        }

        con.close();
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Harga harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menyimpan data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        // TODO add your handling code here:
              String username = SessionLogin.getUsername();
    if (username == null || username.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Username tidak ditemukan. Silakan login kembali!");
        return;
    }
        String kode = txt_kdproduk.getText().trim();
    if (kode.isEmpty()) {
        JOptionPane.showMessageDialog(this,"Pilih data yang akan dihapus terlebih dahulu!","Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    }
    

    int konfirmasi = JOptionPane.showConfirmDialog(this,"Yakin ingin menghapus produk dengan Kode = "+kode+"?",
      "Konfirmasi", JOptionPane.YES_NO_OPTION);
    if (konfirmasi != JOptionPane.YES_OPTION) return;

    String sql = "DELETE FROM produk WHERE kd_produk=?";

    try ( Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dinda_salon","root","");
          PreparedStatement pst = con.prepareStatement(sql)) {

        pst.setString(1, kode);
        if (pst.executeUpdate() > 0) {
            JOptionPane.showMessageDialog(this,"Data berhasil dihapus!", "Sukses",JOptionPane.INFORMATION_MESSAGE);
            loadDataToTable();
            clearForm();
        } else {JOptionPane.showMessageDialog(this,"Data tidak ditemukan!", "Info",JOptionPane.INFORMATION_MESSAGE);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();JOptionPane.showMessageDialog(this, "SQL Error:\n"+ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnhapusActionPerformed

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        // TODO add your handling code here:
    String kode = txt_kdproduk.getText().trim();
    String nama = txt_namaproduk.getText().trim();
    String hs   = txt_hargaproduk.getText().trim();
    String stok = txt_stok.getText().trim();
    String bc   = txt_barcode.getText().trim();
    
    String username = SessionLogin.getUsername();
    if (username == null || username.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Username tidak ditemukan. Silakan login kembali!");
        return;
    }

    if (kode.isEmpty()||nama.isEmpty()||hs.isEmpty()||stok.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Harap pilih data dan isi semua kolom!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    }

    int harga;
    try { harga = Integer.parseInt(hs); }
    catch (NumberFormatException ex) {JOptionPane.showMessageDialog(this, "Harga harus angka!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

     String sql = """
        UPDATE produk
           SET nama_produk=?,
               harga_produk=?,
               stok=?,
               barcode=?
         WHERE kd_produk=?
        """; 

    try ( Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dinda_salon","root","");
        PreparedStatement pst = con.prepareStatement(sql)) {

        pst.setString(1, nama);
        pst.setInt   (2, harga);
        pst.setString(3, stok);
        pst.setString(4, bc);
        pst.setString(5, kode);

        if (pst.executeUpdate() > 0) {
            JOptionPane.showMessageDialog(this,"Data berhasil diubah!", "Sukses",JOptionPane.INFORMATION_MESSAGE);
            loadDataToTable();
            clearForm();
        } else {
            JOptionPane.showMessageDialog(this,"Data tidak ditemukan!", "Info",JOptionPane.INFORMATION_MESSAGE);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this,"SQL Error:\n"+ex.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btneditActionPerformed

    private void btnprintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprintActionPerformed
        // TODO add your handling code here:
        
              String username = SessionLogin.getUsername();
    if (username == null || username.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Username tidak ditemukan. Silakan login kembali!");
        return;
    }
        String barcode = txt_barcode.getText().trim();
        
     if (barcode.isEmpty()) {
        JOptionPane.showMessageDialog(this,"Pilih produk terlebih dahulu!","Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    }
     

    try {
        BufferedImage barcodeImg = generateBarcodeWithText(barcode);

        File folder = new File(OUTPUT_DIR);
        if (!folder.exists()) {
            if (!folder.mkdirs()) {
                throw new IOException("Gagal membuat folder: " + OUTPUT_DIR);
            }
        }

        String filePath = OUTPUT_DIR + barcode + ".png";
        File outputFile = new File(filePath);
        ImageIO.write(barcodeImg, "png", outputFile);

        JOptionPane.showMessageDialog(this,"Barcode tersimpan di:\n" + filePath,"Sukses", JOptionPane.INFORMATION_MESSAGE);

    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this,"Gagal menyimpan barcode:\n" + ex.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnprintActionPerformed

    private void btngenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngenerateActionPerformed
        // TODO add your handling code here:
        
        String username = SessionLogin.getUsername();
    if (username == null || username.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Username tidak ditemukan. Silakan login kembali!");
        return;
    }
    
        final int LENGTH = 12;
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(LENGTH);
        for (int i = 0; i < LENGTH; i++) {
            sb.append(random.nextInt(10));  // angka 0–9
        }
        String randomBarcode = sb.toString();

        txt_barcode.setText(randomBarcode);

        try {
            BufferedImage img = generateBarcodeWithText(randomBarcode);
            lblBarcodePreview.setIcon(new ImageIcon(img));  
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this,"Gagal generate preview barcode:\n" + ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btngenerateActionPerformed

    private void txt_barcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_barcodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_barcodeActionPerformed

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
            java.util.logging.Logger.getLogger(ProdukAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProdukAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProdukAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProdukAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProdukAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnback;
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btngenerate;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnlaporanadmin;
    private javax.swing.JButton btnmembershipadmin;
    private javax.swing.JButton btnpegawaiadmin;
    private javax.swing.JButton btnpembelianadmin;
    private javax.swing.JButton btnprint;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JButton btnsupplieradmin;
    private javax.swing.JButton btntreatment;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_produk;
    private javax.swing.JTextField txt_barcode;
    private javax.swing.JTextField txt_hargaproduk;
    private javax.swing.JTextField txt_kdproduk;
    private javax.swing.JTextField txt_namaproduk;
    private javax.swing.JTextField txt_stok;
    // End of variables declaration//GEN-END:variables
}
