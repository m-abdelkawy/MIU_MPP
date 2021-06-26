package week1.standardexam1;

import java.util.List;

public class Admin {
	public static double computeUpdatedBalanceSum(List<Employee> list) {
		double updatedSum = 0;
		
		for (Employee employee : list) {
			updatedSum+= employee.computeUpdatedBalanceSum();
		}
		
		return updatedSum;
	}
}
