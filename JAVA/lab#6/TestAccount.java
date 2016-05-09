/*
    File:   TestAccount.java
	Author: Hong Zhang
    Date:   03/10/2014
    Description:
    Class TestAccount test class Account.  
*/

import java.util.Scanner;

public class TestAccount {
    public static void main(String[] args) {
   	
	// create Scanner to obtain input 
	Scanner input = new Scanner (System.in);
	
	// open an account
	System.out.print("Enter first name: ");
	String fristName = input.next();
	
	System.out.print("Enter last name: ");
	String lastName = input.next();
	
	String fullName = fristName.concat(" " + lastName);
	
	System.out.print("Enter opening balance: ");
	Double openingBalance = input.nextDouble();
	
	int ID = 1122;

	// create instance of Account class
	Account ac1122 = new Account(ID, openingBalance, fullName);
	
	// display this account's header
	printAccountHeader(ac1122, openingBalance);
	
	// withdraw 
	System.out.print("\nEnter withdraw amount: ");
	Double withdrawAmount = input.nextDouble();
	ac1122.withdraw(withdrawAmount);
	printAccountHeader(ac1122, openingBalance);
	System.out.println("Withdraw:\t\t" + String.format("%, 10.2f", withdrawAmount));
	System.out.println("Current Balance:\t" + String.format("%, 9.2f", ac1122.getBal()));
	
	// deposit
	System.out.print("\nEnter deposit amount: ");
	Double depositAmount = input.nextDouble();
	ac1122.deposit(depositAmount);
	printAccountHeader(ac1122, openingBalance);
	System.out.println("Deposit:\t\t" + String.format("%, 10.2f", depositAmount));
	System.out.println("Current Balance:\t" + String.format("%, 9.2f", ac1122.getBal()));
	
	} // end of main method
	
	// method to dispaly the account header
	public static void printAccountHeader(Account ac, Double open) {
	    System.out.printf("\nID:\t\t %17d\n", ac.getId());
		System.out.printf("Created:\t\t %9tD\n", ac.getDateCreated());
		System.out.printf("Owner:\t\t %17s\n", ac.getName());
		System.out.println("Opening Balance:\t" + String.format("%, 9.2f", open));
		System.out.printf("Annual Rate:\t %16.2f", ac.getAnnualInterestRate());
		System.out.println("%");
	} // end of method printAccountHeade
	
} // end of TestAccount class

/*
Sample Output:
Enter first name: Sam
Enter last name: Williams
Enter opening balance: 20000

ID:                           1122
Created:                  03/05/14
Owner:                Sam Williams
Opening Balance:         20,000.00
Annual Rate:                 4.50%

Enter withdraw amount: 2500

ID:                           1122
Created:                  03/05/14
Owner:                Sam Williams
Opening Balance:         20,000.00
Annual Rate:                 4.50%
Withdraw:                 2,500.00
Current Balance:         17,500.00

Enter deposit amount: 3000

ID:                           1122
Created:                  03/05/14
Owner:                Sam Williams
Opening Balance:         20,000.00
Annual Rate:                 4.50%
Deposit:                  3,000.00
Current Balance:         20,500.00
*/