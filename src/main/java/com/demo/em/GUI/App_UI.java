package com.demo.em.GUI;
import com.demo.em.BUS.Employee_BUS;
import javax.swing.*;
import com.demo.em.BUS.Validates_BUS;
import com.demo.em.DAO.Employee_DAO;
import com.demo.em.DTO.Employee_DTO;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class App_UI extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(App_UI.class.getName());
    
    public App_UI() {
        initComponents();
        
        // Chọn cái nào thì sẽ trả về giá trị đó, trích xuất thông qua ButtonGroup
        femaleRadioButton.setActionCommand("F");
        maleRadioButton.setActionCommand("M");
        
        // JTable cho Employee list
        InitEmployeeTable();
        UpdateEmployeeTable();
        
    }
    // Tạo default table 
    private DefaultTableModel defaultTableModel = new DefaultTableModel();
    public void InitEmployeeTable(){
        
        // Trỏ default table tới employee table
        employeeTable.setModel(defaultTableModel);
        
        // Thêm cột cho default table --> employee table cũng thêm cột
        defaultTableModel.addColumn("ID");
        defaultTableModel.addColumn("First name");
        defaultTableModel.addColumn("Last name");
        defaultTableModel.addColumn("Age");
        defaultTableModel.addColumn("Gender");
        defaultTableModel.addColumn("Salary");
        defaultTableModel.addColumn("Job");
        defaultTableModel.addColumn("Phone");
        
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
                    String id = employeeTable.getValueAt(rowIndex, 0).toString(); 
                    String firstName = employeeTable.getValueAt(rowIndex, 1).toString();
                    String lastName = employeeTable.getValueAt(rowIndex, 2).toString();
                    String age = employeeTable.getValueAt(rowIndex, 3).toString();
                    String gender = employeeTable.getValueAt(rowIndex, 4).toString();
                    String salary = employeeTable.getValueAt(rowIndex, 5).toString();
                    String jobPosition = employeeTable.getValueAt(rowIndex, 6).toString();
                    String phoneNumbers = employeeTable.getValueAt(rowIndex, 7).toString();

                    // Hiển thị dữ liệu lên information panel
                    idTextField.setText(id);
                    firstNameTextField.setText(firstName);
                    lastNameTextField.setText(lastName);
                    ageTextField.setText(age);
                    salaryTextField.setText(salary);
                    jobPositionTextField.setText(jobPosition);
                    phoneNumbersTextField.setText(phoneNumbers);

                    // Kiểm tra giới tính rồi chọn tương ứng
                    if(gender.equals("M")) // Khi dùng a == b nghĩa là a và b có phải cùng 1 object (không áp dụng khi kiểm tra số: a==3)
                        maleRadioButton.setSelected(true);
                    else
                        femaleRadioButton.setSelected(true);
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
    
    private void UpdateEmployeeTable(){
        try {
            // Trích xuất toàn bộ employee từ database
            Employee_BUS employee_BUS = new Employee_BUS();
            ArrayList<Employee_DTO> employeeList = employee_BUS.GetAllEmployees();
            
            // Hàm sẽ lấy toàn bộ dữ liệu từ database (bao gồm cả dữ liệu có sẵn trong JTable) --> Làm sạch JTable rồi add lại toàn bộ dữ liệu
            defaultTableModel.setRowCount(0); // Xoá toàn bộ dòng trong JTable 
            
            System.out.println(employeeList.size());
            
            //Add rows
            for (Employee_DTO employee : employeeList) {
                defaultTableModel.addRow(new Object[]{
                    employee.getId(),
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getAge(),
                    employee.getGender(),
                    employee.getSalary(),
                    employee.getJobPosition(),
                    employee.getPhoneNumbers()
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
        menuPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        mainPanel = new javax.swing.JPanel();
        salaryPanel = new javax.swing.JPanel();
        Label4 = new javax.swing.JLabel();
        Label3 = new javax.swing.JLabel();
        bangThongTin = new javax.swing.JPanel();
        maNhanVien = new javax.swing.JLabel();
        hoTen = new javax.swing.JLabel();
        ngaySinh = new javax.swing.JLabel();
        gioiTinh = new javax.swing.JLabel();
        diaChi = new javax.swing.JLabel();
        soDienThoai = new javax.swing.JLabel();
        maNhanVienField = new javax.swing.JTextField();
        hoTenField = new javax.swing.JTextField();
        ngaySinhField = new javax.swing.JTextField();
        gioiTinhNam = new javax.swing.JRadioButton();
        gioiTinhNu = new javax.swing.JRadioButton();
        diaChiField = new javax.swing.JTextField();
        soDienThoaiField = new javax.swing.JTextField();
        maPhongBan = new javax.swing.JLabel();
        maChucVu = new javax.swing.JLabel();
        maHopDong = new javax.swing.JLabel();
        trangThai = new javax.swing.JLabel();
        maPhongBanBox = new javax.swing.JComboBox<>();
        maChucVuBox = new javax.swing.JComboBox<>();
        maHopDongBox = new javax.swing.JComboBox<>();
        maTrangThaiBox = new javax.swing.JComboBox<>();
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

        menuPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
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
                .addContainerGap(205, Short.MAX_VALUE))
        );

        mainPanel.setPreferredSize(new java.awt.Dimension(1000, 1000));
        mainPanel.setLayout(new java.awt.CardLayout());

        salaryPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Label4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Label4.setText("Danh sách nhân viên");
        salaryPanel.add(Label4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, -1, -1));

        Label3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Label3.setText("Thông tin nhân viên");
        salaryPanel.add(Label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        bangThongTin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        maNhanVien.setText("Mã nhân viên");

        hoTen.setText("Họ và tên");

        ngaySinh.setText("Ngày Sinh");

        gioiTinh.setText("Giới tính");

        diaChi.setText("Địa chỉ");

        soDienThoai.setText("Số điện thoại");

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

        maChucVuBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        maHopDongBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        maTrangThaiBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yes", "No", " " }));

        javax.swing.GroupLayout bangThongTinLayout = new javax.swing.GroupLayout(bangThongTin);
        bangThongTin.setLayout(bangThongTinLayout);
        bangThongTinLayout.setHorizontalGroup(
            bangThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bangThongTinLayout.createSequentialGroup()
                .addGroup(bangThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bangThongTinLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(bangThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hoTen)
                            .addComponent(ngaySinh)
                            .addComponent(gioiTinh)
                            .addComponent(diaChi)
                            .addComponent(soDienThoai)))
                    .addGroup(bangThongTinLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(maNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35)
                .addGroup(bangThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(diaChiField)
                    .addComponent(hoTenField)
                    .addComponent(ngaySinhField)
                    .addGroup(bangThongTinLayout.createSequentialGroup()
                        .addComponent(gioiTinhNam)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 191, Short.MAX_VALUE)
                        .addComponent(gioiTinhNu))
                    .addComponent(soDienThoaiField)
                    .addComponent(maNhanVienField))
                .addGap(57, 57, 57)
                .addGroup(bangThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(bangThongTinLayout.createSequentialGroup()
                        .addComponent(trangThai)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(maTrangThaiBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bangThongTinLayout.createSequentialGroup()
                        .addComponent(maHopDong)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(maHopDongBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bangThongTinLayout.createSequentialGroup()
                        .addGroup(bangThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(maPhongBan)
                            .addGroup(bangThongTinLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(maChucVu)))
                        .addGap(65, 65, 65)
                        .addGroup(bangThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(maPhongBanBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(maChucVuBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        bangThongTinLayout.setVerticalGroup(
            bangThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bangThongTinLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(bangThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maNhanVien)
                    .addComponent(maNhanVienField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maPhongBan)
                    .addComponent(maPhongBanBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(bangThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hoTen)
                    .addComponent(hoTenField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maChucVu)
                    .addComponent(maChucVuBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(bangThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ngaySinh)
                    .addComponent(ngaySinhField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maHopDong)
                    .addComponent(maHopDongBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(bangThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(trangThai)
                    .addComponent(maTrangThaiBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(bangThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gioiTinhNam)
                    .addComponent(gioiTinhNu)
                    .addComponent(gioiTinh))
                .addGap(15, 15, 15)
                .addGroup(bangThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(diaChiField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(diaChi))
                .addGap(58, 58, 58)
                .addGroup(bangThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(soDienThoaiField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(soDienThoai))
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

        mainPanel.add(salaryPanel, "card3");

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton9.setText("jButton9");
        jPanel2.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 200, -1, -1));

        jLabel2.setText("jLabel2");
        jLabel2.setPreferredSize(new java.awt.Dimension(100, 100));
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 380, -1, -1));

        mainPanel.add(jPanel2, "card4");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1091, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 707, Short.MAX_VALUE)
        );

        mainPanel.add(jPanel3, "card5");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1091, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 707, Short.MAX_VALUE)
        );

        mainPanel.add(jPanel4, "card6");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1091, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 707, Short.MAX_VALUE)
        );

        mainPanel.add(jPanel5, "card7");

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
                .addContainerGap(147, Short.MAX_VALUE))
        );

        mainPanel.add(employeePanel, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1091, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
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
        String result = validate.ValidateEmployee(firstNameTextField, lastNameTextField, ageTextField, genderButtonGroup, salaryTextField, jobPositionTextField, phoneNumbersTextField);

        Employee_DTO employee = new Employee_DTO();
        if(result == null){
            employee = validate.ReturnEmployee();
            employee.setId(Integer.parseInt(id));
        }

        else{
            JOptionPane.showMessageDialog(this, result, "Validation", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Employee_BUS employee_BUS = new Employee_BUS();

        if(employee_BUS.UpdateEmployee(employee) == true)
        JOptionPane.showMessageDialog(null, "Employee edited successfully!");
        else
        JOptionPane.showMessageDialog(null, "Failed to edit employee!");
    }//GEN-LAST:event_editButton

    private void newEmployeeButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newEmployeeButton
        ClearTextFields(informationPanel);

    }//GEN-LAST:event_newEmployeeButton

    private void updateJTableButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateJTableButton
        UpdateEmployeeTable();
        JOptionPane.showMessageDialog(null, "Employees list table updated");
    }//GEN-LAST:event_updateJTableButton

    private void deleteButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButton
        String id = idTextField.getText();
        if(id.isEmpty()){
            String error = "Choose employee in JTable first before delete";
            JOptionPane.showMessageDialog(this, error, "Delete employee", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Employee_BUS employee_BUS = new Employee_BUS();
        employee_BUS.DeleteEmployee(Integer.parseInt(id));
        UpdateEmployeeTable();
    }//GEN-LAST:event_deleteButton

    private void addButton1addEmployeeButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButton1addEmployeeButton
        // TODO add your handling code here:
    }//GEN-LAST:event_addButton1addEmployeeButton

    private void updateButton1updateJTableButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButton1updateJTableButton
        // TODO add your handling code here:
    }//GEN-LAST:event_updateButton1updateJTableButton

    private void newButton1newEmployeeButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButton1newEmployeeButton
        // TODO add your handling code here:
    }//GEN-LAST:event_newButton1newEmployeeButton

    private void editButton2editButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButton2editButton
        // TODO add your handling code here:
    }//GEN-LAST:event_editButton2editButton

    private void deleteButton1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButton1
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteButton1

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed
        
    private void addEmployeeButton(java.awt.event.ActionEvent evt) {                                                                             
        // TH nếu User nhấn vào employee trên JTable rồi nhấn nút Add --> Thông tin trên Information panel đầy đủ --> Sẽ add lại nhân viên vào database
        // --> Nhấn nút New để xoá hết thông tin trên JTextField rồi nhập vào thông tin mới
        String id = idTextField.getText();
        if (id.isEmpty() == false){
            String error = "Hit the 'New' button before add Employee";
            JOptionPane.showMessageDialog(this, error, "Add employee", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Validates_BUS validate = new Validates_BUS();
        String result = validate.ValidateEmployee(firstNameTextField, lastNameTextField, ageTextField, genderButtonGroup, salaryTextField, jobPositionTextField, phoneNumbersTextField);
        
        Employee_DTO employee = new Employee_DTO();
        if(result == null)
            employee = validate.ReturnEmployee();
             
        else{
            JOptionPane.showMessageDialog(this, result, "Validation", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Employee_DAO employee_DAO = new Employee_DAO();
        if(employee_DAO.AddEmployee(employee) == true)
                JOptionPane.showMessageDialog(null, "Employee added successfully!");   
        else
           JOptionPane.showMessageDialog(null, "Failed to add employee!"); 
        
        // Sau khi thêm employee thì update lại table Employee list
        UpdateEmployeeTable();
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
    private javax.swing.JPanel bangCongCu;
    private javax.swing.JScrollPane bangNhanVien;
    private javax.swing.JPanel bangThongTin;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton deleteButton1;
    private javax.swing.JLabel diaChi;
    private javax.swing.JTextField diaChiField;
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
    private javax.swing.JLabel gioiTinh;
    private javax.swing.JRadioButton gioiTinhNam;
    private javax.swing.JRadioButton gioiTinhNu;
    private javax.swing.JLabel hoTen;
    private javax.swing.JTextField hoTenField;
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
    private javax.swing.JComboBox<String> maChucVuBox;
    private javax.swing.JLabel maHopDong;
    private javax.swing.JComboBox<String> maHopDongBox;
    private javax.swing.JLabel maNhanVien;
    private javax.swing.JTextField maNhanVienField;
    private javax.swing.JLabel maPhongBan;
    private javax.swing.JComboBox<String> maPhongBanBox;
    private javax.swing.JComboBox<String> maTrangThaiBox;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JRadioButton maleRadioButton;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JButton newButton;
    private javax.swing.JButton newButton1;
    private javax.swing.JLabel ngaySinh;
    private javax.swing.JTextField ngaySinhField;
    private javax.swing.JLabel phoneNumberLabel;
    private javax.swing.JTextField phoneNumbersTextField;
    private javax.swing.JLabel salaryLabel;
    private javax.swing.JPanel salaryPanel;
    private javax.swing.JTextField salaryTextField;
    private javax.swing.JLabel soDienThoai;
    private javax.swing.JTextField soDienThoaiField;
    private javax.swing.JLabel trangThai;
    private javax.swing.JButton updateButton;
    private javax.swing.JButton updateButton1;
    private javax.swing.JPanel utilitiesPanel;
    // End of variables declaration//GEN-END:variables
}
