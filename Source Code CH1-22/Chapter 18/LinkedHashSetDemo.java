import java.util.*;

/**
   This program demonstrates how a LinkedHashSet
   preserves the order in which elements are added.
*/

public class LinkedHashSetDemo
{
   public static void main(String[] args)
   {
      // Create a HashSet and store some values in it.
      Set<String> set1 = new HashSet<String>();
      set1.add("Apple");
      set1.add("Strawberry");
      set1.add("Pear");
      set1.add("Banana");

      // Now create a LinkedHashSet and store some
      // values in it.
      Set<String> set2 = new LinkedHashSet<String>();
      set2.add("Apple");
      set2.add("Strawberry");
      set2.add("Pear");
      set2.add("Banana");
      
      // Display the elements in the HashSet.
      System.out.println("Here are the elements in " +
                         "the HashSet:");
      for (String str : set1)
         System.out.println(str);

      // Now display the elements in the LinkedHashSet.
      System.out.println("\nAnd here are the elements " +
                         "in the LinkedHashSet:");
      for (String str : set2)
         System.out.println(str);
   }
}