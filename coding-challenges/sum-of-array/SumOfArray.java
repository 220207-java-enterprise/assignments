<<<<<<< HEAD
class SumOfArray {
	public static void main(String[] args){
		int[] arr = {1,2,3,4,5};
		int sum = 0;
		
		for(int i = 0; i < arr.length; i++){
			sum += arr[i];
		}
		
		System.out.println("Total: " + sum);
=======
public class SumOfArray {
	public static void main(String[] args) {
		int sum = 0;
		int[] arr = { 1, 2, 3, 4, 5};
		
		for (int n : arr) {
			sum += n;
		}
		
		System.out.println(sum);
>>>>>>> fb6705ceffc2ed69d551887e43a589916e306a18
	}
}