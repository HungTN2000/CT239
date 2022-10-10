/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manegement.data;

import Manegement.classData.listQ;
import java.awt.Color;
import java.awt.Font;
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
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
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
public class addQTN extends javax.swing.JPanel {

    DefaultTableModel tbn = new DefaultTableModel();
    Connect a = new Connect();
    Connection con = a.getConnection();
    Statement st = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    String fPath = null;
    byte[] img_DATA;

    public addQTN() {
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
            pst = con.prepareStatement("Select TenChuDe from ChuDe");
            rs = pst.executeQuery();

            while (rs.next()) {
                cbbTopic.addItem(rs.getString("TenChuDe"));
            }
        } catch (Exception e) {
            System.out.println(e.toString());
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

    public ArrayList<listQ> listQuestionManagement() {
        ArrayList<listQ> adList = new ArrayList<>();
        try {
            String url = "Select * from CauHoiTN";
            st = con.createStatement();
            rs = st.executeQuery(url);
            listQ data;
            while (rs.next()) {
                //data = new listQ(rs.getString("ID_Question"), rs.getString("Question"), rs.getString("Option1"), rs.getString("Option2"), rs.getString("Option3"), rs.getString("Option4"), rs.getBytes("Image"), rs.getString("Answer"), rs.getString("Level"));
                data = new listQ(rs.getString("MaCHTN"), rs.getString("CauHoi"), rs.getString("DapAnA"), rs.getString("DapAnB"), rs.getString("DapAnC"), rs.getString("DapAnD"),
                        rs.getBytes("HinhAnh"), rs.getString("CauTraLoi"), rs.getString("TenChuDe"), rs.getString("MaTV"));
                adList.add(data);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return adList;
    }

    public void show_ad() {
        ArrayList<listQ> list = listQuestionManagement();
        DefaultTableModel model = (DefaultTableModel) tblListQuestion.getModel();
        Object[] row = new Object[10];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getMaCHTN();
            row[1] = list.get(i).getCHTN();
            row[2] = list.get(i).getOption1();
            row[3] = list.get(i).getOption2();
            row[4] = list.get(i).getOption3();
            row[5] = list.get(i).getOption4();
            row[6] = list.get(i).getImage();
            row[7] = list.get(i).getAnswer();
            row[8] = list.get(i).getTopic();
            row[9] = list.get(i).getMaTV();
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

    //    public void loadData() {
//        try {
//            int number;
//            Vector row, column;
//            column = new Vector();
//            Statement st = con.createStatement();
//            rs = st.executeQuery("Select ID_Question, Question,  Option1, Option2, Option3, Option4, Image, Answer\n"
//                    + "from question");
//            ResultSetMetaData metadata = rs.getMetaData();
//            number = metadata.getColumnCount(); //trả về số cột
//
//            for (int i = 1; i <= number; i++) {
//                column.add(metadata.getColumnName(i)); //lấy ra tiêu đề của các cột
//            }
//            tbn.setColumnIdentifiers(column);
//
//            while (rs.next()) {
//                row = new Vector();
//                for (int i = 1; i <= number; i++) {
//                    row.addElement(rs.getString(i));
//                }
//                tbn.addRow(row);
//                tblListQuestion.setModel(tbn);
//            }
//            tblListQuestion.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
//                @Override
//                public void valueChanged(ListSelectionEvent e) {
//                    if (tblListQuestion.getSelectedRow() >= 0) {
//                        txtIDQuestion.setText(tblListQuestion.getValueAt(tblListQuestion.getSelectedRow(), 0) + "");
//                        txtQuestion.setText(tblListQuestion.getValueAt(tblListQuestion.getSelectedRow(), 1) + "");
//                        txtOption1.setText(tblListQuestion.getValueAt(tblListQuestion.getSelectedRow(), 2) + "");
//                        txtOption2.setText(tblListQuestion.getValueAt(tblListQuestion.getSelectedRow(), 3) + "");
//                        txtOption3.setText(tblListQuestion.getValueAt(tblListQuestion.getSelectedRow(), 4) + "");
//                        txtOption4.setText(tblListQuestion.getValueAt(tblListQuestion.getSelectedRow(), 5) + "");
//                        txtOption1.setText(tblListQuestion.getValueAt(tblListQuestion.getSelectedRow(), 2) + "");
//                        txtAnswer.setText(tblListQuestion.getValueAt(tblListQuestion.getSelectedRow(), 7) + "");
//                    }
//                }
//            });
//        } catch (Exception e) {
//            System.out.println(e.toString());
//        }
//    }
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtOption1 = new javax.swing.JTextField();
        txtOption2 = new javax.swing.JTextField();
        txtOption3 = new javax.swing.JTextField();
        txtOption4 = new javax.swing.JTextField();
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
        jLabel10 = new javax.swing.JLabel();
        Footer = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnChooseImage = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 102)));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(1200, 830));
        setLayout(new java.awt.BorderLayout());

        Header.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
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
                "MÃ CHTN", "CÂU HỎI TN", "ĐÁP ÁN A", "ĐÁP ÁN B", "ĐÁP ÁN C", "ĐÁP ÁN D", "HÌNH ẢNH", "CÂU TRẢ LỜI", "TÊN CHỦ ĐỀ", "MÃ TV"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true, true, true
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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1192, Short.MAX_VALUE)
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        add(Header, java.awt.BorderLayout.PAGE_START);

        Main.setBackground(new java.awt.Color(255, 250, 240));
        Main.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setText("Nội dung câu hỏi");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Mã câu hỏi");

        txtIDQuestion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("Nội dung đáp án");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("A");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setText("B");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setText("C");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel7.setText("D");

        txtOption1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtOption2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtOption3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtOption4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

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
        jLabel9.setText("Tên chủ đề");

        cbbTopic.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cbbTopic.setMaximumRowCount(5);
        cbbTopic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTopicActionPerformed(evt);
            }
        });

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
        cbbMaTV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---- Select MaTV ----" }));
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

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel10.setText("Tìm kiếm");

        javax.swing.GroupLayout MainLayout = new javax.swing.GroupLayout(Main);
        Main.setLayout(MainLayout);
        MainLayout.setHorizontalGroup(
            MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainLayout.createSequentialGroup()
                        .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(MainLayout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel7)
                                    .addGap(18, 18, 18)
                                    .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtAnswer, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                                        .addComponent(txtOption4)))
                                .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(MainLayout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtOption2, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(MainLayout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtOption3, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(MainLayout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtOption1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(18, 18, 18)
                        .addComponent(lblImg, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MainLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MainLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtIDQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbbTopic, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(cbbMaTV, 0, 192, Short.MAX_VALUE))
                            .addGroup(MainLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2)))))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(171, 171, 171))
                    .addGroup(MainLayout.createSequentialGroup()
                        .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        MainLayout.setVerticalGroup(
            MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(MainLayout.createSequentialGroup()
                .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbTopic, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbMaTV, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(txtIDQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MainLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(MainLayout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(jLabel4))
                                    .addComponent(txtOption1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(MainLayout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(jLabel5))
                                    .addComponent(txtOption2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(MainLayout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(jLabel6))
                                    .addComponent(txtOption3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(MainLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel7))
                                    .addComponent(txtOption4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(MainLayout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addComponent(jLabel8))
                                    .addGroup(MainLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(txtAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(lblImg, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(MainLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        add(Main, java.awt.BorderLayout.CENTER);

        Footer.setBackground(new java.awt.Color(255, 250, 240));
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
        btnEdit.setText("Sửa");
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

        btnChooseImage.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnChooseImage.setText("Tải ảnh");
        btnChooseImage.setPreferredSize(new java.awt.Dimension(120, 40));
        btnChooseImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseImageActionPerformed(evt);
            }
        });
        Footer.add(btnChooseImage);

        add(Footer, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void tblListQuestionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListQuestionMouseClicked
        int i = tblListQuestion.getSelectedRow();
        TableModel model = tblListQuestion.getModel();

        txtIDQuestion.setText(model.getValueAt(i, 0).toString());
        txtQuestion.setText(model.getValueAt(i, 1).toString());
        txtOption1.setText(model.getValueAt(i, 2).toString());
        txtOption2.setText(model.getValueAt(i, 3).toString());
        txtOption3.setText(model.getValueAt(i, 4).toString());
        txtOption4.setText(model.getValueAt(i, 5).toString());
        byte[] img = (listQuestionManagement().get(i).getImage());
        ImageIcon imgIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(lblImg.getWidth(), lblImg.getHeight(), Image.SCALE_SMOOTH));
        lblImg.setIcon(imgIcon);
        img_DATA = img;
        txtAnswer.setText(model.getValueAt(i, 7).toString());
        cbbTopic.setSelectedItem(model.getValueAt(i, 8).toString());
        cbbMaTV.setSelectedItem(model.getValueAt(i, 9).toString());
        
        dataNotEnabledButton();
    }//GEN-LAST:event_tblListQuestionMouseClicked

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        reset();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            String url = "insert into CauHoiTN values (?,?,?,?,?,?,?,?,?,?)";
            pst = con.prepareStatement(url);
            pst.setString(1, txtIDQuestion.getText());
            pst.setString(2, txtQuestion.getText());
            pst.setString(3, txtOption1.getText());
            pst.setString(4, txtOption2.getText());
            pst.setString(5, txtOption3.getText());
            pst.setString(6, txtOption4.getText());
            pst.setBytes(7, img_DATA);
            pst.setString(8, txtAnswer.getText());
            pst.setString(9, cbbTopic.getSelectedItem().toString());
            pst.setString(10, cbbMaTV.getSelectedItem().toString());
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel) tblListQuestion.getModel();
            model.setRowCount(0);
            show_ad();
            JOptionPane.showMessageDialog(null, "Lưu dữ liệu thành công.");
            dataEnabledButton();
            reset();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        try {
            pst = con.prepareStatement("Update CauHoiTN set CauHoi=?,DapAnA=?,DapAnB=?,DapAnC=?,DapAnD=?,HinhAnh=?,CauTraLoi=?,TenChuDe=?, MaTV=? where MaCHTN=?");
            pst.setString(10, txtIDQuestion.getText());
            pst.setString(1, txtQuestion.getText());
            pst.setString(2, txtOption1.getText());
            pst.setString(3, txtOption2.getText());
            pst.setString(4, txtOption3.getText());
            pst.setString(5, txtOption4.getText());
            pst.setBytes(6, img_DATA);
            pst.setString(7, txtAnswer.getText());
            pst.setString(8, cbbTopic.getSelectedItem().toString());
            pst.setString(9, cbbMaTV.getSelectedItem().toString());
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel) tblListQuestion.getModel();
            model.setRowCount(0);
            show_ad();
            JOptionPane.showMessageDialog(this, "Cập nhật thành công.");
            dataEnabledButton();
            reset();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnChooseImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseImageActionPerformed
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
    }//GEN-LAST:event_btnChooseImageActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        DefaultTableModel model = (DefaultTableModel) tblListQuestion.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<DefaultTableModel>(model);
        tblListQuestion.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(txtSearch.getText().trim()));
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            pst = con.prepareStatement("Delete CauHoiTN where MaCHTN=?");
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

    private void cbbMaTVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbMaTVActionPerformed
        int Flag = 0;
        try {
            pst = con.prepareStatement("SELECT * FROM CauHoiTN WHERE MaTV=?");
            pst.setString(1, cbbMaTV.getSelectedItem().toString());
            rs = pst.executeQuery();
            if (cbbTopic.isShowing() && Flag > 0) {
                cbbTopic.removeItem(1);
            }
            while (rs.next()) {
                txtIDQuestion.setText(rs.getString("MaCHTN"));
                txtQuestion.setText(rs.getString("CauHoi"));
                byte[] img = rs.getBytes("HinhAnh");
                //cbbTopic.addItem(rs.getString("TenChuDe"));
                txtOption1.setText(rs.getString("DapAnA"));
                txtOption2.setText(rs.getString("DapAnB"));
                txtOption3.setText(rs.getString("DapAnC"));
                txtOption4.setText(rs.getString("DapAnD"));
                txtAnswer.setText(rs.getString("CauTraLoi"));
                ImageIcon imgIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(lblImg.getWidth(), lblImg.getHeight(), Image.SCALE_SMOOTH));
                lblImg.setIcon(imgIcon);
                img_DATA = img;
                Flag += 1;
            }
            String temp = Integer.toString(Flag);
            txtSearch.setText(cbbTopic.getSelectedItem().toString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_cbbMaTVActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        try {
            pst = con.prepareStatement("SELECT * FROM CauHoiTN WHERE MaTV=?");
            pst.setString(1, cbbMaTV.getSelectedItem().toString());
            rs = pst.executeQuery();
            if (rs.next()) {
                txtIDQuestion.setText(rs.getString("MaCHTN"));
                txtQuestion.setText(rs.getString("CauHoi"));
                String topic = rs.getString("TenChuDe");
                cbbTopic.addItem(topic);
                txtAnswer.setText(rs.getString("CauTraLoi"));
            } else {
                JOptionPane.showMessageDialog(this, "KHÔNG TÌM THẤY!");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void cbbTopicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTopicActionPerformed
//        try {
//            pst = con.prepareStatement("SELECT * FROM CauHoiTN WHERE TenChuDe=?");
//            pst.setString(1, cbbTopic.getSelectedItem().toString());
//            rs = pst.executeQuery();
//            cbbMaTV.setSelectedIndex(0);
//            while (rs.next()) {
//                txtIDQuestion.setText(rs.getString("MaCHTN"));
//                txtQuestion.setText(rs.getString("CauHoi"));
//                byte[] img = rs.getBytes("HinhAnh");
//                cbbMaTV.addItem(rs.getString("MaTV"));
//                txtOption1.setText(rs.getString("DapAnA"));
//                txtOption2.setText(rs.getString("DapAnB"));
//                txtOption3.setText(rs.getString("DapAnC"));
//                txtOption4.setText(rs.getString("DapAnD"));
//                txtAnswer.setText(rs.getString("CauTraLoi"));
//                ImageIcon imgIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(lblImg.getWidth(), lblImg.getHeight(), Image.SCALE_SMOOTH));
//                lblImg.setIcon(imgIcon);
//                img_DATA = img;
//            }
//        } catch (Exception e) {
//            System.out.println(e.toString());
//        }
    }//GEN-LAST:event_cbbTopicActionPerformed

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
        btnChooseImage.setEnabled(false);
        txtIDQuestion.setEnabled(false);
        txtQuestion.setEnabled(false);
        cbbMaTV.setEnabled(false);
        cbbTopic.setEnabled(false);
        txtOption1.setEnabled(false);
        txtOption2.setEnabled(false);
        txtOption3.setEnabled(false);
        txtOption4.setEnabled(false);
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
        btnChooseImage.setEnabled(true);
        txtIDQuestion.setEnabled(true);
        txtQuestion.setEnabled(true);
        cbbMaTV.setEnabled(true);
        cbbTopic.setEnabled(true);
        txtOption1.setEnabled(true);
        txtOption2.setEnabled(true);
        txtOption3.setEnabled(true);
        txtOption4.setEnabled(true);
        txtAnswer.setEnabled(true);
        lblImg.setEnabled(true);
        txtSearch.setEnabled(true);
    }

    public void reset() {
        txtIDQuestion.setText("");
        cbbMaTV.setSelectedIndex(-1);
        cbbTopic.setSelectedIndex(-1);
        txtAnswer.setText("");
        txtOption1.setText("");
        txtOption2.setText("");
        txtOption3.setText("");
        txtOption4.setText("");
        lblImg.setIcon(null);
        txtQuestion.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Footer;
    private javax.swing.JPanel Header;
    private javax.swing.JPanel Main;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnChooseImage;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cbbMaTV;
    private javax.swing.JComboBox<String> cbbTopic;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblImg;
    private javax.swing.JTable tblListQuestion;
    private javax.swing.JTextField txtAnswer;
    private javax.swing.JTextField txtIDQuestion;
    private javax.swing.JTextField txtOption1;
    private javax.swing.JTextField txtOption2;
    private javax.swing.JTextField txtOption3;
    private javax.swing.JTextField txtOption4;
    private javax.swing.JTextArea txtQuestion;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
