
package com.em.DTO;

import java.sql.Date;

public class NghiPhep_DTO{
    private int maNghiPhep, maNhanVien;
    private Date ngayBatDau, ngayKetThuc;
    private String lyDo;
    
    public NghiPhep_DTO() { }
    
    public NghiPhep_DTO(int maNhanVien, Date ngayBatDau, Date ngayKetThuc, String lyDo){
        this.maNhanVien = maNhanVien;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.lyDo = lyDo;
    }
    
    public NghiPhep_DTO(int maNghiPhep, int maNhanVien, Date ngayBatDau, Date ngayKetThuc, String lyDo){
        this.maNghiPhep = maNghiPhep;
        this.maNhanVien = maNhanVien;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.lyDo = lyDo;
    }
    
    public void setMaNghiPhep(int maNghiPhep){ this.maNghiPhep = maNghiPhep; } 
    public void setMaNhanVien(int maNhanVien){ this.maNhanVien = maNhanVien; }
    public void setNgayBatDau(Date ngayBatDau){ this.ngayBatDau = ngayBatDau; } 
    public void setNgayKetThuc(Date ngayKetThuc){ this.ngayKetThuc = ngayKetThuc; }
    public void setLyDo(String lyDo){ this.lyDo = lyDo; } 
    
    public int getMaNghiPhep(){ return maNghiPhep; } 
    public int getMaNhanVien(){ return maNhanVien; }
    public Date getNgayBatDau(){ return ngayBatDau; } 
    public Date getNgayKetThuc(){ return ngayKetThuc; }
    public String getLyDo(){ return lyDo; } 
    
    public void OutputNghiPhep(){
        System.out.println("Mã nghỉ phép: " + maNghiPhep);
        System.out.println("Mã nhân viên: " + maNhanVien);
        System.out.println("Ngày bắt đầu: " + ngayBatDau); // YYYY/MM/DD
        System.out.println("ngày kết thúc: " + ngayKetThuc); // YYYY/MM/DD
        System.out.println("Lý do: " + lyDo);
    }
}
