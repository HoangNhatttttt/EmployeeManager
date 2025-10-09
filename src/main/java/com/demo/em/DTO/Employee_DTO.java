package com.demo.em.DTO;

import java.sql.Date;


public class Employee_DTO {
    private int maNhanVien, maPhongBan, maChucVu, maHopDong;
    private String hoTen, soDienThoai, diaChi, trangThai;
    private char gioiTinh;
    private Date ngaySinh;
    
    // Constructer rỗng
    public Employee_DTO(){ }
    
    // Constructer dùng để thêm Eployee, không có ID, ID quản lý tự động
    public Employee_DTO(String hoTen, Date ngaySinh, char gioiTinh, String diaChi, String soDienThoai, int maPhongBan, int maChucVu, int maHopDong, String trangThai){
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.maPhongBan = maPhongBan;
        this.maChucVu = maChucVu;
        this.maHopDong = maHopDong;
    }
    
    // Constructer dùng để lấy thông tin từ database, có ID
    public Employee_DTO(int maNhanVien, String hoTen, Date ngaySinh, char gioiTinh, String diaChi, String soDienThoai, int maPhongBan, int maChucVu, int maHopDong, String trangThai){
        this.maNhanVien = maNhanVien;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.maPhongBan = maPhongBan;
        this.maChucVu = maChucVu;
        this.maHopDong = maHopDong;
    }
    
    //Setter
    public void setMaNhanVien(int maNhanVien){ this.maNhanVien = maNhanVien; }
    public void setMaPhongBan(int maPhongBan){ this.maPhongBan = maPhongBan; }
    public void setMaChucVu(int maChucVu){ this.maChucVu = maChucVu; }
    public void setMaHopDong(int maHopDong){ this.maHopDong = maHopDong; }
    public void setHoTen(String hoTen){ this.hoTen = hoTen; }
    public void setSoDienThoai(String soDienThoai){ this.soDienThoai = soDienThoai; }
    public void setDiaChi(String diaChi){ this.diaChi = diaChi; }
    public void setGioiTinh(char gioiTinh){ this.gioiTinh = gioiTinh; }
    public void setNgaySinh(Date ngaySinh){ this.ngaySinh = ngaySinh; }
    public void setTrangThai(String trangThai){ this.trangThai = trangThai; }
    
    //Getter
    public int getMaNhanVien(){ return this.maNhanVien; }
    public int getMaPhongBan(){ return this.maPhongBan; }
    public int getMaChucVu(){ return this.maChucVu; }
    public int getMaHopDong(){ return this.maHopDong; }
    public String getHoTen(){ return this.hoTen = hoTen; }
    public String getSoDienThoai(){ return this.soDienThoai; }
    public String getDiaChi(){ return this.diaChi; }
    public char getGioiTinh(){ return this.gioiTinh; }
    public Date getNgaySinh(){ return this.ngaySinh; }
    public String getTrangThai(){ return this.trangThai; }
    
    public void PrintInformation(){
        System.out.println("Mã nhân viên: " + maNhanVien);
        System.out.println("Họ tên: " + hoTen);
        System.out.println("Ngày sinh: " + ngaySinh);
        System.out.println("Giới tính: " + gioiTinh);
        System.out.println("Địa chỉ: " + diaChi);
        System.out.println("Số điện thoại: " + soDienThoai);
        System.out.println("Mã phòng ban: " + maPhongBan);
        System.out.println("Mã chức vụ: " + maChucVu);
        System.out.println("Mã hợp đồng: " + maHopDong);
        System.out.println("Trạng thái: " + trangThai);
    }
}
