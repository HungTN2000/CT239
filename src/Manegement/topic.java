/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manegement;

import Manegement.classData.listT;
import Manegement.classData.listV;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import user.Connect;

/**
 *
 * @author HP
 */
public class topic extends javax.swing.JPanel {

    final String colV[] = {"MÃ TV", "TỪ VỰNG", "PHIÊN ÂM", "NGHĨA"};
    final DefaultTableModel tbnV = new DefaultTableModel(colV, 0);

    final String colCHTN[] = {"MÃ CHTN", "CÂU HỎI", "ĐÁP ÁN A", "ĐÁP ÁN B", "ĐÁP ÁN C", "ĐÁP ÁN D", "HÌNH ẢNH", "CÂU TRẢ LỜI"};
    final DefaultTableModel tbnCHTN = new DefaultTableModel(colCHTN, 0);

    final String colCHDT[] = {"MÃ CHDT", "CÂU HỎI", "HÌNH ẢNH", "CÂU TRẢ LỜI"};
    final DefaultTableModel tbnCHDT = new DefaultTableModel(colCHDT, 0);

    DefaultTableModel tbn = new DefaultTableModel();
    Connect a = new Connect();
    Connection con = a.getConnection();
    Statement st = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    String fPath = null;
    byte[] img_DATA;

    private DefaultListModel mode;

    public topic() {
        initComponents();
        uploadMaTV();
        uploadMaCHTN();
        uploadMaCHDT();
    }

    public void uploadMaTV() {
        try {
            String url = "Select * from TuVung";
            pst = con.prepareStatement(url);
            rs = pst.executeQuery();

//            //Tạo 1 DefaultComboboxModel
//            DefaultComboBoxModel modelID = (DefaultComboBoxModel) cbbID.getModel();
//            modelID.removeAllElements(); //Xóa hết dữ liệu trong combobox
            while (rs.next()) {
                cbbMaTV.addItem(rs.getString("MaTV"));
            }
            rs.close();
        } catch (Exception e) {
        }
    }

    public void uploadMaCHTN() {
        try {
            String url = "Select * from CauHoiTN";
            pst = con.prepareStatement(url);
            rs = pst.executeQuery();

//            //Tạo 1 DefaultComboboxModel
//            DefaultComboBoxModel modelID = (DefaultComboBoxModel) cbbID.getModel();
//            modelID.removeAllElements(); //Xóa hết dữ liệu trong combobox
            while (rs.next()) {
                cbbMaCHTN.addItem(rs.getString("MaCHTN"));
            }
            rs.close();
        } catch (Exception e) {
        }
    }

    public void uploadMaCHDT() {
        try {
            String url = "Select * from CauHoiDT";
            pst = con.prepareStatement(url);
            rs = pst.executeQuery();

//            //Tạo 1 DefaultComboboxModel
//            DefaultComboBoxModel modelID = (DefaultComboBoxModel) cbbID.getModel();
//            modelID.removeAllElements(); //Xóa hết dữ liệu trong combobox
            while (rs.next()) {
                cbbMaCHDT.addItem(rs.getString("MaCHDT"));
            }
            rs.close();
        } catch (Exception e) {
        }
    }

    public void getConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=duan1;user=sa;password=sa2008");
            st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery("select * from ChuDe");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public ArrayList<listT> listTopicManagement() {
        ArrayList<listT> adList = new ArrayList<>();
        try {
            String url = "Select * from ChuDe";
            st = con.createStatement();
            rs = st.executeQuery(url);
            listT data;
            while (rs.next()) {
                data = new listT(rs.getString("TenChuDe"), rs.getString("MaTV"), rs.getString("MaCHTN"), rs.getString("MaCHDT"));
                adList.add(data);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return adList;
    }

    public void show_T() {
        ArrayList<listT> list = listTopicManagement();
        tbn = (DefaultTableModel) tblV.getModel();
        Object[] row = new Object[4];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getTenChuDe();
            row[1] = list.get(i).getMaTV();
            row[2] = list.get(i).getMaCHTN();
            row[3] = list.get(i).getMaCHDT();
            tbn.addRow(row);
        }
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
        HeaderSearch = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblV = new javax.swing.JTable();
        Main = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbbMaTV = new javax.swing.JComboBox<>();
        cbbMaCHDT = new javax.swing.JComboBox<>();
        cbbMaCHTN = new javax.swing.JComboBox<>();
        cbbTenChuDe = new javax.swing.JComboBox<>();
        btnTV = new javax.swing.JButton();
        btnCHTN = new javax.swing.JButton();
        btnCHDT = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblImg = new javax.swing.JLabel();
        Option = new javax.swing.JPanel();
        btnReset = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(1200, 830));
        setLayout(new java.awt.BorderLayout(0, 10));

        Header.setBackground(new java.awt.Color(255, 228, 181));
        Header.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 2, true));
        Header.setPreferredSize(new java.awt.Dimension(1200, 380));
        Header.setLayout(new java.awt.BorderLayout());

        HeaderSearch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        HeaderSearch.setOpaque(false);
        HeaderSearch.setPreferredSize(new java.awt.Dimension(350, 10));

        txtSearch.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtSearch.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search.png"))); // NOI18N
        jLabel10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel10.setOpaque(true);
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        jList1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jList1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLayeredPane1.setLayer(jList1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addComponent(jList1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addComponent(jList1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout HeaderSearchLayout = new javax.swing.GroupLayout(HeaderSearch);
        HeaderSearch.setLayout(HeaderSearchLayout);
        HeaderSearchLayout.setHorizontalGroup(
            HeaderSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(HeaderSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPane1)
                    .addGroup(HeaderSearchLayout.createSequentialGroup()
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(62, 62, 62))
        );
        HeaderSearchLayout.setVerticalGroup(
            HeaderSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderSearchLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(HeaderSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSearch)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        Header.add(HeaderSearch, java.awt.BorderLayout.WEST);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jScrollPane1.setInheritsPopupMenu(true);

        tblV.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tblV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TÊN CHỦ ĐỀ", "MÃ TỪ VỰNG", "MÃ CHTN", "MÃ CHDT"
            }
        ));
        tblV.setFillsViewportHeight(true);
        tblV.setGridColor(new java.awt.Color(153, 153, 153));
        tblV.setRowHeight(40);
        tblV.setRowMargin(5);
        tblV.setSelectionBackground(new java.awt.Color(127, 255, 212));
        tblV.setSelectionForeground(new java.awt.Color(51, 51, 51));
        tblV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblV);

        Header.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        add(Header, java.awt.BorderLayout.PAGE_START);

        Main.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        Main.setOpaque(false);
        Main.setPreferredSize(new java.awt.Dimension(1200, 400));
        Main.setLayout(new java.awt.BorderLayout(10, 10));

        jPanel1.setBackground(new java.awt.Color(255, 228, 181));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel1.setPreferredSize(new java.awt.Dimension(650, 350));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("Nội Dung:");
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jLabel7.setPreferredSize(new java.awt.Dimension(80, 50));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setText("Mã Từ Vựng");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Mã CHTN");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("Mã CHDT");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("Tên Chủ Đề");

        cbbMaTV.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cbbMaTV.setMaximumRowCount(4);
        cbbMaTV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose" }));
        cbbMaTV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbMaTVActionPerformed(evt);
            }
        });

        cbbMaCHDT.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cbbMaCHDT.setMaximumRowCount(4);
        cbbMaCHDT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose" }));

        cbbMaCHTN.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cbbMaCHTN.setMaximumRowCount(4);
        cbbMaCHTN.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose" }));

        cbbTenChuDe.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cbbTenChuDe.setMaximumRowCount(4);
        cbbTenChuDe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose", "Animal", "Bugs and insects", "Color", "Vegestable", "Fruit" }));

        btnTV.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnTV.setText("Bảng Từ Vựng");
        btnTV.setPreferredSize(new java.awt.Dimension(140, 45));
        btnTV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTVActionPerformed(evt);
            }
        });

        btnCHTN.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnCHTN.setText("Bảng CHTN");
        btnCHTN.setPreferredSize(new java.awt.Dimension(140, 45));
        btnCHTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCHTNActionPerformed(evt);
            }
        });

        btnCHDT.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnCHDT.setText("Bảng CHDT");
        btnCHDT.setPreferredSize(new java.awt.Dimension(140, 45));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbTenChuDe, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnTV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCHTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCHDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbbMaTV, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbbMaCHTN, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(cbbMaCHDT, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbMaTV, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbMaCHTN, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbMaCHDT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(86, 86, 86)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbTenChuDe, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCHTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCHDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Main.add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setBackground(new java.awt.Color(255, 153, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(500, 340));
        jPanel2.setLayout(new java.awt.BorderLayout());

        lblImg.setBackground(new java.awt.Color(255, 228, 181));
        lblImg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        lblImg.setOpaque(true);
        lblImg.setPreferredSize(new java.awt.Dimension(600, 300));
        jPanel2.add(lblImg, java.awt.BorderLayout.CENTER);

        Main.add(jPanel2, java.awt.BorderLayout.EAST);

        add(Main, java.awt.BorderLayout.CENTER);

        Option.setBackground(new java.awt.Color(255, 228, 181));
        Option.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        Option.setPreferredSize(new java.awt.Dimension(14, 60));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 10);
        flowLayout1.setAlignOnBaseline(true);
        Option.setLayout(flowLayout1);

        btnReset.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnReset.setText("Thêm mới");
        btnReset.setPreferredSize(new java.awt.Dimension(120, 35));
        Option.add(btnReset);

        btnSave.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnSave.setText("Lưu");
        btnSave.setPreferredSize(new java.awt.Dimension(120, 35));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        Option.add(btnSave);

        btnUpdate.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnUpdate.setText("Cập nhật");
        btnUpdate.setPreferredSize(new java.awt.Dimension(120, 35));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        Option.add(btnUpdate);

        btnDelete.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnDelete.setText("Xóa");
        btnDelete.setPreferredSize(new java.awt.Dimension(120, 35));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        Option.add(btnDelete);

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton6.setText("jButton6");
        jButton6.setPreferredSize(new java.awt.Dimension(120, 35));
        Option.add(jButton6);

        add(Option, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            String url = "insert into ChuDe values (?,?,?,?)";
            pst = con.prepareStatement(url);
            pst.setString(1, cbbTenChuDe.getSelectedItem().toString());
            pst.setString(2, cbbMaTV.getSelectedItem().toString());
            pst.setString(3, cbbMaCHTN.getSelectedItem().toString());
            pst.setString(4, cbbMaCHDT.getSelectedItem().toString());
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel) tblV.getModel();
            model.setRowCount(0);
            show_T();
            getConnection();
            JOptionPane.showMessageDialog(null, "Lưu dữ liệu thành công.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void tblVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVMouseClicked
        int i = tblV.getSelectedRow();
        TableModel model = tblV.getModel();
    }//GEN-LAST:event_tblVMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
//            int row = tblV.getSelectedRow();
//            String value = (tblV.getModel().getValueAt(row, 0).toString());
            pst = con.prepareStatement("Update ChuDe set MaTV=?,MaCHTN=?,MaCHDT=? where TenChuDe=?");
            pst.setString(4, cbbTenChuDe.getSelectedItem().toString());
            pst.setString(1, cbbMaTV.getSelectedItem().toString());
            pst.setString(2, cbbMaCHTN.getSelectedItem().toString());
            pst.setString(3, cbbMaCHDT.getSelectedItem().toString());
            pst.executeUpdate();
            tbn = (DefaultTableModel) tblV.getModel();
            tbn.setRowCount(0);
            show_T();
            JOptionPane.showMessageDialog(this, "Cập nhật thành công.");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            pst = con.prepareStatement("Delete ChuDe where TenChuDe=?");
            pst.setString(1, tblV.getValueAt(tblV.getSelectedRow(), 0).toString());
            if (JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa?", "Confirm", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                pst.executeUpdate();
                tbn = (DefaultTableModel) tblV.getModel();
                tbn.setRowCount(0);
                show_T();
                JOptionPane.showMessageDialog(this, "Xóa thành công");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Xóa thất bại");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        DefaultTableModel model = (DefaultTableModel) tblV.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<DefaultTableModel>(model);
        tblV.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(txtSearch.getText().trim()));
    }//GEN-LAST:event_txtSearchKeyReleased

    private void cbbMaTVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbMaTVActionPerformed
        try {
            pst = con.prepareStatement("Select HinhAnh from TuVung where MaTV=?");
            pst.setString(1, cbbMaTV.getSelectedItem().toString());
            rs = pst.executeQuery();
            if (rs.next()) {
                byte[] img = rs.getBytes("HinhAnh");
                ImageIcon imgIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(lblImg.getWidth(), lblImg.getHeight(), Image.SCALE_SMOOTH));
                lblImg.setIcon(imgIcon);
                img_DATA = img;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_cbbMaTVActionPerformed

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        try {
            pst = con.prepareStatement("Select HinhAnh from TuVung where MaTV=?");
            pst.setString(1, cbbMaTV.getSelectedItem().toString());
            rs = pst.executeQuery();
            tbn = (DefaultTableModel) tblV.getModel();
            tbn.setRowCount(0);
            show_T();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_jLabel10MouseClicked

    private void btnTVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTVActionPerformed
        try {
            int number;
            Vector row, column;
            column = new Vector();
            st = con.createStatement();
            rs = st.executeQuery("Select * from TuVung");
            ResultSetMetaData metadata = rs.getMetaData();
            number = metadata.getColumnCount(); //trả về số cột
            tbnV.setRowCount(0);
//            for (int i = 1; i <= number; i++) {
//                column.add(metadata.getColumnName(i)); //lấy ra tiêu đề của các cột
//            }
            //tbnV.setColumnIdentifiers(column);
            while (rs.next()) {
                row = new Vector();
                for (int i = 1; i <= number; i++) {
                    row.addElement(rs.getString(i));
                }
                tbnV.addRow(row);
                tblV.setModel(tbnV);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnTVActionPerformed

    private void btnCHTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCHTNActionPerformed
        try {
            int number;
            Vector row, column;
            column = new Vector();
            st = con.createStatement();
            rs = st.executeQuery("Select * from CauHoiTN");
            ResultSetMetaData metadata = rs.getMetaData();
            number = metadata.getColumnCount(); //trả về số cột
            tbnCHTN.setRowCount(0);
//            for (int i = 1; i <= number; i++) {
//                column.add(metadata.getColumnName(i)); //lấy ra tiêu đề của các cột
//            }
            //tbnV.setColumnIdentifiers(column);
            while (rs.next()) {
                row = new Vector();
                for (int i = 1; i <= number; i++) {
                    row.addElement(rs.getString(i));
                }
                tbnCHTN.addRow(row);
                tblV.setModel(tbnCHTN);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnCHTNActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Header;
    private javax.swing.JPanel HeaderSearch;
    private javax.swing.JPanel Main;
    private javax.swing.JPanel Option;
    private javax.swing.JButton btnCHDT;
    private javax.swing.JButton btnCHTN;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnTV;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbbMaCHDT;
    private javax.swing.JComboBox<String> cbbMaCHTN;
    private javax.swing.JComboBox<String> cbbMaTV;
    private javax.swing.JComboBox<String> cbbTenChuDe;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblImg;
    private javax.swing.JTable tblV;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
