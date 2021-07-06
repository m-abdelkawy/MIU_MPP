package week3.lab7_interfaces_object.lab1_school.testing;

import org.junit.Assert;
import org.junit.Test;

import week3.lab7_interfaces_object.lab1_school.IPerson;
import week3.lab7_interfaces_object.lab1_school.Person;


public class TestingPerson {
	@Test
	public void myDefault_true_outPutEquals() {
		Person p = new Person("Ahmed Ali", "444-555", 35);
		String actual = p.myDefault();
		Assert.assertEquals("From default method", actual);
	}
	
	@Test
	public void myStatic_True_outputEquals() {
		String actual = IPerson.myStatic();
		Assert.assertEquals("From static method", actual);
	}
	
	@Test
	public void myAbstract_True_outputEquals() {
		Person p = new Person("Ahmed Ali", "444-555", 35);
		String actual = p.myAbstract();
		Assert.assertEquals("From abstract method", actual);
	}
}
