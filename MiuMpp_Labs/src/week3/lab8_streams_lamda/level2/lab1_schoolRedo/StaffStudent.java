package week3.lab8_streams_lamda.level2.lab1_schoolRedo;

import java.time.LocalDate;

public class StaffStudent extends Student{
	private LocalDate startDate;
	private Staff staff;

	public StaffStudent(String name, String phone, int age, double salary, LocalDate startDate, double gpa) {
		super(name, phone, age, gpa);
		this.setStartDate(startDate);
		
		this.staff = new Staff(name, phone, age, salary);
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}


	public double getSalary() {
		// delegation
		return this.staff.getSalary();
	}
}
