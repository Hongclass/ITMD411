
public class StringTest {

	/**
	 * Hong Zhang
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String s1 = new String("Welcome to Java");
        String s2 = new String(s1);
        String s3 = new String(new char[] {'J', 'a', 'v', 'a'});
        String s4 = "Welcome to Java";
        String s5 = "Welcome to Java";
        
        // check for equality
        if (s1 == s2)
        	System.out.println("s1 and s2 are equal");
        else 
        	System.out.println("s1 and s2 are NOT equal");
        if (s1 == s4)
        	System.out.println("s1 and s4 are equal");
        else 
        	System.out.println("s1 and s4 are NOT equal");
        if (s4 == s5)
        	System.out.println("s4 and s5 are equal");
        else 
        	System.out.println("s4 is NOT equaland to s5");
        
        // check for comparisons
        if (s1.equals(s2))
        	System.out.println("s1 and s2 constain equivalent values");
        if (s1.equals(s4))
        	System.out.println("s1 and s4 constain equivalent values");
        
	}

}

/*
 * 
Sample Output:
s1 and s2 are NOT equal
s1 and s4 are NOT equal
s4 and s5 are equal
s1 and s2 constain equivalent values
s1 and s4 constain equivalent values


*/
