/*
1. create the class SumOfArrayII
2. Get user input for array size
3. Let the user enter in their own values
4. print out the sum of the array
*/
import java.util.Scanner;

public class SumOfArrayII{

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter an array size: " );
        int sizeOfArray = userInput.nextInt();
        int sum = 0;
        while(sizeOfArray>0){
            sum += userInput.nextDouble();
            sizeOfArray--;
        }
        System.out.println(sum);
    }

}