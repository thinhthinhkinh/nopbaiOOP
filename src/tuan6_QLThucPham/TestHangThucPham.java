package tuan6_QLThucPham;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TestHangThucPham {
    private static final Scanner sn = new Scanner(System.in);
    private static final DSHangThucPham ds = new DSHangThucPham();
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

  //xuất tiêu đề
    public static void xuatTieuDe() {
        System.out.printf("%-7s %-20s %-15s %-20s %-20s %n", "Mã Hàng", "Tên hàng", "Đơn giá", "Ngày sản xuất", "Ngày hết hạn");
    }
    
    public static void main(String[] args) throws Exception {
        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Nhập cứng hàng thực phẩm");
            System.out.println("2. Nhập hàng thực phẩm mới");
            System.out.println("3. Xuất hàng thực phẩm hiện có");
            System.out.println("4. Kiểm tra hạn sử dụngg của hàng hóa");
            System.out.println("5. Thoát");
            System.out.print("Chọn một tùy chọn (1-5): ");
            int option = sn.nextInt();
            sn.nextLine(); // Đọc dòng còn lại

            switch (option) {
                case 1:
                	nhapCung(); 
                    break;

                case 2:
                	themHangThucPham();
                    break;

                case 3:
                	xuatDanhSachHangTP();
                    break;

                case 4:
                	kiemTraHSD();
                    break;

                case 5:
                    System.out.println("Thoát chương trình.");
                    sn.close();
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    public static void nhapCung() throws Exception {
        HangThucPham[] hangMau = {
            new HangThucPham("TP001", "Gạo", 20000, sdf.parse("01/01/2023"), sdf.parse("01/01/2024")),
            new HangThucPham("TP002", "Mì tôm", 5000, sdf.parse("15/05/2023"), sdf.parse("15/05/2024")),
            new HangThucPham("TP003", "Nước ngọt", 10000, sdf.parse("10/06/2023"), sdf.parse("10/06/2024")),
            new HangThucPham("TP004", "Gạo", 20000, sdf.parse("01/01/2023"), sdf.parse("01/01/2024")),
            new HangThucPham("TP005", "Mì tôm", 5000, sdf.parse("15/05/2023"), sdf.parse("15/05/2024")),
            new HangThucPham("TP006", "Nước ngọt", 10000, sdf.parse("10/06/2023"), sdf.parse("10/06/2024")),
            new HangThucPham("TP007", "Gạo", 20000, sdf.parse("01/01/2023"), sdf.parse("01/01/2024")),
            new HangThucPham("TP008", "Mì tôm", 5000, sdf.parse("15/05/2023"), sdf.parse("15/05/2024")),
            new HangThucPham("TP009", "Nước ngọt", 10000, sdf.parse("10/06/2023"), sdf.parse("10/06/2024")),
            new HangThucPham("TP0010", "Gạo", 20000, sdf.parse("01/01/2023"), sdf.parse("01/01/2024")),
            new HangThucPham("TP0011", "Mì tôm", 5000, sdf.parse("15/05/2023"), sdf.parse("15/05/2024")),
            new HangThucPham("TP0012", "Nước ngọt", 10000, sdf.parse("10/06/2023"), sdf.parse("10/06/2024"))
        };

        for (HangThucPham hang : hangMau) {
            ds.them(hang);
        }
    }

    public static void themHangThucPham() {
        System.out.println("Nhập thông tin hàng thực phẩm mới:");
        
        // Nhập mã hàng
        String maHang = inputString("Mã hàng: ");
        
        // Nhập tên hàng
        String tenHang = inputString("Tên hàng: ");
        
        // Nhập đơn giá
        double donGia = inputDouble("Đơn giá: ");
        
        // Nhập ngày sản xuất
        Date ngaySanXuat = inputDate("Ngày sản xuất (dd/MM/yyyy): ");
        
        // Nhập ngày hết hạn
        Date ngayHetHan;
        do {
            ngayHetHan = inputDate("Ngày hết hạn (dd/MM/yyyy): ");
            if (ngayHetHan.before(ngaySanXuat)) {
                System.out.println("Ngày hết hạn phải sau ngày sản xuất. Vui lòng nhập lại.");
                ngayHetHan = null; // Reset the value to keep prompting
            }
        } while (ngayHetHan == null); // Continue prompting until valid date is entered

        // Tạo đối tượng HangThucPham và thêm vào danh sách
        HangThucPham hang = new HangThucPham(maHang, tenHang, donGia, ngaySanXuat, ngayHetHan);
        try {
            ds.them(hang);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void xuatDanhSachHangTP() {
        System.out.println("Danh sách hàng thực phẩm:");
        xuatTieuDe();
        ds.hienThiDanhSach();
    }

    public static void kiemTraHSD() {
        String maHang = inputString("Nhập mã hàng để kiểm tra HSD: ");
        HangThucPham hang = ds.timHang(maHang);
        if (hang != null) {
            if (hang.getNgayHetHan().before(new Date())) {
                System.out.println("Hàng hóa đã hết hạn sử dụng.");
            } else {
                System.out.println("Hàng Hóa này còn hạn dử dụng.");
            }
        } else {
            System.out.println("Không tìm thấy mã hàng!!!");
        }
    }

    public static String inputString(String prompt) {
        System.out.print(prompt);
        return sn.nextLine();
    }

    public static double inputDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(sn.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập một số hợp lệ.");
            }
        }
    }

    public static Date inputDate(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return sdf.parse(sn.nextLine());
            } catch (ParseException e) {
                System.out.println("Ngày không hợp lệ. Vui lòng nhập lại.");
            }
        }
    }
}

