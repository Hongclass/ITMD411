/* 
   Program to write payroll information
   from the user and writes the information 
   into payroll.txt data file.  
   Programmer: Hong Zhang, 
   File Name: CreateData.java
*/

import java.awt.Graphics;   
import javax.swing.JOptionPane;
import java.io.*;
import java.io.FileWriter;    
 
public class CreateData {
	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, 
				"this program writes payroll data",
				"Welcome", JOptionPane.PLAIN_MESSAGE);
		int repeat = 1;
		String answer;

		do {
		    Write();
		    answer = JOptionPane.showInputDialog("write payroll data?\n"     
		                          + "enter 1 to continue or 0 to exit");

		    repeat = Integer.parseInt(answer);

		} while(repeat == 1);
		  
		  System.exit(1);

	}
	
	static void Write()	{
		try {  
			String firstLine = "", secondLine = "", thirdLine = "", number = "";

			File check = new File("payroll.txt");  
			FileWriter file;
			if(check.exists()) 
				file = new FileWriter("payroll.txt", true);
			else
				file = new FileWriter("payroll.txt"); 
			BufferedWriter buffer = new BufferedWriter(file);
			number = JOptionPane.showInputDialog("how many records?");
			while(number == null || number.equals(""))
			number = JOptionPane.showInputDialog("Please input some data! how many records?");
			
			int size = Integer.parseInt(number);
			
			for (int count = 1; count <= size; count++) {				
				firstLine = JOptionPane.showInputDialog("Enter name");
				while(firstLine == null || firstLine.equals(""))
				firstLine = JOptionPane.showInputDialog("Please input some data! Enter name");
				
				secondLine = JOptionPane.showInputDialog("Enter hours");
				while(secondLine == null || secondLine.equals(""))
				secondLine = JOptionPane.showInputDialog("Please input some data! Enter hours");
				
				thirdLine = JOptionPane.showInputDialog("Enter wage");
				while(thirdLine == null || thirdLine.equals(""))
				thirdLine = JOptionPane.showInputDialog("Please input some data! Enter wage");
				
				buffer.write(firstLine);
				buffer.newLine();
				buffer.write(secondLine);
				buffer.newLine();
				buffer.write(thirdLine);
				buffer.newLine();				
			} 
			
			buffer.close();
			
			JOptionPane.showMessageDialog(null, "data processed",
					"Result", JOptionPane.PLAIN_MESSAGE );
			
		}
		
		catch (IOException e) { System.out.println(e); }  
	}
}
