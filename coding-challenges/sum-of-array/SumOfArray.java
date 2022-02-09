//import java.util.Array;

public class SumOfArray {
	

	public static void main(String[] args) {
		int[] myArray = {1, 2, 3, 4, 5};
		int result = 0;

		for (int i = 0; i < myArray.length; i++) {
			result += myArray[i];
		}

		System.out.println("Sum is: " + result);
	}

}