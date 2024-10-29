package tuan4_ChuyenXe;

import java.util.Scanner;

public class KiemThuChuyenXe {
	static DanhSachChuyenXe DS = new DanhSachChuyenXe();
	static void Menu() {
		System.out.println("\t****************************************");
		System.out.println("\t**   Chương trình quản lí chuyến xe**");
		System.out.println("\t* 1. Nhập cứng*");
		System.out.println("\t* 2. Thêm 1 chuyến xe*");
		System.out.println("\t* 3. Xuất tổng doanh thu*");
		System.out.println("\t* 4. Xuất Danh sách All chuyến xe *");
		System.out.println("\t* 5. Xuất danh sách xe ngoại thành*");
		System.out.println("\t* 6.Xuất danh sách xe nội thành*");
		System.out.println("\t* 7. Thoát*");
		System.out.println("\t****************************************");
	}
	static void nhapCung() throws Exception {
		try{
			ChuyenXe nt = new NoiThanh("CX001", "Thinh Pham", 1, 300000, 3, 12.3);
			ChuyenXe nt1 = new NoiThanh("CX003", "Pham Vo Truong THinh", 1, 160000, 3, 12.3);
			ChuyenXe ngt = new NgoaiThanh("CX002", "Truong Thinh", 2, 900000, "Hòa nhơn", 12);
			ChuyenXe ngt1 = new NgoaiThanh("CX004", "Pham Thinh", 2, 800000, "An Nhơn", 12);
			DS.them(nt);
			DS.them(nt1);
			DS.them(ngt);
			DS.them(ngt1);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static String inputString(String thongBao) {
	    Scanner sc = new Scanner(System.in);
	    System.out.println(thongBao);
	    return sc.nextLine();
	}
	
	public static int inputInt(String thongBao) {
	    Scanner sc = new Scanner(System.in);
	    System.out.println(thongBao);
	    return sc.nextInt();
	}
	public static float inputDouble(String thongBao) {
		Scanner sc = new Scanner(System.in);
		System.out.println(thongBao);
	    return sc.nextFloat();
	}
	static ChuyenXe cXe; // khai báo toàn cục
	static ChuyenXe ThemMotXe() {
		try {
			String maChuyenXe, hoTen;
			int soXe;
			double doanhThu;
			maChuyenXe = inputString("Nhập mã chuyến xe:");
			int vt = DS.timKiemViTri(maChuyenXe);
			if (vt == -1) {  // không trùng
				hoTen = inputString("Nhập họ tên tài xế:");
				doanhThu = inputDouble("Nhập doanh thu:");
				soXe = inputInt("Nhập số xe:");
				System.out.println("Nhập xe nội thành [1] hoặc nhập xe ngoại thành [2]: ");
				int chon = new Scanner(System.in).nextInt(); // để nhập 1 hay khác 
				if (chon != 1) {
					String noiDen;
					int soNgayDiDuoc;
					noiDen = inputString("Nhập ni đươi đến:");
					soNgayDiDuoc = inputInt("Nhập số ngày đợc:");
					cXe = new NgoaiThanh(maChuyenXe, hoTen, soXe, doanhThu, noiDen, soNgayDiDuoc);
				} else {
					int soTuyen;
					double soKm;
					soTuyen = inputInt("Nhập vào số tuyến");
					soKm = inputInt("Nhập số km đi được: ");
					cXe = new NoiThanh(maChuyenXe, hoTen, soXe, doanhThu, soTuyen, soKm);
				}

			} else { // ngược của cái if tìm mã xe 
				return null;
			}

		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return cXe;

	}
	static void getDSXeNgoaiThanh() {
		for (NgoaiThanh xeNgoai : DS.getDSXeNgoaiThanh())
			System.out.println(xeNgoai);
	}

	static void getDSXeNoiThanh() {
		for (NoiThanh xeNoi : DS.getDSXeNoiThanh())
			System.out.println(xeNoi);

	}
	public static void xuatTieuDeNGT() {
	    System.out.printf("%9s %-30s %-10s %-20s %-20s %-10s\n", 
	                      "Mã Chuyến", "Họ Tên tài xế", "Số Xe", "Doanh Thu", "Nơi đến", "Số ngày đi");
	}
	public static void xuatTieuDeNT() {
	    System.out.printf("%-9s %-30s %-10s %-20s %-8s %-13s \n", 
	                      "Mã Chuyến", "Họ Tên tài xế", "Số Xe", "Doanh Thu",  "Số tuyến", "Số KM đi được");
	}

	public static void main(String[] args) throws Exception {
		int chon = -1;
		do {
			Menu();
			System.out.println("Nhập lựa chọn: ");
			chon = new Scanner(System.in).nextInt();
			switch (chon) {
			case 1:
				nhapCung();
				break;
			case 2:
				ChuyenXe xe = ThemMotXe();
				if (xe != null) {
					DS.them(xe);
					System.out.println("Thêm thành công");
				}
				else
					System.out.println("Thêm không thành công");
				break;
			case 3:
				System.out.println("Doanh thu la: " + DS.tinhDoanhThu());
				break;
			case 4:
				xuatTieuDeNGT();
				getDSXeNgoaiThanh();
				
				xuatTieuDeNT();
				getDSXeNoiThanh();
				break;
			case 5:
				xuatTieuDeNGT();
				getDSXeNgoaiThanh();
				break;
			case 6:
				xuatTieuDeNT();
				getDSXeNoiThanh();
				break;
			default:
				System.out.println("Cảm ơn bạn đã sử dụng chương trình");
			}
		} while (chon < 7);
	}
}
