import java.util.*;

public class SumOfArrayII {
	
	public static void main(String[] args) {
		int sum = 0;
		Scanner scan = new Scanner(System.in);
		
		int size = scan.nextInt();
		int userInput = 0;
		
		int[] arr = new int[size];
		
		for (int i = 0; i < size; i++) {
			userInput = scan.nextInt();
			arr[i] = userInput;
		}
		
		for (int i = 0; i < size; i++) {
			sum = sum + arr[i];
		}
		
		System.out.println(sum);
	}
}