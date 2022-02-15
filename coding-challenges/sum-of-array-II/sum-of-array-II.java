import java.util.Scanner;
import java.util.Arrays;

class SumOfArrayII {

	public static void main (String [] args){
		System.out.println("How many numbers would you like to add? ");
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int userArray[] = new int [size];
	
		System.out.println("Enter the " + size + " numbers you would like to add and hit enter after each submission: ");
		
		for (int i = 0; i < size; i++) {
			userArray[i] = sc.nextInt();
		}
		System.out.println("Numbers submitted: " + Arrays.toString(userArray));
		
		int sum = 0;
		for (int num : userArray) {
			sum = sum + num;
		}
		System.out.println("The sum of your array is: " + sum);
	}
}
		
