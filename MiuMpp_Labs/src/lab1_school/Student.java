package lab1_school;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Student extends Person {
	private double gpa;
	private List<Course> lstCourse;
	
	public Student(String name, String phone, int age, double gpa) {
		super(name, phone, age);
		this.gpa = gpa;
		lstCourse = new ArrayList<Course>();
	}

	@Override
	public void addCourse(Course course) {
		lstCourse.add(course);
	}
	

	public double getTotalUnits() {
		return 0;
	}

	@Override
	public double getSalary() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected List<Course> getCourses(){
		//in order not to return mutable object
		Course[] res = new Course[lstCourse.size()];
		System.arraycopy(lstCourse.toArray(), 0, res, 0, lstCourse.size());
		return Arrays.asList(res);
	}
}
