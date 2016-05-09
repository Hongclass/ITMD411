/*
    File:   CheckingAccount.java
	Author: Hong Zhang
    Date:   03/24/2014
    Description:
    Class CheckingAccount includes a subclass CheckingAccount
	with the ability to withdraw more than the balance.
*/

public class CheckingAccount extends Account {
    private double overdraftAmount;

    public CheckingAccount(int id, double balance, String name, double overdraftAmount) {
	super(id, balance, name);
	this.overdraftAmount = overdraftAmount;
	}	
	
    public void withdraw(double amount){
        if (amount < (balance + overdraftAmount))
            super.withdraw(amount); 
        else {
            System.out.println("\nError! Invalid withdrawal amount.");
			System.out.println("Checking account cannot exceed overdraft limit.");
        }
    }
	
	public void deposit(double amount)
    {
        balance += amount;
    }
	
	public String toString() {
	    return String.format ("\nAccount Type: \t Checking \n%s", super.toString());
	}

} // end class CheckingAccount