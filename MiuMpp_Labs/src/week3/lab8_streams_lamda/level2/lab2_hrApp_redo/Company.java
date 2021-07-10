package week3.lab8_streams_lamda.level2.lab2_hrApp_redo;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class Company {
	private String name;
	private List<Department> lstDepartment;

	public Company(String name) {
		this.name = name;
		this.lstDepartment = new ArrayList<Department>();
	}

	public void addDepartment(Department department) {
		if (department != null)
			lstDepartment.add(department);
	}

	public void print() {
		System.out.println(String.format("Company: %s", name));
		lstDepartment.forEach(d -> d.print());
	}

	public double getSalary() {
		/*
		 * double companyTotalSalary = 0; for (Department department : lstDepartment) {
		 * companyTotalSalary += department.getSalary(); } return companyTotalSalary;
		 */

		// using stream API
		// method 1
		/*
		 * DoubleSummaryStatistics summaryStatistics = lstDepartment.stream()
		 * .collect(Collectors.summarizingDouble(Department::getSalary)); return
		 * summaryStatistics.getSum();
		 */

		// method 2
		return lstDepartment.stream().map(Department::getSalary).reduce((x, y) -> x + y).orElse(0d);
	}

	public List<Department> getDepartments() {
		return lstDepartment;
	}
}
