/*  
   Name:   Hong Zhang
   File:   CompCD.java
   Date:   02/10/3014
   Class:  CIS2571-001
   Descr:
   This program prompts the user to enter 
   an amount, the annual percentage yield, 
   and the number of months and displays 
   the result.
*/


import java.util.Scanner;

public class CompCD {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("Enter the initial deposit amount: ");
    double initialDeposit = input.nextDouble();

    System.out.print("Enter annual percentage yield: ");
    double annualYieldRate = input.nextDouble();

    System.out.print("Enter maturity period (number of months): ");
    int numberOfMonths = input.nextInt();

    System.out.println("Month CD Value\n");
   
    double currentValue = initialDeposit;

    for (int i = 0; i < numberOfMonths; i++) {
      currentValue = currentValue + currentValue * annualYieldRate / 1200;
      System.out.printf("%-2d", (i+1));
      System.out.printf("%16.2f\n", currentValue);
    }
  }
}

/*
Sample output:

Enter the initial deposit amount: 10000
Enter annual percentage yield: 5.75
Enter maturity period (number of months): 18


Month CD Value

1       10047.92
2       10096.06
3       10144.44
4       10193.05
5       10241.89
6       10290.97
7       10340.28
8       10389.82
9       10439.61
10      10489.63
11      10539.89
12      10590.40
13      10641.14
14      10692.13
15      10743.37
16      10794.84
17      10846.57
18      10898.54
*/