package com.revature.challenges.linked_list;

/**
 * Singly-linked list implementation of the List and Deque interfaces. Permits
 * all elements (including null).
 *
 * @param <T> the type of elements maintained by this list
 */
public class LinkedList<T> implements List<T> {

    private int size = 0;
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
        size++;

        if (head == null){
            head = new Node<>(data);
            System.out.println(head.data);
            return true;
        }
        tail = head;
        for(int i = 0; i < size - 1; i++)
        {
            if(tail.nextNode == null){
                tail.nextNode = new Node<>(data);
                return true;
            }
            tail = tail.nextNode;
        }
        return true;
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
        if(head == null)
            return false;
        tail = head;
        for(int i = 0; i < size; i++)
        {
            if (tail.data == data) {
                return true;
            }
            tail = tail.nextNode;
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
        if(head == null)
            return true;
        return false;
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
        if(head == null)
            return false;
        if(head.data.equals(data))
        {
            head = head.nextNode;
            size--;
            return true;
        }
        tail = head;
        for(int i = 0; i < size; i++)
        {
            if (tail.nextNode.data.equals(data)) {
                tail.nextNode = tail.nextNode.nextNode;
                size--;
                return true;
            }
            tail = tail.nextNode;
        }
        return false;
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
     */
    @Override
    public T get(int index) {
        if(index > size)
            return (T) "Failed: Specified index > size of linked list";
        tail = head;
        for(int i = 1; i < index; i++)
        {
            tail = tail.nextNode;
        }
        return (T) tail.data;
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
        Node <T> tmp;
        if(index > size) {
            return;
        }
        if (head == null){
            head = new Node<>(element);
        }
        size++;
        tail = head;
        tmp = tail.nextNode;
        if(index == 1) {
            head = new Node<>(element);
            head.nextNode = tail;
            return;
        }
        for(int i = 1; i < index; i++)
        {
            tmp = tail;
            tail = tail.nextNode;
        }

        Node<T> tmp2 = new Node<>(element);
        //System.out.println("Created tmp2: " + tmp2.data + " Tail: " + tail.data + " Tmp: " + tmp.data + " Head: " + head.nextNode.data); //tmp.nextNode.data);
        tmp2.nextNode = tail;

        tmp.nextNode = tmp2;
        //System.out.println(head.data + " " + head.nextNode.data + " " +head.nextNode.nextNode.data);
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
        Node <T> tmp;
        tail = head;
        tmp = tail.nextNode;
        if(index == 1) {
            head = new Node<>(element);
            head.nextNode = tmp;
            return (T) tail.data;
        }
        for(int i = 1; i < index; i++)
        {
            tmp = tail;
            tail = tail.nextNode;
        }

        Node<T> tmp2 = new Node<>(element);
        tmp2.nextNode = tail.nextNode;
        tmp.nextNode = tmp2;
        return (T) tail.data;
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
        if (index < 0 || index > size)
            return (T) "Failed: index out of bounds";
        size--;
        Node <T> tmp;
        tail = head;
        tmp = tail.nextNode;
        if(index == 1) {
            head = head.nextNode;
            return (T) tail.data;
        }
        for(int i = 1; i < index; i++)
        {
            tmp = tail;
            tail = tail.nextNode;
        }
        tmp.nextNode = tail.nextNode;
        return (T) tail.data;
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
        tail = head;
        for( int i = 1; i <= size; i++)
        {
            if (tail.data.equals(element))
            {
                return i;
            }
            tail = tail.nextNode;
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
        int tmp = -1;
        tail = head;
        for( int i = 1; i <= size; i++)
        {
            if (tail.data.equals(element))
            {
                tmp = i;
            }
            tail = tail.nextNode;
        }
        return tmp;
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
