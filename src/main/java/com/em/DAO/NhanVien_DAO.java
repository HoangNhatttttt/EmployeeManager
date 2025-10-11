package com.em.DAO;

import com.em.DTO.NhanVien_DTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class NhanVien_DAO{
    /*
    
    Database SQL:
    CREATE TABLE `nhanvien` (
        `maNhanVien` int(11) NOT NULL,         -- AUTO_INCREMENT PRIMARY KEY: tạo Id khi chèn 1 hàng - row vào database
        `hoTen` varchar(50) NOT NULL,
        `ngaySinh` date NOT NULL,
        `gioiTinh` varchar(1) NOT NULL,        -- 'M' or 'F'
        `diaChi` varchar(50) NOT NULL,
        `soDienThoai` varchar(10) NOT NULL,    -- 8-10 digits
        `maLuong` int(11),                     -- maLuong thêm vào sau --> cho phép NULL
        `maPhongBan` int(11),                  -- maPhongBan thêm vào sau --> cho phép NULL
        `maChucVu` int(11),                    -- maChucVu thêm vào sau --> cho phép NULL
        `maHopDong` int(11),                   -- maHopDong thêm vào sau --> cho phép NULL
        `trangThai` varchar(3) NOT NULL        -- "Yes" / "No" 
    )
    */
    
    
    
    public boolean AddNhanVien(NhanVien_DTO nhanvien) {
        String sql = "INSERT INTO nhanvien (hoTen, ngaySinh, gioiTinh, diaChi, soDienThoai, trangThai) VALUES (?, ?, ?, ?, ?, ?, ?)";
        // Add thông tin Employee từ user input --> Dùng Prepared statement
        
        try (Connection connection = DatabaseConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
              
            // setString(int parameterIndex, String x) ; int parameterIndex: Vị trí để nhập dữ liệu
            preparedStatement.setString(1, nhanvien.getHoTen());
            java.sql.Date sqlNgaySinh = new java.sql.Date(nhanvien.getNgaySinh().getTime()); // Chuyển util.Date sang sql.Date
            preparedStatement.setDate(2, sqlNgaySinh);
            preparedStatement.setString(4, nhanvien.getGioiTinh());
            preparedStatement.setString(5, nhanvien.getDiaChi());
            preparedStatement.setString(6, nhanvien.getSoDienThoai());
            preparedStatement.setString(7, nhanvien.getTrangThai());
            
            int rowsInserted = preparedStatement.executeUpdate(); // Hiện số dòng đã chèn vào database

            if (rowsInserted > 0) { // rowsInserted > 0 --> data được thêm thành công vào database
                
                try (ResultSet resultSet = preparedStatement.getGeneratedKeys()){ // getGeneratedKeys trích xuất Id được tạo tự động khi insert nhanvien vào database
                    if (resultSet.next() == true) // true khi có dòng kế tiếp (dòng id được tạo tự động), không trả về false
                        nhanvien.setMaNhanVien(resultSet.getInt(1)); // resultSet.getInt(1) trich xuất giá trị integer tại cột 1 (cột Id)
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
                nhanvien.setMaLuong(resultSet.getInt("maLuong"));
                nhanvien.setMaPhongBan(resultSet.getInt("maPhongBan"));
                nhanvien.setMaChucVu(resultSet.getInt("maChucVu"));
                nhanvien.setMaHopDong(resultSet.getInt("maHopDong"));
                nhanvien.setTrangThai(resultSet.getString("trangThai"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return nhanvien;
    }
    
    // Cập nhật thông tin nhanvien lên database sau khi sửa đổi
    public boolean UpdateNhanVien(NhanVien_DTO nhanvien) {   
        String sql = "UPDATE nhanvien SET hoTen = ?, ngaySinh = ?, gioiTinh = ?, diaChi = ?, soDienThoai = ?, maLuong = ?, maPhongBan = ?, maChucVu = ?, maHopDong = ?, trangThai = ? WHERE maNhanVien = ?";
        // Thông tin sửa đổi được lấy từ user input --> dùng prepared statement
        
        try (Connection connection = DatabaseConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setString(1, nhanvien.getHoTen());
            java.sql.Date sqlNgaySinh = new java.sql.Date(nhanvien.getNgaySinh().getTime()); // Chuyển util.Date sang sql.Date
            preparedStatement.setDate(2, sqlNgaySinh);
            preparedStatement.setString(3, nhanvien.getGioiTinh());
            preparedStatement.setString(4, nhanvien.getDiaChi());
            preparedStatement.setString(5, nhanvien.getSoDienThoai());
            preparedStatement.setInt(6, nhanvien.getMaLuong());
            preparedStatement.setInt(7, nhanvien.getMaPhongBan());
            preparedStatement.setInt(8, nhanvien.getMaChucVu());
            preparedStatement.setInt(9, nhanvien.getMaHopDong());
            preparedStatement.setString(10, nhanvien.getTrangThai());
            
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
             PreparedStatement data = connection.prepareStatement(sql)) {
            
            data.setInt(1, maNhanVien);
            int rowsDeleted = data.executeUpdate();
            return rowsDeleted > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
