/* 
   Program to read payroll information
   from payroll.txt data file and display
   it to the user.
  
   Programmer: Hong Zhang, 
   File Name: ReadData.java
*/

import javax.swing.JOptionPane;
import java.io.*;   
import java.text.DecimalFormat;
 
public class ReadData { 
	
	DecimalFormat twoDecimal = new DecimalFormat("0.00");
	
	public ReadData () {
		try {  
			// declare variables
			String[] firstLine  = new String[100],
                     secondLine = new String[100],
                     thirdLine = new String[100];
   
            double hours[] = new double[100], 
            	   wages[] = new double[100],
            	   overTimePay[] = new double[100],
            	   grossPay[] = new double[100];
  
            int index;    

            for (index = 0; index < 100; index++) {
                firstLine[index] = "";
                secondLine[index] = "";
                thirdLine[index ] = "";
                hours[index] = 0.0;
                wages[index]= 0.0;
                overTimePay[index]= 0.0;
                grossPay[index]= 0.0;
            }

            FileReader file = new FileReader("payroll.txt");
            BufferedReader buffer = new BufferedReader(file);
            index = 0;
            String line;
            
            File check = new File("Overtime.txt");  
    		FileWriter fileOvertime;
    		
    		if(check.exists()) 
    			fileOvertime = new FileWriter("Overtime.txt", true);
    		else
    			fileOvertime = new FileWriter("Overtime.txt");    
    		BufferedWriter bufferOvertime = new BufferedWriter(fileOvertime);
   
            while((line = buffer.readLine()) != null) {
            	// read data from payroll.txt
            	firstLine[index] = line;
            	secondLine[index] = buffer.readLine();
            	thirdLine[index ] = buffer.readLine(); 
            	
                hours[index] = Double.parseDouble(secondLine[index]); 
                wages[index] = Double.parseDouble(thirdLine[index]);
               
                // calculate overtime pay and gross pay 
                if (hours[index] <= 40)
                	overTimePay[index] = 0.0;
                else if (hours[index] > 40)
                	overTimePay[index] = 
                	       (hours[index] - 40) * wages[index] * 1.5;
                
                if (hours[index] <= 40)
                	grossPay[index] = hours[index] * wages[index];
                else if (hours[index] > 40)
                	grossPay[index] = 40 * wages[index] 
                			                        + overTimePay[index];
                
                // write data into Overtime.txt
                bufferOvertime.write(line);
                bufferOvertime.newLine();
                bufferOvertime.write(twoDecimal.format(overTimePay[index]));
                bufferOvertime.newLine();
  
                JOptionPane.showMessageDialog(null, 
                      "Name: " + firstLine[index] + "\n"
                    + "Hours: " + hours[index] + "\n" 
                	+ "Wages: $" + twoDecimal.format(wages[index]) + "\n"  
                	+ "Gross Pay: $" + twoDecimal.format(grossPay[index]),
                	  "Result", JOptionPane.PLAIN_MESSAGE );
 
                index++;
            }
            
            buffer.close();
            bufferOvertime.close();
        }
		
		catch (IOException e ) { 
			System.out.println(e); 
		}      
		
    } // end ReadData ()
	
    public static void main(String[] args) {
	    new ReadData();
	} // end main
    
} // end class
