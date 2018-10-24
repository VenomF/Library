package objects;

import java.util.ArrayList;

public class Account {
	
	public static ArrayList<Account> accountLog = new ArrayList<>();
	private int accNum;
	private String userName;
	private int booksTaken;
	
	Account(int accNum, String userName){
		this.accNum=accNum;
		this.userName=userName;
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
	
	public static Account findUser(int accNum) {
		for(int i=0; i<accountLog.size(); i++)
			if(accountLog.get(i).accNum==accNum)
				return accountLog.get(i);
		
		return null;
	}
	
	public static boolean isRealAccount (int accNum) {
		if(findUser(accNum)!=null)
			return true;
		
		else
			return false;
	}

}
