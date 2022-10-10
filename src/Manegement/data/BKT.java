/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manegement.data;

import Manegement.classData.listBKT;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
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
public class BKT extends javax.swing.JPanel {

    DefaultTableModel tbn = new DefaultTableModel();
    Connect a = new Connect();
    Connection con = a.getConnection();
    Statement st = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    String fPath = null;
    byte[] img_DATA;

    private DefaultListModel mode;

    public BKT() {
        initComponents();
        dataEnabledButton();
        loadDataCBBMaND();
        loadDataCBBLevel();
        loadDataCBBTopic();
        show_V();
    }

    public void getConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=duan1;user=sa;password=sa2008");
            st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery("select * from BaiKiemTra");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public ArrayList<listBKT> listVocabularyManagement() {
        ArrayList<listBKT> adList = new ArrayList<>();
        try {
            String url = "Select * from BaiKiemTra";
            st = con.createStatement();
            rs = st.executeQuery(url);
            listBKT data;
            while (rs.next()) {
                data = new listBKT(rs.getString("MaBKT"), rs.getString("MaND"), rs.getString("TenCapDo"), rs.getString("TenChuDe"), rs.getFloat("Diem"));
                adList.add(data);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return adList;
    }

    public void show_V() {
        ArrayList<listBKT> list = listVocabularyManagement();
        DefaultTableModel model = (DefaultTableModel) tblBKT.getModel();
        Object[] row = new Object[5];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getMaBKT();
            row[1] = list.get(i).getMaND();
            row[2] = list.get(i).getTenCapDo();
            row[3] = list.get(i).getTenChuDe();
            row[4] = list.get(i).getDiem();
            model.addRow(row);
        }
        JTableHeader Theader = tblBKT.getTableHeader();
        
        Theader.setBackground(new Color(255,215,0));
        Theader.setForeground(Color.black);
        
        Theader.setFont(new Font("Tahome", Font.PLAIN, 16));
        ((DefaultTableCellRenderer)Theader.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        
        tblBKT.setFont(new Font("Tahome", Font.PLAIN, 16));
    }

//    public ImageIcon ResizeImage(String ImagePath) {
//        ImageIcon MyImage = new ImageIcon(ImagePath);
//        Image img = MyImage.getImage();
//        Image newImg = img.getScaledInstance(lblImg.getWidth(), lblImg.getHeight(), Image.SCALE_SMOOTH);
//        ImageIcon image = new ImageIcon(newImg);
//        return image;
//    }
    public void loadDataCBBMaND() {
        try {
            pst = con.prepareStatement("Select * from NguoiDung");
            rs = pst.executeQuery();

            //Tạo 1 DefaultComboboxModel
            DefaultComboBoxModel dataCBBTopic = (DefaultComboBoxModel) cbbMaND.getModel();
            dataCBBTopic.removeAllElements(); //Xóa hết dữ liệu trong combobox
            while (rs.next()) {
                cbbMaND.addItem(rs.getString("MaND"));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi tải dữ liệu MaND!");
        }
    }

    public void loadDataCBBLevel() {
        try {
            pst = con.prepareStatement("Select * from CapDo");
            rs = pst.executeQuery();

            //Tạo 1 DefaultComboboxModel
            DefaultComboBoxModel dataCBBTopic = (DefaultComboBoxModel) cbbTenCapDo.getModel();
            dataCBBTopic.removeAllElements(); //Xóa hết dữ liệu trong combobox
            while (rs.next()) {
                cbbTenCapDo.addItem(rs.getString("TenCapDo"));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi tải dữ liệu TenCapDo!");
        }
    }

    public void loadDataCBBTopic() {
        try {
            pst = con.prepareStatement("Select * from ChuDe");
            rs = pst.executeQuery();

            //Tạo 1 DefaultComboboxModel
            DefaultComboBoxModel dataCBBTopic = (DefaultComboBoxModel) cbbTenChuDe.getModel();
            dataCBBTopic.removeAllElements(); //Xóa hết dữ liệu trong combobox
            while (rs.next()) {
                cbbTenChuDe.addItem(rs.getString("TenChuDe"));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi tải dữ liệu TenChuDe!");
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

        Hearder = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        btnSearch = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        Main = new javax.swing.JPanel();
        Left = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBKT = new javax.swing.JTable();
        Right = new javax.swing.JPanel();
        RightTop = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMaBKT = new javax.swing.JTextField();
        cbbMaND = new javax.swing.JComboBox<>();
        cbbTenCapDo = new javax.swing.JComboBox<>();
        cbbTenChuDe = new javax.swing.JComboBox<>();
        txtDiem = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        RightLast = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(245, 245, 220));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 102), 1, true));

        Hearder.setBackground(new java.awt.Color(255, 255, 255));
        Hearder.setPreferredSize(new java.awt.Dimension(0, 200));

        jPanel7.setBackground(new java.awt.Color(255, 250, 240));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search.png"))); // NOI18N
        btnSearch.setPreferredSize(new java.awt.Dimension(65, 35));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        txtSearch.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtSearch.setPreferredSize(new java.awt.Dimension(6, 35));
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel8.setText("Tìm kiếm");
        jLabel8.setPreferredSize(new java.awt.Dimension(120, 35));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(768, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34))))
        );

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("DỮ LIỆU BÀI KIỂM TRA");
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jLabel7.setPreferredSize(new java.awt.Dimension(250, 50));

        javax.swing.GroupLayout HearderLayout = new javax.swing.GroupLayout(Hearder);
        Hearder.setLayout(HearderLayout);
        HearderLayout.setHorizontalGroup(
            HearderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        HearderLayout.setVerticalGroup(
            HearderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HearderLayout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Main.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        Main.setLayout(new java.awt.BorderLayout());

        Left.setPreferredSize(new java.awt.Dimension(500, 410));
        Left.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        tblBKT.setAutoCreateRowSorter(true);
        tblBKT.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tblBKT.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tblBKT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MÃ BKT", "MÃ ND", "TÊN CẤP ĐỘ", "TÊN CHỦ ĐỀ", "ĐIỂM", "NGÀY KT"
            }
        ));
        tblBKT.setFillsViewportHeight(true);
        tblBKT.setFocusCycleRoot(true);
        tblBKT.setGridColor(new java.awt.Color(0, 0, 0));
        tblBKT.setRowHeight(30);
        tblBKT.setSelectionBackground(new java.awt.Color(72, 209, 204));
        tblBKT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBKTMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBKT);

        Left.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        Main.add(Left, java.awt.BorderLayout.CENTER);

        Right.setPreferredSize(new java.awt.Dimension(460, 100));
        Right.setLayout(new java.awt.BorderLayout());

        RightTop.setBackground(new java.awt.Color(255, 250, 240));
        RightTop.setPreferredSize(new java.awt.Dimension(500, 310));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setText("Mã BKT");
        jLabel1.setPreferredSize(new java.awt.Dimension(120, 35));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Mã ND");
        jLabel2.setPreferredSize(new java.awt.Dimension(120, 35));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("Tên cấp độ");
        jLabel3.setPreferredSize(new java.awt.Dimension(120, 35));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("Tên chủ đề");
        jLabel4.setPreferredSize(new java.awt.Dimension(120, 35));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setText("Điểm");
        jLabel5.setPreferredSize(new java.awt.Dimension(120, 35));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setText("Ngày KT");
        jLabel6.setPreferredSize(new java.awt.Dimension(120, 35));

        txtMaBKT.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtMaBKT.setPreferredSize(new java.awt.Dimension(300, 35));

        cbbMaND.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cbbMaND.setPreferredSize(new java.awt.Dimension(300, 35));

        cbbTenCapDo.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cbbTenCapDo.setPreferredSize(new java.awt.Dimension(300, 35));

        cbbTenChuDe.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cbbTenChuDe.setPreferredSize(new java.awt.Dimension(300, 35));

        txtDiem.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtDiem.setPreferredSize(new java.awt.Dimension(300, 35));

        jDateChooser1.setPreferredSize(new java.awt.Dimension(300, 35));

        javax.swing.GroupLayout RightTopLayout = new javax.swing.GroupLayout(RightTop);
        RightTop.setLayout(RightTopLayout);
        RightTopLayout.setHorizontalGroup(
            RightTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightTopLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(RightTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(RightTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMaBKT, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                    .addGroup(RightTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(cbbTenChuDe, javax.swing.GroupLayout.Alignment.LEADING, 0, 150, Short.MAX_VALUE)
                        .addComponent(cbbTenCapDo, javax.swing.GroupLayout.Alignment.LEADING, 0, 1, Short.MAX_VALUE)
                        .addComponent(cbbMaND, javax.swing.GroupLayout.Alignment.LEADING, 0, 1, Short.MAX_VALUE))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        RightTopLayout.setVerticalGroup(
            RightTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightTopLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(RightTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaBKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(RightTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbMaND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(RightTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbTenCapDo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(RightTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbTenChuDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(RightTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(RightTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Right.add(RightTop, java.awt.BorderLayout.CENTER);

        RightLast.setBackground(new java.awt.Color(255, 250, 250));
        RightLast.setPreferredSize(new java.awt.Dimension(500, 200));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 20);
        flowLayout1.setAlignOnBaseline(true);
        RightLast.setLayout(flowLayout1);

        btnAdd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAdd.setText("THÊM");
        btnAdd.setPreferredSize(new java.awt.Dimension(120, 40));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        RightLast.add(btnAdd);

        btnSave.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSave.setText("LƯU");
        btnSave.setPreferredSize(new java.awt.Dimension(120, 40));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        RightLast.add(btnSave);

        btnEdit.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnEdit.setText("SỬA");
        btnEdit.setPreferredSize(new java.awt.Dimension(120, 40));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        RightLast.add(btnEdit);

        btnDelete.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnDelete.setText("XÓA");
        btnDelete.setPreferredSize(new java.awt.Dimension(120, 40));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        RightLast.add(btnDelete);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("LÀM MỚI");
        jButton1.setPreferredSize(new java.awt.Dimension(120, 40));
        RightLast.add(jButton1);

        Right.add(RightLast, java.awt.BorderLayout.PAGE_END);

        Main.add(Right, java.awt.BorderLayout.EAST);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Hearder, javax.swing.GroupLayout.PREFERRED_SIZE, 1198, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(Main, javax.swing.GroupLayout.PREFERRED_SIZE, 1198, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Hearder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(Main, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        btnAdd.setEnabled(false);
        dataNotEnabledButton();
        reset();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            String url = "insert into BaiKiemTra values (?,?,?,?,?)";
            pst = con.prepareStatement(url);
            pst.setString(1, txtMaBKT.getText());
            pst.setString(2, cbbMaND.getSelectedItem().toString());
            pst.setString(3, cbbTenCapDo.getSelectedItem().toString());
            pst.setString(4, cbbTenChuDe.getSelectedItem().toString());
            pst.setString(5, txtDiem.getText());
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel) tblBKT.getModel();
            model.setRowCount(0);
            show_V();
            JOptionPane.showMessageDialog(null, "Lưu dữ liệu thành công.");
            btnAdd.setEnabled(true);
            dataEnabledButton();
            reset();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            pst = con.prepareStatement("Delete BaiKiemTra where MaBKT=?");
            pst.setString(1, tblBKT.getValueAt(tblBKT.getSelectedRow(), 0).toString());
            if (JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa?", "Confirm", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                pst.executeUpdate();
                DefaultTableModel model = (DefaultTableModel) tblBKT.getModel();
                model.setRowCount(0);
                show_V();
                JOptionPane.showMessageDialog(this, "Xóa thành công");
            }
            btnAdd.setEnabled(true);
            dataEnabledButton();
            reset();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Xóa thất bại");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        try {
            pst = con.prepareStatement("Update BaiKiemTra set MaND=?,TenCapDo=?,TenChuDe=?,Diem=? where MaBKT=?");
            pst.setString(5, txtMaBKT.getText());
            pst.setString(1, cbbMaND.getSelectedItem().toString());
            pst.setString(2, cbbTenCapDo.getSelectedItem().toString());
            pst.setString(3, cbbTenChuDe.getSelectedItem().toString());
            pst.setString(4, txtDiem.getText());
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel) tblBKT.getModel();
            model.setRowCount(0);
            show_V();
            JOptionPane.showMessageDialog(this, "Cập nhật thành công.");
            btnAdd.setEnabled(true);
            dataEnabledButton();
            reset();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void tblBKTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBKTMouseClicked
        int i = tblBKT.getSelectedRow();
        TableModel model = tblBKT.getModel();

        txtMaBKT.setText(model.getValueAt(i, 0).toString());
        cbbMaND.setSelectedItem(model.getValueAt(i, 1).toString());
        cbbTenCapDo.setSelectedItem(model.getValueAt(i, 2).toString());
        cbbTenChuDe.setSelectedItem(model.getValueAt(i, 3).toString());
        txtDiem.setText(model.getValueAt(i, 4).toString());

        btnAdd.setEnabled(false);
        dataNotEnabledButton();
    }//GEN-LAST:event_tblBKTMouseClicked

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        DefaultTableModel model = (DefaultTableModel) tblBKT.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<DefaultTableModel>(model);
        tblBKT.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(txtSearch.getText().trim()));
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        try {
            pst = con.prepareStatement("Select * from BaiKiemTra where MaBKT=?");
            pst.setString(1, txtSearch.getText());
            rs = pst.executeQuery();
            while (rs.next()) {
                txtMaBKT.setText(rs.getString("MaBKT"));
                cbbMaND.setSelectedItem(rs.getString("MaND"));
                cbbTenCapDo.setSelectedItem(rs.getString("TenCapDo"));
                cbbTenChuDe.setSelectedItem(rs.getString("TenChuDe"));
                txtDiem.setText(rs.getString("Diem"));
            }
            btnAdd.setEnabled(false);
            dataNotEnabledButton();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    public void dataEnabledButton() {
        btnSave.setEnabled(false);
        btnEdit.setEnabled(false);
        btnDelete.setEnabled(false);
        txtMaBKT.setEnabled(false);
        cbbMaND.setEnabled(false);
        cbbTenCapDo.setEnabled(false);
        cbbTenChuDe.setEnabled(false);
        txtDiem.setEnabled(false);
    }

    public void dataNotEnabledButton() {
        btnSave.setEnabled(true);
        btnEdit.setEnabled(true);
        btnDelete.setEnabled(true);
        txtMaBKT.setEnabled(true);
        cbbMaND.setEnabled(true);
        cbbTenCapDo.setEnabled(true);
        cbbTenChuDe.setEnabled(true);
        txtDiem.setEnabled(true);
    }

    public void reset() {
        txtMaBKT.setText("");
        cbbMaND.setSelectedItem(0);
        cbbTenCapDo.setSelectedItem(0);
        cbbTenChuDe.setSelectedItem(0);
        txtDiem.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Hearder;
    private javax.swing.JPanel Left;
    private javax.swing.JPanel Main;
    private javax.swing.JPanel Right;
    private javax.swing.JPanel RightLast;
    private javax.swing.JPanel RightTop;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cbbMaND;
    private javax.swing.JComboBox<String> cbbTenCapDo;
    private javax.swing.JComboBox<String> cbbTenChuDe;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblBKT;
    private javax.swing.JTextField txtDiem;
    private javax.swing.JTextField txtMaBKT;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

}
