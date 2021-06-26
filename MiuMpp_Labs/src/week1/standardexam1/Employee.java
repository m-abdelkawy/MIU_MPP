package week1.standardexam1;

import java.util.ArrayList;
import java.util.List;

public class Employee {
	private String name;
	private List<Account> lstAccount;
	
	public Employee(String name) {
		this.name = name;
		this.lstAccount = new ArrayList<Account>();
	}

	public String getName() {
		return this.name;
	}

	public void addAccount(Account account) {
		if (account == null)
			return;
		this.lstAccount.add(account);
	}

	public double computeUpdatedBalanceSum() {
		double updatedBalanceSum = 0;
		for (Account account : lstAccount) {
			updatedBalanceSum += account.computeUpdatedBalance();
		}
		return updatedBalanceSum;
	}
}
