import java.util.Scanner;
import java.util.Arrays;

public class SumOfArrayII{
	public static void main(String[] args) {
		Scanner arraySizeInput = new Scanner(System.in);
		System.out.println("Enter Array Size:");
		
		int arraySize = arraySizeInput.nextInt();
		int[] theArray = new int[arraySize];
		int i;
		for(i = 0; i < theArray.length; i++){
			Scanner arrayIndexInput = new Scanner(System.in);
			System.out.println("Enter the " + i + "th integer into the array.");
			theArray[i] = arrayIndexInput.nextInt();
		}
		
		System.out.println("Your array is " + Arrays.toString(theArray));
	}
}