
package com.em.DAO;

import com.em.DTO.NghiPhep_DTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class NghiPhep_DAO{
    public boolean AddNghiPhep(NghiPhep_DTO nghiPhep) {
        String sql = "INSERT INTO nghiphep (maNhanVien, ngayBatDau, ngayKetThuc, lyDo) VALUES (?, ?, ?, ?)";
        
        try (Connection connection = DatabaseConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setInt(1, nghiPhep.getMaNhanVien());
            preparedStatement.setDate(2, nghiPhep.getNgayBatDau());
            preparedStatement.setDate(3, nghiPhep.getNgayKetThuc());
            preparedStatement.setString(4, nghiPhep.getLyDo());
                        
            int rowsInserted = preparedStatement.executeUpdate(); 
            if (rowsInserted > 0) { 
                try (ResultSet resultSet = preparedStatement.getGeneratedKeys()){ 
                    if (resultSet.next() == true) 
                        nghiPhep.setMaNghiPhep(resultSet.getInt(1)); 
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
    
    public boolean EditNghiPhep(NghiPhep_DTO nghiPhep) {   
        String sql = "UPDATE nghiphep SET maNhanVien = ?, ngayBatDau = ?, ngayKetThuc = ?, lyDo = ? WHERE maNghiPhep = ?";
        
        try (Connection connection = DatabaseConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setInt(1, nghiPhep.getMaNhanVien());
            preparedStatement.setDate(2, nghiPhep.getNgayBatDau());
            preparedStatement.setDate(3, nghiPhep.getNgayKetThuc());
            preparedStatement.setString(4, nghiPhep.getLyDo());

            int rowsUpdated = preparedStatement.executeUpdate();
            
            if(rowsUpdated > 0)
                return true;
            return false;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean DeleteNghiPhep(int maNghiPhep) {
        String sql = "DELETE FROM nghiphep WHERE maNghiPhep = ?";
        
        try (Connection connection = DatabaseConnect.getConnection();
        PreparedStatement data = connection.prepareStatement(sql)) {
            
            data.setInt(1, maNghiPhep);
            int rowsDeleted = data.executeUpdate();
            return rowsDeleted > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public ArrayList<NghiPhep_DTO> GetAllNghiPhep() {
        ArrayList<NghiPhep_DTO> nghiPhepList = new ArrayList<>();
        String sql = "SELECT * FROM NghiPhep";    
        
        try (Connection connect = DatabaseConnect.getConnection();
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)) {
            
            while (resultSet.next()){ 
                NghiPhep_DTO nghiPhep = new NghiPhep_DTO();
                
                nghiPhep.setMaNghiPhep(resultSet.getInt("maNghiPhep"));
                nghiPhep.setMaNhanVien(resultSet.getInt("maNhanVien"));
                nghiPhep.setNgayBatDau(resultSet.getDate("ngayBatDau"));
                nghiPhep.setNgayKetThuc(resultSet.getDate("ngayKetThuc"));
                nghiPhep.setLyDo(resultSet.getString("lyDo"));
                
                nghiPhepList.add(nghiPhep);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return nghiPhepList;
    }
    
    public NghiPhep_DTO GetNghiPhepByID(int maNghiPhep) {
        String sql = "SELECT * FROM nghiphep WHERE maNghiPhep = ?";
        
        NghiPhep_DTO nghiPhep = new NghiPhep_DTO();
        
        try (Connection connection = DatabaseConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setInt(1, maNghiPhep);
            ResultSet resultSet = preparedStatement.executeQuery();
                 
            if (resultSet.next()) {
                
                nghiPhep.setMaNghiPhep(resultSet.getInt("maNghiPhep"));
                nghiPhep.setMaNhanVien(resultSet.getInt("maNhanVien"));
                nghiPhep.setNgayBatDau(resultSet.getDate("ngayBatDau"));
                nghiPhep.setNgayKetThuc(resultSet.getDate("ngayKetThuc"));
                nghiPhep.setLyDo(resultSet.getString("lyDo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return nghiPhep;
    }
}
