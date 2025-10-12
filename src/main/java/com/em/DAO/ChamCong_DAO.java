
package com.em.DAO;

import com.em.DTO.ChamCong_DTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ChamCong_DAO{
    public boolean AddChamCong(ChamCong_DTO chamCong) {
        String sql = "INSERT INTO chamcong (maNhanVien, ngayBatDau, ngayKetThuc) VALUES (?, ?, ?)";
        
        try (Connection connection = DatabaseConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            
            java.sql.Date sqlNgaybatDau = new java.sql.Date(chamCong.getNgayBatDau().getTime());
            java.sql.Date sqlNgayKetThuc = new java.sql.Date(chamCong.getNgayKetThuc().getTime());
            
            preparedStatement.setInt(1, chamCong.getMaNhanVien());
            preparedStatement.setDate(2, sqlNgaybatDau);
            preparedStatement.setDate(3, sqlNgayKetThuc);
                        
            int rowsInserted = preparedStatement.executeUpdate(); 
            if (rowsInserted > 0) { 
                try (ResultSet resultSet = preparedStatement.getGeneratedKeys()){ 
                    if (resultSet.next() == true) 
                        chamCong.setMaChamCong(resultSet.getInt(1)); 
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
    
    public boolean EditChamCong(ChamCong_DTO chamCong) {   
        String sql = "UPDATE chamcong SET maNhanVien = ?, ngayBatDau = ?, ngayKetThuc = ? WHERE maChamCong = ?";
        
        try (Connection connection = DatabaseConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            java.sql.Date sqlNgaybatDau = new java.sql.Date( chamCong.getNgayBatDau().getTime());
            java.sql.Date sqlNgayKetThuc = new java.sql.Date( chamCong.getNgayKetThuc().getTime());
            
            preparedStatement.setInt(1, chamCong.getMaNhanVien());
            preparedStatement.setDate(2, sqlNgaybatDau);
            preparedStatement.setDate(3, sqlNgayKetThuc);  
            preparedStatement.setInt(4, chamCong.getMaChamCong());

            int rowsUpdated = preparedStatement.executeUpdate();
            
            if(rowsUpdated > 0)
                return true;
            return false;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean DeleteChamCong(int maChamCong) {
        String sql = "DELETE FROM chamcong WHERE maChamCong = ?";
        
        try (Connection connection = DatabaseConnect.getConnection();
        PreparedStatement data = connection.prepareStatement(sql)) {
            
            data.setInt(1, maChamCong);
            int rowsDeleted = data.executeUpdate();
            return rowsDeleted > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public ArrayList<ChamCong_DTO> GetAllChamCong() {
        ArrayList<ChamCong_DTO> chamCongList = new ArrayList<>();
        String sql = "SELECT * FROM ChamCong";    
        
        try (Connection connect = DatabaseConnect.getConnection();
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)) {
            
            while (resultSet.next()){ 
                ChamCong_DTO chamCong = new ChamCong_DTO();
                
                chamCong.setMaChamCong(resultSet.getInt("maChamCong"));
                chamCong.setMaNhanVien(resultSet.getInt("maNhanVien"));
                chamCong.setNgayBatDau(resultSet.getDate("ngayBatDau"));
                chamCong.setNgayKetThuc(resultSet.getDate("ngayKetThuc"));
                
                chamCongList.add(chamCong);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return chamCongList;
    }
    
    public ChamCong_DTO GetChamCongByID(int maChamCong) {
        String sql = "SELECT * FROM chamcong WHERE maChamCong = ?";
        
        ChamCong_DTO chamCong = new ChamCong_DTO();
        
        try (Connection connection = DatabaseConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setInt(1, maChamCong);
            ResultSet resultSet = preparedStatement.executeQuery();
                 
            if (resultSet.next()) {
                
                chamCong.setMaChamCong(resultSet.getInt("maChamCong"));
                chamCong.setMaNhanVien(resultSet.getInt("maNhanVien"));
                chamCong.setNgayBatDau(resultSet.getDate("ngayBatDau"));
                chamCong.setNgayKetThuc(resultSet.getDate("ngayKetThuc"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return chamCong;
    } 
}
