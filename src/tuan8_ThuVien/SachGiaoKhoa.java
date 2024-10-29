package tuan8_ThuVien;

import java.util.Date;
public class SachGiaoKhoa extends Sach {
    String tinhTrang;

    public SachGiaoKhoa(String maSach, Date ngayNhap, double donGia, int soLuong, String nhaXuatBan, String tinhTrang) {
        super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
        this.tinhTrang = tinhTrang;
    }

    @Override
    public String toString() {
        return "SachGiaoKhoa{" +
                "tinhTrang='" + tinhTrang + '\'' +
                ", " + super.toString() +
                '}';
    }
}
