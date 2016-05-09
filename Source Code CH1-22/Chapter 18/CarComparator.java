import java.util.Comparator;

public class CarComparator<T extends Car>
                 implements Comparator<T>
{
   public int compare(T car1, T car2)
   {
      // Get the two cars' VINs.
      String vin1 = car1.getVin();
      String vin2 = car2.getVin();
      
      // Compare the VINs and return the
      // result of the comparison.
      return vin1.compareToIgnoreCase(vin2);
   }
}