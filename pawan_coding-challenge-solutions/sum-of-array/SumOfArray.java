public class SumOfArray {
    public static void main(String[] args){

        int [] nums = {1, 2, 3, 4, 5};
        int sum = 0;

        for (int i = 0; i < nums.length; i++)
            sum += nums[i];
        System.out.println("Sum: " + sum);
    }
}
