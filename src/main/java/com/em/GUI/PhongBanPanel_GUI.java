
package com.em.GUI;

import com.em.BUS.PhongBan_BUS;
import com.em.BUS.Validates_BUS;
import com.em.DTO.PhongBan_DTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import com.em.GUI.App_UI;


public class PhongBanPanel_GUI extends javax.swing.JPanel{

    public PhongBanPanel_GUI(){
        initComponents();
        
        InitPhongBanTable();
        UpdatePhongBanTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(danhSachPhongBan)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bangPhongBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(menuPhongBan, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(menuPhongBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bangPhongBan, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(danhSachPhongBan, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

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
     
    private boolean UpdatePhongBanTable(){
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
            
            return false;
        }
        
        return true;
    }
    
    private void NewPhongBan(){
        App_UI.ClearAllField(this);
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
        String maPhongBan = maPhongBanField.getText();
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
    
    private void newButton2(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButton2
        NewPhongBan();
    }//GEN-LAST:event_newButton2

    private void addButton2(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButton2
        AddPhongBan();
    }//GEN-LAST:event_addButton2

    private void editButton2(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButton2
        EditPhongBan();
    }//GEN-LAST:event_editButton2

    private void deleteButton2(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButton2
        DeletePhongBan();
    }//GEN-LAST:event_deleteButton2

    private void updateButton2(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButton2
        if(UpdatePhongBanTable()){
            String text = "Update thành công";
            JOptionPane.showMessageDialog(this, text, "Update", JOptionPane.WIDTH);
        }
    }//GEN-LAST:event_updateButton2

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabel11;
    private javax.swing.JLabel JLabel12;
    private javax.swing.JButton addButton2;
    private javax.swing.JPanel bangPhongBan;
    private javax.swing.JScrollPane danhSachPhongBan;
    private javax.swing.JButton deleteButton2;
    private javax.swing.JButton editButton2;
    private javax.swing.JTextField maPhongBanField;
    private javax.swing.JPanel menuPhongBan;
    private javax.swing.JButton newButton2;
    private javax.swing.JTable phongBanTable;
    private javax.swing.JTextField tenPhongBanField;
    private javax.swing.JButton updateButton2;
    // End of variables declaration//GEN-END:variables
}
