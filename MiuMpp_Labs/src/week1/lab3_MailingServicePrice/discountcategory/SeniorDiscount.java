package week1.lab3_MailingServicePrice.discountcategory;

public class SeniorDiscount extends DiscountCategory{
	private double discountRatio = 0.15;
	

	@Override
	public double getDiscountRatio() {
		return discountRatio;
	}

	@Override
	public void setDiscountRatio(double discountRatio) {
		this.discountRatio = discountRatio;
	}
}
