import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class RacingCar extends JFrame {
    public RacingCar() {
        add(new CarImage());
    }

	public static void main(String[] args) {
    JFrame frame = new RacingCar();
    frame.setTitle("Racing Car");
    frame.setSize(300, 150);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true); 
    }

    class CarImage extends JPanel {
    protected int x = 0;
    protected int y = 150;
    protected int z = 300;
    protected int c = 0;

    public CarImage() {
        Timer timer1 = new Timer(50, new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            x += 10;
            c ++;
            repaint();
        }
        });
        timer1.start();
    }

    public void paintComponent(Graphics g) {
super.paintComponent(g);
// x = 0;
y = getHeight();
z = getWidth();
g.setColor(Color.WHITE);
g.fillRect(0, 0, z, y);
Polygon polygon = new Polygon();
polygon.addPoint(x + 10, y - 21);
polygon.addPoint(x + 20, y - 31);
polygon.addPoint(x + 30, y - 31);
polygon.addPoint(x + 40, y - 21);

if (x < z - 40) {
g.setColor(Color.BLACK);
g.fillOval(x + 10, y - 11, 10, 10);
g.fillOval(x + 30, y - 11, 10, 10);
g.setColor(Color.BLUE);
g.fillRect(x, y - 21, 50, 10);
g.setColor(Color.GRAY);
g.fillPolygon(polygon);
g.setColor(Color.RED);
}
else 
x = 0;
if (c < z - 86)
g.drawString("Carl learns Java!", c, y - 51);
else
c = 0;
}

}
}