package com.em.BUS;

import com.em.DAO.Luong_DAO;
import com.em.DTO.Luong_DTO;
import java.util.ArrayList;

public class Luong_BUS{
    private Luong_DAO Luong_DAO = new Luong_DAO();
    
    public boolean AddLuong(Luong_DTO luong){     
        return(Luong_DAO.AddLuong(luong));
    }
    
    public boolean EditLuong(Luong_DTO luong) {
        return Luong_DAO.EditLuong(luong);
    }
    
    public boolean DeleteLuong(int maLuong) {
        return Luong_DAO.DeleteLuong(maLuong);
    }
    
    public ArrayList<Luong_DTO> GetAllLuong() {
        return Luong_DAO.GetAllLuong();
    }
    
    public Luong_DTO GetLuongByID(int maLuong) {
        return Luong_DAO.GetLuongByID(maLuong);
    } 
}
