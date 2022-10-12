/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ct239;

import Manegement.data.BKT;
import data_class.frmIndex;
import data_class.frmReg;
import Manegement.data.addQTN;
import data.panelMusic;
import Manegement.topicTNDT.ChuDeQuiz;
import Manegement.data.Learn;
import Manegement.data.addQDT;
import Manegement.data.home;
import data.panelVideo;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Manegement.data.profile;
import Manegement.data.vocabulary;
import Manegement.data.result;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import user.Connect;

/**
 *
 * @author HP
 */
public class frmMain extends javax.swing.JFrame {

    private JPanel childPanel;
    private JFrame frame;

    DefaultTableModel tbn = new DefaultTableModel();
    Connect a = new Connect();
    Connection con = a.getConnection();
    Statement st = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    String fPath = null;
    byte[] img_DATA;

    //private String username;

    public frmMain() {
        initComponents();
//        this.username = username;
//        lblusername.setText(username);
        setTitle("Phần Mềm Hỗ Trợ Bé Học Tiếng Anh");
        setLocationRelativeTo(null);
        childPanel = new home();
        panelCenter.removeAll();
        panelCenter.add(childPanel);
        panelCenter.validate();
        
        btnHome.setBackground(new Color(0,255,127));
    }

//    private frmMain() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        Build = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        lblusername = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lblLogin = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        panelLeft = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        Top = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        option = new javax.swing.JPanel();
        btnHome = new javax.swing.JButton();
        btnLearn = new javax.swing.JButton();
        btnTest = new javax.swing.JButton();
        btnVideo = new javax.swing.JButton();
        btnMusic = new javax.swing.JButton();
        btnKtra = new javax.swing.JButton();
        btnThanhTich = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        panelCenter = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        menuItemTV = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        menuItemBKT = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();

        jMenuBar2.setBackground(new java.awt.Color(255, 255, 255));

        jMenu1.setText("File");
        jMenuBar2.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar2.add(jMenu2);

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        Build.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), null));
        Build.setPreferredSize(new java.awt.Dimension(1500, 880));
        Build.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setPreferredSize(new java.awt.Dimension(1492, 50));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setOpaque(false);
        jPanel4.setPreferredSize(new java.awt.Dimension(250, 50));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setPreferredSize(new java.awt.Dimension(150, 50));
        jPanel7.setLayout(new java.awt.BorderLayout());

        lblusername.setBackground(new java.awt.Color(255, 255, 255));
        lblusername.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel7.add(lblusername, java.awt.BorderLayout.CENTER);

        jPanel4.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel6.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.white, java.awt.Color.white), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        jPanel6.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanel6.setLayout(new java.awt.BorderLayout());

        lblLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/user.png"))); // NOI18N
        lblLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLoginMouseClicked(evt);
            }
        });
        jPanel6.add(lblLogin, java.awt.BorderLayout.CENTER);

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, -1, -1));

        jPanel8.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.white, java.awt.Color.white), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        jPanel8.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanel8.setLayout(new java.awt.BorderLayout());

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/211614_down_b_arrow_icon.png"))); // NOI18N
        jPanel8.add(jLabel4, java.awt.BorderLayout.CENTER);

        jPanel4.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, -1, -1));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1245, 0, -1, -1));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setPreferredSize(new java.awt.Dimension(1250, 50));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.white, java.awt.Color.white), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        jPanel10.setLayout(new java.awt.BorderLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Quản lý");
        jPanel10.add(jLabel5, java.awt.BorderLayout.CENTER);

        jPanel9.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 50));

        jPanel11.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.white, java.awt.Color.white), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        jPanel11.setPreferredSize(new java.awt.Dimension(150, 50));
        jPanel11.setLayout(new java.awt.BorderLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Hướng dẫn");
        jPanel11.add(jLabel6, java.awt.BorderLayout.CENTER);

        jPanel9.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, -1, -1));

        jPanel12.setPreferredSize(new java.awt.Dimension(100, 50));
        jPanel12.setLayout(new java.awt.BorderLayout());
        jPanel9.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 950, -1));

        jPanel2.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, -1));

        Build.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(1500, 830));
        jPanel1.setLayout(new java.awt.BorderLayout());

        panelLeft.setBackground(new java.awt.Color(255, 255, 255));
        panelLeft.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), javax.swing.BorderFactory.createEmptyBorder(20, 0, 0, 0)));
        panelLeft.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panelLeft.setPreferredSize(new java.awt.Dimension(300, 50));
        panelLeft.setLayout(new java.awt.BorderLayout(20, 20));

        jPanel3.setOpaque(false);
        jPanel3.setPreferredSize(new java.awt.Dimension(627, 100));
        jPanel3.setLayout(new java.awt.BorderLayout());

        Top.setBackground(new java.awt.Color(255, 255, 255));
        Top.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        Top.setPreferredSize(new java.awt.Dimension(100, 180));
        Top.setLayout(new java.awt.BorderLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon.png"))); // NOI18N
        Top.add(jLabel2, java.awt.BorderLayout.CENTER);

        jPanel3.add(Top, java.awt.BorderLayout.PAGE_START);

        option.setBackground(new java.awt.Color(255, 255, 255));
        option.setPreferredSize(new java.awt.Dimension(300, 780));
        option.setLayout(new java.awt.GridLayout(7, 0));

        btnHome.setBackground(new java.awt.Color(255, 255, 255));
        btnHome.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnHome.setForeground(new java.awt.Color(51, 51, 51));
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/9004832_house_home_building_estate_icon.png"))); // NOI18N
        btnHome.setText("Trang chủ");
        btnHome.setAutoscrolls(true);
        btnHome.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        btnHome.setFocusPainted(false);
        btnHome.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnHome.setIconTextGap(20);
        btnHome.setPreferredSize(new java.awt.Dimension(150, 50));
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });
        option.add(btnHome);

        btnLearn.setBackground(new java.awt.Color(255, 255, 255));
        btnLearn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnLearn.setForeground(new java.awt.Color(51, 51, 51));
        btnLearn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/6771580_book_education_learning_school_science_icon.png"))); // NOI18N
        btnLearn.setText("Học");
        btnLearn.setAutoscrolls(true);
        btnLearn.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        btnLearn.setDoubleBuffered(true);
        btnLearn.setFocusPainted(false);
        btnLearn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnLearn.setIconTextGap(20);
        btnLearn.setPreferredSize(new java.awt.Dimension(150, 50));
        btnLearn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLearnActionPerformed(evt);
            }
        });
        option.add(btnLearn);

        btnTest.setBackground(new java.awt.Color(255, 255, 255));
        btnTest.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnTest.setForeground(new java.awt.Color(51, 51, 51));
        btnTest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/writting.png"))); // NOI18N
        btnTest.setText("Kiểm tra");
        btnTest.setAutoscrolls(true);
        btnTest.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        btnTest.setFocusPainted(false);
        btnTest.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnTest.setIconTextGap(20);
        btnTest.setPreferredSize(new java.awt.Dimension(150, 50));
        btnTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTestActionPerformed(evt);
            }
        });
        option.add(btnTest);

        btnVideo.setBackground(new java.awt.Color(255, 255, 255));
        btnVideo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnVideo.setForeground(new java.awt.Color(51, 51, 51));
        btnVideo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/video.png"))); // NOI18N
        btnVideo.setText("Video");
        btnVideo.setAutoscrolls(true);
        btnVideo.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        btnVideo.setFocusPainted(false);
        btnVideo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnVideo.setIconTextGap(20);
        btnVideo.setMaximumSize(new java.awt.Dimension(150, 40));
        btnVideo.setMinimumSize(new java.awt.Dimension(150, 40));
        btnVideo.setPreferredSize(new java.awt.Dimension(150, 50));
        btnVideo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVideoActionPerformed(evt);
            }
        });
        option.add(btnVideo);

        btnMusic.setBackground(new java.awt.Color(255, 255, 255));
        btnMusic.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnMusic.setForeground(new java.awt.Color(51, 51, 51));
        btnMusic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/9004842_music_sound_audio_media_icon.png"))); // NOI18N
        btnMusic.setText("Music ");
        btnMusic.setAutoscrolls(true);
        btnMusic.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        btnMusic.setFocusPainted(false);
        btnMusic.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnMusic.setIconTextGap(20);
        btnMusic.setPreferredSize(new java.awt.Dimension(150, 50));
        btnMusic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMusicActionPerformed(evt);
            }
        });
        option.add(btnMusic);

        btnKtra.setBackground(new java.awt.Color(255, 255, 255));
        btnKtra.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnKtra.setForeground(new java.awt.Color(51, 51, 51));
        btnKtra.setText("Quiz");
        btnKtra.setAutoscrolls(true);
        btnKtra.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        btnKtra.setFocusPainted(false);
        btnKtra.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnKtra.setIconTextGap(20);
        btnKtra.setPreferredSize(new java.awt.Dimension(150, 50));
        btnKtra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKtraActionPerformed(evt);
            }
        });
        option.add(btnKtra);

        btnThanhTich.setBackground(new java.awt.Color(255, 255, 255));
        btnThanhTich.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnThanhTich.setForeground(new java.awt.Color(51, 51, 51));
        btnThanhTich.setText("Thành Tích");
        btnThanhTich.setAutoscrolls(true);
        btnThanhTich.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        btnThanhTich.setFocusPainted(false);
        btnThanhTich.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnThanhTich.setIconTextGap(20);
        btnThanhTich.setPreferredSize(new java.awt.Dimension(150, 50));
        btnThanhTich.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhTichActionPerformed(evt);
            }
        });
        option.add(btnThanhTich);

        jPanel3.add(option, java.awt.BorderLayout.CENTER);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel5.setPreferredSize(new java.awt.Dimension(300, 250));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/9069112_setting_icon.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(0, 260, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 208, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.add(jPanel5, java.awt.BorderLayout.PAGE_END);

        panelLeft.add(jPanel3, java.awt.BorderLayout.CENTER);

        jPanel1.add(panelLeft, java.awt.BorderLayout.WEST);

        panelCenter.setBackground(new java.awt.Color(255, 255, 255));
        panelCenter.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelCenter.setOpaque(false);
        panelCenter.setLayout(new java.awt.BorderLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Phần mềm hỗ trợ học Tiếng anh cho bé qua hình ảnh ");
        jLabel1.setOpaque(true);
        panelCenter.add(jLabel1, java.awt.BorderLayout.CENTER);

        jPanel1.add(panelCenter, java.awt.BorderLayout.CENTER);

        Build.add(jPanel1, java.awt.BorderLayout.CENTER);

        jMenuBar1.setBackground(new java.awt.Color(204, 255, 204));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jMenuBar1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jMenuBar1.setName(""); // NOI18N
        jMenuBar1.setPreferredSize(new java.awt.Dimension(1200, 49));

        jMenu4.setBackground(new java.awt.Color(204, 255, 204));
        jMenu4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenu4.setText("Quản lý");
        jMenu4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jMenu4.setIconTextGap(50);

        menuItemTV.setBackground(new java.awt.Color(255, 255, 224));
        menuItemTV.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        menuItemTV.setText("Quản lý từ vựng");
        menuItemTV.setIconTextGap(30);
        menuItemTV.setMargin(new java.awt.Insets(20, 20, 20, 20));
        menuItemTV.setOpaque(true);
        menuItemTV.setPreferredSize(new java.awt.Dimension(300, 50));
        menuItemTV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemTVActionPerformed(evt);
            }
        });
        jMenu4.add(menuItemTV);

        jMenu6.setBackground(new java.awt.Color(255, 255, 224));
        jMenu6.setText("Quản lý câu hỏi");
        jMenu6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jMenu6.setIconTextGap(30);
        jMenu6.setMargin(new java.awt.Insets(20, 20, 20, 20));
        jMenu6.setOpaque(true);
        jMenu6.setPreferredSize(new java.awt.Dimension(250, 50));

        jMenuItem4.setBackground(new java.awt.Color(255, 255, 224));
        jMenuItem4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jMenuItem4.setText("Câu hỏi trác nghiệm");
        jMenuItem4.setIconTextGap(30);
        jMenuItem4.setMargin(new java.awt.Insets(20, 20, 20, 20));
        jMenuItem4.setOpaque(true);
        jMenuItem4.setPreferredSize(new java.awt.Dimension(300, 50));
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem4);

        jMenuItem5.setBackground(new java.awt.Color(255, 255, 224));
        jMenuItem5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jMenuItem5.setText("Câu hỏi điền từ");
        jMenuItem5.setIconTextGap(30);
        jMenuItem5.setMargin(new java.awt.Insets(20, 20, 20, 20));
        jMenuItem5.setOpaque(true);
        jMenuItem5.setPreferredSize(new java.awt.Dimension(300, 50));
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem5);

        menuItemBKT.setBackground(new java.awt.Color(255, 255, 224));
        menuItemBKT.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        menuItemBKT.setText("Bài kiểm tra");
        menuItemBKT.setIconTextGap(30);
        menuItemBKT.setMargin(new java.awt.Insets(20, 20, 20, 20));
        menuItemBKT.setOpaque(true);
        menuItemBKT.setPreferredSize(new java.awt.Dimension(300, 50));
        menuItemBKT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemBKTActionPerformed(evt);
            }
        });
        jMenu6.add(menuItemBKT);

        jMenu4.add(jMenu6);

        jMenuItem6.setBackground(new java.awt.Color(255, 255, 224));
        jMenuItem6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jMenuItem6.setText("Quản lý thông tin người dùng");
        jMenuItem6.setIconTextGap(30);
        jMenuItem6.setMargin(new java.awt.Insets(20, 20, 20, 20));
        jMenuItem6.setMinimumSize(new java.awt.Dimension(250, 50));
        jMenuItem6.setOpaque(true);
        jMenuItem6.setPreferredSize(new java.awt.Dimension(300, 50));
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem6);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Build, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Build, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVideoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVideoActionPerformed
        childPanel = new panelVideo();
        panelCenter.removeAll();
        panelCenter.add(childPanel);
        panelCenter.validate();
    }//GEN-LAST:event_btnVideoActionPerformed

    private void btnMusicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMusicActionPerformed
        childPanel = new panelMusic();
        panelCenter.removeAll();
        panelCenter.add(childPanel);
        panelCenter.validate();
    }//GEN-LAST:event_btnMusicActionPerformed

    private void btnLearnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLearnActionPerformed
        childPanel = new Learn();
        panelCenter.removeAll();
        panelCenter.add(childPanel);
        panelCenter.validate();
        
        btnHome.setBackground(Color.white);
        btnLearn.setBackground(new Color(0,255,127));
        btnTest.setBackground(Color.white);
    }//GEN-LAST:event_btnLearnActionPerformed

    private void btnKtraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKtraActionPerformed

    }//GEN-LAST:event_btnKtraActionPerformed

    private void btnTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTestActionPerformed
        childPanel = new ChuDeQuiz();
        panelCenter.removeAll();
        panelCenter.add(childPanel);
        panelCenter.validate();
        
        btnHome.setBackground(Color.white);
        btnLearn.setBackground(Color.white);
        btnTest.setBackground(new Color(0,255,127));
    }//GEN-LAST:event_btnTestActionPerformed

    private void btnThanhTichActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhTichActionPerformed
        childPanel = new result();
        panelCenter.removeAll();
        panelCenter.add(childPanel);
        panelCenter.validate();
    }//GEN-LAST:event_btnThanhTichActionPerformed

    private void menuItemTVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemTVActionPerformed
        childPanel = new vocabulary();
        panelCenter.removeAll();
        panelCenter.add(childPanel);
        panelCenter.validate();
    }//GEN-LAST:event_menuItemTVActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        childPanel = new addQTN();
        panelCenter.removeAll();
        panelCenter.add(childPanel);
        panelCenter.validate();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        childPanel = new addQDT();
        panelCenter.removeAll();
        panelCenter.add(childPanel);
        panelCenter.validate();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        childPanel = new profile();
        panelCenter.removeAll();
        panelCenter.add(childPanel);
        panelCenter.validate();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void menuItemBKTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemBKTActionPerformed
        childPanel = new BKT();
        panelCenter.removeAll();
        panelCenter.add(childPanel);
        panelCenter.validate();
    }//GEN-LAST:event_menuItemBKTActionPerformed

    private void lblLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLoginMouseClicked
        frame = new frmLogin();
        frame.setVisible(true);
    }//GEN-LAST:event_lblLoginMouseClicked

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        childPanel = new home();
        panelCenter.removeAll();
        panelCenter.add(childPanel);
        panelCenter.validate();
        
        btnHome.setBackground(new Color(0,255,127));
        btnLearn.setBackground(Color.white);
        btnTest.setBackground(Color.white);
    }//GEN-LAST:event_btnHomeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Build;
    private javax.swing.JPanel Top;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnKtra;
    private javax.swing.JButton btnLearn;
    private javax.swing.JButton btnMusic;
    private javax.swing.JButton btnTest;
    private javax.swing.JButton btnThanhTich;
    private javax.swing.JButton btnVideo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblusername;
    private javax.swing.JMenuItem menuItemBKT;
    private javax.swing.JMenuItem menuItemTV;
    private javax.swing.JPanel option;
    private javax.swing.JPanel panelCenter;
    private javax.swing.JPanel panelLeft;
    // End of variables declaration//GEN-END:variables
}
