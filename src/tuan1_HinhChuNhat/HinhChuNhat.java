package tuan1_HinhChuNhat;

import java.util.Scanner;

class HinhChuNhat {
    // Attributes
    private double chieuDai;
    private double chieuRong;

    // Phương thức thiết lập chiều dài
    public void setChieuDai(double chieuDai) {
        this.chieuDai = chieuDai;
    }

    // Phương thức lấy chiều dài
    public double getChieuDai() {
        return chieuDai;
    }

    // Phương thức thiết lập chiều rộng
    public void setChieuRong(double chieuRong) {
        this.chieuRong = chieuRong;
    }

    // Phương thức lấy chiều rộng
    public double getChieuRong() {
        return chieuRong;
    }

    // Phương thức tính diện tích
    public double tinhDienTich() {
        return chieuDai * chieuRong;
    }

    // Phương thức tính chu vi
    public double tinhChuVi() {
        return 2 * (chieuDai + chieuRong);
    }

    // Phương thức toString
    @Override
    public String toString() {
        return String.format("Chiều dài: %.2f, Chiều rộng: %.2f, Diện tích: %.2f, Chu vi: %.2f",
                chieuDai, chieuRong, tinhDienTich(), tinhChuVi());
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HinhChuNhat hinhChuNhat = new HinhChuNhat();

        // Nhập chiều dài và chiều rộng từ bàn phím
        System.out.print("Nhập chiều dài: ");
        double chieuDai = scanner.nextDouble();
        hinhChuNhat.setChieuDai(chieuDai);

        System.out.print("Nhập chiều rộng: ");
        double chieuRong = scanner.nextDouble();
        hinhChuNhat.setChieuRong(chieuRong);

        // Xuất thông tin ra dạng bảng
        System.out.printf("%-10s | %-10s | %-10s | %-10s%n", "Chieu dai", "Chieu rong", "Chu vi", "Dien tich");
        System.out.printf("%-10.2f | %-10.2f | %-10.2f | %-10.2f%n", 
                          hinhChuNhat.getChieuDai(), 
                          hinhChuNhat.getChieuRong(), 
                          hinhChuNhat.tinhChuVi(), 
                          hinhChuNhat.tinhDienTich());
    }
}
	


