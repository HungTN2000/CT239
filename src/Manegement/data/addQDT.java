/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manegement.data;

import Manegement.classData.listQDT;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import user.Connect;

/**
 *
 * @author HP
 */
public class addQDT extends javax.swing.JPanel {

    DefaultTableModel tbn = new DefaultTableModel();
    Connect a = new Connect();
    Connection con = a.getConnection();
    Statement st = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    String fPath = null;
    byte[] img_DATA;

    public addQDT() {
        initComponents();
        show_ad();
        //getConnection();
        loadDataCBBTopic();
        loadDataCBBMaTV();
    }

    public void getConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=duan1;user=sa;password=sa2008");
            st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery("select * from CauHoiTN");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public void loadDataCBBTopic() {
        try {
            pst = con.prepareStatement("Select * from ChuDe");
            rs = pst.executeQuery();

            while (rs.next()) {
                cbbTopic.addItem(rs.getString("TenChuDe"));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "LỖI LẤY MÃ SỐ SINH VIÊN");
        }
    }

    public void loadDataCBBMaTV() {
        try {
            pst = con.prepareStatement("Select MaTV from TuVung");
            rs = pst.executeQuery();

            while (rs.next()) {
                cbbMaTV.addItem(rs.getString("MaTV"));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "LỖI LẤY MÃ SỐ SINH VIÊN");
        }
    }

    public ArrayList<listQDT> listQuestionDTManagement() {
        ArrayList<listQDT> adList = new ArrayList<>();
        try {
            String url = "Select * from CauHoiDT";
            st = con.createStatement();
            rs = st.executeQuery(url);
            listQDT data;
            while (rs.next()) {
                //data = new listQ(rs.getString("ID_Question"), rs.getString("Question"), rs.getString("Option1"), rs.getString("Option2"), rs.getString("Option3"), rs.getString("Option4"), rs.getBytes("Image"), rs.getString("Answer"), rs.getString("Level"));
                data = new listQDT(rs.getString("MaCHDT"), rs.getString("CauHoiDT"), rs.getBytes("HinhAnh"), rs.getString("CauTraLoi"), rs.getString("TenChuDe"), rs.getString("MaTV"));
                adList.add(data);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return adList;
    }

    public void show_ad() {
        ArrayList<listQDT> list = listQuestionDTManagement();
        DefaultTableModel model = (DefaultTableModel) tblListQuestion.getModel();
        Object[] row = new Object[6];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getMaCHDT();
            row[1] = list.get(i).getCauHoiDT();
            row[2] = list.get(i).getImage();
            row[3] = list.get(i).getCauTraLoi();
            row[4] = list.get(i).getTenChuDe();
            row[5] = list.get(i).getMaTV();
            model.addRow(row);
        }
        JTableHeader Theader = tblListQuestion.getTableHeader();
        
        Theader.setBackground(new Color(255,215,0));
        Theader.setForeground(Color.black);
        
        Theader.setFont(new Font("Tahome", Font.PLAIN, 16));
        ((DefaultTableCellRenderer)Theader.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        
        tblListQuestion.setFont(new Font("Tahome", Font.PLAIN, 16));
        
        dataEnabledButton();
        reset();
    }

    public ImageIcon ResizeImage(String ImagePath) {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(lblImg.getWidth(), lblImg.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListQuestion = new javax.swing.JTable();
        Main = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtIDQuestion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtQuestion = new javax.swing.JTextArea();
        lblImg = new javax.swing.JLabel();
        txtAnswer = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cbbTopic = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        txtSearch = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cbbMaTV = new javax.swing.JComboBox<>();
        btnSearch = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        Footer = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 102)));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(1200, 830));
        setLayout(new java.awt.BorderLayout());

        Header.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        Header.setPreferredSize(new java.awt.Dimension(1200, 300));

        jScrollPane1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(1164, 2));

        tblListQuestion.setAutoCreateRowSorter(true);
        tblListQuestion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        tblListQuestion.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tblListQuestion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MÃ CHDT", "CÂU HỎI DT", "HÌNH ẢNH", "TỪ VỰNG", "TÊN CHỦ ĐỀ", "MÃ TV"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblListQuestion.setFillsViewportHeight(true);
        tblListQuestion.setRowHeight(30);
        tblListQuestion.setSelectionBackground(new java.awt.Color(72, 209, 204));
        tblListQuestion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListQuestionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblListQuestion);

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1182, Short.MAX_VALUE)
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        add(Header, java.awt.BorderLayout.PAGE_START);

        Main.setBackground(new java.awt.Color(255, 228, 181));
        Main.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setText("Nội dung câu hỏi");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Mã câu hỏi");

        txtIDQuestion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel8.setText("Đáp án");

        txtQuestion.setColumns(20);
        txtQuestion.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtQuestion.setRows(5);
        jScrollPane2.setViewportView(txtQuestion);

        lblImg.setBackground(new java.awt.Color(255, 255, 255));
        lblImg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        lblImg.setOpaque(true);

        txtAnswer.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel9.setText("Topic");

        cbbTopic.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cbbTopic.setMaximumRowCount(3);
        cbbTopic.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose topic" }));

        jSeparator1.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator1.setOpaque(true);

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel11.setText("Mã TV");

        cbbMaTV.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cbbMaTV.setMaximumRowCount(5);
        cbbMaTV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose MaTV" }));
        cbbMaTV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbMaTVActionPerformed(evt);
            }
        });

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search.png"))); // NOI18N
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("Tìm kiếm");

        javax.swing.GroupLayout MainLayout = new javax.swing.GroupLayout(Main);
        Main.setLayout(MainLayout);
        MainLayout.setHorizontalGroup(
            MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainLayout.createSequentialGroup()
                        .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MainLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(cbbMaTV, 0, 252, Short.MAX_VALUE))
                            .addGroup(MainLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtAnswer, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtIDQuestion)))
                            .addGroup(MainLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(cbbTopic, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(22, 22, 22)
                        .addComponent(lblImg, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MainLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainLayout.createSequentialGroup()
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch))
                    .addComponent(jLabel3))
                .addContainerGap())
        );
        MainLayout.setVerticalGroup(
            MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(MainLayout.createSequentialGroup()
                .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MainLayout.createSequentialGroup()
                                .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtIDQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbTopic, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbMaTV, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblImg, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(MainLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                            .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addContainerGap(79, Short.MAX_VALUE))
        );

        add(Main, java.awt.BorderLayout.CENTER);

        Footer.setBackground(new java.awt.Color(245, 255, 250));
        Footer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        Footer.setPreferredSize(new java.awt.Dimension(1200, 70));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 10);
        flowLayout1.setAlignOnBaseline(true);
        Footer.setLayout(flowLayout1);

        btnAdd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAdd.setText("Thêm");
        btnAdd.setPreferredSize(new java.awt.Dimension(120, 40));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        Footer.add(btnAdd);

        btnSave.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSave.setText("Lưu");
        btnSave.setPreferredSize(new java.awt.Dimension(120, 40));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        Footer.add(btnSave);

        btnEdit.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnEdit.setText("Cập nhật");
        btnEdit.setPreferredSize(new java.awt.Dimension(120, 40));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        Footer.add(btnEdit);

        btnDelete.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnDelete.setText("Xóa");
        btnDelete.setPreferredSize(new java.awt.Dimension(120, 40));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        Footer.add(btnDelete);

        btnReset.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnReset.setText("Làm sạch");
        btnReset.setPreferredSize(new java.awt.Dimension(120, 40));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        Footer.add(btnReset);

        add(Footer, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void tblListQuestionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListQuestionMouseClicked
        int i = tblListQuestion.getSelectedRow();
        TableModel model = tblListQuestion.getModel();

        txtIDQuestion.setText(model.getValueAt(i, 0).toString());
        txtQuestion.setText(model.getValueAt(i, 1).toString());
        byte[] img = (listQuestionDTManagement().get(i).getImage());
        ImageIcon imgIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(lblImg.getWidth(), lblImg.getHeight(), Image.SCALE_SMOOTH));
        lblImg.setIcon(imgIcon);
        img_DATA = img;
        txtAnswer.setText(model.getValueAt(i, 3).toString());
        cbbTopic.setSelectedItem(model.getValueAt(i, 4).toString());
        cbbMaTV.setSelectedItem(model.getValueAt(i, 5).toString());
        
        dataNotEnabledButton();
    }//GEN-LAST:event_tblListQuestionMouseClicked

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        reset();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            String url = "insert into CauHoiDT values (?,?,?,?,?,?)";
            pst = con.prepareStatement(url);
            pst.setString(1, txtIDQuestion.getText());
            pst.setString(2, txtQuestion.getText());
            pst.setBytes(3, img_DATA);
            pst.setString(4, txtAnswer.getText());
            pst.setString(5, cbbTopic.getSelectedItem().toString());
            pst.setString(6, cbbMaTV.getSelectedItem().toString());
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel) tblListQuestion.getModel();
            model.setRowCount(0);
            show_ad();
            getConnection();
            JOptionPane.showMessageDialog(null, "Lưu dữ liệu thành công.");
            dataEnabledButton();
            reset();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        try {
            pst = con.prepareStatement("Update CauHoiDT set CauHoiDT=?, HinhAnh=?,CauTraLoi=?,TenChuDe=?,MaTV=? where MaCHDT=?");
            pst.setString(6, txtIDQuestion.getText());
            pst.setString(1, txtQuestion.getText());
            pst.setBytes(2, img_DATA);
            pst.setString(3, txtAnswer.getText());
            pst.setString(4, cbbTopic.getSelectedItem().toString());
            pst.setString(5, cbbMaTV.getSelectedItem().toString());
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel) tblListQuestion.getModel();
            model.setRowCount(0);
            show_ad();
            getConnection();
            JOptionPane.showMessageDialog(this, "Cập nhật thành công.");
            dataEnabledButton();
            reset();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            pst = con.prepareStatement("Delete CauHoiDT where MaCHT=DT=?");
            pst.setString(1, tblListQuestion.getValueAt(tblListQuestion.getSelectedRow(), 0).toString());
            if (JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa?", "Confirm", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                pst.executeUpdate();
                DefaultTableModel model = (DefaultTableModel) tblListQuestion.getModel();
                model.setRowCount(0);
                show_ad();
                JOptionPane.showMessageDialog(this, "Xóa thành công");
            }
            dataEnabledButton();
            reset();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Xóa thất bại");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        DefaultTableModel model = (DefaultTableModel) tblListQuestion.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<DefaultTableModel>(model);
        tblListQuestion.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(txtSearch.getText().trim()));
    }//GEN-LAST:event_txtSearchKeyReleased

    private void cbbMaTVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbMaTVActionPerformed
        try {
            pst = con.prepareStatement("Select * from TuVung where MaTV=?");
            pst.setString(1, cbbMaTV.getSelectedItem().toString());
            rs = pst.executeQuery();
            if (rs.next()) {
                txtAnswer.setText(rs.getString("TuVung"));
                byte[] img = rs.getBytes("HinhAnh");
                ImageIcon imgIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(lblImg.getWidth(), lblImg.getHeight(), Image.SCALE_SMOOTH));
                lblImg.setIcon(imgIcon);
                img_DATA = img;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_cbbMaTVActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        try {
            pst = con.prepareStatement("Select * from TuVUng where MaTV=?");
            pst.setString(1, cbbMaTV.getSelectedItem().toString());
            rs = pst.executeQuery();
            while (rs.next()) {
                txtIDQuestion.setText(rs.getString("MaCHTN"));
                txtQuestion.setText(rs.getString("CauHoi"));
                txtAnswer.setText(rs.getString("CauTraLoi"));
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        dataNotEnabledButton();
    }//GEN-LAST:event_btnAddActionPerformed

    public void dataEnabledButton() {
        btnAdd.setEnabled(true);
        btnSave.setEnabled(false);
        btnEdit.setEnabled(false);
        btnDelete.setEnabled(false);
        btnReset.setEnabled(false);
        btnSearch.setEnabled(false);
        txtIDQuestion.setEnabled(false);
        txtQuestion.setEnabled(false);
        cbbMaTV.setEnabled(false);
        cbbTopic.setEnabled(false);
        txtAnswer.setEnabled(false);
        lblImg.setEnabled(false);
        txtSearch.setEnabled(false);
    }

    public void dataNotEnabledButton() {
        btnAdd.setEnabled(false);
        btnSave.setEnabled(true);
        btnEdit.setEnabled(true);
        btnDelete.setEnabled(true);
        btnReset.setEnabled(true);
        btnSearch.setEnabled(true);
        txtIDQuestion.setEnabled(true);
        txtQuestion.setEnabled(true);
        cbbMaTV.setEnabled(true);
        cbbTopic.setEnabled(true);
        txtAnswer.setEnabled(true);
        lblImg.setEnabled(true);
        txtSearch.setEnabled(true);
    }

    public void reset() {
        txtIDQuestion.setText("");
        txtAnswer.setText("");
        txtQuestion.setText("");
        txtSearch.setText("");
        cbbMaTV.setSelectedIndex(0);
        cbbTopic.setSelectedIndex(0);
        lblImg.setIcon(null);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Footer;
    private javax.swing.JPanel Header;
    private javax.swing.JPanel Main;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cbbMaTV;
    private javax.swing.JComboBox<String> cbbTopic;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblImg;
    private javax.swing.JTable tblListQuestion;
    private javax.swing.JTextField txtAnswer;
    private javax.swing.JTextField txtIDQuestion;
    private javax.swing.JTextArea txtQuestion;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
