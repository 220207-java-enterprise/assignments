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
            throw new IllegalArgumentException("Array is empty");

        //987654321 -> 123456789
        //012345678

        //run collection.length-1 times
        for (int i=0; i<collection.length-1; i++){
            //each time will move the largest to the end.
            for (int j=0; j<collection.length-1; j++){
                if (collection[j]>collection[j+1]){
                    Integer tempValue = collection[j];
                    collection[j] = collection[j+1];
                    collection[j+1] = tempValue;
                }
            }
        }
    }

}
