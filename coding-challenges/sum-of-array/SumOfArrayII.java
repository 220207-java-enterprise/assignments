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
	}
}