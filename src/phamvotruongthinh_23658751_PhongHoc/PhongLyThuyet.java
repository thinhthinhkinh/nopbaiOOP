package phamvotruongthinh_23658751_PhongHoc;

public class PhongLyThuyet extends PhongHoc{
	private boolean coMayChieu;
	//constructors day du tham so
	public PhongLyThuyet(String maPhong, String dayNha, double dienTich, int soBongDen, boolean coMayChieu) {
		super(maPhong, dayNha, dienTich, soBongDen);
		this.coMayChieu = coMayChieu;
	}
	//getters & setters
	public boolean isMayChieu() {
		return coMayChieu;
	}
	public void setMayChieu(boolean coMayChieu) {
		this.coMayChieu = coMayChieu;
	}
	//kiem tra phong co dat chuan hay khong
	public boolean datChuan() {
		return (soBongDen >= dienTich/10) && coMayChieu;
	}
	@Override
	public String toString() {
		return super.toString() + "Có máy chiếu: " + (coMayChieu ? "Có" : "Không");
	}
	
}
