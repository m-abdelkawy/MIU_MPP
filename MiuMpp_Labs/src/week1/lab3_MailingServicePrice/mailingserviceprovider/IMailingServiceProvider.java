package week1.lab3_MailingServicePrice.mailingserviceprovider;

import week1.lab3_MailingServicePrice.Package;

public interface IMailingServiceProvider {
	abstract double calculatePrice(Package _package);
	String getName();
}
