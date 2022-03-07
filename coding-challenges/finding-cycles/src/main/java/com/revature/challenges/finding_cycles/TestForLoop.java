package com.revature.challenges.finding_cycles;

public class TestForLoop {
    public static void main(String[] args) {
        System.out.println("Setting up a node called nodule.");
        SinglyLinkedList.Node<String> nodule = new SinglyLinkedList.Node<>("Snoopy");
        System.out.println("Setting up a singly linked list object.");
        SinglyLinkedList sll = new SinglyLinkedList(nodule);

        System.out.println("Testing to see if sll contains a loop.");
        if (sll.containsCycle(sll))
            System.out.println("Yes, the linked list contains a loop.");
        else
            System.out.println("no, the linked list does not contain a loop.");
    }
}
