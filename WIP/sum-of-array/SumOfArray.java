public class SumOfArray{

	public static void main(String[] args) {
		int [] array = new int[]{1, 2, 3, 4, 5};
		int counter = 0;
		int i;

		for( i = 0; i < array.length; i++){
			counter = counter + array[i];
		}

		System.out.println("\nTotal is: " + counter);
		
	}
}