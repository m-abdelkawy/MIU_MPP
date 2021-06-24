package lab1_school;

import java.util.ArrayList;
import java.util.List;

public class Department {
	private String name;
	private List<Person> lstMember;

	public Department(String _name) {
		name = _name;
		lstMember = new ArrayList<Person>();
	}

	public double getTotalSalary() {
		double sum = 0;
		for (Person person : lstMember) {
			sum += person.getSalary();
		}
		return sum;
	}

	public void addPerson(Person person) {
		lstMember.add(person);
	}

	public void showAllMembers() {
		lstMember.forEach(m -> System.out.println(String.format("Name: %s%nPhone: %s%nAge: %d%ntype: %s%n", m.name,
				m.phone, m.age, m.getClass().getSimpleName())));
	}

	public void unitsPerFaculty() {
		lstMember.forEach(m -> {
			if (m instanceof Faculty)
				System.out.println(
						String.format("Faculty: %s%nUnits: %d%n", ((Faculty) m).name, ((Faculty) m).getTotalUnits()));
		});
	}

	public void showStudentsByFacultyMember(String name) {
		Person faculty = lstMember.stream().filter(f -> f.name.toLowerCase().equals(name.toLowerCase())).findFirst()
				.get();
		if (!(faculty instanceof Faculty))
			return;
		List<Course> lstFacultyCourses = ((Faculty) faculty).getCourses();

		List<String> lstStudentName = new ArrayList<String>();

		for (Course course : lstFacultyCourses) {
			lstMember.stream().filter(s -> s.getCourses() != null && s.getCourses().contains(course)).forEach(s -> {
				if (s instanceof Student && !lstStudentName.contains(s.name)) // in order not to duplicate names
					lstStudentName.add(s.name);
			});
		}

		lstStudentName.forEach(n -> System.out.println(n));
	}
}
