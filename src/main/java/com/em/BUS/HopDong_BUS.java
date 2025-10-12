package com.em.BUS;

import com.em.DAO.HopDong_DAO;
import com.em.DTO.HopDong_DTO;
import java.util.ArrayList;

public class HopDong_BUS{
    
    private HopDong_DAO hopDong_DAO = new HopDong_DAO();
    
    public boolean AddHopDong(HopDong_DTO hopDong){     
        return(hopDong_DAO.AddHopDong(hopDong));
    }
    
    public boolean EditHopDong(HopDong_DTO hopDong) {
        return hopDong_DAO.EditHopDong(hopDong);
    }
    
    public boolean DeleteHopDong(int maHopDong) {
        return hopDong_DAO.DeleteHopDong(maHopDong);
    }
    
    public ArrayList<HopDong_DTO> GetAllHopDong() {
        return hopDong_DAO.GetAllHopDong();
    }
    
    public HopDong_DTO GetHopDongByID(int maNhanVien) {
        return hopDong_DAO.GetHopDongByID(maNhanVien);
    }
}
