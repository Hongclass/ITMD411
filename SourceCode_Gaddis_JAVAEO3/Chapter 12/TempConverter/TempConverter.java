import java.awt.*;
import javax.swing.event.*;
import javax.swing.*;
import java.text.DecimalFormat;

/**
 *  This class displays a window with a slider component. The
 *  user can convert the centigrade temperatures from 0 through
 *  100 to Fahrenheit by moving the slider.
 */

public class TempConverter extends JFrame
{
   private JTextField fahrenheitTemp; // Displays Fahrenheit
   private JTextField centigradeTemp; // Displays centigrade
   private JPanel fpanel;             // Holds Fahrenheit
   private JPanel cpanel;             // Holds centigrade
   private JPanel sliderPanel;        // Holds the slider
   private JSlider slider;            // Adjusts temperature
   
   /**
    *  Constructor
    */
   
   public TempConverter()
   {
      // Call the JFrame constructor.
      super("Temperatures");

      // Specify an action for the close button.
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      // Create the labels.
      JLabel label1 = new JLabel("Fahrenheit: ");
      JLabel label2 = new JLabel("Centigrade: ");
      
      // Create the read-only text fields.
      fahrenheitTemp = new JTextField("32.0", 10);
      fahrenheitTemp.setEditable(false);
      centigradeTemp = new JTextField("0.0", 10);
      centigradeTemp.setEditable(false);
      
      // Create the slider.
      slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
      slider.setMajorTickSpacing(20);
      slider.setMinorTickSpacing(5);
      slider.setPaintTicks(true);
      slider.setPaintLabels(true);
      slider.addChangeListener(new SliderListener());
      
      // Create panels and place the components in them.
      fpanel = new JPanel();
      fpanel.add(label1);
      fpanel.add(fahrenheitTemp);
      cpanel = new JPanel();
      cpanel.add(label2);
      cpanel.add(centigradeTemp);
      sliderPanel = new JPanel();
      sliderPanel.add(slider);
      
      // Create a layout manager for the content pane.
      setLayout(new GridLayout(3, 1));
      
      // Add the panels to the content pane.
      add(fpanel);
      add(cpanel);
      add(sliderPanel);
      
      // Pack and display the frame.
      pack();
      setVisible(true);
   }
  
   /**
    *  Private inner class to handle the change events
    *  that are generated when the slider is moved.
    */

   private class SliderListener implements ChangeListener
   {
      public void stateChanged(ChangeEvent e)
      {
         double fahrenheit, centigrade;
         DecimalFormat fmt = new DecimalFormat("0.0");
         
         centigrade = slider.getValue();
         fahrenheit = (9.0 / 5.0) * centigrade + 32.0;
         centigradeTemp.setText(Double.toString(centigrade));
         fahrenheitTemp.setText(fmt.format(fahrenheit));
      }
   }

   /**
    *  The main method creates an instance of the
    *  TempConverter class.
    */

   public static void main(String[] args)
   {
      new TempConverter();
   }
}