/**********************************

Day 2 Assignment, Problem 2
Author:  Naomi Makovkin

**********************************/

import java.util.Scanner;

public class SumOfArrayII{
  public static void main(String arg[]){

  	//Declare and initialize array to user inputted size
    int intArray[];
    Scanner sc= new Scanner(System.in); //System.in is a standard input stream.
	System.out.print("Enter a size and please just a normal integer because i dont have any exception handling: ");
	String input= sc.nextLine();
	int size = Integer.parseInt(input);
	intArray = new int[size];
	
	//Fill up array with user values
	int count=0;
	int num=0;
	while(count<size){
		System.out.println("Enter Numbers: ");
		input= sc.nextLine();
		num = Integer.parseInt(input);
		intArray[count]=num;
		count++;
	}

	//Sum up array
	int sum=0;
	for(int i=0; i<size; i++){
    	sum += intArray[i];
    }

    //Print sum
    System.out.println("\nSum of Array is: " + sum);
  }
}