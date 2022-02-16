public class SumOfArray
{
    public static int[] array = {1, 2, 3, 4, 5};

    public static void addValues()
    {
        int sum = 0;
        for(int i = 0; i < array.length; i++)
        {
            sum += array[i];
        }
        System.out.println("Sum of arry = " + sum);
    }

    public static void main(String[] args)
    {
        addValues();
    }
}