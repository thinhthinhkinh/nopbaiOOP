package phamvotruongthinh_23658751_PhongHoc;

public class PhongThiNghiem extends PhongHoc{
	private boolean coBonRua;
	//constructor day du tham so
	public PhongThiNghiem(String maPhong, String dayNha, double dienTich, int soBongDen, boolean coBonRua) {
		super(maPhong, dayNha, dienTich, soBongDen);
		this.coBonRua = coBonRua;
	}
	//getters  & setters
	public boolean isCoBonRua() {
		return coBonRua;
	}
	public void setCoBonRua(boolean coBonRua) {
		this.coBonRua = coBonRua;
	}
	//kiem tra dat chuan
	public boolean datChuan() {
		return (soBongDen >= dienTich/10) && coBonRua;
	}
	@Override
	public String toString() {
		return super.toString() + "Có bồn rửa: " + (coBonRua ? "Có" : "Không");
	}
	

}
