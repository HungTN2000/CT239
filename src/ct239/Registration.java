/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ct239;

import ct239.frmLogin;
import java.awt.Color;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import user.Connect;

/**
 *
 * @author HP
 */
public class Registration extends javax.swing.JFrame {

    frmLogin login = new frmLogin();

    Connect a = new Connect();
    Connection con = a.getConnection();
    Statement st = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public Registration() {
        initComponents();
        setTitle("Form Registration");
        setLocationRelativeTo(null);
        //setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        backgroundgBuild();
    }

    public void backgroundgBuild() {
        ImageIcon MyImage = new ImageIcon("C:\\Java-JSP\\duan9\\src\\img\\Background\\1.jpg");
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(lblBackground.getWidth(), lblBackground.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        lblBackground.setIcon(image);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngGT = new javax.swing.ButtonGroup();
        pnlBUILD = new javax.swing.JPanel();
        pnlTOP = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        pnlCENTER = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        rdbMale = new javax.swing.JRadioButton();
        rdbFemale = new javax.swing.JRadioButton();
        txtDiaChi = new javax.swing.JTextField();
        txtDate = new com.toedter.calendar.JDateChooser();
        txtSDT = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtPWD = new javax.swing.JPasswordField();
        txtTaiKhoan = new javax.swing.JTextField();
        pnlBOTTOM = new javax.swing.JPanel();
        btnRegistration = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlBUILD.setOpaque(false);
        pnlBUILD.setLayout(new java.awt.BorderLayout());

        pnlTOP.setOpaque(false);
        pnlTOP.setPreferredSize(new java.awt.Dimension(646, 80));
        pnlTOP.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ĐĂNG KÝ TÀI KHOẢN");
        jLabel1.setPreferredSize(new java.awt.Dimension(41, 80));
        pnlTOP.add(jLabel1, java.awt.BorderLayout.CENTER);

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        pnlTOP.add(jSeparator2, java.awt.BorderLayout.PAGE_END);

        pnlBUILD.add(pnlTOP, java.awt.BorderLayout.PAGE_START);

        pnlCENTER.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 40, 10, 40));
        pnlCENTER.setOpaque(false);
        pnlCENTER.setPreferredSize(new java.awt.Dimension(560, 500));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("HỌ VÀ TÊN");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("GIỚI TÍNH");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ĐỊA CHỈ");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("NGÀY SINH");

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("SĐT");

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("EMAIL");

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("NHẬP MẬT KHẨU");

        jLabel9.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("TÊN TÀI KHOẢN");

        txtName.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N

        btngGT.add(rdbMale);
        rdbMale.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N
        rdbMale.setForeground(new java.awt.Color(255, 255, 255));
        rdbMale.setText("NAM");

        btngGT.add(rdbFemale);
        rdbFemale.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N
        rdbFemale.setForeground(new java.awt.Color(255, 255, 255));
        rdbFemale.setText("NỮ");

        txtDiaChi.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N

        txtDate.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N

        txtSDT.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N

        txtEmail.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N

        txtPWD.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N

        txtTaiKhoan.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N

        javax.swing.GroupLayout pnlCENTERLayout = new javax.swing.GroupLayout(pnlCENTER);
        pnlCENTER.setLayout(pnlCENTERLayout);
        pnlCENTERLayout.setHorizontalGroup(
            pnlCENTERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCENTERLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCENTERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCENTERLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtName))
                    .addGroup(pnlCENTERLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDiaChi))
                    .addGroup(pnlCENTERLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlCENTERLayout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSDT))
                    .addGroup(pnlCENTERLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmail))
                    .addGroup(pnlCENTERLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPWD))
                    .addGroup(pnlCENTERLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdbMale)
                        .addGap(18, 18, 18)
                        .addComponent(rdbFemale)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlCENTERLayout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTaiKhoan)))
                .addContainerGap())
        );
        pnlCENTERLayout.setVerticalGroup(
            pnlCENTERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCENTERLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCENTERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCENTERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdbMale, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdbFemale, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCENTERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCENTERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCENTERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCENTERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCENTERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCENTERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPWD, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlBUILD.add(pnlCENTER, java.awt.BorderLayout.CENTER);

        pnlBOTTOM.setOpaque(false);
        pnlBOTTOM.setPreferredSize(new java.awt.Dimension(550, 130));

        btnRegistration.setBackground(new java.awt.Color(255, 0, 0));
        btnRegistration.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnRegistration.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistration.setText("SUBMIT");
        btnRegistration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrationActionPerformed(evt);
            }
        });

        btnLogin.setBackground(new java.awt.Color(0, 191, 255));
        btnLogin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("LOGIN");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel10.setFont(new java.awt.Font("Serif", 3, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Đã có tài khoản quay lại");

        javax.swing.GroupLayout pnlBOTTOMLayout = new javax.swing.GroupLayout(pnlBOTTOM);
        pnlBOTTOM.setLayout(pnlBOTTOMLayout);
        pnlBOTTOMLayout.setHorizontalGroup(
            pnlBOTTOMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBOTTOMLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlBOTTOMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRegistration, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBOTTOMLayout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLogin)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jSeparator1)
        );
        pnlBOTTOMLayout.setVerticalGroup(
            pnlBOTTOMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBOTTOMLayout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegistration, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlBOTTOMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );

        pnlBUILD.add(pnlBOTTOM, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(pnlBUILD, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 570));
        getContentPane().add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        login.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnRegistrationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrationActionPerformed
        boolean name_control = false;
        boolean email_control = false;

        StringBuilder sb = new StringBuilder();

        try {
            if (txtName.getText().equals("") || txtDiaChi.getText().equals("") || txtTaiKhoan.getText().equals("")
                    || txtEmail.getText().equals("") || txtSDT.getText().equals("") || txtPWD.getText().equals("")) {
                if (txtName.getText().equals("") && txtDiaChi.getText().equals("") && txtTaiKhoan.getText().equals("")
                        | txtEmail.getText().equals("") && txtSDT.getText().equals("") && txtPWD.getText().equals("")) {
                    JOptionPane.showMessageDialog(login, "Dữ liệu không được bỏ trống.");
                }
                checkEmpty(sb);
                if (sb.length() > 0) {
                    JOptionPane.showMessageDialog(this, sb.toString(), "Invalidation", JOptionPane.ERROR_MESSAGE);
                }
            } else if (txtEmail.getText().indexOf("\\w+@\\w+\\.\\w+") == -1) {
                JOptionPane.showMessageDialog(login, "Email is wrong.");
            } else if (name_control | email_control) {
                JOptionPane.showMessageDialog(login, "This user is already registered.");
            } else {
                String url = "Insert into users values(?,?,?,?,?,?,?,?)";
                pst = con.prepareStatement(url);
                pst.setString(1, txtTaiKhoan.getText());
                pst.setString(2, txtName.getText());
                pst.setString(3, txtDiaChi.getText());
                if (rdbMale.isSelected()) {
                    pst.setBoolean(4, true);
                } else {
                    pst.setBoolean(4, false);
                }
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String date = sdf.format(txtDate.getDate());
                pst.setString(5, date);
                pst.setString(6, txtEmail.getText());
                pst.setString(7, txtSDT.getText());
                pst.setString(8, txtPWD.getText());
                int check = pst.executeUpdate();

                if (check > 0) {
                    JOptionPane.showMessageDialog(login, "Registration Successful.");
                }

                setVisible(false);
                login.setVisible(true);//để hiển thị màn hình form đăng nhập
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnRegistrationActionPerformed

    public void checkEmpty(StringBuilder sb) {
        checkTK(sb);
        checkName(sb);
        checkDC(sb);
        checkSDT(sb);
        checkEmail(sb);
        checkPWD(sb);
        checkDate(sb);
    }

    public void checkTK(StringBuilder sb) {
        if (txtTaiKhoan.getText().equals("")) {
            txtTaiKhoan.setBackground(Color.yellow);
            sb.append("Tài khoản chưa nhập.\n");
        } else {
            txtTaiKhoan.setBackground(Color.white);
        }
    }

    public void checkName(StringBuilder sb) {
        if (txtName.getText().equals("")) {
            txtName.setBackground(Color.yellow);
            sb.append("Họ tên chưa nhập.\n");
        } else {
            txtName.setBackground(Color.white);
        }
    }

    public void checkDC(StringBuilder sb) {
        if (txtDiaChi.getText().equals("")) {
            txtDiaChi.setBackground(Color.yellow);
            sb.append("Địa chỉ chưa nhập.\n");
        } else {
            txtDiaChi.setBackground(Color.white);
        }
    }

    // Ham kiem tra dinh dang so dien thoai
    public void checkSDT(StringBuilder sb) {
        String sdt = txtSDT.getText();
        // Bieu thuc chinh quy mo ta dinh dang so dien thoai
        String reg = "^[0-9]{10}$";
        // Kiem tra dinh dang
        Pattern p = Pattern.compile(reg);
        if (p.matcher(sdt).find()) {
            sb.append("phone ok");
        }
//        boolean kt = str.matches(reg);
        //
        //        if (kt == false) {
        //            throw new PhoneException("Loi: Khong dung dinh dang!");
        //        } else {
        //            System.out.println("Dung dinh dang so dien thoai!");
        //        }
        {
            if (txtSDT.getText().equals("")) {
                txtSDT.setBackground(Color.yellow);
                sb.append("Số điện thoại chưa nhập.\n");
            } else {
                txtSDT.setBackground(Color.white);
            }
        }
    }

    public void checkPWD(StringBuilder sb) {
        if (txtPWD.getText().equals("")) {
            txtPWD.setBackground(Color.yellow);
            sb.append("Mật khẩu chưa nhập.\n");
        } else {
            txtPWD.setBackground(Color.white);
        }
    }

    public void checkDate(StringBuilder sb) {
        Date date = txtDate.getDate();
        if (date == null) {
            txtDate.setBackground(Color.yellow);
            //JOptionPane.showMessageDialog(this, "MSSV CHƯA NHẬP!");
            sb.append("Ngày sinh chưa nhập.\n");
        } else {
            txtDate.setBackground(Color.white);
        }
    }
    
    public void checkEmail(StringBuilder sb) {
        if (txtEmail.getText().equals("")) {
            txtEmail.setBackground(Color.yellow);
            sb.append("Email chưa nhập.\n");
        } else {
            txtEmail.setBackground(Color.white);
        }
    }

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
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnRegistration;
    private javax.swing.ButtonGroup btngGT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JPanel pnlBOTTOM;
    private javax.swing.JPanel pnlBUILD;
    private javax.swing.JPanel pnlCENTER;
    private javax.swing.JPanel pnlTOP;
    private javax.swing.JRadioButton rdbFemale;
    private javax.swing.JRadioButton rdbMale;
    private com.toedter.calendar.JDateChooser txtDate;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPWD;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTaiKhoan;
    // End of variables declaration//GEN-END:variables
}
