import java.io.Serializable;

public final class BankAccount implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	private int accNo;
	private String name;
	private double balance;
	
	BankAccount() {
		accNo = 0;
		name = "";
		balance = 0.0;
	}
	public int getAccNo() {
		return accNo;
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
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
}