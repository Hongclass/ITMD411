import java.util.*;

/**
   This program demonstrates how to add elements
   to a HashSet. It also shows that duplicate
   elements are not allowed.
*/

public class HashSetDemo1
{
   public static void main(String[] args)
   {
      // Create a HashSet to hold String objects.
      Set<String> fruitSet = new HashSet<String>();
      
      // Add some strings to the set.
      fruitSet.add("Apple");
      fruitSet.add("Banana");
      fruitSet.add("Pear");
      fruitSet.add("Strawberry");
      
      // Display the elements in the set.
      System.out.println("Here are the elements.");
      for (String element : fruitSet)
         System.out.println(element);
      
      // Try to add a duplicate element.
      System.out.println("\nTrying to add Banana to " +
                         "the set again...");
      if (!fruitSet.add("Banana"))
         System.out.println("Banana was not added again.");
      
      // Display the elements in the set.
      System.out.println("\nHere are the elements once more.");
      for (String element : fruitSet)
         System.out.println(element);
   }
}