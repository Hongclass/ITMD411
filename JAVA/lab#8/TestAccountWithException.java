import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

 /*
    File:   TestAccountWithException.java
	Author: Hong Zhang
    Date:   04/07/2014
    Description: 
	TestAccountWithException class write account information to file.
*/

public class TestAccountWithException {
	public static void main(String[] args) throws FileNotFoundException {
	    
		Scanner inputFromConsole = new Scanner (System.in);
		Scanner input = new Scanner(System.in);
		
		// set static annual interest rate
        AccountWithException.setAnnualInterestRate(4.5);
	
		// prompt user for input filename
		System.out.print("Enter the filename: ");
		String filename = inputFromConsole.nextLine();
		File file = new File(filename);
		while(file.exists()) {
		    // create File object to reference file on storage
		    System.out.println("The File " + filename + " already exists.");
			System.out.println("please choose another name.");
			System.out.print("Enter the filename: ");
		    filename = inputFromConsole.nextLine();	
            file = new File(filename);
		} 
		System.out.println("File will be created...");
		
		// create PrintWriten object to output data
		// referencing the previously created File object
		PrintWriter output = new PrintWriter(file);
		
		try {
		    // open an account
	        System.out.print("Enter first name: ");
	        String fristName = input.next();
	
	        System.out.print("Enter last name: ");
	        String lastName = input.next();
	
	        String fullName = fristName.concat(" " + lastName);
	
	        System.out.print("Enter opening balance: ");
	        Double openingBalance = input.nextDouble();
	
	        final int ID = 1122;

	        // create instance of AccountWithException class
	        AccountWithException ac1122 = new AccountWithException(ID, openingBalance, fullName);
			
			// create this account's header
            String header = ac1122.toString();
			
			// process withdrawal
            System.out.print("\nHow much would you like to withdraw? ");
            double withdrawAmount = input.nextDouble();
            ac1122.withdraw(withdrawAmount);
            output.println(ac1122);
			output.println();
		
            // process deposit
            System.out.print("\nHow much would you like to deposit? ");
            double depositAmount = input.nextDouble();
            ac1122.deposit(depositAmount);
            output.println(ac1122);    
		}
		
		/** CRE**add to use custom exception */
		catch (InvalidBalanceException ex) {
			System.out.println(ex);
		}
			
		// make sure file is closed
		finally {
			System.out.println("Closing file...");
			output.close();
		}
	} 
}

/*
Sample output:
Enter the filename: account.txt
File will be created...
Enter first name: Sam
Enter last name: Williams
Enter opening balance: 20000

How much would you like to withdraw? 2500

How much would you like to deposit? 3000
Closing file...

Enter the filename: account.txt
File will be created...
Enter first name: Sam
Enter last name: Williams
Enter opening balance: 20000

How much would you like to withdraw? 2500

How much would you like to deposit? 3000
Closing file...

Enter the filename: account.txt
The File account.txt already exists.
please choose another name.
Enter the filename: hong.txt
File will be created...
Enter first name: Sam
Enter last name: Williams
Enter opening balance: 20000

How much would you like to withdraw? 25000
InvalidBalanceException: Invalid balance 20000.0
Closing file...

*/