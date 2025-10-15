
package com.em.GUI;

import com.em.BUS.NghiPhep_BUS;
import com.em.BUS.NhanVien_BUS;
import com.em.BUS.Validates_BUS;
import com.em.DTO.NghiPhep_DTO;
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

public class NghiPhepPanel_GUI extends javax.swing.JPanel{


    public NghiPhepPanel_GUI(){
        initComponents();
        
        InitNghiPhepTable();
        UpdateNghiPhepTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bangNghiPhep = new javax.swing.JPanel();
        JLabel23 = new javax.swing.JLabel();
        JLabel24 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        maNghiPhepField = new javax.swing.JTextField();
        maNhanVienBox5 = new javax.swing.JComboBox<>();
        ngayBatDauNghiChooser = new com.toedter.calendar.JDateChooser();
        ngayKetThucNghiChooser = new com.toedter.calendar.JDateChooser();
        tenNhanVienField5 = new javax.swing.JTextField();
        lyDoField = new javax.swing.JTextField();
        danhSachNghiPhep = new javax.swing.JScrollPane();
        nghiPhepTable = new javax.swing.JTable();
        menuNghiPhep = new javax.swing.JPanel();
        addButton8 = new javax.swing.JButton();
        deleteButton8 = new javax.swing.JButton();
        updateButton8 = new javax.swing.JButton();
        newButton8 = new javax.swing.JButton();
        editButton8 = new javax.swing.JButton();

        bangNghiPhep.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        JLabel23.setText("Mã nghỉ phép");

        JLabel24.setText("Mã nhân viên");

        jLabel30.setText("Ngày bắt đầu");

        jLabel31.setText("Ngày kết thúc");

        jLabel32.setText("Tên nhân viên");

        jLabel3.setText("Lý do nghỉ phép");

        maNghiPhepField.setEditable(false);

        maNhanVienBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        maNhanVienBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateTenMaNhanVienBox5(evt);
            }
        });

        ngayBatDauNghiChooser.setPreferredSize(new java.awt.Dimension(100, 28));

        ngayKetThucNghiChooser.setPreferredSize(new java.awt.Dimension(100, 28));

        tenNhanVienField5.setEditable(false);

        javax.swing.GroupLayout bangNghiPhepLayout = new javax.swing.GroupLayout(bangNghiPhep);
        bangNghiPhep.setLayout(bangNghiPhepLayout);
        bangNghiPhepLayout.setHorizontalGroup(
            bangNghiPhepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bangNghiPhepLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(bangNghiPhepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLabel24)
                    .addComponent(JLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30)
                    .addComponent(jLabel31)
                    .addComponent(jLabel3))
                .addGap(32, 32, 32)
                .addGroup(bangNghiPhepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(maNghiPhepField, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(bangNghiPhepLayout.createSequentialGroup()
                        .addComponent(maNhanVienBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(jLabel32)
                        .addGap(33, 33, 33)
                        .addComponent(tenNhanVienField5, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bangNghiPhepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lyDoField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(ngayKetThucNghiChooser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                        .addComponent(ngayBatDauNghiChooser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        bangNghiPhepLayout.setVerticalGroup(
            bangNghiPhepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bangNghiPhepLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(bangNghiPhepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLabel23)
                    .addComponent(maNghiPhepField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(bangNghiPhepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLabel24)
                    .addComponent(maNhanVienBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32)
                    .addComponent(tenNhanVienField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(bangNghiPhepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30)
                    .addComponent(ngayBatDauNghiChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(bangNghiPhepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31)
                    .addComponent(ngayKetThucNghiChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(bangNghiPhepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bangNghiPhepLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel3))
                    .addGroup(bangNghiPhepLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lyDoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(162, Short.MAX_VALUE))
        );

        nghiPhepTable.setModel(new javax.swing.table.DefaultTableModel(
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
        danhSachNghiPhep.setViewportView(nghiPhepTable);

        menuNghiPhep.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        addButton8.setText("Add");
        addButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButton8(evt);
            }
        });

        deleteButton8.setText("Delete");
        deleteButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButton8(evt);
            }
        });

        updateButton8.setText("Update");
        updateButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButton8(evt);
            }
        });

        newButton8.setText("New");
        newButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButton8(evt);
            }
        });

        editButton8.setText("Edit");
        editButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButton8(evt);
            }
        });

        javax.swing.GroupLayout menuNghiPhepLayout = new javax.swing.GroupLayout(menuNghiPhep);
        menuNghiPhep.setLayout(menuNghiPhepLayout);
        menuNghiPhepLayout.setHorizontalGroup(
            menuNghiPhepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuNghiPhepLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(menuNghiPhepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(newButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
            .addGroup(menuNghiPhepLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuNghiPhepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(updateButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menuNghiPhepLayout.setVerticalGroup(
            menuNghiPhepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuNghiPhepLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(newButton8)
                .addGap(57, 57, 57)
                .addComponent(addButton8)
                .addGap(18, 18, 18)
                .addComponent(editButton8)
                .addGap(18, 18, 18)
                .addComponent(deleteButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(updateButton8)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(danhSachNghiPhep, javax.swing.GroupLayout.PREFERRED_SIZE, 1052, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bangNghiPhep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(menuNghiPhep, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(314, 314, 314))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bangNghiPhep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menuNghiPhep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(danhSachNghiPhep, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private DefaultTableModel defaultNghiPhepTableModel = new DefaultTableModel();
    public void InitNghiPhepTable(){
        
        nghiPhepTable.setModel(defaultNghiPhepTableModel);
        
        defaultNghiPhepTableModel.addColumn("Mã hợp đồng");
        defaultNghiPhepTableModel.addColumn("Mã nhân viên");
        defaultNghiPhepTableModel.addColumn("Ngày bắt đầu");
        defaultNghiPhepTableModel.addColumn("Ngày kết thúc");
        defaultNghiPhepTableModel.addColumn("Lý do");

        ListSelectionModel listSelectionModel = nghiPhepTable.getSelectionModel();
        listSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        listSelectionModel.addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e){
               
                int rowIndex = nghiPhepTable.getSelectedRow();
                if(rowIndex != -1){ 
                    String maNghiPhep = nghiPhepTable.getValueAt(rowIndex, 0).toString();
                    String maNhanVien = nghiPhepTable.getValueAt(rowIndex, 1).toString();
                    String ngayBatDau = nghiPhepTable.getValueAt(rowIndex, 2).toString();
                    String ngayKetThuc = nghiPhepTable.getValueAt(rowIndex, 3).toString();
                    String lyDo = nghiPhepTable.getValueAt(rowIndex, 4).toString();
                    
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    
                    try {
                        Date ngayBatDauNghiFormat = dateFormat.parse(ngayBatDau);
                        Date ngayKetThucNghiFormat = dateFormat.parse(ngayKetThuc);
                        
                        ngayBatDauNghiChooser.setDateFormatString("dd/MM/yyyy");
                        ngayBatDauNghiChooser.setDate(ngayBatDauNghiFormat);
                        
                        ngayKetThucNghiChooser.setDateFormatString("dd/MM/yyyy");
                        ngayKetThucNghiChooser.setDate(ngayKetThucNghiFormat);
                    }                    
                    catch (ParseException d) {
                        d.printStackTrace();               
                    }  
                    
                    maNghiPhepField.setText(maNghiPhep);
                    maNhanVienBox5.setSelectedItem(maNhanVien);
                    lyDoField.setText(lyDo);
                }
            }
        });
    } 
    private boolean UpdateNghiPhepTable(){
        try {
            NghiPhep_BUS nghiPhep_BUS = new NghiPhep_BUS();
            ArrayList<NghiPhep_DTO> nghiPhepList = nghiPhep_BUS.GetAllNghiPhep();
            
            defaultNghiPhepTableModel.setRowCount(0);            
            for (NghiPhep_DTO nghiPhep : nghiPhepList) {
                
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                
                String ngayBatDauFormatted = "";
                String ngayKetThucFormatted = "";
                ngayBatDauFormatted = dateFormat.format(nghiPhep.getNgayBatDau());
                ngayKetThucFormatted = dateFormat.format(nghiPhep.getNgayKetThuc());
                
                defaultNghiPhepTableModel.addRow(new Object[]{
                    nghiPhep.getMaNghiPhep(),
                    nghiPhep.getMaNhanVien(),
                    ngayBatDauFormatted,
                    ngayKetThucFormatted,
                    nghiPhep.getLyDo(),                 
                });
            }
        }
        
        catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "Lỗi trích xuất thông tin nghỉ phép: " + e.getMessage(),
                "Lỗi",
                JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            
            return false;
        }
        
        return true;
    }
    
    private void NewNghiPhep(){
        App_UI.ClearAllField(this);
    }

    private void AddNghiPhep() {                                                                             
        String maNghiPhep = maNghiPhepField.getText();
        if (maNghiPhep.isEmpty() == false){
            String error = "Bấm nút 'New' trước khi thêm nghỉ phép.";
            JOptionPane.showMessageDialog(this, error, "Add nghỉ phép", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Validates_BUS validate = new Validates_BUS();
        String result = validate.ValidateNghiPhep(maNhanVienBox5, ngayBatDauNghiChooser, ngayKetThucNghiChooser, lyDoField);
        
        NghiPhep_DTO nghiPhep = new NghiPhep_DTO();
        
        if(result == null)
            nghiPhep = validate.ReturnNghiPhep(maNhanVienBox5, ngayBatDauNghiChooser, ngayKetThucNghiChooser, lyDoField);
      
        else{
            JOptionPane.showMessageDialog(this, result, "Nghỉ phép Validation", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        NghiPhep_BUS nghiPhep_BUS = new NghiPhep_BUS();
        
        if(nghiPhep_BUS.AddNghiPhep(nghiPhep) == true)
                JOptionPane.showMessageDialog(null, "Thêm nghỉ phép thành công!");   
        else
           JOptionPane.showMessageDialog(null, "Thêm nghỉ phép không thành công!"); 
        

        UpdateNghiPhepTable();
    }
    
    private void EditNghiPhep(){
        String maNghiPhep = maNghiPhepField.getText();
        if (maNghiPhep.isEmpty() == false){
            String error = "Bấm nút 'New' trước khi thêm nghỉ phép.";
            JOptionPane.showMessageDialog(this, error, "Add nghỉ phép", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Validates_BUS validate = new Validates_BUS();
        String result = validate.ValidateNghiPhep(maNhanVienBox5, ngayBatDauNghiChooser, ngayKetThucNghiChooser, lyDoField);
        
        NghiPhep_DTO nghiPhep = new NghiPhep_DTO();
        
        if(result == null)
            nghiPhep = validate.ReturnNghiPhep(maNhanVienBox5, ngayBatDauNghiChooser, ngayKetThucNghiChooser, lyDoField);
      
        else{
            JOptionPane.showMessageDialog(this, result, "Hợp đồng Validation", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        NghiPhep_BUS nghiPhep_BUS = new NghiPhep_BUS();
        
        if(nghiPhep_BUS.EditNghiPhep(nghiPhep) == true)
            JOptionPane.showMessageDialog(null, "Sửa nghỉ phép thành công!");   
        else
           JOptionPane.showMessageDialog(null, "Sửa nghỉ phép không thành công!"); 
        

        UpdateNghiPhepTable();
    }
    
    private void DeleteNghiPhep(){
        String maNghiPhep = maNghiPhepField.getText();
        if (maNghiPhep.isEmpty() == true){
            String error = "Chọn nghỉ phép trong danh sách trước khi xoá";
            JOptionPane.showMessageDialog(this, error, "Delete nghỉ phép", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Show confirmation dialog
        int confirm = JOptionPane.showConfirmDialog(
            this,
            "Bạn có chắc muốn xoá nghỉ phép ?",
            "Xác nhận xoá",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE
        );
    
        if (confirm == JOptionPane.YES_OPTION) {
            // User clicked YES - proceed with deletion
            NghiPhep_BUS nghiPhep_BUS = new NghiPhep_BUS();

            if (nghiPhep_BUS.DeleteNghiPhep(Integer.parseInt(maNghiPhep)) == true) {
                JOptionPane.showMessageDialog(this, 
                    "Xoá nghỉ phép thành công.", 
                    "Thành công", 
                    JOptionPane.INFORMATION_MESSAGE);
                
                UpdateNghiPhepTable();
            } 
            
            else {
                JOptionPane.showMessageDialog(this, 
                    "Xoá nghỉ phép thất bại.", 
                    "Lỗi", 
                    JOptionPane.ERROR_MESSAGE);
            }
        } 
        
        else {
            // User clicked NO or closed dialog - do nothing
            return;
        }
    }
    
    public void UpdateTenMaNhanVienBox5() {                                                      
        NhanVien_BUS nhanVien_BUS = new NhanVien_BUS();
        ArrayList<NhanVien_DTO> nhanVienList = nhanVien_BUS.GetAllNhanVien();
    
        maNhanVienBox5.removeAllItems();
    
        for (NhanVien_DTO nhanVien : nhanVienList)
            maNhanVienBox5.addItem(Integer.toString(nhanVien.getMaNhanVien()));
        
        maNhanVienBox5.setSelectedIndex(-1);
        tenNhanVienField5.setText("");
    }
    
    private void UpdateTenMaNhanVienBox5(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateTenMaNhanVienBox5
        if(maNhanVienBox5.getSelectedIndex() != -1){
            int selectedNhanVien = Integer.parseInt(maNhanVienBox5.getSelectedItem().toString());

            NhanVien_BUS nhanVien_BUS = new NhanVien_BUS();

            NhanVien_DTO nhanVien = new NhanVien_DTO();
            nhanVien = nhanVien_BUS.GetNhanVienById(selectedNhanVien);

            tenNhanVienField5.setText(nhanVien.getHoTen());
        }
    }//GEN-LAST:event_UpdateTenMaNhanVienBox5

    private void newButton8(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButton8
        NewNghiPhep();
    }//GEN-LAST:event_newButton8

    private void addButton8(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButton8
        AddNghiPhep();
    }//GEN-LAST:event_addButton8

    private void editButton8(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButton8
        EditNghiPhep();
    }//GEN-LAST:event_editButton8

    private void deleteButton8(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButton8
        DeleteNghiPhep();
    }//GEN-LAST:event_deleteButton8

    private void updateButton8(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButton8
        if(UpdateNghiPhepTable()){
            String text = "Update thành công";
            JOptionPane.showMessageDialog(this, text, "Update", JOptionPane.WIDTH);
        }
    }//GEN-LAST:event_updateButton8

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabel23;
    private javax.swing.JLabel JLabel24;
    private javax.swing.JButton addButton8;
    private javax.swing.JPanel bangNghiPhep;
    private javax.swing.JScrollPane danhSachNghiPhep;
    private javax.swing.JButton deleteButton8;
    private javax.swing.JButton editButton8;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JTextField lyDoField;
    private javax.swing.JTextField maNghiPhepField;
    private javax.swing.JComboBox<String> maNhanVienBox5;
    private javax.swing.JPanel menuNghiPhep;
    private javax.swing.JButton newButton8;
    private com.toedter.calendar.JDateChooser ngayBatDauNghiChooser;
    private com.toedter.calendar.JDateChooser ngayKetThucNghiChooser;
    private javax.swing.JTable nghiPhepTable;
    private javax.swing.JTextField tenNhanVienField5;
    private javax.swing.JButton updateButton8;
    // End of variables declaration//GEN-END:variables
}
