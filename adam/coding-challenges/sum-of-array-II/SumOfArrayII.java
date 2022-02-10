<<<<<<< HEAD
import java.util.Scanner;

public class SumOfArrayII{

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int i, counter = 0;

		System.out.print("Enter array size: ");
		int arraysize = scan.nextInt();
		int [] input = new int[arraysize];


		for(i = 0; i < arraysize; i++){
			System.out.print("Enter array value" + (i + 1) + ": ");
			input[i] = scan.nextInt();
			counter = counter + input[i];
		}

		System.out.println("\nTotal is: " + counter);
		
=======
import java.util.*;

public class SumOfArrayII {
	public static void main(String[] args) {
		int size = 0;
		int input = 0;
		int sum = 0;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please specify the size of the array");
		size = scan.nextInt();
		int[] arr = new int[size];
		
		System.out.println("Populate the array");
		for (int i = 0; i < size; i++) {
			input = scan.nextInt();
			arr[i] = input;
		}
		
		for (int n : arr) {
			sum += n;
		}
		
		System.out.println("Sum: " + sum);
>>>>>>> 49a0bbc90936d11e66da00e28aa8d28f7bda7a57
	}
}