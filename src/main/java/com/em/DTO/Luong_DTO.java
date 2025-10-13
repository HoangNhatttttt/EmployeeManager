package com.em.DTO;

import java.sql.Date;

public class Luong_DTO{
    private int maLuong, maNhanVien, luongCoBan, soGioCoban;
    private Date ngayNhanLuong;
    
    public Luong_DTO() { }
    
    public Luong_DTO(int maNhanVien, int luongCoBan, int soGioCoBan, Date ngayNhanLuong){
        this.maNhanVien = maNhanVien;
        this.luongCoBan = luongCoBan;
        this.soGioCoban = soGioCoBan;
    }
    
    public Luong_DTO(int maLuong, int maNhanVien, int luongCoBan, int soGioCoBan, Date ngayNhanLuong){
        this.maLuong = maLuong;
        this.maNhanVien = maNhanVien;
        this.luongCoBan = luongCoBan;
        this.soGioCoban = soGioCoBan;
    }
    
    public void setMaLuong(int maLuong){ this.maLuong = maLuong; } 
    public void setMaNhanVien(int maNhanVien){ this.maNhanVien = maNhanVien; }   
    public void setLuongCoBan(int luongCoBan){ this.luongCoBan = luongCoBan; }
    public void setSoGioCoBan(int soGioCoBan){ this.soGioCoban = soGioCoBan; }
    public void setNgayNhanLuong(Date ngayNhanLuong){ this.ngayNhanLuong = ngayNhanLuong; }
    
    public int getMaLuong(){ return maLuong; } 
    public int getMaNhanVien(){ return maNhanVien; }   
    public int getLuongCoBan(){ return luongCoBan; }
    public int getSoGioCoBan(){ return soGioCoban; }
    public Date getNgayNhanLuong(){ return ngayNhanLuong; }
   
    public void OutputLuong(){
        System.out.println("Mã lương: " + maLuong);
        System.out.println("Mã nhân viên: " + maNhanVien);
        System.out.println("Lương cơ bản: " + luongCoBan);
        System.out.println("Số giờ cơ bản: " + soGioCoban);
        System.out.println("Ngày nhận lương: " + ngayNhanLuong);     
    }
}
