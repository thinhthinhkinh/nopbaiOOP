package tuan11_QLPhongHoc;
import java.util.*;

public class QuanLyPhongHoc {
    private List<PhongHoc> danhSachPhongHoc;

    public QuanLyPhongHoc() {
        this.danhSachPhongHoc = new ArrayList<>();
    }
    public List<PhongHoc> getDanhSachPhongHoc() {
        return danhSachPhongHoc;
    }

    public boolean themPhongHoc(PhongHoc phongHoc) {
        if (timPhongHoc(phongHoc.getMaPhong()) == null) {
            danhSachPhongHoc.add(phongHoc);
            return true;
        }
        return false;
    }

    public PhongHoc timPhongHoc(String maPhong) {
        for (PhongHoc phong : danhSachPhongHoc) {
            if (phong.getMaPhong().equals(maPhong)) {
                return phong;
            }
        }
        return null;
    }
    public void sapXepTheoDayNha() {
        Collections.sort(danhSachPhongHoc, Comparator.comparing(PhongHoc::getDayNha));
    }

    public void sapXepTheoDienTichGiamDan() {
        Collections.sort(danhSachPhongHoc, Comparator.comparing(PhongHoc::getDienTich).reversed());
    }

    public void sapXepTheoSoBongDen() {
        Collections.sort(danhSachPhongHoc, Comparator.comparing(PhongHoc::getSoBongDen));
    }

    public void capNhatSoMayTinh(String maPhong, int soMayTinhMoi) {
        PhongHoc phong = timPhongHoc(maPhong);
        if (phong instanceof PhongMayTinh) {
            ((PhongMayTinh) phong).capNhatSoMayTinh(soMayTinhMoi);
        } else {
            System.out.println("Phòng không phải là phòng máy tính.");
        }
    }

    public boolean xoaPhongHoc(String maPhong) {
        PhongHoc phong = timPhongHoc(maPhong);
        if (phong != null) {
            danhSachPhongHoc.remove(phong);
            return true;
        }
        return false;
    }

    public int tongSoPhongHoc() {
        return danhSachPhongHoc.size();
    }

}
