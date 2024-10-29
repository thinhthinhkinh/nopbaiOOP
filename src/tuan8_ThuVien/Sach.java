package tuan8_ThuVien;

import java.util.Date;
import java.util.Objects;

public class Sach {
    protected String maSach;
    protected Date ngayNhap;
    protected double donGia;
    protected int soLuong;
    protected String nhaXuatBan;

    public Sach(String maSach, Date ngayNhap, double donGia, int soLuong, String nhaXuatBan) {
        this.maSach = maSach;
        this.ngayNhap = ngayNhap;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.nhaXuatBan = nhaXuatBan;
    }

    public double thanhTien() {
        return donGia * soLuong;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Sach sach = (Sach) obj;
        return Objects.equals(maSach, sach.maSach);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maSach);
    }

    @Override
    public String toString() {
        return "Sach{" +
                "maSach='" + maSach + '\'' +
                ", ngayNhap=" + ngayNhap +
                ", donGia=" + donGia +
                ", soLuong=" + soLuong +
                ", nhaXuatBan='" + nhaXuatBan + '\'' +
                '}';
    }

    public String getMaSach() {
        return maSach;
    }

    public String getNhaXuatBan() {
        return nhaXuatBan;
    }
}


