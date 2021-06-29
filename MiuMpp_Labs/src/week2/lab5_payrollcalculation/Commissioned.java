package week2.lab5_payrollcalculation;

import java.util.ArrayList;
import java.util.List;

public class Commissioned extends Employee {
	private double commission;
	private double baseSalary;
	private List<Order> lstOrder;
	private static int COMMISSIONED_ID = 1;

	public Commissioned(double baseSalary) {
		super("Commissioned#" + COMMISSIONED_ID++);
		this.baseSalary = baseSalary;
		this.lstOrder = new ArrayList<Order>();
	}

	public void addOrder(Order order) {
		if (order == null)
			return;
		lstOrder.add(order);
	}

	@Override
	double calcGrossPay(DateRange dateRange) {
		double grossPay = 0;
		for (Order order : lstOrder) {
			if (dateRange.isInRange(order.getOrderDate())) {
				commission += order.getOrderAmount() * 0.07;
			}
		}
		grossPay = baseSalary + commission;
		commission = 0;
		return grossPay;
	}

}
