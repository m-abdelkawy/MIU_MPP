package week3.lab8_streams_lamda.level2.lab3_mailingservice_redo.mailingserviceprovider;

import week3.lab8_streams_lamda.level2.lab3_mailingservice_redo.Package;

public interface IMailingServiceProvider {
	abstract double calculatePrice(Package _package);
	String getName();
}
