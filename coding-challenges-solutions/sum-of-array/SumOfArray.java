<<<<<<< HEAD:coding-challenges/sum-of-array/SumOfArray.java
class SumOfArray{
    
    public static void main(String[] args){
        
	int [] nums = {1, 2, 3, 4, 5};
	int sum = 0;
	
	for (int num : nums){
	    sum += num;
=======
public class SumOfArray {
	public static void main(String[] args) {
		int sum = 0;
		int[] arr = {1, 2, 3, 4 ,5};
		char[] cArr = {'a', 'b', 'c'};
		
		for (int num : arr) {
			sum = sum + num;	
		}
		
		System.out.println(sum);
>>>>>>> 9e2abe6db0c9ccf8ae3cf9eb34f2cfae43b6dd31:coding-challenges-solutions/sum-of-array/SumOfArray.java
	}
	System.out.println("Sum: " + sum);
    }
}
