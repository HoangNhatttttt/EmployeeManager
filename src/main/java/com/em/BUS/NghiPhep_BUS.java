package com.em.BUS;

import com.em.DAO.NghiPhep_DAO;
import com.em.DTO.NghiPhep_DTO;
import java.util.ArrayList;

public class NghiPhep_BUS{
    private NghiPhep_DAO nghiPhep_DAO = new NghiPhep_DAO();
    
    public boolean AddNghiPhep(NghiPhep_DTO nghiPhep){     
        return(nghiPhep_DAO.AddNghiPhep(nghiPhep));
    }
    
    public boolean EditNghiPhep(NghiPhep_DTO nghiPhep) {
        return nghiPhep_DAO.EditNghiPhep(nghiPhep);
    }
    
    public boolean DeleteNghiPhep(int maNghiPhep) {
        return nghiPhep_DAO.DeleteNghiPhep(maNghiPhep);
    }
    
    public ArrayList<NghiPhep_DTO> GetAllNghiPhep() {
        return nghiPhep_DAO.GetAllNghiPhep();
    }
    
    public NghiPhep_DTO GetNghiPhepByID(int maNhanVien) {
        return nghiPhep_DAO.GetNghiPhepByID(maNhanVien);
    }
}
