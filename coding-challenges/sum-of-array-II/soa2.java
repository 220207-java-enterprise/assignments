import java.util.Scanner;

// # Problem: Sum of Array II

// **Tasks**
// 1. create the class SumOfArrayII
// 2. Get user input for array size
// 3. Let the user enter in their own values
// 4. print out the sum of the array


public class soa2 {
    public static void main(String[] args) {
        Scanner howMany = new Scanner(System.in);
        System.out.println("Type in an int to represent how large you want your array to be:  ");
        while(!howMany.hasNextInt()) {
            howMany.nextInt();
        } 
            int frhowMany = howMany.nextInt();
            int[] theirArray[] = new int[frhowMany];
            System.out.println(theirArray);
            

    }

}
