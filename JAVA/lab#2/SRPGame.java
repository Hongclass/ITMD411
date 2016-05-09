/*  
   Name:   Hong Zhang
   File:   SRPGame.java
   Date:   02/10/3014
   Class:  CIS2571-001
   Descr:
   This program uses random number simulation 
   to create a scissor-rock-paper game.
*/

import java.util.Scanner;
import java.util.Random;

public class SRPGame {
    public static void main (String[] args) {

        System.out.println("\nLet's play Rock Paper Scissors!");

        Scanner input = new Scanner(System.in);
       
        System.out.print("\nScissor (0), rock (1), paper (2): ");
        int guess = input.nextInt();
        
        while (guess >= 0 && guess <= 2) {
             
             int rnum = (int) (Math.random() * 3);

             String result = "";
            
             if(guess == rnum)
                result = "It is a draw!";
             else if(((guess + 1 <= 2)? guess + 1: 0) == rnum)
                result = "The computer won";
             else
                result = "You won";
             
             String guessName = "";
        
             switch(guess) {
                 case 0: guessName = "Scissors"; break;
                 case 1: guessName = "Rock"; break;
                 case 2: guessName = "Paper"; break;
             }
             
             String rnumName = "";
        
             switch(rnum) {
                 case 0: rnumName = "Scissors"; break;
                 case 1: rnumName = "Rock"; break;
                 case 2: rnumName = "Paper"; break;
             }
             
             System.out.println("The computer is " + rnumName + 
                                ". You are " + guessName + ". "
                                + result);
         
             System.out.print("\nScissor (0), rock (1), paper (2): ");
             guess = input.nextInt();

          } 

          System.out.println(
                "\nYou don't want to play? Come back soon!");

        }
    }
    
   
/* Sample Output:
E:\JAVA>javac SRPGame.java

E:\JAVA>java SRPGame

Let's play Rock Paper Scissors!

Scissor (0), rock (1), paper (2): 0
The computer is Paper. You are Scissors. You won

Scissor (0), rock (1), paper (2): 1
The computer is Paper. You are Rock. The computer won

Scissor (0), rock (1), paper (2): 2
The computer is Paper. You are Paper. It is a draw!

Scissor (0), rock (1), paper (2): 3

You don't want to play? Come back soon!

E:\JAVA>
*/
