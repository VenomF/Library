package test;

import java.util.Scanner;

import objects.Account;
import objects.Book;

public class Menu {
	
	static Scanner input=new Scanner(System.in);

	public static void createAccount() {
		System.out.println("Unesite broj racuna.");
		int accNumber=input.nextInt();
		System.out.println("Unesite vase ime.");
		String name=input.next();
		if(accNumber>0) {
			if(!Account.isAccount(accNumber)) {
				Account user=new Account(accNumber, name);
				user.toString();
				System.out.println("Uspijesno ste kreirali racun");
			}
		}
		else
			System.out.println("Racun mora imati jedinstven pozitivan broj");
	}

	public static void createBook() {
		System.out.println("Unesite broj knjige.");
		int bookNumber=input.nextInt();
		if(bookNumber>0) {
			System.out.println("Unesite naslov");
			String title=input.next();
			if(Book.findBook(bookNumber)==null) {
				Book book=new Book(bookNumber, title);
				book.toString();
				System.out.println("Uspijesno ste kreirali knjigu.");
			}
		}
		else
			System.out.println("Knjiga mora imati jedinstven pozitivan broj.");
	}

	public static void takeBook() {
		System.out.println("Unesite broj knjige koju zelite posuditi");
		int book=input.nextInt();
		System.out.println("Unesite broj vaseg racuna.");
		int acc=input.nextInt();
		try {
			Book wantedBook=Book.findBook(book);
			if(Account.isAccount(acc)) {
				wantedBook.takeBook(book, acc);
				System.out.println("Podigli ste knjigu " + wantedBook.getBookTitle());
			}
			else
				System.out.println("Vas racun nije validan");
		}catch(NullPointerException e) {
			System.out.println("Knjiga koju ste trazili ne postoji.");
		}
	}

	public static void returnBook() {
		System.out.println("Unesite broj vaseg racuna.");
		int acc=input.nextInt();
		System.out.println("Unesite knjigu koju zelite da vratite.");
		int book=input.nextInt();
		try {
			Book bookReturn=Book.findBook(book);
			bookReturn.returnBook(acc);
			System.out.println("Vratili ste knjigu " + bookReturn.getBookTitle());
		}catch(NullPointerException e) {
			System.out.println("Greska...");
		}
	}

	public static void details() {
		System.out.println("Unesite broj racuna.");
		int accNum=input.nextInt();
		try {
			Account acc=Account.findUser(accNum);
			acc.toString();
		}catch(NullPointerException e) {
			System.out.println("Uneseni racun ne postoji.");
		}
	}

	public static void main(String[] args) {
		int num=0;

		while(num!=6) {
			System.out.println("1) Novi racun\n2) Nova knjiga\n3) Posudi knjigu\n4) Vrati knjigu\n5) Detalji racuna\n6) Izlaz");
			num=input.nextInt();

			switch (num){
			case 1: createAccount();
			break;

			case 2: createBook();
			break;

			case 3: takeBook();
			break;

			case 4: returnBook();
			break;
			
			case 5: details();
			break;
			}
			
		}
		
		input.close();

	}

}
