package week2.lab5_payrollcalculation;

import java.time.LocalDate;
import java.time.YearMonth;

public final class DateRange {
	private final LocalDate startDate;
	private final LocalDate endDate;

	public DateRange(LocalDate date) {
		this.startDate = LocalDate.of(date.getYear(), date.getMonth(), getFirstDayOfMonth(date));
		this.endDate = LocalDate.of(date.getYear(), date.getMonth(), getLastDayOfMonth(date));
	}

	public boolean isInRange(LocalDate date) {
		boolean isInRange = date.compareTo(startDate) >= 0 && date.compareTo(endDate) <= 0;
		return isInRange;
	}

	@Override
	public String toString() {
		return "From " + startDate + " to " + endDate;
	}

	public static int getFirstDayOfMonth(LocalDate date) {
		return YearMonth.of(date.getYear(), date.getMonth()).atDay(1).getDayOfMonth();
	}

	public static int getLastDayOfMonth(LocalDate date) {
		return YearMonth.of(date.getYear(), date.getMonth()).atEndOfMonth().getDayOfMonth();
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}
}
