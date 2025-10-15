
package com.em.GUI;

import com.em.BUS.Luong_BUS;
import com.em.BUS.NhanVien_BUS;
import com.em.BUS.Validates_BUS;
import com.em.DTO.Luong_DTO;
import com.em.DTO.NhanVien_DTO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class LuongPanel_GUI extends javax.swing.JPanel{

    public LuongPanel_GUI(){
        initComponents();
        
        InitLuongTable();
        UpdateLuongTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bangLuong = new javax.swing.JPanel();
        JLabel17 = new javax.swing.JLabel();
        JLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        maLuongField = new javax.swing.JTextField();
        maNhanVienBox2 = new javax.swing.JComboBox<>();
        tenNhanVienField2 = new javax.swing.JTextField();
        luongCoBanField = new javax.swing.JTextField();
        soGioCoBanField = new javax.swing.JTextField();
        ngayNhanLuongChooser = new com.toedter.calendar.JDateChooser();
        danhSachLuong = new javax.swing.JScrollPane();
        luongTable = new javax.swing.JTable();
        menuLuong = new javax.swing.JPanel();
        addButton5 = new javax.swing.JButton();
        deleteButton5 = new javax.swing.JButton();
        updateButton5 = new javax.swing.JButton();
        newButton5 = new javax.swing.JButton();
        editButton5 = new javax.swing.JButton();

        bangLuong.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        JLabel17.setText("Mã lương");

        JLabel18.setText("Mã nhân viên");

        jLabel20.setText("Lương cơ bản");

        jLabel21.setText("Số giờ cơ bản");

        jLabel22.setText("Tên nhân viên");

        jLabel1.setText("Ngày nhận lương");

        maLuongField.setEditable(false);

        maNhanVienBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        maNhanVienBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateTenMaNhanVienBox2(evt);
            }
        });

        tenNhanVienField2.setEditable(false);

        luongCoBanField.setPreferredSize(new java.awt.Dimension(81, 28));

        soGioCoBanField.setToolTipText("");
        soGioCoBanField.setPreferredSize(new java.awt.Dimension(81, 28));

        javax.swing.GroupLayout bangLuongLayout = new javax.swing.GroupLayout(bangLuong);
        bangLuong.setLayout(bangLuongLayout);
        bangLuongLayout.setHorizontalGroup(
            bangLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bangLuongLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(bangLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLabel18)
                    .addComponent(JLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(jLabel1))
                .addGroup(bangLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bangLuongLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(bangLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(maLuongField, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(bangLuongLayout.createSequentialGroup()
                                .addComponent(maNhanVienBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64)
                                .addComponent(jLabel22)
                                .addGap(33, 33, 33)
                                .addComponent(tenNhanVienField2, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(bangLuongLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(bangLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ngayNhanLuongChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(luongCoBanField, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                            .addComponent(soGioCoBanField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        bangLuongLayout.setVerticalGroup(
            bangLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bangLuongLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(bangLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLabel17)
                    .addComponent(maLuongField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(bangLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLabel18)
                    .addComponent(maNhanVienBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(tenNhanVienField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(bangLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(luongCoBanField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(bangLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(soGioCoBanField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(bangLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ngayNhanLuongChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(170, Short.MAX_VALUE))
        );

        luongTable.setModel(new javax.swing.table.DefaultTableModel(
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
        danhSachLuong.setViewportView(luongTable);

        menuLuong.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        addButton5.setText("Add");
        addButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButton5(evt);
            }
        });

        deleteButton5.setText("Delete");
        deleteButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButton5(evt);
            }
        });

        updateButton5.setText("Update");
        updateButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButton5(evt);
            }
        });

        newButton5.setText("New");
        newButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButton5(evt);
            }
        });

        editButton5.setText("Edit");
        editButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButton5(evt);
            }
        });

        javax.swing.GroupLayout menuLuongLayout = new javax.swing.GroupLayout(menuLuong);
        menuLuong.setLayout(menuLuongLayout);
        menuLuongLayout.setHorizontalGroup(
            menuLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuLuongLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(menuLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(newButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
            .addGroup(menuLuongLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(updateButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menuLuongLayout.setVerticalGroup(
            menuLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuLuongLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(newButton5)
                .addGap(57, 57, 57)
                .addComponent(addButton5)
                .addGap(18, 18, 18)
                .addComponent(editButton5)
                .addGap(18, 18, 18)
                .addComponent(deleteButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(updateButton5)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(danhSachLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 1052, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bangLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(menuLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(314, 314, 314))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bangLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menuLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(danhSachLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private DefaultTableModel defaultLuongTableModel = new DefaultTableModel();
    public void InitLuongTable(){
        
        luongTable.setModel(defaultLuongTableModel);
        
        defaultLuongTableModel.addColumn("Mã lương");
        defaultLuongTableModel.addColumn("Mã nhân viên");
        defaultLuongTableModel.addColumn("Lương cơ bản");
        defaultLuongTableModel.addColumn("Số giờ cơ bản");
        defaultLuongTableModel.addColumn("Ngày nhận lương");

        ListSelectionModel listSelectionModel = luongTable.getSelectionModel();
        listSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        listSelectionModel.addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e){
               
                int rowIndex = luongTable.getSelectedRow();
                if(rowIndex != -1){ 
                    String maLuong = luongTable.getValueAt(rowIndex, 0).toString();
                    String maNhanVien = luongTable.getValueAt(rowIndex, 1).toString();
                    String luongCoBan = luongTable.getValueAt(rowIndex, 2).toString();
                    String soGioCoBan = luongTable.getValueAt(rowIndex, 3).toString();
                    String ngayNhanLuong = luongTable.getValueAt(rowIndex, 4).toString();
                    
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    
                    try {
                        Date ngayNhanLuongFormat = dateFormat.parse(ngayNhanLuong);
                        
                        ngayNhanLuongChooser.setDateFormatString("dd/MM/yyyy");
                        ngayNhanLuongChooser.setDate(ngayNhanLuongFormat);
                    }                    
                    catch (ParseException d) {
                        d.printStackTrace();               
                    }  
                        
                    maLuongField.setText(maLuong); 
                    luongCoBanField.setText(luongCoBan);
                    soGioCoBanField.setText(soGioCoBan);
                    maNhanVienBox2.setSelectedItem(maNhanVien);
                }
            }
        });
    } 
    private boolean UpdateLuongTable(){
        try {
            Luong_BUS Luong_BUS = new Luong_BUS();
            ArrayList<Luong_DTO> luongList = Luong_BUS.GetAllLuong();
            
            defaultLuongTableModel.setRowCount(0);            
            for (Luong_DTO luong : luongList) {
                
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                
                String ngayNhanLuongFormat = "";
                ngayNhanLuongFormat = dateFormat.format(luong.getNgayNhanLuong());
                
                defaultLuongTableModel.addRow(new Object[]{
                    luong.getMaLuong(),
                    luong.getMaNhanVien(),
                    luong.getLuongCoBan(),
                    luong.getSoGioCoBan(),
                    ngayNhanLuongFormat,
                });
            }
        }
        
        catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "Lỗi trích xuất thông tin lương: " + e.getMessage(),
                "Lỗi",
                JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            
            return false;
        }
        
        return true;
    }
    
    private void NewLuong(){
        App_UI.ClearAllField(this);
    }

    private void AddLuong() {                                                                             
        String maLuong = maLuongField.getText();
        if (maLuong.isEmpty() == false){
            String error = "Bấm nút 'New' trước khi thêm lương.";
            JOptionPane.showMessageDialog(this, error, "Add lương", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Validates_BUS validate = new Validates_BUS();
        String result = validate.ValidateLuong(maNhanVienBox2, luongCoBanField, soGioCoBanField, ngayNhanLuongChooser);
        
        Luong_DTO luong = new Luong_DTO();
        
        if(result == null)
            luong = validate.ReturnLuong(maNhanVienBox2, luongCoBanField, soGioCoBanField, ngayNhanLuongChooser);
      
        else{
            JOptionPane.showMessageDialog(this, result, "Lương Validation", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Luong_BUS luong_BUS = new Luong_BUS();
        
        if(luong_BUS.AddLuong(luong) == true)
            JOptionPane.showMessageDialog(null, "Thêm lương thành công!");   
        else
           JOptionPane.showMessageDialog(null, "Thêm lương không thành công!"); 
        

        UpdateLuongTable();
    }
    
    private void EditLuong(){
        String maLuong = maLuongField.getText();
        if (maLuong.isEmpty() == false){
            String error = "Bấm nút 'New' trước khi sửa lương.";
            JOptionPane.showMessageDialog(this, error, "Edit lương", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Validates_BUS validate = new Validates_BUS();
        String result = validate.ValidateLuong(maNhanVienBox2, luongCoBanField, soGioCoBanField, ngayNhanLuongChooser);
        
        Luong_DTO luong = new Luong_DTO();
        
        if(result == null)
            luong = validate.ReturnLuong(maNhanVienBox2, luongCoBanField, soGioCoBanField, ngayNhanLuongChooser);
      
        else{
            JOptionPane.showMessageDialog(this, result, "Lương Validation", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Luong_BUS luong_BUS = new Luong_BUS();
        
        if(luong_BUS.EditLuong(luong) == true)
            JOptionPane.showMessageDialog(null, "Sửa lương thành công!");   
        else
           JOptionPane.showMessageDialog(null, "Sửa lương không thành công!"); 
        

        UpdateLuongTable();
    }
    
    private void DeleteLuong(){
        String maLuong = maLuongField.getText();
        if (maLuong.isEmpty() == true){
            String error = "Chọn lương trong danh sách trước khi xoá";
            JOptionPane.showMessageDialog(this, error, "Delete lương", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Show confirmation dialog
        int confirm = JOptionPane.showConfirmDialog(
            this,
            "Bạn có chắc muốn xoá lương ?",
            "Xác nhận xoá",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE
        );
    
        if (confirm == JOptionPane.YES_OPTION) {
            // User clicked YES - proceed with deletion
            Luong_BUS luong_BUS = new Luong_BUS();

            if (luong_BUS.DeleteLuong(Integer.parseInt(maLuong)) == true) {
                JOptionPane.showMessageDialog(this, 
                    "Xoá lương thành công.", 
                    "Thành công", 
                    JOptionPane.INFORMATION_MESSAGE);
                
                UpdateLuongTable();
            } 
            
            else {
                JOptionPane.showMessageDialog(this, 
                    "Xoá lương thất bại.", 
                    "Lỗi", 
                    JOptionPane.ERROR_MESSAGE);
            }
        } 
        
        else {
            // User clicked NO or closed dialog - do nothing
            return;
        }
    }            
    
    public void UpdateTenMaNhanVienBox2() {                                                      
        NhanVien_BUS nhanVien_BUS = new NhanVien_BUS();
        ArrayList<NhanVien_DTO> nhanVienList = nhanVien_BUS.GetAllNhanVien();
    
        maNhanVienBox2.removeAllItems();
    
        for (NhanVien_DTO nhanVien : nhanVienList)
            maNhanVienBox2.addItem(Integer.toString(nhanVien.getMaNhanVien()));
        
        maNhanVienBox2.setSelectedIndex(-1);
        tenNhanVienField2.setText("");
    }   
    
    private void UpdateTenMaNhanVienBox2(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateTenMaNhanVienBox2
        if(maNhanVienBox2.getSelectedIndex() != -1){
            int selectedNhanVien = Integer.parseInt(maNhanVienBox2.getSelectedItem().toString());
            
            NhanVien_BUS nhanVien_BUS = new NhanVien_BUS();
        
            NhanVien_DTO nhanVien = new NhanVien_DTO();
            nhanVien = nhanVien_BUS.GetNhanVienById(selectedNhanVien);
            
            tenNhanVienField2.setText(nhanVien.getHoTen());
        }
    }//GEN-LAST:event_UpdateTenMaNhanVienBox2

    private void newButton5(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButton5
        NewLuong();
    }//GEN-LAST:event_newButton5

    private void addButton5(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButton5
        AddLuong();
    }//GEN-LAST:event_addButton5

    private void editButton5(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButton5
        EditLuong();
    }//GEN-LAST:event_editButton5

    private void deleteButton5(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButton5
        DeleteLuong();
    }//GEN-LAST:event_deleteButton5

    private void updateButton5(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButton5
        if(UpdateLuongTable()){
            String text = "Update thành công";
            JOptionPane.showMessageDialog(this, text, "Update", JOptionPane.WIDTH);
        }
    }//GEN-LAST:event_updateButton5

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabel17;
    private javax.swing.JLabel JLabel18;
    private javax.swing.JButton addButton5;
    private javax.swing.JPanel bangLuong;
    private javax.swing.JScrollPane danhSachLuong;
    private javax.swing.JButton deleteButton5;
    private javax.swing.JButton editButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JTextField luongCoBanField;
    private javax.swing.JTable luongTable;
    private javax.swing.JTextField maLuongField;
    private javax.swing.JComboBox<String> maNhanVienBox2;
    private javax.swing.JPanel menuLuong;
    private javax.swing.JButton newButton5;
    private com.toedter.calendar.JDateChooser ngayNhanLuongChooser;
    private javax.swing.JTextField soGioCoBanField;
    private javax.swing.JTextField tenNhanVienField2;
    private javax.swing.JButton updateButton5;
    // End of variables declaration//GEN-END:variables
}
