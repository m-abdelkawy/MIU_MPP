package week1.lab3_MailingServicePrice.mailingserviceprovider;

import week1.lab3_MailingServicePrice.Package;

public class UPS extends MailingServiceProvider {
	public UPS() {
		super("UPS");
	}

	@Override
	public double calculatePrice(Package _package) {
		return _package.getWeight() * 0.45;
	}
}
