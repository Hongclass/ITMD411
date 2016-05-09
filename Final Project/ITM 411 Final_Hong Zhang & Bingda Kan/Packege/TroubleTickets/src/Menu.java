import java.awt.Graphics;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Menu{

	public Menu() {

		String message = "Welcome to IT help desk touble tickets system." + "\n", response;

		message += "\n" + "Enter a number to choose an option:";
		message += "\n" + "  1 to view ticket(s)";
		message += "\n" + "  2 to insert a ticket";
		message += "\n" + "  3 to update a ticket";
		message += "\n" + "  4 to delete a ticket";
		message += "\n" + "  5 to close a ticket";
		message += "\n" + "  6 to exit" + "\n" + " ";

		char answer = 'Y';

			try {

				response = JOptionPane.showInputDialog(message);
				while (response == null || response.equals(""))
					response = JOptionPane.showInputDialog(message);

				// judge if input is string or number
				boolean isNumeric = true;

				for (int i = response.length(); --i >= 0;) {
					if (!Character.isDigit(response.charAt(i))) {
						isNumeric = false;
					}
				}

				if (isNumeric == false) {
					JOptionPane.showMessageDialog(null,
							"Please enter 1-5 and try again", "Result",
							JOptionPane.PLAIN_MESSAGE);
					 new Menu();

				} else {
					int choice = Integer.parseInt(response);

					switch (choice) {
					case 1:
						Choice c = new Choice();
						answer = 'Y';  //System.exit(2);
						break;
					case 2:
						InsertData id = new InsertData();
						answer = 'Y'; // System.exit(1);
						break;
					case 3:
						UpdateTicket ut = new UpdateTicket();
						answer = 'Y'; // System.exit(1);
						break;
					case 4:
						DeleteChoice dc = new DeleteChoice();
						answer = 'Y'; // System.exit(1);
						break;
					case 5:
						CloseTicket ct = new CloseTicket();
						answer = 'Y'; // System.exit(1);
						break;
					case 6:
						answer = 'N'; // System.exit(1);
						break;
					default: {
						answer = 'Y';
						choice = 0;
						JOptionPane.showMessageDialog(null,
								"Enter a number: 1 - 4");
						new Menu();
					}
					}// end switch
				}
			}// end try

			catch (Exception e) {
				System.out.println(e);
			}
	if (answer == 'N' || answer == 'n')
		JOptionPane.showMessageDialog(null, "Thanks for using!!");
	}

	public static void main(String[] args) {
		new Menu();

	}// end main

}// end class
