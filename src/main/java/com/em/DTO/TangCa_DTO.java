
package com.em.DTO;

import java.sql.Date;

public class TangCa_DTO{
    private int maTangCa, maNhanVien, luongTangCa, soGioTangCa;
    private Date ngayTangCa;
    
    public TangCa_DTO() { }
    
    public TangCa_DTO(int maNhanVien, int luongCoBan, int soGioCoBan, Date ngayTangCa){
        this.maNhanVien = maNhanVien;
        this.luongTangCa = luongCoBan;
        this.soGioTangCa = soGioCoBan;
        this.ngayTangCa = ngayTangCa;
    }
    
    public TangCa_DTO(int maTangCa, int maNhanVien, int luongCoBan, int soGioCoBan, Date ngayTangCa){
        this.maTangCa = maTangCa;
        this.maNhanVien = maNhanVien;
        this.luongTangCa = luongCoBan;
        this.soGioTangCa = soGioCoBan;
        this.ngayTangCa = ngayTangCa;
    }
    
    public void setMaTangCa(int maTangCa){ this.maTangCa = maTangCa; } 
    public void setMaNhanVien(int maNhanVien){ this.maNhanVien = maNhanVien; }   
    public void setLuongTangCa(int luongTangCa){ this.luongTangCa = luongTangCa; }
    public void setSoGioTangCa(int soGioTangCa){ this.soGioTangCa = soGioTangCa; }
    public void setNgayTangCa(Date ngayTangCa){ this.ngayTangCa = ngayTangCa; }
    
    public int getMaTangCa(){ return maTangCa; } 
    public int getMaNhanVien(){ return maNhanVien; }   
    public int getLuongTangCa(){ return luongTangCa; }
    public int getSoGioTangCa(){ return soGioTangCa; }
    public Date getNgayTangCa(){ return ngayTangCa; }
   
    public void OutputTangCa(){
        System.out.println("Mã tăng ca: " + maTangCa);
        System.out.println("Mã nhân viên: " + maNhanVien);
        System.out.println("Lương tăng ca: " + luongTangCa);
        System.out.println("Số giờ tăng ca: " + soGioTangCa);
        System.out.println("Ngày tăng ca: " + ngayTangCa);     
    }
}
