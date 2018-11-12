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

		public Book(int bookNum, String bookTitle) throws IOException {
			PrintWriter writer=new PrintWriter(file);
			this.bookNum=bookNum;
			this.bookTitle=bookTitle;
			this.status=true;
			list.add(this);
			writer.println(bookNum);
			writer.println(bookTitle);
			writer.close();
			
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
			
			while(reader.hasNextLine()) {
				int bookNum=reader.nextInt();
				String title=reader.nextLine();
				Book book=new Book(bookNum, title);
			}
			
			reader.close();
			
		}

		@Override
		public String toString() {
			return "Book [bookNum=" + bookNum + ", " + (bookTitle != null ? "bookTitle=" + bookTitle + ", " : "")
					+ "status=" + status + "]";
		}

	}
