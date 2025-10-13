
package com.em.DTO;

import java.sql.Time;
import java.sql.Date;

public class ChamCong_DTO{
    private int maChamCong, maNhanVien;
    private Date ngayChamCong;
    private Time thoiGianVao, thoiGianRa;
      
    public ChamCong_DTO() { }
    
    public ChamCong_DTO(int maNhanVien, Date ngayChamCong, Time thoiGianVao, Time thoiGianRa){
        this.maNhanVien = maNhanVien;
        this.ngayChamCong = ngayChamCong;
        this.thoiGianVao = thoiGianVao;
        this.thoiGianRa = thoiGianRa;
    }
    
    public ChamCong_DTO(int maChamCong, int maNhanVien, Date ngayChamCong, Time thoiGianVao, Time thoiGianRa){
        this.maNhanVien = maNhanVien;
        this.ngayChamCong = ngayChamCong;
        this.thoiGianVao = thoiGianVao;
        this.thoiGianRa = thoiGianRa;
    }
    
    public void setMaChamCong(int maChamCong){ this.maChamCong = maChamCong; } 
    public void setMaNhanVien(int maNhanVien){ this.maNhanVien = maNhanVien; }
    public void setNgayChamCong(Date ngayChamCong){ this.ngayChamCong = ngayChamCong; } 
    public void setThoiGianVao(Time thoiGianVao){ this.thoiGianVao = thoiGianVao; }
    public void setThoiGianRa(Time thoiGianRa){ this.thoiGianRa = thoiGianRa; } 
    
    public int getMaChamCong(){ return this.maChamCong; } 
    public int getMaNhanVien(){ return this.maNhanVien; }
    public Date getNgayChamCong(){ return this.ngayChamCong; } 
    public Time getThoiGianVao(){ return this.thoiGianVao; }
    public Time getThoiGianRa(){ return this.thoiGianRa; } 
    
    public void OutputChamCong(){
        System.out.println("Mã hợp đồng: " + maChamCong);
        System.out.println("Mã nhân viên: " + maNhanVien);
        System.out.println("Ngày chấm công: " + ngayChamCong);
        System.out.println("Thời gian vào: " + thoiGianVao);
        System.out.println("Thời gian ra: " + thoiGianRa);
    }
}
