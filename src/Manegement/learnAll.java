/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manegement;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import ct239.frmMain;
import java.awt.Color;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import user.Connect;

/**
 *
 * @author HP
 */
public class learnAll extends javax.swing.JFrame {

    private static final String VOICENAME = "kevin16";
    private static int position = 0;

    DefaultTableModel tbn = new DefaultTableModel();
    Connect a = new Connect();
    Connection con = a.getConnection();
    Statement st = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    String fPath = null;
    byte[] img_DATA;

    ButtonGroup bg = new ButtonGroup();

    Timer t, time;
    int cong;

    int counter = 0;
    Boolean isIT = false;

    int point = 0;
    int count = 0;

    public learnAll() {
        initComponents();
        getConnection();
        loadTest();
        this.setResizable(false);
        //Topic();
    }

//    public void Topic() {
//        ImageIcon MyImage = new ImageIcon("C:\\Java-JSP\\duan9\\src\\img\\Background\\18.jpg");
//        Image img = MyImage.getImage();
//        Image newImg = img.getScaledInstance(lblBg.getWidth(), lblBg.getHeight(), Image.SCALE_SMOOTH);
//        ImageIcon image = new ImageIcon(newImg);
//        lblBg.setIcon(image);
//    }

    public void getConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=duan1;user=sa;password=sa2008");
            st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery("Select * from TuVung");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
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
        Top = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Main = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lblImg = new javax.swing.JLabel();
        lblMaTV = new javax.swing.JLabel();
        Option = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnPrevious = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        txtTV = new javax.swing.JTextField();
        txtPro = new javax.swing.JTextField();
        txtVN = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(800, 500));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 102), 1, true));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(new java.awt.BorderLayout());

        Top.setBackground(new java.awt.Color(255, 255, 204));
        Top.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153))));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Đánh dấu từ đã học");
        jLabel1.setAutoscrolls(true);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/star_icon.png"))); // NOI18N
        jLabel2.setAutoscrolls(true);
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/1646012_cancel_delete_error_exit_remove_icon.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/speaker.png"))); // NOI18N

        javax.swing.GroupLayout TopLayout = new javax.swing.GroupLayout(Top);
        Top.setLayout(TopLayout);
        TopLayout.setHorizontalGroup(
            TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 488, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addContainerGap())
        );
        TopLayout.setVerticalGroup(
            TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(TopLayout.createSequentialGroup()
                        .addGroup(TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel1.add(Top, java.awt.BorderLayout.PAGE_START);

        Main.setBackground(new java.awt.Color(255, 255, 255));
        Main.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), javax.swing.BorderFactory.createEmptyBorder(30, 50, 30, 50)));
        Main.setPreferredSize(new java.awt.Dimension(550, 460));
        Main.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true)));
        jPanel4.setLayout(new java.awt.BorderLayout());
        jPanel4.add(lblImg, java.awt.BorderLayout.CENTER);

        lblMaTV.setBackground(new java.awt.Color(127, 255, 212));
        lblMaTV.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblMaTV.setText("CÂU");
        lblMaTV.setOpaque(true);
        lblMaTV.setPreferredSize(new java.awt.Dimension(34, 40));
        jPanel4.add(lblMaTV, java.awt.BorderLayout.PAGE_START);

        Main.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel1.add(Main, java.awt.BorderLayout.CENTER);

        Option.setBackground(new java.awt.Color(127, 255, 212));
        Option.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        Option.setPreferredSize(new java.awt.Dimension(300, 460));
        Option.setLayout(new java.awt.BorderLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 60, 30);
        flowLayout1.setAlignOnBaseline(true);
        jPanel5.setLayout(flowLayout1);

        btnPrevious.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/9554501_arrow_left_navigation_gps_direction_icon.png"))); // NOI18N
        btnPrevious.setPreferredSize(new java.awt.Dimension(50, 50));
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });
        jPanel5.add(btnPrevious);

        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/9554506_arrow_right_next_navigation_pointer_icon.png"))); // NOI18N
        btnNext.setPreferredSize(new java.awt.Dimension(50, 50));
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        jPanel5.add(btnNext);

        Option.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel6.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), javax.swing.BorderFactory.createEmptyBorder(20, 20, 10, 10)));
        jPanel6.setOpaque(false);
        jPanel6.setPreferredSize(new java.awt.Dimension(348, 200));
        jPanel6.setLayout(new java.awt.GridLayout(3, 0, 20, 20));

        txtTV.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtTV.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel6.add(txtTV);

        txtPro.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtPro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel6.add(txtPro);

        txtVN.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtVN.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel6.add(txtVN);

        Option.add(jPanel6, java.awt.BorderLayout.PAGE_START);

        jPanel1.add(Option, java.awt.BorderLayout.EAST);

        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(925, 50));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 798, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        try {
            if (!rs.isLast()) {
                rs.next();
                count += 1;
                //lblMaTV.setText("Câu " + rs.getString(1) + ":");
                txtTV.setText(rs.getString(2));
                txtPro.setText(rs.getString(3));
                txtVN.setText(rs.getString(4));
                byte[] img = rs.getBytes(5);
                ImageIcon imgIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(lblImg.getWidth(), lblImg.getHeight(), Image.SCALE_SMOOTH));
                lblImg.setIcon(imgIcon);
                img_DATA = img;
                voiceLBL();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        try {
            if (!rs.isFirst()) {
                rs.previous();
                count += 1;
                lblMaTV.setText("Câu " + rs.getString(1) + ":");
                txtTV.setText(rs.getString(2));
                txtPro.setText(rs.getString(3));
                txtVN.setText(rs.getString(4));
                byte[] img = rs.getBytes(5);
                ImageIcon imgIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(lblImg.getWidth(), lblImg.getHeight(), Image.SCALE_SMOOTH));
                lblImg.setIcon(imgIcon);
                img_DATA = img;
            }
        } catch (Exception e) {
        }
        voiceLBL();
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        try {
            String url = "insert into TuDaHoc values (?)";
            pst = con.prepareStatement(url);
            pst.setString(1, lblMaTV.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Lưu dữ liệu thành công.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        frmMain g = new frmMain();
        g.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jLabel3MouseClicked

    public void loadTest() {
        try {
            rs.first();
            //lblMaTV.setText("Câu " + rs.getString(1) + ":");
            txtTV.setText(rs.getString(2));
            txtPro.setText(rs.getString(3));
            txtVN.setText(rs.getString(4));
            byte[] img = rs.getBytes(5);
            ImageIcon imgIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(lblImg.getWidth(), lblImg.getHeight(), Image.SCALE_SMOOTH));
            lblImg.setIcon(imgIcon);
            img_DATA = img;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        voiceLBL();
    }

    public void voiceLBL() {
        Voice voice;
        VoiceManager vm = VoiceManager.getInstance();
        voice = vm.getVoice(VOICENAME);

        voice.allocate();

        try {
            voice.speak(txtTV.getText());
        } catch (Exception e) {
        }
    }

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
            java.util.logging.Logger.getLogger(learnAll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(learnAll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(learnAll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(learnAll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new learnAll().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Main;
    private javax.swing.JPanel Option;
    private javax.swing.JPanel Top;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lblImg;
    private javax.swing.JLabel lblMaTV;
    private javax.swing.JTextField txtPro;
    private javax.swing.JTextField txtTV;
    private javax.swing.JTextField txtVN;
    // End of variables declaration//GEN-END:variables
}
