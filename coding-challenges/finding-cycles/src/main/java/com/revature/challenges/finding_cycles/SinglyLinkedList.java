package com.revature.challenges.finding_cycles;

import java.util.LinkedList;
import java.util.ArrayList;

public class SinglyLinkedList<T> {

    protected Node<T> head;

    public SinglyLinkedList(Node<T> head) {
        this.head = head;
    }

    /**
     * Determines whether this linked list contains any cycles. A cycle is present if
     * there is any node in the list whose nextNode points to another node present earlier
     * in the list.
     *
     * @return true if a cycle is present within this list, otherwise false
     */
    public boolean containsCycle(SinglyLinkedList<T> ll) {
        // Here goes!
        ArrayList<Node> al = new ArrayList<>();
        // Start at head node
        Node temp = new Node("Snoopy");
        temp = ll.head;
        if (temp.nextNode == null) {
            return false;
        }
        if (temp.nextNode == head) {
            return true;
        }

        Node next = temp.nextNode;

        al.add(temp);
        //al.add(next);

        do {

            for (int i = 0; i < al.size(); i++) {

                if (temp.nextNode == al.get(i)) {
                    return true;
                }
            }
            // At this point we know that the node in question hasn't occurred in the list before.

            // go to the next node
            al.add(next);
            temp = next;
            next = temp.nextNode;
        } while (temp.nextNode != null);

        // If its reference data shows up in the array list, return true.

        // else place its reference data into the array list

        // Last node?  No?  Go back up and go to the next node to check it

        return false; // There are no cycles in this linked list.
    }

    public static class Node<T> {
        T data;
        Node<T> nextNode;

        public Node(T data) {
            this.data = data;
        }
    }

}
