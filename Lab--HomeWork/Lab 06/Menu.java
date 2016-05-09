/* 
   Program to creates a menu
  
   Programmer: Hong Zhang, 
   File Name: Menu.java
*/

import java.awt.Graphics;   
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

//programmer: Hong Zhang

public class Menu {
	
	public Menu() {
		
		String message = "welcome" + "\n", response;

		message += "\n" + "enter...";
		message += "\n" + "  1 to enter payroll data";
		message += "\n" + "  2 to view payroll data";
		message += "\n" + "  3 to generate report by employee";	
		message += "\n" + "  4 to view overtime pay data";	
		message += "\n" + "  5 to exit" + "\n" + " ";
		
		char answer = 'Y';
		
		do {
			
			try {  
				
				response  = JOptionPane.showInputDialog(message);
				while (response == null || response.equals("")) 
					response  = JOptionPane.showInputDialog(message);
				
				// judge if input is string or number 
				boolean isNumeric = true;
		        
		        for (int i = response.length(); --i >=0;) {
		        	if(!Character.isDigit(response.charAt(i))) {
		        		isNumeric = false;
		        	}
		        }
				
				if (isNumeric == false) {
					JOptionPane.showMessageDialog(null, 
		                      "Please enter 1-5and try again", "Result", 
		                      JOptionPane.PLAIN_MESSAGE );

				}
				else
				{
					int choice = Integer.parseInt(response);
	
					switch (choice) {
						case 1:  CreateData cd = new CreateData();
						answer = 'Y'; //System.exit(1);
						break;
						case 2:  ReadData rd = new ReadData();
						answer = 'Y';  //System.exit(1);
						break;
						case 3:  Report  rpt = new Report();
						answer = 'Y';  //System.exit(1);
						break;
						case 4:  Summary  op = new Summary();
						answer = 'Y';  //System.exit(1);
						break;
						case 5:  answer = 'N';  //System.exit(1);
						break;
						default: { answer = 'Y'; choice = 0;
						JOptionPane.showMessageDialog(null,"enter a number: 1 - 4");
						} 
					}//end switch
				}
		}//end try
 
		catch (Exception e ) { System.out.println(e); }  
			
		} while(answer == 'Y' || answer == 'y');  
		
		JOptionPane.showMessageDialog(null,"Goodbye!!");
	}
	
	public static void main(String[] args) { 
		new Menu();
		
	}//end main

}//end class 


 	         