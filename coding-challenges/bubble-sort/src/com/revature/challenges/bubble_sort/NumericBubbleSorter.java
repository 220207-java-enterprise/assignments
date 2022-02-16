
package com.revature.challenges.bubble_sort;
import java.util.*;
public class NumericBubbleSorter implements Sorter<Integer> {

    /**
     * Sorts the provided collection of Integers from smallest to largest using the bubble
     * sort algorithm.
     * <p>
     * This method is considered to be impure, as it will modify the provided array directly.
     *
     * @param collection the array to be sorted
     * @throws IllegalArgumentException if a null array is provided
     */
    public void check(Integer[] collection) {
        Integer[] arr = collection;
        boolean bawl = false;
        for(int x = 0; x<10; x++) {
            if (arr[x]>arr[x+1]){
                bawl = false;
                break;
            }
            else {
                bawl = true;
            }
        }
        if(bawl){
            System.out.println("Sorted");
        }
    }
    @Override
    public void sort(Integer[] collection) throws IllegalArgumentException {
        // TODO your implementation
        if(collection == null){
            throw new IllegalArgumentException("null pointer");
        } else {


            Integer[] arr = collection;
            if (arr.length == 0) {
                System.out.println("Array is empty.");
            } else {
                check(arr);
                int a = 0;
                int b = 1;
                int num1 = arr[a];
                int num2 = arr[b];


                for (int x = 0; x < 1; x++) {
//            while (d = false) {
                    boolean bawl = false;
                    while (!bawl) {
                        if (num2 < num1) {

                            int temp = arr[a];
                            arr[a] = arr[b];
                            arr[b] = temp;
                        }

                        a++;
                        b++;
                        if (b == 11) {
                            a = 0;
                            b = 1;
                        }
                        num1 = arr[a];
                        num2 = arr[b];

                        for (int y = 0; y < 10; y++) {
                            if (arr[y] > arr[y + 1]) {
                                bawl = false;
                                break;
                            } else {
                                bawl = true;
                            }
                        }
                    }
                }
            }
        }
//        System.out.println("Ends with " + Arrays.toString(arr));
    }
}


    //begin
//    @Override
//    public void sort(Integer[] collection) throws IllegalArgumentException {
//        // TODO your implementation
//        Integer[] arr = collection;
//        int theLength = arr.length;
//        int a = 0;
//        int b = 1;
//        int num1 = arr[a];
//        int num2 = arr[b];
//        int c = 0;
////        String beg = Arrays.toString(arr);
//        System.out.println("begins with " + Arrays.toString(arr));
//        for (int x = 0; x < 1; x++) {
////            while (d = false) {
//            while (c < 100) {
//                if (a < 9) {
//                    if (num2 < num1) {
//
//                        int temp = arr[a];
//                        arr[a] = arr[b];
//                        arr[b] = temp;
////                    System.out.println("a: " + a);
////                    System.out.println("b: " + b);
//                        if(b==9){
//                            System.out.println("a: " + a + "the num in pos is: " + num1);
//                            System.out.println("b: " + b + "the num in pos is: " + num2);
//                        }
//
//
//                    }
//
//                    a++;
//                    b++;
//                    c++;
//                    num1 = arr[a];
//                    num2 = arr[b];
//                } else {
//                a = 0;
//                b = 1;
//            }
//            }
//        }
////        }
//        System.out.println("Ends with " + Arrays.toString(arr));
//    }
//}
//end





//    @Override
//    public void sort(Integer[] collection) throws IllegalArgumentException {
//        // TODO your implementation
//        Integer[] arr = collection;
//        checkSort(arr);









//        Integer[] arr = collection;
//        int a = 0;
//        int b = 1;
//        int num1 = arr[a];
//        int num2 = arr[b];
//        System.out.println("begins with " + Arrays.toString(arr));
////        while (num1 > num2) {
////            array
////        }
//        for(int x = 0; x<1000; x++) {
//            a = 0;
//            b = 1;
////            System.out.println(x);
//            if(num1 > num2) {
//                while (b < arr.length) {
//                    num1 = arr[a];
//                    num2 = arr[b];
//                    int originalPosition = a;
//                    int newPosition = b;
//
//                    int temp = arr[originalPosition];
//                    arr[originalPosition] = arr[newPosition];
//                    arr[newPosition] = temp;
//
//                    if(b == arr.length) {
//                        a = 0;
//                        b = 1;
//                    } else {
//                        a++;
//                        b++;
//                    }
//                }
//            }
//
//        }System.out.println("Ends with " + Arrays.toString(arr));
//
//    }
//
//}
