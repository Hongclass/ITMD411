// create class to test creation of non-static, and static inner classes
// Ch 16.4 Inner Classes
public class TestInnerClass {
	/** Main method */
	public static void main(String[] args) {
		// syntax for non-static inner class
		// create instance of outer class
		ControlCircle testOuter = new ControlCircle();
		// create instance of inner class
		ControlCircle.CirclePanel testInner = testOuter.new CirclePanel();
		// syntax for static inner class
		// create instance of inner using static outer class name
		// NOTE: Need to add 'static' to nested CirclePanel class
		//       and comment out 'testInner' variable declaration.
		//ControlCircle.CirclePanel testInnerStatic = new ControlCircle2.CirclePanel();
	}
}