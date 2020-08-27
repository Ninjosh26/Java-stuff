package bank;
import java.util.*;
public class BankAccount {
	private String password;
	private double balance;

	public static void main(String[] args) {
		int x = 1;
		String pass;
		double bal;
		String choice;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a new password: ");
		String firstPassword = scan.nextLine();
		System.out.println("Enter your balance: ");
		double firstBalance = scan.nextDouble();
		scan.nextLine();
		BankAccount a = new BankAccount(firstPassword, firstBalance);
		while(x == 1) {
			System.out.println("Would you like to deposit, withdaw, or know your balance? (d, w, or b)");
			choice = scan.nextLine();
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
			System.out.println("Would you like to exit? ");
			choice = scan.nextLine();
			if(choice.equals("yes")) {
				x = -1;
			}
		}

	}
	public BankAccount() {
		password = "";
		balance = 0.0;
	}
	public BankAccount(String acctPassword, double acctBalance) {
		password = acctPassword;
		balance = acctBalance;
	}
	public double getBalance() {
		return balance;
	}
	public void deposit(String acctPassword, double amount) {
		if(!acctPassword.equals(password)) {
			System.out.println("Incorrect Password");
		}else {
			balance+=amount;
		}
	}
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
