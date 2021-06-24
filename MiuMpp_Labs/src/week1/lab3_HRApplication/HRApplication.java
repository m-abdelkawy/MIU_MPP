package week1.lab3_HRApplication;

import java.time.LocalDate;

public class HRApplication {

	public static void main(String[] args) {
		Company aspenCompany = new Company("ASPEN Engineering Company");

		// Departmants
		Department strDepartment = new Department("Structural Engineering", "Cairo", aspenCompany);
		Department arcDepartment = new Department("Architectural Engineering", "Cairo", aspenCompany);
		Department mechDepartment = new Department("Mechanical Engineering", "Cairo", aspenCompany);

		aspenCompany.addDepartment(strDepartment);
		aspenCompany.addDepartment(arcDepartment);
		aspenCompany.addDepartment(mechDepartment);

		// positions
		Position jrStrDesign = new Position("Junior Structural Design Engineer",
				"Performs structural analysis of concrete, steel and timber structures", strDepartment);
		Position srStrDesign = new Position("Senior Structural Design Engineer",
				"Performs structural analysis of concrete, steel and timber structures", strDepartment);
		Position leadStrDesign = new Position("Structural Lead Design Engineer",
				"Performs structural analysis of concrete, steel and timber structures", strDepartment);
		Position strDraftsman = new Position("Draftsman", "does structural desi", strDepartment);

		strDepartment.addPosition(jrStrDesign);
		strDepartment.addPosition(srStrDesign);
		strDepartment.addPosition(leadStrDesign);
		strDepartment.addPosition(strDraftsman);

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
		Employee ahmedAli = new Employee("str1", "Ahmed", "", "Ali", LocalDate.of(1988, 5,25), "554-11111", 15000, leadStrDesign);
		Employee mohammedHammam = new Employee("str2", "Mohammed", "", "Hammam", LocalDate.of(1989, 6, 01), "554-11112", 12000, srStrDesign);
		Employee adelJr = new Employee("str2", "Mohammed", "", "Adel", LocalDate.of(1990, 6, 01), "554-11115", 12000, jrStrDesign);
		
		Employee hebaMagdy = new Employee("arch1", "Heba", "", "Magdy", LocalDate.of(1990, 8, 10), "554-11113", 12000, interiorDesigner);
		Employee johnDoe = new Employee("arch2", "John", "", "Doe", LocalDate.of(1989, 7, 15), "554-11114", 9000, shopDwgArchitect);
		
		//fill positions
		leadStrDesign.setEmployee(ahmedAli);
		srStrDesign.setEmployee(mohammedHammam);
		jrStrDesign.setEmployee(adelJr);
		
		interiorDesigner.setEmployee(hebaMagdy);
		shopDwgArchitect.setEmployee(johnDoe);
		
		//print company's hierarchy
		aspenCompany.print();


		//position reporting hierarchy
		leadStrDesign.addInferior(srStrDesign);
		srStrDesign.addInferior(jrStrDesign);
		srStrDesign.addInferior(strDraftsman);
		
		leadStrDesign.printDownLine();
		
		//char spaceString = ' '>>>20;
		//System.out.println(leadStrDesign.printDownLine());
		
		strDepartment.printReportingHierarchy();
	}

}
