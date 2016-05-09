import java.util.Iterator;

/** This program shows how we can use the
    enhanced for loop with the ListType class.
*/
public class IteratorDemo2
{
   public static void main(String[] args)
   {
      // Create a list to hold String objects.
      ListType<String> nameList = new ListType<String>();
      
      // Add some names to the list.
      nameList.add("Johnson");
      nameList.add("Graves");
      nameList.add("Smith");
      nameList.add("Jones");

      // Display the list elements.
      for (String str : nameList)
         System.out.println(str);
   }
}