/** This program gives a simple demonstration of some
    of the generic ListType class's methods.
*/

public class GenericListDemo
{
   public static void main(String[] args)
   {
      // Create a list to hold Car objects.
      ListType<Car> carList = new ListType<Car>();
      
      // Create a few Car objects.
      Car vw = new Car("227H54", "1997 Volkswagen");
      Car porsche = new Car("453B55", "2007 Porsche");
      Car bmw = new Car("177R60", "1980 BMW");

      // Add the cars to the list.
      carList.add(vw);
      carList.add(porsche);
      carList.add(bmw);
      
      // Display the elements in the list.
      System.out.println("Here are the elements in the list:");
      displayList(carList);

      // Remove the first and last elements.
      carList.remove(0);
      carList.remove(carList.size() - 1);
      
      // Display the list.
      System.out.println("\nNow with the first and last removed:");
      displayList(carList);

      // Create two new Car objects.
      Car mustang = new Car("448A69", "1965 Mustang");
      Car corvette = new Car("99C33", "2006 Corvette");
      
      // Add the new Cars to the beginning and end of the list.
      carList.add(0, mustang);
      carList.add(corvette);

      // Display the list one last time.
      System.out.println("\nNow with new first and last elements:");
      displayList(carList);    
   }

   /** The displayList method displays the elements in
       an GeneralList object.
       @param list The list to display.
   */
   public static void displayList(GeneralList list)
   {
      for (int index = 0; index < list.size(); index++)
      {
         System.out.println("Index " + index + ": " +
                            list.get(index));
      }
   }
}