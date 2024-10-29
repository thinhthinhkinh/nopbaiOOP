package tuan6_LopCD;

public class CD {
    private int maCD;
    private String tuaCD;
    private String caSy;
    private int soBaiHat;
    private double giaThanh;

    // Constructor
    public CD(int maCD, String tuaCD, String caSy, int soBaiHat, double giaThanh) {
        if (soBaiHat <= 0 || giaThanh <= 0) {
            throw new IllegalArgumentException("Số bài hát và giá thành phải lớn hơn 0.");
        }
        this.maCD = maCD;
        this.tuaCD = tuaCD;
        this.caSy = caSy;
        this.soBaiHat = soBaiHat;
        this.giaThanh = giaThanh;
    }

    // Getters and Setters
    public int getMaCD() {
        return maCD;
    }

    public String getTuaCD() {
        return tuaCD;
    }

    public void setTuaCD(String tuaCD) {
        this.tuaCD = tuaCD;
    }

    public String getCaSy() {
        return caSy;
    }

    public void setCaSy(String caSy) {
        this.caSy = caSy;
    }

    public int getSoBaiHat() {
        return soBaiHat;
    }

    public void setSoBaiHat(int soBaiHat) {
        if (soBaiHat <= 0) {
            throw new IllegalArgumentException("Số bài hát phải lớn hơn 0.");
        }
        this.soBaiHat = soBaiHat;
    }

    public double getGiaThanh() {
        return giaThanh;
    }

    public void setGiaThanh(double giaThanh) {
        if (giaThanh <= 0) {
            throw new IllegalArgumentException("Giá thành phải lớn hơn 0.");
        }
        this.giaThanh = giaThanh;
    }

    @Override
    public String toString() {
        return "CD{" +
                "maCD=" + maCD +
                ", tuaCD='" + tuaCD + '\'' +
                ", caSy='" + caSy + '\'' +
                ", soBaiHat=" + soBaiHat +
                ", giaThanh=" + giaThanh +
                '}';
    }

	public void xuatBang() {
		// TODO Auto-generated method stub
		
	}
}
