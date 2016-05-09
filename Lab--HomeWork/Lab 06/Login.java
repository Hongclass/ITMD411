/* 
   Program to require a login entry screen 
   to access a main program
  
   Programmer: Hong Zhang, 
   File Name: Login.java
*/

import java.awt.Graphics;   
import javax.swing.JOptionPane;
import java.lang.String; 

public class Login {
	public static void main(String[] args) { 
		
		// declare variables
		boolean access = false;	
		boolean nameMatch = false;
		boolean passwordMatch = false;
		
		int nameAttempts = 0;
		int passwordAttempts = 0;
		
		String name;
		String password;
		
		// enter username
		String message = "welcome" + "\n", response;
		message += "enter your name";
		message += "\n" + " ";   
		
		do {
			name = JOptionPane.showInputDialog(message);
		    name = name.trim();
		    name = name.toUpperCase();
		    if (name.equals("SAMMY")){
			    nameMatch = true;
			    JOptionPane.showMessageDialog(null,"hello " + name);
			    break;
		    }
		    else 
		    	JOptionPane.showMessageDialog(null, "Incorrect login name!");
		    nameAttempts++;		
		} while(nameAttempts < 3 && nameMatch == false); 
		
		if (nameAttempts == 3 && nameMatch == false)
			System.exit(1);;
		
		// enter password
		
		message = "enter your password";
		message += "\n" + " ";
		
		do {
			password = JOptionPane.showInputDialog(message);
			password = password.trim(); 
			password = password.toUpperCase();
			if (password.equals("AUTUMN")){
				passwordMatch = true;
				access = true;
			    break;
		    }
			else
				JOptionPane.showMessageDialog(null, "Incorrect Password!");
			passwordAttempts++;	
		} while(passwordAttempts < 3 && passwordMatch == false);
			
		if(access == true) {
			try {
				Menu m = new Menu(); 
				System.exit(1);
				}
			
			catch (Exception e) { System.out.println(e);} 
		}

	}//end main
	
}//end class
