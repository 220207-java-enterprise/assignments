import java.util.Scanner;

class SumOfArrayII{
    public static void main(String[] args){

    Scanner scan = new Scanner(System.in);
		
    final int SIZE; 
    int sum = 0;
    
    System.out.print("Enter size: ");
    SIZE = scan.nextInt();
		
    int [] nums = new int[SIZE];

    for (int i = 0; i < SIZE; i++){
	
	    System.out.print("Enter " + (i + 1) + "(th) number: ");
	
	    nums[i] = scan.nextInt();
	    sum += nums[i];
    }
    System.out.println("Sum: " + sum);
    }
}
