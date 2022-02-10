package Subfolder;
import java.util.Scanner;
import java.lang.reflect.Array;

// # Problem: Sum of Array II

// **Tasks**
// 1. create the class SumOfArrayII
// 2. Get user input for array size
// 3. Let the user enter in their own values
// 4. print out the sum of the array

class secondSoa {
    void myMethod() {
        Scanner howMany = new Scanner(System.in);
            System.out.println("Type in an int to represent how large you want your array to be:  ");
            while(!howMany.hasNextInt()) {
                howMany.nextInt();
            } 
                int frhowMany = howMany.nextInt();
                int[] theirArray = new int[frhowMany];
                int count = 0;
                for (int element : theirArray) {
                    try (Scanner newVal = new Scanner(System.in)) {
                        System.out.print("What would you like in the " + count + "th spot in your array?  ");
                        while(!newVal.hasNextInt()) {
                            newVal.nextInt();
                        } 
                            int frnewVal = newVal.nextInt();
                            Array.set(theirArray, count, frnewVal);
                    }
                    System.out.println(theirArray[count]);
                    count++;
                }
                count = 0;
                int sum = 0;
                for (int element : theirArray) {
                    sum += theirArray[count];
                    count++;
                }
                System.out.println(sum);
    
        } 
    }