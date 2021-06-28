package week1.lab3_MailingServicePrice.mailingserviceprovider;

import week1.lab3_MailingServicePrice.Package;

public class USMail extends MailingServiceProvider {
	public USMail() {
		super("US Mail");
	}

	@Override
	public double calculatePrice(Package _package) {
		double price;
		if (_package.getWeight() <= 3)
			price = 1;
		else
			price = 0.55 * _package.getWeight();

		return price;
	}

}
