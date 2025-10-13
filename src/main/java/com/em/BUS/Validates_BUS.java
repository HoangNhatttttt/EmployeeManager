package com.em.BUS;
import com.em.DTO.ChamCong_DTO;
import com.em.DTO.HopDong_DTO;
import com.em.DTO.Luong_DTO;
import com.em.DTO.NhanVien_DTO;
import com.toedter.calendar.JDateChooser;
import java.util.Calendar;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
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
    
    //
    // Nhân viên
    //
    
    public String ValidateHoTen(JTextField firstNameField){
        String hoTenVN = firstNameField.getText();
        
        if(ValidateIsEmpty(hoTenVN) == true)
            return "Họ tên không được để trống.";
        
        if(ValidateHasSpecialCharacter(hoTenVN) == true)
            return "Họ tên không chứa ký tự đặc biệt";
        
        if(ValidateIsStartWithWhitespace(hoTenVN) == true)
            return "Không bắt đầu bằng khoảng trắng";
        
        return null;
    }
    
    public String ValidateNgaySinh(JDateChooser ngaySinhChooser){
        
        java.util.Date ngaySinh = ngaySinhChooser.getDate();
        Date sqlNgaySinh = new Date(ngaySinh.getTime());
        
        Date today = new Date(System.currentTimeMillis());
        
        // Check rỗng
        if(sqlNgaySinh == null)
            return "Ngày sinh không được để trống";
        
        // Check nhân viên đã sinh ra chưa
        if(sqlNgaySinh.after(today)){
            return "Nhân viên phải được sinh ra trước.";
        }
        

        Calendar ngaySinhCalendar = Calendar.getInstance(); // Tạo Calender (lịch) chứa thời gian mà dòng code này được chạy
        ngaySinhCalendar.setTime(sqlNgaySinh); // Set ngày của lịch thành ngày sinh của nhân viên

        Calendar todayCalendar = Calendar.getInstance();
        todayCalendar.setTime(today);

        int age = todayCalendar.get(Calendar.YEAR) - ngaySinhCalendar.get(Calendar.YEAR);

        // Kiểm tra ngày sinh trong năm đã diễn ra chưa
        // Nếu tháng sinh < tháng hiện tại thì chưa đến ngày sinh nhật
        if (todayCalendar.get(Calendar.MONTH) < ngaySinhCalendar.get(Calendar.MONTH))
            age--;
         
        // Nếu trùng tháng nhưng ngày < ngày hiện tại thì chưa đến ngày sinh nhật
        else if (todayCalendar.get(Calendar.MONTH) == ngaySinhCalendar.get(Calendar.MONTH)) 
            if (todayCalendar.get(Calendar.DAY_OF_MONTH) < ngaySinhCalendar.get(Calendar.DAY_OF_MONTH)) 
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
    
    public String ValidateMaPhongBanNhanVien(JComboBox maPhongBanBox){
        if(maPhongBanBox.getSelectedIndex() == -1)
            return "Mã phòng ban không được để trống.";
        
        return null;
    }
    
    public String ValidateMaChucVuNhanVien(JComboBox maChucVuBox){
        if(maChucVuBox.getSelectedIndex() == -1)
            return "Mã chức vụ không được để trống.";
        
        return null;
    }
    
    public String ValidateNhanVien(JTextField hoTen, JDateChooser ngaySinh, ButtonGroup gioiTinh, JTextField diaChi, JTextField soDienThoai, JComboBox maPhongBanBox, JComboBox maChucVuBox, JComboBox trangThaiBox){
        
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
        
        error = ValidateMaPhongBanNhanVien(maPhongBanBox);
        if(error != null){
            maPhongBanBox.requestFocus();
            return error;
        }
        
        error = ValidateMaChucVuNhanVien(maChucVuBox);
        if(error != null){
            maChucVuBox.requestFocus();
            return error;
        }
        
                     
        return null;
    }
    
    public NhanVien_DTO ReturnNhanVien(JTextField hoTenField, JDateChooser ngaySinhChooser, ButtonGroup gioiTinhButtonGroup, JTextField diaChiField, JTextField soDienThoaiField, JComboBox maPhongBanBox, JComboBox maChucVuBox, JComboBox trangThaiBox){
       String hoTen = CleanString(hoTenField.getText());
       
        java.util.Date ngaySinh = ngaySinhChooser.getDate();
        Date sqlNgaySinh = new Date(ngaySinh.getTime());
        
        String gioiTinh = gioiTinhButtonGroup.getSelection().getActionCommand();
        String diaChi = CleanString(diaChiField.getText());
        String soDienThoai = soDienThoaiField.getText();
        int maPhongBanNV = Integer.parseInt(maPhongBanBox.getSelectedItem().toString());
        int maChucVuNV = Integer.parseInt(maChucVuBox.getSelectedItem().toString());
        String trangThaiNV = trangThaiBox.getSelectedItem().toString();
        NhanVien_DTO nhanVien = new NhanVien_DTO(hoTen, sqlNgaySinh, gioiTinh, diaChi, soDienThoai, maPhongBanNV, maChucVuNV, trangThaiNV);
       
        return nhanVien;
    }
    
    //
    // Phòng ban
    //
    
    public String ValidateTenPhongBan(JTextField tenPhongBan){
        String tenPhongBanText = tenPhongBan.getText();
          
        if(ValidateIsEmpty(tenPhongBanText) == true)
            return "Tên phòng ban không được để trống";
        
        if(ValidateHasSpecialCharacter(tenPhongBanText) == true)
            return "Tên phòng ban không chứa ký tự đặc biệt";
        
        if(ValidateIsStartWithWhitespace(tenPhongBanText) == true)
            return "Tên phòng ban không bắt đầu bằng khoảng trắng";
        
        return null;
    }
    
    //
    // Chức vụ
    //
    
    public String ValidateTenChucVu(JTextField tenChucVu){
        String tenPhongBanText = tenChucVu.getText();
          
        if(ValidateIsEmpty(tenPhongBanText) == true)
            return "Tên chức vụ không được để trống";
        
        if(ValidateHasSpecialCharacter(tenPhongBanText) == true)
            return "Tên chức vụ không chứa ký tự đặc biệt";
        
        if(ValidateIsStartWithWhitespace(tenPhongBanText) == true)
            return "Tên chức không bắt đầu bằng khoảng trắng";
        
        return null;
    }
    
    //
    // Hợp đồng
    //
    
    public String ValidateMaNhanVien(JComboBox maNhanVienBox){
        if (maNhanVienBox.getSelectedItem() == null)
            return "Mã nhân viên không được để trống";
        
        return null;
    }
    
    public String ValidateNgayBatDau_NgayKetThuc(JDateChooser ngayBatDauChooser, JDateChooser ngayKetThucChooser){
        
        java.util.Date ngayBatDau = ngayBatDauChooser.getDate();
        Date sqlNgayBatDau = new Date(ngayBatDau.getTime());
        
        java.util.Date ngayKetThuc = ngayKetThucChooser.getDate();
        Date sqlNgayKetThuc = new Date(ngayKetThuc.getTime());
        
        LocalDate localNgayBatDau = sqlNgayBatDau.toLocalDate();
        LocalDate now = LocalDate.now();

        
        // Check rỗng
        if(sqlNgayBatDau == null)
            return "Ngày bắt đầu không được để trống";
        if(sqlNgayKetThuc == null)
            return "Ngày kết thúc không được để trống";
        if(localNgayBatDau.equals(now) == false)
            return "Hợp đồng phải bắt đầu tối thiểu ngày hôm nay.";
        if(sqlNgayKetThuc.before(sqlNgayBatDau))
            return "Ngày kết thúc phải sau ngày bất đầu";
        if(sqlNgayBatDau.equals(ngayKetThuc))
            return "Ngày bắt đầu và ngày kết thúc phải khác nhau";
        
        return null;
    }
    
    public String ValidateHopDong(JComboBox maNhanVienBox, JDateChooser ngayBatDauChooser, JDateChooser ngayKetThucChooser){
        String error;
        
        error = ValidateMaNhanVien(maNhanVienBox);
        if(error != null) {
            maNhanVienBox.requestFocus();
            return error;
        }
         
        error = ValidateNgayBatDau_NgayKetThuc(ngayBatDauChooser, ngayKetThucChooser);
        if(error != null){
            ngayBatDauChooser.requestFocus();
            return error;
        }
        
        return null;
    }
    
    public HopDong_DTO ReturnHopDong(JComboBox maNhanVienBox, JDateChooser ngayBatDauChooser, JDateChooser ngayKetThucChooser){
        int maNhanVien = Integer.parseInt(maNhanVienBox.getSelectedItem().toString());
        
        java.util.Date ngayBatDau = ngayBatDauChooser.getDate();
        java.util.Date ngayKetThuc = ngayKetThucChooser.getDate();
        
        Date sqlNgayBatDau = new Date(ngayBatDau.getTime());
        Date sqlNgayKetThuc = new Date(ngayKetThuc.getTime());
        
        HopDong_DTO hopDong = new HopDong_DTO(maNhanVien, sqlNgayBatDau, sqlNgayKetThuc);
        
        return hopDong;
    }
    
    //
    // Lương
    //
    
    public String ValidateLuongCoBan(JTextField luongCoBanField){
        String luongCoBanText = luongCoBanField.getText();
        
        if(ValidateIsEmpty(luongCoBanText))
            return "Lương cơ bản không được để trống";
  
        if(ValidateIsInteger(luongCoBanText) == false)
            return "Lương cơ bản phải là số";
        
        if(ValidateIsStartWithWhitespace(luongCoBanText))
            return "Lương cơ bản không được bắt đầu bằng dấu cách";
        
        int luongCoBan = Integer.parseInt(luongCoBanText);
        
        if(luongCoBan <= 0)
            return "Lương cơ bản phải lớn hơn 0";
        
        return null;
    }
    
    public String ValidateSoGioCoBan(JTextField soGioCoBanField){
        String soGioCoBanText = soGioCoBanField.getText();
        
        if(ValidateIsEmpty(soGioCoBanText))
            return "Số giờ cơ bản không được để trống";
  
        if(ValidateIsInteger(soGioCoBanText) == false)
            return "Số giờ cơ bản phải là số";
        
        if(ValidateIsStartWithWhitespace(soGioCoBanText))
            return "Số giờ cơ bản không được bắt đầu bằng dấu cách";
        
        int luongCoBan = Integer.parseInt(soGioCoBanText);
        
        if(luongCoBan <= 0)
            return "Số giờ cơ bản phải lớn hơn 0";
        
        
        return null;
    }
    
    public String ValidateNgayNhanLuong(JDateChooser ngayNhanLuongChooser){
        java.util.Date ngayNhanLuong = ngayNhanLuongChooser.getDate();
        Date sqlNgayNhanLuong = new Date(ngayNhanLuong.getTime());
        
        if(sqlNgayNhanLuong == null)
            return "Ngày nhận lương không được để trống";
        
        return null;
    }
    
    public String ValidateLuong(JComboBox maNhanVienBox, JTextField luongCoBanField, JTextField soGioCoBanField, JDateChooser ngayNhanLuongChooser){
        String error;
        
        error = ValidateMaNhanVien(maNhanVienBox);
        if(error != null) {
            maNhanVienBox.requestFocus();
            return error;
        }
         
        error = ValidateLuongCoBan(luongCoBanField);
        if(error != null){
            luongCoBanField.requestFocus();
            return error;
        }
        
        error = ValidateSoGioCoBan(soGioCoBanField);
        if(error != null){
            soGioCoBanField.requestFocus();
            return error;
        }
        
        error = ValidateNgayNhanLuong(ngayNhanLuongChooser);
        if(error != null){
            ngayNhanLuongChooser.requestFocus();
            return error;
        }
        
        return null;
    }
    
    public Luong_DTO ReturnLuong(JComboBox maNhanVienBox, JTextField luongCoBanField, JTextField soGioCoBanField, JDateChooser ngayNhanLuongChooser){
        int maNhanVien = Integer.parseInt(maNhanVienBox.getSelectedItem().toString());
        int luongCoBan = Integer.parseInt(luongCoBanField.getText());
        int soGioCoBan = Integer.parseInt(soGioCoBanField.getText());
        
        java.util.Date ngayNhanLuong = ngayNhanLuongChooser.getDate();
        Date sqlNgayNhanLuong = new Date(ngayNhanLuong.getTime());
        
        Luong_DTO luong = new Luong_DTO(maNhanVien, luongCoBan, soGioCoBan, sqlNgayNhanLuong);
        
        return luong;
    }
    
    //
    // Chấm công
    //
    
    public String ValidateNgayChamCong(JDateChooser ngayChamCongChooser){
        
        java.util.Date ngayChamCong = ngayChamCongChooser.getDate();
        Date sqlNgayChamCong = new Date(ngayChamCong.getTime());
                     
        LocalDate localNgayChamCong = sqlNgayChamCong.toLocalDate();
        LocalDate now = LocalDate.now();

        if (localNgayChamCong.equals(now) == false)
            return "Ngày chấm công phải trong ngày";
        
        
        return null;
    }
    
    public String ValidateThoiGianVao_ThoiGianRa(JSpinner thoiGianVaoSpinner, JSpinner thoiGianRaSpinner){
        java.util.Date thoiGianVao = (java.util.Date) thoiGianVaoSpinner.getValue();
        Time sqlThoiGianVao = new Time(thoiGianVao.getTime());

        java.util.Date thoiGianRa = (java.util.Date) thoiGianRaSpinner.getValue();
        Time sqlThoiGianRa = new Time(thoiGianRa.getTime());
        
        if(sqlThoiGianVao.after(thoiGianRa))
            return "Thời gian vào phải trước thời gian ra";
        if(sqlThoiGianVao.equals(thoiGianRa))
            return "Thời gian vào và thời gian ra phải khác nhau";
        
        
        return null;
    }
    
    public String ValidateChamCong(JComboBox maNhanVienBox, JDateChooser ngayChamCongChooser, JSpinner thoiGianVaoSpinner, JSpinner thoiGianRaSpinner){
        String error;
        
        error = ValidateMaNhanVien(maNhanVienBox);
        if(error != null) {
            maNhanVienBox.requestFocus();
            return error;
        }
         
        error = ValidateNgayChamCong(ngayChamCongChooser);
        if(error != null){
            ngayChamCongChooser.requestFocus();
            return error;
        }
        
        error = ValidateThoiGianVao_ThoiGianRa(thoiGianVaoSpinner, thoiGianRaSpinner);
        if(error != null){
            thoiGianVaoSpinner.requestFocus();
            return error;
        }
        
        return null;
    }
    
    public ChamCong_DTO ReturnChamCong(JComboBox maNhanVienBox, JDateChooser ngayChamCongChooser, JSpinner thoiGianVaoSpinner, JSpinner thoiGianRaSpinner){
        int maNhanVien = Integer.parseInt(maNhanVienBox.getSelectedItem().toString());
        java.util.Date ngayChamCong = ngayChamCongChooser.getDate();
        Date sqlNgayChamCong = new Date(ngayChamCong.getTime());
        
        java.util.Date thoiGianVao = (java.util.Date) thoiGianVaoSpinner.getValue();
        Time sqlThoiGianVao = new Time(thoiGianVao.getTime());

        java.util.Date thoiGianRa = (java.util.Date) thoiGianRaSpinner.getValue();
        Time sqlThoiGianRa = new Time(thoiGianRa.getTime());
        
        ChamCong_DTO chamCong = new ChamCong_DTO(maNhanVien, sqlNgayChamCong, sqlThoiGianVao, sqlThoiGianRa);
        
        return chamCong;
    }
}
