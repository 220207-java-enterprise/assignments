/**********************************

Day 2 Assignment, Problem 1
Author:  Naomi Makovkin

**********************************/

public class SumOfArray{
  public static void main(String arg[]){

    int array [] = {1,2,3,4,5};
    int count=0;
    for(int i=0; i<5; i++){
    	count += array[i];
    }
    System.out.println("Sum of Array is: " + count);

  }
}