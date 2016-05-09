/**
   The Car class stores a VIN (Vehicle Identification
   Number) and a description for a car.
*/

public class Car
{
   private String vin;          // Vehicle Identification Number
   private String description;  // Car description
   
   /**
      Constructor
      @param v The VIN for the car.
      @param desc The description of the car.
   */
   
   public Car(String v, String desc)
   {
      vin = v;
      description = desc;
   }
   
   /**
      toString method
      @return A string containing the VIN and description.
   */
   
   public String toString()
   {
      return "VIN: " + vin +
             "  Description: " +
             description;
   }
 
   /**
      equals method
      @param obj Another object to compare this object to.
      @return true if the two objects are equal, false otherwise.
   */
     
   public boolean equals(Object obj)
   {
      // Make sure the other object is a Car.
      if (obj instanceof Car)
      {
         // Get a Car reference to obj.
         Car tempCar = (Car) obj;
         
         // Compare the two VINs. If the VINs are
         // the same, then they are the same car.
         if (vin.equalsIgnoreCase(tempCar.vin))
            return true;
         else
            return false;
      }
      else
         return false;
   }
}