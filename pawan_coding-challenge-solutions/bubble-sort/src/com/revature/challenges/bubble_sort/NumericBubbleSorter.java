package com.revature.challenges.bubble_sort;

import java.lang.annotation.Documented;

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

        Integer temp;
        for (int i = 0; i < collection.length; i++){
            for (int j = i + 1; j < collection.length; j++){
                if(collection[i] > collection[j]) {
                    temp = collection[j];
                    collection[j] = collection[i];
                    collection[i] = temp;
                }
            }
            System.out.print(collection[i] + " ");
        }
        System.out.println("\n");
    }

    public void printArray(Integer [] array){
        for (Integer i : array)
            System.out.print(i + " ");
        System.out.println();
    }


}
