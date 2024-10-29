package tuan8_ThuVien;

import java.util.ArrayList;
import java.util.List;

public class QuanLySach {
    List<Sach> listSachs = new ArrayList<>();

    public void themData(Sach object) throws Exception {
        if (!listSachs.contains(object)) {
            listSachs.add(object);
        } else {
            throw new Exception("Trùng mã sách");
        }
    }

    public int timVitri(String ma) {
        for (Sach s : listSachs) {
            if (s.getMaSach().equalsIgnoreCase(ma)) {
                return listSachs.indexOf(s);
            }
        }
        return -1;
    }

    public Sach timSach(String ma) {
        int viTri = timVitri(ma);
        if (viTri != -1)
            return listSachs.get(viTri);
        return null;
    }

    public double tongThanhTien() {
        double tong = 0;
        for (Sach s : listSachs) {
            tong += s.thanhTien();
        }
        return tong;
    }

    public double trungBinhDonGiaSachThamKhao() {
        double tongDonGia = 0;
        int count = 0;
        for (Sach s : listSachs) {
            if (s instanceof SachThamKhao) {
                tongDonGia += s.donGia;
                count++;
            }
        }
        return count > 0 ? tongDonGia / count : 0;
    }

    public List<Sach> sachGiaoKhoaNhaXuatBan(String nhaXuatBan) {
        List<Sach> result = new ArrayList<>();
        for (Sach s : listSachs) {
            if (s instanceof SachGiaoKhoa && s.getNhaXuatBan().equalsIgnoreCase(nhaXuatBan)) {
                result.add(s);
            }
        }
        return result;
    }
}
