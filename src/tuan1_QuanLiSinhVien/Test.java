package tuan1_QuanLiSinhVien;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
        SinhVien sv1 = new SinhVien(1001, "Pham Vo Truong THinh", 8.5f, 9.0f);
        SinhVien sv2 = new SinhVien(1002, "Pham Thinh", 7.5f, 8.0f);
        
        // Tạo sv3 và nhập thông tin từ bàn phím
        SinhVien sv3 = new SinhVien();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Nhập thông tin cho sinh viên 3:");
        System.out.print("MSSV: ");
        sv3.setMaSV(scanner.nextInt());
        scanner.nextLine(); 
        
        System.out.print("Họ tên: ");
        sv3.setHoVaTen(scanner.nextLine());
        
        System.out.print("Điểm lý thuyết: ");
        sv3.setDiemLT(scanner.nextFloat());
        
        System.out.print("Điểm thực hành: ");
        sv3.setDiemTH(scanner.nextFloat());
        
        // In bảng danh sách sinh viên
        System.out.println("\nDANH SÁCH SINH VIÊN");
        System.out.println("==========================================================");
        System.out.printf("%-8s %-30s %-7s %-9s %-9s\n", 
            "MSSV", "Họ tên", "Điểm LT", "Điểm TH", "Điểm TB");
        System.out.println("----------------------------------------------------------");
        System.out.println(sv1.toString());
        System.out.println(sv2.toString());
        System.out.println(sv3.toString());
        System.out.println("==========================================================");
        
 
	}
}
