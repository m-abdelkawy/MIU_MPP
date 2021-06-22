package lab1_school;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Faculty extends Person {
	private double salary;
	private List<Course> lstCourse;

	public Faculty(String name, String phone, int age ,double salary) {
		super(name, phone, age);
		this.salary = salary;
		this.lstCourse = new ArrayList<Course>();
	}
	
	public void addCourse(Course course) {
		lstCourse.add(course);
	}
	
	public int getTotalUnits() {
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
	public double getSalary() {
		// TODO Auto-generated method stub
		return salary;
	}
}
