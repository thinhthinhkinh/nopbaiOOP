package tuan1_QuanLiSinhVien;

public class SinhVien {
	private int maSV;
	private String hoVaTen;
	private double diemLT;
	private double diemTH;
	//constructor
	public SinhVien(int maSV, String hoVaTen, double diemLT, double diemTH) {
		this.maSV = maSV;
		this.hoVaTen = hoVaTen;
		this.diemLT = diemLT;
		this.diemTH = diemTH;
	}
    public SinhVien() {
        this.maSV = 0;
        this.hoVaTen = "";
        this.diemLT = 0.0f;
        this.diemTH = 0.0f;
    }
	//getters & setters
	public int getMaSV() {
		return maSV;
	}
	public void setMaSV(int maSV) {
		this.maSV = maSV;
	}
	public String getHoVaTen() {
		return hoVaTen;
	}
	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}
	public double getDiemLT() {
		return diemLT;
	}
	public void setDiemLT(double diemLT) {
		this.diemLT = diemLT;
	}
	public double getDiemTH() {
		return diemTH;
	}
	public void setDiemTH(double diemTH) {
		this.diemTH = diemTH;
	}
	//tinh diem trung binh
	public double tinhDiemTB() {
		return (diemLT + diemTH) /2;
	}
	@Override
	public String toString() {
		return String.format("%-8d %-30s %-5.2f %11.2f %9.2f",
				maSV, hoVaTen, diemLT, diemTH, tinhDiemTB()
				);
	}
}
