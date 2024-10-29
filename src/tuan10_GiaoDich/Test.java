package tuan10_GiaoDich;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QuanLyGiaoDich qlgd = new QuanLyGiaoDich();
        
        // nhapCung
        qlgd.them(new GiaoDichVang("GDV001", "15/03/2024", 1500000000, 10, "9999"));
        qlgd.them(new GiaoDichVang("GDV002", "16/03/2024", 800000000, 5, "999"));
        qlgd.them(new GiaoDichTienTe("GDTT001", "15/03/2024", 2000000000, 100, 24500, "USD"));
        
        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Thêm giao dịch");
            System.out.println("2. Xóa giao dịch");
            System.out.println("3. Sửa giao dịch");
            System.out.println("4. Xem danh sách");
            System.out.println("5. Xem tổng số lượng");
            System.out.println("6. Xem trung bình thành tiền tiền tệ");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            
            int chon = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng new line

            if (chon == 0) break;

            switch (chon) {
                case 1:
                    System.out.println("\nThêm giao dịch:");
                    System.out.println("1. Giao dịch vàng");
                    System.out.println("2. Giao dịch tiền tệ");
                    System.out.print("Chọn loại giao dịch: ");
                    int loai = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Nhập mã giao dịch: ");
                    String maGD = scanner.nextLine();
                    System.out.print("Nhập ngày giao dịch (dd/MM/yyyy): ");
                    String ngayGD = scanner.nextLine();
                    System.out.print("Nhập đơn giá: ");
                    double donGia = scanner.nextDouble();
                    System.out.print("Nhập số lượng: ");
                    int soLuong = scanner.nextInt();
                    scanner.nextLine();

                    if (loai == 1) {
                        System.out.print("Nhập loại vàng: ");
                        String loaiVang = scanner.nextLine();
                        qlgd.them(new GiaoDichVang(maGD, ngayGD, donGia, soLuong, loaiVang));
                    } else {
                        System.out.print("Nhập tỉ giá: ");
                        double tiGia = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Nhập loại tiền tệ (VND/USD/EUR): ");
                        String loaiTienTe = scanner.nextLine();
                        qlgd.them(new GiaoDichTienTe(maGD, ngayGD, donGia, soLuong, tiGia, loaiTienTe));
                    }
                    System.out.println("Thêm thành công!");
                    break;

                case 2:
                    System.out.print("Nhập mã giao dịch cần xóa: ");
                    maGD = scanner.nextLine();
                    if (qlgd.xoa(maGD)) {
                        System.out.println("Xóa thành công!");
                    } else {
                        System.out.println("Không tìm thấy giao dịch!");
                    }
                    break;

                case 3:
                    System.out.print("Nhập mã giao dịch cần sửa: ");
                    maGD = scanner.nextLine();
                    GiaoDich gd = qlgd.timKiem(maGD);
                    
                    if (gd != null) {
                        System.out.print("Nhập ngày giao dịch mới: ");
                        String ngayMoi = scanner.nextLine();
                        System.out.print("Nhập đơn giá mới: ");
                        double donGiaMoi = scanner.nextDouble();
                        System.out.print("Nhập số lượng mới: ");
                        int soLuongMoi = scanner.nextInt();
                        scanner.nextLine();

                        gd.setNgayGD(ngayMoi);
                        gd.setDonGia(donGiaMoi);
                        gd.setSoLuong(soLuongMoi);

                        if (gd instanceof GiaoDichVang) {
                            System.out.print("Nhập loại vàng mới: ");
                            String loaiVangMoi = scanner.nextLine();
                            ((GiaoDichVang) gd).setLoaiVang(loaiVangMoi);
                        } else if (gd instanceof GiaoDichTienTe) {
                            System.out.print("Nhập tỉ giá mới: ");
                            double tiGiaMoi = scanner.nextDouble();
                            scanner.nextLine();
                            System.out.print("Nhập loại tiền tệ mới: ");
                            String loaiTienTeMoi = scanner.nextLine();
                            ((GiaoDichTienTe) gd).setTiGia(tiGiaMoi);
                            ((GiaoDichTienTe) gd).setLoaiTienTe(loaiTienTeMoi);
                        }
                        System.out.println("Sửa thành công!");
                    } else {
                        System.out.println("Không tìm thấy giao dịch!");
                    }
                    break;

                case 4:
                    System.out.println("\nDanh sách giao dịch:");
                    System.out.println("Mã GD | Ngày GD | Đơn giá | Số lượng | Loại | Thành tiền");
                    for (GiaoDich giaoDich : qlgd.getDanhSach()) {
                        if (giaoDich instanceof GiaoDichVang) {
                            GiaoDichVang gdv = (GiaoDichVang) giaoDich;
                            System.out.printf("%s | %s | %.0f | %d | Vàng %s | %.0f%n",
                                gdv.getMaGD(), gdv.getNgayGD(), gdv.getDonGia(),
                                gdv.getSoLuong(), gdv.getLoaiVang(), gdv.tinhThanhTien());
                        } else if (giaoDich instanceof GiaoDichTienTe) {
                            GiaoDichTienTe gdtt = (GiaoDichTienTe) giaoDich;
                            System.out.printf("%s | %s | %.0f | %d | %s | %.0f%n",
                                gdtt.getMaGD(), gdtt.getNgayGD(), gdtt.getDonGia(),
                                gdtt.getSoLuong(), gdtt.getLoaiTienTe(), gdtt.tinhThanhTien());
                        }
                    }
                    break;

                case 5:
                    System.out.println("\nTổng số lượng:");
                    System.out.println("Giao dịch vàng: " + qlgd.tinhTongSoLuongVang());
                    System.out.println("Giao dịch tiền tệ: " + qlgd.tinhTongSoLuongTienTe());
                    break;

                case 6:
                    System.out.printf("\nTrung bình thành tiền giao dịch tiền tệ: %.0f%n",
                        qlgd.tinhTrungBinhThanhTienTienTe());
                    break;

                default:
                    System.out.println("Chức năng không hợp lệ!");
            }
        }
        
    }
}





