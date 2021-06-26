package week1.standardexam1;

public class CheckingAccount extends Account {
	private String accId;
	private double balance;
	private double monthlyFee;
	
	public CheckingAccount(String accId, double fee , double startBalance) {
		this.accId = accId;
		this.balance = startBalance;
		this.monthlyFee = fee;
	}


	@Override
	public String getAccountId() {
		return this.accId;
	}

	@Override
	public double getBalance() {
		return this.balance;
	}

	@Override
	public double computeUpdatedBalance() {
		return this.balance - monthlyFee;
	}

	public double getMonthlyFee() {
		return monthlyFee;
	}

	public void setMonthlyFee(double monthlyFee) {
		this.monthlyFee = monthlyFee;
	}

}
