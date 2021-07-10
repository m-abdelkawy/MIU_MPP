package week3.lab8_streams_lamda.level2.lab3_mailingservice_redo;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import week3.lab8_streams_lamda.level2.lab3_mailingservice_redo.discountcategory.IDiscountCategory;
import week3.lab8_streams_lamda.level2.lab3_mailingservice_redo.mailingserviceprovider.IMailingServiceProvider;

public class User {
	private IDiscountCategory discountCategory;
	private List<Package> lstPackage;

	public User() {
		this.lstPackage = new ArrayList<Package>();
	}

	public void addPackage(Package _package) {
		if (_package == null)
			return;

		lstPackage.add(_package);
	}

	public void printPrices(List<IMailingServiceProvider> lstCarrier) {
		calcPrices(lstCarrier);

		// for formatting
		int descMaxSpacing = lstPackage.stream().mapToInt(p -> p.getDescription().length()).max()
				.orElseThrow(NoSuchElementException::new);

		int providerMaxSpacing = lstPackage.stream().mapToInt(p -> p.getLowestPriceProvider().length()).max()
				.orElseThrow(NoSuchElementException::new);

		for (Package _package : lstPackage) {
			int spacing1 = descMaxSpacing + 10 - _package.getDescription().length();
			int spacing2 = -providerMaxSpacing + 15+ _package.getLowestPriceProvider().length();

			System.out.println(String.format("%s%" + spacing1 + "s%.2f%" + spacing2 + "s", _package.getDescription(),
					"$", _package.getPrice(), _package.getLowestPriceProvider()));
		}
	}

	public IDiscountCategory getDiscountCategory() {
		return discountCategory;
	}

	public void setDiscountCategory(IDiscountCategory discountCategory) {
		this.discountCategory = discountCategory;
	}

	private void calcPrices(List<IMailingServiceProvider> lstCarrier) {
		for (Package _package : lstPackage) {
			_package.calcLowestPrice(lstCarrier);
		}
	}
}
