/*
1. Create the class **SumOfArray**
2. Create an **array** of **integers [1, 2, 3, 4, 5]**
3. Print out the sum of the array
*/

public class SumOfArray {
<<<<<<< HEAD:coding-challenges/sum-of-array/SumOfArray.java

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += array[i];
        }
        System.out.println(sum);
    }

=======
	public static void main(String[] args) {
		int sum = 0;
		int[] arr = {1, 2, 3, 4 ,5};
		char[] cArr = {'a', 'b', 'c'};
		
		for (int num : arr) {
			sum = sum + num;	
		}
		
		System.out.println(sum);
	}
>>>>>>> 9e2abe6db0c9ccf8ae3cf9eb34f2cfae43b6dd31:coding-challenges-solutions/sum-of-array/SumOfArray.java
}