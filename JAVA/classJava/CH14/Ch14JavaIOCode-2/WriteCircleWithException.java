import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * @author        Hong Zhang
 * @file          WriteCircleWithException.java
 * @date          03/26/2014
 * @description   Example program to write circle information to file.
 * @modifications
 */


/** CRE**checked exceptions declared and handled in try/catch block */

public class WriteCircleWithException {
	public static void main(String[] args) throws FileNotFoundException {
		
		// create File object to reference file on storage
		File file = new File("C:/Temp/Circle.txt");  
		// File file = new File("Circle.txt");
		
		if (file.exists())
			System.out.println("File will be overwritten...");
		else
			System.out.println("File will be created...");
		// create PrintWriten object to output data
		// referencing the previously created File object
		PrintWriter output = new PrintWriter(file);
		
		try {
			CircleWithException[] cArr = {new CircleWithException(5),
					new CircleWithException(10),
					new CircleWithException(15)};
			
			// display created array of circle objects
			for (CircleWithException ce: cArr) 
				// System.out.print(ce);
				output.print(ce);
						
		}
		/** CRE**add to use custom exception */
		catch (InvalidRadiusException ex) {
			System.out.println(ex);
		}
		// make sure file is closed
		finally {
			System.out.println("Closing file...");
			output.close();
		}
	  	  
		System.out.println("Number of objects created: " +
			CircleWithException.getNumberOfObjects());
	}
}