package tuan4_ChuyenXe;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;

public class ChuyenXe {
	//khai báo thuộc tính
	protected String maChuyenXe;
	protected String hoTen;
	protected int soXe;
	protected double doanhThu;

	//contructor đầy đủ tham số
	public ChuyenXe(String maChuyenXe, String hoTen, int soXe, double doanhThu) {
		super();
		this.maChuyenXe = maChuyenXe;
		this.hoTen = hoTen;
		this.soXe = soXe;
		this.doanhThu = doanhThu;
	}
	public ChuyenXe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMaChuyenXe() {
		return maChuyenXe;
	}

	public void setMaChuyenXe(String maChuyenXe) {
		this.maChuyenXe = maChuyenXe;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public int getSoXe() {
		return soXe;
	}

	public void setSoXe(int soXe) {
		this.soXe = soXe;
	}

	public double getDoanhThu() {
		return doanhThu;
	}

	public void setDoanhThu(double doanhThu) throws Exception {
		if(doanhThu > 0)
			this.doanhThu = doanhThu;
		else
			throw new Exception("Doanh thu phải lớn hơn không");
	}
	//Hashcode
	@Override
	public int hashCode() {
		return Objects.hash(maChuyenXe);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChuyenXe other = (ChuyenXe) obj;
		return Objects.equals(maChuyenXe, other.maChuyenXe);
	}

	@Override
	public String toString() {
		NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
	    String doanhThuString = formatter.format(doanhThu);
		return String.format("%9s %-30s %10d %20s", getMaChuyenXe(), getHoTen(), getSoXe(), doanhThuString);
	}

}
