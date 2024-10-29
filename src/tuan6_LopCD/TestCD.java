package tuan6_LopCD;

import java.util.Scanner;

public class TestCD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DanhSachCD danhSach = new DanhSachCD(10); // Kích thước mảng là 10
        int luaChon;

        do {
            System.out.println("Menu:");
            System.out.println("1. Thêm CD");
            System.out.println("2. Hiển thị số lượng CD");
            System.out.println("3. Tính tổng giá thành");
            System.out.println("4. Sắp xếp giảm dần theo giá thành");
            System.out.println("5. Sắp xếp tăng dần theo tựa CD");
            System.out.println("6. Xuất toàn bộ danh sách");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            luaChon = scanner.nextInt();

            switch (luaChon) {
                case 1:
                    System.out.print("Nhập mã CD: ");
                    int maCD = scanner.nextInt();
                    scanner.nextLine(); // Đọc dòng còn lại
                    System.out.print("Nhập tựa CD: ");
                    String tuaCD = scanner.nextLine();
                    System.out.print("Nhập ca sỹ: ");
                    String caSy = scanner.nextLine();
                    System.out.print("Nhập số bài hát: ");
                    int soBaiHat = scanner.nextInt();
                    System.out.print("Nhập giá thành: ");
                    double giaThanh = scanner.nextDouble();

                    CD cd = new CD(maCD, tuaCD, caSy, soBaiHat, giaThanh);
                    if (danhSach.themCD(cd)) {
                        System.out.println("Thêm CD thành công!");
                    } else {
                        System.out.println("Mã CD đã tồn tại hoặc không còn chỗ trống.");
                    }
                    break;

                case 2:
                    System.out.println("Số lượng CD: " + danhSach.soLuongCD());
                    break;

                case 3:
                    System.out.println("Tổng giá thành: " + danhSach.tongGiaThanh());
                    break;

                case 4:
                    danhSach.sapXepGiamDanTheoGia();
                    System.out.println("Đã sắp xếp giảm dần theo giá thành.");
                    break;

                case 5:
                    danhSach.sapXepTangDanTheoTua();
                    System.out.println("Đã sắp xếp tăng dần theo tựa CD.");
                    break;

                case 6:
                    xuatDanhSach(danhSach);
                    break;

                case 0:
                    System.out.println("Thoát chương trình.");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (luaChon != 0);
    }
    private static void themCD(Scanner scanner, DanhSachCD danhSach) {
        System.out.print("Nhập mã CD: ");
        int maCD = scanner.nextInt();
        scanner.nextLine(); // Đọc dòng còn lại
        System.out.print("Nhập tựa CD: ");
        String tuaCD = scanner.nextLine();
        System.out.print("Nhập ca sỹ: ");
        String caSy = scanner.nextLine();
        System.out.print("Nhập số bài hát: ");
        int soBaiHat = scanner.nextInt();
        System.out.print("Nhập giá thành: ");
        double giaThanh = scanner.nextDouble();

        CD cd = new CD(maCD, tuaCD, caSy, soBaiHat, giaThanh);
        if (danhSach.themCD(cd)) {
            System.out.println("Thêm CD thành công!");
        } else {
            System.out.println("Mã CD đã tồn tại hoặc không còn chỗ trống.");
        }
    }

    // Phương thức xuất danh sách CD
    private static void xuatDanhSach(DanhSachCD danhSach) {
        System.out.printf("%-10s | %-20s | %-15s | %-10s | %-10s%n", 
                          "Mã CD", "Tựa CD", "Ca Sỹ", "Số Bài Hát", "Giá Thành");
        for (int i = 0; i < danhSach.soLuongCD(); i++) {
            danhSach.getDsCD()[i].xuatBang();
        }
    }
}
