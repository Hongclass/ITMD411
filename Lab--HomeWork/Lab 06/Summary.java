/* 
   Program to use Control-Break Logic 
   
   Programmer: Hong Zhang, 
   File Name: Summary.java
*/

import java.io.*;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Summary {
	
	// declare variables
	String firstLine = "", 
		   secondLine = "";
			
	double overpay1 = 0,
		   subTotal1 = 0,
		   overpay2 = 0,
		   subTotal2 = 0,
		   overpay3 = 0,
		   subTotal3 = 0,
		   total = 0;
	
	DecimalFormat twoDecimal = new DecimalFormat("0.00");
	
    static ArrayList<String> empNames1 = new ArrayList<String>();
    static ArrayList<String> empNames2 = new ArrayList<String>();
    static ArrayList<String> empNames3 = new ArrayList<String>();
    
    public Summary() throws Exception {
    	
    	FileReader file = new FileReader("Overtime.txt");
        BufferedReader buffer = new BufferedReader(file);
        
        String line; 
        
        while((line = buffer.readLine()) != null) {
   				firstLine = line;
        	    secondLine = buffer.readLine();
        	    
        	    // first name begins with A through F 
   				if(line.charAt(0) >= 65 && line.charAt(0) < 71) {
   					empNames1.add(line);
                	overpay1 = Double.parseDouble(secondLine); 
                	subTotal1 = subTotal1 + overpay1;
                }
   				// first name begins with total G through L 
   				else if(line.charAt(0) >= 71 && line.charAt(0) < 77) {
   					empNames2.add(line);
                	overpay2 = Double.parseDouble(secondLine); 
                	subTotal2 = subTotal2 + overpay2;
                }
   				// first name begins with total M through Z 
   				else {
   					empNames3.add(line);
                	overpay3 = Double.parseDouble(secondLine); 
                	subTotal3 = subTotal3 + overpay3;
   				}	
   			} 
        
        total = subTotal1 + subTotal2 + subTotal3;
        
        String empList1 = "";
        
        Collections.sort(empNames1);
        for (String str : empNames1) 
            empList1 += str + "\n";
        
        String empList2 = "";
        
        Collections.sort(empNames2);
        for (String str : empNames2) 
            empList2 += str + "\n";
        
        String empList3 = "";
        
        Collections.sort(empNames3);
        for (String str : empNames3) 
            empList3 += str + "\n";
        
        String show = "Name (First name for A to F):\n" + empList1 
        		+ "Subtotal overpay: " + twoDecimal.format(subTotal1) + "\n\n" + 
        		"Name (First name for G to L):\n" + empList2 
        		+ "Subtotal overpay: $" + twoDecimal.format(subTotal2) + "\n\n" +
        		"Name (First name for M to Z):\n" + empList3 
        		+ "Subtotal overpay: " + twoDecimal.format(subTotal3) + "\n\n" 
        		+ "Grandtotal overpay: " + twoDecimal.format(total);
        
        //Employee Listing (names)                
        JOptionPane.showMessageDialog(null, show, 
        		"Employee Overpay", JOptionPane.PLAIN_MESSAGE);
        
        buffer.close();
        file.close();

    } //END of Public Summary ()
	
    public static void main(String[] args) throws Exception {
    	new Summary();
    } //End of Main

} // end of Summary class
