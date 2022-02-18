package com.revature.challenges.bubble_sort;

import java.util.Arrays;

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
        // TODO your implementation

        if (collection == null) {
            throw new IllegalArgumentException();
        }

        int placeholder = 0;

        for (int i = 0; i < collection.length; i++) {
            for (int j = 0; j < collection.length; j++) {
                if (collection[i] < collection[j]) {
                    placeholder = collection[i];
                    collection[i] = collection[j];
                    collection[j] = placeholder;
                }
            }
        }

        System.out.println(Arrays.toString(collection));
    }
}
