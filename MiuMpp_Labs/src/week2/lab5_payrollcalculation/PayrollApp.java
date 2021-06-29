package week2.lab5_payrollcalculation;

import java.time.LocalDate;

public class PayrollApp {

	public static void main(String[] args) {
		Employee empSalaried1 = new Salaried(100000);
		
		empSalaried1.calcCompensation(1,2021);
		empSalaried1.calcCompensation(2,2021);
		empSalaried1.calcCompensation(3,2021);
		empSalaried1.calcCompensation(4,2021);
		empSalaried1.calcCompensation(5,2021);
		
		Employee empHourly1 = new Hourly(30, 40);
		empHourly1.calcCompensation(1,2021);
		empHourly1.calcCompensation(2,2021);
		empHourly1.calcCompensation(3,2021);
		empHourly1.calcCompensation(4,2021);
		empHourly1.calcCompensation(5,2021);
		
		Employee empCommissioned1 = new Commissioned(2000);
		Order o11 = new Order(1, LocalDate.of(2021, 1, 10), 500,(Commissioned)empCommissioned1);
		Order o12 = new Order(1, LocalDate.of(2021, 1, 20), 1000,(Commissioned)empCommissioned1);
		Order o31 = new Order(1, LocalDate.of(2021, 3, 10), 700,(Commissioned)empCommissioned1);
		Order o51 = new Order(1, LocalDate.of(2021, 5, 17), 1500,(Commissioned)empCommissioned1);
		Order o52 = new Order(1, LocalDate.of(2021, 5, 20), 1600,(Commissioned)empCommissioned1);
		Order o53 = new Order(1, LocalDate.of(2021, 5, 25), 750,(Commissioned)empCommissioned1);
		
		
		
		empCommissioned1.calcCompensation(1,2021);
		empCommissioned1.calcCompensation(2,2021);
		empCommissioned1.calcCompensation(3,2021);
		empCommissioned1.calcCompensation(4,2021);
		empCommissioned1.calcCompensation(5,2021);
		
		//empSalaried1.print();
		//empHourly1.print();
		empCommissioned1.print();
	}

}
