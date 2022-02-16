package com.revature.challenges.bubble_sort;
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
        if (collection == null)
            throw new IllegalArgumentException();
        // if bigger number from 2 elements
        int temp = 0;
        for (int i = 0; i < collection.length; i++) {
            for (int j = i; j < collection.length; j++) {
                if (collection[i] > collection[j]) {
                    temp = collection[i];
                    collection[i] = collection[j];
                    collection[j] = temp;

                }
            }

        }
    }
    }
