import java.util.*;

/**
   This program demonstrates an ArrayList.
*/

public class ArrayListDemo1
{
   public static void main(String[] args)
   {
      // Create an ArrayList to hold String objects.
      List<String> nameList = new ArrayList<String>();
      
      // Add some names to the ArrayList.
      nameList.add("Chris");
      nameList.add("David");
      nameList.add("Katherine");
      nameList.add("Kenny");
      
      // Display the size of the ArrayList.
      System.out.println("The ArrayList has " +
                         nameList.size() +
                         " objects stored in it.");

      // Now display the items in nameList.
      for (int index = 0; index < nameList.size(); index++)
      {
         System.out.println("The name stored at Element " + 
                            index + " is " + nameList.get(index));
      }
   }
}