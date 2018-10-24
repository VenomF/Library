package objects;

public class Book {
	
	private int bookNum;
	private String bookTitle;
	private boolean status;
	
	public Book(int bookNum, String bookTitle) {
		this.bookNum=bookNum;
		this.bookTitle=bookTitle;
		this.status=true;
	}

	public int getBookNum() {
		return bookNum;
	}

	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	
	public void takeBook(int bookNum, int accountNum) {
		Account taker=Account.findUser(accountNum);
		int booksBorrowed=taker.getBooksTaken();
		if(this.status && booksBorrowed<3) {
			this.status=false;
			taker.setBooksTaken(++booksBorrowed); 
			
		}
	}

}
