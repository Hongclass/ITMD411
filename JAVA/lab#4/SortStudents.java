/* 
    File:   SortStudents.java
	Author: Hong Zhang
    Date:   02/24/2014
    Description:
    This program prompts the user to enter the number of students, 
    and student names and their scores, and prints the student names 
	in decreasing order of their scores.
*/

import java.util.Scanner;

class SortStudents{
    public static void main(String[] args){
	
        System.out.print("Please enter the number of students: ");
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
		System.out.print("\n");
	
        double[] studentScore=new double[number];
        String[] studentName=new String[number];
	
        for(int i = 0; i < number; i++){
            System.out.print("Please enter the name of student NO." + (i+1) + ": ");
            studentName[i]= scan.next();
            System.out.print("Please enter the score of student NO." + (i+1) + ": ");
            studentScore[i]=scan.nextDouble();
			System.out.print("\n");
        }
	
        insertionSort(studentScore, studentName, number);
		
        System.out.println("Student names with their scores which are in decreasing order: ");
        print(studentName, studentScore, number);
        }
	
    public static void insertionSort(double[] score,String[] name, int index){
        double current;
        String currentName = " ";
		
        for(int i = 1; i < index; i++){
            current = score[i];
            currentName = name[i];
            int j;
            for(j = i - 1; j >= 0 && current > score[j]; j--){
                score[j + 1] = score[j];
                name[j + 1] = name[j];
            }
            score[j + 1] = current;
            name[j + 1] = currentName;
        }  
    }
  
    public static void print(String[] name, double[] score, int index){
        for(int i = 0; i < index; i++){
        System.out.printf(name[i] + ":   ");
		System.out.println(score[i]);
        }
    }	
}

/*Sample Output:
Please enter the number of students: 8

Please enter the name of student NO.1: Angel
Please enter the score of student NO.1: 69

Please enter the name of student NO.2: Bill
Please enter the score of student NO.2: 82

Please enter the name of student NO.3: Cindy
Please enter the score of student NO.3: 88

Please enter the name of student NO.4: Hong
Please enter the score of student NO.4: 99

Please enter the name of student NO.5: Nancy
Please enter the score of student NO.5: 79

Please enter the name of student NO.6: Jack
Please enter the score of student NO.6: 75

Please enter the name of student NO.7: Linda
Please enter the score of student NO.7: 93

Please enter the name of student NO.8: Max
Please enter the score of student NO.8: 80

Student names with their scores which are in decreasing order: 
Hong:   99.0
Linda:   93.0
Cindy:   88.0
Bill:   82.0
Max:   80.0
Nancy:   79.0
Jack:   75.0
Angel:   69.0
*/
