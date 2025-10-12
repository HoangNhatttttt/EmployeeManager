package com.em.DTO;

import java.util.Date;


public class NhanVien_DTO {
    private int maNhanVien, maPhongBan, maChucVu;
    private String hoTen, soDienThoai, diaChi, trangThai, gioiTinh;
    private Date ngaySinh;
    
    // Constructer rỗng
    public NhanVien_DTO(){ }
    
    // Constructer dùng để thêm Eployee, không có ID, ID quản lý tự động
    public NhanVien_DTO(String hoTen, Date ngaySinh, String gioiTinh, String diaChi, String soDienThoai){
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.trangThai = "Yes";
    }
    
    // Constructer dùng để thêm Eployee, không có ID, ID quản lý tự động
    public NhanVien_DTO(String hoTen, Date ngaySinh, String gioiTinh, String diaChi, String soDienThoai, int maPhongBan, int maChucVu, String trangThai){
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.maPhongBan = maPhongBan;
        this.maChucVu = maChucVu;
        this.trangThai = trangThai;
    }
    
    // Constructer dùng để lấy thông tin từ database, có ID
    public NhanVien_DTO(int maNhanVien, String hoTen, Date ngaySinh, String gioiTinh, String diaChi, String soDienThoai, int maPhongBan, int maChucVu, String trangThai){
        this.maNhanVien = maNhanVien;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.maPhongBan = maPhongBan;
        this.maChucVu = maChucVu;
        this.trangThai = trangThai;
    }
    
    //Setter
    public void setMaNhanVien(int maNhanVien){ this.maNhanVien = maNhanVien; }
    public void setMaPhongBan(int maPhongBan){ this.maPhongBan = maPhongBan; }
    public void setMaChucVu(int maChucVu){ this.maChucVu = maChucVu; }
    public void setHoTen(String hoTen){ this.hoTen = hoTen; }
    public void setSoDienThoai(String soDienThoai){ this.soDienThoai = soDienThoai; }
    public void setDiaChi(String diaChi){ this.diaChi = diaChi; }
    public void setGioiTinh(String gioiTinh){ this.gioiTinh = gioiTinh; }
    public void setNgaySinh(Date ngaySinh){ this.ngaySinh = ngaySinh; }
    public void setTrangThai(String trangThai){ this.trangThai = trangThai; }
    
    //Getter
    public int getMaNhanVien(){ return maNhanVien; }
    public int getMaPhongBan(){ return maPhongBan; }
    public int getMaChucVu(){ return maChucVu; }
    public String getHoTen(){ return hoTen; }
    public String getSoDienThoai(){ return soDienThoai; }
    public String getDiaChi(){ return diaChi; }
    public String getGioiTinh(){ return gioiTinh; }
    public Date getNgaySinh(){ return ngaySinh; }
    public String getTrangThai(){ return trangThai; }
    
    public void OutputNhanVien(){
        System.out.println("Mã nhân viên: " + maNhanVien);
        System.out.println("Họ tên: " + hoTen);
        System.out.println("Ngày sinh: " + ngaySinh); // YYYY/MM/DD
        System.out.println("Giới tính: " + gioiTinh);
        System.out.println("Địa chỉ: " + diaChi);
        System.out.println("Số điện thoại: " + soDienThoai);
        System.out.println("Mã phòng ban: " + maPhongBan);
        System.out.println("Mã chức vụ: " + maChucVu);
        System.out.println("Trạng thái: " + trangThai);
    }
}
