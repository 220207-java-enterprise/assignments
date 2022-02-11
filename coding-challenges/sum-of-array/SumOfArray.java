import java.util.Arrays;

public class SumOfArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};

        int sum = 0;

        for (int i : arr) {
           sum += i;
        }

        System.out.println(sum);
    }
}
