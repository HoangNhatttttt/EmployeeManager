package com.em.DTO;

public class PhongBan_DTO{

    private int maPhongBan;
    private String tenPhongBan;
    
    public PhongBan_DTO() { }
    
    public PhongBan_DTO(String tenPhongBan){
        this.tenPhongBan = tenPhongBan;
    }
    
    public PhongBan_DTO(int maPhongBan, String tenPhongBan){
        this.maPhongBan = maPhongBan;
        this.tenPhongBan = tenPhongBan;
    }
    
    public void setMaPhongBan(int maPhongBan){ this.maPhongBan = maPhongBan; } 
    public void setTenPhongBan(String tenPhongBan){ this.tenPhongBan = tenPhongBan; }   
    
    public int getMaPhongBan(){ return maPhongBan; } 
    public String getTenPhongBan(){ return tenPhongBan; }   
   
    public void OutputPhongBan(){
        System.out.println("Mã phòng ban: " + maPhongBan);
        System.out.println("Tên phòng ban: " + tenPhongBan);
    }
}


