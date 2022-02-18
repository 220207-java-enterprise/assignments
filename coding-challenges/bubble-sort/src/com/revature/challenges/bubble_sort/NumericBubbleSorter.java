//package com.revature.challenges.bubble_sort;

public class NumericBubbleSorter implements Sorter<Integer> {

    /**
     * Sorts the provided collection of Integers from smallest to largest using the bubble
     * sort algorithm.
     *
     * This method is considered to be impure, as it will modify the provided array directly.
     *
     * @param collection the array to be sorted
     * @throws IllegalArgumentException if a null array is provided
     */
    @Override
    public void sort(Integer[] collection) throws IllegalArgumentException {
        // Here goes
        int temp;

        for (int i = 0; i < collection.length; i++) {
            for (int j = 0; j < collection.length-1; j++) {
                if (collection[j] > collection[j+1]) {
                    temp = collection[j];
                    collection[j] = collection[j+1];
                    collection[j+1] = temp;
                }
            }
        }
    }

}
