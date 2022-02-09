public class SumOfArray{
	public static void main(String[] args) {
	
	int sum = 0;
	int[] array = {1, 2, 3, 4, 5};
	int i;

	for (i=0; i < array.length; i++) {
		sum += array[i];
	}
	
	System.out.println(sum);	

	}
}