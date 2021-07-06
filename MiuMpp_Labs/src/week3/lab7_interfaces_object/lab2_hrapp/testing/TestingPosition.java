package week3.lab7_interfaces_object.lab2_hrapp.testing;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

import week3.lab7_interfaces_object.lab2_hrapp.Company;
import week3.lab7_interfaces_object.lab2_hrapp.Department;
import week3.lab7_interfaces_object.lab2_hrapp.Employee;
import week3.lab7_interfaces_object.lab2_hrapp.Position;

public class TestingPosition {
	/*---------Testing equals()-------*/
	@Test
	public void posEquals_True_PositionsAreEqual() {
		Company comp = new Company("comp1");
		Department strEngDept = new Department("Structural Engineering", "Cairo", comp);
		Position pos1 = new Position("Software Engineer", "Develop apps", strEngDept);
		Position pos2 = new Position("Software Engineer", "Develop apps", strEngDept);
		
		Assert.assertEquals(pos1, pos2);
	}

	@Test
	public void posEquals_False_PositionsAreNotEqual1() {
		Company comp = new Company("comp1");
		Department strEngDept = new Department("Structural Engineering", "Cairo", comp);
		Position pos1 = new Position("Software Engineer", "Develop apps", strEngDept);
		Position pos2 = new Position("Structural Engineer", "Design bridges", strEngDept);
		
		Assert.assertNotEquals(pos1, pos2);
	}
	
	@Test
	public void posEquals_False_PositionsAreNotEqual2() {
		Company comp = new Company("comp1");
		Department strEngDept = new Department("Structural Engineering", "Cairo", comp);
		Department itDept = new Department("IT", "Cairo", comp);
		Position pos1 = new Position("Software Engineer", "Develop apps", itDept);
		Position pos2 = new Position("Software Engineer", "Develop apps", strEngDept);
		
		Assert.assertNotEquals(pos1, pos2);
	}
	
	/*---------Testing toString()-------*/
	@Test
	public void toString_True_outputsAreEqual() {
		Position pos = new Position("Structural Engineer", "Designs buildings", null);
		String actual = pos.toString();
		String expected = "[Name: Structural Engineer, Description: Designs buildings]";

		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void toString_False_outputsAreNotEqual() {
		Position pos = new Position("Software Engineer", "Designs buildings", null);
		String actual = pos.toString();
		String expected = "[Name: Structural Engineer, Description: Designs buildings]";
		
		Assert.assertNotEquals(expected, actual);
	}
	
	/*---------Testing clone()-------*/
	@Test
	public void clone_True_ObjectsClonedEqualOriginal() throws CloneNotSupportedException {
		Company comp = new Company("Microsoft");
		Department devDept = new Department("Development", "Cairo", comp);
		Position swEngrPos = new Position("Software Engineer", "Develop apps", devDept);
		
		Position posCopy = (Position)swEngrPos.clone();
		
		Assert.assertEquals(swEngrPos, posCopy);
	}
}
