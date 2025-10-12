package com.em.BUS;

import com.em.DAO.PhongBan_DAO;
import com.em.DTO.PhongBan_DTO;
import java.util.ArrayList;

public class HopDong_BUS{
    
    private PhongBan_DAO phongBan_DAO = new PhongBan_DAO();
    
    public boolean AddPhongBan(PhongBan_DTO phongBan){     
        return(phongBan_DAO.AddPhongBan(phongBan));
    }
    
    public boolean EditPhongBan(PhongBan_DTO phongBan) {
        return phongBan_DAO.EditPhongBan(phongBan);
    }
    
    public boolean DeletePhongBan(int maPhongBan) {
        return phongBan_DAO.DeletePhongBan(maPhongBan);
    }
    
    public ArrayList<PhongBan_DTO> GetAllPhongBan() {
        return phongBan_DAO.GetAllPhongBan();
    }
    
    public PhongBan_DTO GetPhongBanByID(int maNhanVien) {
        return phongBan_DAO.GetPhongBanByID(maNhanVien);
    }
}
