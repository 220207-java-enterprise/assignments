import java.util.*;

public class SumOfArrayII {

	public static void main(String[] args) {
	
	Scanner ac = new Scanner(System.in);
	System.out.print("Enter the size of your array: ");
	int size = ac.nextInt();
	int sum = 0;
	int[] numA = new int[size];
	for(int i=0; i < size; i++) {
	System.out.print("Enter a number for the array: ");
	int num = ac.nextInt();
	numA[i] = num;
	sum += numA[i];
	}
	System.out.print("Sum of your array is: " + sum);
	}

}