
package com.em.GUI;
import com.em.BUS.ChucVu_BUS;
import com.em.BUS.NhanVien_BUS;
import com.em.BUS.PhongBan_BUS;
import com.em.BUS.Validates_BUS;
import com.em.DTO.ChucVu_DTO;
import com.em.DTO.NhanVien_DTO;
import com.em.DTO.PhongBan_DTO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import com.em.GUI.App_UI;

public class NhanVienPanel_GUI extends javax.swing.JPanel{
    
    public NhanVienPanel_GUI(){
        initComponents();
        
    gioiTinhNu.setActionCommand("F");
    gioiTinhNam.setActionCommand("M");    
    
    InitNhanVienTable();
    UpdateNhanVienTable();
    
    UpdateTenChucVuBox();
    UpdateTenPhongBanBox();
    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gioiTinhButtonGroup = new javax.swing.ButtonGroup();
        bangNhanVien = new javax.swing.JPanel();
        JLabel1 = new javax.swing.JLabel();
        JLabel2 = new javax.swing.JLabel();
        JLabel3 = new javax.swing.JLabel();
        JLabel4 = new javax.swing.JLabel();
        JLabel5 = new javax.swing.JLabel();
        JLabel6 = new javax.swing.JLabel();
        maNhanVienField = new javax.swing.JTextField();
        hoTenField = new javax.swing.JTextField();
        ngaySinhChooser = new com.toedter.calendar.JDateChooser();
        gioiTinhNam = new javax.swing.JRadioButton();
        gioiTinhNu = new javax.swing.JRadioButton();
        diaChiField = new javax.swing.JTextField();
        soDienThoaiField = new javax.swing.JTextField();
        JLabel7 = new javax.swing.JLabel();
        JLabel8 = new javax.swing.JLabel();
        JLabel10 = new javax.swing.JLabel();
        maPhongBanBox = new javax.swing.JComboBox<>();
        maChucVuBox = new javax.swing.JComboBox<>();
        trangThaiBox = new javax.swing.JComboBox<>();
        tenPhongBanField2 = new javax.swing.JTextField();
        tenChucVuField2 = new javax.swing.JTextField();
        danhSachNhanVien = new javax.swing.JScrollPane();
        nhanVienTable = new javax.swing.JTable();
        menuNhanVien = new javax.swing.JPanel();
        addButton1 = new javax.swing.JButton();
        deleteButton1 = new javax.swing.JButton();
        updateButton1 = new javax.swing.JButton();
        newButton1 = new javax.swing.JButton();
        editButton1 = new javax.swing.JButton();

        bangNhanVien.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        JLabel1.setText("Mã nhân viên");

        JLabel2.setText("Họ và tên");

        JLabel3.setText("Ngày Sinh");

        JLabel4.setText("Giới tính");

        JLabel5.setText("Địa chỉ");

        JLabel6.setText("Số điện thoại");

        maNhanVienField.setEditable(false);

        gioiTinhButtonGroup.add(gioiTinhNam);
        gioiTinhNam.setText("Male");

        gioiTinhButtonGroup.add(gioiTinhNu);
        gioiTinhNu.setText("Female");

        JLabel7.setText("Mã phòng ban");

        JLabel8.setText("Mã chức vụ");

        JLabel10.setText("Trạng thái");

        maPhongBanBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateTenPhongBanBox(evt);
            }
        });

        maChucVuBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateTenChucVuBox(evt);
            }
        });

        trangThaiBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yes", "No", " " }));

        tenPhongBanField2.setPreferredSize(new java.awt.Dimension(82, 28));

        tenChucVuField2.setPreferredSize(new java.awt.Dimension(82, 28));

        javax.swing.GroupLayout bangNhanVienLayout = new javax.swing.GroupLayout(bangNhanVien);
        bangNhanVien.setLayout(bangNhanVienLayout);
        bangNhanVienLayout.setHorizontalGroup(
            bangNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bangNhanVienLayout.createSequentialGroup()
                .addGroup(bangNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bangNhanVienLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(bangNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(bangNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(JLabel2)
                                .addComponent(JLabel4)
                                .addComponent(JLabel5)
                                .addComponent(JLabel6))
                            .addGroup(bangNhanVienLayout.createSequentialGroup()
                                .addComponent(JLabel3)
                                .addGap(20, 20, 20)))
                        .addGap(35, 35, 35))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bangNhanVienLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(JLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(bangNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bangNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(diaChiField)
                        .addComponent(hoTenField)
                        .addGroup(bangNhanVienLayout.createSequentialGroup()
                            .addComponent(gioiTinhNam)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 191, Short.MAX_VALUE)
                            .addComponent(gioiTinhNu))
                        .addComponent(soDienThoaiField)
                        .addComponent(maNhanVienField))
                    .addComponent(ngaySinhChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(bangNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLabel8)
                    .addComponent(JLabel7)
                    .addComponent(JLabel10))
                .addGap(27, 27, 27)
                .addGroup(bangNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(bangNhanVienLayout.createSequentialGroup()
                        .addComponent(maChucVuBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tenChucVuField2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(bangNhanVienLayout.createSequentialGroup()
                        .addComponent(maPhongBanBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tenPhongBanField2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(trangThaiBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 14, Short.MAX_VALUE))
        );
        bangNhanVienLayout.setVerticalGroup(
            bangNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bangNhanVienLayout.createSequentialGroup()
                .addGroup(bangNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bangNhanVienLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(bangNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JLabel1)
                            .addComponent(maNhanVienField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(maPhongBanBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tenPhongBanField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bangNhanVienLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(JLabel7)))
                .addGroup(bangNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bangNhanVienLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(bangNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(maChucVuBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tenChucVuField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)
                        .addGroup(bangNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JLabel10)
                            .addComponent(trangThaiBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(bangNhanVienLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(bangNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JLabel2)
                            .addComponent(hoTenField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JLabel8))
                        .addGroup(bangNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bangNhanVienLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(ngaySinhChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(bangNhanVienLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(JLabel3)))))
                .addGap(16, 16, 16)
                .addGroup(bangNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gioiTinhNam)
                    .addComponent(gioiTinhNu)
                    .addComponent(JLabel4))
                .addGap(15, 15, 15)
                .addGroup(bangNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(diaChiField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLabel5))
                .addGap(58, 58, 58)
                .addGroup(bangNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(soDienThoaiField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLabel6))
                .addGap(30, 30, 30))
        );

        nhanVienTable.setModel(new javax.swing.table.DefaultTableModel(
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
        danhSachNhanVien.setViewportView(nhanVienTable);

        menuNhanVien.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        addButton1.setText("Add");
        addButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButton1(evt);
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
                updateButton1(evt);
            }
        });

        newButton1.setText("New");
        newButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButton1(evt);
            }
        });

        editButton1.setText("Edit");
        editButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButton1(evt);
            }
        });

        javax.swing.GroupLayout menuNhanVienLayout = new javax.swing.GroupLayout(menuNhanVien);
        menuNhanVien.setLayout(menuNhanVienLayout);
        menuNhanVienLayout.setHorizontalGroup(
            menuNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuNhanVienLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(menuNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(newButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
            .addGroup(menuNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(updateButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menuNhanVienLayout.setVerticalGroup(
            menuNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuNhanVienLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(newButton1)
                .addGap(57, 57, 57)
                .addComponent(addButton1)
                .addGap(18, 18, 18)
                .addComponent(editButton1)
                .addGap(18, 18, 18)
                .addComponent(deleteButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(updateButton1)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(danhSachNhanVien)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bangNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(menuNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(menuNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bangNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(danhSachNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public DefaultTableModel defaultNhanVienTableModel = new DefaultTableModel();
    
    public void InitNhanVienTable(){
        
        // Trỏ default table tới employee table
        nhanVienTable.setModel(defaultNhanVienTableModel);
        
        // Thêm cột cho default table --> employee table cũng thêm cột
        defaultNhanVienTableModel.addColumn("Mã nhân viên");
        defaultNhanVienTableModel.addColumn("Họ tên");
        defaultNhanVienTableModel.addColumn("Ngày sinh");
        defaultNhanVienTableModel.addColumn("Giới tính");
        defaultNhanVienTableModel.addColumn("Địa chỉ");
        defaultNhanVienTableModel.addColumn("Số điện thoại");
        defaultNhanVienTableModel.addColumn("Mã phòng ban");
        defaultNhanVienTableModel.addColumn("mã chức vụ");
        defaultNhanVienTableModel.addColumn("Trạng thái");
        
        // Chỉ được chọn 1 dòng/employee trong 1 lúc
        ListSelectionModel listSelectionModel = nhanVienTable.getSelectionModel();
        listSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        //Mỗi lần chọn 1 employee sẽ hiện thông tin employee lên information panel
        listSelectionModel.addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e){
                
                // Trích xuất vị trí ô dòng/employee được chọn
                int rowIndex = nhanVienTable.getSelectedRow();
                // TH nếu chọn 1 employee/dòng trong JTable rồi JTable reset data --> ValueChanged --> rowIndex = -1 do không có data trong JTable
                // ==> Gây ra lỗi khi trích xuất dữ liệu từ JTable
                if(rowIndex != -1){ //TH database không có dữ liệu thì không cần trích xuất dữ liệu từ JTable và không update Information Panel
                    
                    // Trích xuất dữ liệu các cột của dòng được chọn
                    String maNhanVien = nhanVienTable.getValueAt(rowIndex, 0).toString(); 
                    String hoTen = nhanVienTable.getValueAt(rowIndex, 1).toString();
                    String ngaySinh = nhanVienTable.getValueAt(rowIndex, 2).toString();
                    String gioiTinh = nhanVienTable.getValueAt(rowIndex, 3).toString();
                    String diaChi = nhanVienTable.getValueAt(rowIndex, 4).toString();
                    String soDienThoai = nhanVienTable.getValueAt(rowIndex, 5).toString();
                    String maPhongBan = nhanVienTable.getValueAt(rowIndex, 6).toString();
                    String maChucVu = nhanVienTable.getValueAt(rowIndex, 7).toString();
                    String trangThai = nhanVienTable.getValueAt(rowIndex, 8).toString();

                    // Hiển thị dữ liệu lên information panel
                    maNhanVienField.setText(maNhanVien);
                    hoTenField.setText(hoTen);
                    
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    try {
                        Date date = dateFormat.parse(ngaySinh);
                        ngaySinhChooser.setDateFormatString("dd/MM/yyyy");
                        ngaySinhChooser.setDate(date);
                    }                    
                    catch (ParseException d) {
                        d.printStackTrace();
}
                    
                    diaChiField.setText(diaChi);
                    soDienThoaiField.setText(soDienThoai);
                    maPhongBanBox.setSelectedItem(maPhongBan);
                    maChucVuBox.setSelectedItem(maChucVu);
                    trangThaiBox.setSelectedItem(trangThai);
                    
                    // Kiểm tra giới tính rồi chọn tương ứng
                    if(gioiTinh.equals("M")) // Khi dùng a == b nghĩa là a và b có phải cùng 1 object (không áp dụng khi kiểm tra số: a==3)
                        gioiTinhNam.setSelected(true);
                    else
                        gioiTinhNu.setSelected(true);
                }  
            }
        });
    }
    
    public boolean UpdateNhanVienTable(){
        try {
            // Trích xuất toàn bộ employee từ database
            NhanVien_BUS NhanVien_BUS = new NhanVien_BUS();
            ArrayList<NhanVien_DTO> nhanVienList = NhanVien_BUS.GetAllNhanVien();
            
            // Hàm sẽ lấy toàn bộ dữ liệu từ database (bao gồm cả dữ liệu có sẵn trong JTable) --> Làm sạch JTable rồi add lại toàn bộ dữ liệu
            defaultNhanVienTableModel.setRowCount(0); // Xoá toàn bộ dòng trong JTable 
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            
            //Add rows
            for (NhanVien_DTO nhanVien : nhanVienList) {
                
                String ngaySinhFormatted = "";
                ngaySinhFormatted = dateFormat.format(nhanVien.getNgaySinh());
                
                defaultNhanVienTableModel.addRow(new Object[]{
                    nhanVien.getMaNhanVien(),
                    nhanVien.getHoTen(),
                    ngaySinhFormatted,
                    nhanVien.getGioiTinh(),
                    nhanVien.getDiaChi(),
                    nhanVien.getSoDienThoai(),
                    nhanVien.getMaPhongBan(),
                    nhanVien.getMaChucVu(),
                    nhanVien.getTrangThai()
                });
            }
        }
        
        catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "Lỗi trích xuất thông tin nhân viên: " + e.getMessage(),
                "Lỗi",
                JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            
            return false;
        }
        
        return true;
    }
    
    public void NewNhanVien(){
        gioiTinhButtonGroup.clearSelection();
        App_UI.ClearAllField(this);
    }
    
    public void AddNhanVien() {                                                                             
        // TH nếu User nhấn vào employee trên JTable rồi nhấn nút Add --> Thông tin trên Information panel đầy đủ --> Sẽ add lại nhân viên vào database
        // --> Nhấn nút New để xoá hết thông tin trên JTextField rồi nhập vào thông tin mới
        String maNhanVien = maNhanVienField.getText();
        if (maNhanVien.isEmpty() == false){
            String error = "Bấm nút 'New' trước khi thêm nhân viên.";
            JOptionPane.showMessageDialog(this, error, "Add nhân viên", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Validates_BUS validate = new Validates_BUS();
        String result = validate.ValidateNhanVien(hoTenField, ngaySinhChooser, gioiTinhButtonGroup, diaChiField, soDienThoaiField, maPhongBanBox, maChucVuBox, trangThaiBox);
        
        NhanVien_DTO nhanVien = new NhanVien_DTO();
        
        if(result == null)
            nhanVien = validate.ReturnNhanVien(hoTenField, ngaySinhChooser, gioiTinhButtonGroup, diaChiField, soDienThoaiField, maPhongBanBox, maChucVuBox, trangThaiBox);
             
        else{
            JOptionPane.showMessageDialog(this, result, "Nhân Viên Validation", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        NhanVien_BUS nhanVien_BUS = new NhanVien_BUS();
        
        if(nhanVien_BUS.AddNhanVien(nhanVien) == true)
                JOptionPane.showMessageDialog(null, "Thêm nhân viên thành công!");   
        else
           JOptionPane.showMessageDialog(null, "Thêm nhân viên không thành công!"); 
        
        // Sau khi thêm employee thì update lại table NhanVien list
        UpdateNhanVienTable();
    }
    
    public void EditNhanVien(){
        String maNhanVien = maNhanVienField.getText();
        if (maNhanVien.isEmpty() == true){
            String error = "Chọn nhân viên trong danh sách trước khi sửa";
            JOptionPane.showMessageDialog(this, error, "Edit nhân viên", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Validates_BUS validate = new Validates_BUS();
        String result = validate.ValidateNhanVien(hoTenField, ngaySinhChooser, gioiTinhButtonGroup, diaChiField, soDienThoaiField, maPhongBanBox, maChucVuBox, trangThaiBox);
        
        NhanVien_DTO nhanVien = new NhanVien_DTO();
        
        if(result == null){
            nhanVien = validate.ReturnNhanVien(hoTenField, ngaySinhChooser, gioiTinhButtonGroup, diaChiField, soDienThoaiField, maPhongBanBox, maChucVuBox, trangThaiBox);
            nhanVien.setMaNhanVien(Integer.parseInt(maNhanVien));
        }
            
             
        else{
            JOptionPane.showMessageDialog(this, result, "Nhân Viên Validation", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        NhanVien_BUS nhanVien_BUS = new NhanVien_BUS();
        
        if(nhanVien_BUS.EditNhanVien(nhanVien) == true)
                JOptionPane.showMessageDialog(null, "Sửa nhân viên thành công!");   
        else
           JOptionPane.showMessageDialog(null, "Sửa nhân viên không thành công!"); 
        
        // Sau khi thêm employee thì update lại table NhanVien list
        UpdateNhanVienTable();
    }
    
    public void DeleteNhanVien(){
        String maNhanVien = maNhanVienField.getText();
        if (maNhanVien.isEmpty() == true){
            String error = "Chọn nhân viên trong danh sách trước khi xoá";
            JOptionPane.showMessageDialog(this, error, "Delete nhân viên", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Show confirmation dialog
        int confirm = JOptionPane.showConfirmDialog(
            this,
            "Bạn có chắc muốn xoá nhân viên ?",
            "Xác nhận xoá",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE
        );
    
        if (confirm == JOptionPane.YES_OPTION) {
            // User clicked YES - proceed with deletion
            NhanVien_BUS nhanVien_BUS = new NhanVien_BUS();

            if (nhanVien_BUS.DeleteNhanVien(Integer.parseInt(maNhanVien)) == true) {
                JOptionPane.showMessageDialog(this, 
                    "Xoá nhân viên thành công.", 
                    "Thành công", 
                    JOptionPane.INFORMATION_MESSAGE);
                
                UpdateNhanVienTable();
            } 
            
            else {
                JOptionPane.showMessageDialog(this, 
                    "Xoá nhân viên thất bại.", 
                    "Lỗi", 
                    JOptionPane.ERROR_MESSAGE);
            }
        } 
        
        else {
            // User clicked NO or closed dialog - do nothing
            return;
        }
    }
    
    public void UpdateTenPhongBanBox(){
        
        PhongBan_BUS phongBanBUS = new PhongBan_BUS();
        ArrayList<PhongBan_DTO> phongBanList = phongBanBUS.GetAllPhongBan(); // Trích xuất toàn bộ phòng ban
    
        maPhongBanBox.removeAllItems(); // Xoá danh sách cũ
    
        for (PhongBan_DTO phongBan : phongBanList)  // Tuỳ theo maPhongBan, hiện tên phòng ban
            maPhongBanBox.addItem(Integer.toString(phongBan.getMaPhongBan()));
        
        maPhongBanBox.setSelectedIndex(-1);
        tenPhongBanField2.setText("");
    }
    
    public void UpdateTenChucVuBox(){
        
        ChucVu_BUS chucVuBUS = new ChucVu_BUS();
        ArrayList<ChucVu_DTO> chucVuList = chucVuBUS.GetAllChucVu(); // Trích xuất toàn bộ phòng ban
    
        maChucVuBox.removeAllItems(); // Xoá danh sách cũ
    
        for (ChucVu_DTO chucVu : chucVuList)  // Tuỳ theo maChucVu, hiện tên chức vụ
            maChucVuBox.addItem(Integer.toString(chucVu.getMaChucVu()));
        
        maChucVuBox.setSelectedIndex(-1);
        tenChucVuField2.setText("");
    }
    
    private void UpdateTenPhongBanBox(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateTenPhongBanBox
        if(maPhongBanBox.getSelectedIndex() != -1){
            int selectedPhongBan = Integer.parseInt(maPhongBanBox.getSelectedItem().toString());
            PhongBan_BUS phongBan_BUS = new PhongBan_BUS();
            PhongBan_DTO phongBan = new PhongBan_DTO();

            phongBan = phongBan_BUS.GetPhongBanByID(selectedPhongBan);

            tenPhongBanField2.setText(phongBan.getTenPhongBan());
        }
    }//GEN-LAST:event_UpdateTenPhongBanBox

    private void UpdateTenChucVuBox(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateTenChucVuBox
        if(maChucVuBox.getSelectedIndex() != -1){
            int selectedPhongBan = Integer.parseInt(maChucVuBox.getSelectedItem().toString());
            ChucVu_BUS chucVu_BUS = new ChucVu_BUS();
            ChucVu_DTO chucVu = new ChucVu_DTO();

            chucVu = chucVu_BUS.GetChucVuByID(selectedPhongBan);

            tenChucVuField2.setText(chucVu.getTenChucVu());
        }
    }//GEN-LAST:event_UpdateTenChucVuBox

    private void newButton1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButton1
        NewNhanVien();
    }//GEN-LAST:event_newButton1

    private void addButton1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButton1
        AddNhanVien();
    }//GEN-LAST:event_addButton1

    private void editButton1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButton1
        EditNhanVien();
    }//GEN-LAST:event_editButton1

    private void deleteButton1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButton1
        DeleteNhanVien();
    }//GEN-LAST:event_deleteButton1

    private void updateButton1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButton1
        if(UpdateNhanVienTable()){
            String text = "Update thành công";
            JOptionPane.showMessageDialog(this, text, "Update", JOptionPane.WIDTH);
        }
    }//GEN-LAST:event_updateButton1

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabel1;
    private javax.swing.JLabel JLabel10;
    private javax.swing.JLabel JLabel2;
    private javax.swing.JLabel JLabel3;
    private javax.swing.JLabel JLabel4;
    private javax.swing.JLabel JLabel5;
    private javax.swing.JLabel JLabel6;
    private javax.swing.JLabel JLabel7;
    private javax.swing.JLabel JLabel8;
    private javax.swing.JButton addButton1;
    private javax.swing.JPanel bangNhanVien;
    private javax.swing.JScrollPane danhSachNhanVien;
    private javax.swing.JButton deleteButton1;
    private javax.swing.JTextField diaChiField;
    private javax.swing.JButton editButton1;
    private javax.swing.ButtonGroup gioiTinhButtonGroup;
    private javax.swing.JRadioButton gioiTinhNam;
    private javax.swing.JRadioButton gioiTinhNu;
    private javax.swing.JTextField hoTenField;
    private javax.swing.JComboBox<String> maChucVuBox;
    private javax.swing.JTextField maNhanVienField;
    private javax.swing.JComboBox<String> maPhongBanBox;
    private javax.swing.JPanel menuNhanVien;
    private javax.swing.JButton newButton1;
    private com.toedter.calendar.JDateChooser ngaySinhChooser;
    private javax.swing.JTable nhanVienTable;
    private javax.swing.JTextField soDienThoaiField;
    private javax.swing.JTextField tenChucVuField2;
    private javax.swing.JTextField tenPhongBanField2;
    private javax.swing.JComboBox<String> trangThaiBox;
    private javax.swing.JButton updateButton1;
    // End of variables declaration//GEN-END:variables
}
