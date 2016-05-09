/**
 * @author        Hong Zhang
 * @file          InvalidRadiusException.java
 * @date          03/26/2014
 * @description   custom exception for invalid radius
 * @modifications
 */

public class InvalidRadiusException extends Exception {
  private double radius;

  /** Construct an exception */
  public InvalidRadiusException(double radius) {
    super("Invalid radius " + radius);
    this.radius = radius;
  }

  /** Return the radius */
  public double getRadius() {
    return radius;
  }
}
