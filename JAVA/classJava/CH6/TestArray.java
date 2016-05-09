/*
    Author: Hong Zhang
	File:   TestArray.java
	Date:   02/12/2014
	Descr:
	In-class exercise to demonstrate the use
*/

public class TestArray {
    // main method: program start
	public static void main(String[] args){
	    // creat an array of integers
		final int NUMBER_OF_ELEMENTS = 5;
		int[] list = new int[NUMBER_OF_ELEMENTS];
		
		// get user input values for array
		java.util.Scanner input = new java.util.Scanner(System.in);
		for (int i = 0; i < list.length; i++) {
		    System.out.print("Enter an integer value: ");
			list[i] = input.nextInt();
		}
		
		// copy array elements to new array
		int[] list1 = new int[list.length];
		System.arraycopy(list, 0, list1, 0, list.length);
	    
		// dispaly both arrays
        System.out.print("Using method to dispaly array elements...\n");
        System.out.print("\tsource array...\n");
        printArray(list1);
		System.out.print("\ttarget array...\n");
		printArray(list1);
		swapElements(list1);
		System.out.println("Swapped elements...");
		printArray(list1);
		
		
		// passing an anonymous array as an argument
		System.out.println("Passing an anonymous array argument...");
		printArray(new int[] {3, 1, 2, 6, 4, 2});
		
		// creating array from returned value of method
		int[] list2 = reverse(list1);
		System.out.println("Returning an array from a method...");
		printArray(list2);
		
	} // end of main method
	
	// method to print all elements of passed array
	public static void printArray(int[] array) {
	    //useing a for-each loop
		for (int aVal: array) 
		    System.out.print(aVal + " ");
		System.out.print("\n");
	}
	
	// method to swap first two elements of array
	// to demonstrate pass by sharing
	public static void swapElements(int[] array) {
	    int temp = array[0];
		array[0] = array[1];
		array[1] = temp;
	}
	
	// method to return array
	// reverses input array
	public static int[] reverse(int[] array){
	    int[] result = new int[array.length];
        for (int i = 0, j = result.length - 1;
                i < array.length; i++, j--)
            result[j] = array[i];
        return result;			
	}
	
} // end of class definition	
	