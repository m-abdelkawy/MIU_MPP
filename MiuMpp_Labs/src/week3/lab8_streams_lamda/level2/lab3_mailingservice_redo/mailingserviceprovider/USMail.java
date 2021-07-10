package week3.lab8_streams_lamda.level2.lab3_mailingservice_redo.mailingserviceprovider;

import week3.lab8_streams_lamda.level2.lab3_mailingservice_redo.Package;

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
