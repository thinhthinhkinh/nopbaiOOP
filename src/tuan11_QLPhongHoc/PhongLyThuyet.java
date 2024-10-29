package tuan11_QLPhongHoc;

public class PhongLyThuyet extends PhongHoc {
    private boolean coMayChieu;

    public PhongLyThuyet(String maPhong, String dayNha, double dienTich, int soBongDen, boolean coMayChieu) {
        super(maPhong, dayNha, dienTich, soBongDen);
        this.coMayChieu = coMayChieu;
    }
    
    public boolean isCoMayChieu() {
        return coMayChieu;
    }

    @Override
    public boolean datChuan() {
        return (soBongDen >= dienTich / 10) && coMayChieu;
    }

    @Override
    public String toString() {
        return super.toString() + ", Có máy chiếu: " + (coMayChieu ? "Có" : "Không");
    }
}