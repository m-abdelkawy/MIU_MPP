package inclass.functionalprogramming_day1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

import inclass.functionalprogramming_day1.EmployeeInfo.SortMethod;

public class ProcessingEmployeesTrial {

	public static void main(String[] args) {
		// initialize array of Employees
		Employee[] employees = { new Employee("Jason", "Red", 5000, "IT"), new Employee("Ashley", "Green", 7600, "IT"),
				new Employee("Matthew", "Indigo", 3587.5, "Sales"),
				new Employee("James", "Indigo", 4700.77, "Marketing"), new Employee("Luke", "Indigo", 6200, "IT"),
				new Employee("Jason", "Blue", 3200, "Sales"), new Employee("Wendy", "Brown", 4236.4, "Marketing") };

		// get List view of the Employees
		List<Employee> lstEmployee = Arrays.asList(employees);

		// EmployeeInfo empInfo11 = new EmployeeInfo(SortMethod.BYNAME);
		// EmployeeInfo empInfo12 = new EmployeeInfo(SortMethod.BYSALARY);

		// using sort1 by name
		// empInfo11.sort1(lstEmployee);
		// System.out.println(String.format("Employees sorted by name: %n%s",
		// lstEmployee));

		// using sort1 by salary
		// empInfo12.sort1(lstEmployee);
		// System.out.println(String.format("Employees sorted by salary: %n%s",
		// lstEmployee));

		// EmployeeInfo empInfo21 = new EmployeeInfo();

		// using sort2 by name
		// empInfo21.sort2(lstEmployee, SortMethod.BYNAME);
		// System.out.println(String.format("Employees sorted by name: %n%s",
		// lstEmployee));

		// using sort2 by salary
		// empInfo21.sort2(lstEmployee, SortMethod.BYSALARY);
		// System.out.println(String.format("Employees sorted by salary: %n%s",
		// lstEmployee));

		char letter = 'J';

		for (Employee employee : lstEmployee) {
			if (employee.getFirstName().startsWith(Character.valueOf(letter).toString())) {
				System.out.println(employee);
			}
		}

		System.out.println("\nParallel Stream: ");

		lstEmployee.parallelStream().filter(emp -> emp.getFirstName().startsWith(Character.valueOf(letter).toString()))
				.map(emp -> new Employee(emp.getFirstName().toUpperCase(), emp.getLastName().toUpperCase(),
						emp.getSalary(), emp.getDepartment()))
				.sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())).forEach(System.out::println);
		
		System.out.println();

		lstEmployee.stream().filter(emp -> emp.getFirstName().startsWith(Character.valueOf(letter).toString()))
				.map(emp -> new Employee(emp.getFirstName().toUpperCase(), emp.getLastName().toUpperCase(),
						emp.getSalary(), emp.getDepartment()))
				.sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())).forEach(System.out::println);
	}

}
