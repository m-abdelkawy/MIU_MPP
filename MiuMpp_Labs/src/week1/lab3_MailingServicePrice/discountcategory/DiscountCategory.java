package week1.lab3_MailingServicePrice.discountcategory;

public abstract class DiscountCategory implements IDiscountCategory{

	@Override
	public abstract double getDiscountRatio();
	
	
	@Override
	public abstract void setDiscountRatio(double discountRatio);
}
