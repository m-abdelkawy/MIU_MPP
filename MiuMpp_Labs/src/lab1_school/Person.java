package lab1_school;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	protected double getSalary() {
		return 0;
	}

	protected void setSalary(double salary) {
		return;
	}

	protected abstract void addCourse(Course course);

	protected abstract List<Course> getCourses();

}
