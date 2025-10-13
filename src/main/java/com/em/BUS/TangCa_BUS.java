package com.em.BUS;

import com.em.DAO.TangCa_DAO;
import com.em.DTO.TangCa_DTO;
import java.util.ArrayList;

public class TangCa_BUS{
     private TangCa_DAO tangCa_DAO = new TangCa_DAO();
    
    public boolean AddTangCa(TangCa_DTO tangCa){     
        return(tangCa_DAO.AddTangCa(tangCa));
    }
    
    public boolean EditTangCa(TangCa_DTO tangCa) {
        return tangCa_DAO.EditTangCa(tangCa);
    }
    
    public boolean DeleteTangCa(int maTangCa) {
        return tangCa_DAO.DeleteTangCa(maTangCa);
    }
    
    public ArrayList<TangCa_DTO> GetAllTangCa() {
        return tangCa_DAO.GetAllTangCa();
    }
    
    public TangCa_DTO GetTangCaByID(int maTangCa) {
        return tangCa_DAO.GetTangCaByID(maTangCa);
    } 
}
