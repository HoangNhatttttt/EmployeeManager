package com.em.GUI;
import com.em.BUS.NhanVien_BUS;
import javax.swing.*;
import com.em.BUS.Validates_BUS;
import com.em.DAO.NhanVien_DAO;
import com.em.DTO.NhanVien_DTO;
import java.awt.Component;
import java.awt.Container;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class App_UI extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(App_UI.class.getName());
    
    public App_UI() {
        initComponents();
        
        // Chọn cái nào thì sẽ trả về giá trị đó, trích xuất thông qua ButtonGroup
        gioiTinhNu.setActionCommand("F");
        gioiTinhNam.setActionCommand("M");
        
        // JTable cho NhanVien list
        InitNhanVienTable();
        UpdateNhanVienTable();
        
    }
    // Tạo default table 
    private DefaultTableModel defaultTableModel = new DefaultTableModel();
    
    public void InitComboBox(){
        
    }
    
    public void InitNhanVienTable(){
        
        // Trỏ default table tới employee table
        employeeTable.setModel(defaultTableModel);
        
        // Thêm cột cho default table --> employee table cũng thêm cột
        defaultTableModel.addColumn("Mã nhân viên");
        defaultTableModel.addColumn("Họ tên");
        defaultTableModel.addColumn("Ngày sinh");
        defaultTableModel.addColumn("Giới tính");
        defaultTableModel.addColumn("Địa chỉ");
        defaultTableModel.addColumn("Số điện thoại");
        defaultTableModel.addColumn("Mã lương");
        defaultTableModel.addColumn("Mã phòng ban");
        defaultTableModel.addColumn("mã chức vụ");
        defaultTableModel.addColumn("Mã hợp đồng");
        defaultTableModel.addColumn("Trạng thái");
        
        // Chỉ được chọn 1 dòng/employee trong 1 lúc
        ListSelectionModel listSelectionModel = employeeTable.getSelectionModel();
        listSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        //Mỗi lần chọn 1 employee sẽ hiện thông tin employee lên information panel
        listSelectionModel.addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e){
                // Trích xuất vị trí ô dòng/employee được chọn
                
                int rowIndex = employeeTable.getSelectedRow();
                // TH nếu chọn 1 employee/dòng trong JTable rồi JTable reset data --> ValueChanged --> rowIndex = -1 do không có data trong JTable
                // ==> Gây ra lỗi khi trích xuất dữ liệu từ JTable
                if(rowIndex != -1){ //TH database không có dữ liệu thì không cần trích xuất dữ liệu từ JTable và không update Information Panel
                    
                    // Trích xuất dữ liệu các cột của dòng được chọn
                    String maNhanVien = employeeTable.getValueAt(rowIndex, 0).toString(); 
                    String hoTen = employeeTable.getValueAt(rowIndex, 1).toString();
                    String ngaySinh = employeeTable.getValueAt(rowIndex, 2).toString();
                    String gioiTinh = employeeTable.getValueAt(rowIndex, 3).toString();
                    String diaChi = employeeTable.getValueAt(rowIndex, 4).toString();
                    String soDienThoai = employeeTable.getValueAt(rowIndex, 5).toString();
                    String maLuong = employeeTable.getValueAt(rowIndex, 6).toString();
                    String maPhongBan = employeeTable.getValueAt(rowIndex, 7).toString();
                    String maChucVu = employeeTable.getValueAt(rowIndex, 8).toString();
                    String maHopDong = employeeTable.getValueAt(rowIndex, 9).toString();
                    String trangThai = employeeTable.getValueAt(rowIndex, 10).toString();

                    // Hiển thị dữ liệu lên information panel
                    maNhanVienField.setText(maNhanVien);
                    hoTenField.setText(hoTen);
                    diaChiField.setText(diaChi);
                    soDienThoaiField.setText(soDienThoai);
                    
                    

                    // Kiểm tra giới tính rồi chọn tương ứng
                    if(gioiTinh.equals("M"))
                        gioiTinhNam.setSelected(true);
                    else
                        gioiTinhNu.setSelected(true);
                }  
            }
        });
    }
    
    public void ClearTextFields(Container container) {
        for (Component c : container.getComponents()) {
            if (c instanceof JTextField) 
                ((JTextField) c).setText("");

            else if (c instanceof Container) 
                ClearTextFields((Container) c);      
        }
    }
    
    private void UpdateNhanVienTable(){
        try {
            // Trích xuất toàn bộ employee từ database
            NhanVien_BUS NhanVien_BUS = new NhanVien_BUS();
            ArrayList<NhanVien_DTO> nhanVienList = NhanVien_BUS.GetAllNhanVien();
            
            // Hàm sẽ lấy toàn bộ dữ liệu từ database (bao gồm cả dữ liệu có sẵn trong JTable) --> Làm sạch JTable rồi add lại toàn bộ dữ liệu
            defaultTableModel.setRowCount(0); // Xoá toàn bộ dòng trong JTable 
            
            
            //Add rows
            for (NhanVien_DTO nhanVien : nhanVienList) {
                defaultTableModel.addRow(new Object[]{
                    nhanVien.getMaNhanVien(),
                    nhanVien.getHoTen(),
                    nhanVien.getNgaySinh(),
                    nhanVien.getGioiTinh(),
                    nhanVien.getDiaChi(),
                    nhanVien.getSoDienThoai(),
                    nhanVien.getMaLuong(),
                    nhanVien.getMaPhongBan(),
                    nhanVien.getMaChucVu(),
                    nhanVien.getMaHopDong(),
                    nhanVien.getTrangThai()
                });
            } 
        }
        
        catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "Error loading employee data: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        genderButtonGroup = new javax.swing.ButtonGroup();
        bangMenu = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        bangChucNang = new javax.swing.JPanel();
        salaryPanel = new javax.swing.JPanel();
        Label4 = new javax.swing.JLabel();
        Label3 = new javax.swing.JLabel();
        bangThongTin = new javax.swing.JPanel();
        maNhanVienLabel = new javax.swing.JLabel();
        hoTenLabel = new javax.swing.JLabel();
        ngaySinhLabel = new javax.swing.JLabel();
        gioiTinhLabel = new javax.swing.JLabel();
        diaChiLabel = new javax.swing.JLabel();
        soDienThoaiLabel = new javax.swing.JLabel();
        maNhanVienField = new javax.swing.JTextField();
        hoTenField = new javax.swing.JTextField();
        ngaySinhChooser = new com.toedter.calendar.JDateChooser();
        gioiTinhNam = new javax.swing.JRadioButton();
        gioiTinhNu = new javax.swing.JRadioButton();
        diaChiField = new javax.swing.JTextField();
        soDienThoaiField = new javax.swing.JTextField();
        maPhongBan = new javax.swing.JLabel();
        maChucVu = new javax.swing.JLabel();
        maHopDong = new javax.swing.JLabel();
        trangThai = new javax.swing.JLabel();
        maPhongBanBox = new javax.swing.JComboBox<>();
        maTrangThaiBox = new javax.swing.JComboBox<>();
        maChucVuField = new javax.swing.JTextField();
        maHopDongField = new javax.swing.JTextField();
        bangNhanVien = new javax.swing.JScrollPane();
        employeeTable1 = new javax.swing.JTable();
        bangCongCu = new javax.swing.JPanel();
        addButton1 = new javax.swing.JButton();
        deleteButton1 = new javax.swing.JButton();
        updateButton1 = new javax.swing.JButton();
        newButton1 = new javax.swing.JButton();
        editButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        employeePanel = new javax.swing.JPanel();
        employeeList = new javax.swing.JScrollPane();
        employeeTable = new javax.swing.JTable();
        Label2 = new javax.swing.JLabel();
        Label1 = new javax.swing.JLabel();
        informationPanel = new javax.swing.JPanel();
        idLabel = new javax.swing.JLabel();
        firstNameLabel = new javax.swing.JLabel();
        lastNameLabel = new javax.swing.JLabel();
        ageLabel = new javax.swing.JLabel();
        genderLabel = new javax.swing.JLabel();
        salaryLabel = new javax.swing.JLabel();
        jobPositionLabel = new javax.swing.JLabel();
        phoneNumberLabel = new javax.swing.JLabel();
        idTextField = new javax.swing.JTextField();
        firstNameTextField = new javax.swing.JTextField();
        lastNameTextField = new javax.swing.JTextField();
        ageTextField = new javax.swing.JTextField();
        maleRadioButton = new javax.swing.JRadioButton();
        femaleRadioButton = new javax.swing.JRadioButton();
        salaryTextField = new javax.swing.JTextField();
        jobPositionTextField = new javax.swing.JTextField();
        phoneNumbersTextField = new javax.swing.JTextField();
        utilitiesPanel = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        newButton = new javax.swing.JButton();
        editButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 153, 153));

        bangMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton1.setText("Nhân viên");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Luong");

        jButton3.setText("jButton3");

        jButton4.setText("jButton4");

        jButton5.setText("jButton5");

        jButton6.setText("jButton6");

        jButton7.setText("jButton7");

        jButton8.setText("jButton8");

        javax.swing.GroupLayout bangMenuLayout = new javax.swing.GroupLayout(bangMenu);
        bangMenu.setLayout(bangMenuLayout);
        bangMenuLayout.setHorizontalGroup(
            bangMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bangMenuLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(bangMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton8)
                    .addComponent(jButton7)
                    .addComponent(jButton6)
                    .addComponent(jButton5)
                    .addComponent(jButton4)
                    .addComponent(jButton3)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        bangMenuLayout.setVerticalGroup(
            bangMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bangMenuLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jButton1)
                .addGap(29, 29, 29)
                .addComponent(jButton2)
                .addGap(35, 35, 35)
                .addComponent(jButton3)
                .addGap(42, 42, 42)
                .addComponent(jButton4)
                .addGap(31, 31, 31)
                .addComponent(jButton5)
                .addGap(35, 35, 35)
                .addComponent(jButton6)
                .addGap(33, 33, 33)
                .addComponent(jButton7)
                .addGap(43, 43, 43)
                .addComponent(jButton8)
                .addContainerGap(206, Short.MAX_VALUE))
        );

        bangChucNang.setPreferredSize(new java.awt.Dimension(1000, 1000));
        bangChucNang.setLayout(new java.awt.CardLayout());

        salaryPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Label4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Label4.setText("Danh sách nhân viên");
        salaryPanel.add(Label4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, -1, -1));

        Label3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Label3.setText("Thông tin nhân viên");
        salaryPanel.add(Label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        bangThongTin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        maNhanVienLabel.setText("Mã nhân viên");

        hoTenLabel.setText("Họ và tên");

        ngaySinhLabel.setText("Ngày Sinh");

        gioiTinhLabel.setText("Giới tính");

        diaChiLabel.setText("Địa chỉ");

        soDienThoaiLabel.setText("Số điện thoại");

        maNhanVienField.setEditable(false);

        genderButtonGroup.add(gioiTinhNam);
        gioiTinhNam.setText("Male");

        genderButtonGroup.add(gioiTinhNu);
        gioiTinhNu.setText("Female");

        maPhongBan.setText("Mã phòng ban");

        maChucVu.setText("Mã chức vụ");

        maHopDong.setText("Mã hợp đồng");

        trangThai.setText("Trạng thái");

        maPhongBanBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        maTrangThaiBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yes", "No", " " }));

        maChucVuField.setEditable(false);

        maHopDongField.setEditable(false);

        javax.swing.GroupLayout bangThongTinLayout = new javax.swing.GroupLayout(bangThongTin);
        bangThongTin.setLayout(bangThongTinLayout);
        bangThongTinLayout.setHorizontalGroup(
            bangThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bangThongTinLayout.createSequentialGroup()
                .addGroup(bangThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bangThongTinLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(bangThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hoTenLabel)
                            .addComponent(ngaySinhLabel)
                            .addComponent(gioiTinhLabel)
                            .addComponent(diaChiLabel)
                            .addComponent(soDienThoaiLabel)))
                    .addGroup(bangThongTinLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(maNhanVienLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35)
                .addGroup(bangThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bangThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(diaChiField)
                        .addComponent(hoTenField)
                        .addGroup(bangThongTinLayout.createSequentialGroup()
                            .addComponent(gioiTinhNam)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 191, Short.MAX_VALUE)
                            .addComponent(gioiTinhNu))
                        .addComponent(soDienThoaiField)
                        .addComponent(maNhanVienField))
                    .addComponent(ngaySinhChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(bangThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(bangThongTinLayout.createSequentialGroup()
                        .addComponent(trangThai)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(maTrangThaiBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bangThongTinLayout.createSequentialGroup()
                        .addGroup(bangThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(maPhongBan)
                            .addComponent(maChucVu)
                            .addComponent(maHopDong))
                        .addGap(65, 65, 65)
                        .addGroup(bangThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(maHopDongField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(maPhongBanBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(maChucVuField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        bangThongTinLayout.setVerticalGroup(
            bangThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bangThongTinLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(bangThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maNhanVienLabel)
                    .addComponent(maNhanVienField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maPhongBan)
                    .addComponent(maPhongBanBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(bangThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hoTenLabel)
                    .addComponent(hoTenField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maChucVu)
                    .addComponent(maChucVuField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(bangThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bangThongTinLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(bangThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bangThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ngaySinhLabel)
                                .addComponent(maHopDong))
                            .addComponent(ngaySinhChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(bangThongTinLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(maHopDongField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bangThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(trangThai)
                    .addComponent(maTrangThaiBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(bangThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gioiTinhNam)
                    .addComponent(gioiTinhNu)
                    .addComponent(gioiTinhLabel))
                .addGap(15, 15, 15)
                .addGroup(bangThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(diaChiField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(diaChiLabel))
                .addGap(58, 58, 58)
                .addGroup(bangThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(soDienThoaiField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(soDienThoaiLabel))
                .addGap(30, 30, 30))
        );

        salaryPanel.add(bangThongTin, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 890, -1));

        employeeTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        bangNhanVien.setViewportView(employeeTable1);

        salaryPanel.add(bangNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 1070, 250));

        bangCongCu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        addButton1.setText("Add");
        addButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButton1addEmployeeButton(evt);
            }
        });

        deleteButton1.setText("Delete");
        deleteButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButton1(evt);
            }
        });

        updateButton1.setText("Update");
        updateButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButton1updateJTableButton(evt);
            }
        });

        newButton1.setText("New");
        newButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButton1newEmployeeButton(evt);
            }
        });

        editButton2.setText("Edit");
        editButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButton2editButton(evt);
            }
        });

        javax.swing.GroupLayout bangCongCuLayout = new javax.swing.GroupLayout(bangCongCu);
        bangCongCu.setLayout(bangCongCuLayout);
        bangCongCuLayout.setHorizontalGroup(
            bangCongCuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bangCongCuLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(bangCongCuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(newButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );
        bangCongCuLayout.setVerticalGroup(
            bangCongCuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bangCongCuLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(newButton1)
                .addGap(57, 57, 57)
                .addComponent(addButton1)
                .addGap(34, 34, 34)
                .addComponent(updateButton1)
                .addGap(30, 30, 30)
                .addComponent(editButton2)
                .addGap(29, 29, 29)
                .addComponent(deleteButton1)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        salaryPanel.add(bangCongCu, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 40, -1, -1));

        bangChucNang.add(salaryPanel, "card3");

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton9.setText("jButton9");
        jPanel2.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 200, -1, -1));

        jLabel2.setText("jLabel2");
        jLabel2.setPreferredSize(new java.awt.Dimension(100, 100));
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 380, -1, -1));

        bangChucNang.add(jPanel2, "card4");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1091, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 708, Short.MAX_VALUE)
        );

        bangChucNang.add(jPanel3, "card5");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1091, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 708, Short.MAX_VALUE)
        );

        bangChucNang.add(jPanel4, "card6");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1091, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 708, Short.MAX_VALUE)
        );

        bangChucNang.add(jPanel5, "card7");

        employeePanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        employeePanel.setPreferredSize(new java.awt.Dimension(1000, 800));

        employeeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        employeeList.setViewportView(employeeTable);

        Label2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Label2.setText("Employee list");

        Label1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Label1.setText("Employee information:");

        informationPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        idLabel.setText("ID");

        firstNameLabel.setText("First name:");

        lastNameLabel.setText("Last name:");

        ageLabel.setText("Age:");

        genderLabel.setText("Gender");

        salaryLabel.setText("Salary:");

        jobPositionLabel.setText("Job position:");

        phoneNumberLabel.setText("Phone numbers:");

        idTextField.setEditable(false);

        genderButtonGroup.add(maleRadioButton);
        maleRadioButton.setText("Male");

        genderButtonGroup.add(femaleRadioButton);
        femaleRadioButton.setText("Female");

        javax.swing.GroupLayout informationPanelLayout = new javax.swing.GroupLayout(informationPanel);
        informationPanel.setLayout(informationPanelLayout);
        informationPanelLayout.setHorizontalGroup(
            informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(informationPanelLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(firstNameLabel)
                    .addComponent(idLabel)
                    .addComponent(lastNameLabel)
                    .addComponent(ageLabel)
                    .addComponent(genderLabel)
                    .addComponent(salaryLabel)
                    .addComponent(jobPositionLabel)
                    .addComponent(phoneNumberLabel))
                .addGap(35, 35, 35)
                .addGroup(informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(salaryTextField)
                    .addComponent(firstNameTextField)
                    .addComponent(lastNameTextField)
                    .addComponent(ageTextField)
                    .addGroup(informationPanelLayout.createSequentialGroup()
                        .addComponent(maleRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 191, Short.MAX_VALUE)
                        .addComponent(femaleRadioButton))
                    .addComponent(jobPositionTextField)
                    .addComponent(phoneNumbersTextField)
                    .addComponent(idTextField))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        informationPanelLayout.setVerticalGroup(
            informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(informationPanelLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idLabel)
                    .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameLabel)
                    .addComponent(firstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastNameLabel)
                    .addComponent(lastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ageLabel)
                    .addComponent(ageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maleRadioButton)
                    .addComponent(genderLabel)
                    .addComponent(femaleRadioButton))
                .addGap(15, 15, 15)
                .addGroup(informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salaryLabel)
                    .addComponent(salaryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jobPositionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jobPositionLabel))
                .addGap(15, 15, 15)
                .addGroup(informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneNumbersTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phoneNumberLabel))
                .addGap(30, 30, 30))
        );

        utilitiesPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEmployeeButton(evt);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButton(evt);
            }
        });

        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateJTableButton(evt);
            }
        });

        newButton.setText("New");
        newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newEmployeeButton(evt);
            }
        });

        editButton1.setText("Edit");
        editButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButton(evt);
            }
        });

        javax.swing.GroupLayout utilitiesPanelLayout = new javax.swing.GroupLayout(utilitiesPanel);
        utilitiesPanel.setLayout(utilitiesPanelLayout);
        utilitiesPanelLayout.setHorizontalGroup(
            utilitiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, utilitiesPanelLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(utilitiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(newButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );
        utilitiesPanelLayout.setVerticalGroup(
            utilitiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, utilitiesPanelLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(newButton)
                .addGap(57, 57, 57)
                .addComponent(addButton)
                .addGap(34, 34, 34)
                .addComponent(updateButton)
                .addGap(30, 30, 30)
                .addComponent(editButton1)
                .addGap(29, 29, 29)
                .addComponent(deleteButton)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout employeePanelLayout = new javax.swing.GroupLayout(employeePanel);
        employeePanel.setLayout(employeePanelLayout);
        employeePanelLayout.setHorizontalGroup(
            employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(employeePanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(employeePanelLayout.createSequentialGroup()
                        .addComponent(Label1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(employeePanelLayout.createSequentialGroup()
                        .addComponent(Label2, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, employeePanelLayout.createSequentialGroup()
                        .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(employeeList, javax.swing.GroupLayout.DEFAULT_SIZE, 1042, Short.MAX_VALUE)
                            .addGroup(employeePanelLayout.createSequentialGroup()
                                .addComponent(informationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(utilitiesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(22, 22, 22))))
        );
        employeePanelLayout.setVerticalGroup(
            employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(employeePanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(Label1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(employeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(informationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(utilitiesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Label2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(employeeList, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(148, Short.MAX_VALUE))
        );

        bangChucNang.add(employeePanel, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bangMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bangChucNang, javax.swing.GroupLayout.DEFAULT_SIZE, 1091, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bangMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bangChucNang, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButton
        String id = idTextField.getText();
        if(id.isEmpty()){
            String error = "Choose employee in JTable first before edit";
            JOptionPane.showMessageDialog(this, error, "Edit employee", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Validates_BUS validate = new Validates_BUS();
        String result = validate.ValidateNhanVien(hoTenField, ngaySinhChooser, genderButtonGroup, diaChiField, soDienThoaiField);

        NhanVien_DTO nhanVien = new NhanVien_DTO();
        if(result == null){
            nhanVien = validate.ReturnNhanVien(hoTenField, ngaySinhChooser, genderButtonGroup, diaChiField, soDienThoaiField);
            // Cần add mã phòng ban, mã lương, ...
        }
            
            
        else{
            JOptionPane.showMessageDialog(this, result, "Validation", JOptionPane.WARNING_MESSAGE);
            return;
        }

        NhanVien_BUS NhanVien_BUS = new NhanVien_BUS();

        if(NhanVien_BUS.UpdateNhanVien(nhanVien) == true)
        JOptionPane.showMessageDialog(null, "NhanVien edited successfully!");
        else
        JOptionPane.showMessageDialog(null, "Failed to edit employee!");
    }//GEN-LAST:event_editButton

    private void newEmployeeButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newEmployeeButton
        ClearTextFields(informationPanel);

    }//GEN-LAST:event_newEmployeeButton

    private void updateJTableButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateJTableButton
        UpdateNhanVienTable();
        JOptionPane.showMessageDialog(null, "NhanViens list table updated");
    }//GEN-LAST:event_updateJTableButton

    private void deleteButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButton
        String id = idTextField.getText();
        if(id.isEmpty()){
            String error = "Choose employee in JTable first before delete";
            JOptionPane.showMessageDialog(this, error, "Delete employee", JOptionPane.WARNING_MESSAGE);
            return;
        }

        NhanVien_BUS employee_BUS = new NhanVien_BUS();
        employee_BUS.DeleteNhanVien(Integer.parseInt(id));
        UpdateNhanVienTable();
    }//GEN-LAST:event_deleteButton

        
    private void addNhanVienButton(java.awt.event.ActionEvent evt) {                                                                             
        // TH nếu User nhấn vào employee trên JTable rồi nhấn nút Add --> Thông tin trên Information panel đầy đủ --> Sẽ add lại nhân viên vào database
        // --> Nhấn nút New để xoá hết thông tin trên JTextField rồi nhập vào thông tin mới
        String id = idTextField.getText();
        if (id.isEmpty() == false){
            String error = "Hit the 'New' button before add NhanVien";
            JOptionPane.showMessageDialog(this, error, "Add employee", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Validates_BUS validate = new Validates_BUS();
        String result = validate.ValidateNhanVien(hoTenField, ngaySinhChooser, genderButtonGroup, diaChiField, soDienThoaiField);
        
        NhanVien_DTO employee = new NhanVien_DTO();
        
        if(result == null)
            employee = validate.ReturnNhanVien(hoTenField, ngaySinhChooser, genderButtonGroup, diaChiField, soDienThoaiField);
             
        else{
            JOptionPane.showMessageDialog(this, result, "Nhân Viên Validation", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        NhanVien_DAO employee_DAO = new NhanVien_DAO();
        
        if(employee_DAO.AddNhanVien(employee) == true)
                JOptionPane.showMessageDialog(null, "Thêm nhân viên thành công!");   
        else
           JOptionPane.showMessageDialog(null, "Thêm nhân viên!"); 
        
        // Sau khi thêm employee thì update lại table NhanVien list
        UpdateNhanVienTable();
    }                                  
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Label1;
    private javax.swing.JLabel Label2;
    private javax.swing.JLabel Label3;
    private javax.swing.JLabel Label4;
    private javax.swing.JButton addButton;
    private javax.swing.JButton addButton1;
    private javax.swing.JLabel ageLabel;
    private javax.swing.JTextField ageTextField;
    private javax.swing.JPanel bangChucNang;
    private javax.swing.JPanel bangCongCu;
    private javax.swing.JPanel bangMenu;
    private javax.swing.JScrollPane bangNhanVien;
    private javax.swing.JPanel bangThongTin;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton deleteButton1;
    private javax.swing.JTextField diaChiField;
    private javax.swing.JLabel diaChiLabel;
    private javax.swing.JButton editButton1;
    private javax.swing.JButton editButton2;
    private javax.swing.JScrollPane employeeList;
    private javax.swing.JPanel employeePanel;
    private javax.swing.JTable employeeTable;
    private javax.swing.JTable employeeTable1;
    private javax.swing.JRadioButton femaleRadioButton;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JTextField firstNameTextField;
    private javax.swing.ButtonGroup genderButtonGroup;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JLabel gioiTinhLabel;
    private javax.swing.JRadioButton gioiTinhNam;
    private javax.swing.JRadioButton gioiTinhNu;
    private javax.swing.JTextField hoTenField;
    private javax.swing.JLabel hoTenLabel;
    private javax.swing.JLabel idLabel;
    private javax.swing.JTextField idTextField;
    private javax.swing.JPanel informationPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel jobPositionLabel;
    private javax.swing.JTextField jobPositionTextField;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JTextField lastNameTextField;
    private javax.swing.JLabel maChucVu;
    private javax.swing.JTextField maChucVuField;
    private javax.swing.JLabel maHopDong;
    private javax.swing.JTextField maHopDongField;
    private javax.swing.JTextField maNhanVienField;
    private javax.swing.JLabel maNhanVienLabel;
    private javax.swing.JLabel maPhongBan;
    private javax.swing.JComboBox<String> maPhongBanBox;
    private javax.swing.JComboBox<String> maTrangThaiBox;
    private javax.swing.JRadioButton maleRadioButton;
    private javax.swing.JButton newButton;
    private javax.swing.JButton newButton1;
    private com.toedter.calendar.JDateChooser ngaySinhChooser;
    private javax.swing.JLabel ngaySinhLabel;
    private javax.swing.JLabel phoneNumberLabel;
    private javax.swing.JTextField phoneNumbersTextField;
    private javax.swing.JLabel salaryLabel;
    private javax.swing.JPanel salaryPanel;
    private javax.swing.JTextField salaryTextField;
    private javax.swing.JTextField soDienThoaiField;
    private javax.swing.JLabel soDienThoaiLabel;
    private javax.swing.JLabel trangThai;
    private javax.swing.JButton updateButton;
    private javax.swing.JButton updateButton1;
    private javax.swing.JPanel utilitiesPanel;
    // End of variables declaration//GEN-END:variables
}
