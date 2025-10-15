
package com.em.GUI;

import com.em.BUS.ChucVu_BUS;
import com.em.BUS.Validates_BUS;
import com.em.DTO.ChucVu_DTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class ChucVuPanel_GUI extends javax.swing.JPanel{

    public ChucVuPanel_GUI(){
        initComponents();
        
        InitChucVuTable();
        UpdateChucVuTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(danhSachChucVu)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bangChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(menuChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(menuChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bangChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(danhSachChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    
   
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

    private void NewChucVu(){
        App_UI.ClearAllField(this);
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
        String maChucVu = maChucVuField.getText();
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
      
    private boolean UpdateChucVuTable(){
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
            
            return false;
        }
        
        return true;
    }
    
    private void newButton3(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButton3
        NewChucVu();
    }//GEN-LAST:event_newButton3

    private void addButton3(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButton3
        AddChucVu();
    }//GEN-LAST:event_addButton3

    private void editButton3(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButton3
        EditChucVu();
    }//GEN-LAST:event_editButton3

    private void deleteButton3(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButton3
        DeleteChucVu();
    }//GEN-LAST:event_deleteButton3

    private void updateButton3(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButton3
        if(UpdateChucVuTable()){
            String text = "Update thành công";
            JOptionPane.showMessageDialog(this, text, "Update", JOptionPane.WIDTH);
        }
    }//GEN-LAST:event_updateButton3

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabel13;
    private javax.swing.JLabel JLabel14;
    private javax.swing.JButton addButton3;
    private javax.swing.JPanel bangChucVu;
    private javax.swing.JTable chucVuTable;
    private javax.swing.JScrollPane danhSachChucVu;
    private javax.swing.JButton deleteButton3;
    private javax.swing.JButton editButton3;
    private javax.swing.JTextField maChucVuField;
    private javax.swing.JPanel menuChucVu;
    private javax.swing.JButton newButton3;
    private javax.swing.JTextField tenChucVuField;
    private javax.swing.JButton updateButton3;
    // End of variables declaration//GEN-END:variables
}
