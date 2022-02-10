/*
1. Create the class **SumOfArray**
2. Create an **array** of **integers [1, 2, 3, 4, 5]**
3. Print out the sum of the array
*/

public class SumOfArray {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += array[i];
        }
        System.out.println(sum);
    }

}