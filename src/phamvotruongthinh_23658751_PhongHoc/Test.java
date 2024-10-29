package phamvotruongthinh_23658751_PhongHoc;

import java.util.Scanner;

import tuan11_QLPhongHoc.PhongHoc;
import tuan11_QLPhongHoc.PhongLyThuyet;
import tuan11_QLPhongHoc.PhongMayTinh;
import tuan11_QLPhongHoc.PhongThiNghiem;
import tuan11_QLPhongHoc.QuanLyPhongHoc;

public class Test {
    private static QuanLyPhongHoc quanLy = new QuanLyPhongHoc();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            handleChoice(choice);
        } while (choice != 0);
    }

    private static void displayMenu() {
        System.out.println("\n===== MENU =====");
        System.out.println("1. Thêm phòng học");
        System.out.println("2. Tìm kiếm phòng học");
        System.out.println("3. In danh sách phòng học");
        System.out.println("4. In danh sách phòng học đạt chuẩn");
        System.out.println("5. Sắp xếp danh sách theo dãy nhà");
        System.out.println("6. Sắp xếp danh sách theo diện tích giảm dần");
        System.out.println("7. Sắp xếp danh sách theo số bóng đèn");
        System.out.println("8. Cập nhật số máy tính");
        System.out.println("9. Xóa phòng học");
        System.out.println("10. In tổng số phòng học");
        System.out.println("11. In danh sách phòng máy có 60 máy");
        System.out.println("12. Nhập cứng dữ liệu");
        System.out.println("0. Thoát");
        System.out.print("Nhập lựa chọn của bạn: ");
    }

    private static void handleChoice(int choice) {
        switch (choice) {
            case 1:
                themPhongHoc();
                break;
            case 2:
                timKiemPhongHoc();
                break;
            case 3:
                inDanhSachDangBang();
                break;
            case 4:
                inDanhSachPhongHocDatChuan();
                break;
            case 5:
                quanLy.sapXepTheoDayNha();
                System.out.println("Đã sắp xếp theo dãy nhà.");
                break;
            case 6:
                quanLy.sapXepTheoDienTichGiamDan();
                System.out.println("Đã sắp xếp theo diện tích giảm dần.");
                break;
            case 7:
                quanLy.sapXepTheoSoBongDen();
                System.out.println("Đã sắp xếp theo số bóng đèn.");
                break;
            case 8:
                capNhatSoMayTinh();
                break;
            case 9:
                xoaPhongHoc();
                break;
            case 10:
                System.out.println("Tổng số phòng học: " + quanLy.tongSoPhongHoc());
                break;
            case 11:
                inDanhSachPhongMay60May();
                break;
            case 12:
            	nhapCung();
            	System.out.println("Đã nhập cứng dữ liệu.");
            	break;
            case 0:
                System.out.println("Tạm biệt!");
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
        }
    }
    private static void themPhongHoc() {
        System.out.println("Nhập thông tin phòng học:");
        System.out.print("Mã phòng: ");
        String maPhong = scanner.nextLine();
        System.out.print("Dãy nhà: ");
        String dayNha = scanner.nextLine();
        System.out.print("Diện tích: ");
        double dienTich = scanner.nextDouble();
        System.out.print("Số bóng đèn: ");
        int soBongDen = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Chọn loại phòng (1: Lý thuyết, 2: Máy tính, 3: Thí nghiệm): ");
        int loaiPhong = scanner.nextInt();
        scanner.nextLine();
        PhongHoc phongHoc = null;
        switch (loaiPhong) {
            case 1:
                System.out.print("Máy chiếu (true/false): ");
                boolean coMayChieu = scanner.nextBoolean();
                phongHoc = new PhongLyThuyet(maPhong, dayNha, dienTich, soBongDen, coMayChieu);
                break;
            case 2:
                System.out.print("Số máy tính: ");
                int soMayTinh = scanner.nextInt();
                phongHoc = new PhongMayTinh(maPhong, dayNha, dienTich, soBongDen, soMayTinh);
                break;
            case 3:
                System.out.print("Có bồn rửa (true/false): ");
                boolean coBonRua = scanner.nextBoolean();
                phongHoc = new PhongThiNghiem(maPhong, dayNha, dienTich, soBongDen, coBonRua);
                break;
            default:
                System.out.println("Loại phòng không hợp lệ.");
                return;
        }

        if (quanLy.themPhongHoc(phongHoc)) {
            System.out.println("Thêm phòng học thành công.");
        } else {
            System.out.println("Thêm phòng học thất bại. Mã phòng đã tồn tại.");
        }
    }

    private static void timKiemPhongHoc() {
        System.out.print("Nhập mã phòng cần tìm: ");
        String maPhong = scanner.nextLine();
        PhongHoc phong = quanLy.timPhongHoc(maPhong);
        if (phong != null) {
            System.out.println("Thông tin phòng học:");
            System.out.println(phong);
        } else {
            System.out.println("Không tìm thấy phòng học với mã " + maPhong);
        }
    }

    private static void capNhatSoMayTinh() {
        System.out.print("Nhập mã phòng cần cập nhật: ");
        String maPhong = scanner.nextLine();
        System.out.print("Nhập số máy tính mới: ");
        int soMayTinhMoi = scanner.nextInt();
        quanLy.capNhatSoMayTinh(maPhong, soMayTinhMoi);
    }

    private static void xoaPhongHoc() {
        System.out.print("Nhập mã phòng cần xóa: ");
        String maPhong = scanner.nextLine();
        System.out.print("Bạn có chắc chắn muốn xóa phòng học này? (y/n): ");
        String confirm = scanner.nextLine();
        if (confirm.equalsIgnoreCase("y")) {
            if (quanLy.xoaPhongHoc(maPhong)) {
                System.out.println("Đã xóa phòng học thành công.");
            } else {
                System.out.println("Không tìm thấy phòng học với mã " + maPhong);
            }
        } else {
            System.out.println("Hủy xóa phòng học.");
        }
    }
    private static void nhapCung() {
        quanLy.themPhongHoc(new PhongLyThuyet("LT01", "A", 50, 5, true));
        quanLy.themPhongHoc(new PhongMayTinh("MT01", "B", 60, 6, 60));
        quanLy.themPhongHoc(new PhongThiNghiem("TN01", "C", 40, 4, true));
        quanLy.themPhongHoc(new PhongLyThuyet("LT02", "A", 45, 4, false));
        quanLy.themPhongHoc(new PhongMayTinh("MT02", "B", 70, 7, 30));
        
        System.out.println("Đã nhập cứng dữ liệu.");
    }
    private static void inDanhSachDangBang() {
        System.out.println("+---------+--------+------------+--------------+-------------------+");
        System.out.println("| Mã Phòng| Dãy Nhà| Diện Tích  | Số Bóng Đèn  | Thông Tin Thêm    |");
        System.out.println("+---------+--------+------------+--------------+-------------------+");
        
        for (PhongHoc phong : quanLy.getDanhSachPhongHoc()) {
            String thongTinThem = "";
            if (phong instanceof PhongLyThuyet) {
                thongTinThem = "Máy chiếu: " + (((PhongLyThuyet) phong).isCoMayChieu() ? "Có" : "Không");
            } else if (phong instanceof PhongMayTinh) {
                thongTinThem = "Số máy tính: " + ((PhongMayTinh) phong).getSoMayTinh();
            } else if (phong instanceof PhongThiNghiem) {
                thongTinThem = "Bồn rửa: " + (((PhongThiNghiem) phong).isCoBonRua() ? "Có" : "Không");
            }
            
            System.out.printf("| %-7s | %-6s | %-10.2f | %-12d | %-17s |\n",
                    phong.getMaPhong(), phong.getDayNha(), phong.getDienTich(),
                    phong.getSoBongDen(), thongTinThem);
        }
        
        System.out.println("+---------+--------+------------+--------------+-------------------+");
    }
    private static void inDanhSachPhongMay60May() {
        for (PhongHoc phong : quanLy.getDanhSachPhongHoc()) {
            if (phong instanceof PhongMayTinh && ((PhongMayTinh) phong).getSoMayTinh() == 60) {
                System.out.println(phong);
            }
        }
    }
    private static void inDanhSachPhongHoc() {
        for (PhongHoc phong : quanLy.getDanhSachPhongHoc()) {
            System.out.println(phong);
        }
    }

    private static void inDanhSachPhongHocDatChuan() {
        for (PhongHoc phong : quanLy.getDanhSachPhongHoc()) {
            if (phong.datChuan()) {
                System.out.println(phong);
            }
        }
    }
}

    
    

	
	
	
	
	
	
