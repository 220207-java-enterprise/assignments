package com.revature.challenges.array_list;

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

    }
}
