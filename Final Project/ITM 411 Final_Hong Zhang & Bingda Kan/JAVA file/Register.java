import javax.swing.JOptionPane;

public class Register{

	public Register() {

		String message = "Welcome to IT help desk touble tickets system." + "\n", response;

		message += "\n" + "Enter a number to choose an option. You are:";
		message += "\n" + "  1 User";
		message += "\n" + "  2 Administrator";
		message += "\n" + "  3 Exit" + "\n" + " ";

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
							"Please enter 1-3 and try again", "Result",
							JOptionPane.PLAIN_MESSAGE);
					 new Register();

				} else {
					int choice = Integer.parseInt(response);

					switch (choice) {
					case 1:
						JOptionPane.showMessageDialog(null,
								"Mention: Because you are a user, you can only view ticket(s)", "Mention",
								JOptionPane.PLAIN_MESSAGE);
						UserChoice c = new UserChoice();
						answer = 'Y';  //System.exit(2);
						break;
					case 2:
						LogIn li = new LogIn();
						answer = 'Y'; // System.exit(1);
						break;
					case 3:
						answer = 'N'; // System.exit(1);
						break;
					default: {
						answer = 'Y';
						choice = 0;
						JOptionPane.showMessageDialog(null,
								"Enter a number: 1 - 3");
						new Register();
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
		new Register();

	}// end main

}// end class