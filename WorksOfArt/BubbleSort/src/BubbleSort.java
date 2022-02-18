


public class BubbleSort {
    public static void main(String[] args) {
        Integer[] target = {9, 8, 7, 6, 5, 4, 3, 2, 1};

        NumericBubbleSorter nbs = new NumericBubbleSorter();
        nbs.newBubbleSort(target);
        for (int i = 0; i < target.length ; i++)
            System.out.print(target[i] + " ");
    }
}
