package tuan6_LopCD;

import java.util.Arrays;

public class DanhSachCD {
    private CD[] dsCD;
    private int count;

    public DanhSachCD(int size) {
        dsCD = new CD[size];
        count = 0;
    }

    public boolean themCD(CD cd) {
        if (count < dsCD.length) {
        	
//            for (int i = 0; i < count; i++) {
//                if (dsCD[i].getMaCD() == cd.getMaCD()) {
//                    return false; // Mã CD đã tồn tại
//                }
//            }
            dsCD[count++] = cd;
            return true; // Thêm thành công
        }
        return false; // Kích thước mảng không đủ
    }

    public int soLuongCD() {
        return count;
    }

    public double tongGiaThanh() {
        double tong = 0;
        for (int i = 0; i < count; i++) {
            tong += dsCD[i].getGiaThanh();
        }
        return tong;
    }

    public void sapXepGiamDanTheoGia() {
        Arrays.sort(dsCD, 0, count, (cd1, cd2) -> Double.compare(cd2.getGiaThanh(), cd1.getGiaThanh()));
    }

    public void sapXepTangDanTheoTua() {
        Arrays.sort(dsCD, 0, count, (cd1, cd2) -> cd1.getTuaCD().compareTo(cd2.getTuaCD()));
    }

//    public void xuatDanhSach() {
//        for (int i = 0; i < count; i++) {
//            System.out.println(dsCD[i]);
//        }
    public CD[] getDsCD() {
    	return dsCD;
    }
}

