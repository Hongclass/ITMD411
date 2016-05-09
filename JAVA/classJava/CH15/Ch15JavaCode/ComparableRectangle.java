/*Hong Zhang*/

public class ComparableRectangle extends Rectangle 
            implements Comparable<ComparableRectangle> {
	// create constructor to take width and height
	public ComparableRectangle(double width, double height) {
		super(width,height);
	}
	
	
	// implement interface method
	public int compareTo(ComparableRectangle o) {
		// use area as criteria for comparison
		if (this.getArea() > o.getArea())
			return 1;
		else if (this.getArea() < o.getArea())
			return -1;
		else 
			return 0;
	}
	
	// provide String implementation
	public String toString() {
		return String.format("Width: %5.2f Height: %5.2f Area: %7.2f%n",
				getWidth(), getHeight(), getArea());
		
	}

}
