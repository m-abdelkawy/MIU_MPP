package week3.lab7_interfaces_object.lab2_hrapp;

import java.util.ArrayList;
import java.util.List;

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
		double companyTotalSalary = 0;
		for (Department department : lstDepartment) {
			companyTotalSalary += department.getSalary();
		}
		return companyTotalSalary;
	}
	
	public List<Department> getDepartments(){
		return lstDepartment;
	}
}
