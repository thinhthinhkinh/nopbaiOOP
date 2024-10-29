package phamvotruongthinh_23658751_PhongHoc;

public class PhongMayTinh extends PhongHoc{
	private int soMayTinh;
	//constructors day du tham so
	public PhongMayTinh(String maPhong, String dayNha, double dienTich, int soBongDen, int soMayTinh) {
		super(maPhong, dayNha, dienTich, soBongDen);
		this.soMayTinh = soMayTinh;
	}
	//getters & setters
	public int getSoMayTinh() {
		return soMayTinh;
	}
	public void setSoMayTinh(int soMayTinh) {
		this.soMayTinh = soMayTinh;
	}
	//kiem tra dat chuan
	public boolean datChuan() {
		return (soBongDen >= dienTich/10) && (dienTich / soMayTinh <=1.5);
	}
	public void capNhatSoMayTinh(int soMT) {
		this.soMayTinh = soMT;
	}
	@Override
	public String toString() {
		return super.toString() + "Số máy tính: " + soMayTinh;
	}
	
}
