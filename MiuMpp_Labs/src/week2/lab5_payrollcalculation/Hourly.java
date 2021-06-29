package week2.lab5_payrollcalculation;

public class Hourly extends Employee {
	private double hourlyWage;
	private int hoursPerWeek;
	private static int HOURLY_ID = 1;

	public Hourly(double hourlyWage, int hoursPerWeek) {
		super("Hourly#" + HOURLY_ID++);
		this.hourlyWage = hourlyWage;
		this.hoursPerWeek = hoursPerWeek;
	}

	public double getHourlyWage() {
		return this.hourlyWage;
	}

	public void setHourlyWage(double hourlyWage) {
		this.hourlyWage = hourlyWage;
	}

	public int getHoursPerWeek() {
		return this.hoursPerWeek;
	}

	public void setHoursPerWeek(int hoursPerWeek) {
		this.hoursPerWeek = hoursPerWeek;
	}

	@Override
	double calcGrossPay(DateRange dateReange) {
		return this.hourlyWage * this.hoursPerWeek * 4;
	}
}
