package objects;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Book {

		private int bookNum;
		private String bookTitle;
		private boolean status;
		private static ArrayList<Book> list=new ArrayList<>();
		private static File file=new File("books.txt");

		public Book(int bookNum) {
			this.bookNum=bookNum;

		}

		protected Book() {

		}

		public Book(int bookNum, String bookTitle) {
			this.bookNum=bookNum;
			this.bookTitle=bookTitle;
			this.status=true;
			list.add(this);
			
		}
		
		private Book(int bookNum, String title, boolean status) {
			this.bookNum=bookNum;
			this.bookTitle=title;
			this.status=status;
			list.add(this);
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

		public boolean getStatus() {
			return status;
		}

		public static Book findBook(int bookNum) {

			for(int i=0; i<list.size(); i++)
				if(list.get(i).bookNum==bookNum)
					return list.get(i);

			return null;
		}

		public void takeBook(int bookNum, int accountNum) {

			Account user=Account.findUser(accountNum);
			int booksBorrowed=user.getBooksTaken();

			if(this.status && booksBorrowed<3) {
				this.status=false;
				booksBorrowed++;
				user.setBooksTaken(booksBorrowed); 
			}
		}

		public void returnBook(int accountNum) {
			Account user=Account.findUser(accountNum);
			user.setBooksTaken();
			this.status=true;
		}
		
		public static void read() throws FileNotFoundException, IOException {
			Scanner reader=new Scanner(file);

			while (reader.hasNext()) {
				new Book(reader.nextInt(), reader.next(), reader.nextBoolean());
			}

			reader.close();
		}
		
		public static void write() throws FileNotFoundException {
			PrintWriter write=new PrintWriter(file);
			for(int i=0; i<list.size(); i++) {
				write.print(list.get(i).bookNum + " ");
				write.print(list.get(i).bookTitle + " ");
				write.println(list.get(i).status);
			}
			
			write.close();
		}

		@Override
		public String toString() {
			return "Book [bookNum=" + bookNum + ", " + (bookTitle != null ? "bookTitle=" + bookTitle + ", " : "")
					+ "status=" + status + "]";
		}

	}
