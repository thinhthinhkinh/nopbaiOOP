package tuan3_QLThucPham;

import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class HangThucPham {
	private String maHang;
    private String tenHang;
    private double donGia;
    private Date ngaySanXuat;
    private Date ngayHetHan;
    
    // Constructor đầy đủ tham số
    public HangThucPham(String maHang, String tenHang, double donGia, 
            Date ngaySanXuat, Date ngayHetHan) {
        if (maHang != null && !maHang.trim().isEmpty()) {
            this.maHang = maHang;
        } else {
            this.maHang = "DEFAULT";
        }
        setTenHang(tenHang);
        setDonGia(donGia);
        setNgaySanXuat(ngaySanXuat);
        setNgayHetHan(ngayHetHan);
    }
    
    // Constructor với tham số là mã hàng
    public HangThucPham(String maHang) {
        if (maHang != null && !maHang.trim().isEmpty()) {
            this.maHang = maHang;
        } else {
            this.maHang = "DEFAULT";
        }
        // Khởi tạo giá trị mặc định cho các thuộc tính khác
        this.tenHang = "xxx";
        this.donGia = 0;
        this.ngaySanXuat = new Date();
        this.ngayHetHan = new Date();
    }
    
    // Getters
    public String getMaHang() {
        return maHang;
    }
    
    public String getTenHang() {
        return tenHang;
    }
    
    public double getDonGia() {
        return donGia;
    }
    
    public Date getNgaySanXuat() {
        return ngaySanXuat;
    }
    
    public Date getNgayHetHan() {
        return ngayHetHan;
    }
    
    // Setters với ràng buộc
    public void setTenHang(String tenHang) {
        if (tenHang != null && !tenHang.trim().isEmpty()) {
            this.tenHang = tenHang;
        } else {
            this.tenHang = "xxx";
        }
    }
    
    public void setDonGia(double donGia) {
        if (donGia > 0) {
            this.donGia = donGia;
        } else {
            this.donGia = 0;
        }
    }
    
    public void setNgaySanXuat(Date ngaySanXuat) {
        if (ngaySanXuat != null) {
            this.ngaySanXuat = ngaySanXuat;
        } else {
            this.ngaySanXuat = new Date();
        }
    }
    
    public void setNgayHetHan(Date ngayHetHan) {
        if (ngayHetHan != null && ngayHetHan.after(ngaySanXuat)) {
            this.ngayHetHan = ngayHetHan;
        } else {
            // Nếu ngày hết hạn không hợp lệ, set mặc định là 1 năm sau ngày sản xuất
            Calendar c = Calendar.getInstance();
            c.setTime(this.ngaySanXuat);
            c.add(Calendar.YEAR, 1);
            this.ngayHetHan = c.getTime();
        }
    }
    
    // Kiểm tra hết hạn
    public boolean daHetHan() {
        Date hienTai = new Date();
        return hienTai.after(ngayHetHan);
    }
    
    // Phương thức toString với định dạng yêu cầu
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        DecimalFormat df = new DecimalFormat("#,###");
        return String.format("Mã hàng: %s\nTên hàng: %s\nĐơn giá: %s\n" +
                "Ngày sản xuất: %s\nNgày hết hạn: %s",
                maHang,
                tenHang,
                df.format(donGia),
                sdf.format(ngaySanXuat),
                sdf.format(ngayHetHan));
    }
}
