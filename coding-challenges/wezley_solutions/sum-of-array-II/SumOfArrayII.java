import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SumOfArrayII {

    private static int[] array;

    public static void main(String[] args) throws IOException {

        try {

            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Please specify how many values you would like for your array to hold: ");
            String size = consoleReader.readLine();
            array = new int[Integer.parseInt(size)];

            System.out.println("Array initialized, moving to array population...");
            int sum = 0;
            for (int i = 0; i < array.length; i++) {
                System.out.print("Please provide a numeric value to go into the array: ");
                int nextInt = Integer.parseInt(consoleReader.readLine());
                array[i] = nextInt;
                sum += nextInt;
            }

            System.out.println("Populated array: " + Arrays.toString(array));
            System.out.println("Sum of values: " + sum);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("You provided an non-numeric value. Exiting application");
        }

    }
}
