/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import user.Connect;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author HP
 */
public class frmData extends javax.swing.JFrame {

    DefaultTableModel tbn = new DefaultTableModel();
    Connect a = new Connect();
    Connection con = a.getConnection();
    Statement st = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    String fPath = null;
    byte[] img_DATA;

    public frmData() {
        initComponents();
        setTitle("Dữ liệu phần mềm");
        setLocationRelativeTo(null);
        show_ad();
        bgData();
        updateCBBID();
        this.img_DATA = null;
        getConnection();
    }

    public void getConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=duan1;user=sa;password=sa2008");
            st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery("select * from data");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public ArrayList<imgList> adminList() {
        ArrayList<imgList> adList = new ArrayList<>();
        try {
            String url = "select * from data";
            st = con.createStatement();
            rs = st.executeQuery(url);
            imgList data;
            while (rs.next()) {
                data = new imgList(rs.getInt("id"), rs.getString("EN"), rs.getString("Pro"), rs.getString("VN"), rs.getBytes("img"), rs.getString("date"));
                adList.add(data);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return adList;
    }

    public void show_ad() {
        ArrayList<imgList> list = adminList();
        DefaultTableModel model = (DefaultTableModel) tblDS.getModel();
        Object[] row = new Object[6];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getEN();
            row[2] = list.get(i).getPro();
            row[3] = list.get(i).getVN();
            row[4] = list.get(i).getImg();
            row[5] = list.get(i).getDate();
            model.addRow(row);
        }
    }

    public ImageIcon ResizeImage(String ImagePath) {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(lblImg.getWidth(), lblImg.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    public void bgData() {
        bgmain();
        bgOption();
    }

    public void bgmain() {
        ImageIcon MyImage = new ImageIcon("C:\\Java-JSP\\duan9\\src\\img\\Background\\bg2.jpg");
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(lblbg.getWidth(), lblbg.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        lblbg.setIcon(image);
    }

    public void bgOption() {
        ImageIcon MyImage = new ImageIcon("C:\\Java-JSP\\duan9\\src\\img\\Background\\4.jpg");
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        jLabel1.setIcon(image);
    }

    public void newdata() {
        txtID.setText("");
        txtEN.setText("");
        txtPro.setText("");
        txtVN.setText("");
        lblImg.setIcon(null);
        jDateChooser1.setDate(null);
    }

    private void updateCBBID() {
        try {
            String sql = "Select id from data group by id";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            //Tạo 1 DefaultComboboxModel
            DefaultComboBoxModel modelID = (DefaultComboBoxModel) cbbID.getModel();
            modelID.removeAllElements(); //Xóa hết dữ liệu trong combobox
            while (rs.next()) {
                cbbID.addItem(rs.getString("ID"));
            }
            rs.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        panelTop = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnSearch = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        cbbID = new javax.swing.JComboBox<>();
        btnFirst = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        panelWest = new javax.swing.JPanel();
        panelLeft = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnNew = new javax.swing.JButton();
        btnChonImg = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        panelBuildCenter = new javax.swing.JPanel();
        panelCenter = new javax.swing.JPanel();
        lblImg = new javax.swing.JLabel();
        panelText = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtEN = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPro = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtVN = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        panelRight = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDS = new javax.swing.JTable();
        panelBottom = new javax.swing.JPanel();
        lblbg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 10));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(1100, 900));
        jPanel1.setLayout(new java.awt.BorderLayout());

        panelTop.setOpaque(false);
        panelTop.setPreferredSize(new java.awt.Dimension(1100, 160));
        panelTop.setLayout(new java.awt.BorderLayout());

        jLabel2.setFont(new java.awt.Font("SimSun", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 247, 253));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("DATA ENGLISH FOR KIDS");
        jLabel2.setPreferredSize(new java.awt.Dimension(420, 60));
        panelTop.add(jLabel2, java.awt.BorderLayout.CENTER);

        jPanel4.setOpaque(false);
        jPanel4.setPreferredSize(new java.awt.Dimension(1380, 60));

        btnSearch.setText("TÌM KIẾM");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        cbbID.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        btnFirst.setText("FIRST");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnNext.setText("NEXT");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLast.setText("LAST");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(btnSearch)
                .addGap(7, 7, 7)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cbbID, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFirst)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNext)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLast)
                .addContainerGap(479, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbbID, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnFirst)
                        .addComponent(btnBack)
                        .addComponent(btnNext)
                        .addComponent(btnLast)))
                .addContainerGap())
        );

        panelTop.add(jPanel4, java.awt.BorderLayout.PAGE_END);

        jPanel1.add(panelTop, java.awt.BorderLayout.PAGE_START);

        panelWest.setOpaque(false);
        panelWest.setPreferredSize(new java.awt.Dimension(800, 350));
        panelWest.setLayout(new java.awt.BorderLayout());

        panelLeft.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "CHỨC NĂNG", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 255, 255)), javax.swing.BorderFactory.createEmptyBorder(20, 5, 20, 5))); // NOI18N
        panelLeft.setPreferredSize(new java.awt.Dimension(240, 250));
        panelLeft.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 5, 30, 5));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.GridLayout(7, 0, 15, 10));

        btnNew.setBackground(new java.awt.Color(255, 116, 22));
        btnNew.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnNew.setText("THÊM MỚI");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        jPanel2.add(btnNew);

        btnChonImg.setBackground(new java.awt.Color(255, 116, 22));
        btnChonImg.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnChonImg.setText("LẤY ẢNH");
        btnChonImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonImgActionPerformed(evt);
            }
        });
        jPanel2.add(btnChonImg);

        btnAdd.setBackground(new java.awt.Color(255, 116, 22));
        btnAdd.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnAdd.setText("THÊM");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel2.add(btnAdd);

        btnUpdate.setBackground(new java.awt.Color(255, 116, 22));
        btnUpdate.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnUpdate.setText("CẬP NHẬT");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel2.add(btnUpdate);

        btnDelete.setBackground(new java.awt.Color(255, 116, 22));
        btnDelete.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnDelete.setText("XÓA");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel2.add(btnDelete);

        btnSave.setBackground(new java.awt.Color(255, 116, 22));
        btnSave.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnSave.setText("LƯU");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel2.add(btnSave);

        btnExit.setBackground(new java.awt.Color(255, 116, 22));
        btnExit.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnExit.setText("THOÁT");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jPanel2.add(btnExit);

        panelLeft.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 44, 218, 610));
        panelLeft.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 680));

        panelWest.add(panelLeft, java.awt.BorderLayout.WEST);

        panelBuildCenter.setOpaque(false);
        panelBuildCenter.setLayout(new java.awt.BorderLayout(0, 10));

        panelCenter.setBackground(new java.awt.Color(255, 255, 255));
        panelCenter.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        panelCenter.setPreferredSize(new java.awt.Dimension(100, 244));
        panelCenter.setLayout(new java.awt.BorderLayout());

        lblImg.setBackground(new java.awt.Color(255, 255, 255));
        lblImg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelCenter.add(lblImg, java.awt.BorderLayout.CENTER);

        panelBuildCenter.add(panelCenter, java.awt.BorderLayout.CENTER);

        panelText.setBackground(new java.awt.Color(255, 255, 255));
        panelText.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "NHẬP DỮ LIỆU CẦN THÊM", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18)), javax.swing.BorderFactory.createEmptyBorder(15, 60, 15, 60))); // NOI18N
        panelText.setOpaque(false);
        panelText.setPreferredSize(new java.awt.Dimension(180, 260));
        panelText.setLayout(new java.awt.GridLayout(5, 2, -150, 5));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("STT");
        panelText.add(jLabel6);

        txtID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        panelText.add(txtID);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("TỪ VỰNG");
        panelText.add(jLabel3);

        txtEN.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        panelText.add(txtEN);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("PHIÊN ÂM");
        panelText.add(jLabel4);

        txtPro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        panelText.add(txtPro);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("NGHĨA TỪ VỰNG");
        panelText.add(jLabel5);

        txtVN.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        panelText.add(txtVN);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("DATE");
        panelText.add(jLabel7);

        jDateChooser1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        panelText.add(jDateChooser1);

        panelBuildCenter.add(panelText, java.awt.BorderLayout.PAGE_START);

        panelWest.add(panelBuildCenter, java.awt.BorderLayout.CENTER);

        jPanel1.add(panelWest, java.awt.BorderLayout.WEST);

        panelRight.setBackground(new java.awt.Color(255, 255, 255));
        panelRight.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(0, 20, 0, 0), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        panelRight.setOpaque(false);
        panelRight.setPreferredSize(new java.awt.Dimension(404, 404));
        panelRight.setLayout(new java.awt.BorderLayout());

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setBorder(null);
        jScrollPane3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane3.setPreferredSize(new java.awt.Dimension(440, 402));

        tblDS.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tblDS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "ENGLISH", "PHIÊN ÂM", "VIETNAMESE", "IMAGES", "DATE"
            }
        ));
        tblDS.setAutoscrolls(false);
        tblDS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblDS);

        panelRight.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        jPanel1.add(panelRight, java.awt.BorderLayout.CENTER);

        panelBottom.setBackground(new java.awt.Color(255, 255, 255));
        panelBottom.setOpaque(false);
        panelBottom.setPreferredSize(new java.awt.Dimension(1100, 80));

        javax.swing.GroupLayout panelBottomLayout = new javax.swing.GroupLayout(panelBottom);
        panelBottom.setLayout(panelBottomLayout);
        panelBottomLayout.setHorizontalGroup(
            panelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1380, Short.MAX_VALUE)
        );
        panelBottomLayout.setVerticalGroup(
            panelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        jPanel1.add(panelBottom, java.awt.BorderLayout.PAGE_END);

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1400, 900));
        jPanel3.add(lblbg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1400, 900));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void btnChonImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonImgActionPerformed
        JFileChooser fBuild = new JFileChooser("C:\\Java-JSP\\duan9\\src\\img\\Vocabulary");

        FileNameExtensionFilter fnef = new FileNameExtensionFilter("*.Image", "jpg", "png");
        fBuild.addChoosableFileFilter(fnef);

        int result = fBuild.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File f = fBuild.getSelectedFile();
            fPath = f.getAbsolutePath();
            ImageIcon imgIcon = new ImageIcon(new ImageIcon(fPath).getImage().getScaledInstance(lblImg.getWidth(), lblImg.getHeight(), Image.SCALE_SMOOTH));
            lblImg.setIcon(ResizeImage(fPath));
        }

        try {
            File image = new File(fPath);
            FileInputStream fis = new FileInputStream(image);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            for (int readNum; (readNum = fis.read(buf)) != -1;) {
                bos.write(buf, 0, readNum);
            }
            img_DATA = bos.toByteArray();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnChonImgActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        int chon = JOptionPane.showConfirmDialog(this, "Bạn có muốn thoát không!", "Thoát", JOptionPane.YES_NO_CANCEL_OPTION);
        if (chon == JOptionPane.YES_OPTION) {
            System.exit(0);
        }

    }//GEN-LAST:event_btnExitActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        try {
            pst.setString(1, txtEN.getText());
            pst.setString(2, txtPro.getText());
            pst.setString(3, txtVN.getText());
            pst.setBytes(4, img_DATA);
            DefaultTableModel model = (DefaultTableModel) tblDS.getModel();
            model.setRowCount(0);
            JOptionPane.showMessageDialog(null, "THÊM DỮ LIỆU THÀNH CÔNG!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            String url = "insert into data values (?,?,?,?,?,?)";
            pst = con.prepareStatement(url);
            pst.setString(1, txtID.getText());
            pst.setString(2, txtEN.getText());
            pst.setString(3, txtPro.getText());
            pst.setString(4, txtVN.getText());
            pst.setBytes(5, img_DATA);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(jDateChooser1.getDate());
            pst.setString(6, date);
            pst.executeUpdate();
            tbn.setRowCount(0);
            DefaultTableModel model = (DefaultTableModel) tblDS.getModel();
            model.setRowCount(0);
            show_ad();
            getConnection();
            JOptionPane.showMessageDialog(null, "LƯU DỮ LIỆU THÀNH CÔNG!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
//            int row = tblDS.getSelectedRow();
//            String value = (tblDS.getModel().getValueAt(row, 0).toString());
            String value = txtID.getText();
            String url = "update data set EN=?, Pro=?, VN=?, img=?, date=? where id=" + value;
            pst = con.prepareStatement(url);
            pst.setString(1, txtEN.getText());
            pst.setString(2, txtPro.getText());
            pst.setString(3, txtVN.getText());
            byte[] img = img_DATA;
            pst.setBytes(4, img);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(jDateChooser1.getDate());
            pst.setString(5, date);
            pst.executeUpdate();
            tbn.setRowCount(0);
            DefaultTableModel model = (DefaultTableModel) tblDS.getModel();
            model.setRowCount(0);
            show_ad();
            JOptionPane.showMessageDialog(null, "CẬP NHẬT DỮ LIỆU THÀNH CÔNG!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        newdata();
    }//GEN-LAST:event_btnNewActionPerformed

    private void tblDSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSMouseClicked
        int i = tblDS.getSelectedRow();
        TableModel model = tblDS.getModel();

        txtID.setText(model.getValueAt(i, 0).toString());
        txtEN.setText(model.getValueAt(i, 1).toString());
        txtPro.setText(model.getValueAt(i, 2).toString());
        txtVN.setText(model.getValueAt(i, 3).toString());
        byte[] img = (adminList().get(i).getImg());
        ImageIcon imgIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(lblImg.getWidth(), lblImg.getHeight(), Image.SCALE_SMOOTH));
        lblImg.setIcon(imgIcon);
        img_DATA = img;
        try {
            int srow = tblDS.getSelectedRow();
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String) model.getValueAt(srow, 5));
            jDateChooser1.setDate(date);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_tblDSMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            int row = tblDS.getSelectedRow();
            String value = (tblDS.getModel().getValueAt(row, 0).toString());
            String url = "delete from data where id = " + value;
            pst = con.prepareStatement(url);
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel) tblDS.getModel();
            model.setRowCount(0);
            show_ad();
            JOptionPane.showMessageDialog(null, "XÓA DỮ LIỆU THÀNH CÔNG!");
            newdata();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        try {
            pst = con.prepareStatement("Select * from data where id=?");
            pst.setString(1, cbbID.getSelectedItem().toString());
            rs = pst.executeQuery();
            if (rs.next()) {
                txtID.setText(rs.getString("id"));
                txtEN.setText(rs.getString("EN"));
                txtPro.setText(rs.getString("Pro"));
                txtVN.setText(rs.getString("VN"));
                jDateChooser1.setDate(rs.getDate("date"));
                byte[] img = rs.getBytes("img");
                ImageIcon imgIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(lblImg.getWidth(), lblImg.getHeight(), Image.SCALE_SMOOTH));
                lblImg.setIcon(imgIcon);
                img_DATA = img;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        try {
            pst = con.prepareStatement("Select * from data where id=?");
            pst.setString(1, txtSearch.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                txtID.setText(rs.getString("id"));
                txtEN.setText(rs.getString("EN"));
                txtPro.setText(rs.getString("Pro"));
                txtVN.setText(rs.getString("VN"));
                jDateChooser1.setDate(rs.getDate("date"));
                byte[] img = rs.getBytes("img");
                ImageIcon imgIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(lblImg.getWidth(), lblImg.getHeight(), Image.SCALE_SMOOTH));
                lblImg.setIcon(imgIcon);
                img_DATA = img;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        try {
            rs.first();
            txtID.setText(rs.getString(1));
            txtEN.setText(rs.getString(2));
            txtPro.setText(rs.getString(3));
            txtVN.setText(rs.getString(4));
            jDateChooser1.setDate(rs.getDate(6));
            byte[] img = rs.getBytes(5);
            ImageIcon imgIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(lblImg.getWidth(), lblImg.getHeight(), Image.SCALE_SMOOTH));
            lblImg.setIcon(imgIcon);
            img_DATA = img;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        try {
            if (!rs.isFirst()) {
                rs.previous();
                txtID.setText(rs.getString(1));
                txtEN.setText(rs.getString(2));
                txtPro.setText(rs.getString(3));
                txtVN.setText(rs.getString(4));
                jDateChooser1.setDate(rs.getDate(6));
                byte[] img = rs.getBytes(5);
                ImageIcon imgIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(lblImg.getWidth(), lblImg.getHeight(), Image.SCALE_SMOOTH));
                lblImg.setIcon(imgIcon);
                img_DATA = img;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_btnBackActionPerformed


    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        try {
            if (!rs.isLast()) {
                rs.next();
                txtID.setText(rs.getString(1));
                txtEN.setText(rs.getString(2));
                txtPro.setText(rs.getString(3));
                txtVN.setText(rs.getString(4));
                jDateChooser1.setDate(rs.getDate(6));
                byte[] img = rs.getBytes(5);
                ImageIcon imgIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(lblImg.getWidth(), lblImg.getHeight(), Image.SCALE_SMOOTH));
                lblImg.setIcon(imgIcon);
                img_DATA = img;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        try {
            rs.last();
            txtID.setText(rs.getString(1));
            txtEN.setText(rs.getString(2));
            txtPro.setText(rs.getString(3));
            txtVN.setText(rs.getString(4));
            jDateChooser1.setDate(rs.getDate(6));
            byte[] img = rs.getBytes(5);
            ImageIcon imgIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(lblImg.getWidth(), lblImg.getHeight(), Image.SCALE_SMOOTH));
            lblImg.setIcon(imgIcon);
            img_DATA = img;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_btnLastActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmData().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnChonImg;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbbID;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblImg;
    private javax.swing.JLabel lblbg;
    private javax.swing.JPanel panelBottom;
    private javax.swing.JPanel panelBuildCenter;
    private javax.swing.JPanel panelCenter;
    private javax.swing.JPanel panelLeft;
    private javax.swing.JPanel panelRight;
    private javax.swing.JPanel panelText;
    private javax.swing.JPanel panelTop;
    private javax.swing.JPanel panelWest;
    private javax.swing.JTable tblDS;
    private javax.swing.JTextField txtEN;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtPro;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtVN;
    // End of variables declaration//GEN-END:variables
}
