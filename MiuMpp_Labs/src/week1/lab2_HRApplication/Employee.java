package week1.lab2_HRApplication;

import java.time.LocalDate;

public class Employee {
	private String employeeId;
	private String firstName;
	private String middleInitial;
	private String lastName;
	private LocalDate birthDate;
	private String ssn;
	private double salary;
	private Position position;
	
	public Employee(String employeeId, String firstName, String middleInitial, String lastName, LocalDate birthDate,
			String ssn, double salary, Position position) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.middleInitial = middleInitial;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.ssn = ssn;
		this.salary = salary;
		this.position = position;
	}
	
	public void print() {
		System.out.println(firstName + " " + lastName);
	}
	
	public double getSalary() {
		return salary;
	}
}
