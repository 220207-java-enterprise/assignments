import java.util.Scanner;

public class SumOfArrayII{

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int i, counter = 0;

		System.out.print("Enter array size: ");
		int arraysize = scan.nextInt();
		int [] input = new int[arraysize];


		for(i = 0; i < arraysize; i++){
			System.out.print("Enter array value " + (i + 1) + ": ");
			input[i] = scan.nextInt();
			counter = counter + input[i];
		}

		System.out.println("\nTotal is: " + counter);
		
	}
}