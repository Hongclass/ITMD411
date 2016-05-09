import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author        Hong Zhang
 * @file          ReadCircleWithException.java
 * @date          03/26/2014
 * @description   Example program to read circle information from file.
 */


public class ReadCircleWithException {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// prompt user for filename
		Scanner inputFromConsole = new Scanner(System.in);
		System.out.print("Enter a filename: ");
		String filename = inputFromConsole.nextLine();
		
		// create File object on Storage; link to Scanner object for input
		try {
			Scanner inputFromFile = new Scanner(new File(filename));
			// read data from file
			while (inputFromFile.hasNext()) {
				double radius = inputFromFile.nextDouble();
				String circleInfo = inputFromFile.nextLine();
				// create circle with given radius
				CircleWithException c1 = new CircleWithException(radius);
				System.out.println(c1);
			}
			// close file
			inputFromFile.close();
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception: " + filename + "not found!");
		} catch (InvalidRadiusException e) {
			// TODO Auto-generated catch block
			System.out.println("Invalid Radius: " + e);
		}
		finally {
				inputFromConsole.close();
		}
	    // output message to user
		System.out.println("Data read from " + filename );

	}

}

/*
Enter a filename: C:\temp\circle.txt
5.000000 Circle area = 78.539750

10.000000 Circle area = 314.159000

15.000000 Circle area = 706.857750

Data read from C:\temp\circle.txt

*/
