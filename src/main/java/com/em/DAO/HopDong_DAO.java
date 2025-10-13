package com.em.DAO;

import com.em.DTO.HopDong_DTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class HopDong_DAO{
    
    public boolean AddHopDong(HopDong_DTO hopDong) {
        String sql = "INSERT INTO hopdong (maNhanVien, ngayBatDau, ngayKetThuc) VALUES (?, ?, ?)";
        
        try (Connection connection = DatabaseConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setInt(1, hopDong.getMaNhanVien());
            preparedStatement.setDate(2, hopDong.getNgayBatDau());
            preparedStatement.setDate(3, hopDong.getNgayKetThuc());
                        
            int rowsInserted = preparedStatement.executeUpdate(); 
            if (rowsInserted > 0) { 
                try (ResultSet resultSet = preparedStatement.getGeneratedKeys()){ 
                    if (resultSet.next() == true) 
                        hopDong.setMaHopDong(resultSet.getInt(1)); 
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
    
    public boolean EditHopDong(HopDong_DTO hopDong) {   
        String sql = "UPDATE hopdong SET maNhanVien = ?, ngayBatDau = ?, ngayKetThuc = ? WHERE maHopDong = ?";
        
        try (Connection connection = DatabaseConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            

            preparedStatement.setInt(1, hopDong.getMaNhanVien());
            preparedStatement.setDate(2, hopDong.getNgayBatDau());
            preparedStatement.setDate(3, hopDong.getNgayKetThuc());  
            preparedStatement.setInt(4, hopDong.getMaHopDong());

            int rowsUpdated = preparedStatement.executeUpdate();
            
            if(rowsUpdated > 0)
                return true;
            return false;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean DeleteHopDong(int maHopDong) {
        String sql = "DELETE FROM hopdong WHERE maHopDong = ?";
        
        try (Connection connection = DatabaseConnect.getConnection();
        PreparedStatement data = connection.prepareStatement(sql)) {
            
            data.setInt(1, maHopDong);
            int rowsDeleted = data.executeUpdate();
            return rowsDeleted > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public ArrayList<HopDong_DTO> GetAllHopDong() {
        ArrayList<HopDong_DTO> hopDongList = new ArrayList<>();
        String sql = "SELECT * FROM HopDong";    
        
        try (Connection connect = DatabaseConnect.getConnection();
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)) {
            
            while (resultSet.next()){ 
                HopDong_DTO hopDong = new HopDong_DTO();
                
                hopDong.setMaHopDong(resultSet.getInt("maHopDong"));
                hopDong.setMaNhanVien(resultSet.getInt("maNhanVien"));
                hopDong.setNgayBatDau(resultSet.getDate("ngayBatDau"));
                hopDong.setNgayKetThuc(resultSet.getDate("ngayKetThuc"));
                
                hopDongList.add(hopDong);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return hopDongList;
    }
    
    public HopDong_DTO GetHopDongByID(int maHopDong) {
        String sql = "SELECT * FROM hopdong WHERE maHopDong = ?";
        
        HopDong_DTO hopDong = new HopDong_DTO();
        
        try (Connection connection = DatabaseConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setInt(1, maHopDong);
            ResultSet resultSet = preparedStatement.executeQuery();
                 
            if (resultSet.next()) {
                
                hopDong.setMaHopDong(resultSet.getInt("maHopDong"));
                hopDong.setMaNhanVien(resultSet.getInt("maNhanVien"));
                hopDong.setNgayBatDau(resultSet.getDate("ngayBatDau"));
                hopDong.setNgayKetThuc(resultSet.getDate("ngayKetThuc"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return hopDong;
    }
        
}
