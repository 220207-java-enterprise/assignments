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
        int tmp = 0;
        for(int j=1; j<collection.length;j++){
            for (int i=1; i<=collection.length-j; i++){
                if(collection[i]<collection[i-1]){
                    tmp = collection[i];
                    collection[i] = collection[i-1];
                    collection[i-1] = tmp;
                }
            }
        }
        
        for (int j=0; j<collection.length; j++){
            System.out.print(collection[j]+",");
        }
        System.out.println();
        // TODO your implementation
    }

}
