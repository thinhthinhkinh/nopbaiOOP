package tuan9_HangHoa;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
public abstract class HangHoa {
	protected final String maHang;
	protected String tenHang;
	protected double donGia;
	protected int sLTon;
	public abstract double VAT();
	public abstract String mucDoBanBuon();

	public HangHoa(String maHang, String tenHang, double donGia, int sLTon) throws Exception {
		if(maHang.equals(""))
			throw new Exception("Mã hàng bị rỗng!");
		this.maHang = maHang;
		setTenHang(tenHang);
		setDonGia(donGia);
		this.sLTon = sLTon;
	}

	public String getMaHang() {
		return maHang;
	}


	public String getTenHang() {
		return tenHang;
	}

	public void setTenHang(String tenHang) {
		if(tenHang.isEmpty()) {
			this.tenHang = "xxx";
		}
		else
			this.tenHang = tenHang;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) throws Exception {
		if(donGia < 0 ) 
			throw new Exception("Đơn giá phải lớn hơn 0!");	
		this.donGia = donGia;	
	}

	public int getsLTon() {
		return sLTon;
	}

	public void setsLTon(int sLTon) throws Exception {
		if(sLTon < 0 ) 
			throw new Exception("Số lượng tồn kho phải lớn hơn 0!");	
		this.sLTon = sLTon;	
	}
	
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maHang == null) ? 0 : maHang.hashCode());
		return result;
	}

	@Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        HangHoa hangHoa = (HangHoa) obj;
        return maHang.equals(hangHoa.maHang);  // So sánh dựa trên mã hàng
    }

	
	Locale VN = new Locale("vi","VN");
	NumberFormat nF = NumberFormat.getCurrencyInstance(VN);
	public String formatDate(LocalDate tmp) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String sngay = dtf.format(tmp);
		return sngay;
	}
	
	@Override
	public String toString() {
		String s ="";
		s+=String.format("%10s|%-10s|%15s|%8d|",getMaHang(),getTenHang(),nF.format(getDonGia()),getsLTon());
		return s;
	}
}
