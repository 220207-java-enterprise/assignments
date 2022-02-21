<<<<<<< HEAD


public class SumOfArray {
	public static void main(String[] args){
		int[] myArr = {1,2,3,4,5};
		int solution;
		for (int i = 0; i<myArr.length; i++){
			solution = myArr[i]+myArr[i++];
			if (i == myArr.length){
				System.out.println(solution);	
			}
			
		}
		
		
	}

=======
public class SumOfArray {
	public static void main(String[] args) {
		int sum = 0;
		int[] arr = {1, 2, 3, 4 ,5};
		char[] cArr = {'a', 'b', 'c'};
		
		for (int num : arr) {
			sum = sum + num;	
		}
		
		System.out.println(sum);
	}
>>>>>>> main
}