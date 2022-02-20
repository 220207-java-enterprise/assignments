package com.revature.challenges.linked_list;

import javax.xml.soap.Node;

public class ListDriver {

    public static void main(String[] args) {

        LinkedList<String> myList = new LinkedList<>();

        // TODO test your implementations below using the myList reference

        //add item to end of linked list
        myList.add("1st item");
        myList.add("2nd item");
        myList.add("3rd item");
        System.out.println(myList.toString());

        //contains given item
        System.out.println(myList.contains("2nd item"));

        //remove given item from list
        //DOES NOT WORK CURRENTLY
        //myList.remove("3rd item");
        //System.out.println(myList.toString());

        //add new item to end of linked list
        myList.add("4th item");
        System.out.println(myList.toString());

        //get item at given index
        System.out.println(myList.get(5)); //throws exception and returns null
        System.out.println(myList.get(1));

        //set item at given index to item given
        myList.set(1, "testing set(i, T)");
        System.out.println(myList.toString());

        //insert new item at given index
        myList.add(2, "inserted this in the middle");
        System.out.println(myList.toString());
        System.out.println(myList.size());

        //find the index of a given item
        System.out.println(myList.indexOf("4th item"));
    }
}
