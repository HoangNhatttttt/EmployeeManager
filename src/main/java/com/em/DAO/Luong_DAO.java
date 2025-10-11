package com.em.DAO;
import com.em.DTO.NhanVien_DTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Luong_DAO{
    /*
    SQL Database:
    CREATE TABLE `luong` (
        `maLuong` int(11) NOT NULL,
        `maNhanVien` int(11) NOT NULL,
        `luongCoBan` int(11) NOT NULL,
        `soGioCoBan` int(11) NOT NULL
    )
    */
    
    // Trích xuất toàn bộ nhanvien từ database
    public ArrayList<NhanVien_DTO> GetAllLuong() {
        ArrayList<NhanVien_DTO> nhanvienList = new ArrayList<>();
        String sql = "SELECT * FROM nhanvien";    
        // Truy cứu không cần user input --> dùng Statement
        
        try (Connection connect = DatabaseConnect.getConnection();
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)) {
            
            // Trong trường hợp này resultSet chứa toàn bộ data của nhanvien trong database
            /* Row 1: [id=1, hoTen="Nguyễn Văn A", ...]
               Row 2: [id=2, hoTen="Nguyễn Văn B", ...]
               Row 3: [id=3, hoTen="Nguyễn Văn C", ...] */
            
            while (resultSet.next()){ // Loop qua từng dòng nhanvien, trích xuất thông tin nhanvien trong dòng đó
                NhanVien_DTO nhanvien = new NhanVien_DTO();
                nhanvien.setMaNhanVien(resultSet.getInt("maNhanVien"));
                nhanvien.setHoTen(resultSet.getString("hoTen"));
                nhanvien.setGioiTinh(resultSet.getString("gioiTinh"));
                nhanvien.setDiaChi(resultSet.getString("diaChi"));
                nhanvien.setSoDienThoai(resultSet.getString("soDienThoai"));
                nhanvien.setMaLuong(resultSet.getInt("maLuong"));
                nhanvien.setMaPhongBan(resultSet.getInt("maPhongBan"));
                nhanvien.setMaChucVu(resultSet.getInt("maChucVu"));
                nhanvien.setMaHopDong(resultSet.getInt("maHopDong"));
                nhanvien.setTrangThai(resultSet.getString("trangThai"));
                
                nhanvienList.add(nhanvien);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return nhanvienList;
    }
}
