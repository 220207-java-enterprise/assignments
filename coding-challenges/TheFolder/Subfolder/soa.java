package Subfolder;
// # Problem: Sum of Array

// **Tasks:**
// 1. Create the class **SumOfArray**
// 2. Create an **array** of **integers [1, 2, 3, 4, 5]**
// int[] thisArray = new int[]{1, 2, 3, 4, 5};
// 3. Print out the sum of the array
// sys.path.append(".")
// from los import los

public class soa {
    public static int sum;
    void myMethod() {
        // public int[] thisArray = {1, 2, 3, 4, 5};
        int[] thisArray = new int[]{1, 2, 3, 4, 5};
    for (int var : thisArray) {
        sum = sum + var;
    }
    System.out.println(sum);
    }
    

}
