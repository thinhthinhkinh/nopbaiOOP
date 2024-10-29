package tuan2_QlBank;

public class Account {
	private long numOfAcc;
	private String name;
	private double balance;
	private static final double RATE = 0.035;
	
	public long getNumOfAcc() {
		return numOfAcc;
	}
	public void setNumOfAcc(long numOfAcc) {
		this.numOfAcc = numOfAcc;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Account() {
		super();
	}
	public Account(long numOfAcc, String name, double balance) {
		super();
		this.setNumOfAcc(numOfAcc);
		this.setName(name);
		this.setBalance(balance);
	}
	public Account(long numOfAcc, String name) {
		super();
		this.setNumOfAcc(numOfAcc);
		this.setName(name);
		this.balance = 50000;
		
	}
	@Override
	public String toString() {
		String str = String.format("%-20d %-30s %-20.2f", getNumOfAcc(), getName(), getBalance());
		return str;
	}
	public boolean deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            return true;
        }
        return false;
    }

	public boolean withdraw(double amount, double fee) {
        if (amount > 0 && amount + fee <= this.balance) {
            this.balance -= (amount + fee);
            return true;
        }
        return false;
    }
	public void maturity() {
		this.balance += this.balance*RATE;
	}
	public boolean transfer(Account acc2, double amount) {
        if (amount > 0 && this.balance >= amount) {
            this.balance -= amount;
            acc2.deposit(amount);
            return true;
        }
        return false;
    }
	// Hàm tách tên (phần cuối cùng trong fullName)
    public String getFirstName() {
        String[] parts = name.split(" ");
        return parts[parts.length - 1]; // Tên là phần cuối cùng
    }
	
}
