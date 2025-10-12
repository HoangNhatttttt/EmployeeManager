
package com.em.BUS;

import com.em.DAO.ChamCong_DAO;
import com.em.DTO.ChamCong_DTO;
import java.util.ArrayList;


public class ChamCong_BUS{

    
    private ChamCong_DAO chamCong_DAO = new ChamCong_DAO();
    
    public boolean AddChamCong(ChamCong_DTO chamCong){     
        return(chamCong_DAO.AddChamCong(chamCong));
    }
    
    public boolean EditChamCong(ChamCong_DTO chamCong) {
        return chamCong_DAO.EditChamCong(chamCong);
    }
    
    public boolean DeleteChamCong(int maChamCong) {
        return chamCong_DAO.DeleteChamCong(maChamCong);
    }
    
    public ArrayList<ChamCong_DTO> GetAllChamCong() {
        return chamCong_DAO.GetAllChamCong();
    }
    
    public ChamCong_DTO GetChamCongByID(int maNhanVien) {
        return chamCong_DAO.GetChamCongByID(maNhanVien);
    }

}
