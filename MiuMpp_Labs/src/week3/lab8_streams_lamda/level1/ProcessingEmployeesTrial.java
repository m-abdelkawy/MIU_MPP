package week3.lab8_streams_lamda.level1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

public class ProcessingEmployeesTrial {

	/*public static void main(String[] args) {
		// initialize array of Employees
		Employee[] employees = { new Employee("Jason", "Red", 5000, "IT"), new Employee("Ashley", "Green", 7600, "IT"),
				new Employee("Matthew", "Indigo", 3587.5, "Sales"),
				new Employee("James", "Indigo", 4700.77, "Marketing"), new Employee("Luke", "Indigo", 6200, "IT"),
				new Employee("Jason", "Blue", 3200, "Sales"), new Employee("Wendy", "Brown", 4236.4, "Marketing") };

		// get List view of the Employees
		List<Employee> lstEmployee = Arrays.asList(employees);

		Predicate<Employee> salaryPredicate1 = new Predicate<Employee>() {
			@Override
			public boolean test(Employee t) {
				return t.getSalary() > 4000 && t.getSalary() <= 6000;
			}
		};

		Predicate<Employee> salaryPredicate2 = e -> e.getSalary() > 4000 && e.getSalary() <= 6000;
		

		System.out.println("Employees with salaries between 4000 and 6000: ");
		lstEmployee.stream().filter(salaryPredicate2)
		.sorted(Comparator.comparing(e->e.getSalary()))
		.forEach(System.out::println);
		
		
		Function<Employee, Double> bySalary = Employee::getSalary;
		System.out.println("Employees with salaries between 4000 and 6000: ");
		lstEmployee.stream().filter(salaryPredicate2)
		.sorted(Comparator.comparing(bySalary))
		.forEach(System.out::println);
		
		System.out.println("Employees with salaries between 4000 and 6000: ");
		Optional<Employee> empOptional= lstEmployee.stream().filter(salaryPredicate2)
		.sorted(Comparator.comparing(bySalary))
		.findFirst();
		
		System.out.println(empOptional.orElse(null));

	}*/

}
