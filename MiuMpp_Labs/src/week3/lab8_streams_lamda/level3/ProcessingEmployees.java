package week3.lab8_streams_lamda.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProcessingEmployees {

	public static void main(String[] args) {
		// initialize array of Employees
		Employee[] employees = { new Employee("Jason", "Red", 5000, "IT"), new Employee("Ashley", "Green", 7600, "IT"),
				new Employee("Matthew", "Indigo", 3587.5, "Sales"),
				new Employee("James", "Indigo", 4700.77, "Marketing"), new Employee("Luke", "Indigo", 6200, "IT"),
				new Employee("Jason", "Blue", 3200, "Sales"), new Employee("Wendy", "Brown", 4236.4, "Marketing") };

		// get List view of the Employees
		List<Employee> lstEmployee = Arrays.asList(employees);

		// a) Print out each department and the average salary for the department.
		Map<String, Double> avgSalaryByDept = lstEmployee.stream().collect(Collectors
				.groupingBy(Employee::getDepartment, TreeMap::new, Collectors.averagingDouble(Employee::getSalary)));

		System.out.println(String.format("07.a average salary by department-----", 0));
		avgSalaryByDept.forEach((dept, avgSalary) -> {
			System.out.println(String.format("%s%n  Average Salary: %.2f", dept, avgSalary));
		});

		// b) Print out each department and the maximum salary for the department.
		Map<String, Optional<Employee>> maxSalaryByDept = lstEmployee.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, TreeMap::new,
						Collectors.maxBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))));

		System.out.println(String.format("%n07.b Max. salary by department-----", 0));
		maxSalaryByDept.forEach((dept, empOptional) -> {
			System.out.println(String.format("%s%n  Max. Salary: %.2f", dept,
					empOptional.isPresent() ? empOptional.get().getSalary() : 0));
		});

		// c) Print out each department and all of the employees who work at that
		// department.
		System.out.printf("%n07.c Employees by department:%n");
		Map<String, List<Employee>> groupedByDepartment = lstEmployee.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment));

		groupedByDepartment.forEach((department, employeesInDepartment) -> {
			System.out.println(department);
			employeesInDepartment.forEach(employee -> System.out.printf("   %s%n", employee));
		});

	}
}
