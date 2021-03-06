package week3.lab7_interfaces_object.lab1_school;

public class Course {
	private String number;
	private String title;
	private int units;
	
	public Course(String number, String title, int units) {
		this.setNumber(number);
		this.setTitle(title);
		this.setUnits(units);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}
}
