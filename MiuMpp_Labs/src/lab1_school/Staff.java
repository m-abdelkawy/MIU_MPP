package lab1_school;

import java.util.List;

public class Staff extends Person {
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


	@Override
	protected void addCourse(Course course) {
		return;
	}


	@Override
	protected List<Course> getCourses() {
		// TODO Auto-generated method stub
		return null;
	}

}
