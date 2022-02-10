public class SumOfArray{

    public static void main(String[] args) {
        
        int[] arr = new int[]{1,2,3,4,5};
        int result=0;
        for (int i=0; i<arr.length; i++){
            result += arr[i];
        }
        System.out.println(result);
}