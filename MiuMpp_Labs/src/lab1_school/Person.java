package lab1_school;

import java.util.Arrays;
import java.util.List;

public abstract class Person {
	protected String name;
	protected String phone;
	protected int age;
	
	
	
	public Person(String name, String phone, int age) {
		this.name = name;
		this.phone = phone;
		this.age = age;
	}



	protected abstract double getSalary();
	protected abstract void addCourse(Course course);
	protected abstract List<Course> getCourses();
	/*public String getName() {
		return name;
	}
	public String getPhone() {
		return phone;
	}
	public int getAge() {
		return age;
	}*/



}
