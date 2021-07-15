package inclass.functionalprogramming_day1;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class EmployeeInfo {
	static enum SortMethod {
		BYNAME, BYSALARY
	};

	private SortMethod method;

	EmployeeInfo(SortMethod method) {
		this.method = method;
	}

	EmployeeInfo() {
	}

	void sort1(List<Employee> lstEmployee) {
		if (method == SortMethod.BYNAME) {
			Collections.sort(lstEmployee, new EmpNameComparator());
		} else if (method == SortMethod.BYSALARY) {
			Collections.sort(lstEmployee, new EmpSalaryComparator());
		}
	}

	// we need to implement the sort method so that only one type of comparator is
	// used (using Closure), using a local class
	// for the following method we may not need the method field nor the constructor

	void sort2(List<Employee> lstEmployee, SortMethod method) {
		class EmployeeComparator implements Comparator<Employee> {
			@Override
			public int compare(Employee e1, Employee e2) {
				if (method == SortMethod.BYNAME) {
					return e1.getName().compareTo(e2.getName());
				} else {
					if (e1.getSalary() > e2.getSalary())
						return 1;
					else if (e1.getSalary() == e2.getSalary())
						return 0;
					else
						return -1;
				}
			}
		}

		Collections.sort(lstEmployee, new EmployeeComparator());
	}
}
