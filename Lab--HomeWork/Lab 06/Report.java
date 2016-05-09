/* 
   program to generate a report for each individual 	
   employee whose payroll data is requested.
 
   Programmer: Hong Zhang, 
   File Name: Report.java
 */

import java.io.*;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Report { 
	
	// declare variables
	String firstLine = " ", 
		   secondLine = " ", 
		   thirdLine = " ";
    int hours = 0;
    double wages = 0,
    	   grosspay = 0,
    	   overpay = 0;
	    
    DecimalFormat twoDecimal = new DecimalFormat("0.00");
    static ArrayList<String> empNames = new ArrayList<String>();
    
    public Report() throws Exception {
    	
        //code here the logic to create a report for the user
        FileReader file = new FileReader("payroll.txt");
        BufferedReader buffer = new BufferedReader(file);
        
        String line;
        
        // read the file from payroll.txt
        while ((line = buffer.readLine()) != null) {
            firstLine = line;
            secondLine = buffer.readLine();
            thirdLine = buffer.readLine();
            empNames.add(line);
        }//end while
        
        buffer.close();
        file.close();
        
        String empList = "";
        
        Collections.sort(empNames);
        for (String str : empNames) 
            empList += str + "\n";
        
        //Employee Listing (names)                
        JOptionPane.showMessageDialog(null, "Name:\n" + empList, 
        		"Employee Listing", JOptionPane.PLAIN_MESSAGE);

        //Get input then of desired employee name to save employee data to a file
        String userInput = " ";
        
        userInput = JOptionPane.showInputDialog("To get a payroll report, "
        		+ "enter a name from the list: \n" + empList);

        while (userInput == null || userInput.equals("")) 
            userInput = JOptionPane.showInputDialog("To get a payroll report, "
            		+ "enter a name from the list: \n" + empList);
        
        // find the name if it exists in the list 
        boolean isExist = false;
        
        for(String string : empNames){
        	if((string.toUpperCase()).matches(userInput.toUpperCase())) {
        		isExist = true;
        	    break;
        	}
        }        
        
        // if exists, create the file to store the report
        if(isExist) { 

   		    // search this employee's information from payroll.txt  		  
   	        FileReader file1 = new FileReader("payroll.txt");
   	        BufferedReader buffer1 = new BufferedReader(file1);
   	        
   			while((line = buffer1.readLine()) != null) {
   				firstLine = line;
        	    secondLine = buffer1.readLine();
        	    thirdLine = buffer1.readLine();
        	    
   				if((userInput.toUpperCase()).matches(line.toUpperCase())) {
   					File check = new File(line.charAt(0) + 
   		        			userInput.substring(line.indexOf(' ') + 1) 
   		      	          + ".txt");  
   		        	
   		   		    FileWriter file2;
   		   		 
   		   		    if(check.exists()) 
   		   			    file2 = new FileWriter(line.charAt(0) + 
   		   					userInput.substring(line.indexOf(' ') + 1) 
   		   					+ ".txt", true);
   		   		    else
   		   			    file2 = new FileWriter(line.charAt(0) + 
   		   					userInput.substring(line.indexOf(' ') + 1) 
   		   					+ ".txt");    	    
   		   		    
   		   		    BufferedWriter buffer2 = new BufferedWriter(file2);
   		   		    
                	hours = Integer.parseInt(secondLine); 
                    wages = Double.parseDouble(thirdLine);
                    
                    if (hours <= 40)
                        overpay = 0.0;
                    else if (hours > 40)
                        overpay = (hours - 40) * wages * 1.5;
                            
                    if (hours <= 40)
                        grosspay = hours * wages;
                    else if (hours > 40)
                        grosspay = 40 * wages + overpay;  
                    
                    // write this report to his file        
                    buffer2.write("********** Payroll Report *****************************\n");
                    buffer2.newLine();
                    buffer2.write("");
                    buffer2.newLine();
                	buffer2.write("Employee Name:  " + line);
                    buffer2.newLine();
                    buffer2.write("Hours:          " + hours);
                    buffer2.newLine();
                    buffer2.write("Wages:         $" + twoDecimal.format(wages));
                    buffer2.newLine();
                    buffer2.write("Gross Pay:     $" + twoDecimal.format(grosspay));
                    buffer2.newLine();
                    buffer2.write("Overtime Pay:  $" + twoDecimal.format(overpay) + 
                        		                   "  (include in gross pay)");
                    buffer2.newLine();
                    buffer2.write("*******************************************************");
                    buffer2.newLine();
                    
                    buffer2.close();
                    
        	        break;
                }
   			} 
   			
   		    buffer1.close();
   		    file1.close();
                
            // show this report in GUI dialog box
            JOptionPane.showMessageDialog(null, 
                	"********** Payroll Replort *****************************\n"
                    + "Employee Name: " + line + "\n"
                    + "Hours:         " + hours + "\n" 
                    + "Wages:        $" + twoDecimal.format(wages) + "\n"  
                	 + "Gross Pay:    $" + twoDecimal.format(grosspay) + "\n"
                	 + "Overtime Pay: $" + twoDecimal.format(overpay) + "\n" +
                	"*******************************************************",
                	  "Result", JOptionPane.PLAIN_MESSAGE );

            // "Report Generated" Notification
            JOptionPane.showMessageDialog(null, "Report Generated.", 
                   		"Result", JOptionPane.PLAIN_MESSAGE);      
        }
        
      //Error Message
        else { 
            JOptionPane.showMessageDialog(null, 
             		"Error!! Name invalid or doesn't exist, please try again.");
        } 
        
        // clear the whole data in empNames
        empNames.clear();

    } //END of Public Report ()
    
    public static void main(String[] args) throws Exception {
    	new Report();
    } //End of Main

} // End of Report Class