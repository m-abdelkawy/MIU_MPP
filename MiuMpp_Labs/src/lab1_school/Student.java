package lab1_school;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Student extends Person implements IStudent {
	private double gpa;
	private List<Course> lstCourse;
	
	public Student(String name, String phone, int age, double gpa) {
		super(name, phone, age);
		this.setGpa(gpa);
		lstCourse = new ArrayList<Course>();
	}

	@Override
	public void addCourse(Course course) {
		lstCourse.add(course);
	}
	

	public double getTotalUnits() {
		int res = 0;
		for (Course course : lstCourse) {
			res+=course.getUnits();
		}
		return res;
	}


	@Override
	protected List<Course> getCourses(){
		//in order not to return mutable object
		Course[] res = new Course[lstCourse.size()];
		System.arraycopy(lstCourse.toArray(), 0, res, 0, lstCourse.size());
		return Arrays.asList(res);
	}

	@Override
	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
}
