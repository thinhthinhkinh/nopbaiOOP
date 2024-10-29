package tuan2_QLxe;

public class DSVehicle {
    private Vehicle DSVehicle[]; // Mảng để lưu trữ các đối tượng Vehicle
    private int count = 0; 

    // Constructor để khởi tạo danh sách xe
    public DSVehicle(int n) {
        if (n < 0)
            DSVehicle = new Vehicle[3]; 
        else
            DSVehicle = new Vehicle[n]; 
    }

    // Phương thức để lấy mảng chứa các đối tượng Vehicle
    public Vehicle[] getDSVehicle() {
        return DSVehicle;
    }

    // Phương thức để lấy số lượng xe hiện tại trong danh sách
    public int getCount() {
        return count;
    }

    // Phương thức để thêm một đối tượng Vehicle vào danh sách
    public boolean addVehicle(Vehicle vehicle) {
        if (count < DSVehicle.length) {
            DSVehicle[count] = vehicle; // Thêm đối tượng Vehicle vào mảng
            count++; // Tăng số lượng xe hiện tại
            return true; // Trả về true nếu thêm thành công
        }
        return false; // danh sách đã đầy
    }
}

