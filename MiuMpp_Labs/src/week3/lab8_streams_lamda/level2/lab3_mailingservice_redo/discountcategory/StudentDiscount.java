package week3.lab8_streams_lamda.level2.lab3_mailingservice_redo.discountcategory;

public class StudentDiscount extends DiscountCategory {
	private double discountRatio = 0.10;

	@Override
	public double getDiscountRatio() {
		return discountRatio;
	}

	@Override
	public void setDiscountRatio(double discountRatio) {
		this.discountRatio = discountRatio;
	}
}
