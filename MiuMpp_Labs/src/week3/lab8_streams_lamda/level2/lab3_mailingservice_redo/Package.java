package week3.lab8_streams_lamda.level2.lab3_mailingservice_redo;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import week3.lab8_streams_lamda.level2.lab3_mailingservice_redo.dtos.PackageLowestPriceDto;
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

		PackageLowestPriceDto dto = lstCarrier.stream()
				.map(c -> new PackageLowestPriceDto(c.calculatePrice(this), c.getName()))
				.sorted((o1, o2) -> o1.price.compareTo(o2.price)).findFirst().orElse(null);

		lowestPrice = user.getDiscountCategory() == null ? dto.price
				: dto.price * (1 - user.getDiscountCategory().getDiscountRatio());

		setLowestPriceProvider(dto.provider);
		// System.out.println(String.format("%s%10s%.2f%10s", description, "$",
		// finalPrice, provider));
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
