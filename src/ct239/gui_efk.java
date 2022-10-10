/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ct239;

import Manegement.data.addQTN;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import Manegement.data.profile;
import Manegement.data.vocabulary;
import data.panelVideo;

/**
 *
 * @author HP
 */
public class gui_efk extends javax.swing.JFrame {

    private JPanel childPanel;
    private JFrame frame;

    boolean a = false;

    public gui_efk() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        execute();
    }

    private void execute() {
        ImageIcon iconHome = new ImageIcon("C:\\Java-JSP\\ct239\\src\\icon\\home-24.png");
        ImageIcon iconTopic = new ImageIcon("C:\\Java-JSP\\ct239\\src\\icon\\subjects.png");
        ImageIcon iconTest = new ImageIcon("C:\\Java-JSP\\ct239\\src\\icon\\test.png");
        ImageIcon iconEntertainment = new ImageIcon("C:\\Java-JSP\\ct239\\src\\icon\\entertainment.png");
        ImageIcon iconVideo = new ImageIcon("C:\\Java-JSP\\ct239\\src\\icon\\video.png");
        ImageIcon iconMusic = new ImageIcon("C:\\Java-JSP\\ct239\\src\\icon\\music.png");
        ImageIcon iconDatabase = new ImageIcon("C:\\Java-JSP\\ct239\\src\\icon\\database.png");
        ImageIcon iconSubMenu = new ImageIcon("C:\\Java-JSP\\ct239\\src\\icon\\submenu.png");
        ImageIcon iconNext = new ImageIcon("C:\\Java-JSP\\ct239\\src\\icon\\next.png");
        
        //Create menu
        menuItem menuTopic1 =  new menuItem(iconSubMenu, "English Topic 007: Animals", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        menuItem menuTopic2 =  new menuItem(iconSubMenu, "English Topic 002: Colors", null);
        menuItem menuTopic3 =  new menuItem(iconSubMenu, "English Topic 003: Numbers", null);
        menuItem menuTopic4 =  new menuItem(iconSubMenu, "English Topic 004: Alphabet", null);
        
        //Create test
        menuItem menuTest1 =  new menuItem(iconSubMenu, "English Test 001", null);
        menuItem menuTest2 =  new menuItem(iconSubMenu, "English Test 002", null);
        menuItem menuTest3 =  new menuItem(iconSubMenu, "English Test 003", null);
        menuItem menuTest4 =  new menuItem(iconSubMenu, "English Test 004", null);
        menuItem menuTest5 =  new menuItem(iconSubMenu, "English Test 005", null);
        menuItem menuTest6 =  new menuItem(iconSubMenu, "English Test 006", null);
        
        //Create Video
        menuItem menuVideo1 =  new menuItem(iconNext, "Video: Học Bảng Chữ Cái Tiếng Anh", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                content.add(new panelVideo());
                content.repaint();
                content.revalidate();
            }
        });
        
        //Create Music
        menuItem menuMusic1 =  new menuItem(iconNext, "Music: Bài Hát Baby Shark", null);
        
        //Create Entertaiment
        menuItem menuVideo =  new menuItem(iconVideo, "Video", null, menuVideo1);
        menuItem menuMusic =  new menuItem(iconMusic, "Music", null, menuMusic1);
        
        //Create database
        menuItem menuDatabase1 =  new menuItem(iconSubMenu, "Quản lý chủ để từ vựng", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                content.add(new vocabulary());
                content.repaint();
                content.revalidate();
            }
        });
        menuItem menuDatabase2 =  new menuItem(iconSubMenu, "Quản lý thông tin người dùng", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                content.add(new profile());
                content.repaint();
                content.revalidate();
            }
        });
        menuItem menuDatabase3 =  new menuItem(iconSubMenu, "Quản lý danh sách câu hỏi", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                content.add(new addQTN());
                content.repaint();
                content.revalidate();
            }
        });
        menuItem menuDatabase4 =  new menuItem(iconSubMenu, "Quản lý điểm", null);
        
        menuItem menuStaff = new menuItem(iconHome, "Home", null);
        menuItem menuTopic = new menuItem(iconTopic, "English Topics", null, menuTopic1, menuTopic2, menuTopic3, menuTopic4);
        menuItem menuTest = new menuItem(iconTest, "Test Lesson", null, menuTest1,menuTest2, menuTest3, menuTest4, menuTest5, menuTest6);
        menuItem menuEntertainment = new menuItem(iconTest, "Entertaiment", null, menuVideo, menuMusic);
        menuItem menuDatabase = new menuItem(iconDatabase, "System Database", null, menuDatabase1, menuDatabase2, menuDatabase3, menuDatabase4);
        addMenu(menuStaff, menuTopic, menuTest, menuEntertainment, menuDatabase);
    }

    private void addMenu(menuItem... menu) {
        for (int i = 0; i < menu.length; i++) {
            menus.add(menu[i]);
            ArrayList<menuItem> subMenu = menu[i].getSubMenu();
            for(menuItem m : subMenu) {
                addMenu(m);
            }
        }
        menus.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Header = new javax.swing.JPanel();
        iconminmaxclose = new javax.swing.JPanel();
        btnclose = new javax.swing.JPanel();
        close = new javax.swing.JLabel();
        btnmax = new javax.swing.JPanel();
        fullmax = new javax.swing.JLabel();
        btnmin = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Menu = new javax.swing.JPanel();
        menuicon = new javax.swing.JPanel();
        linehidemenu = new javax.swing.JPanel();
        hidemenu = new javax.swing.JPanel();
        btnhidemenu = new javax.swing.JLabel();
        seting = new javax.swing.JPanel();
        btnseting = new javax.swing.JLabel();
        lineseting = new javax.swing.JPanel();
        menuoption = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        menus = new javax.swing.JPanel();
        content = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        Header.setBackground(new java.awt.Color(5, 10, 46));
        Header.setPreferredSize(new java.awt.Dimension(800, 50));
        Header.setLayout(new java.awt.BorderLayout());

        iconminmaxclose.setBackground(new java.awt.Color(5, 10, 46));
        iconminmaxclose.setPreferredSize(new java.awt.Dimension(150, 50));
        iconminmaxclose.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnclose.setBackground(new java.awt.Color(5, 10, 46));
        btnclose.setPreferredSize(new java.awt.Dimension(50, 50));
        btnclose.setLayout(new java.awt.BorderLayout());

        close.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete_32px.png"))); // NOI18N
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                closeMouseExited(evt);
            }
        });
        btnclose.add(close, java.awt.BorderLayout.CENTER);

        iconminmaxclose.add(btnclose, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, -1, -1));

        btnmax.setBackground(new java.awt.Color(5, 10, 46));
        btnmax.setPreferredSize(new java.awt.Dimension(50, 50));
        btnmax.setLayout(new java.awt.BorderLayout());

        fullmax.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fullmax.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/full_screen_32px.png"))); // NOI18N
        fullmax.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fullmaxMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                fullmaxMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                fullmaxMouseExited(evt);
            }
        });
        btnmax.add(fullmax, java.awt.BorderLayout.CENTER);

        iconminmaxclose.add(btnmax, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, -1, -1));

        btnmin.setBackground(new java.awt.Color(5, 10, 46));
        btnmin.setPreferredSize(new java.awt.Dimension(50, 50));
        btnmin.setLayout(new java.awt.BorderLayout());
        iconminmaxclose.add(btnmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Header.add(iconminmaxclose, java.awt.BorderLayout.LINE_END);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("     ENGLISH FOR KIDS");
        Header.add(jLabel1, java.awt.BorderLayout.CENTER);

        getContentPane().add(Header, java.awt.BorderLayout.PAGE_START);

        Menu.setPreferredSize(new java.awt.Dimension(350, 450));
        Menu.setLayout(new java.awt.BorderLayout());

        menuicon.setBackground(new java.awt.Color(5, 10, 46));
        menuicon.setPreferredSize(new java.awt.Dimension(50, 450));
        menuicon.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        linehidemenu.setBackground(new java.awt.Color(5, 10, 46));
        linehidemenu.setPreferredSize(new java.awt.Dimension(50, 5));

        javax.swing.GroupLayout linehidemenuLayout = new javax.swing.GroupLayout(linehidemenu);
        linehidemenu.setLayout(linehidemenuLayout);
        linehidemenuLayout.setHorizontalGroup(
            linehidemenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        linehidemenuLayout.setVerticalGroup(
            linehidemenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        menuicon.add(linehidemenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        hidemenu.setBackground(new java.awt.Color(5, 10, 46));
        hidemenu.setLayout(new java.awt.BorderLayout());

        btnhidemenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnhidemenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/back_32px.png"))); // NOI18N
        btnhidemenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnhidemenuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnhidemenuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnhidemenuMouseExited(evt);
            }
        });
        hidemenu.add(btnhidemenu, java.awt.BorderLayout.CENTER);

        menuicon.add(hidemenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, 50, 50));

        seting.setBackground(new java.awt.Color(5, 10, 46));
        seting.setLayout(new java.awt.BorderLayout());

        btnseting.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnseting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/settings_32px.png"))); // NOI18N
        btnseting.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnsetingMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnsetingMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnsetingMouseExited(evt);
            }
        });
        seting.add(btnseting, java.awt.BorderLayout.CENTER);

        menuicon.add(seting, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 55, 50, 50));

        lineseting.setBackground(new java.awt.Color(5, 10, 46));
        lineseting.setPreferredSize(new java.awt.Dimension(50, 5));

        javax.swing.GroupLayout linesetingLayout = new javax.swing.GroupLayout(lineseting);
        lineseting.setLayout(linesetingLayout);
        linesetingLayout.setHorizontalGroup(
            linesetingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        linesetingLayout.setVerticalGroup(
            linesetingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        menuicon.add(lineseting, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 55, -1, -1));

        Menu.add(menuicon, java.awt.BorderLayout.LINE_START);

        menuoption.setBackground(new java.awt.Color(54, 70, 78));
        menuoption.setLayout(new java.awt.BorderLayout());

        menus.setBackground(new java.awt.Color(255, 255, 255));
        menus.setLayout(new javax.swing.BoxLayout(menus, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(menus);

        menuoption.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        Menu.add(menuoption, java.awt.BorderLayout.CENTER);

        getContentPane().add(Menu, java.awt.BorderLayout.LINE_START);

        content.setBackground(new java.awt.Color(255, 153, 0));
        content.setLayout(new java.awt.BorderLayout());
        getContentPane().add(content, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(1200, 900));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void changecolor(JPanel hover, Color rand) {
        hover.setBackground(rand);
    }

    public void clickmenu(JPanel h1, JPanel h2, int numberbool) {
        if (numberbool == 1) {
            h1.setBackground(new Color(25, 29, 74));
            h2.setBackground(new Color(5, 10, 46));
        } else {
            h1.setBackground(new Color(5, 10, 46));
            h2.setBackground(new Color(25, 29, 74));
        }
    }

    public void changeimage(JLabel button, String resourcheimg) {
        ImageIcon aimg = new ImageIcon(getClass().getResource(resourcheimg));
        button.setIcon(aimg);
    }

    public void hideshow(JPanel menushowhide, boolean dashboard, JLabel button) {
        if (dashboard == true) {
            menushowhide.setPreferredSize(new Dimension(50, menushowhide.getHeight()));
            changeimage(button, "/icon/menu_32px.png");
        } else {
            menushowhide.setPreferredSize(new Dimension(350, menushowhide.getHeight()));
            changeimage(button, "/icon/back_32px.png");
        }

    }

    private void closeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseEntered
        changecolor(btnclose, new Color(25, 29, 74));
    }//GEN-LAST:event_closeMouseEntered

    private void closeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseExited
        changecolor(btnclose, new Color(5, 10, 46));
    }//GEN-LAST:event_closeMouseExited

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        System.exit(0);
    }//GEN-LAST:event_closeMouseClicked

    private void fullmaxMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fullmaxMouseEntered
        changecolor(btnmax, new Color(25, 29, 74));
    }//GEN-LAST:event_fullmaxMouseEntered

    private void fullmaxMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fullmaxMouseExited
        changecolor(btnmax, new Color(5, 10, 46));
    }//GEN-LAST:event_fullmaxMouseExited

    private void fullmaxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fullmaxMouseClicked
        if (this.getExtendedState() != gui_efk.MAXIMIZED_BOTH) {
            this.setExtendedState(gui_efk.MAXIMIZED_BOTH);
        } else {
            this.setExtendedState(gui_efk.NORMAL);
        }
    }//GEN-LAST:event_fullmaxMouseClicked

    private void btnhidemenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhidemenuMouseEntered
        changecolor(linehidemenu, new Color(247, 78, 105));
    }//GEN-LAST:event_btnhidemenuMouseEntered

    private void btnhidemenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhidemenuMouseExited
        changecolor(linehidemenu, new Color(5, 10, 46));
    }//GEN-LAST:event_btnhidemenuMouseExited

    private void btnhidemenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhidemenuMouseClicked
        clickmenu(hidemenu, seting, 1);
        //create void for methode hide and show panel menu
        if (a == true) {
            hideshow(Menu, a, btnhidemenu);
            SwingUtilities.updateComponentTreeUI(this);
            //create methode change image

            a = false;
        } else {
            hideshow(Menu, a, btnhidemenu);
            SwingUtilities.updateComponentTreeUI(this);
            a = true;
        }
    }//GEN-LAST:event_btnhidemenuMouseClicked

    private void btnsetingMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsetingMouseEntered
        changecolor(lineseting, new Color(8, 177, 150));
    }//GEN-LAST:event_btnsetingMouseEntered

    private void btnsetingMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsetingMouseExited
        changecolor(lineseting, new Color(5, 10, 46));
    }//GEN-LAST:event_btnsetingMouseExited

    private void btnsetingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsetingMouseClicked
        clickmenu(seting, hidemenu, 1);
    }//GEN-LAST:event_btnsetingMouseClicked
    //   int x = 220;
//        if (x == 220) {
//            jPanel2.setSize(220, 450);
//            Thread th = new Thread() {
//                @Override
//                public void run() {
//                    for (int i = 220; i >= 0; i--) {
//                        try {
//                            Thread.sleep(1);
//                            jPanel2.setSize(i, 450);
//                        } catch (InterruptedException ex) {
//                            Logger.getLogger(gui_efk.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                    }
//                }
//            };
//            th.start();
//            x = 0;
//        }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(gui_efk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gui_efk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gui_efk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gui_efk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gui_efk().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Header;
    private javax.swing.JPanel Menu;
    private javax.swing.JPanel btnclose;
    private javax.swing.JLabel btnhidemenu;
    private javax.swing.JPanel btnmax;
    private javax.swing.JPanel btnmin;
    private javax.swing.JLabel btnseting;
    private javax.swing.JLabel close;
    private javax.swing.JPanel content;
    private javax.swing.JLabel fullmax;
    private javax.swing.JPanel hidemenu;
    private javax.swing.JPanel iconminmaxclose;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel linehidemenu;
    private javax.swing.JPanel lineseting;
    private javax.swing.JPanel menuicon;
    private javax.swing.JPanel menuoption;
    private javax.swing.JPanel menus;
    private javax.swing.JPanel seting;
    // End of variables declaration//GEN-END:variables
}
