package week3.lab8_streams_lamda.level2.lab2_hrApp_redo;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

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
		/*
		 * double deptTotalSalary = 0; for (Position position : lstPosition) {
		 * deptTotalSalary += position.getSalary(); } return deptTotalSalary;
		 */

		// using stream API
		// 01. using summary statistics
		/*
		 * DoubleSummaryStatistics summaryStatistics = lstPosition.stream()
		 * .collect(Collectors.summarizingDouble(Position::getSalary)); return
		 * summaryStatistics.getSum();
		 */

		// 02. using reduce method
		return lstPosition.stream().map(Position::getSalary).reduce((x, y) -> x + y).orElse(0d);
	}

	public void printReportingHierarchy() {
		System.out.println(this.name + " Reporting Hierarchy:---");
		/*
		 * Position topPosition = null; for (Position position : lstPosition) { if
		 * (position.getSuperior() == null ||
		 * !position.getSuperior().getDepartment().equals(this)) { topPosition =
		 * position.getSuperior(); } }
		 */

		// using stream API
		Position topPosition = lstPosition.stream()
				.filter(p -> p.getSuperior() != null && !p.getSuperior().getDepartment().equals(this)).findFirst()
				.orElse(null);

		if (topPosition == null)
			return;

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
