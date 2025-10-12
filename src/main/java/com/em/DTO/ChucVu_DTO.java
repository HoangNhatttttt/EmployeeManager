package com.em.DTO;

public class ChucVu_DTO{

    private int maChucVu;
    private String tenChucVu;
    
    public ChucVu_DTO() { }
    
    public ChucVu_DTO(String tenChucVu){
        this.tenChucVu = tenChucVu;
    }
    
    public ChucVu_DTO(int maChucVu, String tenChucVu){
        this.maChucVu = maChucVu;
        this.tenChucVu = tenChucVu;
    }
    
    public void setMaChucVu(int maChucVu){ this.maChucVu = maChucVu; } 
    public void setTenChucVu(String tenChucVu){ this.tenChucVu = tenChucVu; }   
    
    public int getMaChucVu(){ return maChucVu; } 
    public String getTenChucVu(){ return tenChucVu; }   
   
    public void OutputChucVu(){
        System.out.println("Mã chức vụ: " + maChucVu);
        System.out.println("Tên chức vụ: " + tenChucVu);
    }
}


