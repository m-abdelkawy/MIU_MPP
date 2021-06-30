package week2.standardexam2;

public class Book extends LendingItem {
	private String isbn;
	private String title;
	private String authorFirstName;
	private String authorLastName;

	public Book(String isbn, String title, String fname, String lname) {
		this.isbn = isbn;
		this.title = title;
		this.authorFirstName = fname;
		this.authorLastName = lname;
	}

	@Override
	public boolean equals(Object ob) {
		if (ob == null)
			return false;
		if (ob.getClass() != this.getClass())
			return false;
		Book book = (Book) ob;
		boolean isEqual = this.isbn.equals(book.isbn) && this.title.equals(book.title)
				&& this.authorFirstName.equals(book.authorFirstName) && this.authorLastName.equals(book.authorLastName);
		return isEqual;
	}
}
