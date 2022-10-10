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
import Manegement.NewJPanel;
import Manegement.data.addQDT;
import data.panelVideo;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Manegement.data.profile;
import Manegement.data.vocabulary;
import Manegement.data.result;
import java.awt.Color;

/**
 *
 * @author HP
 */
public class frmMain extends javax.swing.JFrame {

    private JPanel childPanel;
    private JFrame frame;

    public frmMain() {
        initComponents();
        setTitle("Phần Mềm Hỗ Trợ Bé Học Tiếng Anh");
        setLocationRelativeTo(null);
        main();
        bgBuild();
    }

    public void main() {
        bgBuild();
    }

    public void bgBuild() {
        ImageIcon MyImage = new ImageIcon("C:\\Java-JSP\\duan9\\src\\img\\Background\\20.jpg");
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(lblbg.getWidth(), lblbg.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        lblbg.setIcon(image);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Build = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        panelLeft = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        Top = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        option = new javax.swing.JPanel();
        btnProfile = new javax.swing.JButton();
        btnVocabulary = new javax.swing.JButton();
        btnHoc = new javax.swing.JButton();
        btnVideo = new javax.swing.JButton();
        btnMusic = new javax.swing.JButton();
        btnKtra = new javax.swing.JButton();
        btnThanhTich = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        panelCenter = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblbg = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuItemReg = new javax.swing.JMenuItem();
        menuItemLogout = new javax.swing.JMenuItem();
        menuItemLogut = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        menuItemTV = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        menuItemBKT = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        Build.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        Build.setPreferredSize(new java.awt.Dimension(1500, 830));
        Build.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        option.setOpaque(false);
        option.setPreferredSize(new java.awt.Dimension(300, 780));
        option.setLayout(new java.awt.GridLayout(7, 0));

        btnProfile.setBackground(new java.awt.Color(255, 255, 255));
        btnProfile.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnProfile.setForeground(new java.awt.Color(51, 51, 51));
        btnProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/173959_house_icon.png"))); // NOI18N
        btnProfile.setText("Trang chủ");
        btnProfile.setAutoscrolls(true);
        btnProfile.setFocusPainted(false);
        btnProfile.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnProfile.setIconTextGap(20);
        btnProfile.setPreferredSize(new java.awt.Dimension(150, 50));
        option.add(btnProfile);

        btnVocabulary.setBackground(new java.awt.Color(255, 255, 255));
        btnVocabulary.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnVocabulary.setForeground(new java.awt.Color(51, 51, 51));
        btnVocabulary.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/learn.png"))); // NOI18N
        btnVocabulary.setText("Học");
        btnVocabulary.setAutoscrolls(true);
        btnVocabulary.setDoubleBuffered(true);
        btnVocabulary.setFocusPainted(false);
        btnVocabulary.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnVocabulary.setIconTextGap(20);
        btnVocabulary.setPreferredSize(new java.awt.Dimension(150, 50));
        btnVocabulary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVocabularyActionPerformed(evt);
            }
        });
        option.add(btnVocabulary);

        btnHoc.setBackground(new java.awt.Color(255, 255, 255));
        btnHoc.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnHoc.setForeground(new java.awt.Color(51, 51, 51));
        btnHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/writting.png"))); // NOI18N
        btnHoc.setText("Kiểm tra");
        btnHoc.setAutoscrolls(true);
        btnHoc.setFocusPainted(false);
        btnHoc.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnHoc.setIconTextGap(20);
        btnHoc.setPreferredSize(new java.awt.Dimension(150, 50));
        btnHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHocActionPerformed(evt);
            }
        });
        option.add(btnHoc);

        btnVideo.setBackground(new java.awt.Color(255, 255, 255));
        btnVideo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnVideo.setForeground(new java.awt.Color(51, 51, 51));
        btnVideo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/video.png"))); // NOI18N
        btnVideo.setText("Video");
        btnVideo.setAutoscrolls(true);
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
        panelCenter.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelCenter.setOpaque(false);
        panelCenter.setLayout(new java.awt.BorderLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Phần mềm hỗ trợ học Tiếng anh cho bé qua hình ảnh ");
        panelCenter.add(jLabel1, java.awt.BorderLayout.CENTER);

        jPanel1.add(panelCenter, java.awt.BorderLayout.CENTER);

        Build.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 830));
        Build.add(lblbg, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 3, 1500, 830));

        jMenuBar1.setBackground(new java.awt.Color(204, 255, 204));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jMenuBar1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jMenuBar1.setName(""); // NOI18N
        jMenuBar1.setPreferredSize(new java.awt.Dimension(1200, 49));

        jMenu1.setBackground(new java.awt.Color(204, 255, 204));
        jMenu1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenu1.setText("Menu");
        jMenu1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jMenu1.setIconTextGap(50);

        menuItemReg.setBackground(new java.awt.Color(255, 255, 224));
        menuItemReg.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        menuItemReg.setText("Đăng ký");
        menuItemReg.setMargin(new java.awt.Insets(10, 30, 10, 30));
        menuItemReg.setOpaque(true);
        menuItemReg.setPreferredSize(new java.awt.Dimension(320, 50));
        menuItemReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemRegActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemReg);

        menuItemLogout.setBackground(new java.awt.Color(255, 255, 224));
        menuItemLogout.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        menuItemLogout.setText("Đăng nhập");
        menuItemLogout.setMargin(new java.awt.Insets(10, 30, 10, 30));
        menuItemLogout.setOpaque(true);
        menuItemLogout.setPreferredSize(new java.awt.Dimension(320, 50));
        menuItemLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemLogoutActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemLogout);

        menuItemLogut.setBackground(new java.awt.Color(255, 255, 224));
        menuItemLogut.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        menuItemLogut.setText("Đăng xuất");
        menuItemLogut.setMargin(new java.awt.Insets(10, 30, 10, 30));
        menuItemLogut.setOpaque(true);
        menuItemLogut.setPreferredSize(new java.awt.Dimension(320, 50));
        menuItemLogut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemLogutActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemLogut);

        jMenuBar1.add(jMenu1);

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

        jMenu2.setBackground(new java.awt.Color(204, 255, 204));
        jMenu2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenu2.setText("Help");
        jMenu2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jMenu2.setIconTextGap(50);
        jMenuBar1.add(jMenu2);

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

    private void menuItemRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemRegActionPerformed
        if (frame == null) {
            frame = new frmReg();
        }
        frame.setVisible(true);
    }//GEN-LAST:event_menuItemRegActionPerformed

    private void menuItemLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemLogoutActionPerformed
        if (frame == null) {
            frame = new frmLogin();
        }
        frame.setVisible(true);
    }//GEN-LAST:event_menuItemLogoutActionPerformed

    private void menuItemLogutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemLogutActionPerformed
        if (frame == null) {
            frame = new frmIndex();
        }
        frame.setVisible(true);
    }//GEN-LAST:event_menuItemLogutActionPerformed

    private void btnVocabularyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVocabularyActionPerformed
        childPanel = new NewJPanel();
        panelCenter.removeAll();
        panelCenter.add(childPanel);
        panelCenter.validate();
    }//GEN-LAST:event_btnVocabularyActionPerformed

    private void btnKtraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKtraActionPerformed
        
    }//GEN-LAST:event_btnKtraActionPerformed

    private void btnHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHocActionPerformed
        childPanel = new ChuDeQuiz();
        panelCenter.removeAll();
        panelCenter.add(childPanel);
        panelCenter.validate();
    }//GEN-LAST:event_btnHocActionPerformed

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
    private javax.swing.JButton btnHoc;
    private javax.swing.JButton btnKtra;
    private javax.swing.JButton btnMusic;
    private javax.swing.JButton btnProfile;
    private javax.swing.JButton btnThanhTich;
    private javax.swing.JButton btnVideo;
    private javax.swing.JButton btnVocabulary;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lblbg;
    private javax.swing.JMenuItem menuItemBKT;
    private javax.swing.JMenuItem menuItemLogout;
    private javax.swing.JMenuItem menuItemLogut;
    private javax.swing.JMenuItem menuItemReg;
    private javax.swing.JMenuItem menuItemTV;
    private javax.swing.JPanel option;
    private javax.swing.JPanel panelCenter;
    private javax.swing.JPanel panelLeft;
    // End of variables declaration//GEN-END:variables
}
