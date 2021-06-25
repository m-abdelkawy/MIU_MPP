package week1.lab3_HRApplication;

import java.time.LocalDate;
import java.util.List;

public class HRApplication {

	public static void main(String[] args) {
		Company aspenCompany = new Company("ASPEN Engineering Company");

		// Departmants
		Department boardDepartment = new Department("Board", "Cairo", aspenCompany);
		Department strDepartment = new Department("Structural Engineering", "Cairo", aspenCompany);
		Department arcDepartment = new Department("Architectural Engineering", "Cairo", aspenCompany);
		Department mechDepartment = new Department("Mechanical Engineering", "Cairo", aspenCompany);

		aspenCompany.addDepartment(boardDepartment);
		aspenCompany.addDepartment(strDepartment);
		aspenCompany.addDepartment(arcDepartment);
		aspenCompany.addDepartment(mechDepartment);

		// positions
		Position strSecDirector = new Position("Structural Department Director",
				"Stakeholder, responsible for the structural department section", boardDepartment);

		boardDepartment.addPosition(strSecDirector);

		Position strDesignSecHead = new Position("Structural Department Section Head",
				"Provide consultations and revise projects", strDepartment);

		Position leadStrDesign1 = new Position("Structural Lead Design Engineer 1",
				"Performs structural analysis of concrete, steel and timber structures", strDepartment);

		Position srStrDesign1 = new Position("Senior Structural Design Engineer 1",
				"Performs structural analysis of concrete, steel and timber structures", strDepartment);

		Position jrStrDesign1 = new Position("Junior Structural Design Engineer 1",
				"Performs structural analysis of concrete, steel and timber structures", strDepartment);

		Position leadStrDesign2 = new Position("Structural Lead Design Engineer 2",
				"Performs structural analysis of concrete, steel and timber structures", strDepartment);

		Position srStrDesign2 = new Position("Senior Structural Design Engineer 2",
				"Performs structural analysis of concrete, steel and timber structures", strDepartment);

		Position jrStrDesign2 = new Position("Junior Structural Design Engineer 2",
				"Performs structural analysis of concrete, steel and timber structures", strDepartment);

		Position strDraftsman = new Position("Draftsman", "does structural drafting", strDepartment);

		strDepartment.addPosition(strDesignSecHead);
		strDepartment.addPosition(leadStrDesign1);
		strDepartment.addPosition(srStrDesign1);
		strDepartment.addPosition(jrStrDesign1);
		strDepartment.addPosition(strDraftsman);

		strDepartment.addPosition(leadStrDesign2);
		strDepartment.addPosition(srStrDesign2);
		strDepartment.addPosition(jrStrDesign2);

		Position interiorDesigner = new Position("Interior Designer",
				"Does the interior design using 3ds max, Lumion and revit", arcDepartment);
		Position architect = new Position("Architect", "Performs Design of buildings using Revit, AutoCAD",
				arcDepartment);
		Position shopDwgArchitect = new Position("Shop Drawing Architect",
				"Performs structural analysis of concrete, steel and timber structures", arcDepartment);

		arcDepartment.addPosition(interiorDesigner);
		arcDepartment.addPosition(architect);
		arcDepartment.addPosition(shopDwgArchitect);

		Position mechEngineer = new Position("Mechanical Design Engineer",
				"Design mechanical components of the buidings using REVIT..", mechDepartment);
		Position mepEngineer = new Position("MEP Engineer", "Model mechanical components of the buidings using REVIT..",
				mechDepartment);
		Position maintenanceEngineer = new Position("Maintenance Engineer",
				"Supervise Maintenance of mechanical components of the buidings using REVIT..", mechDepartment);

		mechDepartment.addPosition(mechEngineer);
		mechDepartment.addPosition(mepEngineer);
		mechDepartment.addPosition(maintenanceEngineer);

		/*------------------------------------------Creating Employees*/
		Employee hesham = new Employee("strDir1", "Hesham", "", "Ahmed", LocalDate.of(1970, 8, 10), "554-15114", 30000,
				strSecDirector);

		Employee ashrafKhalifa = new Employee("strHead1", "Ashraf", "", "Khalifa", LocalDate.of(1975, 8, 12),
				"554-56698", 25000, strDesignSecHead);

		Employee ahmedAli = new Employee("strLead1", "Ahmed", "", "Ali", LocalDate.of(1988, 5, 25), "554-11111", 15000,
				leadStrDesign1);
		Employee mohammedAbdelkawy = new Employee("strSr2", "Mohammed", "", "Abdelkawy", LocalDate.of(1991, 10, 4),
				"554-11112", 12000, srStrDesign1);
		Employee adelJr = new Employee("strJr2", "Mohammed", "", "Adel", LocalDate.of(1990, 6, 01), "554-11115", 9000,
				jrStrDesign1);

		Employee mohamedSafwat = new Employee("str1", "Mohammed", "", "Safwat", LocalDate.of(1988, 5, 25), "554-11111", 15000,
				leadStrDesign2);
		Employee mohammedHammam = new Employee("str2", "Mohammed", "", "Hammam", LocalDate.of(1989, 6, 01), "554-11112",
				12000, srStrDesign2);
		Employee emanAhmed = new Employee("str2", "Eman", "", "Ahmed", LocalDate.of(1990, 6, 01), "554-11115", 12000,
				jrStrDesign2);

		Employee hebaMagdy = new Employee("arch1", "Heba", "", "Magdy", LocalDate.of(1990, 8, 10), "554-11113", 12000,
				interiorDesigner);
		Employee johnDoe = new Employee("arch2", "John", "", "Doe", LocalDate.of(1989, 7, 15), "554-11114", 9000,
				shopDwgArchitect);

		// fill positions
		strSecDirector.setEmployee(hesham);
		
		strDesignSecHead.setEmployee(ashrafKhalifa);
		
		leadStrDesign1.setEmployee(ahmedAli);
		srStrDesign1.setEmployee(mohammedAbdelkawy);
		jrStrDesign1.setEmployee(adelJr);

		leadStrDesign2.setEmployee(mohamedSafwat);
		srStrDesign2.setEmployee(mohammedHammam);
		jrStrDesign2.setEmployee(emanAhmed);

		interiorDesigner.setEmployee(hebaMagdy);
		shopDwgArchitect.setEmployee(johnDoe);

		System.out.println("Lab 3.1_________");
		// print company's hierarchy
		aspenCompany.print();

		// position reporting hierarchy in the structural engineering department 
		strSecDirector.addInferior(strDesignSecHead);

		strDesignSecHead.addInferior(leadStrDesign1);
		strDesignSecHead.addInferior(leadStrDesign2);

		leadStrDesign1.addInferior(srStrDesign1);
		srStrDesign1.addInferior(jrStrDesign1);
		srStrDesign1.addInferior(strDraftsman);

		leadStrDesign2.addInferior(srStrDesign2);
		srStrDesign2.addInferior(jrStrDesign2);

		

		System.out.println();
		System.out.println("Lab 3.2_________");
		System.out.print("Total Salary Paid by the company: ");
		System.out.println(aspenCompany.getSalary() + " Egyptian Pounds");
		System.out.println();
		List<Department> aspenDepartments =  aspenCompany.getDepartments();
		for (Department dep : aspenDepartments) {
			System.out.println(String.format("%s Department Total Salary: %.2f EGP", dep.getName(), dep.getSalary()));
		}

		
		System.out.println();
		System.out.println("Lab 3.3_________");
		System.out.println("PrintDownLine for leadStrDesign1:--");
		leadStrDesign1.printDownLine();

		//leadStrDesign1.printDownLine2();
		System.out.println();
		//Structural section department hierarchy print
		strDepartment.printReportingHierarchy();
	}

}
