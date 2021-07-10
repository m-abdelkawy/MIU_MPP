package week3.lab8_streams_lamda.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
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

		// 1) Count the number of last names that begin with the letter ‘B’. Print out
		// this number.
		System.out.println(String.format("Count of employees with last name starting with 'B': %d",
				lstEmployee.stream().filter(e -> e.getLastName().startsWith("B")).count()));

		/*
		 * 2) Print out all of the Employee objects whose last name begins with the
		 * letter ‘B’ in sorted order.
		 */
		System.out.println(String.format("%nEmployees with last names starting with 'B':", 0));
		lstEmployee.stream().filter(e -> e.getLastName().startsWith("B")).forEach(e -> System.out.println(e));

		/*
		 * 3) Print out all of the Employee objects whose last name begins with the
		 * letter ‘B’ and change their first name and last name to be All capital
		 * letters.
		 */
		System.out.println(String.format("%nEmployees with last names starting with 'B' all Capital:", 0));

		lstEmployee.stream().filter(e -> e.getLastName().startsWith("B"))
				.map(e -> new Employee(e.getFirstName().toUpperCase(), e.getLastName().toUpperCase(), e.getSalary(),
						e.getDepartment()))
				.forEach(e -> System.out.println(e));

		/*
		 * 4) Print out All of the employee objects, but if the last name begins with
		 * the letter ‘B’ , then capitalize all the letters in the last name.
		 */
		System.out.println(String.format("%nAll Employees, with names starting with 'B' capitalized:", 0));
		lstEmployee.stream()
				.map(e -> new Employee(e.getFirstName(),
						e.getLastName().startsWith("B") ? e.getLastName().toUpperCase() : e.getLastName(),
						e.getSalary(), e.getDepartment()))
				.forEach(e -> System.out.println(e));

		/*
		 * 4.1) Use the Collectors.joining method to print out All Employee objects.
		 * (See my presentation file ‘Do_Last_This_Was_Lesson 9_Streams_E.docx’.)
		 */
		System.out.println(String.format("%nAll Employees, printed as comma separated string", 0));
		System.out.println(lstEmployee.stream().map(Employee::toString).collect(Collectors.joining(", ")));
		System.out.println(lstEmployee.stream().map(e -> e.toString()).collect(Collectors.joining(", ")));

		/*
		 * 4.2) Use the Collectors.joining method to print out All Employee objects, and
		 * separate each one with a delimeter of “---\n---“. (See my presentation file
		 * ‘Do_Last_This_Was_Lesson 9_Streams_E.docx’.)
		 */
		System.out.println(String.format("%nAll Employees, printed as ---\\n--- separated string", 0));
		System.out.println(lstEmployee.stream().map(Employee::toString).collect(Collectors.joining("---\\n---")));
		System.out.println(lstEmployee.stream().map(e -> e.toString()).collect(Collectors.joining("---\\n---")));

		/*
		 * 5) Print out all of the Employee objects’ last names, whose last name begins
		 * with the letter ‘I’ in sorted order, and get rid of all the duplicates. Print
		 * out only the last names.
		 */
		System.out.println(String.format("%n05. All Employees, only last names distinct(sorted by first name)", 0));
		lstEmployee.stream().filter(e -> e.getLastName().startsWith("I"))
				.sorted((e1, e2) -> e1.getFirstName().compareTo(e2.getFirstName())).map(e -> e.getLastName()).distinct()
				.forEach(System.out::println);

		/* 6) Print out the average of all the salaries. */
		System.out.println(String.format("%n06. Salary Average: ", 0));
		System.out.println(String.format("%.2f",
				lstEmployee.stream().collect(Collectors.summarizingDouble(e -> e.getSalary())).getAverage()));
		System.out.println(
				String.format("%.2f", lstEmployee.stream().collect(Collectors.averagingDouble(e -> e.getSalary()))));

		/* 7) Use the ‘reduce’ method to print out the total salary of all employees. */
		System.out.println(String.format("%n07. Total Salary using reduce: ", 0));
		System.out.println(
				String.format("%.2f", lstEmployee.stream().map(e -> e.getSalary()).reduce(0.0, (s1, s2) -> s1 + s2)));

		/*
		 * 8) Print out only the first names of all the employees. Use the ‘map’ method
		 * to accomplish this.
		 */
		System.out.println(String.format("%n08. Employees First Names: ", 0));
		lstEmployee.stream().map(e -> e.getFirstName()).forEach(System.out::println);

		/*
		 * 2-9) Create an infinite stream of even numbers (0, 2, 4, …) and then,
		 * eventually print out only the first 20 even numbers from this stream
		 */
		/*
		 * Supplier<Integer> intSupplier = new Supplier<Integer>() { };
		 */

		System.out.println(String.format("%n02_09.(Long version) Infinite stream of even numbers (Limit 20): ", 0));
		UnaryOperator<Integer> unaryOperator = new UnaryOperator<Integer>() {
			@Override
			public Integer apply(Integer t) {
				return t + 2;
			}
		};
		List<Integer> lstInt = Stream.iterate(0, unaryOperator).limit(20).collect(Collectors.toList());
		lstInt.forEach(System.out::println);

		System.out.println(String.format("%n02_09.(short version) Infinite stream of even numbers (Limit 20): ", 0));
		Stream.iterate(0, i -> i + 2).limit(20).forEach(System.out::println);
		/*
		 * a) Implement a method with the following signature and return type: public
		 * int countWords(List<String> words, char c, char d, int len)
		 */

		System.out.println("\n3---------------------");
		System.out.println(String.format("%n03_a.Test wordCount method ", 0));
		List<String> lstString1 = List.of("A", "code", "mooc", "good", "day", "call", "to", "write", "some", "Java",
				"core");
		System.out.println(String.format("Number of words: %d", countWords(lstString1, 'c', 'd', 4)));// expected 3

		/*
		 * 03_b) Use reduce to concatenate the Strings in the Stream below to form a
		 * single, space-separated String. Print the result to the console.
		 */
		System.out.println(String.format("%n03_b. Concatenate ", 0));
		Stream<String> strings1 = Stream.of("A", "good", "day", "to", "write", "some", "Java");
		System.out.println(strings1.reduce((l, r) -> l + " " + r).orElse(""));
		Stream<String> strings2 = Stream.of("A", "good", "day", "to", "write", "some", "Java");
		System.out.println(strings2.reduce("", (l, r) -> l + " " + r));

		/*
		 * c) The many Java standard methods that are in the files I gave you; create
		 * programs to use them and make sure the results are correct! (For example,
		 * test findfirst, findany, the Optional object (use generics here), orElse
		 * inside an Optional, and others …
		 */
		System.out.println(String.format("%n03_c.  ", 0));
		System.out.println(String.format("%nFindFirst example  ", 0));
		Optional<Employee> emp1 = lstEmployee.stream().filter(e -> e.getSalary() > 4000).findFirst();
		System.out.println(emp1.orElse(null));

		Optional<Employee> emp2 = lstEmployee.stream().filter(e -> e.getSalary() > 100000).findFirst();
		System.out.println(emp2.orElse(null));

		System.out.println(String.format("%nFindAny example  ", 0));
		Optional<Employee> emp11 = lstEmployee.stream().filter(e -> e.getSalary() > 4000).findAny();
		System.out.println(emp11.orElse(null));

		Optional<Employee> emp12 = lstEmployee.stream().filter(e -> e.getSalary() > 100000).findFirst();
		System.out.println(emp12.isPresent() ? emp12.get() : null);

	}

	// 03_a
	public static int countWords(List<String> words, char c, char d, int len) {
		return (int) words.stream().filter(w -> w.indexOf(c) != -1 && w.indexOf(d) == -1 && w.length() == len).count();
	}
}
