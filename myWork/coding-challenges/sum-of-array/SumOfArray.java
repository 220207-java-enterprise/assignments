public class SumOfArray {

	public static void main(String[] args) {
	
	int[] sumA = {1, 2, 3, 4, 5};
	int sum=0;	

	for(int i=0; i < sumA.length; i++) {
	sum+=sumA[i];	
	}
	System.out.println("Sum of the array is " + sum);	
}

}
