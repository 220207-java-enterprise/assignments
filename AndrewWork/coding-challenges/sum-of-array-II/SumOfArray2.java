import java.util.Scanner;

public class SumOfArray2 {
	public static void main(String[] args){
		System.out.println("Enter how many in the array?");
		Scanner arrayAmt = new Scanner(System.in);
		int myArr[]; 
		int solution = 0;
		int temp = arrayAmt.nextInt();
		myArr = new int[temp];
		for (int i = 0; i < myArr.length; i++){
			System.out.println("Enter the "+i+ " value of the array");
			Scanner arrayVal = new Scanner(System.in);
			temp = arrayVal.nextInt();
			myArr[i] = temp; 
			solution += myArr[i];
			if (i == myArr.length-1){
				System.out.println("The sum of the array is: "+solution);
			}	
			
			
		}
	}

}