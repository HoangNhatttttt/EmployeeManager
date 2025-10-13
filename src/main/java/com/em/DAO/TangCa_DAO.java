package com.em.DAO;

import com.em.DTO.Luong_DTO;
import com.em.DTO.TangCa_DTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TangCa_DAO{
    public boolean AddTangCa(TangCa_DTO tangCa) {
        String sql = "INSERT INTO tangca (maNhanVien, luongTangCa, soGioTangCa, ngayTangCa) VALUES (?, ?, ?, ?)";
        
        try (Connection connection = DatabaseConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
                        
            preparedStatement.setInt(1, tangCa.getMaNhanVien());
            preparedStatement.setInt(2, tangCa.getLuongTangCa());
            preparedStatement.setInt(3, tangCa.getSoGioTangCa());
            preparedStatement.setDate(4, tangCa.getNgayTangCa());
                        
            int rowsInserted = preparedStatement.executeUpdate(); 
            if (rowsInserted > 0) { 
                try (ResultSet resultSet = preparedStatement.getGeneratedKeys()){ 
                    if (resultSet.next() == true) 
                        tangCa.setMaTangCa(resultSet.getInt(1)); 
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
    
    public boolean EditTangCa(TangCa_DTO tangCa) {   
        String sql = "UPDATE tangca SET maNhanVien = ?, luongTangCa = ?, soGioTangCa = ?, ngayTangCa = ? WHERE maTangCa = ?";
        
        try (Connection connection = DatabaseConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setInt(1, tangCa.getMaNhanVien());
            preparedStatement.setInt(2, tangCa.getLuongTangCa());
            preparedStatement.setInt(3, tangCa.getSoGioTangCa());
            preparedStatement.setDate(4, tangCa.getNgayTangCa());

            int rowsUpdated = preparedStatement.executeUpdate();
            
            if(rowsUpdated > 0)
                return true;
            return false;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean DeleteTangCa(int maTangCa) {
        String sql = "DELETE FROM tangca WHERE maTangCa = ?";
        
        try (Connection connection = DatabaseConnect.getConnection();
        PreparedStatement data = connection.prepareStatement(sql)) {
            
            data.setInt(1, maTangCa);
            int rowsDeleted = data.executeUpdate();
            return rowsDeleted > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public ArrayList<TangCa_DTO> GetAllTangCa() {
        ArrayList<TangCa_DTO> tangCaList = new ArrayList<>();
        String sql = "SELECT * FROM tangca";    
        
        try (Connection connect = DatabaseConnect.getConnection();
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)) {
            
            while (resultSet.next()){ 
                TangCa_DTO tangCa = new TangCa_DTO();
                
                tangCa.setMaTangCa(resultSet.getInt("maTangCa"));
                tangCa.setMaNhanVien(resultSet.getInt("maNhanVien"));
                tangCa.setLuongTangCa(resultSet.getInt("luongTangCa"));
                tangCa.setSoGioTangCa(resultSet.getInt("soGioTangCa"));
                tangCa.setNgayTangCa(resultSet.getDate("ngayTangCa"));
                
                tangCaList.add(tangCa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return tangCaList;
    }
    
    public TangCa_DTO GetTangCaByID(int maTangCa) {
        String sql = "SELECT * FROM tangca WHERE maTangCa = ?";
        
        TangCa_DTO tangCa = new TangCa_DTO();
        
        try (Connection connection = DatabaseConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setInt(1, maTangCa);
            ResultSet resultSet = preparedStatement.executeQuery();
                 
            if (resultSet.next()) {
                
                tangCa.setMaTangCa(resultSet.getInt("maTangCa"));
                tangCa.setMaNhanVien(resultSet.getInt("maNhanVien"));
                tangCa.setLuongTangCa(resultSet.getInt("luongTangCa"));
                tangCa.setSoGioTangCa(resultSet.getInt("soGioTangCa"));
                tangCa.setNgayTangCa(resultSet.getDate("ngayTangCa"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return tangCa;
    }
}
