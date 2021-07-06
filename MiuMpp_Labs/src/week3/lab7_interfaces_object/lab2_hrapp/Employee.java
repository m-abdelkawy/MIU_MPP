package week3.lab7_interfaces_object.lab2_hrapp;

import java.time.LocalDate;
import java.util.Objects;

public class Employee implements Cloneable {
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

	@Override
	public boolean equals(Object ob) {
		if (ob == null)
			return false;
		if (!(ob instanceof Employee))
			return false;
		Employee emp = (Employee) ob;
		boolean isEqual = this.employeeId.equals(emp.employeeId) && this.firstName.equals(emp.firstName)
				&& this.lastName.equals(emp.lastName) && this.ssn.equals(emp.ssn) && this.birthDate.equals(emp.birthDate);

		return isEqual;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		sb.append(String.format("Name: %s %s, Birtdate: %s, SSN: %s", this.firstName, this.lastName, this.birthDate,
				this.ssn));
		sb.append("]");
		return sb.toString();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(employeeId, firstName, lastName, ssn);
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		Employee copy = (Employee)super.clone();
		copy.position = (Position)position.clone();
		return copy;
	}
}
