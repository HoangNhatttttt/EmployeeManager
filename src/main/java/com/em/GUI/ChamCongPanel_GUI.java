
package com.em.GUI;

import com.em.BUS.ChamCong_BUS;
import com.em.BUS.NhanVien_BUS;
import com.em.BUS.Validates_BUS;
import com.em.DTO.ChamCong_DTO;
import com.em.DTO.NhanVien_DTO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerDateModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class ChamCongPanel_GUI extends javax.swing.JPanel{

    public ChamCongPanel_GUI(){
        initComponents();
        
        SpinnerDateModel thoiGianVaoModel = new SpinnerDateModel();
        thoiGianVaoSpinner.setModel(thoiGianVaoModel);
        JSpinner.DateEditor vaoEditor = new JSpinner.DateEditor(thoiGianVaoSpinner, "HH:mm:ss");
        thoiGianVaoSpinner.setEditor(vaoEditor);
    
        // Configure thoiGianRaSpinner for time input
        SpinnerDateModel thoiGianRaModel = new SpinnerDateModel();
        thoiGianRaSpinner.setModel(thoiGianRaModel);
        JSpinner.DateEditor raEditor = new JSpinner.DateEditor(thoiGianRaSpinner, "HH:mm:ss");
        thoiGianRaSpinner.setEditor(raEditor);
        
        InitChamCongTable();
        UpdateChamCongTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bangChamCong = new javax.swing.JPanel();
        JLabel19 = new javax.swing.JLabel();
        JLabel20 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        maChamCongField = new javax.swing.JTextField();
        maNhanVienBox3 = new javax.swing.JComboBox<>();
        ngayChamCongChooser = new com.toedter.calendar.JDateChooser();
        tenNhanVienField3 = new javax.swing.JTextField();
        thoiGianVaoSpinner = new javax.swing.JSpinner();
        thoiGianRaSpinner = new javax.swing.JSpinner();
        danhSachChamCong = new javax.swing.JScrollPane();
        chamCongTable = new javax.swing.JTable();
        menuChamCong = new javax.swing.JPanel();
        addButton6 = new javax.swing.JButton();
        deleteButton6 = new javax.swing.JButton();
        updateButton6 = new javax.swing.JButton();
        newButton6 = new javax.swing.JButton();
        editButton6 = new javax.swing.JButton();

        bangChamCong.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        JLabel19.setText("Mã chấm công");

        JLabel20.setText("Mã nhân viên");

        jLabel23.setText("Ngày chấm công");

        jLabel25.setText("Tên nhân viên");

        jLabel26.setText("Thời gian vào");

        jLabel27.setText("Thời gian ra");

        maChamCongField.setEditable(false);

        maNhanVienBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        maNhanVienBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateTenMaNhanVienBox3(evt);
            }
        });

        ngayChamCongChooser.setPreferredSize(new java.awt.Dimension(100, 28));

        tenNhanVienField3.setEditable(false);

        javax.swing.GroupLayout bangChamCongLayout = new javax.swing.GroupLayout(bangChamCong);
        bangChamCong.setLayout(bangChamCongLayout);
        bangChamCongLayout.setHorizontalGroup(
            bangChamCongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bangChamCongLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(bangChamCongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLabel20)
                    .addComponent(JLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27))
                .addGap(32, 32, 32)
                .addGroup(bangChamCongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(maChamCongField, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(bangChamCongLayout.createSequentialGroup()
                        .addComponent(maNhanVienBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(jLabel25)
                        .addGap(33, 33, 33)
                        .addComponent(tenNhanVienField3, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bangChamCongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(thoiGianRaSpinner, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(thoiGianVaoSpinner, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(ngayChamCongChooser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        bangChamCongLayout.setVerticalGroup(
            bangChamCongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bangChamCongLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(bangChamCongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLabel19)
                    .addComponent(maChamCongField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(bangChamCongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLabel20)
                    .addComponent(maNhanVienBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(tenNhanVienField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(bangChamCongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(ngayChamCongChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(bangChamCongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(thoiGianVaoSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(bangChamCongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(thoiGianRaSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(166, Short.MAX_VALUE))
        );

        chamCongTable.setModel(new javax.swing.table.DefaultTableModel(
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
        danhSachChamCong.setViewportView(chamCongTable);

        menuChamCong.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        addButton6.setText("Add");
        addButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButton6(evt);
            }
        });

        deleteButton6.setText("Delete");
        deleteButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButton6(evt);
            }
        });

        updateButton6.setText("Update");
        updateButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButton6(evt);
            }
        });

        newButton6.setText("New");
        newButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButton6(evt);
            }
        });

        editButton6.setText("Edit");
        editButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButton6(evt);
            }
        });

        javax.swing.GroupLayout menuChamCongLayout = new javax.swing.GroupLayout(menuChamCong);
        menuChamCong.setLayout(menuChamCongLayout);
        menuChamCongLayout.setHorizontalGroup(
            menuChamCongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuChamCongLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(menuChamCongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(newButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
            .addGroup(menuChamCongLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuChamCongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(updateButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menuChamCongLayout.setVerticalGroup(
            menuChamCongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuChamCongLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(newButton6)
                .addGap(57, 57, 57)
                .addComponent(addButton6)
                .addGap(18, 18, 18)
                .addComponent(editButton6)
                .addGap(18, 18, 18)
                .addComponent(deleteButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(updateButton6)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(danhSachChamCong, javax.swing.GroupLayout.PREFERRED_SIZE, 1052, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bangChamCong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(menuChamCong, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(314, 314, 314))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bangChamCong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menuChamCong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(danhSachChamCong, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private DefaultTableModel defaultChamCongTableModel = new DefaultTableModel();
    public void InitChamCongTable(){
        
        chamCongTable.setModel(defaultChamCongTableModel);
        
        defaultChamCongTableModel.addColumn("Mã chấm công");
        defaultChamCongTableModel.addColumn("Mã nhân viên");
        defaultChamCongTableModel.addColumn("Ngày chấm công");
        defaultChamCongTableModel.addColumn("Thời gian vào");
        defaultChamCongTableModel.addColumn("Thời gian ra");

        ListSelectionModel listSelectionModel = chamCongTable.getSelectionModel();
        listSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        listSelectionModel.addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e){
               
                int rowIndex = chamCongTable.getSelectedRow();
                if(rowIndex != -1){ 
                    String maChamCong = chamCongTable.getValueAt(rowIndex, 0).toString();
                    String maNhanVien = chamCongTable.getValueAt(rowIndex, 1).toString();
                    String ngayChamCong = chamCongTable.getValueAt(rowIndex, 2).toString();
                    String thoiGianVao = chamCongTable.getValueAt(rowIndex, 3).toString();
                    String thoiGianRa = chamCongTable.getValueAt(rowIndex, 4).toString();
                    
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    
                    try {
                        Date ngayChamCongFormat = dateFormat.parse(ngayChamCong);
                        
                        ngayChamCongChooser.setDateFormatString("dd/MM/yyyy");
                        ngayChamCongChooser.setDate(ngayChamCongFormat);
                        
                    }                    
                    catch (ParseException d) {
                        d.printStackTrace();               
                    }  
                    
                    maChamCongField.setText(maChamCong);
                    maNhanVienBox3.setSelectedItem(maNhanVien);
                    
                    java.sql.Time sqlThoiGianVao = java.sql.Time.valueOf(thoiGianVao);
                    java.sql.Time sqlThoiGianRa = java.sql.Time.valueOf(thoiGianRa);
                    
                    thoiGianVaoSpinner.setValue(sqlThoiGianVao);
                    thoiGianRaSpinner.setValue(sqlThoiGianRa);
                }
            }
        });
    } 
    private boolean UpdateChamCongTable(){
        try {
            ChamCong_BUS chamCong_BUS = new ChamCong_BUS();
            ArrayList<ChamCong_DTO> chamCongList = chamCong_BUS.GetAllChamCong();
            
            defaultChamCongTableModel.setRowCount(0);            
            for (ChamCong_DTO chamCong : chamCongList) {
                
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");            
                String ngayChamCongFormatted = "";
                ngayChamCongFormatted = dateFormat.format(chamCong.getNgayChamCong());

                SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
                
                java.sql.Time sqlThoiGianVao = chamCong.getThoiGianVao();
                java.sql.Time sqlThoiGianRa = chamCong.getThoiGianRa();
                
                String thoiGianVaoString = timeFormat.format(sqlThoiGianVao);
                String thoiGianRaString = timeFormat.format(sqlThoiGianRa);
                
                defaultChamCongTableModel.addRow(new Object[]{
                    chamCong.getMaChamCong(),
                    chamCong.getMaNhanVien(),
                    ngayChamCongFormatted,
                    thoiGianVaoString,
                    thoiGianRaString,
                });
            }
        }
        
        catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "Lỗi trích xuất thông tin chấm công: " + e.getMessage(),
                "Lỗi",
                JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            
            return false;
        }
        
        return true;
    }
    
    private void NewChamCong(){
        maNhanVienBox3.setSelectedIndex(-1);
        App_UI.ClearAllField(this);
    }

    private void AddChamCong() {                                                                             
        String maChamCong = maChamCongField.getText();
        if (maChamCong.isEmpty() == false){
            String error = "Bấm nút 'New' trước khi thêm chấm công.";
            JOptionPane.showMessageDialog(this, error, "Add chấm công", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Validates_BUS validate = new Validates_BUS();
        String result = validate.ValidateChamCong(maNhanVienBox3, ngayChamCongChooser, thoiGianVaoSpinner, thoiGianRaSpinner);
        
        ChamCong_DTO chamCong = new ChamCong_DTO();
        
        if(result == null)
            chamCong = validate.ReturnChamCong(maNhanVienBox3, ngayChamCongChooser, thoiGianVaoSpinner, thoiGianRaSpinner);
      
        else{
            JOptionPane.showMessageDialog(this, result, "Chấm công Validation", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        ChamCong_BUS chamCong_BUS = new ChamCong_BUS();
        
        if(chamCong_BUS.AddChamCong(chamCong) == true)
                JOptionPane.showMessageDialog(null, "Thêm chấm công thành công!");   
        else
           JOptionPane.showMessageDialog(null, "Thêm chấm công không thành công!"); 
        

        UpdateChamCongTable();
    }
    
    private void EditChamCong(){
        String maChamCong = maChamCongField.getText();
        if (maChamCong.isEmpty() == false){
            String error = "Bấm nút 'New' trước khi thêm chấm công.";
            JOptionPane.showMessageDialog(this, error, "Add chấm công", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Validates_BUS validate = new Validates_BUS();
        String result = validate.ValidateChamCong(maNhanVienBox3, ngayChamCongChooser, thoiGianVaoSpinner, thoiGianRaSpinner);
        
        ChamCong_DTO chamCong = new ChamCong_DTO();
        
        if(result == null)
            chamCong = validate.ReturnChamCong(maNhanVienBox3, ngayChamCongChooser, thoiGianVaoSpinner, thoiGianRaSpinner);
      
        else{
            JOptionPane.showMessageDialog(this, result, "Chấm công Validation", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        ChamCong_BUS chamCong_BUS = new ChamCong_BUS();
        
        if(chamCong_BUS.EditChamCong(chamCong) == true)
            JOptionPane.showMessageDialog(null, "Sửa chấm công thành công!");   
        else
           JOptionPane.showMessageDialog(null, "Sửa chấm công không thành công!"); 
        

        UpdateChamCongTable();
    }
    
    private void DeleteChamCong(){
        String maChamCong = maChamCongField.getText();
        if (maChamCong.isEmpty() == true){
            String error = "Chọn chấm công trong danh sách trước khi xoá";
            JOptionPane.showMessageDialog(this, error, "Delete hợp đồng", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Show confirmation dialog
        int confirm = JOptionPane.showConfirmDialog(
            this,
            "Bạn có chắc muốn xoá chấm công ?",
            "Xác nhận xoá",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE
        );
    
        if (confirm == JOptionPane.YES_OPTION) {
            // User clicked YES - proceed with deletion
            ChamCong_BUS chamCong_BUS = new ChamCong_BUS();

            if (chamCong_BUS.DeleteChamCong(Integer.parseInt(maChamCong)) == true) {
                JOptionPane.showMessageDialog(this, 
                    "Xoá chấm công thành công.", 
                    "Thành công", 
                    JOptionPane.INFORMATION_MESSAGE);
                
                UpdateChamCongTable();
            } 
            
            else {
                JOptionPane.showMessageDialog(this, 
                    "Xoá chấm công thất bại.", 
                    "Lỗi", 
                    JOptionPane.ERROR_MESSAGE);
            }
        } 
        
        else {
            // User clicked NO or closed dialog - do nothing
            return;
        }
    }
                
    public void UpdateTenMaNhanVienBox3() {                                         
        NhanVien_BUS nhanVien_BUS = new NhanVien_BUS();
        ArrayList<NhanVien_DTO> nhanVienList = nhanVien_BUS.GetAllNhanVien();
    
        maNhanVienBox3.removeAllItems();
    
        for (NhanVien_DTO nhanVien : nhanVienList)
            maNhanVienBox3.addItem(Integer.toString(nhanVien.getMaNhanVien()));
        
        maNhanVienBox3.setSelectedIndex(-1);
        tenNhanVienField3.setText("");
    }
    
    private void UpdateTenMaNhanVienBox3(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateTenMaNhanVienBox3
        if(maNhanVienBox3.getSelectedIndex() != -1){
            int selectedNhanVien = Integer.parseInt(maNhanVienBox3.getSelectedItem().toString());

            NhanVien_BUS nhanVien_BUS = new NhanVien_BUS();

            NhanVien_DTO nhanVien = new NhanVien_DTO();
            nhanVien = nhanVien_BUS.GetNhanVienById(selectedNhanVien);

            tenNhanVienField3.setText(nhanVien.getHoTen());
        }
    }//GEN-LAST:event_UpdateTenMaNhanVienBox3

    private void newButton6(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButton6
        NewChamCong();
    }//GEN-LAST:event_newButton6

    private void addButton6(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButton6
        AddChamCong();
    }//GEN-LAST:event_addButton6

    private void editButton6(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButton6
        EditChamCong();
    }//GEN-LAST:event_editButton6

    private void deleteButton6(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButton6
        DeleteChamCong();
    }//GEN-LAST:event_deleteButton6

    private void updateButton6(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButton6
        if(UpdateChamCongTable()){
            String text = "Update thành công";
            JOptionPane.showMessageDialog(this, text, "Update", JOptionPane.WIDTH);
        }
    }//GEN-LAST:event_updateButton6


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabel19;
    private javax.swing.JLabel JLabel20;
    private javax.swing.JButton addButton6;
    private javax.swing.JPanel bangChamCong;
    private javax.swing.JTable chamCongTable;
    private javax.swing.JScrollPane danhSachChamCong;
    private javax.swing.JButton deleteButton6;
    private javax.swing.JButton editButton6;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JTextField maChamCongField;
    private javax.swing.JComboBox<String> maNhanVienBox3;
    private javax.swing.JPanel menuChamCong;
    private javax.swing.JButton newButton6;
    private com.toedter.calendar.JDateChooser ngayChamCongChooser;
    private javax.swing.JTextField tenNhanVienField3;
    private javax.swing.JSpinner thoiGianRaSpinner;
    private javax.swing.JSpinner thoiGianVaoSpinner;
    private javax.swing.JButton updateButton6;
    // End of variables declaration//GEN-END:variables
}
