package tuan8_ThuVien;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        try {
            QuanLySach quanLySach = new QuanLySach();

            // Nhập dữ liệu mẫu (nhập cứng)
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            quanLySach.themData(new SachGiaoKhoa("GK001", sdf.parse("01/01/2023"), 100000, 10, "NXB A", "mới"));
            quanLySach.themData(new SachGiaoKhoa("GK002", sdf.parse("01/02/2023"), 80000, 5, "NXB B", "cũ"));
            quanLySach.themData(new SachThamKhao("TK001", sdf.parse("01/03/2023"), 120000, 7, "NXB C", 20000));

            // Nhập dữ liệu từ người dùng (nhập mềm)
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhập số lượng sách muốn thêm: ");
            int n = scanner.nextInt();
            scanner.nextLine(); // Đọc dòng còn lại

            for (int i = 0; i < n; i++) {
                System.out.print("Nhập mã sách: ");
                String maSach = scanner.nextLine();
                System.out.print("Nhập ngày nhập (dd/MM/yyyy): ");
                Date ngayNhap = sdf.parse(scanner.nextLine());
                System.out.print("Nhập đơn giá: ");
                double donGia = scanner.nextDouble();
                System.out.print("Nhập số lượng: ");
                int soLuong = scanner.nextInt();
                scanner.nextLine(); // Đọc dòng còn lại
                System.out.print("Nhập nhà xuất bản: ");
                String nhaXuatBan = scanner.nextLine();
                System.out.print("Nhập tình trạng (mới/cũ): ");
                String tinhTrang = scanner.nextLine();

                // Thêm sách giáo khoa
                quanLySach.themData(new SachGiaoKhoa(maSach, ngayNhap, donGia, soLuong, nhaXuatBan, tinhTrang));
            }

            // Xuất thông tin
            System.out.printf("%-10s %-15s %-10s %-10s %-15s %-10s %-10s%n", 
                              "Mã Sách", "Ngày Nhập", "Đơn Giá", "Số Lượng", "Nhà Xuất Bản", "Tình Trạng", "Thành Tiền");
          

            for (Sach s : quanLySach.listSachs) {
                String ngayNhap = sdf.format(s.ngayNhap);
                String tinhTrang = (s instanceof SachGiaoKhoa) ? ((SachGiaoKhoa) s).tinhTrang : "";
                double thanhTien = s.thanhTien();
                
                System.out.printf("%-10s %-15s %-10.2f %-10d %-15s %-10s %-10.2f%n", 
                                  s.maSach, ngayNhap, s.donGia, s.soLuong, s.nhaXuatBan, tinhTrang, thanhTien);
            }

           
            System.out.printf("Tổng thành tiền: %.2f%n", quanLySach.tongThanhTien());
            System.out.printf("Trung bình đơn giá sách tham khảo: %.2f%n", quanLySach.trungBinhDonGiaSachThamKhao());

            List<Sach> sachGiaoKhoaNXB_A = quanLySach.sachGiaoKhoaNhaXuatBan("NXB A");
            System.out.println("Sách giáo khoa của NXB A:");
            for (Sach s : sachGiaoKhoaNXB_A) {
                System.out.println(s.getMaSach());
            }

            scanner.close(); // Đóng scanner

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
