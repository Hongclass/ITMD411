/*
    File:   TestAccount.java
	Author: Hong Zhang
    Date:   03/24/2014
    Description:
    Class TestAccount test this superclass and its two subclasses.  
*/

import java.util.Scanner;

public class TestAccount {
    public static void main(String[] args) throws Exception {
		
	// create Scanner to obtain input 
	Scanner input = new Scanner (System.in);
		
	// get static annual interest rate
	System.out.print("Enter the annual interest rate for Accounts (in decimal format): ");
	Double rate = input.nextDouble();
    Account.setAnnualInterestRate(rate);

  	System.out.print("Enter the checking account overdraft limit: ");
	Double overdraftLimit = input.nextDouble();
	
	// create account
	System.out.print("Enter first name: ");
	String fristName = input.next();
	
	System.out.print("Enter last name: ");
	String lastName = input.next();
	
	String fullName = fristName.concat(" " + lastName);
	
	System.out.print("Enter the account ID: ");
	int ID = input.nextInt();
	
	// create SavingAccount
	System.out.print("\nEnter opening balance of saving account: ");
    Double openBalance = input.nextDouble();
    SavingAccount SV1122 = new SavingAccount(ID, openBalance, fullName);
	// display this saving account's header
    String SVHeader = SV1122.toString();
    System.out.println(SVHeader);
	
    // create CheckingAccount
    System.out.print("\nEnter opening balance of checking account: ");
	Double openingBalance = input.nextDouble();
    CheckingAccount CK1122 = new CheckingAccount(ID, openingBalance, fullName, overdraftLimit);
	// display this checking account's header
    String CKHeader = CK1122.toString();
    System.out.println(CKHeader);
	
	String acctStatus;
	
	int menu;
	
	do {
	    System.out.println("\nSaving Account: What transaction would you like to process? ");
	    System.out.print("(1-deposit, 2-withdraw, 3-done): ");
	    menu = input.nextInt();
        switch (menu) {
	    case 1: {
		    // deposit from SavingAccount
    	    System.out.print("\nEnter deposit amount to Saving Account: ");
	        Double depositSVAmount = input.nextDouble();
	        SV1122.deposit(depositSVAmount);
	        acctStatus = String.format("%s\n%-20s%,15.2f\n%-20s%,15.2f",
                SVHeader,
                "Deposit:", depositSVAmount,
                "Current Balance:", SV1122.getBal());
            System.out.println(acctStatus);
		    break;
		    }
		case 2: {
		    // withdraw from SavingAccount
	        System.out.print("\nEnter withdraw amount from Saving Account: ");
	        Double withdrawSVAmount = input.nextDouble();
	        SV1122.withdraw(withdrawSVAmount);
	        acctStatus = String.format("%s\n%-20s%,15.2f\n%-20s%,15.2f",
                SVHeader,
                "Withdraw:", withdrawSVAmount,
                "Current Balance:", SV1122.getBal());
            System.out.println(acctStatus);
			break;
		    }
		default:
		    break;
	    }	
	} while (menu != 3);
	
		do {
	    System.out.println("\nChecking Account: What transaction would you like to process? ");
	    System.out.print("(1-deposit, 2-withdraw, 3-done): ");
	    menu = input.nextInt();
        switch (menu) {
	    case 1: {
		    // deposit from CheckingAccount
	        System.out.print("\nEnter deposit amount to Checking Account: ");
	        Double depositCKAmount = input.nextDouble();
	        CK1122.deposit(depositCKAmount);
	        acctStatus = String.format("%s\n%-20s%,15.2f\n%-20s%,15.2f",
                CKHeader,
                "Deposit:", depositCKAmount,
                "Current Balance:", CK1122.getBal());
            System.out.println(acctStatus);
		    break;
		    }
		case 2: {
		    // withdraw from CheckingAccount
	        System.out.print("\nEnter withdraw amount from Checking Account: ");
	        Double withdrawCKAmount = input.nextDouble();
	        CK1122.withdraw(withdrawCKAmount);
	        acctStatus = String.format("%s\n%-20s%,15.2f\n%-20s%,15.2f",
                CKHeader,
                "Withdraw:", withdrawCKAmount,
                "Current Balance:", CK1122.getBal());
            System.out.println(acctStatus);
			break;
		    }
		default:
		    break;
	    }	
	} while (menu != 3);
		
	} // end of main method

} // end of TestAccount class

/*
Enter the annual interest rate for Accounts (in decimal format): 4.5
Enter the checking account overdraft limit: 120
Enter first name: Sam
Enter last name: Williams
Enter the account ID: 1122

Enter opening balance of saving account: 24000

Account Type: 	 Saving 
ID:                            1122
Created:                   03/20/14
Owner:                 Sam Williams
Annual Rate:                   4.50%
Balance:                  24,000.00

Enter opening balance of checking account: 550

Account Type: 	 Checking 
ID:                            1122
Created:                   03/20/14
Owner:                 Sam Williams
Annual Rate:                   4.50%
Balance:                     550.00

Saving Account: What transaction would you like to process? 
(1-deposit, 2-withdraw, 3-done): 1

Enter deposit amount to Saving Account: 500

Account Type: 	 Saving 
ID:                            1122
Created:                   03/20/14
Owner:                 Sam Williams
Annual Rate:                   4.50%
Balance:                  24,000.00
Deposit:                     500.00
Current Balance:          24,500.00

Saving Account: What transaction would you like to process? 
(1-deposit, 2-withdraw, 3-done): 2

Enter withdraw amount from Saving Account: 24000

Account Type: 	 Saving 
ID:                            1122
Created:                   03/20/14
Owner:                 Sam Williams
Annual Rate:                   4.50%
Balance:                  24,000.00
Withdraw:                 24,000.00
Current Balance:             500.00

Saving Account: What transaction would you like to process? 
(1-deposit, 2-withdraw, 3-done): 2

Enter withdraw amount from Saving Account: 600

Error! Cannot withdraw amount larger than balance!

Account Type: 	 Saving 
ID:                            1122
Created:                   03/20/14
Owner:                 Sam Williams
Annual Rate:                   4.50%
Balance:                  24,000.00
Withdraw:                    600.00
Current Balance:             500.00

Saving Account: What transaction would you like to process? 
(1-deposit, 2-withdraw, 3-done): 3

Checking Account: What transaction would you like to process? 
(1-deposit, 2-withdraw, 3-done): 1

Enter deposit amount to Checking Account: 100

Account Type: 	 Checking 
ID:                            1122
Created:                   03/20/14
Owner:                 Sam Williams
Annual Rate:                   4.50%
Balance:                     550.00
Deposit:                     100.00
Current Balance:             650.00

Checking Account: What transaction would you like to process? 
(1-deposit, 2-withdraw, 3-done): 2

Enter withdraw amount from Checking Account: 500

Account Type: 	 Checking 
ID:                            1122
Created:                   03/20/14
Owner:                 Sam Williams
Annual Rate:                   4.50%
Balance:                     550.00
Withdraw:                    500.00
Current Balance:             150.00

Checking Account: What transaction would you like to process? 
(1-deposit, 2-withdraw, 3-done): 2

Enter withdraw amount from Checking Account: 200

Account Type: 	 Checking 
ID:                            1122
Created:                   03/20/14
Owner:                 Sam Williams
Annual Rate:                   4.50%
Balance:                     550.00
Withdraw:                    200.00
Current Balance:             -50.00

Checking Account: What transaction would you like to process? 
(1-deposit, 2-withdraw, 3-done): 2

Enter withdraw amount from Checking Account: 100

Error! Invalid withdrawal amount.
Checking account cannot exceed overdraft limit.

Account Type: 	 Checking 
ID:                            1122
Created:                   03/20/14
Owner:                 Sam Williams
Annual Rate:                   4.50%
Balance:                     550.00
Withdraw:                    100.00
Current Balance:             -50.00

Checking Account: What transaction would you like to process? 
(1-deposit, 2-withdraw, 3-done): 3
*/

