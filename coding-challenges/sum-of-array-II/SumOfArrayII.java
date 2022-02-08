import java.util.Scanner;

public class SumOfArrayII{

    public static void main(String[] args) {
        Scanner scannerObj1 = new Scanner(System.in);
        System.out.println("How big is your array?");

        int arr_size = scannerObj1.nextInt();        

        int sum = 0;
        for(int i=1; i<arr_size+1; i++){
            Scanner scannerObj2 = new Scanner(System.in);
            System.out.println("What is your item #"+i+"?");

            int arr_item = scannerObj2.nextInt();  
            sum += arr_item;
        }

        System.out.println("The sum of your array is "+sum);
	}
}