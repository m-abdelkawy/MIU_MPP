package week1.lab3_MailingServicePrice;

import java.util.ArrayList;
import java.util.List;

import week1.lab3_MailingServicePrice.mailingserviceprovider.FedEx;
import week1.lab3_MailingServicePrice.discountcategory.IDiscountCategory;
import week1.lab3_MailingServicePrice.discountcategory.SeniorDiscount;
import week1.lab3_MailingServicePrice.discountcategory.StudentDiscount;
import week1.lab3_MailingServicePrice.mailingserviceprovider.*;

public class MailingApp {

	public static void main(String[] args) {
		User user = new User();

		List<IMailingServiceProvider> lstCarrier = new ArrayList<IMailingServiceProvider>();
		lstCarrier.add(new UPS());
		lstCarrier.add(new FedEx());
		lstCarrier.add(new USMail());

		IDiscountCategory discountCategory = null;

		FastScanner scanner = new FastScanner(System.in);

		System.out.println("Enter number of packages: ");
		int n = scanner.nextInt();

		System.out.println(
				"Enter the first two letters if you're eligible for any of the following discount categories: ");
		System.out.println("Student, Senior Citizen, enter anything else if not eligible");
		String _discountCategory = scanner.next();

		switch (_discountCategory.toLowerCase()) {
		case "st":
			discountCategory = new StudentDiscount();
			break;
		case "se":
			discountCategory = new SeniorDiscount();
			break;

		default:
			break;
		}

		user.setDiscountCategory(discountCategory);

		for (int i = 0; i < n; i++) {
			System.out.println(String.format("Enter package #%d description: ", i+1));
			String description = scanner.next();
			System.out.println("Enter zone number ");
			System.out.println("1 -> IA, MT, OR and CA ");
			System.out.println("2 -> TX and UT ");
			System.out.println("3 -> FL, MA, and OH ");
			System.out.println("4 -> other regions ");
			int zone = scanner.nextInt();

			System.out.println("Enter weight of the package in pounds: ");
			double wt = scanner.nextDouble();

			user.addPackage(new Package(description, wt, Zone.values()[zone - 1], user));
		}

		user.printPrices(lstCarrier);
	}

}
