/*
    File:   TestAccountWithInterface.java
	Author: Hong Zhang
    Date:   04/16/2014
    Description:
    Class TestAccountWithInterface test class AccountWithInterface.  
*/

import java.util.Scanner;

public class TestAccountWithInterface {

    public static void main(String[] args) throws CloneNotSupportedException {
		
	// create Scanner to obtain input 
	Scanner input = new Scanner (System.in);
		
	// get static annual interest rate
	System.out.print("Enter the annual interest rate for Accounts (in decimal format): ");
	Double rate = input.nextDouble();
    AccountWithInterface.setAnnualInterestRate(rate);
	
	// create account
	System.out.print("Enter first name: ");
	String fristName = input.next();
	
	System.out.print("Enter last name: ");
	String lastName = input.next();
	
	String fullName = fristName.concat(" " + lastName);
	
	System.out.print("Enter the account ID: ");
	int ID = input.nextInt();
	
	double openingBalance = 0;
	
	// create Account object
	AccountWithInterface accountTemplate = new AccountWithInterface(ID, openingBalance, fullName);
	AccountWithInterface[] accountArray = new AccountWithInterface[3];
	accountArray[0] = (AccountWithInterface) accountTemplate.clone();
	accountArray[1] = (AccountWithInterface) accountTemplate.clone();
	accountArray[2] = (AccountWithInterface) accountTemplate.clone();

	// assign three balance to accountArray
	System.out.print("Enter the first openging balance: ");
	openingBalance = input.nextDouble();
	accountArray[0] = new AccountWithInterface(ID, openingBalance, fullName);
	
	System.out.print("Enter the second opening balance: ");
	openingBalance = input.nextDouble();
	accountArray[1] = new AccountWithInterface(ID, openingBalance, fullName);
	
	System.out.print("Enter the third opening balance: ");
	openingBalance = input.nextDouble();
	accountArray[2] = new AccountWithInterface(ID, openingBalance, fullName);
	
	// display these accounts
	System.out.println(); //add a CRLF
	System.out.println("This is original order: ");
    for(AccountWithInterface acc: accountArray) {
    	System.out.println(acc);
    }
	
	// sort these accounts
    java.util.Arrays.sort(accountArray);
    
    // display the sorted rectangles
	System.out.println(); //add a CRLF
	System.out.println("This is sorted order by balance: ");
    for(AccountWithInterface acc: accountArray) {
    	System.out.println(acc);
    }

	} // end of main method

} // end of TestAccountWithInterface class

/*
Smaple Output:
Enter the annual interest rate for Accounts (in decimal format): 4.5
Enter first name: Hong
Enter last name: Zhang
Enter the account ID: 1122
Enter the first openging balance: 85900.32
Enter the second opening balance: 3250.99
Enter the third opening balance: 6200.56

This is original order: 
ID:                            1122
Created:                   04/10/14
Owner:                   Hong Zhang
Annual Rate:                   4.50%
Balance:                  85,900.32
ID:                            1122
Created:                   04/10/14
Owner:                   Hong Zhang
Annual Rate:                   4.50%
Balance:                   3,250.99
ID:                            1122
Created:                   04/10/14
Owner:                   Hong Zhang
Annual Rate:                   4.50%
Balance:                   6,200.56

This is sorted order by balance: 
ID:                            1122
Created:                   04/10/14
Owner:                   Hong Zhang
Annual Rate:                   4.50%
Balance:                   3,250.99
ID:                            1122
Created:                   04/10/14
Owner:                   Hong Zhang
Annual Rate:                   4.50%
Balance:                   6,200.56
ID:                            1122
Created:                   04/10/14
Owner:                   Hong Zhang
Annual Rate:                   4.50%
Balance:                  85,900.32
*/