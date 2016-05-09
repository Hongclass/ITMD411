/*
    File:   SavingAccount.java
	Author: Hong Zhang
    Date:   03/24/2014
    Description:
    Class Account includes a subclass SavingAccount
    which can not be overdrawn.	
*/

class SavingAccount extends Account {

    public SavingAccount(int id, double balance, String name) {
	super(id, balance, name);
	}	
	
    public void withdraw(double amount){
        if (amount < balance)
            super.withdraw(amount); 
        else {
            System.out.println("\nError! Cannot withdraw amount larger than balance!");
        }
    }
	
	public void deposit(double amount)
    {
        balance += amount;
    }
	
	public String toString() {
	    return String.format ("\nAccount Type: \t Saving \n%s", super.toString());
	}

} // end class SavingAccount