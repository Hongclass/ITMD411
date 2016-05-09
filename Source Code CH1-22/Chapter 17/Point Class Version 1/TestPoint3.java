/**
   This program demonstrates the printPoint method.
*/

public class TestPoint3
{
   public static void main(String[] args)
   {
      // Create various Point objects.
      Point<Integer> iPoint = new Point<Integer>(1, 2);
      Point<Double> dPoint = new Point<Double>(1.5, 2.5);
      Point<Long> lPoint = new Point<Long>(10L, 20L);
      Point<Float> fPoint = new Point<Float>(7.9f, 9.9f);
      
      // Display each object's coordinates.
      System.out.println("iPoint:");
      printPoint(iPoint);

      System.out.println("\ndPoint:");
      printPoint(dPoint);

      System.out.println("\nlPoint:");
      printPoint(lPoint);

      System.out.println("\nfPoint:");
      printPoint(fPoint);
   }
   
   /**
      The printPoint method prints a Point object's
      X and Y coordinates.
      @param point A Point object.
   */
   
   public static void printPoint(Point<? extends Number> point)
   {
      System.out.println("X Coordinate: " + point.getX());
      System.out.println("Y Coordinate: " + point.getY());
   }
}