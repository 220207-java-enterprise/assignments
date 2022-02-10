<<<<<<< HEAD
import java.util.Scanner;

public class SumOfArrayII {
	public static void main(String[] args) {

	int i;

	int lengthOfArray;
	Scanner scanner = new Scanner(System.in);
	System.out.println("Enter the length of your array: ");
	
	lengthOfArray = scanner.nextInt();

	int[] userArray = new int[lengthOfArray];
	System.out.println("Enter the elements of the array: ");
	for (i=0; i < lengthOfArray; i++) {
		userArray[i] = scanner.nextInt();
	}
	
	int sum = 0;
	for (i=0; i < userArray.length; i++) {
		sum += userArray[i];
	}
	
	System.out.println("The sum of your array is: "+sum);
	
	}

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
	}
>>>>>>> 6812d90cb163251ff5c668a63d2f5907aa7dbe35
}