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
}