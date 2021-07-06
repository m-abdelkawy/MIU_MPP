package week3.lab7_interfaces_object.lab2_hrapp.testing;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

import week3.lab7_interfaces_object.lab2_hrapp.Company;
import week3.lab7_interfaces_object.lab2_hrapp.Department;
import week3.lab7_interfaces_object.lab2_hrapp.Employee;
import week3.lab7_interfaces_object.lab2_hrapp.Position;

public class TestingEmployee {
	@Test
	public void empsEqual_True_EmpsAreEqual() {
		Employee emp1 = new Employee("emp1", "John", "", "Doe", LocalDate.of(1990, 5, 5), "444-555", 5000, null);
		Employee emp2 = new Employee("emp1", "John", "", "Doe", LocalDate.of(1990, 5, 5), "444-555", 5000, null);

		Assert.assertEquals(emp1, emp2);
	}

	@Test
	public void empsEqual_False_EmpsAreNotEqual() {
		Employee emp1 = new Employee("emp1", "John", "", "Doe", LocalDate.of(1990, 5, 5), "444-555", 5000, null);
		Employee emp2 = new Employee("emp2", "John", "", "Doe", LocalDate.of(1990, 5, 5), "444-555", 5000, null);

		Assert.assertNotEquals(emp1, emp2);
	}

	/*---------Testing toString()-------*/
	@Test
	public void toString_True_outputsAreEqual() {
		Employee emp = new Employee("emp1", "Ahmed", "", "Ali", LocalDate.of(1990, 5, 5), "444-555", 5000, null);

		String actual = emp.toString();
		System.out.println(actual);
		String expected = "[Name: Ahmed Ali, Birtdate: 1990-05-05, SSN: 444-555]";

		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void toString_False_outputsAreNotEqual() {
		Employee emp = new Employee("emp1", "Ahmed", "", "Ali", LocalDate.of(1990, 5, 5), "444-555", 5000, null);

		String actual = emp.toString();
		System.out.println(actual);
		String expected = "[Name: Ahmed Samir, Birtdate: 1990-05-05, SSN: 444-555]";

		Assert.assertNotEquals(expected, actual);
	}
	
	/*---------Testing hashCode()-------*/
	@Test
	public void hashCode_True_hashCodesEqual() {
		//revise - check if it should be done this way
		Employee emp11 = new Employee("emp1", "Ahmed", null, "Ali", LocalDate.of(1992, 05, 10), "444-555", 5000, null);
		Employee emp12 = new Employee("emp1", "Ahmed", null, "Ali", LocalDate.of(1992, 05, 10), "444-555", 5000, null);
		
		Assert.assertEquals(emp11, emp12);
		
		int hashCode1 = emp11.hashCode();
		int hashCode2 = emp12.hashCode();
		
		Assert.assertEquals(hashCode1, hashCode2);
	}
	
	@Test
	public void hashCode_False_hashCodesNotEqual() {
		//revise - check if it should be done this way
		Employee emp11 = new Employee("emp11", "Mohamed", null, "Ali", LocalDate.of(1992, 05, 10), "444-555", 5000, null);
		Employee emp12 = new Employee("emp12", "Ahmed", null, "Ali", LocalDate.of(1992, 05, 10), "444-555", 5000, null);
		
		Assert.assertNotEquals(emp11, emp12);
		
		int hashCode1 = emp11.hashCode();
		int hashCode2 = emp12.hashCode();
		
		Assert.assertNotEquals(hashCode1, hashCode2);
	}
	
	/*---------Testing clone()-------*/
	@Test
	public void clone_True_ObjectsClonedEqualOriginal() throws CloneNotSupportedException {
		Company comp = new Company("Microsoft");
		Department devDept = new Department("Development", "Cairo", comp);
		Position swEngrPos = new Position("Software Engineer", "Develop apps", devDept);
		
		Employee emp = new Employee("emp1", "Ahmed", null, "Ali", LocalDate.of(1991, 4, 20), "444-555", 5000, swEngrPos);
		
		Employee empCopy = (Employee)emp.clone();
		
		Assert.assertEquals(emp, empCopy);
	}
	
}
