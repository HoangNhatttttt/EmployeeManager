package com.em.DAO;

import com.em.DTO.PhongBan_DTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class HopDong_DAO{
    public boolean AddPhongBan(PhongBan_DTO phongBan) {
        String sql = "INSERT INTO phongban (tenPhongBan) VALUES (?)";
        
        try (Connection connection = DatabaseConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
              
            preparedStatement.setString(1, phongBan.getTenPhongBan());
                        
            int rowsInserted = preparedStatement.executeUpdate(); 
            if (rowsInserted > 0) { 
                try (ResultSet resultSet = preparedStatement.getGeneratedKeys()){ 
                    if (resultSet.next() == true) 
                        phongBan.setMaPhongBan(resultSet.getInt(1)); 
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
    
    public boolean EditPhongBan(PhongBan_DTO phongBan) {   
        String sql = "UPDATE phongban SET tenPhongBan = ? WHERE maPhongBan = ?";
        
        try (Connection connection = DatabaseConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setString(1, phongBan.getTenPhongBan());
            preparedStatement.setInt(2, phongBan.getMaPhongBan());

            int rowsUpdated = preparedStatement.executeUpdate();
            
            if(rowsUpdated > 0)
                return true;
            return false;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean DeletePhongBan(int maPhongBan) {
        String sql = "DELETE FROM phongban WHERE maPhongBan = ?";
        
        try (Connection connection = DatabaseConnect.getConnection();
             PreparedStatement data = connection.prepareStatement(sql)) {
            
            data.setInt(1, maPhongBan);
            int rowsDeleted = data.executeUpdate();
            return rowsDeleted > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public ArrayList<PhongBan_DTO> GetAllPhongBan() {
        ArrayList<PhongBan_DTO> phongBanList = new ArrayList<>();
        String sql = "SELECT * FROM PhongBan";    
        
        try (Connection connect = DatabaseConnect.getConnection();
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)) {
            
            while (resultSet.next()){ 
                PhongBan_DTO phongBan = new PhongBan_DTO();
                phongBan.setMaPhongBan(resultSet.getInt("maPhongBan"));
                phongBan.setTenPhongBan(resultSet.getString("tenPhongBan"));
                
                phongBanList.add(phongBan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return phongBanList;
    }
    
    public PhongBan_DTO GetPhongBanByID(int maPhongBan) {
        String sql = "SELECT * FROM phongban WHERE maPhongBan = ?";
        
        PhongBan_DTO phongBan = new PhongBan_DTO();
        
        try (Connection connection = DatabaseConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setInt(1, maPhongBan);
            ResultSet resultSet = preparedStatement.executeQuery();
                 
            if (resultSet.next()) {
                
                phongBan.setMaPhongBan(resultSet.getInt("maPhongBan"));
                phongBan.setTenPhongBan(resultSet.getString("tenPhongBan"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return phongBan;
    }
        
}
