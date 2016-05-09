/* 
   Program to write payroll information
   from the user and writes the information 
   into payroll.txt data file.
  
   Programmer: Hong Zhang, 
   File Name: CreateData.java
*/

import javax.swing.JOptionPane;
import java.io.*;
import java.io.FileWriter;    
 
public class CreateData {
	
    public static void main(String[] args) {
	    new CreateData();	
	} // end main
    
    public CreateData() {
        int repeat = 1;
        String answer;
	
        do {
        	Write();
        	answer = JOptionPane.showInputDialog ("write payroll " + 
                     "data?\n" + "enter 1 to continue or 0 to exit");

            repeat = Integer.parseInt(answer);
            
        } while(repeat == 1);

    } // end CreatData()
 
    static void Write() {
    	try {
    		String firstLine, secondLine, thirdLine, number = ""; 
    		File check = new File("payroll.txt");  
    		FileWriter file;
    		
    		if(check.exists()) 
    			file = new FileWriter("payroll.txt", true);
    		else
    			file = new FileWriter("payroll.txt"); 
    		BufferedWriter buffer = new BufferedWriter(file);
    		
    		int size, count = 1; 
    		
    		while(number == null || number.equals("")) 
    		number = JOptionPane.showInputDialog("how many records?");
    		
    		size = Integer.parseInt(number);
	  
	     do {
	    	 firstLine = JOptionPane.showInputDialog("Enter name");
	    	 secondLine = JOptionPane.showInputDialog("Enter hours");
	    	 thirdLine = JOptionPane.showInputDialog("Enter wage");
	    	 buffer.write(firstLine);
	    	 buffer.newLine();
	    	 buffer.write(secondLine);
	    	 buffer.newLine();
	    	 buffer.write(thirdLine);
	    	 buffer.newLine();
	    	 count++;
	     } while(count <= size);
	     
	     buffer.close();

	     JOptionPane.showMessageDialog(null, "data processed",
	                    "Result", JOptionPane.PLAIN_MESSAGE );
	   }
    	
	   catch (IOException e) { 
		   System.out.println(e); 
	   }  
	} // end Write()
} // end class
