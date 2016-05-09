/*Hong Zhang*/

import java.math.*;

public class SortComparableObjects {
  public static void main(String[] args) {
    String[] cities = {"Savannah", "Boston", "Atlanta", "Tampa"};
    java.util.Arrays.sort(cities);
    for (String city: cities)
      System.out.print(city + " "); 
    System.out.println();
    
    BigInteger[] hugeNumbers = {new BigInteger("2323231092923992"),
       new BigInteger("432232323239292"), 
       new BigInteger("54623239292")};    
    java.util.Arrays.sort(hugeNumbers);
    for (BigInteger number: hugeNumbers)
      System.out.print(number + " "); 
    
    // test the use of ComparableRectangle
    ComparableRectangle[] rectangles = {
    		new ComparableRectangle(3.4, 5.4),
    		new ComparableRectangle(13.24,55.4),
    		new ComparableRectangle(7.4, 35.4),
    		new ComparableRectangle(1.4, 25.5)};
    
    // sort the rectangles
    java.util.Arrays.sort(rectangles);
    
    // display the sorted rectangles
    System.out.println(); //add a CRLF
    for(ComparableRectangle rect: rectangles) {
    	System.out.print(rect);
    }
  }
}