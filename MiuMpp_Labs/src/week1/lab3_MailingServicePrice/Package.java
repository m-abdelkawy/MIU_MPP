package week1.lab3_MailingServicePrice;

import java.util.List;

import week1.lab3_MailingServicePrice.discountcategory.IDiscountCategory;
import week1.lab3_MailingServicePrice.mailingserviceprovider.IMailingServiceProvider;

public class Package {
	private String description;
	private double weight;
	private Zone zone;
	private double lowestPrice;
	private String lowestPriceProvider;
	private User user;

	public Package(String description, double wt, Zone zone, User user) {
		this.setDescription(description);
		this.weight = wt;
		this.zone = zone;
		this.user = user;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double wtInPounds) {
		this.weight = wtInPounds;
	}

	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone targetZone) {
		this.zone = targetZone;
	}

	public void calcLowestPrice(List<IMailingServiceProvider> lstCarrier) {
		double packagePrice = Double.MAX_VALUE;
		String provider = null;

		double carrierPrice = 0;

		for (IMailingServiceProvider carrier : lstCarrier) {
			carrierPrice = carrier.calculatePrice(this);
			if (carrierPrice < packagePrice) {
				packagePrice = carrierPrice;
				provider = carrier.getName();
			}
		}

		lowestPrice = user.getDiscountCategory() == null ? packagePrice
				: packagePrice * (1 - user.getDiscountCategory().getDiscountRatio());

		setLowestPriceProvider(provider);
		//System.out.println(String.format("%s%10s%.2f%10s", description, "$", finalPrice, provider));
	}

	public double getPrice() {
		return lowestPrice;
	}

	public void setPrice(double price) {
		this.lowestPrice = price;
	}

	public String getLowestPriceProvider() {
		return lowestPriceProvider;
	}

	public void setLowestPriceProvider(String lowestPriceProvider) {
		this.lowestPriceProvider = lowestPriceProvider;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
