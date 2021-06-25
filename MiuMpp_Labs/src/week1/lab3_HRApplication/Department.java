package week1.lab3_HRApplication;

import java.util.ArrayList;
import java.util.List;

public class Department {
	private String name;
	private String location;
	private List<Position> lstPosition;
	private Company company;

	public Department(String name, String location, Company company) {
		this.name = name;
		this.location = location;
		this.lstPosition = new ArrayList<Position>();
		this.company = company;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void addPosition(Position position) {
		if (position != null)
			this.lstPosition.add(position);
	}

	public void print() {
		System.out.println(String.format("\tDepartment: %s", name));
		lstPosition.forEach(p -> p.print());
	}

	public double getSalary() {
		double deptTotalSalary = 0;
		for (Position position : lstPosition) {
			deptTotalSalary += position.getSalary();
		}
		return deptTotalSalary;
	}

	public void printReportingHierarchy() {
		System.out.println(this.name + " Reporting Hierarchy:---");
		Position topPosition = null;
		for (Position position : lstPosition) {
			if(position.getSuperior() == null || !position.getSuperior().getDepartment().equals(this)) {
				topPosition = position.getSuperior();
			}
		}
		
		topPosition.printDownLine();
	}

	@Override
	public boolean equals(Object ob) {
		if (ob == null)
			return false;
		if (ob.getClass() != this.getClass())
			return false;
		Department dep = (Department) ob;
		boolean isEqual = dep.getName().equals(this.getName()) && dep.getLocation().equals(this.location);
		return isEqual;
	}
}
