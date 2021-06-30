package week2.standardexam2;

public class CD extends LendingItem {
	private String productId;
	private String title;
	private String company;

	public CD(String productid, String title, String company) {
		this.productId = productid;
		this.title = title;
		this.company = company;
	}

	@Override
	public boolean equals(Object ob) {
		if (ob == null)
			return false;
		if (ob.getClass() != this.getClass())
			return false;
		CD cd = (CD) ob;
		boolean isEqual = this.productId.equals(cd.productId) && this.title.equals(cd.title)
				&& this.company.equals(cd.company);
		return isEqual;
	}

}
