<<<<<<< HEAD
import java.util.Scanner;

class SumOfArrayII {
	public static void main(String[] args) {
		Scanner myObj = new Scanner(System.in);
                System.out.print("Enter an array size:");

                //Read it here.
                String input = myObj.nextLine();

		int parsedInput = Integer.parseInt(input);
		
		int[] arr = new int[parsedInput];
		int total = 0;

		for(int i = 0; i < parsedInput; i++) {
			System.out.print("add a number to the array" + "(" + i + "/" + parsedInput + "):");
			String arrInput = myObj.nextLine();
			arr[i] = Integer.parseInt(arrInput);
			total += arr[i];
		}
		
		System.out.println("Total: " + total);
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
>>>>>>> fb6705ceffc2ed69d551887e43a589916e306a18
	}
}