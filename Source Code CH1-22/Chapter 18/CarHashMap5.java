import java.util.*;

/**
   This program displays the mappings stored in a
   TreeMap. The mappings are displayed in ascending
   key order.
*/

public class CarHashMap5
{
   public static void main(String[] args)
   {
      // Create a TreeMap to store Car objects.
      SortedMap<String, Car> carMap = 
             new TreeMap<String, Car>();
      
      // Create some Car objects.
      Car vw = new Car("227H54", "1997 Volkswagen");
      Car mustang = new Car("448A69", "1965 Mustang");
      Car porsche = new Car("453B55", "2007 Porsche");
      Car bmw = new Car("177R60", "1980 BMW");
      
      // Put some mappings into the TreeMap. In each
      //  mapping, the car's VIN is the key and the
      // Car object containing that VIN is the value.
      carMap.put(vw.getVin(), vw);
      carMap.put(mustang.getVin(), mustang);
      carMap.put(porsche.getVin(), porsche);
      carMap.put(bmw.getVin(), bmw);
      
      // Get a set containing the mappings in this map.
      Set<Map.Entry<String, Car>> cars = carMap.entrySet();
      
      // Iterate through the mappings, printing each one.
      System.out.println("Here are the mappings:");
      for (Map.Entry<String, Car> entry : cars)
      {
         System.out.println("Key = " + entry.getKey());
         System.out.println("Value = " + entry.getValue());
         System.out.println();
      }
   }
}