package week2.lab5_payrollcalculation;

import java.time.LocalDate;

public class Order {
	private int orderNo;
	private LocalDate orderDate;
	private int orderAmount;
	private Commissioned commissionedEmployee;

	public Order(int orderNo, LocalDate orderDate, int orderAmount, Commissioned commissioned) {
		this.orderNo = orderNo;
		this.orderDate = orderDate;
		this.orderAmount = orderAmount;
		this.commissionedEmployee = commissioned;
		this.commissionedEmployee.addOrder(this);
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public int getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}
}
