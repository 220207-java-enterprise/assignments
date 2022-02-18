
public class SumOfArray{
	public static void main(String[] args) {
	
	int sum = 0;
	int[] array = {1, 2, 3, 4, 5};

	for (int i:array) {//shorthand loop(same as for (i=1; i<array.length; i++))
		sum += i;
	}
	
	System.out.println(sum);	
	}
}