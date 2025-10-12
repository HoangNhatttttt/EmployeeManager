
package com.em.BUS;

import com.em.DAO.ChucVu_DAO;
import com.em.DTO.ChucVu_DTO;
import java.util.ArrayList;

public class ChucVu_BUS{
    private ChucVu_DAO chucVu_DAO = new ChucVu_DAO();
    
    public boolean AddChucVu(ChucVu_DTO chucVu){     
        return(chucVu_DAO.AddChucVu(chucVu));
    }
    
    public boolean EditChucVu(ChucVu_DTO chucVu) {
        return chucVu_DAO.EditChucVu(chucVu);
    }
    
    public boolean DeleteChucVu(int maChucVu) {
        return chucVu_DAO.DeleteChucVu(maChucVu);
    }
    
    public ArrayList<ChucVu_DTO> GetAllChucVu() {
        return chucVu_DAO.GetAllChucVu();
    }
    
    public ChucVu_DTO GetChucVuByID(int maChucVu) {
        return chucVu_DAO.GetChucVuByID(maChucVu);
    }
}
