public class Circle extends GeometricObject {
  private double radius;
  /*Hong Zhang*/
  
  /** constructors */
  public Circle() {
	super();
  }

  public Circle(double radius) {
	super();
    this.radius = radius;
  }
  
  public Circle(double radius, 
		String color, boolean filled) {
	super(color, filled);
	this.radius = radius;
  }
  
  /** Return radius */
  public double getRadius() {
    return radius;
  }

  /** Set a new radius */
  public void setRadius(double radius) {
    this.radius = radius;
  }

  /** Return area */
  public double getArea() {
    return radius * radius * Math.PI;
  }

  /** Return diameter */
  public double getDiameter() {
    return 2 * radius;
  }

  /** Return perimeter */
  public double getPerimeter() {
    return 2 * radius * Math.PI;
  }
}
