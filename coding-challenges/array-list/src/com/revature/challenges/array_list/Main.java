package com.revature.challenges.array_list;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> myArr = new ArrayList<>();
        myArr.add(0);
        myArr.add(3);
        myArr.add(6);
        myArr.add(9);
        myArr.add(36);
        myArr.add(93);

        myArr.contains(6);

        System.out.println(myArr.add(30));
        System.out.println(myArr.contains(5));   //returns false
        System.out.println(myArr.contains(30));   //returns true
        System.out.println(myArr.size());
        System.out.println(myArr.isEmpty());
        System.out.println(myArr.indexOf(2));


    }
}
