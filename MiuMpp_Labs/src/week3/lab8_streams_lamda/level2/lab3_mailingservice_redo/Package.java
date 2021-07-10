package week3.lab8_streams_lamda.level2.lab3_mailingservice_redo;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import week3.lab8_streams_lamda.level2.lab3_mailingservice_redo.mailingserviceprovider.IMailingServiceProvider;


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
		
		double minPrice = lstCarrier.stream().mapToDouble(c->c.calculatePrice(this)).min().orElse(0d);


		/*String providerName = lstCarrier.stream().map(c->new Object() {
			final Double price=c.calculatePrice(this);
			String provString = c.getName();
		}).sorted((o1,o2)->o1.price.compareTo(o2.price)).findFirst().orElse(null);*/

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
