import java.util.Iterator;

/** This program demonstrates how we can get an
    iterator for objects of the ListType class.
*/
public class IteratorDemo1
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
      
      // Get an iterator.
      Iterator<String> firstIt = nameList.iterator();
      
      // Use the iterator to search for "Smith" and
      // remove it from the list.
      while (firstIt.hasNext())
      {
         if (firstIt.next().equals("Smith"))
            firstIt.remove();
      }
      
      // Get another iterator.
      Iterator<String> secondIt = nameList.iterator();
      
      // Use the iterator to display each element
      // in the list. Smith has been removed.
      while (secondIt.hasNext())
         System.out.println(secondIt.next());
   }
}