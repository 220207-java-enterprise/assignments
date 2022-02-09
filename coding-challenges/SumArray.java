public class SumArray{
    public static void main(String[] args) {
        int[] a = new int[]{ 1,2,3,4,5};
        System.out.println(ArraySum(a));

    }
    public static int ArraySum(int[] a){
        int c = 0;
        for (int i = 0; i < a.length; i++) {
            c += a[i];
        }
        return c;


    }
        
}