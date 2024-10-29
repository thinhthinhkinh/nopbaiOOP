package tuan8_ThuVien;

import java.util.Date;
public class SachThamKhao extends Sach {
    private double thue;

    public SachThamKhao(String maSach, Date ngayNhap, double donGia, int soLuong, String nhaXuatBan, double thue) {
        super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
        this.thue = thue;
    }

    @Override
    public double thanhTien() {
        return super.thanhTien() + thue;
    }

    @Override
    public String toString() {
        return "SachThamKhao{" +
                "thue=" + thue +
                ", " + super.toString() +
                '}';
    }
}
