/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manegement;

import ct239.frmMain;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class quizDT1 extends javax.swing.JFrame {

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
    
    private String username;

    public quizDT1() {
        initComponents();
        //this.username = username;
        getConnection();
        loadData();
        loadTest();
        loadchay();
        this.setResizable(false);
        btnSubmit.setEnabled(false);
    }

//    private quizDT1() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    public void getConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=duan1;user=sa;password=sa2008");
            st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery("Select TOP 10 * from CauHoiTN where TenChuDe = 'Animal'");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    
    public void getConnection1() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=duan1;user=sa;password=sa2008");
            st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery("Select TOP 10 * from CauHoiTN where TenChuDe = 'Animal'");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public void loadchay() {
        t = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cong++;
                ProgressBar1.setValue(cong);
                if (cong == 100) {
                    t.stop();
                }
            }
        });
        t.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Top = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lblSumQuiz = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblSumTime = new javax.swing.JLabel();
        Main = new javax.swing.JPanel();
        Header = new javax.swing.JPanel();
        ProgressBar1 = new javax.swing.JProgressBar();
        DapAn = new javax.swing.JPanel();
        txtAnswer = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        lblImg = new javax.swing.JLabel();
        lblMaCH = new javax.swing.JLabel();
        Option = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnNext = new javax.swing.JButton();
        btnSubmit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 191, 255));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(900, 643));

        Top.setBackground(new java.awt.Color(0, 191, 255));
        Top.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Top.setPreferredSize(new java.awt.Dimension(1100, 63));
        java.awt.FlowLayout flowLayout3 = new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 10);
        flowLayout3.setAlignOnBaseline(true);
        Top.setLayout(flowLayout3);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tổng số câu hỏi: ");
        jLabel5.setPreferredSize(new java.awt.Dimension(138, 35));
        Top.add(jLabel5);

        lblSumQuiz.setBackground(new java.awt.Color(255, 255, 255));
        lblSumQuiz.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblSumQuiz.setOpaque(true);
        lblSumQuiz.setPreferredSize(new java.awt.Dimension(120, 35));
        Top.add(lblSumQuiz);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Thời gian: ");
        jLabel4.setPreferredSize(new java.awt.Dimension(90, 35));
        Top.add(jLabel4);

        lblSumTime.setBackground(new java.awt.Color(255, 255, 255));
        lblSumTime.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblSumTime.setOpaque(true);
        lblSumTime.setPreferredSize(new java.awt.Dimension(120, 35));
        Top.add(lblSumTime);

        getContentPane().add(Top, java.awt.BorderLayout.PAGE_START);

        Main.setBackground(new java.awt.Color(245, 245, 220));
        Main.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), javax.swing.BorderFactory.createEmptyBorder(20, 70, 20, 70)));
        Main.setPreferredSize(new java.awt.Dimension(800, 550));
        Main.setLayout(new java.awt.BorderLayout(30, 30));

        Header.setPreferredSize(new java.awt.Dimension(0, 30));
        Header.setLayout(new java.awt.BorderLayout());

        ProgressBar1.setForeground(new java.awt.Color(0, 255, 51));
        ProgressBar1.setValue(10);
        ProgressBar1.setPreferredSize(new java.awt.Dimension(146, 30));
        Header.add(ProgressBar1, java.awt.BorderLayout.PAGE_START);

        Main.add(Header, java.awt.BorderLayout.PAGE_START);

        DapAn.setBackground(new java.awt.Color(255, 255, 255));
        DapAn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        DapAn.setOpaque(false);
        DapAn.setPreferredSize(new java.awt.Dimension(173, 100));
        DapAn.setLayout(new java.awt.GridLayout(2, 0));

        txtAnswer.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtAnswer.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAnswer.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtAnswer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAnswerActionPerformed(evt);
            }
        });
        DapAn.add(txtAnswer);

        Main.add(DapAn, java.awt.BorderLayout.PAGE_END);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        jPanel1.setPreferredSize(new java.awt.Dimension(594, 300));
        jPanel1.setLayout(new java.awt.BorderLayout(10, 10));
        jPanel1.add(lblImg, java.awt.BorderLayout.CENTER);

        lblMaCH.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblMaCH.setText("      CÂU ");
        jPanel1.add(lblMaCH, java.awt.BorderLayout.PAGE_START);

        Main.add(jPanel1, java.awt.BorderLayout.CENTER);

        getContentPane().add(Main, java.awt.BorderLayout.CENTER);

        Option.setBackground(new java.awt.Color(255, 255, 255));
        Option.setPreferredSize(new java.awt.Dimension(250, 550));
        Option.setLayout(new java.awt.BorderLayout());

        jPanel3.setOpaque(false);
        java.awt.FlowLayout flowLayout2 = new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 40);
        flowLayout2.setAlignOnBaseline(true);
        jPanel3.setLayout(flowLayout2);

        btnNext.setBackground(new java.awt.Color(240, 230, 140));
        btnNext.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnNext.setText("Next");
        btnNext.setPreferredSize(new java.awt.Dimension(100, 40));
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        jPanel3.add(btnNext);

        btnSubmit.setBackground(new java.awt.Color(240, 230, 140));
        btnSubmit.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnSubmit.setText("Submit");
        btnSubmit.setPreferredSize(new java.awt.Dimension(100, 40));
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        jPanel3.add(btnSubmit);

        Option.add(jPanel3, java.awt.BorderLayout.CENTER);

        getContentPane().add(Option, java.awt.BorderLayout.EAST);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        if (count == 9) {
            JOptionPane.showMessageDialog(this, "Đã hoàn thành số câu hỏi kiểm tra.");
            btnNext.setEnabled(false);
            btnSubmit.setEnabled(true);
        }
        if (txtAnswer.equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng lựa chọn đáp án.");
            btnNext.setEnabled(false);
        } else {
            try {
                if (!rs.isLast()) {
                    rs.next();
                    count += 1;
                    lblMaCH.setText("Câu " + rs.getString("MaCHTN") + ":");
                    byte[] img = rs.getBytes(7);
                    ImageIcon imgIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(lblImg.getWidth(), lblImg.getHeight(), Image.SCALE_SMOOTH));
                    lblImg.setIcon(imgIcon);
                    img_DATA = img;
                }
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        String sum = Integer.toString(point);
        JOptionPane.showMessageDialog(this, sum);
        frmMain g = new frmMain();
        g.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void txtAnswerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAnswerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnswerActionPerformed

    public void loadTest() {
        try {
            rs.first();
            lblMaCH.setText("Câu " + rs.getString("MaCHTN") + ":");
            byte[] img = rs.getBytes("HinhAnh");
            ImageIcon imgIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(lblImg.getWidth(), lblImg.getHeight(), Image.SCALE_SMOOTH));
            lblImg.setIcon(imgIcon);
            img_DATA = img;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void loadData() {
        sumQuiz();
    }
    
    public void sumQuiz() {
        try {
            int temp = 0;
            while (!rs.isLast()) {
                rs.next();
                temp += 1;
            }
            String sum = Integer.toString(temp);
            lblSumQuiz.setText(sum);
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
            java.util.logging.Logger.getLogger(quizDT1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(quizDT1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(quizDT1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(quizDT1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new quizDT1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DapAn;
    private javax.swing.JPanel Header;
    private javax.swing.JPanel Main;
    private javax.swing.JPanel Option;
    private javax.swing.JProgressBar ProgressBar1;
    private javax.swing.JPanel Top;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblImg;
    private javax.swing.JLabel lblMaCH;
    private javax.swing.JLabel lblSumQuiz;
    private javax.swing.JLabel lblSumTime;
    private javax.swing.JTextField txtAnswer;
    // End of variables declaration//GEN-END:variables
}
