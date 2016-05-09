import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/** This GUI application demonstrates the operations of the
    ListType class.
*/

public class GenericListGUI extends JFrame
{
   // Constants for the JFrame width and height
   private final int WIDTH = 275;
   private final int HEIGHT = 285;
   
   // An array of JButtons
   private JButton[] buttonArray = 
              { new JButton("Clear"),
                new JButton("Size"),
                new JButton("Get..."),
                new JButton("Add..."),
                new JButton("Add At..."),
                new JButton("Remove..."),
                new JButton("Remove From..."),
                new JButton("Search..."),
                new JButton("Set...")
              };
   
   // A JList to display the list elements
   private JList displayList = new JList();
   
   // A ListType object
   private ListType<Car> list = new ListType<Car>();
   
   /** Constructor
   */
	
   public GenericListGUI()
   {
      // Display the title.
      setTitle("Generic List Demo");
      
      // Set the default closing action.
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // Set the layout manager.
      setLayout(new GridLayout(2, 1));
      
      // Set the JList's visible row count to 6.
      displayList.setVisibleRowCount(6);
      
      // Create a scroll pane for the JList.
      JScrollPane sp = new JScrollPane(displayList);
      
      // Create a panel to hold the JList.
      JPanel listPanel = new JPanel();
      
      // Add the scroll pane (and the JList) to the
      // panel.
      listPanel.add(sp);

      // Initially display an empty list.
      displayList.setListData(list.toStringArray());
		
		// Create an instance of the action listener.
		ActionListener buttonListener = new ButtonListener();
      
      // Register the action listener with each button in
      // the button array.
      for (int count = 0; count < buttonArray.length; count++)
         buttonArray[count].addActionListener(buttonListener);
      
      // Create a panel to hold the buttons.
      JPanel buttonPanel = new JPanel();
      
      // Add the buttons in the button array to the panel.
      for (int count = 0; count < buttonArray.length; count++)
         buttonPanel.add(buttonArray[count]);
      
      // Add the list panel to this JFrame.
      add(listPanel);
      
      // Add the button panel to this JFrame.
      add(buttonPanel);
      
      // Set the size of the JFrame.
      setSize(WIDTH, HEIGHT);
      
      // Make the JFrame visible.
      setVisible(true);
   }
   
   /** ActionListener
   */
	
   private class ButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         try
         {
            // Clear button
            if (e.getActionCommand().equals("Clear"))
            {
               // Clear the list.
               list.clear();
               // Update the JList.
               displayList.setListData(list.toStringArray());
            }
            
            // Size button
            else if (e.getActionCommand().equals("Size"))
            {
               JOptionPane.showMessageDialog(null,
                    "The list has " + list.size() + " elements.");
            }
            
            // Get button
            else if (e.getActionCommand().equals("Get..."))
            {
               // Get an index.
               String str = JOptionPane.showInputDialog(
                                              "Enter an index.");
               int index = Integer.parseInt(str);
               // Display the element at that index.
               JOptionPane.showMessageDialog(null, list.get(index));
            }
            
            // Add button
            else if (e.getActionCommand().equals("Add..."))
            {
               // Get the VIN.
               String vin = JOptionPane.showInputDialog(
                                     "Enter the VIN.");
               // Get the description.
               String desc = JOptionPane.showInputDialog(
                                  "Enter the description.");
					// Create a Car object.
					Car c = new Car(vin, desc);
               // Add the Car to the list.
               list.add(c);
               // Update the JList.
               displayList.setListData(list.toStringArray());
            }
            
            // Add At button
            else if (e.getActionCommand().equals("Add At..."))
            {
               // Get an index.
               String str = JOptionPane.showInputDialog(
                                       "Enter an index.");
               int index = Integer.parseInt(str);
               // Get the VIN.
               String vin = JOptionPane.showInputDialog(
                                     "Enter the VIN.");
               // Get the description.
               String desc = JOptionPane.showInputDialog(
                                  "Enter the description.");
					// Create a Car object.
					Car c = new Car(vin, desc);
               // Add the Car to the list at the specified index.
               list.add(index, c);
               // Update the JList.
               displayList.setListData(list.toStringArray());
            }
            
            // Remove button
            else if (e.getActionCommand().equals("Remove..."))
            {
               // Get the VIN.
               String vin = JOptionPane.showInputDialog(
                                     "Enter the VIN.");
               // Get the description.
               String desc = JOptionPane.showInputDialog(
                                  "Enter the description.");
					// Create a Car object.
					Car c = new Car(vin, desc);
               // If the Car was removed, update the JList.
               if (list.remove(c))
                  displayList.setListData(list.toStringArray());
               else
                  JOptionPane.showMessageDialog(null, "Not found");
            }
            
            // Remove From button
            else if (e.getActionCommand().equals("Remove From..."))
            {
               // Get an index.
               String str = JOptionPane.showInputDialog(
                                       "Enter an index.");
               int index = Integer.parseInt(str);
               
               // Remove the element at that index.
               list.remove(index);
               // Update the JList.
               displayList.setListData(list.toStringArray());
            }
            
            // Search button
            else if (e.getActionCommand().equals("Search..."))
            {
               // Get the VIN to search for.
               String vin = JOptionPane.showInputDialog(
                                     "Enter the VIN to search for.");
               // Get the description to search for.
               String desc = JOptionPane.showInputDialog(
                                  "Enter the description to search for.");
					// Create a Car object.
					Car c = new Car(vin, desc);
               // If the Car is found, display its index.
               if (list.contains(c))
               {
                  JOptionPane.showMessageDialog(null,  
                           "That car was found at index " + 
									list.indexOf(c));
               }
               else
                  JOptionPane.showMessageDialog(null, "Not found");
            }
            
            // Set button
            else if (e.getActionCommand().equals("Set..."))
            {
               // Get an index.
               String str = JOptionPane.showInputDialog(
                                       "Enter an index.");
               int index = Integer.parseInt(str);
               // Get the VIN.
               String vin = JOptionPane.showInputDialog(
                                     "Enter the new VIN.");
               // Get the description.
               String desc = JOptionPane.showInputDialog(
                                  "Enter the new description.");
					// Create a Car object.
					Car c = new Car(vin, desc);
               // Store the Car in the element at the index.
               list.set(index, c);
               // Update the JList.
               displayList.setListData(list.toStringArray());
            }
         }
         
         // Handle an invalid index.
         catch(IndexOutOfBoundsException ex)
         {
            JOptionPane.showMessageDialog(null, 
                                "That is an invalid index.");
         }
      }
   }
   
   /** Instantiate the class and start the application.
   */
	
   public static void main(String[] args)
   {
      new GenericListGUI();
   }
}