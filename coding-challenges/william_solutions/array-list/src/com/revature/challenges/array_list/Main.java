package com.revature.challenges.array_list;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        
        System.out.println(list);

        list.add(3, 5);
        System.out.println(list);
        list.add(8, 10);
        list.set(2, 27);
        System.out.println(list);

        System.out.println(list.indexOf(27));
        System.out.println(list.indexOf(35));

        list.add(10);
        list.add(23);
        list.add(23);
        list.add(1);
        System.out.println(list);

        System.out.println(list.indexOf(23));
        System.out.println(list.lastIndexOf(23));

        System.out.println(list.remove((Integer) 27));
        System.out.println(list);

    }
}
