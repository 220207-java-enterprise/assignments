
import java.util.Scanner;

public class SumOfArrayII {
	public static void main(String[] args) {

	int lengthOfArray;
	Scanner scanner = new Scanner(System.in);
	System.out.println("Enter the length of your array: ");
	
	lengthOfArray = scanner.nextInt();

	int[] userArray = new int[lengthOfArray];

	System.out.println("Enter the elements of the array: ");
	
	for (int i=0; i < lengthOfArray; i++) {
		userArray[i] = scanner.nextInt();
	}
	
	int sum = 0;
	for (int i=0; i < userArray.length; i++) {
		sum += userArray[i];
	}
	
	System.out.println("The sum of your array is: "+sum);
	
	}
}
