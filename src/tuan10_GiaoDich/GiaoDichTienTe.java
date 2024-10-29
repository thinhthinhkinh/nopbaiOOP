package tuan10_GiaoDich;

public class GiaoDichTienTe extends GiaoDich {
    private double tiGia;
    private String loaiTienTe;

    public GiaoDichTienTe(String maGD, String ngayGD, double donGia, int soLuong, double tiGia, String loaiTienTe) {
        super(maGD, ngayGD, donGia, soLuong);
        this.tiGia = tiGia;
        this.loaiTienTe = loaiTienTe;
    }

    public double tinhThanhTien() {
        if (loaiTienTe.equals("VND")) {
            return soLuong * donGia;
        } else {
            return soLuong * donGia * tiGia;
        }
    }

    public double getTiGia() {
        return tiGia;
    }

    public String getLoaiTienTe() {
        return loaiTienTe;
    }

    public void setTiGia(double tiGia) {
        this.tiGia = tiGia;
    }

    public void setLoaiTienTe(String loaiTienTe) {
        this.loaiTienTe = loaiTienTe;
    }
}