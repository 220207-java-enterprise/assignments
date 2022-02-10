<<<<<<< HEAD
public class SumOfArray{

	public static void main(String[] args) {
		int [] array = new int[]{1, 2, 3, 4, 5};
		int counter = 0;
		int i;

		for( i = 0; i < array.length; i++){
			counter = counter + array[i];
		}

		System.out.println("\nTotal is: " + counter);
		
=======
public class SumOfArray {
	public static void main(String[] args) {
		int sum = 0;
		int[] arr = { 1, 2, 3, 4, 5};
		
		for (int n : arr) {
			sum += n;
		}
		
		System.out.println(sum);
>>>>>>> 49a0bbc90936d11e66da00e28aa8d28f7bda7a57
	}
}