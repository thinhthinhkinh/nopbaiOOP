package tuan2_QLxe;

public class Vehicle {
	//Khai báo các thuộc tính 
	private String chuXe;
	private String tenXe;
	private int dungTich;
	private float triGia;
	
	//Phương thức tính thuế:
	//- Dưới 100cc, 1% trị giá xe.
	//- Từ 100 đến 200cc, 3% trị giá xe.
	//- Trên 200cc, 5% trị giá xe.
	public float tinhThue() {
		float thue = 0f;
		if(dungTich<100)
			thue = (1f/100)*triGia;
		else if(dungTich<=200)
			thue = (3f/100)*triGia;
		else
			thue = (5f/100)*triGia;
		return thue;
	}
	//Các phương thức getter và setter
	public String getChuXe() {
		return chuXe;
	}
	public void setChuXe(String chuXe) {
		this.chuXe = chuXe;
	}
	public String getTenXe() {
		return tenXe;
	}
	public void setTenXe(String tenXe) {
		this.tenXe = tenXe;
	}
	public int getDungTich() {
		return dungTich;
	}
	public void setDungTich(int dungTich) {
		if(dungTich<0)
			this.dungTich = 0;
		else
			this.dungTich = dungTich;
	}
	public float getTriGia() {
		return triGia;
	}
	public void setTriGia(float triGia) {
		if(triGia<0)
			this.triGia = 0;
		else
			this.triGia = triGia;
	}
	//Khởi tạo các constructor rỗng và đầy đủ tham số
	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Vehicle(String chuXe, String tenXe, int dungTich, float triGia) {
		super();
		this.chuXe = chuXe;
		this.tenXe = tenXe;
		setDungTich(dungTich);
		setTriGia(triGia);
	}
	@Override
	public String toString() {
		return String.format("%-20s %-20s %15d %20.2f %20.2f", chuXe, tenXe, dungTich, triGia, tinhThue());	
	}
}
