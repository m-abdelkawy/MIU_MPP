package week1.lab1_school;

import java.util.List;

public class Staff extends Person{
	private double salary;
	
	public Staff(String name, String phone, int age, double salary) {
		super(name, phone, age);
		this.salary = salary;
	}


	@Override
	public double getSalary() {
		return salary;
	}
	
	@Override
	public void setSalary(double salary) {
		this.salary = salary;
	}


	

}
