package tuan10_GiaoDich;

public class GiaoDichVang extends GiaoDich {
    private String loaiVang;

    public GiaoDichVang(String maGD, String ngayGD, double donGia, int soLuong, String loaiVang) {
        super(maGD, ngayGD, donGia, soLuong);
        this.loaiVang = loaiVang;
    }

    public double tinhThanhTien() {
        return soLuong * donGia;
    }

    public String getLoaiVang() {
        return loaiVang;
    }

    public void setLoaiVang(String loaiVang) {
        this.loaiVang = loaiVang;
    }
}

