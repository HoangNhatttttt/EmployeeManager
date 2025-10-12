package com.em.DAO;

import com.em.DTO.ChucVu_DTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ChucVu_DAO{    
    public boolean AddChucVu(ChucVu_DTO chucVu) {
        String sql = "INSERT INTO chucvu (tenChucVu) VALUES (?)";
        
        try (Connection connection = DatabaseConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
              
            preparedStatement.setString(1, chucVu.getTenChucVu());
                        
            int rowsInserted = preparedStatement.executeUpdate(); 
            if (rowsInserted > 0) { 
                try (ResultSet resultSet = preparedStatement.getGeneratedKeys()){ 
                    if (resultSet.next() == true) 
                        chucVu.setMaChucVu(resultSet.getInt(1)); 
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
    
    public boolean EditChucVu(ChucVu_DTO chucVu) {   
        String sql = "UPDATE chucvu SET tenChucVu = ? WHERE maChucVu = ?";
        
        try (Connection connection = DatabaseConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setString(1, chucVu.getTenChucVu());
            preparedStatement.setInt(2, chucVu.getMaChucVu());

            int rowsUpdated = preparedStatement.executeUpdate();
            
            if(rowsUpdated > 0)
                return true;
            return false;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean DeleteChucVu(int maChucVu) {
        String sql = "DELETE FROM chucvu WHERE maChucVu = ?";
        
        try (Connection connection = DatabaseConnect.getConnection();
             PreparedStatement data = connection.prepareStatement(sql)) {
            
            data.setInt(1, maChucVu);
            int rowsDeleted = data.executeUpdate();
            return rowsDeleted > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public ArrayList<ChucVu_DTO> GetAllChucVu() {
        ArrayList<ChucVu_DTO> chucVuList = new ArrayList<>();
        String sql = "SELECT * FROM chucvu";    
        
        try (Connection connect = DatabaseConnect.getConnection();
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)) {
            
            while (resultSet.next()){ 
                ChucVu_DTO chucVu = new ChucVu_DTO();
                chucVu.setMaChucVu(resultSet.getInt("maChucVu"));
                chucVu.setTenChucVu(resultSet.getString("tenChucVu"));
                
                chucVuList.add(chucVu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return chucVuList;
    }
    
    public ChucVu_DTO GetChucVuByID(int maChucVu) {
        String sql = "SELECT * FROM chucvu WHERE maChucVu = ?";
        
        ChucVu_DTO chucVu = new ChucVu_DTO();
        
        try (Connection connection = DatabaseConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setInt(1, maChucVu);
            ResultSet resultSet = preparedStatement.executeQuery();
                 
            if (resultSet.next()) {
                
                chucVu.setMaChucVu(resultSet.getInt("maChucVu"));
                chucVu.setTenChucVu(resultSet.getString("tenChucVu"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return chucVu;
    }
}
