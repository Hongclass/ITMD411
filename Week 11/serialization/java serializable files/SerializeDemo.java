import java.io.*;

public class SerializeDemo
{
   public static void main(String [] args)
   {
      Employee e = new Employee();
      e.name = "James Papdemas";
      e.address = "2130 n Western";
      e.SSN = 11122333;
      e.number = 100;
      try
      {
         FileOutputStream fileOut =
         new FileOutputStream("employee.ser");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(e);
         out.close();
         fileOut.close();
         System.out.printf("Serialized data is saved as employee.ser");
      }catch(IOException i)
      {
          i.printStackTrace();
      }
   }
}
