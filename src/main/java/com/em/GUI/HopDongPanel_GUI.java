
package com.em.GUI;

import com.em.BUS.HopDong_BUS;
import com.em.BUS.NhanVien_BUS;
import com.em.BUS.Validates_BUS;
import com.em.DTO.HopDong_DTO;
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

public class HopDongPanel_GUI extends javax.swing.JPanel{


    public HopDongPanel_GUI(){
        initComponents();
        
        InitHopDongTable();
        UpdateHopDongTable();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bangHopDong = new javax.swing.JPanel();
        JLabel15 = new javax.swing.JLabel();
        JLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        maHopDongField = new javax.swing.JTextField();
        maNhanVienBox1 = new javax.swing.JComboBox<>();
        ngayBatDauChooser = new com.toedter.calendar.JDateChooser();
        ngayKetThucChooser = new com.toedter.calendar.JDateChooser();
        tenNhanVienField1 = new javax.swing.JTextField();
        danhSachHopDong = new javax.swing.JScrollPane();
        hopDongTable = new javax.swing.JTable();
        menuHopDong = new javax.swing.JPanel();
        addButton4 = new javax.swing.JButton();
        deleteButton4 = new javax.swing.JButton();
        updateButton4 = new javax.swing.JButton();
        newButton4 = new javax.swing.JButton();
        editButton4 = new javax.swing.JButton();

        bangHopDong.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        JLabel15.setText("Mã hợp đồng");

        JLabel16.setText("Mã nhân viên");

        jLabel17.setText("Ngày bắt đầu");

        jLabel18.setText("Ngày kết thúc");

        jLabel19.setText("Tên nhân viên");

        maHopDongField.setEditable(false);

        maNhanVienBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        maNhanVienBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateTenMaNhanVienBox1(evt);
            }
        });

        ngayBatDauChooser.setPreferredSize(new java.awt.Dimension(100, 28));

        ngayKetThucChooser.setPreferredSize(new java.awt.Dimension(100, 28));

        tenNhanVienField1.setEditable(false);

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
                .addGroup(bangHopDongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(maHopDongField, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(bangHopDongLayout.createSequentialGroup()
                        .addComponent(maNhanVienBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(jLabel19)
                        .addGap(33, 33, 33)
                        .addComponent(tenNhanVienField1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bangHopDongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(ngayKetThucChooser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                        .addComponent(ngayBatDauChooser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(108, Short.MAX_VALUE))
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
                    .addComponent(maNhanVienBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(tenNhanVienField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(danhSachHopDong, javax.swing.GroupLayout.PREFERRED_SIZE, 1052, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bangHopDong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(menuHopDong, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(314, 314, 314))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bangHopDong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menuHopDong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(danhSachHopDong, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private DefaultTableModel defaultHopDongTableModel = new DefaultTableModel();
    public void InitHopDongTable(){
        
        hopDongTable.setModel(defaultHopDongTableModel);
        
        defaultHopDongTableModel.addColumn("Mã hợp đồng");
        defaultHopDongTableModel.addColumn("Mã nhân viên");
        defaultHopDongTableModel.addColumn("Ngày bắt đầu");
        defaultHopDongTableModel.addColumn("Ngày kết thúc");

        ListSelectionModel listSelectionModel = hopDongTable.getSelectionModel();
        listSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        listSelectionModel.addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e){
               
                int rowIndex = hopDongTable.getSelectedRow();
                if(rowIndex != -1){ 
                    String maHopDong = hopDongTable.getValueAt(rowIndex, 0).toString();
                    String maNhanVien = hopDongTable.getValueAt(rowIndex, 1).toString();
                    String ngayBatDau = hopDongTable.getValueAt(rowIndex, 2).toString();
                    String ngayKetThuc = hopDongTable.getValueAt(rowIndex, 3).toString();
                    
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    
                    try {
                        Date ngayBatDauFormat = dateFormat.parse(ngayBatDau);
                        Date ngayKetThucFormat = dateFormat.parse(ngayKetThuc);
                        
                        ngayBatDauChooser.setDateFormatString("dd/MM/yyyy");
                        ngayBatDauChooser.setDate(ngayBatDauFormat);
                        
                        ngayKetThucChooser.setDateFormatString("dd/MM/yyyy");
                        ngayKetThucChooser.setDate(ngayKetThucFormat);
                    }                    
                    catch (ParseException d) {
                        d.printStackTrace();               
                    }  
                    
                    maHopDongField.setText(maHopDong);
                    maNhanVienBox1.setSelectedItem(maNhanVien);  
                }
            }
        });
    } 
    private boolean UpdateHopDongTable(){
        try {
            HopDong_BUS hopDong_BUS = new HopDong_BUS();
            ArrayList<HopDong_DTO> hopDongList = hopDong_BUS.GetAllHopDong();
            
            defaultHopDongTableModel.setRowCount(0);            
            for (HopDong_DTO hopDong : hopDongList) {
                
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                
                String ngayBatDauFormatted = "";
                String ngayKetThucFormatted = "";
                ngayBatDauFormatted = dateFormat.format(hopDong.getNgayBatDau());
                ngayKetThucFormatted = dateFormat.format(hopDong.getNgayKetThuc());
                
                defaultHopDongTableModel.addRow(new Object[]{
                    hopDong.getMaHopDong(),
                    hopDong.getMaNhanVien(),
                    ngayBatDauFormatted,
                    ngayKetThucFormatted,
                });
            }
        }
        
        catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "Lỗi trích xuất thông tin hợp đồng: " + e.getMessage(),
                "Lỗi",
                JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            
            return false;
        }
        
        return true;
    }
    
    private void NewHopDong(){
        App_UI.ClearAllField(this);
    }

    private void AddHopDong() {                                                                             
        String maHopDong = maHopDongField.getText();
        if (maHopDong.isEmpty() == false){
            String error = "Bấm nút 'New' trước khi thêm hợp đồng.";
            JOptionPane.showMessageDialog(this, error, "Add hợp đồng", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Validates_BUS validate = new Validates_BUS();
        String result = validate.ValidateHopDong(maNhanVienBox1, ngayBatDauChooser, ngayKetThucChooser);
        
        HopDong_DTO hopDong = new HopDong_DTO();
        
        if(result == null)
            hopDong = validate.ReturnHopDong(maNhanVienBox1, ngayBatDauChooser, ngayKetThucChooser);
      
        else{
            JOptionPane.showMessageDialog(this, result, "Hợp đồng Validation", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        HopDong_BUS hopDong_BUS = new HopDong_BUS();
        
        if(hopDong_BUS.AddHopDong(hopDong) == true)
                JOptionPane.showMessageDialog(null, "Thêm hợp đồng thành công!");   
        else
           JOptionPane.showMessageDialog(null, "Thêm hợp đồng không thành công!"); 
        

        UpdateHopDongTable();
    }
    
    private void EditHopDong(){
        String maHopDong = maHopDongField.getText();
        if (maHopDong.isEmpty() == false){
            String error = "Bấm nút 'New' trước khi thêm hợp đồng.";
            JOptionPane.showMessageDialog(this, error, "Add hợp đồng", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Validates_BUS validate = new Validates_BUS();
        String result = validate.ValidateHopDong(maNhanVienBox1, ngayBatDauChooser, ngayKetThucChooser);
        
        HopDong_DTO hopDong = new HopDong_DTO();
        
        if(result == null)
            hopDong = validate.ReturnHopDong(maNhanVienBox1, ngayBatDauChooser, ngayKetThucChooser);
      
        else{
            JOptionPane.showMessageDialog(this, result, "Hợp đồng Validation", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        HopDong_BUS hopDong_BUS = new HopDong_BUS();
        
        if(hopDong_BUS.EditHopDong(hopDong) == true)
            JOptionPane.showMessageDialog(null, "Sửa hợp đồng thành công!");   
        else
           JOptionPane.showMessageDialog(null, "Sửa hợp đồng không thành công!"); 
        

        UpdateHopDongTable();
    }
    
    private void DeleteHopDong(){
        String maHopDong = maHopDongField.getText();
        if (maHopDong.isEmpty() == true){
            String error = "Chọn hợp đồng trong danh sách trước khi xoá";
            JOptionPane.showMessageDialog(this, error, "Delete hợp đồng", JOptionPane.WARNING_MESSAGE);
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
            HopDong_BUS hopDong_BUS = new HopDong_BUS();

            if (hopDong_BUS.DeleteHopDong(Integer.parseInt(maHopDong)) == true) {
                JOptionPane.showMessageDialog(this, 
                    "Xoá hợp đồng thành công.", 
                    "Thành công", 
                    JOptionPane.INFORMATION_MESSAGE);
                
                UpdateHopDongTable();
            } 
            
            else {
                JOptionPane.showMessageDialog(this, 
                    "Xoá hợp đồng thất bại.", 
                    "Lỗi", 
                    JOptionPane.ERROR_MESSAGE);
            }
        } 
        
        else {
            // User clicked NO or closed dialog - do nothing
            return;
        }
    }
    
    public void UpdateTenMaNhanVienBox1() {                                        
        NhanVien_BUS nhanVien_BUS = new NhanVien_BUS();
        ArrayList<NhanVien_DTO> nhanVienList = nhanVien_BUS.GetAllNhanVien();
    
        maNhanVienBox1.removeAllItems();
    
        for (NhanVien_DTO nhanVien : nhanVienList)
            maNhanVienBox1.addItem(Integer.toString(nhanVien.getMaNhanVien()));
        
        maNhanVienBox1.setSelectedIndex(-1);
        tenNhanVienField1.setText("");
    }
    
    private void UpdateTenMaNhanVienBox1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateTenMaNhanVienBox1
        if(maNhanVienBox1.getSelectedIndex() != -1){
            int selectedNhanVien = Integer.parseInt(maNhanVienBox1.getSelectedItem().toString());

            NhanVien_BUS nhanVien_BUS = new NhanVien_BUS();

            NhanVien_DTO nhanVien = new NhanVien_DTO();
            nhanVien = nhanVien_BUS.GetNhanVienById(selectedNhanVien);

            tenNhanVienField1.setText(nhanVien.getHoTen());
        }
    }//GEN-LAST:event_UpdateTenMaNhanVienBox1

    private void newButton4(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButton4
        NewHopDong();
    }//GEN-LAST:event_newButton4

    private void addButton4(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButton4
        AddHopDong();
    }//GEN-LAST:event_addButton4

    private void editButton4(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButton4
        EditHopDong();
    }//GEN-LAST:event_editButton4

    private void deleteButton4(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButton4
        DeleteHopDong();
    }//GEN-LAST:event_deleteButton4

    private void updateButton4(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButton4
        if(UpdateHopDongTable()){
            String text = "Update thành công";
            JOptionPane.showMessageDialog(this, text, "Update", JOptionPane.WIDTH);
        }
    }//GEN-LAST:event_updateButton4

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabel15;
    private javax.swing.JLabel JLabel16;
    private javax.swing.JButton addButton4;
    private javax.swing.JPanel bangHopDong;
    private javax.swing.JScrollPane danhSachHopDong;
    private javax.swing.JButton deleteButton4;
    private javax.swing.JButton editButton4;
    private javax.swing.JTable hopDongTable;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JTextField maHopDongField;
    private javax.swing.JComboBox<String> maNhanVienBox1;
    private javax.swing.JPanel menuHopDong;
    private javax.swing.JButton newButton4;
    private com.toedter.calendar.JDateChooser ngayBatDauChooser;
    private com.toedter.calendar.JDateChooser ngayKetThucChooser;
    private javax.swing.JTextField tenNhanVienField1;
    private javax.swing.JButton updateButton4;
    // End of variables declaration//GEN-END:variables
}
