package com.revature.challenges.bubble_sort;

public class Main {
    public static void main(String[] args){

        Integer [] array0 = {22, 113, 1111};
        Integer [] array1 = {113, 22, 1111};
        Integer [] array2 = {113, 1111, 22};
        Integer [] array3 = {1111, 22, 113};
        Integer [] array4 = {1111, 113, 22};

        Sorter<Integer> integerArray = new NumericBubbleSorter();


        System.out.print("Before Sorting: " );
        integerArray.printArray(array0);

        System.out.print("After Sorting: ");
        integerArray.sort(array0);

        System.out.print("Before Sorting: ");
        integerArray.printArray(array1);

        System.out.print("After Sorting: ");
        integerArray.sort(array1);

        System.out.print("Before Sorting: ");
        integerArray.printArray(array2);

        System.out.print("After Sorting: ");
        integerArray.sort(array2);

        System.out.print("Before Sorting: ");
        integerArray.printArray(array3);

        System.out.print("After Sorting: ");
        integerArray.sort(array3);

        System.out.print("Before Sorting: ");
        integerArray.printArray(array4);

        System.out.print("After Sorting: ");
        integerArray.sort(array4);

    }


}
