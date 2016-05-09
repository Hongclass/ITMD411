import javax.swing.*;
import java.awt.*;

public class TestPaintComponent extends JFrame {
  public TestPaintComponent() {
    add(new NewPanel());
  }

  public static void main(String[] args) {
    TestPaintComponent frame = new TestPaintComponent();
    frame.setTitle("TestPaintComponent");
    frame.setSize(400, 450);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}

class NewPanel extends JPanel {
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawLine(0, 0, 50, 50);
	// set the font
	g.setFont(new Font("Sans Serif", Font.BOLD, 16));
	// set the color
	g.setColor(Color.RED);
    g.drawString("Banner", 0, 40);
	// draw a rectangle
	g.setColor(Color.BLUE);
	g.drawRect(10, 10, 10, 10);
	g.fillRect(20, 20, 10, 10);
	// draw rounded rectangle
	g.setColor(Color.GREEN);
	g.drawRoundRect(30, 30, 50, 30, 5, 5);
	g.fillRoundRect(80, 60, 50, 30, 5, 5);
	// draw 3D rectangle
	g.setColor(Color.PINK);
	g.draw3DRect(130, 90, 30, 30, true);
	g.fill3DRect(160, 120, 30, 30, false);
	// draw some ovals
	g.setColor(new Color(255, 153, 152));
	g.drawOval(0, 150, 50, 30);
	g.fillOval(50, 180, 50, 30);
  }
}