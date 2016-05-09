/*
    File:   Account.java
	Author: Hong Zhang
    Date:   03/10/2014
    Description:
    Class Account represents a single account with
    the ability to make deposits and withdrawals.  
*/

public class Account {
    // date field
	private int id;
    private double balance; 
	private java.util.Date dateCreated;
	private String name;
	private static double annualInterestRate = 4.5;

    // constructor (no-arg or default)
    public Account() {
        this (0, 0, " ");
		dateCreated = new java.util.Date();
	}
	
	// parameterized constructor
    public Account( int id, double balance, String name) {
        this.id = id;
		this. balance = balance;
		this. name = name;
		dateCreated = new java.util.Date();
	}
	
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
	
	public void setRate(double annualInterestRate) {
	    this.annualInterestRate = annualInterestRate;
	}
	
	// accessor methods
	public int getId() {
	    return id;
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
	    return balance * (annualInterestRate / (12 * 100));
	}

    public void withdraw(double amount)
    {
        if(balance >= amount)
            balance -= amount;
    }
	
	public void deposit(double amount)
    {
        balance += amount;
    }

} // end class Account