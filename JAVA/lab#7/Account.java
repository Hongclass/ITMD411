/*
    File:   Account.java
	Author: Hong Zhang
    Date:   03/24/2014
    Description:
    Class Account includes a superclass Account
    with the ability to make deposits and withdrawals.	
*/

public class Account {
    // date field
	protected int id;
    protected double balance; 
	protected java.util.Date dateCreated;
	protected String name;
	
	protected static double annualInterestRate;

    // constructor (no-arg or default)
    public Account() {
		dateCreated = new java.util.Date();
	}
	
	// parameterized constructor
    public Account(int id, double balance, String name) {
        this.id = id;
		this. balance = balance;
		this. name = name;
		dateCreated = new java.util.Date();
	}
	
	// mutator methods
	// mutator methods
	public void setId(int id) {
	    this.id = id;
	}
	
	public void setBal(double balance) {
	    this.balance = balance;
	}
	
	public void setName(String name) {
	    this.name = name;
	}
	
    public static void setAnnualInterestRate(double newAnnualInterestRate) {
    annualInterestRate = newAnnualInterestRate;
    }
	
	// accessor methods
	public int getId() {
	    return this.id;
	}
		
	public double getBal() {
		return balance;
	}
	
	public String getName() {
	    return name;
	}
	
	public java.util.Date getDateCreated() {
	    return dateCreated;
	}
	
	public static double getAnnualInterestRate() {
	    return annualInterestRate;
	}
	
	public double getMonthlyInterestRate() {
	   return annualInterestRate / 12;
	}
		
	public double getMonthlyInterest() {
	    double MonthlyInterestRate, MonthlyInterest;
		MonthlyInterestRate = annualInterestRate / (12 * 100);
		MonthlyInterest = balance * MonthlyInterestRate;
	    return MonthlyInterest;
	}

    public void withdraw(double amount)
    {
        balance -= amount;
    }
	
	public void deposit(double amount)
    {
        balance += amount;
    }
	
	public String toString() {
	    return String.format (
		"%-20s%15d\n%-20s%15s\n%-20s%15s\n%-20s%15.2f%%\n%-20s%,15.2f",
        "ID:", getId(),
        "Created:", String.format("%tD", getDateCreated()),
        "Owner:", getName(),
        "Annual Rate:", getAnnualInterestRate(),
        "Balance:", getBal());
	}

} // end class Account

