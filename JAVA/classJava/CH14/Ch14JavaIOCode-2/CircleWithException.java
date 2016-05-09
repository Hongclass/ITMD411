/**
 * @author        Hong Zhang
 * @file          CircleWithException.java
 * @date          03/26/2014
 * @description   Circle class with radius attribute and accompanying class members.
 *                Static instance counter and exception handling included.
 * @modifications
 */

public class CircleWithException {
  /** The radius of the circle */
  private double radius;

  /** The number of the objects created */
  private static int numberOfObjects = 0;

  /** Construct a circle with radius 1 */
  public CircleWithException()
    	//**CRE**change to use custom exception
		throws InvalidRadiusException {
    this(1.0);
  }

  /** Construct a circle with a specified radius */
  public CircleWithException(double newRadius)
  		//**CRE**change to use custom exception
		throws InvalidRadiusException {
    setRadius(newRadius);
    numberOfObjects++;
  }

  /** Return radius */
  public double getRadius() {
    return radius;
  }

  /** Set a new radius */
  public void setRadius(double newRadius)
		//throws IllegalArgumentException {
		//**CRE**change to use custom exception
		throws InvalidRadiusException {
    if (newRadius >= 0)
      radius =  newRadius;
    else
      //throw new IllegalArgumentException(
		//"Radius cannot be negative");
		//**CRE**change to use custom exception
		throw new InvalidRadiusException(newRadius);
  }

  /** Return numberOfObjects */
  public static int getNumberOfObjects() {
    return numberOfObjects;
  }

  /** Return the area of this circle */
  public double findArea() {
    return radius * radius * 3.14159;
  }
  
  /** override method to create String
   * representation of CircleWithException object
   */
  public String toString() {
	  return String.format("%f Circle area = %f%n", 
			  this.radius, this.findArea());  
  }
   
}
