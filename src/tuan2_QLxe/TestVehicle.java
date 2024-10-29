package tuan2_QLxe;

import java.util.Scanner;

public class TestVehicle {
	public static void xuatTieuDe() {
		String title = String.format("%-20s %-20s %15s %20s %20s", "Chủ xe", "Tên xe", "Dung tích", "Trị giá", "Thuế phải nộp");
		System.out.println(title);
	}
	public static void main(String[] args) {
		int chon;
		DSVehicle listXe = new DSVehicle(3);
		do {
			chon=menu();
			switch(chon) {
				case 1: 
				{
					nhapThongTinXe(listXe);
					break;
				}
				case 2: 
				{
					xuatTieuDe();
					xuatTatCa(listXe);
					break;
				}
				case 3: {
					System.out.println("Cám ơn bạn đã sử dụng chương trình");
					break;
				}
			}
		} while(chon<3);
	}
	public static int menu() {
		int chon=0;
		Scanner sc = new Scanner(System.in);
		System.out.println("********************MENU********************");
		System.out.println("1. Nhập thông tin xe 1, xe 2, xe 3");
		System.out.println("2. Xuất bảng kê khai trước bạ của các xe");
		System.out.println("3.Thoát");
		System.out.println("Vui lòng chọn: ");
		chon = sc.nextInt();
		return chon;
	}
	//nhận thông tin từ người dùng thông qua bàn phím. Mỗi hàm này sẽ in 
	//ra một thông báo và trả về giá trị được nhập từ người dùng.
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
	public static float inputFloat(String thongBao) {
		Scanner sc = new Scanner(System.in);
		System.out.println(thongBao);
	    return sc.nextFloat();
	}
	public static Vehicle nhapXe() {
		String chuXe,tenXe;
		int dungTich;
		float triGia;
		Vehicle xe;
		chuXe = inputString("Nhập tên chủ xe: ");
	    tenXe = inputString("Nhập tên xe: ");
	    dungTich = inputInt("Nhập dung tích xe");
	    triGia = inputFloat("Nhập trị giá");
	    xe = new Vehicle(chuXe, tenXe, dungTich, triGia);
	    return xe;
	}
	public static void nhapThongTinXe(DSVehicle listXe) {
		for (int i = 1; i <= 3; i++) {
		    System.out.println("-----NHẬP THÔNG TIN XE " + i + "-----");
		    Vehicle xe = nhapXe();
		    if (listXe.addVehicle(xe)) 
		    	System.out.println("=>Thêm thành công xe " + i + " ");
		    else 
		        System.out.println("Thêm thất bại xe " + i);
		}
	}
	public static void xuatTatCa(DSVehicle listXe) {
	    if (listXe.getCount() == 0) {
	        System.out.println("Chưa có thông tin của bất kì xe nào => Vui lòng chọn 1 tại menu để nhập thông tin xe");
	    } else {
	        for (int i = 0; i < listXe.getCount(); i++) {
	            System.out.println(listXe.getDSVehicle()[i].toString());
	        }
	    }
	}

}
