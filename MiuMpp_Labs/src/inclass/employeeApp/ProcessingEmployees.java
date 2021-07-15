package inclass.employeeApp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.TreeMap;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ProcessingEmployees {

	public static void main(String[] args) {
		// initialize array of Employees
		Employee[] employees = { new Employee("Jason", "Red", 5000, "IT"), new Employee("Ashley", "Green", 7600, "IT"),
				new Employee("Matthew", "Indigo", 3587.5, "Sales"),
				new Employee("James", "Indigo", 4700.77, "Marketing"), new Employee("Luke", "Indigo", 6200, "IT"),
				new Employee("Jason", "Blue", 3200, "Sales"), new Employee("Wendy", "Brown", 4236.4, "Marketing") };

		// get list view of employees
		List<Employee> lstEmployee = Arrays.asList(employees);

		System.out.println(String.format("Complete Employees List:", 0));
		lstEmployee.stream().forEach(System.out::println);

		System.out.println(String.format("%nEmployees with salaries between 4000 and 6000:", 0));
		lstEmployee.stream().filter(e -> e.getSalary() >= 4000 && e.getSalary() <= 6000).forEach(System.out::println);

		System.out.println(String.format("%nEmployees with salaries between 4000 and 6000:", 0));
		// writing predicate and consumer the long way
		Predicate<Employee> betweer4Kand6K = new Predicate<Employee>() {
			@Override
			public boolean test(Employee emp) {
				return emp.getSalary() >= 4000 && emp.getSalary() <= 6000;
			}
		};

		Consumer<Employee> printer = new Consumer<Employee>() {
			@Override
			public void accept(Employee e) {
				System.out.println(e);
			}
		};
		lstEmployee.stream().filter(betweer4Kand6K).forEach(printer);

		System.out.println(String.format("%nFirst Employee with salaries between 4000 and 6000:", 0));
		Employee emp1 = lstEmployee.stream().filter(betweer4Kand6K).findFirst().orElseGet(null);
		System.out.println(emp1);

		System.out.println(String.format("%nEmployees Sorted ascending by lastname then firstname:", 0));
		Function<Employee, String> byLastName = e -> e.getLastName();
		Function<Employee, String> byFirstName = Employee::getFirstName;
		Comparator<Employee> lastThenFirst = Comparator.comparing(byLastName).thenComparing(byFirstName);

		lstEmployee.stream().sorted(lastThenFirst).forEach(System.out::println);

		System.out.println(String.format("%nEmployees Sorted descending by lastname then firstname:", 0));
		lstEmployee.stream().sorted(lastThenFirst.reversed()).forEach(System.out::println);

		System.out.println(String.format("%nUnique last names sorted ascending:", 0));
		lstEmployee.stream().map(e -> e.getLastName()).distinct().sorted().forEach(System.out::println);

		System.out.println(String.format("%nUnique last names sorted descending:", 0));
		lstEmployee.stream().map(e -> e.getLastName()).distinct().sorted(String.CASE_INSENSITIVE_ORDER.reversed())
				.forEach(System.out::println);

		System.out.println("--------------Grouping--------------");
		System.out.println(String.format("%nEmployees By Department", 0));
		Map<String, List<Employee>> groupedByDept = lstEmployee.stream()
				.collect(Collectors.groupingBy(e -> e.getDepartment()));

		groupedByDept.forEach((dept, empsInDept) -> {
			System.out.println(dept);
			empsInDept.forEach(System.out::println);
		});

		System.out.println(String.format("%nCount Employees By Department", 0));
		Map<String, Long> empCountByDept = lstEmployee.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, TreeMap::new, Collectors.counting()));

		empCountByDept.forEach((key, value) -> {
			System.out.println(key + ": " + value);
		});

		System.out.println(String.format("%ncodeLine %d_ Sum Of Employees Salary: $%.2f", getLineNumber(),
				lstEmployee.stream().mapToDouble(Employee::getSalary).sum()));
		System.out.println(String.format("%ncodeLine %d_ Sum Of Employees Salary(using reduce(OptionalDouble)): $%.2f",
				getLineNumber(),
				lstEmployee.stream().mapToDouble(Employee::getSalary).reduce((x, y) -> x + y).orElse(0)));

		System.out.println(String.format("%ncodeLine %d_ Sum Of Employees Salary(using reduce(double)): $%.2f",
				getLineNumber(), lstEmployee.stream().mapToDouble(Employee::getSalary).reduce(0, (x, y) -> x + y)));

		System.out.println(String.format("%ncodeLine %d_ Average Of Employees Salary: $%.2f",
				getLineNumber(), lstEmployee.stream().mapToDouble(Employee::getSalary).average().orElse(0)));

	}

	public static int getLineNumber() {
		return Thread.currentThread().getStackTrace()[2].getLineNumber();
	}
}
