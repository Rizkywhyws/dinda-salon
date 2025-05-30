package BaseApp;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.UIManager;


public class Login extends javax.swing.JFrame {

    public Login() {
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnsignup = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnsignup.setContentAreaFilled(false);
        btnsignup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/SignUpHomebtn.png"))); // NOI18N
        btnsignup.setBorder(null);
        btnsignup.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnsignup.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/SignUpHomebg.png"))); // NOI18N
        btnsignup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnsignupMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnsignupMouseExited(evt);
            }
        });
        btnsignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsignupActionPerformed(evt);
            }
        });
        jPanel1.add(btnsignup, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 580, 360, 150));
        btnsignup.setBorderPainted(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Frame/Login (3).png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1440, 1030));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsignupActionPerformed
        // TODO add your handling code here:
    final JFrame currentFrame = this;

    final SignUp signUpFrame = new SignUp();
    signUpFrame.setOpacity(0f); 
    
    // Timer untuk fade-out Login
    Timer fadeOut = new Timer(30, null);
    fadeOut.addActionListener(new ActionListener() {
        float opacity = 1f;
        @Override
        public void actionPerformed(ActionEvent e) {
            opacity -= 0.1f;
            if (opacity <= 0f) {
                ((Timer)e.getSource()).stop();
                currentFrame.dispose();

                signUpFrame.setVisible(true);
                Timer fadeIn = new Timer(30, null);
                fadeIn.addActionListener(new ActionListener() {
                    float opIn = 0f;
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        opIn += 0.1f;
                        if (opIn >= 1f) {
                            ((Timer)e.getSource()).stop();
                            signUpFrame.setOpacity(1f);
                        } else {
                            signUpFrame.setOpacity(opIn);
                        }
                    }
                });
                fadeIn.start();

            } else {
                currentFrame.setOpacity(opacity);
            }
        }
    });

    // Mulai animasi fade-out
    fadeOut.start();
    }//GEN-LAST:event_btnsignupActionPerformed

    private void btnsignupMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsignupMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnsignupMouseEntered

    private void btnsignupMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsignupMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnsignupMouseExited

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            final Login loginFrame = new Login();
            loginFrame.setOpacity(0f); 
            loginFrame.setVisible(true);

            // Timer untuk efek fade-in
            Timer fadeInTimer = new Timer(30, null);
            fadeInTimer.addActionListener(new ActionListener() {
                float opacity = 0f;
                @Override
                public void actionPerformed(ActionEvent e) {
                    opacity += 0.2f;  
                    if (opacity >= 1f) {
                        loginFrame.setOpacity(1f);
                        fadeInTimer.stop();
                    } else {
                        loginFrame.setOpacity(opacity);
                    }
                }
        });
        fadeInTimer.start();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnsignup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
