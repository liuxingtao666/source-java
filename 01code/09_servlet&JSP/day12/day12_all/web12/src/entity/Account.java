package entity;

public class Account {
	private int id;
	private String accountNo;
	private double balance;
	
	@Override
	public String toString() {
		return id + " " + accountNo 
		+ " " + balance;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
