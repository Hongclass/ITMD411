/*
    File:   Test2DArray.java
	Author: Hong Zhang
	Date:   02/19/2014
	Descr:
	In-class exercise to demonstrate the use of 2D arrays:
	1. create and initialize an array
	2. print out elements of 2 dimensional array
	3. sum by row 
	4. sum by column
*/

class Test2DArray{

    // main method
    public static void main(String[] args){
	    // create and initialize an array
		int[][] numbers = {{1, 2, 3}, {4, 5, 6}};
		// display all elements of 2D array
		System.out.println("Contents of 2D array...");
		printArray(numbers);
		// sum each row
		System.out.println("Summing each row of 2D array...");
		sumByRow(numbers);
		// sum each column
		System.out.println("Summing each column of 2D array...");
		sumByCol(numbers);
		
	} // end of main method
	
	// print out elements of 2 dimensional array
	public static void printArray(int[][] matrix){
	    // loop for each row
		for (int row = 0; row < matrix.length; row++){
		    // loop for each column in row
			for (int col = 0; col < matrix[row].length; col++)
			    System.out.print(matrix[row][col] + " ");
		    // newline at end of row
			System.out.print("\n");
		}
	} // end of printArray method
	
	// sum by row 
	public static void sumByRow (int[][] matrix){
	    // loop for each row 
		for (int row = 0, total = 0; row < matrix.length; row++, total = 0){
		    // loop for each column in row 
		    for (int col = 0; col < matrix[row].length; col++)
			    total += matrix[row][col];
			System.out.println("Sum for row" + row + " is " + total);
		}
	}  // end of sumByRow method
	
	// sum by column 
	public static void sumByCol (int[][] matrix){
	    // loop for each column 
		// assumption of same columns for each row
		for (int col = 0, total = 0; col < matrix[0].length; col++, total = 0){
		    // loop for each row in column 
		    for (int row = 0; row < matrix.length; row++)
			    total += matrix[row][col];
			System.out.println("Sum for column" + col + " is " + total);
		}
	} // end of sumByCol method
	
} // end of class