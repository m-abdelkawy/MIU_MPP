package week2.standardexam2;

import java.time.LocalDate;

public class CheckoutRecordEntry {
	private LocalDate checkoutDate;
	private LocalDate dueDate;
	private LendingItem lendingItem;
	private ItemType itemType;

	public CheckoutRecordEntry(LendingItem item, LocalDate chDate, LocalDate dueDate, ItemType type) {
		super();
		this.checkoutDate = chDate;
		this.dueDate = dueDate;
		this.lendingItem = item;
		itemType = type;
	}

	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public ItemType getLendingItemType() {
		return this.itemType;
		/*ItemType type = null;
		if (this.lendingItem instanceof Book)
			type = ItemType.BOOK;
		else
			type = ItemType.CD;
		return type;*/
	}

	public LendingItem getLendingItem() {
		return this.lendingItem;
	}

}
