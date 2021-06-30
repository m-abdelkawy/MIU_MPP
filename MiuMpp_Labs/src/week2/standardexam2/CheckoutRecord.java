package week2.standardexam2;

import java.util.ArrayList;
import java.util.List;

public class CheckoutRecord {
	private List<CheckoutRecordEntry> checkoutEntryList;

	public CheckoutRecord() {
		this.checkoutEntryList = new ArrayList<CheckoutRecordEntry>();
	}

	public List<CheckoutRecordEntry> getCheckoutEntryList() {
		return this.checkoutEntryList;
	}

	public void addCheckoutEntry(CheckoutRecordEntry entry) {
		if (entry == null)
			return;
		this.checkoutEntryList.add(entry);
	}
}
