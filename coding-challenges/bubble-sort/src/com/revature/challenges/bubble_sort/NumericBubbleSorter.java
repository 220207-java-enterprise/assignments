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
        for (int i = 0; i < collection.length-1; i++){
            if (collection[i]>collection[i+1]){
                int tmp = collection[i+1];
                collection[i+1] = collection[i];
                collection[i] = tmp;
            }

        }
        // TODO your implementation
    }

}
