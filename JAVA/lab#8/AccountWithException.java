 /*
    File:   AccountWithException.java
	Author: Hong Zhang
    Date:   04/07/2014
    Description: 
	AccountWithException class will throw InvalidBalanceException class 
	when an illegal balance (< 0.0) is attempted to be set for an account.
*/

public class AccountWithException {
  private int id;
  private double balance;
  private String name;
  private static double annualInterestRate;
  private java.util.Date dateCreated;


  // no-arg constructor 
  public AccountWithException() 
         throws InvalidBalanceException {
	this (0, 0, " ");	 
    this.dateCreated = new java.util.Date();
  }

  // constructor with parameters
  public AccountWithException(int newId, double newBalance, String newName)
         throws InvalidBalanceException {
    setId(newId);
    setBalance(newBalance);
	setName(newName);
    this.dateCreated = new java.util.Date();
   }

  // accessor methods
  public int getId() {
    return this.id;
  }

  public double getBalance() {
    return this.balance;
  }

  public static double getAnnualInterestRate() {
    return annualInterestRate;
  }

  public double getMonthlyInterest() {
    return this.balance * (this.annualInterestRate / 1200);
  }

  public java.util.Date getDateCreated() {
    return this.dateCreated;
  }

  public String getName() {
    return this.name;
  }

  // mutator methods
  public void setId(int newId) {
    this.id = newId;
  }

  public void setBalance(double newBalance) 
         throws InvalidBalanceException {
    if (newBalance >= 0)
	  this.balance = newBalance;
	else
	    throw new InvalidBalanceException(newBalance); 
  }

  public static void setAnnualInterestRate(double newAnnualInterestRate) {
    annualInterestRate = newAnnualInterestRate;
  }

  public void setName(String newName) {
    this.name = newName;
  }

  // balance modification methods
  public void withdraw(double amount) 
         throws InvalidBalanceException {
	if (amount < balance)	 
      this.balance -= amount;
	else
	    throw new InvalidBalanceException(balance); 
  }
  
  public void deposit(double amount) 
         throws InvalidBalanceException {
	if (amount + balance > 0 )	 
      this.balance += amount;
	else
	    throw new InvalidBalanceException(balance);   
  }

  // override of Object method
  public String toString() {
	// return string with formatted data 
	// left-align 20 character column and right-align 15 character column
	return String.format("%-20s%15d\n%-20s%15tD\n%-20s%15s\n%-20s%15.2f%%\n%-20s%,15.2f\n",
      "ID:", this.id,
      "Created:", this.dateCreated,
      "Owner:", this.name,
      "Annual Rate:", this.annualInterestRate,
      "Balance:", this.balance);
  }
}