package week2.lab5_payrollcalculation;

import java.time.LocalDate;

public final class DateRange {
	private final LocalDate startDate;
	private final LocalDate endDate;

	public DateRange(LocalDate startDate, LocalDate endDate) {
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public boolean isInRange(LocalDate date) {
		boolean isInRange = date.compareTo(startDate) >= 0 && date.compareTo(endDate) <= 0;
		return isInRange;
	}

	@Override
	public String toString() {
		throw new UnsupportedOperationException();
	}

	public static void getFirstDayOfMonth() {
		throw new UnsupportedOperationException();
	}

	public static void getLastDayOfMonth() {
		throw new UnsupportedOperationException();
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}
}
