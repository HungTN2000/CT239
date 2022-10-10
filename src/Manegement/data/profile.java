/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manegement.data;

import Manegement.classData.listProfile;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;
import user.Connect;

/**
 *
 * @author HP
 */
public class profile extends javax.swing.JPanel {

    final String col[] = {"MÃ ND", "TÀI KHOẢN", "MẬT KHẨU", "HỌ VÀ TÊN", "GIỚI TÍNH", "NGÀY SINH", "ĐỊA CHỈ", "SỐ ĐIỆN THOẠI", "EMAIL"};
    final DefaultTableModel tbn = new DefaultTableModel(col, 0);
    Connect a = new Connect();
    Connection con = a.getConnection();
    Statement st = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public profile() {
        initComponents();
        dataEnabledButton();
        loadData();
    }

    public void loadData() {
        try {
            int number;
            Vector row, column;
            column = new Vector();
            st = con.createStatement();
            rs = st.executeQuery("Select MaND, TaiKhoan, MatKhau, HoTen, GioiTinh = (CASE GioiTinh WHEN 'True' THEN N'Nam' \n"
                    + "WHEN 'False' THEN N'Nữ' END), NgaySinh, DiaChi, SDT, Email from NguoiDung");
            ResultSetMetaData metadata = rs.getMetaData();
            number = metadata.getColumnCount(); //trả về số cột
            tbn.setRowCount(0);

//            for (int i = 1; i <= number; i++) {
//                column.add(metadata.getColumnName(i)); //lấy ra tiêu đề của các cột
//            }
//            tbn.setColumnIdentifiers(column);
            while (rs.next()) {
                row = new Vector();
                for (int i = 1; i <= number; i++) {
                    row.addElement(rs.getString(i));
                }
                tbn.addRow(row);
                tblProfile.setModel(tbn);
            }
            tblProfile.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (tblProfile.getSelectedRow() >= 0) {
                        txtMaND.setText(tblProfile.getValueAt(tblProfile.getSelectedRow(), 0) + "");
                        txtTaiKhoan.setText(tblProfile.getValueAt(tblProfile.getSelectedRow(), 1) + "");
                        txtMatKhau.setText(tblProfile.getValueAt(tblProfile.getSelectedRow(), 2) + "");
                        txtHoTen.setText(tblProfile.getValueAt(tblProfile.getSelectedRow(), 3) + "");
                        String gt = tblProfile.getValueAt(tblProfile.getSelectedRow(), 4).toString();
                        if (gt.equals("Nam")) {
                            rdbMale.setSelected(true);
                        } else {
                            rdbFemale.setSelected(true);
                        }
                        try {
                            Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String) tblProfile.getValueAt(tblProfile.getSelectedRow(), 5).toString());
                            txtDate.setDate(date);
                        } catch (ParseException ex) {
                            Logger.getLogger(profile.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        txtDiaChi.setText(tblProfile.getValueAt(tblProfile.getSelectedRow(), 6) + "");
                        txtSDT.setText(tblProfile.getValueAt(tblProfile.getSelectedRow(), 7) + "");
                        txtEmail.setText(tblProfile.getValueAt(tblProfile.getSelectedRow(), 8) + "");

                        if (btnAdd.isSelected() == true || btnAdd.isSelected() == false) {
                            btnAdd.setEnabled(false);
                            dataNotEnabledButton();
                        }
                    }
                }
            });
            loadDataCBBSearchID();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        JTableHeader Theader = tblProfile.getTableHeader();
        
        Theader.setBackground(new Color(255,215,0));
        Theader.setForeground(Color.black);
        
        Theader.setFont(new Font("Tahome", Font.PLAIN, 16));
        ((DefaultTableCellRenderer)Theader.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        
        tblProfile.setFont(new Font("Tahome", Font.PLAIN, 16));
    }

    public void loadDataCBBSearchID() {
        try {
            pst = con.prepareStatement("Select MaND from NguoiDung");
            rs = pst.executeQuery();

            //Tạo 1 DefaultComboboxModel
            DefaultComboBoxModel SeMSSV = (DefaultComboBoxModel) cbbSearchID.getModel();
            SeMSSV.removeAllElements(); //Xóa hết dữ liệu trong combobox
            while (rs.next()) {
                cbbSearchID.addItem(rs.getString("MaND"));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi lấy maND!");
        }
    }

    public ArrayList<listProfile> listProfileUsers() {
        ArrayList<listProfile> adList = new ArrayList<>();
        try {
            String url = "Select * from NguoiDung";
            st = con.createStatement();
            rs = st.executeQuery(url);
            listProfile data;
            while (rs.next()) {
                data = new listProfile(rs.getString("MaND"), rs.getString("TaiKhoan"), rs.getString("MatKhau"), rs.getString("HoTen"), true, rs.getString("GioiTinh"), rs.getString("NgaySinh"), rs.getString("SDT"), rs.getString("Email"));
                adList.add(data);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return adList;
    }

    public void show_ad() {
        ArrayList<listProfile> listPFShow = listProfileUsers();
        DefaultTableModel model = (DefaultTableModel) tblProfile.getModel();
        Object[] row = new Object[9];
        for (int i = 0; i < listPFShow.size(); i++) {
            row[0] = listPFShow.get(i).getMaND();
            row[1] = listPFShow.get(i).getTaikhoan();
            row[2] = listPFShow.get(i).getMatKhau();
            row[3] = listPFShow.get(i).getHoTen();
            row[4] = listPFShow.get(i).isGioiTinh();
            row[5] = listPFShow.get(i).getDiaChi();
            row[6] = listPFShow.get(i).getNgaySinh();
            row[7] = listPFShow.get(i).getSDT();
            row[8] = listPFShow.get(i).getEmail();
            model.addRow(row);
        }
    }

    public void getConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=duan1;user=sa;password=sa2008");
            st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery("select * from NguoiDung");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProfile = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtMaND = new javax.swing.JTextField();
        txtMatKhau = new javax.swing.JPasswordField();
        txtSDT = new javax.swing.JTextField();
        txtHoTen = new javax.swing.JTextField();
        rdbMale = new javax.swing.JRadioButton();
        rdbFemale = new javax.swing.JRadioButton();
        txtDiaChi = new javax.swing.JTextField();
        txtDate = new com.toedter.calendar.JDateChooser();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTaiKhoan = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        cbbSearchID = new javax.swing.JComboBox<>();
        jSeparator2 = new javax.swing.JSeparator();
        btnReset = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 250, 240));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 102), 1, true));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Bảng Dữ Liệu Thông Tin Người Dùng");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jLabel1.setOpaque(true);

        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jScrollPane1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        tblProfile.setAutoCreateRowSorter(true);
        tblProfile.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tblProfile.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tblProfile.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MÃ ND", "TÀI KHOẢN", "MẬT KHẨU", "HỌ VÀ TÊN", "GIỚI TÍNH", "NGÀY SINH", "ĐỊA CHỈ", "SDT", "EMAIL"
            }
        ));
        tblProfile.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblProfile.setFillsViewportHeight(true);
        tblProfile.setRowHeight(30);
        tblProfile.setSelectionBackground(new java.awt.Color(72, 209, 204));
        tblProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProfileMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProfile);

        jPanel1.setBackground(new java.awt.Color(250, 250, 210));
        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Mã Người Dùng");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("Mật Khẩu");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("Số điện thoại");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setText("Họ và Tên");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel7.setText("Giới Tính");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel8.setText("Địa Chỉ");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel9.setText("Ngày Sinh");

        txtMaND.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        txtMatKhau.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMatKhauActionPerformed(evt);
            }
        });

        txtSDT.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtSDT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSDTKeyPressed(evt);
            }
        });

        txtHoTen.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        buttonGroup1.add(rdbMale);
        rdbMale.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        rdbMale.setText("NAM");
        rdbMale.setOpaque(false);

        buttonGroup1.add(rdbFemale);
        rdbFemale.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        rdbFemale.setText("NỮ");
        rdbFemale.setOpaque(false);

        txtDiaChi.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        txtDate.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        lblEmail.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblEmail.setText("Email");

        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setText("Tài Khoản");
        jLabel6.setPreferredSize(new java.awt.Dimension(65, 35));

        txtTaiKhoan.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMaND, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(txtMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(txtEmail)
                    .addComponent(txtSDT, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(txtTaiKhoan))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rdbMale)
                        .addGap(18, 18, 18)
                        .addComponent(rdbFemale))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaND, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTaiKhoan))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdbMale, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdbFemale, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        btnAdd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAdd.setText("THÊM");
        btnAdd.setPreferredSize(new java.awt.Dimension(120, 45));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSave.setText("LƯU");
        btnSave.setPreferredSize(new java.awt.Dimension(120, 45));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnEdit.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnEdit.setText("SỬA");
        btnEdit.setPreferredSize(new java.awt.Dimension(120, 45));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnDelete.setText("XÓA");
        btnDelete.setPreferredSize(new java.awt.Dimension(120, 45));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSearch.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSearch.setText("Tìm kiếm");
        btnSearch.setPreferredSize(new java.awt.Dimension(120, 45));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        txtSearch.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        cbbSearchID.setEditable(true);
        cbbSearchID.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cbbSearchID.setMaximumRowCount(5);

        btnReset.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnReset.setText("LÀM MỚI");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbbSearchID, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                    .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                    .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 238, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jSeparator2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                        .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                    .addComponent(cbbSearchID, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        btnAdd.setEnabled(false);
        dataNotEnabledButton();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        StringBuilder sb = new StringBuilder();
        try {
            if (txtMaND.getText().equals("") || txtMatKhau.getText().equals("") || txtHoTen.getText().equals("")
                    || txtDiaChi.getText().equals("") || txtSDT.getText().equals("") || txtEmail.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Dữ liệu không được bỏ trống!");
            } else {
                hopleMaND(sb);
                hopleTaiKhoan(sb);
                hopleMatKhau(sb);
                hopleEmail(sb);
                hopleSDT(sb);
                if (sb.length() > 0) { //nếu if trên đúng nó sẽ thêm vào sb 1 đoạn string, ktra độ dài chuỗi này nếu lớn hơn 0 tức là có thông báo
                    JOptionPane.showMessageDialog(this, sb.toString());
                } else {
                    String url = "insert into NguoiDung values (?,?,?,?,?,?,?,?,?)";
                    pst = con.prepareStatement(url);
                    pst.setString(1, txtMaND.getText());
                    pst.setString(2, txtTaiKhoan.getText());
                    pst.setString(3, txtMatKhau.getText());
                    pst.setString(4, txtHoTen.getText());
                    if (rdbMale.isSelected()) {
                        pst.setBoolean(5, true);
                    } else {
                        pst.setBoolean(5, false);
                    }
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String date = sdf.format(txtDate.getDate());
                    pst.setString(6, date);
                    pst.setString(7, txtDiaChi.getText());
                    pst.setString(8, txtSDT.getText());
                    pst.setString(9, txtEmail.getText());
                    pst.executeUpdate();
                    loadData();//trước khi loadData cần sét số cột về 0 nếu không nó sẽ loadData lên bảng thêm 1 lần nữa
                    JOptionPane.showMessageDialog(null, "Lưu thành công!");
                    btnAdd.setEnabled(true);
                    dataEnabledButton();
                    reset();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        try {
            pst = con.prepareStatement("Update NguoiDung set TaiKhoan=?,MatKhau=?, HoTen=?, GioiTinh=?, NgaySinh=?, DiaChi=?, SDT=?, Email=? where MaND=?");
            pst.setString(9, txtMaND.getText());
            pst.setString(1, txtTaiKhoan.getText());
            pst.setString(2, txtMatKhau.getText());
            pst.setString(3, txtHoTen.getText());
            if (rdbMale.isSelected()) {
                pst.setBoolean(4, true);
            } else {
                pst.setBoolean(4, false);
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(txtDate.getDate());
            pst.setString(5, date);
            pst.setString(6, txtDiaChi.getText());
            pst.setString(7, txtSDT.getText());
            pst.setString(8, txtEmail.getText());
            pst.executeUpdate();
            tbn.setRowCount(0);
            loadData();
            JOptionPane.showMessageDialog(this, "Cập nhật thành công.");
            btnAdd.setEnabled(true);
            dataEnabledButton();
            reset();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            pst = con.prepareStatement("Delete NguoiDung where MaND=?");
            pst.setString(1, tblProfile.getValueAt(tblProfile.getSelectedRow(), 0).toString());
            if (JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa?", "Confirm", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                pst.executeUpdate();
                DefaultTableModel model = (DefaultTableModel) tblProfile.getModel();
                model.setRowCount(0);
                loadData();;
                JOptionPane.showMessageDialog(this, "Xóa thành công");
                btnAdd.setEnabled(true);
                dataEnabledButton();
                reset();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Xóa thất bại");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tblProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProfileMouseClicked
//        int i = tblProfile.getSelectedRow();
//        DefaultTableModel model = (DefaultTableModel) tblProfile.getModel();
//
//        txtMaND.setText(model.getValueAt(i, 0).toString());
//        txtTaiKhoan.setText(model.getValueAt(i, 1).toString());
//        txtMatKhau.setText(model.getValueAt(i, 2).toString());
//        txtHoTen.setText(model.getValueAt(i, 3).toString());
//        String gt = model.getValueAt(i, 4).toString();
//        if (gt.equals("NAM")) {
//            rdbMale.setSelected(true);
//        } else {
//            rdbFemale.setSelected(true);
//        }
//        try {
//            int srow = tblProfile.getSelectedRow();
//            Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String) model.getValueAt(srow, 5));
//            dcDate.setDate(date);
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
//        }
//        txtDiaChi.setText(model.getValueAt(i, 6).toString());
//        txtSDT.setText(model.getValueAt(i, 7).toString());
//        txtEmail.setText(model.getValueAt(i, 8).toString());
    }//GEN-LAST:event_tblProfileMouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        try {
            pst = con.prepareStatement("Select * from NguoiDung where MaND=?");
            pst.setString(1, cbbSearchID.getSelectedItem().toString());
            rs = pst.executeQuery();
            while (rs.next()) {
                txtMaND.setText(rs.getString("MaND"));
                txtTaiKhoan.setText(rs.getString("TaiKhoan"));
                txtMatKhau.setText(rs.getString("MatKhau"));
                txtHoTen.setText(rs.getString("HoTen"));
                String gioiTinh = "NAM";
                if (gioiTinh.equals(rs.getString("GioiTinh"))) {
                    rdbMale.setSelected(true);
                } else {
                    rdbFemale.setSelected(false);
                }
                txtDate.setDate(rs.getDate("NgaySinh"));
                txtDiaChi.setText((String) rs.getString("DiaChi"));
                txtSDT.setText(rs.getString("SDT"));
                txtEmail.setText(rs.getString("Email"));
            }
            btnAdd.setEnabled(false);
            dataNotEnabledButton();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        reset();
    }//GEN-LAST:event_btnResetActionPerformed

    private void txtSDTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSDTKeyPressed
        String phoneNumber = txtSDT.getText();

        int lenght = phoneNumber.length();

        //Kiểm tra số điện thoại 0 đến 9
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
            //Kiểm tra độ dài không lớn hơn 10 số
            if (lenght <= 10) {
                txtSDT.setEditable(true);
                txtSDT.setBackground(Color.white);
            } else {
                txtSDT.setEditable(false);
                txtSDT.setBackground(Color.green);
            }
        } else {
            //Không cho phép "backsspace' và 'delete'
            if (evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                txtSDT.setEditable(true);
            } else {
                txtSDT.setEditable(false);
            }
        }
    }//GEN-LAST:event_txtSDTKeyPressed

    private void txtMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMatKhauActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMatKhauActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        DefaultTableModel model = (DefaultTableModel) tblProfile.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<DefaultTableModel>(model);
        tblProfile.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(txtSearch.getText().trim()));
    }//GEN-LAST:event_txtSearchKeyReleased

    public void dataEnabledButton() {
        btnSave.setEnabled(false);
        btnEdit.setEnabled(false);
        btnDelete.setEnabled(false);
        btnReset.setEnabled(false);
        txtMaND.setEnabled(false);
        txtTaiKhoan.setEnabled(false);
        txtMatKhau.setEnabled(false);
        txtHoTen.setEnabled(false);
        rdbMale.setEnabled(false);
        rdbFemale.setEnabled(false);
        txtDate.setEnabled(false);
        txtDiaChi.setEnabled(false);
        txtSDT.setEnabled(false);
        txtEmail.setEnabled(false);
    }

    public void dataNotEnabledButton() {
        btnSave.setEnabled(true);
        btnEdit.setEnabled(true);
        btnDelete.setEnabled(true);
        btnReset.setEnabled(true);
        txtMaND.setEnabled(true);
        txtTaiKhoan.setEnabled(true);
        txtMatKhau.setEnabled(true);
        txtHoTen.setEnabled(true);
        rdbMale.setEnabled(true);
        rdbFemale.setEnabled(true);
        txtDate.setEnabled(true);
        txtDiaChi.setEnabled(true);
        txtSDT.setEnabled(true);
        txtEmail.setEnabled(true);
    }

    public void reset() {
        txtMaND.setText("");
        txtTaiKhoan.setText("");
        txtMatKhau.setText("");
        txtHoTen.setText("");
        rdbMale.setSelected(false);
        rdbFemale.setSelected(false);
        txtDate.setDate(null);
        txtDiaChi.setText("");
        txtSDT.setText("");
        txtEmail.setText("");
        txtMaND.setBackground(Color.white);
        txtTaiKhoan.setBackground(Color.white);
        txtMatKhau.setBackground(Color.white);
        txtSDT.setBackground(Color.white);
        txtEmail.setBackground(Color.white);
    }

    private void hopleMaND(StringBuilder sb) {
        try {
            String check_url = "Select * from NguoiDung where MaND = '" + txtMaND.getText() + "'";
            st = con.createStatement();
            rs = st.executeQuery(check_url);

            //Kiểm tra trùng id
            if (rs.next()) {
                sb.append("Mã ND này đã tồn tại!\n");
                txtMaND.setBackground(Color.green);
            } else {
                String MaND = txtMaND.getText();
                //Mã ND phải gồm EFK và 3 chữ số
                String regex = "EFK\\d{3}";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(MaND);
                if (!matcher.find()) {
                    sb.append("Mã ND sai định dạng, Mã ND phải gồm EFK và 3 chữ số, VD: EFK001\n");
                    txtMaND.setBackground(Color.green);
                } else {
                    txtMaND.setBackground(Color.white);
                }
            }
        } catch (Exception e) {
        }
    }

    private void hopleTaiKhoan(StringBuilder sb) {
        try {
            String check_url = "Select * from NguoiDung where TaiKhoan = '" + txtTaiKhoan.getText() + "'";
            st = con.createStatement();
            rs = st.executeQuery(check_url);

            //Kiểm tra trùng id
            if (rs.next()) {
                sb.append("Tài khoản này đã tồn tại!\n");
                txtTaiKhoan.setBackground(Color.green);
            } else {
                //.*[A-Z] : phải có ít nhất 1 ký tự viết hoa
                Pattern patternUpper = Pattern.compile("^.*[A-Z]+.*$");

                //.*[a-z] : phải có ít nhất 1 ký tự viết thường
                Pattern patternLower = Pattern.compile("^.*[a-z]+.*$");

                //.*[0-9] : phải có ít nhất 1 ký tự số
                Pattern patternDigit = Pattern.compile("^.*[0-9]+.*$");

                //.*[#?!@$%^&*-] : phải có ít nhất 1 ký tự đặc biệt
                Pattern patternSpecial = Pattern.compile("^.*[#?!@$%^&*-]+.*$");

                //.*[#?!@$%^&*-] : phải có ít nhất 8 ký tự 
                Pattern patternLenght = Pattern.compile("^.*{8,}+.*$");

                String account = txtTaiKhoan.getText();

                if (patternUpper.matcher(account).find() || patternLower.matcher(account).find()
                        || patternDigit.matcher(account).find() || patternSpecial.matcher(account).find()
                        || patternLenght.matcher(account).find()) {
                    txtTaiKhoan.setBackground(Color.white);
                } else {
                    sb.append("Nhập lại tài khoản!.");
                    txtTaiKhoan.setBackground(Color.green);
                }
            }
        } catch (Exception e) {
        }
    }

    private void hopleMatKhau(StringBuilder sb) {
        //.*[A-Z] : phải có ít nhất 1 ký tự viết hoa
        Pattern patternUpper = Pattern.compile("^.*[A-Z]+.*$");

        //.*[a-z] : phải có ít nhất 1 ký tự viết thường
        Pattern patternLower = Pattern.compile("^.*[a-z]+.*$");

        //.*[0-9] : phải có ít nhất 1 ký tự số
        Pattern patternDigit = Pattern.compile("^.*[0-9]+.*$");

        //.*[#?!@$%^&*-] : phải có ít nhất 1 ký tự đặc biệt
        Pattern patternSpecial = Pattern.compile("^.*[#?!@$%^&*-]+.*$");

        //.*[#?!@$%^&*-] : phải có ít nhất 8 ký tự 
        Pattern patternLenght = Pattern.compile("^.*{8}+.*$");

        String password = txtMatKhau.getText();

        if (patternUpper.matcher(password).find() && patternLower.matcher(password).find()
                && patternDigit.matcher(password).find() && patternSpecial.matcher(password).find()
                && patternLenght.matcher(password).find()) {
            txtMatKhau.setBackground(Color.white);
        } else {
            sb.append("Nhập lại mật khẩu! Mật khẩu phải có 8 ký tự phân biệt.\nMật khẩu phải bao gồm chữ hoa, chữ thường, chữ số và ký tự đặc biệt. VD:Admin12#\n");
            txtMatKhau.setBackground(Color.green);
        }
    }

    private void hopleSDT(StringBuilder sb) {
        try {
            String check_url = "Select * from NguoiDung where SDT = '" + txtSDT.getText() + "'";
            st = con.createStatement();
            rs = st.executeQuery(check_url);

            //Kiểm tra trùng id
            if (rs.next()) {
                sb.append("Số điện thoại này đã tồn tại!\n");
                txtSDT.setBackground(Color.green);
            } else {
                String sdt = txtSDT.getText();
                Pattern p = Pattern.compile("^[0-9]{10}$");
                if (p.matcher(sdt).find()) {
                    txtSDT.setBackground(Color.white);
                } else {
                    sb.append("Số điện thoại không hợp lệ, phải gồm 10 chữ số, VD: 0123456789\n");
                    txtSDT.setBackground(Color.green);
                }
            }
        } catch (Exception e) {
        }
    }

    private void hopleEmail(StringBuilder sb) {
        try {
            String check_url = "Select * from NguoiDung where Email = '" + txtEmail.getText() + "'";
            st = con.createStatement();
            rs = st.executeQuery(check_url);

            //Kiểm tra trùng id
            if (rs.next()) {
                sb.append("Email này đã tồn tại!\n");
                txtEmail.setBackground(Color.green);
            } else {
                String email = txtEmail.getText();
                //[a-zA-Z] : bắt đầu phải là 1 ký tự chữ hoa hoặc thường
                //[a-zA-Z0-9]+ : sau ký tự đầu tiên chữ hoặc số đều được và được viết nhiều lần
                //(\\.[a-zA-Z]+)+ : một cụm có 1 hoặc ký tự ".com" hoặc ".com.vn" ddcuuocwjj lặp lại nhiều lần
                Pattern p = Pattern.compile("^[a-zA-Z][a-zA-Z0-9]+@[a-zA-Z]+(\\.[a-zA-Z]+){1,3}$");
                if (p.matcher(email).find()) {
                    txtEmail.setBackground(Color.white);
                } else {
                    sb.append("Email không hợp lệ, ký tự đầu tiên phải là chữ. VD: hn12345.gmail.com, tuan123ct@student.ctu.edu.vn\n");
                    txtEmail.setBackground(Color.green);
                }
            }
        } catch (Exception e) {
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbSearchID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JRadioButton rdbFemale;
    private javax.swing.JRadioButton rdbMale;
    private javax.swing.JTable tblProfile;
    private com.toedter.calendar.JDateChooser txtDate;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaND;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTaiKhoan;
    // End of variables declaration//GEN-END:variables
}
