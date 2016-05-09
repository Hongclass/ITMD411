import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/** This GUI application demonstrates the operations of the
    StringListType class.
*/

public class StringListGUI extends JFrame
{
   // Constants for the JFrame width and height
   private final int WIDTH = 275;
   private final int HEIGHT = 290;
   
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
   
   // A StringListType object
   private StringListType list = new StringListType();
   
   /** Constructor
   */
   
   public StringListGUI()
   {
      // Display the title.
      setTitle("String List Demo");
      
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
      
      // Create an instance of the action listener class.
      ActionListener buttonListener = new ButtonListener();
      
      // Register the action listener for each button in
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
               // Get a string to add to the list.
               String str = JOptionPane.showInputDialog(
                                     "Enter the string to add.");
               // Add the string to the list.
               list.add(str);
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
               // Get a string to add to the list.
               str = JOptionPane.showInputDialog(
                              "Enter the string to add.");
               // Add the string at the specified index.
               list.add(index, str);
               // Update the JList.
               displayList.setListData(list.toStringArray());
            }
            
            // Remove button
            else if (e.getActionCommand().equals("Remove..."))
            {
               // Get the string to remove.
               String str = JOptionPane.showInputDialog(
                              "Enter the string to remove.");
               // If the string was removed, update the JList.
               if (list.remove(str))
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
               // Get a string to search for.
               String str = JOptionPane.showInputDialog(
                              "Enter the string to search for.");
               // If the string is found, display its index.
               if (list.contains(str))
               {
                  JOptionPane.showMessageDialog(null, str + 
                       " was found at index " + list.indexOf(str));
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
               // Get a string.
               str = JOptionPane.showInputDialog(
                              "Enter the string to set.");
               // Store the string in the element at the index.
               list.set(index, str);
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
      new StringListGUI();
   }
}