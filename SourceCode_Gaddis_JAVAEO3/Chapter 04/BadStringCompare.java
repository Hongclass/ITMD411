import java.util.Scanner;  // Needed for the Scanner class

/**
 * This program incorrectly uses the == operator to compare
 * two String objects. The comparison does not work.
 */

public class BadStringCompare
{
   public static void main(String[] args)
   {
      String name1, name2;  // To hold two names

      // Create a Scanner object to read input.
      Scanner keyboard = new Scanner(System.in);

      // Get a name.
      System.out.print("Enter a name: ");
      name1 = keyboard.nextLine();
      
      // Get another name.
      System.out.print("Enter another name: ");
      name2 = keyboard.nextLine();

      if (name1 == name2)  // ERROR!
      {
         System.out.println(name1 + " and " + name2
                            + " are the same.");
      }
      else
      {
         System.out.println(name1 + " and " + name2
                            + " are NOT the same.");
      }
   }
}
