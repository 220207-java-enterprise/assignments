import java.util.Scanner;

public class SumOfArray2
{
    public static int[] array2;

    public static void getArraySize()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How much space should be in the array?");
        int arraySize = scanner.nextInt();

        array2 = new int[arraySize];
        System.out.println(arraySize);
    }

    public static void fillArray()
    {
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < array2.length; i++)
        {
            System.out.println("Enter a number to put into the array: ");
            array2[i] = scanner.nextInt();
        }
    }
    public static void addValues()
    {
        int sum = 0;
        for(int i = 0; i < array2.length; i++)
        {
            sum += array2[i];
        }
        System.out.println("Sum of array = " + sum);
    }

    public static void main(String[] args)
    {
        getArraySize();
        fillArray();
        addValues();
    }
}