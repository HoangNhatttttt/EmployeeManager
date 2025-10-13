package com.em.DAO;

import com.em.DTO.NhanVien_DTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class NhanVien_DAO{
    public boolean AddNhanVien(NhanVien_DTO nhanvien) {
        String sql = "INSERT INTO nhanvien (hoTen, ngaySinh, gioiTinh, diaChi, soDienThoai, maPhongBan, maChucVu, trangThai) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        // Add thông tin Employee từ user input --> Dùng Prepared statement
        
        try (Connection connection = DatabaseConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
              
            // setString(int parameterIndex, String x) ; int parameterIndex: Vị trí để nhập dữ liệu
            preparedStatement.setString(1, nhanvien.getHoTen());
            preparedStatement.setDate(2, nhanvien.getNgaySinh());
            preparedStatement.setString(3, nhanvien.getGioiTinh());
            preparedStatement.setString(4, nhanvien.getDiaChi());
            preparedStatement.setString(5, nhanvien.getSoDienThoai());
            preparedStatement.setInt(6, nhanvien.getMaPhongBan());
            preparedStatement.setInt(7, nhanvien.getMaChucVu());
            preparedStatement.setString(8, nhanvien.getTrangThai());
            
            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                try (ResultSet resultSet = preparedStatement.getGeneratedKeys()){
                    if (resultSet.next() == true)
                        nhanvien.setMaNhanVien(resultSet.getInt(1));
                }
            }
            
            if (rowsInserted > 0) // Chèn vào thành công thì return true
                return true;
            else // Chèn vào thất bại thì return false
                return false;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Sửa thông tin nhân viên trên database
    public boolean EditNhanVien(NhanVien_DTO nhanVien) {   
        String sql = "UPDATE nhanvien SET hoTen = ?, ngaySinh = ?, gioiTinh = ?, diaChi = ?, soDienThoai = ?, maPhongBan = ?, maChucVu = ?, trangThai = ? WHERE maNhanVien = ?";
        // Thông tin sửa đổi được lấy từ user input --> dùng prepared statement
        
        try (Connection connection = DatabaseConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setString(1, nhanVien.getHoTen());
            preparedStatement.setDate(2, nhanVien.getNgaySinh());
            preparedStatement.setString(3, nhanVien.getGioiTinh());
            preparedStatement.setString(4, nhanVien.getDiaChi());
            preparedStatement.setString(5, nhanVien.getSoDienThoai());
            preparedStatement.setInt(6, nhanVien.getMaPhongBan());
            preparedStatement.setInt(7, nhanVien.getMaChucVu());
            preparedStatement.setString(8, nhanVien.getTrangThai());
            preparedStatement.setInt(9, nhanVien.getMaNhanVien());
            
            int rowsUpdated = preparedStatement.executeUpdate();
            
            if(rowsUpdated > 0)
                return true;
            return false;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Xoá nhanvien khỏi database
    public boolean DeleteNhanVien(int maNhanVien) {
        String sql = "DELETE FROM nhanvien WHERE maNhanVien = ?";
        // Biến id có thể chứa sql injection --> sử dụng prepared statemenet
        
        try (Connection connection = DatabaseConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setInt(1, maNhanVien);
            int rowsDeleted = preparedStatement.executeUpdate();
            return rowsDeleted > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Trích xuất toàn bộ nhanvien từ database
    public ArrayList<NhanVien_DTO> GetAllNhanVien() {
        ArrayList<NhanVien_DTO> nhanvienList = new ArrayList<>();
        String sql = "SELECT * FROM nhanvien";    
        // Truy cứu không cần user input --> dùng Statement
        
        try (Connection connect = DatabaseConnect.getConnection();
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)) {
            
            while (resultSet.next()){ // Loop qua từng dòng nhanvien, trích xuất thông tin nhanvien trong dòng đó
                NhanVien_DTO nhanvien = new NhanVien_DTO();
                nhanvien.setMaNhanVien(resultSet.getInt("maNhanVien"));
                nhanvien.setHoTen(resultSet.getString("hoTen"));
                nhanvien.setNgaySinh(resultSet.getDate("ngaySinh"));
                nhanvien.setGioiTinh(resultSet.getString("gioiTinh"));
                nhanvien.setDiaChi(resultSet.getString("diaChi"));
                nhanvien.setSoDienThoai(resultSet.getString("soDienThoai"));
                nhanvien.setMaPhongBan(resultSet.getInt("maPhongBan"));
                nhanvien.setMaChucVu(resultSet.getInt("maChucVu"));
                nhanvien.setTrangThai(resultSet.getString("trangThai"));
                
                nhanvienList.add(nhanvien);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return nhanvienList;
    }
    
    // Trích xuất nhanvien bằng ID
    public NhanVien_DTO GetNhanVienById(int id) {
        String sql = "SELECT * FROM nhanvien WHERE maNhanVien = ?";
        // Biến id có thể chứa sql injection --> sử dụng prepared statemenet
        
        NhanVien_DTO nhanvien = new NhanVien_DTO();
        
        try (Connection connection = DatabaseConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                nhanvien = new NhanVien_DTO();
                
                nhanvien.setMaNhanVien(resultSet.getInt("maNhanVien"));
                nhanvien.setHoTen(resultSet.getString("hoTen"));
                nhanvien.setGioiTinh(resultSet.getString("gioiTinh"));
                nhanvien.setDiaChi(resultSet.getString("diaChi"));
                nhanvien.setSoDienThoai(resultSet.getString("soDienThoai"));
                nhanvien.setMaPhongBan(resultSet.getInt("maPhongBan"));
                nhanvien.setMaChucVu(resultSet.getInt("maChucVu"));
                nhanvien.setTrangThai(resultSet.getString("trangThai"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return nhanvien;
    }
}
