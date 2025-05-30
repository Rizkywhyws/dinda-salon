<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package BaseApp;

import Base.SignIn;
import BaseApp.TransaksiKasir;
=======
package BaseApp;

import Base.*;
>>>>>>> upstream/main
<<<<<<< HEAD
=======
package BaseApp;

import Base.*;
>>>>>>> upstream/main
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
/**
 *
 * @author ASUS
 */
public class TransaksiLayanan extends javax.swing.JFrame {
    public static String Id;
    /**
     * Creates new form TransaksiKasir
     */
    public TransaksiLayanan() {
        initComponents();
        setLocationRelativeTo(null);
        this.Id = SignIn.LoggedInUser;
=======
<<<<<<< HEAD
=======
>>>>>>> upstream/main
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
public class TransaksiLayanan extends javax.swing.JFrame {

    public TransaksiLayanan() {
        initComponents();
        setLocationRelativeTo(null);
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> upstream/main
=======
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
>>>>>>> upstream/main
        // Ambil model kolom
        TableColumnModel columnModel = tb_sementara.getColumnModel();

        // Cek jumlah kolom cukup
        if (columnModel.getColumnCount() >= 2) {
            // Hapus kolom "No." (index 0)
            columnModel.removeColumn(columnModel.getColumn(0));

            // Hapus kolom "id layanan" yang sekarang berada di index 0 setelah penghapusan pertama
            columnModel.removeColumn(columnModel.getColumn(0));
        }
        try {
            loadLayanan();
            loadPromo();
        } catch (Exception e) {
        }
        
        //border dan content filled cmbx false
        cmbx_layanan.setOpaque(false);
        cmbx_layanan.setBackground(new Color(0, 0, 0, 0));
        cmbx_layanan.setForeground(Color.WHITE);
        cmbx_layanan.setBorder(null);
        //buat dropdown transparan combo box supplier
        cmbx_layanan.setRenderer(new DefaultListCellRenderer() {
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
        
        // Listener untuk pemilihan diskon
        cmbx_diskon.addActionListener(evt -> updateTotal());
        
        //border dan content filled cmbx false
        cmbx_diskon.setOpaque(false);
        cmbx_diskon.setBackground(new Color(0, 0, 0, 0));
        cmbx_diskon.setForeground(Color.WHITE);
        cmbx_diskon.setBorder(null);
        //buat dropdown transparan combo box supplier
        cmbx_diskon.setRenderer(new DefaultListCellRenderer() {
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
        
        //listener untuk update subtotal
        txt_jumlah.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateSubtotal();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateSubtotal();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateSubtotal();
            }
        });
        
        // Listener untuk scan RFID member saat tekan enter
        txt_rfId.addActionListener(evt -> {
            String rfid = txt_rfId.getText();
            if (!rfid.isEmpty()) {
                cariMemberByRFID(rfid);
            }
        });
        
        //Listener untuk menghitung total
        // Tambahkan TableModelListener ke tb_sementara
        tb_sementara.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                updateTotal();
            }
        });
        
        //listener bayar untuk updateKembalum
        txt_bayar.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateKembali();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateKembali();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateKembali();
            }
        });
        
        //listener total untuk updateKembali
        txt_total.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateKembali();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateKembali();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateKembali();
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnSimpan = new javax.swing.JButton();
        btnBayar = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_sementara = new javax.swing.JTable();
        cmbx_layanan = new javax.swing.JComboBox<>();
        txt_subtotal = new javax.swing.JTextField();
        txt_jumlah = new javax.swing.JTextField();
        txt_harga = new javax.swing.JTextField();
        btnHapus = new javax.swing.JButton();
        txt_kembali = new javax.swing.JTextField();
        txt_bayar = new javax.swing.JTextField();
        txt_total = new javax.swing.JTextField();
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
        txt_poin = new javax.swing.JTextField();
        txt_rfId = new javax.swing.JTextField();
        cmbx_diskon = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
=======
<<<<<<< HEAD
=======
>>>>>>> upstream/main
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
        txt_rfId = new javax.swing.JTextField();
        txt_poin = new javax.swing.JTextField();
        cmbx_diskon = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> upstream/main
=======
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
>>>>>>> upstream/main

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(936, 666));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSimpan.setContentAreaFilled(false);
        btnSimpan.setBorderPainted(false);
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
        btnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/button/Group 60 (1).png"))); // NOI18N
        btnSimpan.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/button/Group 60.png"))); // NOI18N
=======
        btnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btnsimpan.png"))); // NOI18N
        btnSimpan.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bgsimpan.png"))); // NOI18N
>>>>>>> upstream/main
<<<<<<< HEAD
=======
        btnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btnsimpan.png"))); // NOI18N
        btnSimpan.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bgsimpan.png"))); // NOI18N
>>>>>>> upstream/main
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
        jPanel1.add(btnSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 140, -1, -1));

        btnBayar.setContentAreaFilled(false);
        btnBayar.setBorderPainted(false);
        btnBayar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/designKasir/Group 27.png"))); // NOI18N
        btnBayar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/button/Group 27 (1).png"))); // NOI18N
=======
<<<<<<< HEAD
=======
>>>>>>> upstream/main
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
        jPanel1.add(btnSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 160, -1, -1));

        btnBayar.setContentAreaFilled(false);
        btnBayar.setBorderPainted(false);
        btnBayar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btnbayar.png"))); // NOI18N
        btnBayar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bgbayar.png"))); // NOI18N
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> upstream/main
=======
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
>>>>>>> upstream/main
        btnBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBayarActionPerformed(evt);
            }
        });
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
        jPanel1.add(btnBayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 570, -1, -1));

        btnBack.setContentAreaFilled(false);
        btnBack.setBorderPainted(false);
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/button/back100.png"))); // NOI18N
        btnBack.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/button/back50.png"))); // NOI18N
=======
<<<<<<< HEAD
=======
>>>>>>> upstream/main
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
        jPanel1.add(btnBayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 820, -1, -1));

        btnBack.setContentAreaFilled(false);
        btnBack.setBorderPainted(false);
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/back.png"))); // NOI18N
        btnBack.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/back1.png"))); // NOI18N
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> upstream/main
=======
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
>>>>>>> upstream/main
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
        jPanel1.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 20, -1, -1));

=======
        jPanel1.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 90, -1));

        tb_sementara.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
>>>>>>> upstream/main
<<<<<<< HEAD
=======
        jPanel1.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 90, -1));

        tb_sementara.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
>>>>>>> upstream/main
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
        tb_sementara.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "id_Lay", "Layanan", "Harga", "Jumlah", "Subtotal"
            }
        ));
        jScrollPane1.setViewportView(tb_sementara);

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 670, 150));

=======
        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 350, 1030, 250));

        cmbx_layanan.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
>>>>>>> upstream/main
<<<<<<< HEAD
=======
        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 350, 1030, 250));

        cmbx_layanan.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
>>>>>>> upstream/main
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
        cmbx_layanan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Layanan" }));
        cmbx_layanan.setBorder(null);
        cmbx_layanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbx_layananActionPerformed(evt);
            }
        });
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
        jPanel1.add(cmbx_layanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 150, 30));

        txt_subtotal.setBorder(null);
        jPanel1.add(txt_subtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 67, 150, 30));

        txt_jumlah.setBorder(null);
        jPanel1.add(txt_jumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 32, 150, 30));

        txt_harga.setEditable(false);
        txt_harga.setBorder(null);
        jPanel1.add(txt_harga, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 73, 150, 30));

        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/button/Group 80.png"))); // NOI18N
        btnHapus.setContentAreaFilled(false);
        btnHapus.setBorderPainted(false);
        btnHapus.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/button/Group 80 (1).png"))); // NOI18N
=======
<<<<<<< HEAD
=======
>>>>>>> upstream/main
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
        jPanel1.add(cmbx_layanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 52, 230, 30));

        txt_subtotal.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        txt_subtotal.setBorder(null);
        jPanel1.add(txt_subtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 100, 240, 40));

        txt_jumlah.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        txt_jumlah.setBorder(null);
        jPanel1.add(txt_jumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 50, 240, 40));

        txt_harga.setEditable(false);
        txt_harga.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        txt_harga.setBorder(null);
        jPanel1.add(txt_harga, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 110, 230, 40));

        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/btndel.png"))); // NOI18N
        btnHapus.setContentAreaFilled(false);
        btnHapus.setBorderPainted(false);
        btnHapus.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bgdel.png"))); // NOI18N
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> upstream/main
=======
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
>>>>>>> upstream/main
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
        jPanel1.add(btnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 400, -1, -1));

        txt_kembali.setEditable(false);
=======
<<<<<<< HEAD
=======
>>>>>>> upstream/main
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
        jPanel1.add(btnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 610, -1, -1));

        txt_kembali.setEditable(false);
        txt_kembali.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> upstream/main
=======
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
>>>>>>> upstream/main
        txt_kembali.setBorder(null);
        txt_kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_kembaliActionPerformed(evt);
            }
        });
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
        jPanel1.add(txt_kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 520, 140, 30));

=======
        jPanel1.add(txt_kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 767, 240, 30));

        txt_bayar.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
>>>>>>> upstream/main
<<<<<<< HEAD
=======
        jPanel1.add(txt_kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 767, 240, 30));

        txt_bayar.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
>>>>>>> upstream/main
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
        txt_bayar.setBorder(null);
        txt_bayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bayarActionPerformed(evt);
            }
        });
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
        jPanel1.add(txt_bayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 480, 140, 30));

        txt_total.setEditable(false);
=======
<<<<<<< HEAD
=======
>>>>>>> upstream/main
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
        jPanel1.add(txt_bayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 710, 240, 30));

        txt_total.setEditable(false);
        txt_total.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> upstream/main
=======
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
>>>>>>> upstream/main
        txt_total.setBorder(null);
        txt_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_totalActionPerformed(evt);
            }
        });
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
        jPanel1.add(txt_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 600, 140, 30));

        txt_poin.setBorder(null);
        txt_poin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_poinActionPerformed(evt);
            }
        });
        jPanel1.add(txt_poin, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 519, 140, 30));

=======
        jPanel1.add(txt_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 883, 230, 30));

        txt_rfId.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
>>>>>>> upstream/main
<<<<<<< HEAD
=======
        jPanel1.add(txt_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 883, 230, 30));

        txt_rfId.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
>>>>>>> upstream/main
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
        txt_rfId.setBorder(null);
        txt_rfId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_rfIdActionPerformed(evt);
            }
        });
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        jPanel1.add(txt_rfId, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 479, 140, 30));

=======
=======
>>>>>>> upstream/main
=======
        jPanel1.add(txt_rfId, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 479, 140, 30));

=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
        jPanel1.add(txt_rfId, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 707, 230, 30));

        txt_poin.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        txt_poin.setBorder(null);
        txt_poin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_poinActionPerformed(evt);
            }
        });
        jPanel1.add(txt_poin, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 765, 230, 30));

        cmbx_diskon.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> upstream/main
=======
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
>>>>>>> upstream/main
        cmbx_diskon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih diskon" }));
        cmbx_diskon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbx_diskonActionPerformed(evt);
            }
        });
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
        jPanel1.add(cmbx_diskon, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 560, 150, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/designKasir/transaksi layanan (1).png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 670));
=======
<<<<<<< HEAD
=======
>>>>>>> upstream/main
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
        jPanel1.add(cmbx_diskon, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 826, 240, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Frame/transaksi layanan.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> upstream/main
=======
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
>>>>>>> upstream/main

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 940, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)
=======
<<<<<<< HEAD
=======
>>>>>>> upstream/main
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1374, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 983, Short.MAX_VALUE)
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> upstream/main
=======
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
>>>>>>> upstream/main
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        new TransaksiKasir().setVisible(true);
        this.dispose();
        JOptionPane.showMessageDialog(this, "Batal melakukan transaksi.", "Batal", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnBackActionPerformed

    private void cmbx_layananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbx_layananActionPerformed
        try {
            int idLayanan = getIdFromComboBox(cmbx_layanan);
        if (idLayanan != 0) {
            loadHarga(idLayanan);
            System.out.println("ID yang dipilih: " + idLayanan);
        } else {
            txt_harga.setText("");
        }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Format ID Layanan tidak valid", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_cmbx_layananActionPerformed
    
    //method untuk proses perubahan total
    private void updateTotal() {
        int total = 0;
        DefaultTableModel model = (DefaultTableModel) tb_sementara.getModel();

        // Hitung subtotal dari tabel
        for (int i = 0; i < model.getRowCount(); i++) {
            total += (int) model.getValueAt(i, 5); // Mengasumsikan subtotal ada di kolom ke-5
        }
        // Terapkan diskon jika ada
        String selectedItem = (String) cmbx_diskon.getSelectedItem();
        if (selectedItem != null && !selectedItem.equals("Pilih promo")) {
            String[] parts = selectedItem.split(" - ");
            int discountPercentage = getDiscountPercentage(Integer.parseInt(parts[0].trim())); // Ambil ID promo
            total -= (total * discountPercentage / 100);
        }
        // Update txt_total
        txt_total.setText(String.valueOf(total));
    }
    
    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
         try {
=======
=======
>>>>>>> upstream/main
=======
         try {
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
            String username = SessionLogin.getUsername();
    if (username == null || username.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Username tidak ditemukan. Silakan login kembali!");
        return;
    }
        try {
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> upstream/main
=======
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
>>>>>>> upstream/main
             //validasi agar inputan di isi oleh user
            if (cmbx_layanan.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(this, "Harap Pilih Salah Satu!", "ERROR", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (txt_harga.getText().isEmpty() || txt_jumlah.getText().isEmpty() || txt_subtotal.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Harap Jangan Dikosongi!", "ERROR", JOptionPane.WARNING_MESSAGE);
                return;
            }
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dinda_salon", "root", "");
        
        int idLayanan = getIdFromComboBox(cmbx_layanan);
        
        // Ambil data layanan berdasarkan id yang dipilih
        String sqlLayanan = "SELECT id_layanan, nama_layanan, harga_layanan FROM layanan WHERE id_layanan = ?";
        PreparedStatement pstProduk = conn.prepareStatement(sqlLayanan);
        pstProduk.setInt(1, idLayanan);
        ResultSet rsProduk = pstProduk.executeQuery();

        if (rsProduk.next()) {
            int Layanan = rsProduk.getInt("id_layanan");
            String nama = rsProduk.getString("nama_layanan");
            int harga = rsProduk.getInt("harga_layanan");
            int subtotal = Integer.parseInt(txt_subtotal.getText());
            int jumlah = Integer.parseInt(txt_jumlah.getText());
            String produk = "P000000";
            // Tampilkan ke form
            txt_harga.setText(String.valueOf(harga));
            txt_subtotal.setText(String.valueOf(subtotal));

            // Simpan ke database (tabel detail_sementara)
            String sqlInsert = "INSERT INTO detail_sementara (kd_produk, id_layanan, jumlah_sm, subtotal) VALUES (?, ?, ?, ?)";
            PreparedStatement pstInsert = conn.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
            pstInsert.setString(1, produk);
            pstInsert.setInt(2, Layanan);
            pstInsert.setInt(3, jumlah);
            pstInsert.setInt(4, subtotal);
            pstInsert.executeUpdate();
            
            // Ambil id_sementara yang baru dibuat
            ResultSet generatedKeys = pstInsert.getGeneratedKeys();
            int id_sementara = -1;
            if (generatedKeys.next()) {
                id_sementara = generatedKeys.getInt(1);
            }
            
            // Tambahkan ke tabel sementara
            DefaultTableModel model = (DefaultTableModel) tb_sementara.getModel();
            model.addRow(new Object[]{id_sementara, idLayanan, nama, harga, jumlah, subtotal});
            
            cmbx_layanan.setSelectedIndex(0);
            txt_harga.setText("");
            txt_jumlah.setText("");
            txt_subtotal.setText("");

        } else {
            JOptionPane.showMessageDialog(this, "Barcode tidak ditemukan di database.");
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + e.getMessage());
    }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> upstream/main
=======
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
          String username = SessionLogin.getUsername();
    if (username == null || username.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Username tidak ditemukan. Silakan login kembali!");
        return;
    }
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> upstream/main
=======
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
>>>>>>> upstream/main
        DefaultTableModel model = (DefaultTableModel) tb_sementara.getModel();
        int selectedRow = tb_sementara.getSelectedRow();

        if (selectedRow >= 0) {
            // Ambil id layanan dari baris yang dipilih
            String idLayanan = model.getValueAt(selectedRow, 1).toString();

            try {
                // Koneksi database
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dinda_salon", "root", "");

                // Query hapus data dari detail_sementara berdasarkan kd_produk
                String sqlDelete = "DELETE FROM detail_sementara WHERE id_layanan = ?";
                PreparedStatement pstDelete = conn.prepareStatement(sqlDelete);
                pstDelete.setString(1, idLayanan);

                int affectedRows = pstDelete.executeUpdate();

                if (affectedRows > 0) {
                    // Jika berhasil dihapus dari DB, hapus juga dari tabel
                    model.removeRow(selectedRow);
                    JOptionPane.showMessageDialog(this, "Data berhasil dihapus.");
                } else {
                    JOptionPane.showMessageDialog(this, "Data tidak ditemukan di database.");
                }

                pstDelete.close();
                conn.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error saat menghapus data: " + e.getMessage());
            }

        } else {
            JOptionPane.showMessageDialog(this, "Pilih baris yang ingin dihapus!");
        }
    }//GEN-LAST:event_btnHapusActionPerformed

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
    private void txt_rfIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_rfIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_rfIdActionPerformed
=======
    private void txt_poinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_poinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_poinActionPerformed
>>>>>>> upstream/main
<<<<<<< HEAD
=======
    private void txt_poinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_poinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_poinActionPerformed
>>>>>>> upstream/main
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896

    private void cariMemberByRFID(String rfid) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dinda_salon", "root", "");
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
            String sql = "SELECT * FROM member WHERE rfid = ?";
=======
            String sql = "SELECT * FROM member WHERE rfID = ?";
>>>>>>> upstream/main
<<<<<<< HEAD
=======
            String sql = "SELECT * FROM member WHERE rfID = ?";
>>>>>>> upstream/main
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, rfid);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // Contoh kolom member: nama_member, poin_member, diskon_member (persen)
                txt_poin.setText(String.valueOf(rs.getInt("poin_member")));

            } else {
                JOptionPane.showMessageDialog(this, "Member dengan RFID tersebut tidak ditemukan.");
                txt_poin.setText("");
            }

            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage());
        }
    }
    
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
    private void txt_poinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_poinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_poinActionPerformed
=======
    private void txt_rfIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_rfIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_rfIdActionPerformed
>>>>>>> upstream/main
<<<<<<< HEAD
=======
    private void txt_rfIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_rfIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_rfIdActionPerformed
>>>>>>> upstream/main
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896

    private void txt_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_totalActionPerformed

    private void txt_bayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bayarActionPerformed

    private void txt_kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_kembaliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_kembaliActionPerformed

    private void cmbx_diskonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbx_diskonActionPerformed
        try {
            String selectedItem = (String) cmbx_diskon.getSelectedItem();
            if (selectedItem == null || selectedItem.equals("0 - Pilih Promo")) {
                return;
            }
            // Parsing yang lebih robust dari item yang dipilih
            String[] parts = selectedItem.split(" - ", 2);
            if (parts.length < 2) {
                throw new IllegalArgumentException("Format item tidak valid");
            }
            int selectedId = Integer.parseInt(parts[0].trim());
            String selectedName = parts[1].trim();
            // Ambil persentase diskon dari database
            int discountPercentage = getDiscountPercentage(selectedId);

            // Update total setelah memilih promo
            updateTotal();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Format ID promo tidak valid", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_cmbx_diskonActionPerformed

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
    class LayananItem {
        String id_sementara;
        String id_layanan;
        String jumlah;
        String subtotal;

        public LayananItem(String id_sementara, String id_layanan, String jumlah, String subtotal) {
            this.id_sementara = id_sementara;
            this.id_layanan = id_layanan;
            this.jumlah = jumlah;
            this.subtotal = subtotal;
        }
    }
    
    private void btnBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBayarActionPerformed
        try {
=======
<<<<<<< HEAD
=======
>>>>>>> upstream/main
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
    private void btnBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBayarActionPerformed
           String username = SessionLogin.getUsername();
    if (username == null || username.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Username tidak ditemukan. Silakan login kembali!");
        return;
    }
        try {
            // Validasi agar inputan diisi oleh user
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> upstream/main
=======
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
>>>>>>> upstream/main
            if (cmbx_diskon.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(this, "Harap Pilih Salah Satu!", "ERROR", JOptionPane.WARNING_MESSAGE);
                return;
            }

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
            DefaultTableModel model = (DefaultTableModel) tb_sementara.getModel();
            List<LayananItem> items = new ArrayList<>();

            for (int i = 0; i < model.getRowCount(); i++) {
                String id_sm = model.getValueAt(i, 0).toString();
                String idLayanan = model.getValueAt(i, 1).toString();
                String jumlah = model.getValueAt(i, 4).toString();
                String subtotal = model.getValueAt(i, 5).toString();
                items.add(new LayananItem(id_sm, idLayanan, jumlah, subtotal));
            }

=======
<<<<<<< HEAD
=======
>>>>>>> upstream/main
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
            // Mendapatkan model tabel
            DefaultTableModel model = (DefaultTableModel) tb_sementara.getModel();

            // Membuat list untuk menyimpan data
            List<String[]> listData = new ArrayList<>();

            // Iterasi melalui semua baris di tabel
            for (int i = 0; i < model.getRowCount(); i++) {
                String id_sm = model.getValueAt(i, 0).toString();
                String idLayanan = model.getValueAt(i, 1).toString(); // Kode
                String jumlah = model.getValueAt(i, 4).toString(); // Jumlah
                String subtotal = model.getValueAt(i, 5).toString(); // Subtotal

                // Menyimpan data dalam array
                String[] data = {id_sm, idLayanan, jumlah, subtotal};
                listData.add(data); // Menambahkan array ke list
            }
            
            //pengambilan id member 
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> upstream/main
=======
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
>>>>>>> upstream/main
            String RF = txt_rfId.getText();
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dinda_salon", "root", "");
            String query = "SELECT id_member FROM member WHERE rfID = ?";
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setString(1, RF);
            ResultSet rs = stm.executeQuery();
            String idmemb = null;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
            if (rs.next()) {
                idmemb = rs.getString("id_member");
            } else {
                JOptionPane.showMessageDialog(this, "Member tidak ditemukan!", "ERROR", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int diskon = getIdFromComboBox(cmbx_diskon);
            int IdUser = SessionLogin.getIdUser();
=======
<<<<<<< HEAD
=======
>>>>>>> upstream/main
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
                if (rs.next()) {
                    idmemb = rs.getString("id_member");
                } else{
                    JOptionPane.showMessageDialog(this, "Member tidak ditemukan!", "ERROR", JOptionPane.WARNING_MESSAGE);
                    return;
                }        
            // Proses inisialisasi 
            int diskon = getIdFromComboBox(cmbx_diskon);
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> upstream/main
=======
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
>>>>>>> upstream/main
            LocalDate tgl_jual = LocalDate.now();
            String total_jual = txt_total.getText();
            String bayar_jual = txt_bayar.getText();
            String kembali_jual = txt_kembali.getText();
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD

            SimpanTransaksi(IdUser, idmemb, diskon, tgl_jual, total_jual, bayar_jual, kembali_jual, items);
=======
=======
>>>>>>> upstream/main
=======

            SimpanTransaksi(IdUser, idmemb, diskon, tgl_jual, total_jual, bayar_jual, kembali_jual, items);
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
            String kd_brg = "P000000";
            
            // Melakukan transaksi untuk setiap item dalam listData
            for (String[] data : listData) {
                String id_sm = data[0]; // Kode barang
                String idLayanan = data[1]; // Kode barang
                String jumlah = data[2]; // Jumlah
                String subtotal = data[3]; // Subtotal

                // Memanggil method lain untuk menyimpan transaksi
                SimpanTransaksi(username, idmemb, diskon, tgl_jual, total_jual, bayar_jual, kembali_jual, kd_brg, jumlah, subtotal, id_sm, idLayanan);
            }
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> upstream/main
=======
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
>>>>>>> upstream/main

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "YAHH Gagal melakukan transaksi: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBayarActionPerformed

    //proses simpan data ke database
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
    private void SimpanTransaksi(int IdUser, String idmemb, int diskon, LocalDate tgl_jual,
                             String total_jual, String bayar_jual, String kembali_jual,
                             List<LayananItem> items) {
=======
    private void SimpanTransaksi(String IdUser, String idmemb,int diskon,LocalDate tgl_jual, String total_jual, String bayar_jual, String kembali_jual, String kd_brg, String jumlah, String subtotal, String id_sm, String idLayanan){
>>>>>>> upstream/main
<<<<<<< HEAD
=======
    private void SimpanTransaksi(String IdUser, String idmemb,int diskon,LocalDate tgl_jual, String total_jual, String bayar_jual, String kembali_jual, String kd_brg, String jumlah, String subtotal, String id_sm, String idLayanan){
>>>>>>> upstream/main
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
        Connection conn = null;
        PreparedStatement stmt1 = null;
        PreparedStatement stmt2 = null;
        PreparedStatement stmt3 = null;
        try {
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dinda_salon", "root", "");
            conn.setAutoCommit(false);

            String insert1 = "INSERT INTO transaksi (id_user, id_member, id_promo, tgl_transaksi, total_transaksi, bayar, kembali) VALUES (?, ?, ?, ?, ?, ?, ?)";
            stmt1 = conn.prepareStatement(insert1, Statement.RETURN_GENERATED_KEYS);
            stmt1.setInt(1, IdUser);
=======
<<<<<<< HEAD
=======
>>>>>>> upstream/main
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
            String url = "jdbc:mysql://localhost:3306/dinda_salon";
            String user = "root";
            String pw = "";
            conn = DriverManager.getConnection(url, user, pw);
            
            //mengaktifkan auto-commit untuk memulai transaksi
            conn.setAutoCommit(false);
            
            //query untuk menambah data ke database
            String insert1 = "INSERT INTO transaksi (id_user, id_member, id_promo, tgl_transaksi, total_transaksi, bayar, kembali) VALUES (?, ?, ?, ?, ?, ?, ?)";
            stmt1 = conn.prepareStatement(insert1, Statement.RETURN_GENERATED_KEYS);
            stmt1.setString(1, IdUser);
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> upstream/main
=======
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
>>>>>>> upstream/main
            stmt1.setString(2, idmemb);
            stmt1.setInt(3, diskon);
            stmt1.setDate(4, java.sql.Date.valueOf(tgl_jual));
            stmt1.setString(5, total_jual);
            stmt1.setString(6, bayar_jual);
            stmt1.setString(7, kembali_jual);
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896

            int affectedRows = stmt1.executeUpdate();
            int idTrans = 0;
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = stmt1.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        idTrans = generatedKeys.getInt(1);
                    }
                }
            }

            if (idTrans == 0) {
                throw new SQLException("Menyimpan transaksi gagal, Id transaksi tidak tersedia!");
            }

            String insert2 = "INSERT INTO detail_transaksi (id_detail, id_transaksi, id_layanan, kd_produk, jumlah_jual, subtotal) VALUES (?, ?, ?, ?, ?, ?)";
            stmt2 = conn.prepareStatement(insert2);
            stmt3 = conn.prepareStatement("DELETE FROM detail_sementara WHERE id_sementara = ?");

            for (LayananItem item : items) {
                stmt2.setString(1, item.id_sementara);
                stmt2.setInt(2, idTrans);
                stmt2.setString(3, item.id_layanan);
                stmt2.setString(4, "P000000");
                stmt2.setString(5, item.jumlah);
                stmt2.setString(6, item.subtotal);
                stmt2.executeUpdate();

                stmt3.setString(1, item.id_sementara);
                stmt3.executeUpdate();
            }

            conn.commit();
            JOptionPane.showMessageDialog(this, "Transaksi berhasil ditambahkan.", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            new TransaksiKasir().setVisible(true);
            this.dispose();

=======
<<<<<<< HEAD
=======
>>>>>>> upstream/main
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
            
            //eksekusi table pertama
            int afectedrows = stmt1.executeUpdate();
            
            //ambil id transaksi yang baru saja dimasukkan
            int idTrans = 0;
            if (afectedrows > 0) {
                try (ResultSet generatedKeys = stmt1.getGeneratedKeys()){
                    if (generatedKeys.next()) {
                        idTrans = generatedKeys.getInt(1);
                    }
                } 
            }
            
            //jika tidak ada id, maka batalkan transaksi
            if (idTrans == 0) {
                throw new SQLException("Menyimpan transaksi gagal, Id transaksi tidak tersedia!");
            }
            
            //query untuk menambah ke detail pembelian
            String insert2 = "INSERT INTO detail_transaksi (id_detail, id_transaksi,id_layanan, kd_produk, jumlah_jual, subtotal) VALUES (?, ?, ?, ?, ?, ?)";
            stmt2 = conn.prepareStatement(insert2);
            stmt2.setString(1, id_sm);
            stmt2.setInt(2, idTrans);
            stmt2.setString(3, idLayanan);
            stmt2.setString(4, kd_brg);
            stmt2.setString(5, jumlah);
            stmt2.setString(6, subtotal);
            stmt2.executeUpdate();
            
            String hapus = "DELETE FROM detail_sementara WHERE id_sementara = ?";
            stmt3 = conn.prepareStatement(hapus);
            stmt3.setString(1, id_sm);
            
            int result = stmt3.executeUpdate();
            
            //jika kedua query berhasil, commit transaksi
            conn.commit();
            
             if (result > 0) {
            // Tampilkan pesan sukses dan reset form
                JOptionPane.showMessageDialog(this, "Transaksi berhasil ditambahkan.", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Gagal menambahkan transaksi. Coba lagi.", "Error", JOptionPane.ERROR_MESSAGE);
            }
             
             new TransaksiKasir().setVisible(true);
             this.dispose();
             
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> upstream/main
=======
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
>>>>>>> upstream/main
        } catch (Exception e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
            JOptionPane.showMessageDialog(this, "Gagal menyimpan transaksi: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
=======
            JOptionPane.showMessageDialog(null, "Gagal menyimpan transaksi: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
>>>>>>> upstream/main
<<<<<<< HEAD
=======
            JOptionPane.showMessageDialog(null, "Gagal menyimpan transaksi: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
>>>>>>> upstream/main
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
            e.printStackTrace();
        } finally {
            try {
                if (stmt1 != null) stmt1.close();
                if (stmt2 != null) stmt2.close();
                if (stmt3 != null) stmt3.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
     // Metode untuk mendapatkan persentase diskon dari database
    private int getDiscountPercentage(int promoId) {
        int discount = 0;
        String query = "SELECT diskon FROM promo WHERE id_promo = ?";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dinda_salon", "root", "");
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, promoId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                discount = rs.getInt("diskon");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error saat mengambil diskon: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return discount;
    }
    
    // Improved supplier loading method
    private void loadPromo() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/dinda_salon";
        String user = "root";
        String pw = "";
        String query = "SELECT id_promo, jenis_promo FROM promo";

        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        model.addElement("0 - Pilih Promo");

        try (Connection conn = DriverManager.getConnection(url, user, pw);
             java.sql.Statement stmt = conn.createStatement();
             java.sql.ResultSet rs = stmt.executeQuery(query)) {

            while(rs.next()) {
                int id = rs.getInt("id_promo");
                String nama = rs.getString("jenis_promo");
                model.addElement(id + " - " + nama);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, 
                "Gagal memuat data supplier:\n" + e.getMessage(), 
                "Database Error", 
                JOptionPane.ERROR_MESSAGE);
            throw e;
        }

        cmbx_diskon.setModel(model);
    }
    
    private void loadHarga(int idLayanan) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/dinda_salon";
        String user = "root";
        String pw = "";
        String query = "SELECT harga_layanan FROM layanan WHERE id_layanan = ?";
        try (Connection conn = DriverManager.getConnection(url, user, pw);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, idLayanan);
            try (ResultSet rs = pstmt.executeQuery()) {
                txt_harga.setText(rs.next() 
                    ? String.valueOf(rs.getInt("harga_layanan")) 
                    : "0"
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            txt_harga.setText("0");
        }
    }
    private void loadLayanan() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/dinda_salon";
        String user = "root";
        String pw = "";
        String query = "SELECT id_layanan, nama_layanan FROM layanan ORDER BY nama_layanan";

        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        model.addElement("0 - Pilih Layanan");

        try (Connection conn = DriverManager.getConnection(url, user, pw);
             java.sql.Statement stmt = conn.createStatement();
             java.sql.ResultSet rs = stmt.executeQuery(query)) {

            while(rs.next()) {
                int id = rs.getInt("id_layanan");
                String nama = rs.getString("nama_layanan");
                model.addElement(id + " - " + nama);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, 
                "Gagal memuat data layanan:\n" + e.getMessage(), 
                "Database Error", 
                JOptionPane.ERROR_MESSAGE);
            throw e;
        }

        cmbx_layanan.setModel(model);
    }
    
    //method untuk mengambil id ke combo box
    private int getIdFromComboBox(javax.swing.JComboBox<String> comboBox){
        String selectedItem = (String) comboBox.getSelectedItem();
        if (selectedItem != null && selectedItem.contains(" - ")) {
            String[] parts = selectedItem.split(" - ", 2);
            return Integer.parseInt(parts[0]);
        }
        return 0;
    }
    
    //method untuk hitung subtotal otomatis
    private void updateSubtotal(){
        try {
            int harga = Integer.parseInt(txt_harga.getText());
            int jumlah = Integer.parseInt(txt_jumlah.getText());
            int subtotal = harga * jumlah;
            
            txt_subtotal.setText(String.valueOf(subtotal));
        } catch (NumberFormatException e) {
            //jika jumlah kosong atau tidal berupa angka
            txt_subtotal.setText("");
        }
    }
    
    //proses untuk isi kembali otomatis
    private void updateKembali(){
        try {
            int total = Integer.parseInt(txt_total.getText());
            int bayar = Integer.parseInt(txt_bayar.getText());
            int kembali = bayar - total;
            
            //memastikan nilai nya tida negatif
            if (kembali < 0) {
                txt_kembali.setText("0");
            }else{
                txt_kembali.setText(String.valueOf(kembali));
            }
        } catch (Exception e) {
            //jika inputan bayar kosong
            txt_kembali.setText("");
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
        System.setProperty("sun.java2d.uiScale", "1");
>>>>>>> upstream/main
=======
        System.setProperty("sun.java2d.uiScale", "1");
>>>>>>> upstream/main
=======
=======
        System.setProperty("sun.java2d.uiScale", "1");
>>>>>>> upstream/main
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
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
            java.util.logging.Logger.getLogger(TransaksiLayanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransaksiLayanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransaksiLayanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransaksiLayanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> upstream/main
=======
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> upstream/main
=======
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
>>>>>>> upstream/main

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TransaksiLayanan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBayar;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JComboBox<String> cmbx_diskon;
    private javax.swing.JComboBox<String> cmbx_layanan;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
    private javax.swing.JLabel jLabel1;
=======
    private javax.swing.JLabel jLabel3;
>>>>>>> upstream/main
<<<<<<< HEAD
=======
    private javax.swing.JLabel jLabel3;
>>>>>>> upstream/main
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_sementara;
    private javax.swing.JTextField txt_bayar;
    private javax.swing.JTextField txt_harga;
    private javax.swing.JTextField txt_jumlah;
    private javax.swing.JTextField txt_kembali;
    private javax.swing.JTextField txt_poin;
    private javax.swing.JTextField txt_rfId;
    private javax.swing.JTextField txt_subtotal;
    private javax.swing.JTextField txt_total;
    // End of variables declaration//GEN-END:variables
}
