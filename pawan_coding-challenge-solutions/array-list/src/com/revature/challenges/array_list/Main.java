package com.revature.challenges.array_list;

<<<<<<< HEAD:pawan_coding-challenge-solutions/array-list/src/com/revature/challenges/array_list/Main.java
public class Main {
    public static void main(String[] args){
        List<String> names = new ArrayList<>();

        names.add("one");
        names.add("two");
        names.add("two");
        names.add("two");
        names.add("Three");
        names.add("two");
        names.add("apple");
        names.add("ball");
        names.add("two");
        names.add("Apple");
        //names.add("ball");




//        for(int i = 0; i < ((ArrayList<String>) names).getDEFAULT_CAPACITY(); i ++){
//            System.out.print(names.get(i) + " ");
//        }
//        System.out.println(names.remove(0));
//        System.out.println("After deletion");
//        System.out.println();
//        for(int i = 0; i < names.size(); i ++){
//            System.out.println(names.get(i));
//        }
//        System.out.println("\n" + names.size());
//        System.out.println("\n" + names.remove(0));
        for(int i = 0; i < names.size(); i ++){
            System.out.print(names.get(i) + " ");
        }
        System.out.println("\n" + names.contains(null));

//        System.out.println("\n" + names.lastIndexOf("two"));

=======
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        
        System.out.println(list);
>>>>>>> 7003f927bd4c1c02b60113caf08c39d4b1693093:coding-challenges/array-list/src/com/revature/challenges/array_list/Main.java
    }
}
