package week3.lab7_interfaces_object.lab2_hrapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Position implements Cloneable{
	private String name;
	private String description;
	private Employee employee;
	private Department department;

	private static String SPACING = "";
	private static boolean ISNEWLVL = false;

	private Position superior;
	private List<Position> lstInferior;

	public Position(String name, String description, Department department) {
		this.name = name;
		this.description = description;
		this.setDepartment(department);
		this.lstInferior = new ArrayList<Position>();
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void print() {
		System.out.print(String.format("\t\t%s: ", name));
		if (employee != null)
			employee.print();
		else
			System.out.println("Empty");
	}

	public double getSalary() {
		return employee == null ? 0 : employee.getSalary();
	}

	public void printDownLine() {
		System.out.println(getDownLine());
	}

	private String getDownLine() {
		StringBuilder sb = new StringBuilder(this.name);

		for (Position inferior : lstInferior) {
			sb.append("\n");
			sb.append(inferior.getDownLine().replaceAll("(?m)^", "  "));
		}
		return sb.toString();
	}

	public void printDownLine2() {
		System.out.println(SPACING + name);
		boolean sameLvl = false;
		int lvlCount = 0;
		for (Position position : lstInferior) {
			if (!sameLvl) {
				SPACING = SPACING.concat("  ");
				lvlCount++;
			}
			position.printDownLine2();
			if (sameLvl && position.name.equals(lstInferior.get(lstInferior.size() - 1).name)) {
				lvlCount++;
				for (int i = 0; i < lvlCount; i++) {
					SPACING = SPACING.substring(0, SPACING.lastIndexOf(" ") - 1);
				}
			}
			sameLvl = true;
		}
	}

	public Position getSuperior() {
		return superior;
	}

	public void setSuperior(Position superior) {
		this.superior = superior;
		if (!this.superior.lstInferior.contains(this))
			this.superior.lstInferior.add(this);
	}

	public List<Position> getLstInferior() {
		// change to return a copy
		return lstInferior;
	}

	public void addInferior(Position inferior) {
		if (!this.lstInferior.contains(inferior))
			this.lstInferior.add(inferior);
		inferior.setSuperior(this);
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public boolean equals(Object ob) {
		if (ob == null)
			return false;
		if (!(ob instanceof Position))
			return false;
		Position pos = (Position) ob;
		boolean isEqual = this.name.equals(pos.name) && this.description.equals(pos.description)
				&& this.department.equals(pos.department);
		return isEqual;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		sb.append(String.format("Name: %s, Description: %s", this.name, this.description));
		sb.append("]");
		return sb.toString();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name, description, department);
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		Position copy = (Position)super.clone();
		copy.department = (Department)department.clone();
		return copy;
	}
}
