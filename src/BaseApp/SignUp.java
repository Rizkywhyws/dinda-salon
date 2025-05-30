package BaseApp;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class SignUp extends javax.swing.JFrame {
    private static final Logger logger = Logger.getLogger(SignUp.class.getName());
    private JComboBox<String> levelComboBox;
    public static String hashMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();
            
            for (byte b : messageDigest) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
   
    public SignUp() {
        setUndecorated(true); 
        initComponents();
        level.setOpaque(false);
        level.setBackground(new Color(0, 0, 0, 0));
        level.setForeground(Color.WHITE);
        level.setBorder(null);
        //buat dropdown transparan
        level.setRenderer(new DefaultListCellRenderer() {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value,int index, boolean isSelected, boolean cellHasFocus) {
            Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (c instanceof JComponent) {
                ((JComponent) c).setOpaque(false);
            }
            return c;
}
});
        cmbx_negara.setOpaque(false);
        cmbx_negara.setBackground(new Color(0, 0, 0, 0));
        cmbx_negara.setForeground(Color.WHITE);
        cmbx_negara.setBorder(null);
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
        
        new NegaraAPI(cmbx_negara);
       
        setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtnamauser = new javax.swing.JTextField();
        txtusername = new javax.swing.JTextField();
        txtnotelp = new javax.swing.JTextField();
        txtpassword = new javax.swing.JPasswordField();
        showpassword = new javax.swing.JCheckBox();
        level = new javax.swing.JComboBox<>();
        signupbtn = new javax.swing.JButton();
        signinhaveaccount = new javax.swing.JButton();
        btnbacksignup = new javax.swing.JButton();
        cmbx_negara = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtnamauser.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        txtnamauser.setBorder(null);
        jPanel1.add(txtnamauser, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 324, 720, 30));

        txtusername.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        txtusername.setBorder(null);
        jPanel1.add(txtusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 540, 720, 30));

        txtnotelp.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        txtnotelp.setBorder(null);
        jPanel1.add(txtnotelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 432, 330, 30));

        txtpassword.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        txtpassword.setBorder(null);
        jPanel1.add(txtpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 644, 690, 30));

        showpassword.setBackground(new java.awt.Color(255, 255, 255));
        showpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showpasswordActionPerformed(evt);
            }
        });
        jPanel1.add(showpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(1009, 645, -1, 30));

        level.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        level.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose One", "Owner", "Admin", "Kasir" }));
        level.setBorder(null);
        jPanel1.add(level, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 744, 160, 40));

        signupbtn.setContentAreaFilled(false);
        signupbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/signup1.png"))); // NOI18N
        signupbtn.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Signup.png"))); // NOI18N
        signupbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                signupbtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                signupbtnMouseExited(evt);
            }
        });
        signupbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupbtnActionPerformed(evt);
            }
        });
        jPanel1.add(signupbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 760, -1, -1));
        signupbtn.setBorderPainted(false);

        signinhaveaccount.setContentAreaFilled(false);
        signinhaveaccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Sign In btn.png"))); // NOI18N
        signinhaveaccount.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Sign In btn..png"))); // NOI18N
        signinhaveaccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                signinhaveaccountMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                signinhaveaccountMouseExited(evt);
            }
        });
        signinhaveaccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signinhaveaccountActionPerformed(evt);
            }
        });
        jPanel1.add(signinhaveaccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 870, -1, -1));
        signinhaveaccount.setBorderPainted(false);

        btnbacksignup.setContentAreaFilled(false);
        btnbacksignup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/back.png"))); // NOI18N
        btnbacksignup.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/back1.png"))); // NOI18N
        btnbacksignup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnbacksignupMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnbacksignupMouseExited(evt);
            }
        });
        btnbacksignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbacksignupActionPerformed(evt);
            }
        });
        jPanel1.add(btnbacksignup, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 870, 100, 80));
        btnbacksignup.setBorderPainted(false);

        cmbx_negara.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        jPanel1.add(cmbx_negara, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 432, 370, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Frame/SignUpFrame.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 980));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 980));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void signupbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupbtnActionPerformed
        // TODO add your handling code here:
        String nama = txtnamauser.getText();
        String telepon = txtnotelp.getText();
        String username = txtusername.getText();
        String password = new String(txtpassword.getText());
        String selectedLevel = (String) level.getSelectedItem();
        
        if (nama.isEmpty() || telepon.isEmpty() || username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Harap isi semua kolom");
            return;
        }
        
        String hashedPassword = hashMD5(password);
        
       
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dinda_salon", "root", "")) {
            try (PreparedStatement checkUsername = conn.prepareStatement("SELECT COUNT(*) FROM user WHERE username = ?")) {
                checkUsername.setString(1, username);
                try (ResultSet usernameResult = checkUsername.executeQuery()) {
                    if (usernameResult.next() && usernameResult.getInt(1) > 0) {
                        JOptionPane.showMessageDialog(this, "Username sudah terdaftar!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
            }
            if (selectedLevel.equalsIgnoreCase("owner")) {
                try (PreparedStatement checkOwner = conn.prepareStatement("SELECT COUNT(*) FROM user WHERE level = 'owner'");
                    ResultSet ownerResult = checkOwner.executeQuery()) {
                    if (ownerResult.next() && ownerResult.getInt(1) > 0) {
                        JOptionPane.showMessageDialog(this, "Owner sudah terdaftar!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
            }

            if (selectedLevel.equalsIgnoreCase("admin")) {
                try (PreparedStatement checkAdmin = conn.prepareStatement("SELECT COUNT(*) FROM user WHERE level = 'admin'");
                    ResultSet adminResult = checkAdmin.executeQuery()) {
                    if (adminResult.next() && adminResult.getInt(1) > 0) {
                        JOptionPane.showMessageDialog(this, "Admin sudah terdaftar!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
            }

            PreparedStatement stmt = conn.prepareStatement("INSERT INTO user (nama_user, notelp, username, password, level) VALUES (?, ?, ?, ?, ?)");
            stmt.setString(1, nama);
            stmt.setString(2, telepon);
            stmt.setString(3, username);
            stmt.setString(4, hashedPassword);
            stmt.setString(5, selectedLevel);

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "Sign Up berhasil!", "Success", JOptionPane.INFORMATION_MESSAGE);
                final JFrame currentFrame = this;
                Timer fadeOutTimer = new Timer(30, null);
                fadeOutTimer.addActionListener(new ActionListener() {
                float opacity = 1f;
                     @Override
                        public void actionPerformed(ActionEvent e) {
                            opacity -= 0.1f; // 
                            if (opacity <= 0f) {
                            fadeOutTimer.stop();
                            currentFrame.dispose();  

                        // Buka frame Sign In dengan efek fade-in
                        final SignIn signInFrame = new SignIn();
                        signInFrame.setOpacity(0f);
                        signInFrame.setVisible(true);

                        Timer fadeInTimer = new Timer(30, null);
                        fadeInTimer.addActionListener(new ActionListener() {
                            float opacityIn = 0f;
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                opacityIn += 0.1f; 
                                if (opacityIn >= 1f) {
                                    fadeInTimer.stop();
                                    signInFrame.setOpacity(1f);
                                } else {
                                    signInFrame.setOpacity(opacityIn);
                                }
                            }
                         });
                             fadeInTimer.start();
                         } else {
                            currentFrame.setOpacity(opacity);
                        }
                    }
                });
                    fadeOutTimer.start();
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }

        SignIn n = new SignIn();
        n.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_signupbtnActionPerformed

    private void signupbtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signupbtnMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_signupbtnMouseEntered

    private void signupbtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signupbtnMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_signupbtnMouseExited

    private void signinhaveaccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signinhaveaccountActionPerformed
        // TODO add your handling code here:
    final JFrame currentFrame = this;
    Timer fadeOutTimer = new Timer(40, null);
    fadeOutTimer.addActionListener(new ActionListener() {
        float opacity = 1f;
        @Override
        public void actionPerformed(ActionEvent e) {
            opacity -= 0.1f;
            if (opacity <= 0f) {
                fadeOutTimer.stop();
                currentFrame.dispose();
                
                // mengatur undecorated di konstruktornya
                final SignIn signinFrame = new SignIn();
                signinFrame.setOpacity(0f);
                signinFrame.setVisible(true);
                
                Timer fadeInTimer = new Timer(40, null);
                fadeInTimer.addActionListener(new ActionListener() {
                    float opacityIn = 0f;
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        opacityIn += 0.1f;
                        if (opacityIn >= 1f) {
                            fadeInTimer.stop();
                            signinFrame.setOpacity(1f);
                        } else {
                            signinFrame.setOpacity(opacityIn);
                        }
                    }
                });
                fadeInTimer.start();
            } else {
                currentFrame.setOpacity(opacity);
            }
        }
    });
    fadeOutTimer.start();
    }//GEN-LAST:event_signinhaveaccountActionPerformed

    private void signinhaveaccountMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signinhaveaccountMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_signinhaveaccountMouseEntered

    private void signinhaveaccountMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signinhaveaccountMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_signinhaveaccountMouseExited

    private void btnbacksignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbacksignupActionPerformed
        // TODO add your handling code here:
    final JFrame currentFrame = this;
    Timer fadeOutTimer = new Timer(40, null);
    fadeOutTimer.addActionListener(new ActionListener() {
        float opacity = 1f;
        @Override
        public void actionPerformed(ActionEvent e) {
            opacity -= 0.1f;
            if (opacity <= 0f) {
                fadeOutTimer.stop();
                currentFrame.dispose();
                
                // mengatur undecorated di konstruktornya
                final Login loginFrame = new Login();
                loginFrame.setOpacity(0f);
                loginFrame.setVisible(true);
                
                Timer fadeInTimer = new Timer(40, null);
                fadeInTimer.addActionListener(new ActionListener() {
                    float opacityIn = 0f;
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        opacityIn += 0.1f;
                        if (opacityIn >= 1f) {
                            fadeInTimer.stop();
                            loginFrame.setOpacity(1f);
                        } else {
                            loginFrame.setOpacity(opacityIn);
                        }
                    }
                });
                fadeInTimer.start();
            } else {
                currentFrame.setOpacity(opacity);
            }
        }
    });
    fadeOutTimer.start();

    }//GEN-LAST:event_btnbacksignupActionPerformed

    private void btnbacksignupMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbacksignupMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnbacksignupMouseEntered

    private void btnbacksignupMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbacksignupMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnbacksignupMouseExited

    private void showpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showpasswordActionPerformed
        // TODO add your handling code here:
         if (showpassword.isSelected()) {
            txtpassword.setEchoChar((char) 0);
        } else {
            txtpassword.setEchoChar('•');
        }

    }//GEN-LAST:event_showpasswordActionPerformed

    
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
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignUp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbacksignup;
    private javax.swing.JComboBox<String> cmbx_negara;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> level;
    private javax.swing.JCheckBox showpassword;
    private javax.swing.JButton signinhaveaccount;
    private javax.swing.JButton signupbtn;
    private javax.swing.JTextField txtnamauser;
    private javax.swing.JTextField txtnotelp;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
