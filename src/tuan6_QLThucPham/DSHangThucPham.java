package tuan6_QLThucPham;

public class DSHangThucPham {
    private HangThucPham[] danhSach;
    private int soLuong = 0;

    public DSHangThucPham() {
        this.danhSach = new HangThucPham[10];  // Mảng mặc định với kích thước ban đầu là 10
    }

    public DSHangThucPham(int initialized) {
        this.danhSach = new HangThucPham[initialized];
    }

    public int getSoLuong() {
        return soLuong;
    }

    public HangThucPham[] getDanhSach() {
        return danhSach;
    }

    public boolean maHangHienCo(String maHang) {
        for (int i = 0; i < soLuong; i++) {
            if (danhSach[i].getMaHang().equals(maHang)) {
                return true;
            }
        }
        return false;
    }

    public void them(HangThucPham hang) throws Exception {
        if (maHangHienCo(hang.getMaHang())) {
            throw new Exception("Mã hàng đã tồn tại!");
        }
        if (soLuong == danhSach.length) {
            HangThucPham[] newDanhSach = new HangThucPham[danhSach.length * 2];
            System.arraycopy(danhSach, 0, newDanhSach, 0, soLuong);
            danhSach = newDanhSach;
        }
        danhSach[soLuong++] = hang;
    }

    public HangThucPham timHang(String maHang) {
        for (int i = 0; i < soLuong; i++) {
            if (danhSach[i].getMaHang().equals(maHang)) {
                return danhSach[i];
            }
        }
        return null;
    }

    public void hienThiDanhSach() {
        if (soLuong == 0) {
            System.out.println("Danh sách trống.");
            return;
        }
        for (int i = 0; i < soLuong; i++) {
            System.out.println(danhSach[i].toString());
        }
    }
}
