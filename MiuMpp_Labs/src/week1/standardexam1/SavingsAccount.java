package week1.standardexam1;

public class SavingsAccount extends Account{
	private String accId;
	private double balance;
private double interestRate;

public SavingsAccount(String accId, double interestRate , double startBalance) {
	this.accId = accId;
	this.balance = startBalance;
	this.interestRate = interestRate;
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
		return this.balance + interestRate * this.balance;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

}
