import javax.swing.JOptionPane;

public class ScopeTest {
   public static void main(String[] args) {
      double sum = 0;
      int answer;
      do {
         double val = Math.random();
         sum += val;
         answer = JOptionPane.showConfirmDialog(null, 
            "Do you want to continue?");
      } while (answer == JOptionPane.YES_OPTION);
      JOptionPane.showMessageDialog(null, "sum = " + sum);
   }
}
