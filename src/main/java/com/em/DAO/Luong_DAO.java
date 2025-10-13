package com.em.DAO;

import com.em.DTO.Luong_DTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Luong_DAO{
    public boolean AddLuong(Luong_DTO luong) {
        String sql = "INSERT INTO luong (maNhanVien, luongCoBan, soGioCoBan, ngayNhanLuong) VALUES (?, ?, ?, ?)";
        
        try (Connection connection = DatabaseConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
                        
            preparedStatement.setInt(1, luong.getMaNhanVien());
            preparedStatement.setInt(2, luong.getLuongCoBan());
            preparedStatement.setInt(3, luong.getSoGioCoBan());
            preparedStatement.setDate(4, luong.getNgayNhanLuong());
                        
            int rowsInserted = preparedStatement.executeUpdate(); 
            if (rowsInserted > 0) { 
                try (ResultSet resultSet = preparedStatement.getGeneratedKeys()){ 
                    if (resultSet.next() == true) 
                        luong.setMaLuong(resultSet.getInt(1)); 
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
    
    public boolean EditLuong(Luong_DTO luong) {   
        String sql = "UPDATE luong SET maNhanVien = ?, luongCoBan = ?, soGioCoBan = ?, ngayNhanLuong = ? WHERE maLuong = ?";
        
        try (Connection connection = DatabaseConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setInt(1, luong.getMaNhanVien());
            preparedStatement.setInt(2, luong.getLuongCoBan());
            preparedStatement.setInt(3, luong.getSoGioCoBan());
            preparedStatement.setDate(4, luong.getNgayNhanLuong());

            int rowsUpdated = preparedStatement.executeUpdate();
            
            if(rowsUpdated > 0)
                return true;
            return false;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean DeleteLuong(int maLuong) {
        String sql = "DELETE FROM luong WHERE maLuong = ?";
        
        try (Connection connection = DatabaseConnect.getConnection();
        PreparedStatement data = connection.prepareStatement(sql)) {
            
            data.setInt(1, maLuong);
            int rowsDeleted = data.executeUpdate();
            return rowsDeleted > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public ArrayList<Luong_DTO> GetAllLuong() {
        ArrayList<Luong_DTO> luongList = new ArrayList<>();
        String sql = "SELECT * FROM Luong";    
        
        try (Connection connect = DatabaseConnect.getConnection();
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)) {
            
            while (resultSet.next()){ 
                Luong_DTO luong = new Luong_DTO();
                
                luong.setMaLuong(resultSet.getInt("maLuong"));
                luong.setMaNhanVien(resultSet.getInt("maNhanVien"));
                luong.setLuongCoBan(resultSet.getInt("luongCoBan"));
                luong.setSoGioCoBan(resultSet.getInt("soGioCoBan"));
                luong.setNgayNhanLuong(resultSet.getDate("ngayNhanLuong"));
                
                luongList.add(luong);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return luongList;
    }
    
    public Luong_DTO GetLuongByID(int maLuong) {
        String sql = "SELECT * FROM luong WHERE maLuong = ?";
        
        Luong_DTO luong = new Luong_DTO();
        
        try (Connection connection = DatabaseConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setInt(1, maLuong);
            ResultSet resultSet = preparedStatement.executeQuery();
                 
            if (resultSet.next()) {
                
                luong.setMaLuong(resultSet.getInt("maLuong"));
                luong.setMaNhanVien(resultSet.getInt("maNhanVien"));
                luong.setLuongCoBan(resultSet.getInt("luongCoBan"));
                luong.setSoGioCoBan(resultSet.getInt("soGioCoBan"));
                luong.setNgayNhanLuong(resultSet.getDate("ngayNhanLuong"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return luong;
    }
    
    
    
}
