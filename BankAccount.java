package bank;
import java.util.*;
public class BankAccount {
	private String password;
	private double balance;

	public static void main(String[] args) {
		//establishing variables
		int x = 1;
		String pass;
		double bal;
		String choice;
		Scanner scan = new Scanner(System.in);
		//asks the user to enter a password
		System.out.println("Enter a new password: ");
		String firstPassword = scan.nextLine();
		//asks the user to set their balance
		System.out.println("Enter your balance: ");
		double firstBalance = scan.nextDouble();
		scan.nextLine();
		//Creates a bank account object using the password and balance
		BankAccount a = new BankAccount(firstPassword, firstBalance);
		while(x == 1) {
			System.out.println("Would you like to deposit, withdaw, or know your balance? (d, w, or b)");
			choice = scan.nextLine();
			//deposit
			if(choice.equals("d")) {
				System.out.println("Please enter your password: ");
				pass = scan.nextLine();
				System.out.println("Please enter amount: ");
				bal = scan.nextDouble();
				scan.nextLine();
				a.deposit(pass, bal);
			}else if(choice.equals("w")) {
				System.out.println("Please enter your password: ");
				pass = scan.nextLine();
				System.out.println("Please enter amount: ");
				bal = scan.nextDouble();
				scan.nextLine();
				a.withdraw(pass, bal);
			}else if(choice.equals("b")) {
				System.out.println(a.getBalance());
			}else {
				System.out.println("Incorrect Option");
			}
			//asks the user if they want to exit the program
			System.out.println("Would you like to exit? ");
			choice = scan.nextLine();
			if(choice.equals("yes")) {
				x = -1;
			}
		}

	}
	//default bank account
	public BankAccount() {
		password = "";
		balance = 0.0;
	}
	//specific bank account
	public BankAccount(String acctPassword, double acctBalance) {
		password = acctPassword;
		balance = acctBalance;
	}
	//accessor method for balance
	public double getBalance() {
		return balance;
	}
	//deposit function
	public void deposit(String acctPassword, double amount) {
		if(!acctPassword.equals(password)) {
			System.out.println("Incorrect Password");
		}else {
			balance+=amount;
		}
	}
	//withdrawal function
	public void withdraw(String acctPassword, double amount){
		if(!acctPassword.equals(password)) {
			System.out.println("Incorrect Password");
		}else {
			balance-=amount;
			if(balance < 0) {
				System.out.println("Withdraw penalty");
			}
		}
	}

}
