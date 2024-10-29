package tuan10_GiaoDich;

import java.util.Date;

public class GiaoDich {
    protected String maGD;
    protected String ngayGD;
    protected double donGia;
    protected int soLuong;

    public GiaoDich(String maGD, String ngayGD, double donGia, int soLuong) {
        this.maGD = maGD;
        this.ngayGD = ngayGD;
        this.donGia = donGia;
        this.soLuong = soLuong;
    }

    public String getMaGD() {
        return maGD;
    }

    public String getNgayGD() {
        return ngayGD;
    }

    public double getDonGia() {
        return donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setNgayGD(String ngayGD) {
        this.ngayGD = ngayGD;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}