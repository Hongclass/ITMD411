/*
    File:   AccountWithInterface.java
	Author: Hong Zhang
    Date:   04/16/2014
    Description:
    Class AccountWithInterface includes two interfaces, 
	cloneable and comparable one.	
*/

public class AccountWithInterface implements Cloneable, Comparable<AccountWithInterface>{
    // date field
	private int id;
    private double balance; 
	private java.util.Date dateCreated;
	private String name;
	
	private static double annualInterestRate;

    // constructor (no-arg or default)
    public AccountWithInterface() {
		dateCreated = new java.util.Date();
	}
	
	// parameterized constructor
    public AccountWithInterface(int id, double balance, String name) {
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
	
    public static void setAnnualInterestRate(double newAnnualInterestRate) {
        annualInterestRate = newAnnualInterestRate;
    }
	
	// accessor methods
	public int getId() {
	    return id;
	}
		
	public double getBal() {
		return this.balance;
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
	
	@Override // cloneable interface
    public Object clone() throws CloneNotSupportedException {
	    AccountWithInterface AccountClone = (AccountWithInterface)super.clone();
	    AccountClone.dateCreated = (java.util.Date)this.dateCreated.clone();
        return AccountClone;
  }

    @Override // comparable interface
    public int compareTo(AccountWithInterface o) {
        if (this.getBal() > o.getBal())
            return 1;
        else if (this.getBal() < o.getBal())
            return -1;
        else
            return 0;
  }  

} // end class AccountWithInterface