<<<<<<< HEAD
public class SumOfArray{
	public static void main(String[] args) {
	
	int sum = 0;
	int[] array = {1, 2, 3, 4, 5};
	int i;

	for (i=0; i < array.length; i++) {
		sum += array[i];
	}
	
	System.out.println(sum);	

=======
public class SumOfArray {
	public static void main(String[] args) {
		int sum = 0;
		int[] arr = { 1, 2, 3, 4, 5};
		
		for (int n : arr) {
			sum += n;
		}
		
		System.out.println(sum);
>>>>>>> 6812d90cb163251ff5c668a63d2f5907aa7dbe35
	}
}