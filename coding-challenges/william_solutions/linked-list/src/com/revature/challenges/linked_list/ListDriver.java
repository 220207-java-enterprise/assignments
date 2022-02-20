package com.revature.challenges.linked_list;

public class ListDriver {

    public static void main(String[] args) {

        LinkedList<String> myList = new LinkedList<>();

        // TODO test your implementations below using the myList reference
        //System.out.println("ran successfully");
        myList.add("this one");
        myList.add("this too");
        myList.add("and this thirdly");
        System.out.println(myList.toString());

        /*System.out.println(myList.contains("this too"));
        System.out.println(myList.contains("deliberate failure"));
        System.out.println(myList.isEmpty());*/

        System.out.println(myList.size());
        myList.remove("and this thirdly");
        System.out.println(myList.toString());
        System.out.println(myList.size());

        /*myList.remove("this one");
        System.out.println(myList.toString());
        System.out.println(myList.size());*/
    }
}
