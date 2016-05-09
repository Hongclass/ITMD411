 /*
    File:   InvalidBalanceException.java
	Author: Hong Zhang
    Date:   04/07/2014
    Description: custom exception for invalid balance
*/

public class InvalidBalanceException extends Exception {
  private double balance;

  /** Construct an exception */
  public InvalidBalanceException(double balance) {
    super("Invalid balance " + balance);
    this.balance = balance;
  }

  /** Return the balance */
  public double getBalance() {
    return balance;
  }
}