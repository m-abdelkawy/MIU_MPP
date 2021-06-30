package week2.lab5_payrollcalculation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PayrollApp {

	public static void main(String[] args) {
		List<Employee> lstEmployee = new ArrayList<Employee>();
		
		Employee empSalaried1 = new Salaried(100000);
		lstEmployee.add(empSalaried1);
		empSalaried1.calcCompensation(1,2021);
		empSalaried1.calcCompensation(2,2021);
		empSalaried1.calcCompensation(3,2021);
		empSalaried1.calcCompensation(4,2021);
		empSalaried1.calcCompensation(5,2021);
		
		Employee empHourly1 = new Hourly(30, 40);
		lstEmployee.add(empHourly1);
		empHourly1.calcCompensation(1,2021);
		empHourly1.calcCompensation(2,2021);
		empHourly1.calcCompensation(3,2021);
		empHourly1.calcCompensation(4,2021);
		empHourly1.calcCompensation(5,2021);
		
		Employee empCommissioned1 = new Commissioned(2000);
		lstEmployee.add(empCommissioned1);
		Order o11 = new Order(1, LocalDate.of(2021, 1, 10), 5000,(Commissioned)empCommissioned1);
		Order o12 = new Order(1, LocalDate.of(2021, 1, 20), 10000,(Commissioned)empCommissioned1);
		Order o31 = new Order(1, LocalDate.of(2021, 3, 10), 7000,(Commissioned)empCommissioned1);
		Order o51 = new Order(1, LocalDate.of(2021, 5, 17), 15000,(Commissioned)empCommissioned1);
		Order o52 = new Order(1, LocalDate.of(2021, 5, 20), 16000,(Commissioned)empCommissioned1);
		Order o53 = new Order(1, LocalDate.of(2021, 5, 25), 7500,(Commissioned)empCommissioned1);
		
		
		
		empCommissioned1.calcCompensation(1,2021);
		empCommissioned1.calcCompensation(2,2021);
		empCommissioned1.calcCompensation(3,2021);
		empCommissioned1.calcCompensation(4,2021);
		empCommissioned1.calcCompensation(5,2021);


		for (Employee employee : lstEmployee) {
			employee.print();
		}
	}

}
