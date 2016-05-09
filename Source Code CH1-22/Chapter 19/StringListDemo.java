import java.util.Scanner;

/** This program gives a simple demonstration of some
    of the StringListType methods.
*/

public class StringListDemo
{
   public static void main(String[] args)
   {
      // Create a StringListType object.
      StringListType myList = new StringListType();

      // Create a Scanner for keyboard input.
      Scanner keyboard = new Scanner(System.in);
      
      // Get a line of input.
      System.out.println("Enter a series of words:");
      String input = keyboard.nextLine();
      
      // Tokenize the string.
      String[] tokens = input.split(" ");
      
      // Add each of the tokens to the list.
      for (String s : tokens)
         myList.add(s);
      
      // Display the list.
      System.out.println("\nHere are the words you entered:");
      displayList(myList);
      
      // Remove the first and last elements.
      myList.remove(0);
      myList.remove(myList.size() - 1);
      
      // Display the list.
      System.out.println("\nNow with the first and last removed:");
      displayList(myList);
      
      // Add new elements to the beginning and end of the list.
      myList.add(0, "dog");
      myList.add("cat");
      
      // Display the list.
      System.out.println("\nNow with new first and last elements:");
      displayList(myList);    
   }
   
   /** The displayList method displays the elements in
       a StringList object.
       @param list The list to display.
   */
   public static void displayList(StringList list)
   {
      for (int index = 0; index < list.size(); index++)
      {
         System.out.println("Index " + index + ": " +
                            list.get(index));
      }
   }
}