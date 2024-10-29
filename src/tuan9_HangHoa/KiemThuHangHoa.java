package tuan9_HangHoa;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Scanner;

public class KiemThuHangHoa {
	static Scanner sc = new Scanner(System.in);
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public static void nhapCung(DanhSachHangHoa ds) throws Exception {
	    // Hàng thực phẩm
	    HangHoa htp1 = new HangThucPham("HTP001", "Bánh Mì", 500000, 100, "HuynhHoa", LocalDate.parse("27/09/2024", dtf), LocalDate.parse("31/09/2024", dtf));
	    HangHoa htp2 = new HangThucPham("HTP002", "Sữa Tươi", 300000, 150, "Vinamilk", LocalDate.parse("15/10/2024", dtf), LocalDate.parse("01/11/2024", dtf));
	    HangHoa htp3 = new HangThucPham("HTP003", "Trứng Gà", 200000, 200, "Nông Trại ABC", LocalDate.parse("10/09/2024", dtf), LocalDate.parse("10/12/2024", dtf));
	    
	    // Hàng điện máy
	    HangHoa hdm1 = new HangDienMay("HDM001", "Tủ lạnh", 500000000, 4, 2, 4);
	    HangHoa hdm2 = new HangDienMay("HDM002", "Máy Giặt", 700000000, 2, 3, 8);
	    HangHoa hdm3 = new HangDienMay("HDM003", "Tivi", 800000000, 5, 2, 50);
	    
	    // Hàng sành sứ
	    HangHoa hss1 = new HangSanhSu("HSS001", "Lọ Sứ", 1200000, 2, "Việt Nam", LocalDate.parse("10/09/2024", dtf));
	    HangHoa hss2 = new HangSanhSu("HSS002", "Chén Sứ", 300000, 60, "Nhật Bản", LocalDate.parse("12/09/2024", dtf));
	    HangHoa hss3 = new HangSanhSu("HSS003", "Đĩa Sứ", 500000, 5, "Hàn Quốc", LocalDate.parse("15/09/2024", dtf));
	    
	    // Thêm vào danh sách
	    ds.ThemHH(htp1);
	    ds.ThemHH(htp2);
	    ds.ThemHH(htp3);
	    
	    ds.ThemHH(hdm1);
	    ds.ThemHH(hdm2);
	    ds.ThemHH(hdm3);
	    
	    ds.ThemHH(hss1);
	    ds.ThemHH(hss2);
	    ds.ThemHH(hss3);
	}

	public static int  nhapInt(String prompt) {
		System.out.println(prompt);
		int n = sc.nextInt();
		sc.nextLine();
		return n;
	}
	public static double nhapDouble(String prompt) {
		System.out.println(prompt);
		double n = sc.nextDouble();
		sc.nextLine();
		return n;
	}
	public static String nhapString(String prompt) {
		System.out.println(prompt);
		return sc.nextLine();
	}

    public static LocalDate nhapDate(String prompt) {
        while (true) {
            try {
                System.out.println(prompt);
                String dateStr = sc.nextLine();
                return LocalDate.parse(dateStr, dtf);
            } catch (DateTimeParseException e) {
                System.out.println("Ngày nhập không hợp lệ. Vui lòng nhập lại theo định dạng dd/MM/yyyy.");
            }
        }
    }
	
	public static void main(String[] args) throws Exception {
		DanhSachHangHoa ds = new DanhSachHangHoa();
		int choice = 0;
		do {
			System.out.println("\n-----------MENU------------\n"
				+ "1.Nhập Cứng\n"
				+ "2.Thêm hàng hóa mới\n"
				+ "3.In tất cả hàng hóa\n"
				+ "4.In danh sách hàng thực phẩm\n"
				+ "5.In danh sách hàng điện máy\n"
				+ "6.In danh sách hàng sành sứ\n"
				+ "7.Tìm kiếm hàng hóa\n"
				+ "8.Sắp xếp hàng hóa theo tên\n"
				+ "9.Sắp xếp hàng hóa theo số lượng tồn\n"
				+ "10.In ra các thực phẩm khó bán\n"
				+ "11.Xóa hàng hóa\n"
				+ "12.Sửa hàng hóa\n"
				+ "0.Thoát\n");
			
			choice = nhapInt("Vui lòng chọn(0-12): ");
			
			switch (choice) {
			case 1: 
				nhapCung(ds);
				break;
			case 2:
				int chon = 0;
				do {
					System.out.print("Nhap loai hang muon nhap\n"
						+ "1.Hang Thuc Pham\n"
						+ "2.Hang Diem May\n"
						+ "3.Hang Gom Su\n"
						+ "0.Thoat\n");
					chon = nhapInt("Nhập lựa chọn: ");
					if(chon == 0 ) break;
					String ma =nhapString("Nhập mã: ");
					String ten = nhapString("Nhập tên hàng : ");
					double gia = nhapDouble("Nhập giá:");
					int ton = nhapInt("Nhập tồn kho:");
					switch (chon) {
					case 1:
					    String tenNCC = nhapString("Nhập tên nhà cung cấp: ");
					    LocalDate ngaySX = nhapDate("Nhập ngày/tháng/năm sản xuất (dd/MM/yyyy):");
                        LocalDate ngayHH = nhapDate("Nhập ngày/tháng/năm hết hạn (dd/MM/yyyy):");
                        
                        // Kiểm tra nếu ngày hết hạn trước hoặc bằng ngày sản xuất
                        if (ngayHH.isBefore(ngaySX) || ngayHH.isEqual(ngaySX)) {
                            System.out.println("Ngày hết hạn phải sau ngày sản xuất. Vui lòng nhập lại.");
                            break; // Thoát ra khỏi case nếu nhập không hợp lệ
                        }

					    // Nếu kiểm tra đúng, tạo đối tượng HangThucPham và thêm vào danh sách
					    HangHoa htp = new HangThucPham(ma, ten, gia, ton, tenNCC, ngaySX, ngayHH);
					    if (ds.ThemHH(htp)) {
					        System.out.println("Them thanh cong");
					    } else {
					        System.out.println("Them khong thanh cong");
					    }
					    break;

						case 2:
							int tgbh = nhapInt("Thoi gian bao hanh: ");
							double cs =nhapDouble("Nhap cong suat: ");
							HangHoa hdm = new HangDienMay(ma, ten, gia,ton,tgbh,cs);
							if(ds.ThemHH(hdm)) System.out.println("Them thanh cong");
							else System.out.println("Them khong thanh cong");
							break;
						case 3:
							String nhasx = nhapString("Nhap Nha SX: ");
							String ngayNK = nhapString("Nhap Ngay/Thang/Nam nhap nho: ");
							HangHoa hss = new HangSanhSu(ma, ten, gia, ton, nhasx,LocalDate.parse(ngayNK,dtf));
							if(ds.ThemHH(hss)) System.out.println("Them thanh cong");
							else System.out.println("Them khong thanh cong");
							break;
						default:
							System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
							
					}
				}while(chon !=0 );
				break;
			case 3:
//				inTieuDe();
//				String tthh = ds.getDSHH();
//				
//				System.out.print(tthh);
				inTieuDeHangThucPham();
				String tttp = ds.getHangThucPham();
				System.out.print(tttp);
				inTieuDeHangDienMay();
				String ttdm = ds.getHangDienMay();
				System.out.print(ttdm);
				inTieuDeHangSanhSu();
				String ttss = ds.getHangSanhSu();
				System.out.print(ttss);
				break;
			case 4:
				inTieuDeHangThucPham();
				 tttp = ds.getHangThucPham();
				System.out.print(tttp);
				break;
			case 5:
				inTieuDeHangDienMay();
				 ttdm = ds.getHangDienMay();
				System.out.print(ttdm);
				break;
			case 6:
				inTieuDeHangSanhSu();
				 ttss = ds.getHangSanhSu();
				System.out.print(ttss);
				break;
			case 7:
				String maHH = nhapString("Nhap ma hh can tim:");
				HangHoa hh = ds.timHangHoa(maHH);
				if(hh == null)
					System.out.print("Khong co hang hoa nay");
				else
					System.out.println(hh);
				break;
			case 8:
				ds.sapXepTheoTen();
				
				break;
			case 9:
				ds.sapXepTheoSLTon();
				break;
			case 10:
			    String dskb = ds.getTTDanhSach_HTP_Kho_Ban();
			    System.out.println(dskb);
			    break;
			case 11:
				String ma = nhapString("Nhap ma HH can xoa: ");
				if(ds.xoaHangHoa(ma)) 
					System.out.println("Xoa thanh cong");
				else 
					System.out.println("Xoa khong thanh cong");
				break;
			case 12:
				String ma2  = nhapString("Nhap ma:");
				double giaMoi  = nhapDouble("Nhap gia moi:");
				ds.suaDonGia(ma2, giaMoi);
				break;
			case 0:
				System.out.println("Chương trình kết thúc.");
				break;
			default:
				System.out.println("Vui lòng chọn lại!!!");
				
			}
		}while(choice != 0);
		sc.close();
	}
	public static void inTieuDeHangThucPham() {
	    String title = String.format("%-10s|%-10s|%-15s|%-8s|%-15s|%-25s|%-15s|%-20s|%-10s|", 
	                                 "Mã Hàng", "Tên Hàng", "Đơn Giá", "Số Lượng", "Nhà Cung Cấp", "Ngày Sản Xuất", "Ngày Hết Hạn","Đánh Giá", "VAT");
	    System.out.println(title);
	}
	public static void inTieuDeHangDienMay() {
	    String title = String.format("\n%-10s|%-10s|%-15s|%-8s|%-10s|%-24s|%-20s|%-10s|", 
	                                 "Mã Hàng", "Tên Hàng", "Đơn Giá","Số Lượng", "Bảo Hành", "Công Suất","Đánh Giá", "VAT");
	    System.out.println(title);
	}
	public static void inTieuDeHangSanhSu() {
	    String title = String.format("\n%-10s|%-10s|%-15s|%-8s|%-15s|%-25s|%-36s|%-10s|", 
	                                 "Mã Hàng", "Tên Hàng", "Đơn Giá", "Số Lượng", "Nhà Sản Xuất", "Ngày Nhập","Đánh Giá", "VAT");
	    System.out.println(title);
	}
	public static void inTieuDe() {
	    String title = String.format("%-10s|%-10s|%-15s|%-8s|%-15s|%-25s|%-15s|%-20s|%-10s|", 
	                                 "Mã Hàng", "Tên Hàng", "Đơn Giá", "Số Lượng", "Nhà Cung Cấp", "Ngày Sản Xuất/Ngày Nhập", "Ngày Hết Hạn","Đánh Giá", "VAT");
	    System.out.println(title);
	}


}
