package lab1_school;

import java.time.LocalDate;

public class StaffStudent extends Staff implements IStaffStudent{
	private LocalDate startDate;
	private Student student;

	public StaffStudent(String name, String phone, int age, double salary, LocalDate startDate, double gpa) {
		super(name, phone, age, salary);
		this.setStartDate(startDate);
		
		this.student = new Student(name, phone, age, gpa);
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}


	@Override
	public double getGpa() {
		// delegation
		return this.student.getGpa();
	}
	
	@Override
	public void addStudentCourse(Course course) {
		// delegation (This is different from the addCourse in the Staff class that this class inherits)
		this.student.addCourse(course);
	}
}
