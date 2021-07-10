package week3.lab8_streams_lamda.level2.lab3_mailingservice_redo.mailingserviceprovider;

import week3.lab8_streams_lamda.level2.lab3_mailingservice_redo.Package;

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
