/*Hong Zhang*/

public class TestCircleWithException {
   public static void main(String[] args) {
	   
      try {
	     CircleWithException c1 = new CircleWithException(5);
		 CircleWithException c2 = new CircleWithException(-5);
		 CircleWithException c3 = new CircleWithException(0);
		 // forceArithmeticException();
		 return;
	  }
        
      catch (IllegalArgumentException ex) {
         System.out.println(ex);
      }
      
      catch (ArithmeticException ex) {
    	  System.out.println("Arithmetic Exception caught. ");
      }
      
      catch (InvalidRadiusException ex) {
    	  System.out.println("Invalid Radius Exception caught " + ex.getMessage());
      }
      
      
      // will catch anything from RuntimeException or subclass
      // superclass exception types must be after their subclass types
      // in order of the catch blocks
      catch (RuntimeException ex) {
    	  System.out.println("Runtime Exception caught. ");
      }
      
      finally {
    	  System.out.println ("Finally! We've reached the last statement");
    	  
      }
      
      System.out.println("Number of objects created: " +
      CircleWithException.getNumberOfObjects());
  }
   
   // method to force an exception throw
   public static void forceArithmeticException() {
	   throw new ArithmeticException();
   }
}
