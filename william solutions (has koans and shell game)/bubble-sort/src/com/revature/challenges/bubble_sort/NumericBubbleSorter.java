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
        if (collection == null){
            throw new IllegalArgumentException();
        }

        Integer [] toSort = collection;

        for (int i=0; i<toSort.length; i++) {
            for (int j=i; j<toSort.length; j++) {
                if (toSort[i] > toSort[j]) {
                    int temp = toSort[i];
                    toSort[i] = toSort[j];
                    toSort[j] = temp;
                }
            }
        }
    }

}
