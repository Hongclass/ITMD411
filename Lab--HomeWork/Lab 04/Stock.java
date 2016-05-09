/* 
   Program to create stock transactions for XYZ stock 
   for various clients and display a gain or loss on  
   shares based on a given transacted stock price 
   versus an updated stock price.     
   Programmer: Hong Zhang, 
   File Name: Stock.java and StockPurchase.java
*/

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * The Stock class holds data about a stock.         
 * This version of the class has an equals method.
 */

public class Stock {
	private String symbol;     // Trading symbol of stock
	private static double sharePrice; // Current price per share
	private static double updatedSharePrice; // Updated current price per share
	static int count = 0;
 
/**
   Constructor
   @param sym The stock's trading symbol.
   @param price The stock's share price.
*/
	public Stock(String sym, double price, double updatedPrice)
	{
		symbol = sym;
		sharePrice = price;
		updatedSharePrice = updatedPrice;
		count++;
	}
	
	public Stock() //for Subclass call
	{
		count++;
		System.out.println("New client request count #" + count);
	}

/**
	Copy constructor
		@param object2 The Stock object to copy.
*/
	public Stock(Stock object2)
	{
		this.symbol = object2.symbol;
		this.sharePrice = object2.sharePrice;
	}
	
/**
   getSymbol method
   @return The stock's trading symbol.
*/
	public String getSymbol()
	{
		return symbol;
		}
	
/**
   getSharePrice method
   @return The stock's share price
*/
	public double getSharePrice()
	{
		return sharePrice;
	}
	
/**
	getUpdatedSharePrice method
	@return The stock's updated share price
*/	
	public double getUpdatedSharePrice()
	{
	    return updatedSharePrice;
	}
	
/**
   toString method
   @return A string indicating the object's
           trading symbol and share price.
*/
	public String toString()
	{
		// Create a string describing the stock.
		String str = "Trading symbol: " + symbol +
				"\nShare price: " + sharePrice;
		// Return the string.
		return str;
}

/**
   The copy method makes a copy of a Stock object.
   @return A reference to a copy of the calling object.
*/
	public Stock copy()
	{
		// Create a new Stock object and initialize it
		// with the same data held by the calling object.
		Stock copyObject = new Stock(symbol, sharePrice, updatedSharePrice);
   
		// Return a reference to the new object.
		return copyObject;
		}
	
	public static void main(String[] args)
	{
		int sharesToBuy;  // Number of shares to buy.
		double pirceToBuy;   // price which buyers will buy
		double currentprice; // current share price
	      
		// Create a Stock object for the company stock.
	    // The trading symbol is XYZ, the stock is 
	    // $9.62 per share which buyers can buy now and 
		// the current stock price change to $20 per share.
		pirceToBuy = 9.62;
		currentprice = 20;
	    Stock xyzCompany = new Stock("XYZ", pirceToBuy, currentprice);
	    
	    System.out.println(xyzCompany);

	    // Create a Scanner object for keyboard input.
	    Scanner keyboard = new Scanner(System.in);
	      
	    // Create a DecimalFormat object to format numbers
	    // as dollar amounts.
	    DecimalFormat dollar = new DecimalFormat("#,###.00");
	      
	    //StockPurchase array of buyers 
	    StockPurchase [] theBuyers = new StockPurchase[3];  
	      
	    for(int x=0;x<3;x++)
	    {
	    // Display the current share prices.
	    	System.out.println("XYZ Company's stock is currently $"
	                  + dollar.format(xyzCompany.getSharePrice())
	                  + " per share.");
	                         
	        // Get the number of shares to purchase.
	        System.out.print("How many shares do you want to buy? ");
	        sharesToBuy = keyboard.nextInt();
	               
	        theBuyers[x]= new StockPurchase(xyzCompany, sharesToBuy);
	        // Display the cost of the transaction.
	        System.out.println("Cost of the stock: $"
	                    + dollar.format(theBuyers[x].getCost()));
	     }
	     
	    System.out.println();
	    // Display the header of table stock gain/loss
	    System.out.println("Client #   " + "Original Stock Cost   " + "Gain/Loss");	    
	    for(int x=0;x<3;x++)
	    {
	        // Display the table stock gain/loss.
	        System.out.printf("%2d%14s%1.2f%14s%1.2f",
	        		(x+1), "$", theBuyers[x].getCost(), "$",  
	        		(Stock.updatedSharePrice - Stock.sharePrice) * theBuyers[x] . getShares());
	        System.out.println();
	     }
	    
	 // dismiss the Scanner class object
	    keyboard.close();
	      
	  }//end main

}//end class

