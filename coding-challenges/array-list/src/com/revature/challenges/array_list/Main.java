package com.revature.challenges.array_list;

public class Main{
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(34);
        arr.add(45);
        System.out.println(arr.size());
        System.out.println(arr.isEmpty());
        System.out.println(arr.contains(34));
        System.out.println(arr.get(0));
        System.out.println(arr.remove(45));
        System.out.println(arr.size());
    }
}