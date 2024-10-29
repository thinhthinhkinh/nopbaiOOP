package tuan4_ChuyenXe;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;

public class DanhSachChuyenXe {
	ArrayList<ChuyenXe> DS;
	
	public DanhSachChuyenXe() {
		DS = new ArrayList<ChuyenXe>();
	}

//-------------------------------begin method ----------------------------------
	public void them(ChuyenXe xe) throws Exception {
		if (DS.contains(xe) == false)// hiểu dc nhờ hascode equa của lớp chuyến xe
			DS.add(xe);
		else {
			throw new Exception("Mã chuyến xe đã trùng");
		}
	}
	public ChuyenXe timKiem(String maCX) {
		for (ChuyenXe xe : DS) {
			if (xe.getMaChuyenXe().equalsIgnoreCase(maCX))
				return xe;//trả về chuyến xe có mã chuyến xe trùng với maCX
		}
		return null;
	}
	public int timKiemViTri(String maCX) {//tìm kiếm vị trí của chuyến xe trong danh sách DS
		ChuyenXe findxe = timKiem(maCX);
		if (findxe != null)
			return DS.indexOf(timKiem(maCX));//trả về vị trí của chuyến xe đó trong danh sách
		return -1;
	}

	public String tinhDoanhThu() {
		double s = 0;
		for (ChuyenXe xe : DS)
			s+= xe.getDoanhThu();
			NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
		return formatter.format(s);
	}


	public ArrayList<NoiThanh> getDSXeNoiThanh() {
		ArrayList<NoiThanh> DSxeNoiThanh = new ArrayList<NoiThanh>();
		for (ChuyenXe xe : DS)
			if (xe instanceof NoiThanh)
				DSxeNoiThanh.add((NoiThanh) xe);

		return DSxeNoiThanh;
	}
	

	public ArrayList<NgoaiThanh> getDSXeNgoaiThanh() {
		ArrayList<NgoaiThanh> DSxeNgoaiThanh = new ArrayList<NgoaiThanh>();
		for (ChuyenXe xe : DS)
			if (xe instanceof NgoaiThanh)
				DSxeNgoaiThanh.add((NgoaiThanh) xe);

		return DSxeNgoaiThanh;
	}

//-------------------------------trả về danh sách chuyến xe --------------------
	public ArrayList<ChuyenXe> getDS() {
		return DS;
	}
}
