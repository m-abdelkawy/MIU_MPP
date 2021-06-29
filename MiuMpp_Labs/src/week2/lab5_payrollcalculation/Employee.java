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
		System.out.println("Employee with ID: " + empId);
		for (Paycheck paycheck : lstPaycheck) {
			paycheck.print();
		}
	}

	Paycheck calcCompensation(int month, int year) {
		Paycheck paycheck = new Paycheck(new DateRange(LocalDate.of(year, month, 1), LocalDate.of(year, month, 28)),
				this);

		addPaycheck(paycheck);
		return paycheck;
	}

	abstract double calcGrossPay(DateRange dateReange);
}
