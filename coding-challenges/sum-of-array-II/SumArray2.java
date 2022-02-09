import java.util.Scanner;
public class SumArray2{
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in); 
        System.out.println("Enter Array Length");
        int n = myObj.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            System.out.println("EnterValue" + (i+1));
            a[i] = myObj.nextInt();
        }
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