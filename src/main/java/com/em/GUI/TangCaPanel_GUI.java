
package com.em.GUI;

import com.em.BUS.NhanVien_BUS;
import com.em.BUS.TangCa_BUS;
import com.em.BUS.Validates_BUS;
import com.em.DTO.NhanVien_DTO;
import com.em.DTO.TangCa_DTO;
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

public class TangCaPanel_GUI extends javax.swing.JPanel{

    public TangCaPanel_GUI(){
        initComponents();
        
        InitTangCaTable();
        UpdateTangCaTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bangTangCa = new javax.swing.JPanel();
        JLabel21 = new javax.swing.JLabel();
        JLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        maTangCaField = new javax.swing.JTextField();
        maNhanVienBox4 = new javax.swing.JComboBox<>();
        tenNhanVienField4 = new javax.swing.JTextField();
        luongTangCaField = new javax.swing.JTextField();
        soGioTangCaField = new javax.swing.JTextField();
        ngayTangCaChooser = new com.toedter.calendar.JDateChooser();
        danhSachTangCa = new javax.swing.JScrollPane();
        tangCaTable = new javax.swing.JTable();
        menuTangCa = new javax.swing.JPanel();
        addButton7 = new javax.swing.JButton();
        deleteButton7 = new javax.swing.JButton();
        updateButton7 = new javax.swing.JButton();
        newButton7 = new javax.swing.JButton();
        editButton7 = new javax.swing.JButton();

        bangTangCa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        JLabel21.setText("Mã tăng ca");

        JLabel22.setText("Mã nhân viên");

        jLabel24.setText("Lương tăng ca");

        jLabel28.setText("Số giờ tăng ca");

        jLabel29.setText("Tên nhân viên");

        jLabel2.setText("Ngày tăng ca");

        maTangCaField.setEditable(false);

        maNhanVienBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        maNhanVienBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateTenMaNhanVienBox4(evt);
            }
        });

        tenNhanVienField4.setEditable(false);

        luongTangCaField.setPreferredSize(new java.awt.Dimension(81, 28));

        soGioTangCaField.setToolTipText("");
        soGioTangCaField.setPreferredSize(new java.awt.Dimension(81, 28));

        javax.swing.GroupLayout bangTangCaLayout = new javax.swing.GroupLayout(bangTangCa);
        bangTangCa.setLayout(bangTangCaLayout);
        bangTangCaLayout.setHorizontalGroup(
            bangTangCaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bangTangCaLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(bangTangCaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLabel22)
                    .addComponent(JLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel28)
                    .addComponent(jLabel2))
                .addGroup(bangTangCaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bangTangCaLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(bangTangCaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(maTangCaField, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(bangTangCaLayout.createSequentialGroup()
                                .addComponent(maNhanVienBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64)
                                .addComponent(jLabel29)
                                .addGap(33, 33, 33)
                                .addComponent(tenNhanVienField4, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(bangTangCaLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(bangTangCaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ngayTangCaChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(luongTangCaField, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                            .addComponent(soGioTangCaField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        bangTangCaLayout.setVerticalGroup(
            bangTangCaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bangTangCaLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(bangTangCaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLabel21)
                    .addComponent(maTangCaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(bangTangCaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLabel22)
                    .addComponent(maNhanVienBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29)
                    .addComponent(tenNhanVienField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(bangTangCaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(luongTangCaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(bangTangCaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(soGioTangCaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(bangTangCaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ngayTangCaChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(170, Short.MAX_VALUE))
        );

        tangCaTable.setModel(new javax.swing.table.DefaultTableModel(
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
        danhSachTangCa.setViewportView(tangCaTable);

        menuTangCa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        addButton7.setText("Add");
        addButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButton7(evt);
            }
        });

        deleteButton7.setText("Delete");
        deleteButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButton7(evt);
            }
        });

        updateButton7.setText("Update");
        updateButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButton7(evt);
            }
        });

        newButton7.setText("New");
        newButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButton7(evt);
            }
        });

        editButton7.setText("Edit");
        editButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButton7(evt);
            }
        });

        javax.swing.GroupLayout menuTangCaLayout = new javax.swing.GroupLayout(menuTangCa);
        menuTangCa.setLayout(menuTangCaLayout);
        menuTangCaLayout.setHorizontalGroup(
            menuTangCaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuTangCaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(menuTangCaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(newButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
            .addGroup(menuTangCaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuTangCaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(updateButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menuTangCaLayout.setVerticalGroup(
            menuTangCaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuTangCaLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(newButton7)
                .addGap(57, 57, 57)
                .addComponent(addButton7)
                .addGap(18, 18, 18)
                .addComponent(editButton7)
                .addGap(18, 18, 18)
                .addComponent(deleteButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(updateButton7)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(danhSachTangCa, javax.swing.GroupLayout.PREFERRED_SIZE, 1052, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bangTangCa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(menuTangCa, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(314, 314, 314))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bangTangCa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menuTangCa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(danhSachTangCa, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private DefaultTableModel defaultTangCaTableModel = new DefaultTableModel();
    public void InitTangCaTable(){
        
        tangCaTable.setModel(defaultTangCaTableModel);
        
        defaultTangCaTableModel.addColumn("Mã tăng ca");
        defaultTangCaTableModel.addColumn("Mã nhân viên");
        defaultTangCaTableModel.addColumn("Lương tăng ca");
        defaultTangCaTableModel.addColumn("Số giờ căng ca");
        defaultTangCaTableModel.addColumn("Ngày tăng ca");

        ListSelectionModel listSelectionModel = tangCaTable.getSelectionModel();
        listSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        listSelectionModel.addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e){
               
                int rowIndex = tangCaTable.getSelectedRow();
                if(rowIndex != -1){ 
                    String maTangCa = tangCaTable.getValueAt(rowIndex, 0).toString();
                    String maNhanVien = tangCaTable.getValueAt(rowIndex, 1).toString();
                    String luongTangCa = tangCaTable.getValueAt(rowIndex, 2).toString();
                    String soGioTangCa = tangCaTable.getValueAt(rowIndex, 3).toString();
                    String ngayTangCa = tangCaTable.getValueAt(rowIndex, 4).toString();
                    
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    
                    try {
                        Date ngayTangCaFormat = dateFormat.parse(ngayTangCa);
                        
                        ngayTangCaChooser.setDateFormatString("dd/MM/yyyy");
                        ngayTangCaChooser.setDate(ngayTangCaFormat);
                    }                    
                    catch (ParseException d) {
                        d.printStackTrace();               
                    }  
                        
                    maTangCaField.setText(maTangCa); 
                    luongTangCaField.setText(luongTangCa);
                    soGioTangCaField.setText(soGioTangCa);
                    maNhanVienBox4.setSelectedItem(maNhanVien);
                }
            }
        });
    } 
    private boolean UpdateTangCaTable(){
        try {
            TangCa_BUS tangCa_BUS = new TangCa_BUS();
            ArrayList<TangCa_DTO> tangCaList = tangCa_BUS.GetAllTangCa();
            
            defaultTangCaTableModel.setRowCount(0);            
            for (TangCa_DTO tangCa : tangCaList) {
                
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                
                String ngayTangCaFormat = "";
                ngayTangCaFormat = dateFormat.format(tangCa.getNgayTangCa());
                
                defaultTangCaTableModel.addRow(new Object[]{
                    tangCa.getMaTangCa(),
                    tangCa.getMaNhanVien(),
                    tangCa.getLuongTangCa(),
                    tangCa.getSoGioTangCa(),
                    ngayTangCaFormat,
                });
            }
        }
        
        catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "Lỗi trích xuất thông tin tăng ca: " + e.getMessage(),
                "Lỗi",
                JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            
            return false;
        }
        
        return true;
    }
    
    private void NewTangCa(){
        App_UI.ClearAllField(this);
    }

    private void AddTangCa() {                                                                             
        String maTangCa = maTangCaField.getText();
        if (maTangCa.isEmpty() == false){
            String error = "Bấm nút 'New' trước khi thêm tăng ca.";
            JOptionPane.showMessageDialog(this, error, "Add căng ca", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Validates_BUS validate = new Validates_BUS();
        String result = validate.ValidateTangCa(maNhanVienBox4, luongTangCaField, soGioTangCaField, ngayTangCaChooser);
        
        TangCa_DTO tangCa = new TangCa_DTO();
        
        if(result == null)
            tangCa = validate.ReturnTangCa(maNhanVienBox4, luongTangCaField, soGioTangCaField, ngayTangCaChooser);
      
        else{
            JOptionPane.showMessageDialog(this, result, "Tăng ca Validation", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        TangCa_BUS tangCa_BUS = new TangCa_BUS();
        
        if(tangCa_BUS.AddTangCa(tangCa) == true)
            JOptionPane.showMessageDialog(null, "Thêm tăng ca thành công!");   
        else
           JOptionPane.showMessageDialog(null, "Thêm tăng ca không thành công!"); 
        

        UpdateTangCaTable();
    }
    
    private void EditTangCa(){
        String maTangCa = maTangCaField.getText();
        if (maTangCa.isEmpty() == false){
            String error = "Bấm nút 'New' trước khi sửa tăng ca.";
            JOptionPane.showMessageDialog(this, error, "Edit căng ca", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Validates_BUS validate = new Validates_BUS();
        String result = validate.ValidateTangCa(maNhanVienBox4, luongTangCaField, soGioTangCaField, ngayTangCaChooser);
        
        TangCa_DTO tangCa = new TangCa_DTO();
        
        if(result == null)
            tangCa = validate.ReturnTangCa(maNhanVienBox4, luongTangCaField, soGioTangCaField, ngayTangCaChooser);
      
        else{
            JOptionPane.showMessageDialog(this, result, "Tăng ca Validation", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        TangCa_BUS tangCa_BUS = new TangCa_BUS();
        
        if(tangCa_BUS.EditTangCa(tangCa) == true)
            JOptionPane.showMessageDialog(null, "Sửa tăng ca thành công!");   
        else
           JOptionPane.showMessageDialog(null, "Sửa tăng ca không thành công!"); 
        

        UpdateTangCaTable();
    }
    
    private void DeleteTangCa(){
        String maTangCa = maTangCaField.getText();
        if (maTangCa.isEmpty() == true){
            String error = "Chọn tăng ca trong danh sách trước khi xoá";
            JOptionPane.showMessageDialog(this, error, "Delete tăng ca", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Show confirmation dialog
        int confirm = JOptionPane.showConfirmDialog(
            this,
            "Bạn có chắc muốn xoá tăng ca ?",
            "Xác nhận xoá",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE
        );
    
        if (confirm == JOptionPane.YES_OPTION) {
            // User clicked YES - proceed with deletion
            TangCa_BUS tangCa_BUS = new TangCa_BUS();

            if (tangCa_BUS.DeleteTangCa(Integer.parseInt(maTangCa)) == true) {
                JOptionPane.showMessageDialog(this, 
                    "Xoá tăng ca thành công.", 
                    "Thành công", 
                    JOptionPane.INFORMATION_MESSAGE);
                
                UpdateTangCaTable();
            } 
            
            else {
                JOptionPane.showMessageDialog(this, 
                    "Xoá tăng ca thất bại.", 
                    "Lỗi", 
                    JOptionPane.ERROR_MESSAGE);
            }
        } 
        
        else {
            // User clicked NO or closed dialog - do nothing
            return;
        }
    }
    
    public void UpdateTenMaNhanVienBox4() {                                                      
        NhanVien_BUS nhanVien_BUS = new NhanVien_BUS();
        ArrayList<NhanVien_DTO> nhanVienList = nhanVien_BUS.GetAllNhanVien();
    
        maNhanVienBox4.removeAllItems();
    
        for (NhanVien_DTO nhanVien : nhanVienList)
            maNhanVienBox4.addItem(Integer.toString(nhanVien.getMaNhanVien()));
        
        maNhanVienBox4.setSelectedIndex(-1);
        tenNhanVienField4.setText("");
    } 
    
    private void UpdateTenMaNhanVienBox4(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateTenMaNhanVienBox4
        if(maNhanVienBox4.getSelectedIndex() != -1){
            int selectedNhanVien = Integer.parseInt(maNhanVienBox4.getSelectedItem().toString());

            NhanVien_BUS nhanVien_BUS = new NhanVien_BUS();

            NhanVien_DTO nhanVien = new NhanVien_DTO();
            nhanVien = nhanVien_BUS.GetNhanVienById(selectedNhanVien);

            tenNhanVienField4.setText(nhanVien.getHoTen());
        }
    }//GEN-LAST:event_UpdateTenMaNhanVienBox4

    private void newButton7(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButton7
        NewTangCa();
    }//GEN-LAST:event_newButton7

    private void addButton7(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButton7
        AddTangCa();
    }//GEN-LAST:event_addButton7

    private void editButton7(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButton7
        EditTangCa();
    }//GEN-LAST:event_editButton7

    private void deleteButton7(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButton7
        DeleteTangCa();
    }//GEN-LAST:event_deleteButton7

    private void updateButton7(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButton7
        if(UpdateTangCaTable()){
            String text = "Update thành công";
            JOptionPane.showMessageDialog(this, text, "Update", JOptionPane.WIDTH);
        }
    }//GEN-LAST:event_updateButton7

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabel21;
    private javax.swing.JLabel JLabel22;
    private javax.swing.JButton addButton7;
    private javax.swing.JPanel bangTangCa;
    private javax.swing.JScrollPane danhSachTangCa;
    private javax.swing.JButton deleteButton7;
    private javax.swing.JButton editButton7;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JTextField luongTangCaField;
    private javax.swing.JComboBox<String> maNhanVienBox4;
    private javax.swing.JTextField maTangCaField;
    private javax.swing.JPanel menuTangCa;
    private javax.swing.JButton newButton7;
    private com.toedter.calendar.JDateChooser ngayTangCaChooser;
    private javax.swing.JTextField soGioTangCaField;
    private javax.swing.JTable tangCaTable;
    private javax.swing.JTextField tenNhanVienField4;
    private javax.swing.JButton updateButton7;
    // End of variables declaration//GEN-END:variables
}
