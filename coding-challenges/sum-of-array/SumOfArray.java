import java.util.Scanner;

public class SumOfArray{
	public static void main(String[] args){
		int integerArray[] = {1, 2, 3, 4, 5};
		
		int sum = 0;
		int i;
		for (i = 0; i < integerArray.length; i++) {
			sum = sum + integerArray[i];
		}
		System.out.println("The sum of 1, 2, 3, 4, and 5 is " + sum + ".");
	}
}
