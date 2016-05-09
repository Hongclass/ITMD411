import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

/**
 * The AWTTempConverter class is an applet that converts
 * Fahrenheit temperatures to centigrade.
 */

public class AWTTempConverter extends Applet
{
   private Panel fPanel;         // Fahrenheit panel
   private Panel cPanel;         // Centigrade panel
   private Panel buttonPanel;    // Button panel
   private TextField fahrenheit; // Fahrenheit temperature
   private TextField centigrade; // Centigrade temperature

   /**
    * init method
    */
   
   public void init()
   {
      // Build the panels.
      buildFpanel();
      buildCpanel();
      buildButtonPanel();
      
      // Create a layout manager.
      setLayout(new GridLayout(3, 1));

      // Add the panels to the applet.
      add(fPanel);
      add(cPanel);
      add(buttonPanel);
   }
   
   /**
    * The buildFpanel method creates a panel with a text
    * field in which the user can enter a Fahrenheit
    * temperature.
    */
   
   private void buildFpanel()
   {
      // Create a panel to hold other components.
      fPanel = new Panel();
      
      // Create a label for instructions.
      Label message1 = new Label("Fahrenheit Temperature: ");
      
      // Create a text field for the Fahrenheit temperature.
      fahrenheit = new TextField(10);
      
      // Create a layout manager for the panel.
      fPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
      
      // Add the label and text field to the panel.
      fPanel.add(message1);
      fPanel.add(fahrenheit);

   }
   
   /**
    * The buildCpanel method creates a panel that
    * displays the centigrade temperature in a read-only
    * text field.
    */
   
   private void buildCpanel()
   {
      // Create a panel to hold other components.
      cPanel = new Panel();
      
      // Create a label for instructions.
      Label message2 = new Label("Centigrade Temperature: ");
      
      // Create a text field for the centigrade temperature.
      centigrade = new TextField(10);
      
      // Make the text field read-only.
      centigrade.setEditable(false);
      
      // Create a layout manager for the panel.
      cPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
      
      // Add the label and text field to the panel.
      cPanel.add(message2);
      cPanel.add(centigrade);

   }

   /**
    * The buildButtonPanel method creates a panel with
    * a button that converts the Fahrenheit temperature
    * to centigrade.
    */
   
   private void buildButtonPanel()
   {
      // Create a panel to hold the button.
      buttonPanel = new Panel();
      
      // Create a button.
      Button convButton = new Button("Convert");
      
      // Register an actionlistener.
      convButton.addActionListener(new ButtonListener());
      
      // Add the button to the panel.
      buttonPanel.add(convButton);
   }

   /**
    * The private inner class handles the action event
    * that is generated when the user clicks the Convert
    * button.
    */
   
   private class ButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         double ftemp;  // Fahrenheit temperature
         double ctemp;  // Centigrade temperature
         
         // Create a DecimalFormat object for formatting.
         DecimalFormat formatter = new DecimalFormat("0.0");
         
         // Get the temperature entered by the user.
         ftemp = Double.parseDouble(fahrenheit.getText());
         
         // Convert the temperature to centigrade.
         ctemp = (5.0 / 9.0) * (ftemp - 32);
         
         // Display the centigrade temperature in the
         // read-only text field.
         centigrade.setText(formatter.format(ctemp));
      }
   }
}