package tuan9_HangHoa;

public class HangDienMay extends HangHoa {
	private int tgBaoHanh;
	private double congSuat;

	public HangDienMay(String maHang, String tenHang, double donGia, int sLTon, int tgBaoHanh, double congSuat) throws Exception {
		super(maHang, tenHang, donGia, sLTon);
		setTgBaoHanh(tgBaoHanh);
		setCongSuat(congSuat);
	}

	public int getTgBaoHanh() {
		return tgBaoHanh;
	}

	public void setTgBaoHanh(int tgBaoHanh) throws Exception {
			if (tgBaoHanh < 0)
				throw new Exception("Thời gian bảo hành < 0");
			else
				this.tgBaoHanh = tgBaoHanh;

	}

	public double getCongSuat() {
		return congSuat;
	}

	public void setCongSuat(double congSuat) throws Exception {
		if (congSuat < 0)
			throw new Exception("Công suất < 0");
		else
			this.congSuat = congSuat;
	}
	
	@Override
	public String mucDoBanBuon() {
		String str = "Không Đánh Giá";
		if(sLTon < 3) str = "Bán Được";
		return str;
	}
	
	@Override
	public double VAT() {
		// TODO Auto-generated method stub
		return (0.1)*this.donGia;
	}
	
	@Override
	public String toString() {
		String s1 = "";
		s1+=String.format("%10d|%24.2f|%20s|%10s|",getTgBaoHanh(),getCongSuat(),mucDoBanBuon(),super.nF.format(VAT()));
		return super.toString()+s1;
	}
}
