package week2.standardexam2;

public class LibraryMember {
	private String memberId;
	private String firstName;
	private String lastName;
	private String phone;
	private CheckoutRecord checkoutRecord;
	
	
	
	public LibraryMember(String id, String fname, String lname, String phone) {
		super();
		this.memberId = id;
		this.firstName = fname;
		this.lastName = lname;
		this.phone = phone;
	}
	
	public String getMemberId() {
		return memberId;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPhone() {
		return phone;
	}

	public CheckoutRecord getCheckoutRecord() {
		return checkoutRecord;
	}

	public void setCheckoutRecord(CheckoutRecord checkoutRecord) {
		this.checkoutRecord = checkoutRecord;
	}
}
