/*
    Author: Hong Zhang
	Date:   02/26/2014
	File:   TestDate.java
	Descr:
	In-class exercise to demonstrate use of Data objects.
*/

public class TestDate {
    public static void main(String[] args){
	    java.util.Date today = new java.util.Date();
		System.out.println("Good afternoon, today is " + today);
		System.out.printf("Today is %tA\n", today);
		System.out.printf("\t%1$tB %1$te, %1$tY\n", today);
		System.out.printf("\t%20tD\n", today);
		System.out.printf("\t%-20tD\n", today);
	} //end of main
} // end of TestData class