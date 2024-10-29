package tuan4_ChuyenXe;

import java.text.DecimalFormat;

public class NoiThanh extends ChuyenXe {
	private int soTuyen;
	private double soKm;

	public NoiThanh(String maChuyenXe, String hoTen, int soXe, double doanhThu, int soTuyen, double soKm) {
		super(maChuyenXe, hoTen, soXe, doanhThu);
		this.soTuyen = soTuyen;
		this.soKm = soKm;
	}

	public NoiThanh() {
		
	}

	public int getSoTuyen() {
		return soTuyen;
	}

	public void setSoTuyen(int soTuyen) {
		this.soTuyen = soTuyen;
	}

	public double getSoKm() {
		return soKm;
	}

	public void setSoKm(double soKm) {
		this.soKm = soKm;
	}

	
	@Override
	public String toString() {
	    String baseString = super.toString(); // Kế thừa từ lớp cơ sở
	    DecimalFormat kmFormat = new DecimalFormat("#,##0.00 km");
	    String kmString = kmFormat.format(soKm);
	    return String.format("%s %8d %13s", baseString, getSoTuyen(), kmString);
	}
}
