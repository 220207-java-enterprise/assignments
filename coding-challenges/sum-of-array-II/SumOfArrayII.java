import java.util.ArrayList;
import java.util.Scanner;

public class SumOfArrayII {
	

	public static void main(String[] args) {
		ArrayList<Integer> myArray = new ArrayList<>();
		int result = 0;
		int temp = 0;
		int number = 0;

		Scanner getInput = new Scanner(System.in);

		System.out.println("Enter integers, one after another.  Enter something that isn't a number to stop.");

		while (true) {

		try {
			temp = getInput.nextInt();
		}
		catch (Exception ex) {
			break;
		}
		finally {
			//getInput.close();
		}
			//number = Integer.parseInt(temp);
			
			myArray.add(temp);
		}


		for (int i = 0; i < myArray.size(); i++) {
			result += myArray.get(i);
		}

		System.out.println("Sum is: " + result);

		getInput.close();
	}

}