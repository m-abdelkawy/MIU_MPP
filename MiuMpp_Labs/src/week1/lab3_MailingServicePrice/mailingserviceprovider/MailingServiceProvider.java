package week1.lab3_MailingServicePrice.mailingserviceprovider;

import week1.lab3_MailingServicePrice.Package;

abstract class MailingServiceProvider implements IMailingServiceProvider {
	private String name;

	public MailingServiceProvider(String name) {
		this.name = name;
	}

	public abstract double calculatePrice(Package _package);

	@Override
	public String getName() {
		return this.name;
	}
}
