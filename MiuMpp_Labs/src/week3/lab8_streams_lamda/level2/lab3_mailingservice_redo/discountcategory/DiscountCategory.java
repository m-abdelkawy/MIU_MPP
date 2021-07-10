package week3.lab8_streams_lamda.level2.lab3_mailingservice_redo.discountcategory;

public abstract class DiscountCategory implements IDiscountCategory{

	@Override
	public abstract double getDiscountRatio();
	
	
	@Override
	public abstract void setDiscountRatio(double discountRatio);
}
