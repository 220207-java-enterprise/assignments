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
        if (collection == null) {
            throw new IllegalArgumentException();
        }

        boolean success = false;

        while (success == false) {
            success = true;

            for (int i = 0; i < collection.length; i++) {
                if (i != collection.length - 1 && collection[i] > collection[i + 1]) {
                    success = false;

                    Integer bigInt = collection[i];
                    Integer smallInt = collection[i + 1];

                    collection[i] = smallInt;
                    collection[i + 1] = bigInt;
                }
            }
        }
    }
}
