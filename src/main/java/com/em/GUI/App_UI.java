package com.em.GUI;
import com.em.BUS.ChucVu_BUS;
import com.em.BUS.NhanVien_BUS;
import com.em.BUS.PhongBan_BUS;
import javax.swing.*;
import com.em.BUS.Validates_BUS;
import com.em.DTO.ChucVu_DTO;
import com.em.DTO.NhanVien_DTO;
import com.em.DTO.PhongBan_DTO;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class App_UI extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(App_UI.class.getName());
    
    private CardLayout cardLayout;
    public App_UI() {
        
        initComponents();
        cardLayout = (CardLayout) cardPanel.getLayout();
        
        // Chọn cái nào thì sẽ trả về giá trị đó, trích xuất thông qua ButtonGroup
        gioiTinhNu.setActionCommand("F");
        gioiTinhNam.setActionCommand("M");
        
        // NhanVien Card
        InitNhanVienTable();
        UpdateNhanVienTable();
        UpdateTenPhongBanBox();
        UpdateTenChucVuBox();
        
        // PhongBan Card
        InitPhongBanTable();
        UpdatePhongBanTable();
        
        // ChucVu card
        InitChucVuTable();
        UpdateChucVuTable();
                
    }
    
    public void ClearTextFields(Container container) {
        for (Component c : container.getComponents()) {
            if (c instanceof JTextField) 
                ((JTextField) c).setText("");

            else if (c instanceof Container) 
                ClearTextFields((Container) c);      
        }
    }
     
    //!
    //! Nhân viên
    //!

    // Tạo default table 
    private DefaultTableModel defaultNhanVienTableModel = new DefaultTableModel();
    
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
                    
                    // Kiểm tra giới tính rồi chọn tương ứng
                    if(gioiTinh.equals("M")) // Khi dùng a == b nghĩa là a và b có phải cùng 1 object (không áp dụng khi kiểm tra số: a==3)
                        gioiTinhNam.setSelected(true);
                    else
                        gioiTinhNu.setSelected(true);
                }  
            }
        });
    }
    
    private void UpdateNhanVienTable(){
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
        }
    }
    
    private void NewNhanVien(){
        ClearTextFields(NhanVienCard);
    }
    
    private void AddNhanVien() {                                                                             
        // TH nếu User nhấn vào employee trên JTable rồi nhấn nút Add --> Thông tin trên Information panel đầy đủ --> Sẽ add lại nhân viên vào database
        // --> Nhấn nút New để xoá hết thông tin trên JTextField rồi nhập vào thông tin mới
        String maNhanVien = maNhanVienField.getText();
        if (maNhanVien.isEmpty() == false){
            String error = "Bấm nút 'New' trước khi thêm nhân viên.";
            JOptionPane.showMessageDialog(this, error, "Add nhân viên", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Validates_BUS validate = new Validates_BUS();
        String result = validate.ValidateNhanVien(hoTenField, ngaySinhChooser, genderButtonGroup, diaChiField, soDienThoaiField, maPhongBanBox, maChucVuBox, trangThaiBox);
        
        NhanVien_DTO nhanVien = new NhanVien_DTO();
        
        if(result == null)
            nhanVien = validate.ReturnNhanVien(hoTenField, ngaySinhChooser, genderButtonGroup, diaChiField, soDienThoaiField, maPhongBanBox, maChucVuBox, trangThaiBox);
             
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
    
    private void EditNhanVien(){
        String maNhanVien = maNhanVienField.getText();
        if (maNhanVien.isEmpty() == true){
            String error = "Chọn nhân viên trong danh sách trước khi sửa";
            JOptionPane.showMessageDialog(this, error, "Edit nhân viên", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Validates_BUS validate = new Validates_BUS();
        String result = validate.ValidateNhanVien(hoTenField, ngaySinhChooser, genderButtonGroup, diaChiField, soDienThoaiField, maPhongBanBox, maChucVuBox, trangThaiBox);
        
        NhanVien_DTO nhanVien = new NhanVien_DTO();
        
        if(result == null){
            nhanVien = validate.ReturnNhanVien(hoTenField, ngaySinhChooser, genderButtonGroup, diaChiField, soDienThoaiField, maPhongBanBox, maChucVuBox, trangThaiBox);
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
    
    private void DeleteNhanVien(){
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

    private void NhanVienCardButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NhanVienCardButton
        cardLayout.show(cardPanel, "nhanVienCard");
        UpdateTenPhongBanBox();
        UpdateTenChucVuBox();

    }//GEN-LAST:event_NhanVienCardButton

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
	
	private void updateNhanVienTableButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateNhanVienTableButton
        UpdateNhanVienTable();
    }//GEN-LAST:event_updateNhanVienTableButton

    private void UpdateTenPhongBanBox(){
        
        PhongBan_BUS phongBanBUS = new PhongBan_BUS();
        ArrayList<PhongBan_DTO> phongBanList = phongBanBUS.GetAllPhongBan(); // Trích xuất toàn bộ phòng ban
    
        maPhongBanBox.removeAllItems(); // Xoá danh sách cũ
    
        for (PhongBan_DTO phongBan : phongBanList)  // Tuỳ theo maPhongBan, hiện tên phòng ban
            maPhongBanBox.addItem(Integer.toString(phongBan.getMaPhongBan()));
        
        maPhongBanBox.setSelectedIndex(-1);
        tenPhongBanField2.setText("");
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

    private void UpdateTenChucVuBox(){
        
        ChucVu_BUS chucVuBUS = new ChucVu_BUS();
        ArrayList<ChucVu_DTO> chucVuList = chucVuBUS.GetAllChucVu(); // Trích xuất toàn bộ phòng ban
    
        maChucVuBox.removeAllItems(); // Xoá danh sách cũ
    
        for (ChucVu_DTO chucVu : chucVuList)  // Tuỳ theo maChucVu, hiện tên chức vụ
            maChucVuBox.addItem(Integer.toString(chucVu.getMaChucVu()));
        
        maChucVuBox.setSelectedIndex(-1);
        tenChucVuField2.setText("");
    }

    private void UpdateTenChucVuBox(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateTenChucVuBox
        if(maChucVuBox.getSelectedIndex() != -1){
            int selectedPhongBan = Integer.parseInt(maChucVuBox.getSelectedItem().toString());
            ChucVu_BUS chucVu_BUS = new ChucVu_BUS();
            ChucVu_DTO chucVu = new ChucVu_DTO();
         
            
            chucVu = chucVu_BUS.GetChucVuByID(selectedPhongBan);
        
            tenChucVuField2.setText(chucVu.getTenChucVu());
        }
    }//GEN-LAST:event_UpdateTenChucVuBox


    //!
    //! Phòng ban  
    //!

    private DefaultTableModel defaultPhongBanTableModel = new DefaultTableModel();
    public void InitPhongBanTable(){
        
        phongBanTable.setModel(defaultPhongBanTableModel);
        
        defaultPhongBanTableModel.addColumn("Mã phòng ban");
        defaultPhongBanTableModel.addColumn("Tên phòng ban");

        ListSelectionModel listSelectionModel = phongBanTable.getSelectionModel();
        listSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        listSelectionModel.addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e){
               
                int rowIndex = phongBanTable.getSelectedRow();
                if(rowIndex != -1){ 
                    String maPhongBan = phongBanTable.getValueAt(rowIndex, 0).toString(); 
                    String tenPhongBan = phongBanTable.getValueAt(rowIndex, 1).toString();

                    maPhongBanField.setText(maPhongBan);
                    tenPhongBanField.setText(tenPhongBan);
                }  
            }
        });
    }
     
    private void UpdatePhongBanTable(){
        try {
            PhongBan_BUS phongBan_BUS = new PhongBan_BUS();
            ArrayList<PhongBan_DTO> phongBanList = phongBan_BUS.GetAllPhongBan();
            
            defaultPhongBanTableModel.setRowCount(0);
            
            for (PhongBan_DTO phongBan : phongBanList) {      
                defaultPhongBanTableModel.addRow(new Object[]{
                    phongBan.getMaPhongBan(),
                    phongBan.getTenPhongBan(),
                });
            } 
        }
        
        catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "Lỗi trích xuất thông tin phòng ban: " + e.getMessage(),
                "Lỗi",
                JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
    private void NewPhongBan(){
        ClearTextFields(PhongBanCard);
    }

    private void AddPhongBan() {                                                                             
        String maPhongBan = maPhongBanField.getText();
        if (maPhongBan.isEmpty() == false){
            String error = "Bấm nút 'New' trước khi thêm phòng ban.";
            JOptionPane.showMessageDialog(this, error, "Add phòng ban", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Validates_BUS validate = new Validates_BUS();
        String result = validate.ValidateTenPhongBan(tenPhongBanField);
        
        PhongBan_DTO phongBan = new PhongBan_DTO();
        
        if(result == null)
            phongBan.setTenPhongBan(tenPhongBanField.getText().trim());
             
        else{
            JOptionPane.showMessageDialog(this, result, "Phòng ban Validation", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        PhongBan_BUS phongBan_BUS = new PhongBan_BUS();
        
        if(phongBan_BUS.AddPhongBan(phongBan) == true)
                JOptionPane.showMessageDialog(null, "Thêm phòng thành công!");   
        else
           JOptionPane.showMessageDialog(null, "Thêm phòng ban không thành công!"); 
        
        // Sau khi thêm employee thì update lại table NhanVien list
        UpdatePhongBanTable();
    }
    
    private void EditPhongBan(){
        String maPhongBan = maNhanVienField.getText();
        if (maPhongBan.isEmpty() == true){
            String error = "Chọn phòng ban trong danh sách trước khi sửa";
            JOptionPane.showMessageDialog(this, error, "Edit nhân viên", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Validates_BUS validate = new Validates_BUS();
        String result = validate.ValidateTenPhongBan(tenPhongBanField);
        
        PhongBan_DTO phongBan = new PhongBan_DTO();
        
        if(result == null){
            phongBan.setTenPhongBan(tenPhongBanField.getText().trim());
            phongBan.setMaPhongBan(Integer.parseInt(maPhongBan));
        }
  
        else{
            JOptionPane.showMessageDialog(this, result, "Nhân Viên Validation", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        PhongBan_BUS phongBan_BUS = new PhongBan_BUS();
        
        if(phongBan_BUS.EditPhongBan(phongBan) == true)
                JOptionPane.showMessageDialog(null, "Sửa phòng ban thành công!");   
        else
           JOptionPane.showMessageDialog(null, "Sửa phòng ban không thành công!"); 
        
        // Sau khi thêm employee thì update lại table NhanVien list
        UpdatePhongBanTable();
    }
    
    private void DeletePhongBan(){
        String maPhongBan = maPhongBanField.getText();
        if (maPhongBan.isEmpty() == true){
            String error = "Chọn phòng ban trong danh sách trước khi xoá";
            JOptionPane.showMessageDialog(this, error, "Delete phòng ban", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Show confirmation dialog
        int confirm = JOptionPane.showConfirmDialog(
            this,
            "Bạn có chắc muốn xoá phòng ban ?",
            "Xác nhận xoá",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE
        );
    
        if (confirm == JOptionPane.YES_OPTION) {
            // User clicked YES - proceed with deletion
            PhongBan_BUS phongBan_BUS = new PhongBan_BUS();

            if (phongBan_BUS.DeletePhongBan(Integer.parseInt(maPhongBan)) == true) {
                JOptionPane.showMessageDialog(this, 
                    "Xoá phòng ban thành công.", 
                    "Thành công", 
                    JOptionPane.INFORMATION_MESSAGE);
                
                UpdatePhongBanTable();
            } 
            
            else {
                JOptionPane.showMessageDialog(this, 
                    "Xoá phòng ban thất bại.", 
                    "Lỗi", 
                    JOptionPane.ERROR_MESSAGE);
            }
        } 
        
        else {
            // User clicked NO or closed dialog - do nothing
            return;
        }
    }

    private void PhongBanCardButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PhongBanCardButton
        cardLayout.show(cardPanel, "phongBanCard");
    }//GEN-LAST:event_PhongBanCardButton
 
    private void addButton2(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButton2
        AddPhongBan();
    }//GEN-LAST:event_addButton2

    private void deleteButton2(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButton2
        DeletePhongBan();
    }//GEN-LAST:event_deleteButton2

    private void updateButton2(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButton2
        UpdatePhongBanTable();
    }//GEN-LAST:event_updateButton2

    private void newButton2(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButton2
        NewPhongBan();
    }//GEN-LAST:event_newButton2

    private void editButton2(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButton2
        EditPhongBan();
    }//GEN-LAST:event_editButton2

    //!
    //! Chức vụ
    //!
    
    private void NewChucVu(){
        ClearTextFields(ChucVuCard);
    }
    
    private DefaultTableModel defaultChucVuTableModel = new DefaultTableModel();
    public void InitChucVuTable(){
        
        chucVuTable.setModel(defaultChucVuTableModel);
        
        defaultChucVuTableModel.addColumn("Mã chức vụ");
        defaultChucVuTableModel.addColumn("Tên chức vụ");

        ListSelectionModel listSelectionModel = chucVuTable.getSelectionModel();
        listSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        listSelectionModel.addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e){
               
                int rowIndex = chucVuTable.getSelectedRow();
                if(rowIndex != -1){ 
                    String maChucVu = chucVuTable.getValueAt(rowIndex, 0).toString(); 
                    String tenChucVu = chucVuTable.getValueAt(rowIndex, 1).toString();

                    maChucVuField.setText(maChucVu);
                    tenChucVuField.setText(tenChucVu);
                }  
            }
        });
    }

    private void AddChucVu() {                                                                             
        String maChucVu = maChucVuField.getText();
        if (maChucVu.isEmpty() == false){
            String error = "Bấm nút 'New' trước khi thêm phòng ban.";
            JOptionPane.showMessageDialog(this, error, "Add phòng ban", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Validates_BUS validate = new Validates_BUS();
        String result = validate.ValidateTenChucVu(tenChucVuField);
        
        ChucVu_DTO phongBan = new ChucVu_DTO();
        
        if(result == null)
            phongBan.setTenChucVu(tenChucVuField.getText().trim());
             
        else{
            JOptionPane.showMessageDialog(this, result, "Phòng ban Validation", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        ChucVu_BUS phongBan_BUS = new ChucVu_BUS();
        
        if(phongBan_BUS.AddChucVu(phongBan) == true)
                JOptionPane.showMessageDialog(null, "Thêm phòng thành công!");   
        else
           JOptionPane.showMessageDialog(null, "Thêm phòng ban không thành công!"); 
        
        // Sau khi thêm employee thì update lại table NhanVien list
        UpdateChucVuTable();
    }
    
    private void EditChucVu(){
        String maChucVu = maNhanVienField.getText();
        if (maChucVu.isEmpty() == true){
            String error = "Chọn phòng ban trong danh sách trước khi sửa";
            JOptionPane.showMessageDialog(this, error, "Edit nhân viên", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Validates_BUS validate = new Validates_BUS();
        String result = validate.ValidateTenChucVu(tenChucVuField);
        
        ChucVu_DTO phongBan = new ChucVu_DTO();
        
        if(result == null){
            phongBan.setTenChucVu(tenChucVuField.getText().trim());
            phongBan.setMaChucVu(Integer.parseInt(maChucVu));
        }
  
        else{
            JOptionPane.showMessageDialog(this, result, "Nhân Viên Validation", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        ChucVu_BUS phongBan_BUS = new ChucVu_BUS();
        
        if(phongBan_BUS.EditChucVu(phongBan) == true)
                JOptionPane.showMessageDialog(null, "Sửa phòng ban thành công!");   
        else
           JOptionPane.showMessageDialog(null, "Sửa phòng ban không thành công!"); 
        
        // Sau khi thêm employee thì update lại table NhanVien list
        UpdateChucVuTable();
    }
    
    private void DeleteChucVu(){
        String maChucVu = maChucVuField.getText();
        if (maChucVu.isEmpty() == true){
            String error = "Chọn phòng ban trong danh sách trước khi xoá";
            JOptionPane.showMessageDialog(this, error, "Delete phòng ban", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Show confirmation dialog
        int confirm = JOptionPane.showConfirmDialog(
            this,
            "Bạn có chắc muốn xoá phòng ban ?",
            "Xác nhận xoá",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE
        );
    
        if (confirm == JOptionPane.YES_OPTION) {
            // User clicked YES - proceed with deletion
            ChucVu_BUS phongBan_BUS = new ChucVu_BUS();

            if (phongBan_BUS.DeleteChucVu(Integer.parseInt(maChucVu)) == true) {
                JOptionPane.showMessageDialog(this, 
                    "Xoá phòng ban thành công.", 
                    "Thành công", 
                    JOptionPane.INFORMATION_MESSAGE);
                
                UpdateChucVuTable();
            } 
            
            else {
                JOptionPane.showMessageDialog(this, 
                    "Xoá phòng ban thất bại.", 
                    "Lỗi", 
                    JOptionPane.ERROR_MESSAGE);
            }
        } 
        
        else {
            // User clicked NO or closed dialog - do nothing
            return;
        }
    }
      
    private void UpdateChucVuTable(){
        try {
            ChucVu_BUS chucVu_BUS = new ChucVu_BUS();
            ArrayList<ChucVu_DTO> chucVuList = chucVu_BUS.GetAllChucVu();
            
            defaultChucVuTableModel.setRowCount(0);
            
            for (ChucVu_DTO chucVu : chucVuList) {      
                defaultChucVuTableModel.addRow(new Object[]{
                    chucVu.getMaChucVu(),
                    chucVu.getTenChucVu(),
                });
            } 
        }
        
        catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "Lỗi trích xuất thông tin chức vụ: " + e.getMessage(),
                "Lỗi",
                JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void ChucVuCardButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChucVuCardButton
        cardLayout.show(cardPanel, "chucVuCard");
    }//GEN-LAST:event_ChucVuCardButton
    
    private void addButton3(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButton3
        AddChucVu();
    }//GEN-LAST:event_addButton3

    private void deleteButton3(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButton3
        DeleteChucVu();
    }//GEN-LAST:event_deleteButton3

    private void updateButton3(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButton3
        UpdateChucVuTable();
    }//GEN-LAST:event_updateButton3

    private void newButton3(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButton3
        NewChucVu();
    }//GEN-LAST:event_newButton3

    private void editButton3(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButton3
        EditChucVu();
    }//GEN-LAST:event_editButton3
    
    //!
    //! Hợp đồng
    //!
    
    private void HopDongCardButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HopDongCardButton
        cardLayout.show(cardPanel, "hopDongCard");
    }//GEN-LAST:event_HopDongCardButton

    private void newButton4(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButton4
        // TODO add your handling code here:
    }//GEN-LAST:event_newButton4
    
    private void addButton4(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButton4
        // TODO add your handling code here:
    }//GEN-LAST:event_addButton4

    private void editButton4(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButton4
        // TODO add your handling code here:
    }//GEN-LAST:event_editButton4

    private void deleteButton4(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButton4
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteButton4

    private void updateButton4(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButton4
        // TODO add your handling code here:
    }//GEN-LAST:event_updateButton4

        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        genderButtonGroup = new javax.swing.ButtonGroup();
        bangMenu = new javax.swing.JPanel();
        menuButton1 = new javax.swing.JButton();
        menuButton2 = new javax.swing.JButton();
        menuButton3 = new javax.swing.JButton();
        menuButton4 = new javax.swing.JButton();
        menuButton5 = new javax.swing.JButton();
        menuButton6 = new javax.swing.JButton();
        menuButton7 = new javax.swing.JButton();
        menuButton8 = new javax.swing.JButton();
        cardPanel = new javax.swing.JPanel();
        NhanVienCard = new javax.swing.JPanel();
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
        PhongBanCard = new javax.swing.JPanel();
        bangPhongBan = new javax.swing.JPanel();
        JLabel11 = new javax.swing.JLabel();
        JLabel12 = new javax.swing.JLabel();
        maPhongBanField = new javax.swing.JTextField();
        tenPhongBanField = new javax.swing.JTextField();
        danhSachPhongBan = new javax.swing.JScrollPane();
        phongBanTable = new javax.swing.JTable();
        menuPhongBan = new javax.swing.JPanel();
        addButton2 = new javax.swing.JButton();
        deleteButton2 = new javax.swing.JButton();
        updateButton2 = new javax.swing.JButton();
        newButton2 = new javax.swing.JButton();
        editButton2 = new javax.swing.JButton();
        ChucVuCard = new javax.swing.JPanel();
        bangChucVu = new javax.swing.JPanel();
        JLabel13 = new javax.swing.JLabel();
        JLabel14 = new javax.swing.JLabel();
        maChucVuField = new javax.swing.JTextField();
        tenChucVuField = new javax.swing.JTextField();
        danhSachChucVu = new javax.swing.JScrollPane();
        chucVuTable = new javax.swing.JTable();
        menuChucVu = new javax.swing.JPanel();
        addButton3 = new javax.swing.JButton();
        deleteButton3 = new javax.swing.JButton();
        updateButton3 = new javax.swing.JButton();
        newButton3 = new javax.swing.JButton();
        editButton3 = new javax.swing.JButton();
        HopDongCard = new javax.swing.JPanel();
        bangHopDong = new javax.swing.JPanel();
        JLabel15 = new javax.swing.JLabel();
        JLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        maHopDongField = new javax.swing.JTextField();
        maNhanVienBox = new javax.swing.JComboBox<>();
        ngayBatDauChooser = new com.toedter.calendar.JDateChooser();
        ngayKetThucChooser = new com.toedter.calendar.JDateChooser();
        danhSachHopDong = new javax.swing.JScrollPane();
        hopDongTable = new javax.swing.JTable();
        menuHopDong = new javax.swing.JPanel();
        addButton4 = new javax.swing.JButton();
        deleteButton4 = new javax.swing.JButton();
        updateButton4 = new javax.swing.JButton();
        newButton4 = new javax.swing.JButton();
        editButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 153, 153));

        bangMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        menuButton1.setText("Nhân viên");
        menuButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NhanVienCardButton(evt);
            }
        });

        menuButton2.setText("Phòng ban");
        menuButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PhongBanCardButton(evt);
            }
        });

        menuButton3.setText("Chức vụ");
        menuButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChucVuCardButton(evt);
            }
        });

        menuButton4.setText("Hợp đồng");
        menuButton4.setToolTipText("");
        menuButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HopDongCardButton(evt);
            }
        });

        menuButton5.setText("Lương");

        menuButton6.setText("Chấm công");

        menuButton7.setText("Tăng ca");

        menuButton8.setText("Nghỉ phép");

        javax.swing.GroupLayout bangMenuLayout = new javax.swing.GroupLayout(bangMenu);
        bangMenu.setLayout(bangMenuLayout);
        bangMenuLayout.setHorizontalGroup(
            bangMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bangMenuLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(bangMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menuButton8)
                    .addComponent(menuButton7)
                    .addComponent(menuButton6)
                    .addComponent(menuButton5)
                    .addComponent(menuButton4)
                    .addComponent(menuButton3)
                    .addComponent(menuButton2)
                    .addComponent(menuButton1))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        bangMenuLayout.setVerticalGroup(
            bangMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bangMenuLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(menuButton1)
                .addGap(29, 29, 29)
                .addComponent(menuButton2)
                .addGap(35, 35, 35)
                .addComponent(menuButton3)
                .addGap(42, 42, 42)
                .addComponent(menuButton4)
                .addGap(31, 31, 31)
                .addComponent(menuButton5)
                .addGap(35, 35, 35)
                .addComponent(menuButton6)
                .addGap(33, 33, 33)
                .addComponent(menuButton7)
                .addGap(43, 43, 43)
                .addComponent(menuButton8)
                .addContainerGap(187, Short.MAX_VALUE))
        );

        menuButton1.getAccessibleContext().setAccessibleName("");
        menuButton2.getAccessibleContext().setAccessibleName("");
        menuButton2.getAccessibleContext().setAccessibleDescription("");
        menuButton3.getAccessibleContext().setAccessibleName("");
        menuButton4.getAccessibleContext().setAccessibleName("");
        menuButton5.getAccessibleContext().setAccessibleName("");
        menuButton6.getAccessibleContext().setAccessibleName("");
        menuButton7.getAccessibleContext().setAccessibleName("");
        menuButton8.getAccessibleContext().setAccessibleName("");

        cardPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cardPanel.setLayout(new java.awt.CardLayout());

        bangNhanVien.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        JLabel1.setText("Mã nhân viên");

        JLabel2.setText("Họ và tên");

        JLabel3.setText("Ngày Sinh");

        JLabel4.setText("Giới tính");

        JLabel5.setText("Địa chỉ");

        JLabel6.setText("Số điện thoại");

        maNhanVienField.setEditable(false);

        genderButtonGroup.add(gioiTinhNam);
        gioiTinhNam.setText("Male");

        genderButtonGroup.add(gioiTinhNu);
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
                updateNhanVienTableButton(evt);
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

        javax.swing.GroupLayout NhanVienCardLayout = new javax.swing.GroupLayout(NhanVienCard);
        NhanVienCard.setLayout(NhanVienCardLayout);
        NhanVienCardLayout.setHorizontalGroup(
            NhanVienCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NhanVienCardLayout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(NhanVienCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(danhSachNhanVien)
                    .addGroup(NhanVienCardLayout.createSequentialGroup()
                        .addComponent(bangNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(menuNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        NhanVienCardLayout.setVerticalGroup(
            NhanVienCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NhanVienCardLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(NhanVienCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(menuNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bangNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(danhSachNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        cardPanel.add(NhanVienCard, "nhanVienCard");

        bangPhongBan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        JLabel11.setText("Mã phòng ban");

        JLabel12.setText("Tên phòng ban");

        maPhongBanField.setEditable(false);

        javax.swing.GroupLayout bangPhongBanLayout = new javax.swing.GroupLayout(bangPhongBan);
        bangPhongBan.setLayout(bangPhongBanLayout);
        bangPhongBanLayout.setHorizontalGroup(
            bangPhongBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bangPhongBanLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(bangPhongBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLabel12)
                    .addComponent(JLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(bangPhongBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tenPhongBanField, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                    .addComponent(maPhongBanField))
                .addContainerGap(418, Short.MAX_VALUE))
        );
        bangPhongBanLayout.setVerticalGroup(
            bangPhongBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bangPhongBanLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(bangPhongBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLabel11)
                    .addComponent(maPhongBanField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(bangPhongBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLabel12)
                    .addComponent(tenPhongBanField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(289, 289, 289))
        );

        phongBanTable.setModel(new javax.swing.table.DefaultTableModel(
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
        danhSachPhongBan.setViewportView(phongBanTable);

        menuPhongBan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        addButton2.setText("Add");
        addButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButton2(evt);
            }
        });

        deleteButton2.setText("Delete");
        deleteButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButton2(evt);
            }
        });

        updateButton2.setText("Update");
        updateButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButton2(evt);
            }
        });

        newButton2.setText("New");
        newButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButton2(evt);
            }
        });

        editButton2.setText("Edit");
        editButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButton2(evt);
            }
        });

        javax.swing.GroupLayout menuPhongBanLayout = new javax.swing.GroupLayout(menuPhongBan);
        menuPhongBan.setLayout(menuPhongBanLayout);
        menuPhongBanLayout.setHorizontalGroup(
            menuPhongBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuPhongBanLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(menuPhongBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(newButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
            .addGroup(menuPhongBanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuPhongBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(updateButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menuPhongBanLayout.setVerticalGroup(
            menuPhongBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuPhongBanLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(newButton2)
                .addGap(57, 57, 57)
                .addComponent(addButton2)
                .addGap(18, 18, 18)
                .addComponent(editButton2)
                .addGap(18, 18, 18)
                .addComponent(deleteButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(updateButton2)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout PhongBanCardLayout = new javax.swing.GroupLayout(PhongBanCard);
        PhongBanCard.setLayout(PhongBanCardLayout);
        PhongBanCardLayout.setHorizontalGroup(
            PhongBanCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PhongBanCardLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PhongBanCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(danhSachPhongBan)
                    .addGroup(PhongBanCardLayout.createSequentialGroup()
                        .addComponent(bangPhongBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(menuPhongBan, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        PhongBanCardLayout.setVerticalGroup(
            PhongBanCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PhongBanCardLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(PhongBanCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(menuPhongBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bangPhongBan, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(danhSachPhongBan, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        cardPanel.add(PhongBanCard, "phongBanCard");

        bangChucVu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        JLabel13.setText("Mã chức vụ");

        JLabel14.setText("Tên chức vụ");

        maChucVuField.setEditable(false);

        javax.swing.GroupLayout bangChucVuLayout = new javax.swing.GroupLayout(bangChucVu);
        bangChucVu.setLayout(bangChucVuLayout);
        bangChucVuLayout.setHorizontalGroup(
            bangChucVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bangChucVuLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(bangChucVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLabel14)
                    .addComponent(JLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(bangChucVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tenChucVuField, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                    .addComponent(maChucVuField))
                .addContainerGap(418, Short.MAX_VALUE))
        );
        bangChucVuLayout.setVerticalGroup(
            bangChucVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bangChucVuLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(bangChucVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLabel13)
                    .addComponent(maChucVuField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(bangChucVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLabel14)
                    .addComponent(tenChucVuField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(289, 289, 289))
        );

        chucVuTable.setModel(new javax.swing.table.DefaultTableModel(
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
        danhSachChucVu.setViewportView(chucVuTable);

        menuChucVu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        addButton3.setText("Add");
        addButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButton3(evt);
            }
        });

        deleteButton3.setText("Delete");
        deleteButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButton3(evt);
            }
        });

        updateButton3.setText("Update");
        updateButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButton3(evt);
            }
        });

        newButton3.setText("New");
        newButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButton3(evt);
            }
        });

        editButton3.setText("Edit");
        editButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButton3(evt);
            }
        });

        javax.swing.GroupLayout menuChucVuLayout = new javax.swing.GroupLayout(menuChucVu);
        menuChucVu.setLayout(menuChucVuLayout);
        menuChucVuLayout.setHorizontalGroup(
            menuChucVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuChucVuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(menuChucVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(newButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
            .addGroup(menuChucVuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuChucVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(updateButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menuChucVuLayout.setVerticalGroup(
            menuChucVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuChucVuLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(newButton3)
                .addGap(57, 57, 57)
                .addComponent(addButton3)
                .addGap(18, 18, 18)
                .addComponent(editButton3)
                .addGap(18, 18, 18)
                .addComponent(deleteButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(updateButton3)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout ChucVuCardLayout = new javax.swing.GroupLayout(ChucVuCard);
        ChucVuCard.setLayout(ChucVuCardLayout);
        ChucVuCardLayout.setHorizontalGroup(
            ChucVuCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ChucVuCardLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ChucVuCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(danhSachChucVu)
                    .addGroup(ChucVuCardLayout.createSequentialGroup()
                        .addComponent(bangChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(menuChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        ChucVuCardLayout.setVerticalGroup(
            ChucVuCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ChucVuCardLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(ChucVuCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(menuChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bangChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(danhSachChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        cardPanel.add(ChucVuCard, "chucVuCard");

        bangHopDong.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        JLabel15.setText("Mã hợp đồng");

        JLabel16.setText("Mã nhân viên");

        jLabel17.setText("Ngày bắt đầu");

        jLabel18.setText("Ngày kết thúc");

        maHopDongField.setEditable(false);

        maNhanVienBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout bangHopDongLayout = new javax.swing.GroupLayout(bangHopDong);
        bangHopDong.setLayout(bangHopDongLayout);
        bangHopDongLayout.setHorizontalGroup(
            bangHopDongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bangHopDongLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(bangHopDongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLabel16)
                    .addComponent(JLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18))
                .addGap(32, 32, 32)
                .addGroup(bangHopDongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(bangHopDongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(maHopDongField, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(maNhanVienBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bangHopDongLayout.createSequentialGroup()
                        .addGroup(bangHopDongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ngayKetThucChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ngayBatDauChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(234, 234, 234)))
                .addContainerGap(418, Short.MAX_VALUE))
        );
        bangHopDongLayout.setVerticalGroup(
            bangHopDongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bangHopDongLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(bangHopDongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLabel15)
                    .addComponent(maHopDongField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(bangHopDongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLabel16)
                    .addComponent(maNhanVienBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(bangHopDongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(ngayBatDauChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(bangHopDongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(ngayKetThucChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(208, Short.MAX_VALUE))
        );

        hopDongTable.setModel(new javax.swing.table.DefaultTableModel(
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
        danhSachHopDong.setViewportView(hopDongTable);

        menuHopDong.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        addButton4.setText("Add");
        addButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButton4(evt);
            }
        });

        deleteButton4.setText("Delete");
        deleteButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButton4(evt);
            }
        });

        updateButton4.setText("Update");
        updateButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButton4(evt);
            }
        });

        newButton4.setText("New");
        newButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButton4(evt);
            }
        });

        editButton4.setText("Edit");
        editButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButton4(evt);
            }
        });

        javax.swing.GroupLayout menuHopDongLayout = new javax.swing.GroupLayout(menuHopDong);
        menuHopDong.setLayout(menuHopDongLayout);
        menuHopDongLayout.setHorizontalGroup(
            menuHopDongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuHopDongLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(menuHopDongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(newButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
            .addGroup(menuHopDongLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuHopDongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(updateButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menuHopDongLayout.setVerticalGroup(
            menuHopDongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuHopDongLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(newButton4)
                .addGap(57, 57, 57)
                .addComponent(addButton4)
                .addGap(18, 18, 18)
                .addComponent(editButton4)
                .addGap(18, 18, 18)
                .addComponent(deleteButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(updateButton4)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout HopDongCardLayout = new javax.swing.GroupLayout(HopDongCard);
        HopDongCard.setLayout(HopDongCardLayout);
        HopDongCardLayout.setHorizontalGroup(
            HopDongCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HopDongCardLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(HopDongCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(danhSachHopDong)
                    .addGroup(HopDongCardLayout.createSequentialGroup()
                        .addComponent(bangHopDong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(menuHopDong, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        HopDongCardLayout.setVerticalGroup(
            HopDongCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HopDongCardLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(HopDongCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(menuHopDong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bangHopDong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(danhSachHopDong, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        cardPanel.add(HopDongCard, "hopDongCard");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bangMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1130, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(157, Short.MAX_VALUE)
                    .addComponent(cardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(16, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(bangMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(cardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 689, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(15, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ChucVuCard;
    private javax.swing.JPanel HopDongCard;
    private javax.swing.JLabel JLabel1;
    private javax.swing.JLabel JLabel10;
    private javax.swing.JLabel JLabel11;
    private javax.swing.JLabel JLabel12;
    private javax.swing.JLabel JLabel13;
    private javax.swing.JLabel JLabel14;
    private javax.swing.JLabel JLabel15;
    private javax.swing.JLabel JLabel16;
    private javax.swing.JLabel JLabel2;
    private javax.swing.JLabel JLabel3;
    private javax.swing.JLabel JLabel4;
    private javax.swing.JLabel JLabel5;
    private javax.swing.JLabel JLabel6;
    private javax.swing.JLabel JLabel7;
    private javax.swing.JLabel JLabel8;
    private javax.swing.JPanel NhanVienCard;
    private javax.swing.JPanel PhongBanCard;
    private javax.swing.JButton addButton1;
    private javax.swing.JButton addButton2;
    private javax.swing.JButton addButton3;
    private javax.swing.JButton addButton4;
    private javax.swing.JPanel bangChucVu;
    private javax.swing.JPanel bangHopDong;
    private javax.swing.JPanel bangMenu;
    private javax.swing.JPanel bangNhanVien;
    private javax.swing.JPanel bangPhongBan;
    private javax.swing.JPanel cardPanel;
    private javax.swing.JTable chucVuTable;
    private javax.swing.JScrollPane danhSachChucVu;
    private javax.swing.JScrollPane danhSachHopDong;
    private javax.swing.JScrollPane danhSachNhanVien;
    private javax.swing.JScrollPane danhSachPhongBan;
    private javax.swing.JButton deleteButton1;
    private javax.swing.JButton deleteButton2;
    private javax.swing.JButton deleteButton3;
    private javax.swing.JButton deleteButton4;
    private javax.swing.JTextField diaChiField;
    private javax.swing.JButton editButton1;
    private javax.swing.JButton editButton2;
    private javax.swing.JButton editButton3;
    private javax.swing.JButton editButton4;
    private javax.swing.ButtonGroup genderButtonGroup;
    private javax.swing.JRadioButton gioiTinhNam;
    private javax.swing.JRadioButton gioiTinhNu;
    private javax.swing.JTextField hoTenField;
    private javax.swing.JTable hopDongTable;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JComboBox<String> maChucVuBox;
    private javax.swing.JTextField maChucVuField;
    private javax.swing.JTextField maHopDongField;
    private javax.swing.JComboBox<String> maNhanVienBox;
    private javax.swing.JTextField maNhanVienField;
    private javax.swing.JComboBox<String> maPhongBanBox;
    private javax.swing.JTextField maPhongBanField;
    private javax.swing.JButton menuButton1;
    private javax.swing.JButton menuButton2;
    private javax.swing.JButton menuButton3;
    private javax.swing.JButton menuButton4;
    private javax.swing.JButton menuButton5;
    private javax.swing.JButton menuButton6;
    private javax.swing.JButton menuButton7;
    private javax.swing.JButton menuButton8;
    private javax.swing.JPanel menuChucVu;
    private javax.swing.JPanel menuHopDong;
    private javax.swing.JPanel menuNhanVien;
    private javax.swing.JPanel menuPhongBan;
    private javax.swing.JButton newButton1;
    private javax.swing.JButton newButton2;
    private javax.swing.JButton newButton3;
    private javax.swing.JButton newButton4;
    private com.toedter.calendar.JDateChooser ngayBatDauChooser;
    private com.toedter.calendar.JDateChooser ngayKetThucChooser;
    private com.toedter.calendar.JDateChooser ngaySinhChooser;
    private javax.swing.JTable nhanVienTable;
    private javax.swing.JTable phongBanTable;
    private javax.swing.JTextField soDienThoaiField;
    private javax.swing.JTextField tenChucVuField;
    private javax.swing.JTextField tenChucVuField2;
    private javax.swing.JTextField tenPhongBanField;
    private javax.swing.JTextField tenPhongBanField2;
    private javax.swing.JComboBox<String> trangThaiBox;
    private javax.swing.JButton updateButton1;
    private javax.swing.JButton updateButton2;
    private javax.swing.JButton updateButton3;
    private javax.swing.JButton updateButton4;
    // End of variables declaration//GEN-END:variables
}
