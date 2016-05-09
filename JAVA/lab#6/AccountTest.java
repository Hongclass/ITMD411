import java.util.Scanner;
public class AccountTest
{
// main method begins execution of Java application
public static void main( String[] args )
{
Account account1 = new Account( 50.00 ); // create Account object
Account account2 = new Account( -7.53 ); // create Account object
// display initial balance of each object
System.out.printf( "account1 balance: $%.2f\n",
account1.getBalance() );
System.out.printf( "account2 balance: $%.2f\n\n",
account2.getBalance() );
// create Scanner to obtain input from command window
Scanner input = new Scanner( System.in );
double depositAmount; // deposit amount read from user
double withdrawAmount; // withdraw amount read from user
System.out.println( "Enter deposit amount for account1: " ); // prompt
depositAmount = input.nextDouble(); // obtain user input
System.out.printf( "\nadding %.2f to account1 balance\n\n",
depositAmount );
account1.credit( depositAmount ); // add to account1 balance
// display balances
System.out.printf( "account1 balance: $%.2f\n",
account1.getBalance() );
System.out.printf( "account2 balance: $%.2f\n\n",
account2.getBalance() );
System.out.print( "Enter deposit amount for account2: " ); // prompt
depositAmount = input.nextDouble(); // obtain user input
System.out.printf( "\nadding %.2f to account2 balance\n\n",
depositAmount );
account2.credit( depositAmount ); // add to account2 balance
// display balances
System.out.printf( "account1 balance: $%.2f\n\n",
account1.getBalance() );
System.out.printf( "account2 balance: $%.2f\n\n",
account2.getBalance() );
System.out.println( "Enter withdraw amount for account1: " ); // prompt
withdrawAmount = input.nextDouble(); // obtain user input
System.out.printf( "\nsubtracting %.2f to account1 balance\n\n",
withdrawAmount );
account1.withdraw( withdrawAmount ); // subtract from account1 balance
// display balances
System.out.printf( "account1 balance: $%.2f\n",
account1.getBalance() );
System.out.printf( "account2 balance: $%.2f\n\n",
account2.getBalance() );
System.out.print( "Enter withdraw amount for account2: " ); // prompt
withdrawAmount = input.nextDouble(); // obtain user input
System.out.printf( "\nsubtracting %.2f to account2 balance\n\n",
withdrawAmount );
account2.withdraw( withdrawAmount ); // subtract from account2 balance
// display balances
System.out.printf( "account1 balance: $%.2f\n",
account1.getBalance() );
System.out.printf( "account2 balance: $%.2f\n",
account2.getBalance() );
} // end main
} // end class AccountTest

/*
Sample Output:
account1 balance: $50.00
account2 balance: $0.00

Enter deposit amount for account1: 
66

adding 66.00 to account1 balance

account1 balance: $116.00
account2 balance: $0.00

Enter deposit amount for account2: 664

adding 664.00 to account2 balance

account1 balance: $116.00

account2 balance: $664.00

Enter withdraw amount for account1: 
486

subtracting 486.00 to account1 balance

account1 balance: $-370.00
account2 balance: $664.00

Enter withdraw amount for account2: 743

subtracting 743.00 to account2 balance

account1 balance: $-370.00
account2 balance: $-79.00
*/