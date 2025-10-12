package com.em.BUS;
import com.em.DTO.NhanVien_DTO;
import com.em.DAO.NhanVien_DAO;
import java.util.ArrayList;

public class NhanVien_BUS{
    private NhanVien_DAO employeeDAO = new NhanVien_DAO();
    
    
    public boolean AddNhanVien(NhanVien_DTO employee){     
        return(employeeDAO.AddNhanVien(employee)); // Nếu thành công thì trả về True, thất bại thì trả về False
    }
    
    // Cập nhật thông tin Employee lên database sau khi sửa đổi
    public boolean EditNhanVien(NhanVien_DTO nhanVien) {
        return employeeDAO.EditNhanVien(nhanVien);
    }
    
    // Xoá employee khỏi database bằng id
    public boolean DeleteNhanVien(int maNhanVien) {
        // Thêm hàm check nếu employee được sử dụng bởi foreign key (hoá đơn, ...)
        return employeeDAO.DeleteNhanVien(maNhanVien);
    }
    
    // Trích xuất toàn bộ employee từ database
    public ArrayList<NhanVien_DTO> GetAllNhanVien() {
        return employeeDAO.GetAllNhanVien();
    }
    
    // Trích xuất employee thông qua ID
    public NhanVien_DTO GetNhanVienById(int maNhanVien) {
        return employeeDAO.GetNhanVienById(maNhanVien);
    }
}
