import java.util.Scanner;

class SumOfArrayII{
    public static void main(String[] args){

    Scanner n = new Scanner(System.in);
		
    final int SIZE; 
    int sum = 0;
    
    System.out.print("Enter size: ");
    SIZE = n.nextInt();
		
    int [] nums = new int[SIZE];

    for (int i = 0; i < nums.length; i++){
	
	System.out.print("Enter " + (i +1) + "(th) number: ");
	
	nums[i] = n.nextInt();
	sum += nums[i];
    }
    System.out.println("Sum: " + sum);
    }
}
