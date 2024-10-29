package tuan4_ChuyenXe;

public class NgoaiThanh  extends ChuyenXe{
	private String noiDen;
	private int soNgayDiDuoc;

	

	public NgoaiThanh(String maChuyenXe, String hoTen, int soXe, double doanhThu, String noiDen, int soNgayDiDuoc) {
		super(maChuyenXe, hoTen, soXe, doanhThu);
		this.noiDen = noiDen;
		this.soNgayDiDuoc = soNgayDiDuoc;
	}
	
	public NgoaiThanh() {
		super();
	}
	
	public String getNoiDen() {
		return noiDen;
	}

	public void setNoiDen(String noiDen) {
		this.noiDen = noiDen;
	}

	public int getSoNgayDiDuoc() {
		return soNgayDiDuoc;
	}

	public void setSoNgayDiDuoc(int soNgayDiDuoc) {
		this.soNgayDiDuoc = soNgayDiDuoc;
	}
	// --------------------------end ---------------------------------------------
	@Override
	public String toString() {
	    String baseString = super.toString(); // Kế thừa từ lớp cơ sở
	    return String.format("%s %-20s %10d", baseString, getNoiDen(), getSoNgayDiDuoc());
	}
}
