// # Problem: Sum of Array
package SumOfArray;
// **Tasks:**
// 1. Create the class **SumOfArray**
// 2. Create an **array** of **integers [1, 2, 3, 4, 5]**
// 3. Print out the sum of the array
// sys.path.append(".")
// from los import los

class soa {
    static int sum;
    // public static void main(String[] args) {
        int[] thisArray = {1, 2, 3, 4, 5};
        for (int var : thisArray) {
            sum = sum + var;
        }
        System.out.println(sum);
    // }
}
