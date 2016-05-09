/**
 * This program demonstrates how to access the file system on the user's machine
 *
 */
import java.io.*;
import java.util.*;
public class FileSystem
{
   public static void main(String [] args)
   {
      // Get list of root directories  of the file system and print
      File [] roots  = File.listRoots();
      System.out.println(Arrays.asList(roots));

      // List file objects in each root directory
      for (File f : roots)
      {
          System.out.print(f.getName() + ": ");
          if (f.isDirectory())
              System.out.println(Arrays.asList(f.list()));
          else
              System.out.println();
      }
   }
}
