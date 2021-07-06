package week3.lab7_interfaces_object.lab2_hrapp.testing;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

import week3.lab7_interfaces_object.lab2_hrapp.Department;
import week3.lab7_interfaces_object.lab2_hrapp.Employee;
import week3.lab7_interfaces_object.lab2_hrapp.Position;

public class DepartmentTesting {
	/*---------Testing equals()-------*/
	@Test
	public void deptEquals_True_DeptsAreEqual() {
		Department dept1 = new Department("IT", "Cairo", null);
		Department dept2 = new Department("IT", "Cairo", null);
		Assert.assertEquals(dept1, dept2);
	}

	@Test
	public void deptEquals_False_DeptsAreNotEqual() {
		Department dept1 = new Department("IT", "Cairo", null);
		Department dept2 = new Department("Structural Engineering", "Cairo", null);
		Assert.assertNotEquals(dept1, dept2);
	}

	/*---------Testing toString()-------*/
	@Test
	public void toString_True_outputsAreEqual() {
		Department dept = new Department("IT", "Cairo", null);

		String actual = dept.toString();
		String expected = "[Name: IT, Location: Cairo]";
		
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void toString_False_outputsAreNotEqual() {
		Department dept = new Department("IT", "Cairo", null);

		String actual = dept.toString();
		String notExpected = "[Name: Structural Engineering, Location: Cairo]";

		Assert.assertNotEquals(notExpected, actual);
	}
	
	/*---------Testing hashCode()-------*/
	@Test
	public void hashCode_True_hashCodesEqual() {
		//revise - check if it should be done this way
		Department dept1 = new Department("IT", "Cairo", null);
		Department dept2 = new Department("IT", "Cairo", null);
		Assert.assertEquals(dept1, dept2);
		int hashCode1 = dept1.hashCode();
		int hashCode2 = dept2.hashCode();
		Assert.assertEquals(hashCode1, hashCode2);
	}
	
	@Test
	public void hashCode_False_hashCodesNotEqual() {
		//revise - check if it should be done this way
		Department dept1 = new Department("IT", "Cairo", null);
		Department dept2 = new Department("Structural Engineering", "Cairo", null);
		Assert.assertNotEquals(dept1, dept2);
		int hashCode1 = dept1.hashCode();
		int hashCode2 = dept2.hashCode();
		Assert.assertNotEquals(hashCode1, hashCode2);
	}
	
	
}
