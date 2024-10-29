package tuan3_QLThucPham;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class Test{
    public static void main(String[] args) {
        // Tạo các đối tượng Date để test
        Calendar cal = Calendar.getInstance();
        Date ngaySX = cal.getTime();
        
        cal.add(Calendar.MONTH, 3); // Thêm 3 tháng cho ngày hết hạn
        Date ngayHH = cal.getTime();
        
        // Test constructor đầy đủ tham số
        HangThucPham htp1 = new HangThucPham("TP001", "Mì gói", 3500, ngaySX, ngayHH);
        System.out.println(" Thông tin hàng thực phẩm 1 ");
        System.out.println(htp1);
        
        // Test constructor với mã hàng
        HangThucPham htp2 = new HangThucPham("TP002", "Cà phê", 60000, ngaySX, ngayHH);
        System.out.println("\n Thông tin hàng thực phẩm 2 ");
        System.out.println(htp2);
        
        // Test các ràng buộc
        HangThucPham htp3 = new HangThucPham("TP003", "Sữa TH", 24000, ngaySX, ngayHH);
        System.out.println("\n Thông tin hàng thực phẩm 3 ");
        System.out.println(htp3);
        
        // Test kiểm tra hết hạn
        System.out.println("\nKiểm tra hết hạn hàng thực phẩm 1: " + 
                (htp1.daHetHan() ? "Đã hết hạn" : "Chưa hết hạn"));
        System.out.println("\nKiểm tra hết hạn hàng thực phẩm 2: " + 
                (htp2.daHetHan() ? "Đã hết hạn" : "Chưa hết hạn"));
        System.out.println("\nKiểm tra hết hạn hàng thực phẩm 4: " + 
                (htp3.daHetHan() ? "Đã hết hạn" : "Chưa hết hạn"));
    }
}
