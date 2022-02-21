package com.revature.challenges.array_list;

public class ArrayListDriver {
    public static void main(String[] args){
        ArrayList<Character> testList = new ArrayList<>();


        System.out.println(testList.contains('A'));
        System.out.println(testList.contains('Z'));
        System.out.println(testList.contains(null));

        System.out.println(testList.isEmpty());

    }
}
