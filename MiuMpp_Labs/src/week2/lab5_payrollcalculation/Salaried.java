package week2.lab5_payrollcalculation;

public class Salaried extends Employee {
	private double annualSalary;
	private static int SALARIED_ID = 1;

	public Salaried(double annualSalary) {
		super("Salaried#" + SALARIED_ID++);
		this.annualSalary = annualSalary;
	}

	@Override
	double calcGrossPay(DateRange dateReange) {
		return this.annualSalary / 12;
	}
}
