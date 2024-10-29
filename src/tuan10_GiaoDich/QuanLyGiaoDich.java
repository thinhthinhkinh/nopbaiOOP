package tuan10_GiaoDich;

import java.util.ArrayList;
import java.util.List;

public class QuanLyGiaoDich {
    private ArrayList<GiaoDich> danhSachGD;

    public QuanLyGiaoDich() {
        danhSachGD = new ArrayList<>();
    }

    public void them(GiaoDich gd) {
        danhSachGD.add(gd);
    }

    public boolean xoa(String maGD) {
        for (int i = 0; i < danhSachGD.size(); i++) {
            if (danhSachGD.get(i).getMaGD().equals(maGD)) {
                danhSachGD.remove(i);
                return true;
            }
        }
        return false;
    }

    public GiaoDich timKiem(String maGD) {
        for (GiaoDich gd : danhSachGD) {
            if (gd.getMaGD().equals(maGD)) {
                return gd;
            }
        }
        return null;
    }

    public ArrayList<GiaoDich> getDanhSach() {
        return danhSachGD;
    }

    public int tinhTongSoLuongVang() {
        int tong = 0;
        for (GiaoDich gd : danhSachGD) {
            if (gd instanceof GiaoDichVang) {
                tong += gd.getSoLuong();
            }
        }
        return tong;
    }

    public int tinhTongSoLuongTienTe() {
        int tong = 0;
        for (GiaoDich gd : danhSachGD) {
            if (gd instanceof GiaoDichTienTe) {
                tong += gd.getSoLuong();
            }
        }
        return tong;
    }

    public double tinhTrungBinhThanhTienTienTe() {
        double tongThanhTien = 0;
        int soGiaoDich = 0;
        
        for (GiaoDich gd : danhSachGD) {
            if (gd instanceof GiaoDichTienTe) {
                GiaoDichTienTe gdtt = (GiaoDichTienTe) gd;
                tongThanhTien += gdtt.tinhThanhTien();
                soGiaoDich++;
            }
        }
        
        if (soGiaoDich == 0) return 0;
        return tongThanhTien / soGiaoDich;
    }
}
