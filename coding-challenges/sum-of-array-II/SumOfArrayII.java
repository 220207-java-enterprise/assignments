import java.util.Scanner;

public class SumOfArrayII {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the length of your array \n" +
                         "> ");

        int arrSize = scan.nextInt();
        int[] userArr = new int[arrSize];
        int sum = 0;

        System.out.print("Enter the values of your array \n" +
                         "> ");

        for (int i = 0; i < userArr.length; i++) {
            int userInput = scan.nextInt();
            userArr[i] = userInput;

            sum += userArr[i];
        }

        System.out.println(sum);
    }
}
