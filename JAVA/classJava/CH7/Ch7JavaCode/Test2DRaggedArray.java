/*
   FILE:   Test2DRaggedArray.java
   AUTHOR: Your Name Here
   DATE:   MM/DD/YYYY
   DESCR:
   In-class exercise to demonstrate the use of ragged 2D array:
     1. creation and initialization
     2. passing as parameter
     3. displaying all elements
     4. summing elements by row
     5. summing elements by column
*/
public class Test2DRaggedArray {
  public static void main(String[] args) {

    // test arrays
    int[][] matrix = {{1, 2, 3, 4, 5},
                      {1, 2, 3, 4},
                      {1, 2, 3},
                      {1, 2},
                      {1}};

    // processing 2D ragged array of numbers
    System.out.println("Contents of Ragged Two Dimensional Array...");
    printArray(matrix);
    System.out.println("Summing Elements By Row...");
    sumByRow(matrix);
    System.out.println("Summing Elements By Column...");
    sumByColForRagged(matrix);
  }

  // print out elements of 2D ragged matrix
  public static void printArray(int[][] matrix) {
    for (int row = 0; row < matrix.length; row++) {
      for (int col = 0; col < matrix[row].length; col++)
        System.out.print(matrix[row][col] + " ");
      System.out.print("\n");
    }
  }

  // summing elements by row for ragged array
  public static void sumByRow(int[][] matrix) {
    for (int row = 0; row < matrix.length; row++) {
      int total = 0;
      // hold row constant, loop over column
      for (int col = 0; col < matrix[row].length; col++)
        total += matrix[row][col];
      System.out.println("Sum for row " + row + " is " + total);
    }
  }

  // summing elements by col for ragged array
  public static void sumByColForRagged(int[][] rmatrix) {
    // find the maximum number of elements (col) for any row
    // use maximum column to define an array of column totals
    int maxCol = rmatrix[0].length;
    for (int row = 0; row < rmatrix.length; row++)
		if (rmatrix[row].length > maxCol)
			maxCol = rmatrix[row].length;
	// create array to hold column totals
	// initialized to 0 by default
    int[] colTotals = new int[maxCol];
    // loop through each row
    for (int row = 0; row < rmatrix.length; row++)
      // add each value to appropriate column total
      for (int col = 0; col < rmatrix[row].length; col++)
        colTotals[col] += rmatrix[row][col];
    // print out the column totals
    for (int col = 0; col < colTotals.length; col++)
      System.out.println("Sum for ragged column " + col + " is " + colTotals[col]);
  }

}