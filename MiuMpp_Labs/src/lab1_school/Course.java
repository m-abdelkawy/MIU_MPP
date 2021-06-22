package lab1_school;

public class Course {
	private String number;
	private String title;
	private int units;
	
	public Course(String number, String title, int units) {
		this.number = number;
		this.title = title;
		this.units = units;
	}
	
	public String getNumber() {
		return number;
	}
	
	public int getUnits() {
		return units;
	}
}
