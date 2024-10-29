package tuan11_QLPhongHoc;

public class PhongThiNghiem extends PhongHoc {
    private boolean coBonRua;

    public PhongThiNghiem(String maPhong, String dayNha, double dienTich, int soBongDen, boolean coBonRua) {
        super(maPhong, dayNha, dienTich, soBongDen);
        this.coBonRua = coBonRua;
    }
    public boolean isCoBonRua() {
        return coBonRua;
    }
    
    @Override
    public boolean datChuan() {
        return (soBongDen >= dienTich / 10) && coBonRua;
    }

    @Override
    public String toString() {
        return super.toString() + ", Có bồn rửa: " + (coBonRua ? "Có" : "Không");
    }
}