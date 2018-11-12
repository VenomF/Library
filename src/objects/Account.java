package objects;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Account {
	
	public static ArrayList<Account> accountLog = new ArrayList<>();
	private int accNum;
	private String userName;
	private int booksTaken;
	private static File file=new File("users.txt");
	
	public Account(int accNum, String userName) throws IOException {
		this.accNum=accNum;
		this.userName=userName;
		accountLog.add(this);
		PrintWriter writer=new PrintWriter(file);
		writer.println(accNum);
		writer.println(userName);
		writer.close();
	}

	public int getAccNum() {
		return accNum;
	}

	public void setAccNum(int accNum) {
		this.accNum = accNum;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public int getBooksTaken() {
		return this.booksTaken;
	}
	
	public void setBooksTaken(int booksTaken) {
		this.booksTaken=booksTaken;
	}
	
	public void setBooksTaken() {
		this.booksTaken--;
	}
	
	public static Account findUser(int accNum) {
		
		for(int i=0; i<accountLog.size(); i++)
			if(accountLog.get(i).accNum==accNum)
				return accountLog.get(i);
		
		return null;
	}
	
	public static void read() throws FileNotFoundException, IOException {
		Scanner reader=new Scanner(file);
		
		while(reader.hasNextLine()) {
			int accNum=reader.nextInt();
			String name=reader.nextLine();
			Account acc=new Account(accNum, name);
		}
		
		reader.close();
	}

	@Override
	public String toString() {
		return "Account [accNum=" + accNum + ", " + (userName != null ? "userName=" + userName + ", " : "")
				+ "booksTaken=" + booksTaken + "]";
	}
	

}
