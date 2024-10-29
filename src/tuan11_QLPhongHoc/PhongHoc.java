package tuan11_QLPhongHoc;

public abstract class PhongHoc {
    protected String maPhong;
    protected String dayNha;
    protected double dienTich;
    protected int soBongDen;

    public PhongHoc(String maPhong, String dayNha, double dienTich, int soBongDen) {
        this.maPhong = maPhong;
        this.dayNha = dayNha;
        this.dienTich = dienTich;
        this.soBongDen = soBongDen;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public String getDayNha() {
        return dayNha;
    }

    public double getDienTich() {
        return dienTich;
    }

    public int getSoBongDen() {
        return soBongDen;
    }

    public abstract boolean datChuan();

    @Override
    public String toString() {
        return "Mã phòng: " + maPhong + ", Dãy nhà: " + dayNha + ", Diện tích: " + dienTich + ", Số bóng đèn: " + soBongDen;
    }
}
