package com.em.GUI;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import com.em.GUI.*;


public class App_UI extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(App_UI.class.getName());
    
    NhanVienPanel_GUI nv = new NhanVienPanel_GUI();
    PhongBanPanel_GUI pb = new PhongBanPanel_GUI();
    ChucVuPanel_GUI cv = new ChucVuPanel_GUI();
    HopDongPanel_GUI hd = new HopDongPanel_GUI();
    LuongPanel_GUI l = new LuongPanel_GUI();
    ChamCongPanel_GUI c = new ChamCongPanel_GUI();
    TangCaPanel_GUI tc = new TangCaPanel_GUI();
    NghiPhepPanel_GUI np = new NghiPhepPanel_GUI();
    
    private CardLayout cardLayout;
    public App_UI() {
        
        initComponents();
        cardLayout = (CardLayout) cardPanel.getLayout();
        
        cardPanel.add(nv, "nhanVienCard");   
        cardPanel.add(pb, "phongBanCard");
        cardPanel.add(cv, "chucVuCard");
        cardPanel.add(hd, "hopDongCard");
        cardPanel.add(l, "luongCard");
        cardPanel.add(c, "chamCongCard");
        cardPanel.add(tc, "tangCaCard");
        cardPanel.add(np, "nghiPhepCard");           
    }
            
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gioiTinhButtonGroup = new javax.swing.ButtonGroup();
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
        menuButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LuongCardButton(evt);
            }
        });

        menuButton6.setText("Chấm công");
        menuButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChamCongCardButton(evt);
            }
        });

        menuButton7.setText("Tăng ca");
        menuButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TangCaCardButton(evt);
            }
        });

        menuButton8.setText("Nghỉ phép");
        menuButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NghiPhepCardButton(evt);
            }
        });

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
    private javax.swing.JPanel bangMenu;
    private javax.swing.JPanel cardPanel;
    private javax.swing.ButtonGroup gioiTinhButtonGroup;
    private javax.swing.JButton menuButton1;
    private javax.swing.JButton menuButton2;
    private javax.swing.JButton menuButton3;
    private javax.swing.JButton menuButton4;
    private javax.swing.JButton menuButton5;
    private javax.swing.JButton menuButton6;
    private javax.swing.JButton menuButton7;
    private javax.swing.JButton menuButton8;
    // End of variables declaration//GEN-END:variables

    public static void ClearAllField(Container container) {
        for (Component c : container.getComponents()) {
            if (c instanceof JTextField) {
                ((JTextField) c).setText("");
            }
            else if (c instanceof JDateChooser) {
                ((JDateChooser) c).setDate(null);
            }
            else if (c instanceof JComboBox) {
                ((JComboBox<?>) c).setSelectedIndex(-1);
            }
            
            else if (c instanceof JSpinner) {
                // Reset spinner value to current time if it's a time spinner
                if (((JSpinner) c).getModel() instanceof SpinnerDateModel) {
                    ((JSpinner) c).setValue(new java.util.Date());
                }
                
                // Skip recursion into spinner internals
                continue;
            }
            else if (c instanceof Container) {
                ClearAllField((Container) c);
            }
        }
    }
    
    
    private void NhanVienCardButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NhanVienCardButton
        nv.UpdateTenPhongBanBox();
        nv.UpdateTenChucVuBox();
   
        cardLayout.show(cardPanel, "nhanVienCard");
    }//GEN-LAST:event_NhanVienCardButton

    private void PhongBanCardButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PhongBanCardButton
        cardLayout.show(cardPanel, "phongBanCard");
    }//GEN-LAST:event_PhongBanCardButton
    private void ChucVuCardButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChucVuCardButton
        cardLayout.show(cardPanel, "chucVuCard");
    }//GEN-LAST:event_ChucVuCardButton

    private void HopDongCardButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HopDongCardButton
        hd.UpdateTenMaNhanVienBox1();
        
        cardLayout.show(cardPanel, "hopDongCard");   
    }//GEN-LAST:event_HopDongCardButton
 
    private void LuongCardButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LuongCardButton
        l.UpdateTenMaNhanVienBox2();
        
        cardLayout.show(cardPanel, "luongCard");
    }//GEN-LAST:event_LuongCardButton
    
    private void ChamCongCardButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChamCongCardButton
        c.UpdateTenMaNhanVienBox3();
        
        cardLayout.show(cardPanel, "chamCongCard");
    }//GEN-LAST:event_ChamCongCardButton
    
    private void TangCaCardButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TangCaCardButton
        tc.UpdateTenMaNhanVienBox4();
        
        cardLayout.show(cardPanel, "tangCaCard");      
    }//GEN-LAST:event_TangCaCardButton
    
    private void NghiPhepCardButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NghiPhepCardButton
        np.UpdateTenMaNhanVienBox5();
        
        cardLayout.show(cardPanel, "nghiPhepCard");   
    }//GEN-LAST:event_NghiPhepCardButton

}
