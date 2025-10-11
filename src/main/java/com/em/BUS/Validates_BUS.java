package com.em.BUS;
import com.em.DTO.NhanVien_DTO;
import com.toedter.calendar.JDateChooser;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;

public class Validates_BUS{
    
    public String CleanString(String text){
        // trim() xoá whitespace ở đầu và cuối String
        // replaceAll(): replace các khoảng trắng từ 2 cái liên tục trở lên thành 1 cái
        return text.trim().replaceAll("\\s+", " ");
    }
    
    public boolean ValidateIsEmpty(String text){
        if(text.isBlank() || text.isEmpty() || text == null)
            return true;
        return false;
    }
    
    public boolean ValidateIsInteger(String text){        
        //TH là Integer
        try {
            int nums = Integer.parseInt(text); // Đồng thời bỏ các số 0 ở đầu
            return true;
        }
        //TH không phải Integer
        catch (NumberFormatException e) {
            return false;
        }
    }
    
    public boolean ValidateHasSpecialCharacter(String text){
        // Nếu không matches --> Có special character --> Return true
        // Có mataches --> Không có special chacacter --> Return false
        return !text.matches("[a-zA-Z0-9 ]+"); 
    }
    
    public boolean ValidateIsStartWithWhitespace(String text){
        if(text.startsWith(" "))
            return true;
        return false;               
    }
    
    public String ValidateHoTen(JTextField firstNameField){
        String firstName = firstNameField.getText();
        
        if(ValidateIsEmpty(firstName) == true)
            return "Họ tên không được để trống.";
        
        if(ValidateHasSpecialCharacter(firstName) == true)
            return "Họ tên không chứa ký tự đặc biệt";
        
        if(ValidateIsStartWithWhitespace(firstName) == true)
            return "Không bắt đầu bằng khoảng trắng";
        
        return null;
    }
    
    public String ValidateNgaySinh(JDateChooser ngaySinh){
        Date ngaySinhNV = ngaySinh.getDate();
        Date today = new Date();
        
        // Check rỗng
        if(ngaySinhNV == null)
            return "Ngày sinh không được để trống";
        
        // Check nhân viên đã sinh ra chưa
        if(ngaySinhNV.after(today)){
            return "Nhân viên phải được sinh ra trước.";
        }
        

        Calendar ngaySinhNVCalendar = Calendar.getInstance(); // Tạo Calender (lịch) chứa thời gian mà dòng code này được chạy
        ngaySinhNVCalendar.setTime(ngaySinhNV); // Set ngày của lịch thành ngày sinh của nhân viên

        Calendar todayCalendar = Calendar.getInstance();
        todayCalendar.setTime(today);

        int age = todayCalendar.get(Calendar.YEAR) - ngaySinhNVCalendar.get(Calendar.YEAR);

        // Kiểm tra ngày sinh trong năm đã diễn ra chưa
        // Nếu tháng sinh < tháng hiện tại thì chưa đến ngày sinh nhật
        if (todayCalendar.get(Calendar.MONTH) < ngaySinhNVCalendar.get(Calendar.MONTH))
            age--;
         
        // Nếu trùng tháng nhưng ngày < ngày hiện tại thì chưa đến ngày sinh nhật
        else if (todayCalendar.get(Calendar.MONTH) == ngaySinhNVCalendar.get(Calendar.MONTH)) 
            if (todayCalendar.get(Calendar.DAY_OF_MONTH) < ngaySinhNVCalendar.get(Calendar.DAY_OF_MONTH)) 
                age--;
   
        // Kiểm tra tuổi
        if(age < 0)
            return "Nhân viên phải được sinh ra trước.";
        else if (age >= 0 && age < 18)
            return "Nhân viên quá trẻ.";
        else if (age >= 70 && age < 150)
            return "Nhân viên quá độ tuổi lao động.";
        else if (age >= 150)
            return "Nhân viên có phải là ma cà rồng ?"; 
                
        return null;
    }
    
    public String ValidateGioiTinh(ButtonGroup gioiTinhButtonGroup){
        if(gioiTinhButtonGroup.getSelection() == null)
            return "Giới tính không được bỏ trống.";
           
        return null;
    }
    
    public String ValidateDiaChi(JTextField diaChi){
        String diaChiNV = diaChi.getText();
        
        if(ValidateIsEmpty(diaChiNV) == true)
            return "Địa chỉ không được bỏ trống";
                
        if(ValidateIsStartWithWhitespace(diaChiNV) == true)
            return "Địa chỉ không bắt đầu bằng khoảng trắng";
        
        return null;
    }
    
    public String ValidateSoDienThoai(JTextField soDienThoai){
        String soDienThoaiNV = soDienThoai.getText();
        
        if(ValidateIsEmpty(soDienThoaiNV) == true)
            return "Số điện thoại không được bỏ trống.";
        
        if(ValidateIsInteger(soDienThoaiNV) == false)
            return "Số điện thoại chỉ chứa số.";
        
        if(!soDienThoaiNV.startsWith("0"))
            return "Số điện thoại bắt đầu bằng 0.";
        
        if(soDienThoaiNV.length() < 8 || soDienThoaiNV.length() > 10)
            return "Số điện thoại phải có độ dài 8 - 10.";
        
        if(ValidateIsStartWithWhitespace(soDienThoaiNV) == true)
            return "Số điện thoại không bắt đầu bằng khoảng trắng.";
            
        return null;
    }
    
    
    
    public String ValidateNhanVien(JTextField hoTen, JDateChooser ngaySinh, ButtonGroup gioiTinh, JTextField diaChi, JTextField soDienThoai){
        
        String error; // Nếu có error thì error sẽ gán giá trị khác null, không thì được gán giá trị null
        
        error = ValidateHoTen(hoTen);
        if(error != null) {
            hoTen.requestFocus();
            return error;
        }
         
        error = ValidateNgaySinh(ngaySinh);
        if(error != null){
            ngaySinh.requestFocus();
            return error;
        }
        
        error = ValidateGioiTinh(gioiTinh);
        if(error != null) return error;

        
        error = ValidateDiaChi(diaChi);
        if(error != null){
            diaChi.requestFocus();
            return error;
        }
    
        error = ValidateSoDienThoai(soDienThoai);
        if(error != null){
            soDienThoai.requestFocus();
            return error;
        }
                     
        return null;
    }
    
    public NhanVien_DTO ReturnNhanVien(JTextField hoTen, JDateChooser ngaySinh, ButtonGroup gioiTinh, JTextField diaChi, JTextField soDienThoai){
       String hoTenNV = CleanString(hoTen.getText());
       Date ngaySinhNV = ngaySinh.getDate();
       String gioiTinhNV = gioiTinh.getSelection().getActionCommand();
       String diaChiNV = CleanString(diaChi.getText());
       String soDienThoaiNV = soDienThoai.getText();
       
       NhanVien_DTO nhanVien = new NhanVien_DTO(hoTenNV, ngaySinhNV, gioiTinhNV, diaChiNV, soDienThoaiNV);
       
       return nhanVien;
    }
    
}
