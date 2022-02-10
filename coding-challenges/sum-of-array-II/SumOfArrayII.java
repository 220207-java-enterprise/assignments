<<<<<<< HEAD
/*
1. create the class SumOfArrayII
2. Get user input for array size
3. Let the user enter in their own values
4. print out the sum of the array
*/
import java.util.Scanner;

public class SumOfArrayII{

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter an array size: " );
        int sizeOfArray = userInput.nextInt();
        int sum = 0;
        while(sizeOfArray>0){
            sum += userInput.nextDouble();
            sizeOfArray--;
        }
        System.out.println(sum);
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
>>>>>>> fb6705ceffc2ed69d551887e43a589916e306a18
}