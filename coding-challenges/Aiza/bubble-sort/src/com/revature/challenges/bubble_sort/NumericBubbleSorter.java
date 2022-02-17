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
        if (collection == null){
            throw new IllegalArgumentException();
        }
        int one;
            for(int x=0; x<collection.length;x++) {
                for (int i = 0; i < collection.length-x; i++) {
                    if((i+1)<collection.length) {
                        if (collection[i] > collection[i + 1]) {
                            one = collection[i];
                            collection[i] = collection[i + 1];
                            collection[i + 1] = one;
                        }
                    }
                }
            }
            System.out.println(Arrays.toString(collection));
    }

}
