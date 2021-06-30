package week2.lab5_payrollcalculation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Employee {
	private String empId;
	private List<Paycheck> lstPaycheck;

	public Employee(String empId) {
		this.empId = empId;
		lstPaycheck = new ArrayList<Paycheck>();
	}

	private void addPaycheck(Paycheck paycheck) {
		if (paycheck == null)
			return;
		lstPaycheck.add(paycheck);
	}

	public void print() {
		System.out.println("*=====================================*");
		System.out.println("Employee with ID: " + empId);
		System.out.println("*=====================================*");
		for (Paycheck paycheck : lstPaycheck) {
			paycheck.print();
		}
		System.out.println("*__________________________________*______________________________*");
	}

	Paycheck calcCompensation(int month, int year) {
		DateRange dr = new DateRange(LocalDate.of(year, month, 1));
		Paycheck paycheck = new Paycheck(dr, this);

		addPaycheck(paycheck);
		return paycheck;
	}

	abstract double calcGrossPay(DateRange dateReange);
}
