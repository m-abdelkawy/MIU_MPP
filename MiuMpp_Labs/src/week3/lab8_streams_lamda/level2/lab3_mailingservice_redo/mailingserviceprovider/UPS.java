package week3.lab8_streams_lamda.level2.lab3_mailingservice_redo.mailingserviceprovider;

import week3.lab8_streams_lamda.level2.lab3_mailingservice_redo.Package;

public class UPS extends MailingServiceProvider {
	public UPS() {
		super("UPS");
	}

	@Override
	public double calculatePrice(Package _package) {
		return _package.getWeight() * 0.45;
	}
}
