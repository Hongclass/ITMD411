/*
    File:   StillFan.java
	Author: Hong Zhang
    Date:   05/05/2014
    Description:
    This program draws a still fan.  
*/

import javax.swing.*;
import java.awt.*;

// The class for drawing a fan on a panel
public class StillFan extends JPanel {
	// data fields
	private int xCenter, yCenter;
	private int fanRadius, bladeLength;
	private int angle = 100;
	private int direction = 1;
    private Color color = Color.BLACK;
	
    // Draw the fan
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    
        // Initialize fan parameters
        fanRadius = (int)(Math.min(getSize().width, getSize().height)*0.9*0.5);
  	    xCenter = (getSize().width)/2;
  	    yCenter = (getSize().height)/2;
  	    bladeLength = (int)(fanRadius*0.9);
  	    angle = (angle+direction)%360;
        g.setColor(color);

        // Draw a circle
        g.drawOval(xCenter - fanRadius,yCenter - fanRadius,
        	    2*fanRadius, 2*fanRadius);
    
        // Draw four blazes of a fan
        drawBlade(g, angle);
  	    drawBlade(g, angle+90);
  	    drawBlade(g, angle+180);
  	    drawBlade(g, angle+270);
     } 
    
        // method to draw a blaze	 
        private void drawBlade(Graphics g, int angle) {
  	        g.fillArc(xCenter-bladeLength, yCenter-bladeLength,
  	                   2*bladeLength, 2*bladeLength, angle, 30);
  	    } 
        
        // mutator method for color
	    public void setColor(Color color) {
		    this.color = color;
			repaint();
		}
	    
	    
	    // accessor method for color
		public Color getColor() {
		    return this.color;
		}
 
} // end of class StillFan
