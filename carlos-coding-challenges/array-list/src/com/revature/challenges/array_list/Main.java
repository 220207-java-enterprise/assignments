package com.revature.challenges.array_list;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        System.out.println(arr.size());
        arr.add(10);
        arr.add(9);
        arr.add(8);
        arr.add(7);
        arr.add(6);
        arr.add(5);
        arr.add(4);
        arr.add(3);

        System.out.println(arr.size());

        System.out.println("Contains: "+arr.contains(5));

    }
}
