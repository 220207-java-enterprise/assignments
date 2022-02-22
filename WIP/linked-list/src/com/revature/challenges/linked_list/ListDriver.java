package com.revature.challenges.linked_list;

public class ListDriver {

    public static void main(String[] args) {

        LinkedList<String> myList = new LinkedList<>();
        myList.add("A");
        myList.add("B C");
        myList.add("D2");
        System.out.println(myList);
        System.out.println("Contains: " +myList.contains("D2"));
        System.out.println("Remove1 (D2) : " +myList.remove("D2"));
        System.out.println(myList);
        System.out.println("Get: " + myList.get(2));
        myList.add(1, "Eyes");
        System.out.println("Add2: " +myList);
        System.out.println(myList);
        System.out.println("Set: " +myList.set(2, "closed"));
        System.out.println(myList);
        System.out.println("Remove2 (index 3): " +myList.remove(1));
        System.out.println(myList + " "+ myList.size());
        System.out.println("Indexof: " +myList.indexOf("closed"));
        myList.add("closed");
        System.out.println("LastIndexof: " +myList.lastIndexOf("closed"));
        System.out.println(myList);


        // TODO test your implementations below using the myList reference

    }
}
