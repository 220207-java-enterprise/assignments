package com.revature.challenges.linked_list;

/**
 * Singly-linked list implementation of the List and Deque interfaces. Permits
 * all elements (including null).
 *
 * @param <T> the type of elements maintained by this list
 */
public class LinkedList<T> implements List<T> {

    private int size;
    private Node<T> head;
    private Node<T> tail;

    /**
     * Appends the specified element to the end of this list.
     *
     * @param data element to be appended to this list
     * @return true
     */
    @Override
    public boolean add(T data) {

        //System.out.println("start add");
        if (this.head == null) {
            this.head = new Node<>(data);
            //System.out.println("first if");
        }
        else if (this.head.nextNode == null) {
            this.tail = new Node<>(data);
            this.head.nextNode = this.tail;
            //System.out.println("2nd if");
        }
        else {
            this.tail.nextNode = new Node<>(data);
            this.tail = this.tail.nextNode;
            //System.out.println("last if");
        }
        this.size++;
        return false;
    }

    /**
     * Returns true if this list contains the specified element. More formally,
     * returns true if and only if this list contains at least one element e
     * such that (o==null ? e==null : o.equals(e)).
     *
     * @param data element whose presence in this list is to be tested
     * @return true if this list contains the specified element
     */
    @Override
    public boolean contains(T data) {

        Node<T> runner = head;
        for (int i = 0; i < this.size; i++) {
            if (runner.data == data) {
                return true;
            }
            runner = runner.nextNode;
        }
        return false;
    }

    /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Removes the first occurrence of the specified element from this list, if it is present.
     * If this list does not contain the element, it is unchanged. More formally, removes the
     * element with the lowest index i such that (o==null ? get(i)==null : o.equals(get(i)))
     * (if such an element exists). Returns true if this list contained the specified element.
     *
     * @param data element to be removed from this list, if present
     * @return true if this list contained the specified element
     */
    @Override
    public boolean remove(T data) {


        Node<T> runner = head;
        Node<T> previousRunner = head;
        for (int i = 0; i < this.size; i++) {
            //System.out.println(runner.data);
            //System.out.println(data);

            //if data is found in the last node do this
            //this currently works
            if (runner.data == data && runner.nextNode == null) {
                System.out.println("last node conditional");
                System.out.println(previousRunner.data);
                System.out.println(runner.data);
                previousRunner.nextNode = null;
                System.out.println(previousRunner.nextNode);
                size--;
                return true;
            }
            //if data is found and it is not in the first node
            else if (runner.data == data && previousRunner.nextNode != runner.nextNode) {
                System.out.println("not first or last node conditional");
                previousRunner.nextNode = runner.nextNode;
                size--;
                return true;
            }
            //if data is found in the first node do this
            //currently works!!
            else if (runner.data == data && i == 0) {
                System.out.println("first node conditional");
                System.out.println("head: " + head.data);
                head = head.nextNode;
                System.out.println("new head: " + head.data);
                size--;
                return true;
            }

            else {
                System.out.println("last else in remove");
                //System.out.println(runner.data == tail.data);
                runner = runner.nextNode;
                if (i != 0)
                    previousRunner = previousRunner.nextNode;
            }
            System.out.println(i);
        }

        return false;
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    @Override
    public int size() { return this.size; }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
     */
    @Override
    public T get(int index) {

        try {
            if (index < 0 || index > this.size) {
                throw new IndexOutOfBoundsException();
            }
            else if (index == 0){
                return this.head.data;
            }
            Node<T> runner = this.head;
            for (int i = 0; i < this.size; i++) {
                if (i == index) {
                    return runner.data;
                }
                runner = runner.nextNode;
            }
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("Index " + index + " is out of bounds!");
        }
        return null;
    }

    /**
     * Inserts the specified element at the specified position in this list. Shifts
     * the element currently at that position (if any) and any subsequent elements
     * to the right (adds one to their indices).
     *
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index > size())
     */
    @Override
    public void add(int index, T element) {

        try {
            if (index < 0 || index > size()) {
                throw new IndexOutOfBoundsException();
            }
            Node<T> runner = head;
            Node<T> previousRunner = head;
            Node<T> insertThis = new Node<>(element);

            for (int i=0; i<this.size; i++) {
                //if we are at the correct index and the index
                // is not at the first node, do this
                if (index != 0 && i == index) {
                    previousRunner.nextNode = insertThis;
                    insertThis.nextNode = runner;
                    size++;
                    return;
                }
                if (i == 0) {
                    runner = runner.nextNode;
                }
                else {
                    previousRunner = previousRunner.nextNode;
                    runner = runner.nextNode;
                }
            }
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("Index was out of bounds");
        }
    }

    /**
     * Replaces the element at the specified position in this list with the
     * specified element (optional operation).
     *
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     */
    @Override
    public T set(int index, T element) {
        System.out.println(element);

        Node<T> runner = this.head;
        for (int i = 0; i < this.size; i++) {
            if (i == index) {
                runner.data = element;
                return element;
            }
            runner = runner.nextNode;
        }
        return null;
    }

    /**
     * Removes the element at the specified position in this list. Shifts any
     * subsequent elements to the left (subtracts one from their indices).
     * Returns the element that was removed from the list.
     *
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
     */
    @Override
    public T remove(int index) {
        return null;
    }

    /**
     * Returns the index of the first occurrence of the specified element in this list,
     * or -1 if this list does not contain the element. More formally, returns the lowest
     * index i such that (o==null ? get(i)==null : o.equals(get(i))), or -1 if there is
     * no such index.
     *
     * @param element element to search for
     * @return the index of the first occurrence of the specified element in this list,
     *         or -1 if this list does not contain the element
     */
    @Override
    public int indexOf(T element) {

        Node<T> runner = this.head;
        for (int i=0; i<this.size; i++) {
            if (runner.data == element) {
                return i;
            }
            runner = runner.nextNode;
        }
        return -1;
    }

    /**
     * Returns the index of the last occurrence of the specified element in this list,
     * or -1 if this list does not contain the element. More formally, returns the highest
     * index i such that (o==null ? get(i)==null : o.equals(get(i))), or -1 if there is
     * no such index.
     *
     * @param element element to search for
     * @return the index of the last occurrence of the specified element in this list,
     *             or -1 if this list does not contain the element
     */
    @Override
    public int lastIndexOf(T element) {
        return -1;
    }


    @Override
    public String toString() {

        if (head == null) {
            return "[ ]";
        }

        StringBuilder strBldr = new StringBuilder();
        strBldr.append("[ ");

        Node<T> runner = head;
        for (int i = 0; i < this.size; i++) {
            if (i == size - 1) {
                strBldr.append(runner.data.toString()).append(" ");
            } else {
                strBldr.append(runner.data.toString()).append(", ");
            }
            runner = runner.nextNode;
        }

        strBldr.append("]");

        //System.out.println(tail.nextNode==null);
        return strBldr.toString();
    }

    // Nested Inner Class
    // The outer class (LinkedList) can see all the members of this class (even if they are private)
    private static class Node<T> {
        T data;
        Node<T> nextNode;

        public Node(T data) {
            this.data = data;
        }
    }

}