
public class TestStringBuilder {

	/**
	 * Hong Zhang
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// create a String object
		String st = new String();
		System.out.println("Length of st = " + st.length());
		// System.out.println("Length of st = " + st.capacity());
		
		// create a StringBuilder object
		StringBuilder sb = new StringBuilder();
		System.out.println("Length of sb = " + sb.length());
		System.out.println("Capacity of sb = " + sb.capacity());
		sb.append("This is a test");
		System.out.println("Length of sb = " + sb.length());
		System.out.println("Capacity of sb = " + sb.capacity());
		sb.append(" of my StringBuilder capacity!");
		System.out.println("Length of sb = " + sb.length());
		System.out.println("Capacity of sb = " + sb.capacity());
		sb.delete(0, 5);
		System.out.println("Length of sb = " + sb.length());
		System.out.println("Capacity of sb = " + sb.capacity());
	}

}
/*
Length of st = 0
Length of sb = 0
Capacity of sb = 16
Length of sb = 14
Capacity of sb = 16
Length of sb = 44
Capacity of sb = 44
Length of sb = 39
Capacity of sb = 44
 */
