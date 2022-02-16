public class SumOfArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int sum = 0;
        for (int value : arr) sum += value;
        System.out.println("The sum of values in the array {1, 2, 3, 4, 5} is: " + sum);
    }

}
