package lab1_school;

import java.time.LocalDate;

public class StaffStudent extends Staff {
	private double gpa;
	private LocalDate startDate;

	public StaffStudent(String name, String phone, int age, double salary, double gpa, LocalDate startDate) {
		super(name, phone, age, salary);
		this.gpa = gpa;
		this.startDate = startDate;
	}

}
