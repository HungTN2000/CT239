/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ct239;

import data_class.frmReg;
import ct239.gui_efk;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import user.DatabaseConnection;

/**
 *
 * @author HP
 */
public class frmLogin extends javax.swing.JFrame {

    public frmLogin() {
        initComponents();
        setLocationRelativeTo(null);
        //setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        bgBuild();
        this.lbleye_hiden.setVisible(false);
    }
    
    public void bgBuild() {
        ImageIcon MyImage = new ImageIcon("C:\\Java-JSP\\duan9\\src\\img\\Background\\7.jpg");
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(lblImg.getWidth(), lblImg.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        lblImg.setIcon(image);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLogin = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblTaiKhoan = new javax.swing.JLabel();
        txtTaiKhoan = new javax.swing.JTextField();
        lblPwd = new javax.swing.JLabel();
        txtPwd = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        cbbChoose = new javax.swing.JComboBox<>();
        jCheckBox1 = new javax.swing.JCheckBox();
        lbleye = new javax.swing.JLabel();
        lbleye_hiden = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblSignUp = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblImg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFocusCycleRoot(false);

        panelLogin.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Algerian", 1, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(30, 144, 254));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("User Login");
        jLabel1.setPreferredSize(new java.awt.Dimension(81, 9));

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 30, 10, 30));
        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(250, 111));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTaiKhoan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTaiKhoan.setText("Tài Khoản");
        lblTaiKhoan.setPreferredSize(new java.awt.Dimension(60, 17));
        jPanel2.add(lblTaiKhoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 11, 100, 35));
        jPanel2.add(txtTaiKhoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 11, 231, 35));

        lblPwd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblPwd.setText("Mật Khẩu");
        jPanel2.add(lblPwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 56, 100, 35));
        jPanel2.add(txtPwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 56, 231, 35));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Lựa Chọn");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 133, 100, 35));

        cbbChoose.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cbbChoose.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "choose", "admin", "student" }));
        jPanel2.add(cbbChoose, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 133, 119, 35));

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jCheckBox1.setText("Show password");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 100, -1, -1));

        lbleye.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/eye.png"))); // NOI18N
        lbleye.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbleyeMousePressed(evt);
            }
        });
        jPanel2.add(lbleye, new org.netbeans.lib.awtextra.AbsoluteConstraints(389, 61, -1, 30));

        lbleye_hiden.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/eye_hide.png"))); // NOI18N
        lbleye_hiden.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbleye_hidenMousePressed(evt);
            }
        });
        jPanel2.add(lbleye_hiden, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 59, 30, -1));

        btnLogin.setBackground(new java.awt.Color(30, 144, 254));
        btnLogin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("ĐĂNG NHẬP");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setText("Quên mật khẩu ?");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("Bạn chưa có tài khoản ? Đăng ký");

        lblSignUp.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblSignUp.setForeground(new java.awt.Color(0, 102, 255));
        lblSignUp.setText("Tại đây");
        lblSignUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSignUpMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelLoginLayout = new javax.swing.GroupLayout(panelLogin);
        panelLogin.setLayout(panelLoginLayout);
        panelLoginLayout.setHorizontalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLoginLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btnLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLoginLayout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );
        panelLoginLayout.setVerticalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        getContentPane().add(panelLogin, java.awt.BorderLayout.CENTER);

        jPanel4.setPreferredSize(new java.awt.Dimension(600, 500));
        jPanel4.setLayout(new java.awt.BorderLayout());
        jPanel4.add(lblImg, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel4, java.awt.BorderLayout.WEST);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        frmReg register = new frmReg();
        String selectedItem = cbbChoose.getSelectedItem().toString();
        DatabaseConnection database = new DatabaseConnection();
        try {
            ResultSet rs = database.getStatement().executeQuery("Select * from NguoiDung WHERE MaND='" + txtTaiKhoan.getText() + "' and MatKhau='" + txtPwd.getText() + "'");
            if (rs.next()) {
                if (selectedItem.equals("student")) {
                    JOptionPane.showMessageDialog(register, "Login successful.");
                    gui_efk g = new gui_efk();
                    g.setVisible(true);
                    setVisible(false);
                }
                if (selectedItem.equals("admin")) {
                    JOptionPane.showMessageDialog(register, "Login successful.");
                    gui_efk g = new gui_efk();
                    g.setVisible(true);
                    setVisible(false);
                }
            } else {
                JOptionPane.showMessageDialog(register, "Incorrect username or password");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
       if(jCheckBox1.isSelected()) {
           txtPwd.setEchoChar((char)0);
       } else {
           txtPwd.setEchoChar('*');
       }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void lbleyeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbleyeMousePressed
        lbleye_hiden.setVisible(true);
        lbleye.setVisible(false);
        txtPwd.setEchoChar((char)0);
    }//GEN-LAST:event_lbleyeMousePressed

    private void lbleye_hidenMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbleye_hidenMousePressed
        lbleye.setVisible(true);
        lbleye_hiden.setVisible(false);
        txtPwd.setEchoChar('*');
    }//GEN-LAST:event_lbleye_hidenMousePressed

    private void lblSignUpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSignUpMouseClicked
        Registration reg = new Registration();
        reg.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_lblSignUpMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JComboBox<String> cbbChoose;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblImg;
    private javax.swing.JLabel lblPwd;
    private javax.swing.JLabel lblSignUp;
    private javax.swing.JLabel lblTaiKhoan;
    private javax.swing.JLabel lbleye;
    private javax.swing.JLabel lbleye_hiden;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JPasswordField txtPwd;
    private javax.swing.JTextField txtTaiKhoan;
    // End of variables declaration//GEN-END:variables
}
