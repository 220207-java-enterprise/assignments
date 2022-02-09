public class SumOfArray {
	public static void main(String[] args) {
		int sum = 0;
		int[] arr = { 1, 2, 3, 4, 5};
		
		for (int n : arr) {
			sum += n;
		}
		
		System.out.println(sum);
	}
}