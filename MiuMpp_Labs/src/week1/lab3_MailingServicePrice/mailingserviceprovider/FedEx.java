package week1.lab3_MailingServicePrice.mailingserviceprovider;

import week1.lab3_MailingServicePrice.Package;

public class FedEx extends MailingServiceProvider {
	private static final double[] ZONE_RATES = { 0.35, 0.30, 0.55, 0.43 };

	public FedEx() {
		super("FedEx");
	}


	@Override
	public double calculatePrice(Package _package) {
		return ZONE_RATES[_package.getZone().getValue()] * _package.getWeight();
	}

}
