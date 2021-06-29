package week2.lab5_payrollcalculation;

import java.time.LocalDate;

public final class Paycheck {
	private static final double PERC_FICATAX = 0.23;
	private static final double PERC_STATETAX = 0.05;
	private static final double PERC_LOCALTAX = 0.01;
	private static final double PERC_MEDICARE = 0.03;
	private static final double PERC_SOCIALSECURITY = 0.075;

	private double grossPay;
	private double fica;
	private double state;
	private double local;
	private double medicare;
	private double socialSecurity;
	private DateRange payPeriod;

	private Employee employee;

	public Paycheck(DateRange dateRange, Employee employee) {
		this.grossPay = employee.calcGrossPay(dateRange);

		this.fica = grossPay * PERC_FICATAX;
		this.state = grossPay * PERC_STATETAX;
		this.local = grossPay * PERC_LOCALTAX;
		this.medicare = grossPay * PERC_MEDICARE;
		this.socialSecurity = grossPay * PERC_SOCIALSECURITY;

		this.payPeriod = dateRange;
		this.employee = employee;
	}

	public double getGrossPay() {
		return grossPay;
	}

	public double getFica() {
		return fica;
	}

	public double getState() {
		return state;
	}

	public double getLocal() {
		return local;
	}

	public double getMedicare() {
		return medicare;
	}

	public double getSocialSecurity() {
		return socialSecurity;
	}

	public DateRange getPayPeriod() {
		return payPeriod;
	}

	public void print() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("for month #%d: %n", payPeriod.getStartDate().getMonth().getValue()));
		sb.append(String.format("GrossPay: %.2f$%n%n", grossPay));
		sb.append(String.format(
				"Taxes breakdown:-%nFICA: %.2f$%nState: %.2f$%nLocal: %.2f$%nMedicare: %.2f$%nSocialSecurity: %.2f$%n%n",
				fica, state, local, medicare, socialSecurity));
		sb.append(String.format("Net Salary: %.2f$%n", getNetPay()));
		System.out.println(sb.toString());
		System.out.println("__________________________\n");
	}

	public double getNetPay() {
		return grossPay - fica - state - local - medicare - socialSecurity;
	}
}
