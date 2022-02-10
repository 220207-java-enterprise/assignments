class SumOfArray{
    
    public static void main(String[] args){
        
	int [] nums = {1, 2, 3, 4, 5};
	int sum = 0;
	
	for (int num : nums){
	    sum += num;
	}
	System.out.println("Sum: " + sum);
    }
}
