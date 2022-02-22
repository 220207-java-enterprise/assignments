package com.revature.challenges.array_list;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");

        ArrayList<Integer> arrList = new ArrayList<>();
        System.out.println(arrList);
        arrList.add(10);
        arrList.add(9);
        arrList.add(8);
        arrList.add(7);
        arrList.add(6);
        arrList.add(5);
        arrList.add(4);
        arrList.add(3);
        arrList.add(2);
        arrList.add(1);
        arrList.add(0);

        arrList.contains(11);

        System.out.println(arrList.isEmpty());

        //arrList.remove(new Integer(10));

        System.out.println("Size of the ArrayList= "+arrList.size());
        System.out.println("Element at index 9= " + arrList.get(9));

    }
}
