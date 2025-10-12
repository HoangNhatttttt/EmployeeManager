package com.em.DTO;
import java.util.Date;

public class HopDong_DTO{

    private int maHopDong, maNhanVien;
    private Date ngayBatDau, ngayKetThuc;
    
    public HopDong_DTO() { }
    
    public HopDong_DTO(int maNhanVien, Date ngayBatDau, Date ngayKetThuc){
        this.maNhanVien = maNhanVien;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }
    
    public HopDong_DTO(int maHopDong, int maNhanVien, Date ngayBatDau, Date ngayKetThuc){
        this.maHopDong = maHopDong;
        this.maNhanVien = maNhanVien;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }
    
    public void setMaHopDong(int maHopDong){ this.maHopDong = maHopDong; } 
    public void setMaNhanVien(int maNhanVien){ this.maNhanVien = maNhanVien; }
    public void setNgayBatDau(Date ngayBatDau){ this.ngayBatDau = ngayBatDau; } 
    public void setNgayKetThuc(Date ngayKetThuc){ this.ngayKetThuc = ngayKetThuc; } 
    
    public int getMaHopDong(){ return maHopDong; } 
    public int getMaNhanVien(){ return maNhanVien; }
    public Date getNgayBatDau(){ return ngayBatDau; } 
    public Date getNgayKetThuc(){ return ngayKetThuc; } 
    
    public void OutputHopDong(){
        System.out.println("Mã hợp đồng: " + maHopDong);
        System.out.println("Mã nhân viên: " + maNhanVien);
        System.out.println("Ngày bắt đầu: " + ngayBatDau); // YYYY/MM/DD
        System.out.println("ngày kết thúc: " + ngayKetThuc); // YYYY/MM/DD
    }
}
