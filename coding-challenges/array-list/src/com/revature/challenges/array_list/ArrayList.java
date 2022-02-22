package com.revature.challenges.array_list;

import java.util.Arrays;

/**
 * Resizable-array implementation of the List interface. Permits all element values,
 * including null. Each ArrayList instance has a capacity. The capacity is the size
 * of the array used to store the elements in the list. It is always at least as large
 * as the list size. As elements are added to an ArrayList, its capacity grows
 * automatically.
 *
 * @param <T> the type of elements maintained by this list
 */
public class ArrayList<T> implements List<T> {

    private int pointer = 0;

    private static final int DEFAULT_CAPACITY = 10;
    private final int index = 0;
    private int currentSize = 0;
    private Object[] elementContainer = new Object[currentSize];

    /**
     * Appends the specified element to the end of this list.
     *
     * @param element element to be appended to this list
     * @return true
     */
    @Override
    public boolean add(T element){

        Object[] tempContainer = new Object[currentSize];

        /*
        1. make a copy of the element container and store into tempContainer
        Params
        src – the source array.
        srcPos – starting position in the source array.
        dest – the destination array.
        destPos – starting position in the destination data.
        length – the number of array elements to be copied.
        */
        System.arraycopy(elementContainer, 0, tempContainer, 0, elementContainer.length);

        // 2. Increment currentSize
        currentSize += 1;

        // 3. Re-instantiate elementContainer using that can hold the new currentSize value
        elementContainer = new Object[currentSize];

        // 4. Send all tempContainer elements back to elementContainer. Now elementContainer can hold one extra item
        System.arraycopy(tempContainer, 0, elementContainer, 0, tempContainer.length);

        // 5. Add the new element at the last index of elementContainer
        elementContainer[elementContainer.length - 1] = element;

        System.out.println("Adding "+element+" to soccerPlayers");
        return true;

    }


    /**
     * Returns true if this list contains the specified element. More formally,
     * returns true if and only if this list contains at least one element e
     * such that (o==null ? e==null : o.equals(e)).
     *
     * @param element element whose presence in this list is to be tested
     * @return true if this list contains the specified element
     */
    @Override //input -> element output -> boolean
    public boolean contains(T element) {
        // return true if element is inside elementContainer
        if (currentSize==0){
            return false;
        }
        for (int i = 0; i < elementContainer.length; i++) {
            if (elementContainer[i].equals(element)) {
                System.out.println(element + " is a soccerPlayer");
                return true;
            }
        }
        System.out.println(element + " is not a soccerPlayer");
        return false;
    }
    /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements
     */
    @Override
    public boolean isEmpty() {
        if (currentSize==0){
            System.out.println("soccerPlayers is an empty array");
        } else {
            System.out.println("soccerPlayers is not an empty array");
        }
        return currentSize==0;
    }

    /**
     * Removes the first occurrence of the specified element from this list, if it is present.
     * If this list does not contain the element, it is unchanged. More formally, removes the
     * element with the lowest index i such that (o==null ? get(i)==null : o.equals(get(i)))
     * (if such an element exists). Returns true if this list contained the specified element.
     *
     * @param element element to be removed from this list, if present
     * @return true if this list contained the specified element
     */
    @Override
    public boolean remove(T element) {
        System.out.println("Running remove()...");
        for (int i = 0; i < elementContainer.length; i++){
            if (element.equals(elementContainer[i])) {
                int j=0;
                while(j < currentSize){
                    System.out.println(elementContainer[j]);
                    T temp = (T) elementContainer[j+1];
                    elementContainer[j]=temp;
                    j++;
                }
                System.out.println("After removing: "+Arrays.toString(elementContainer));
                currentSize--;
                return true;
            }
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
        System.out.println("There are "+currentSize+" players in soccerPlayers");
        return currentSize;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
     */
    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        try {
            System.out.println("soccerPlayer at index " + index + " is " + elementContainer[index].toString());
        } catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return (T) elementContainer[index];
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
        // get item that will be replaced
        T previous = (T) elementContainer[index];
        // update previous with the new item
        elementContainer[index] = element;
        // return replaced item
        return previous;
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
        // start cursor from the front
        pointer = 0;
        while (pointer < elementContainer.length){
            if (elementContainer[pointer].equals(element)){
                System.out.println(element +" first occurs in this index position: "+pointer);
                return pointer;
            }
            pointer++;
        }
        System.out.println(element + " is not in the array");
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
     *         or -1 if this list does not contain the element
     */
    @Override
    public int lastIndexOf(T element) {
        // start cursor from the back
        pointer = elementContainer.length-1;
        while (pointer >= 0){
            if (elementContainer[pointer].equals(element)){
                System.out.println(element +" last occurs in this index position: "+pointer);
                return pointer;
            }
            pointer--;
        }
        System.out.println(element + " is not in the array");
        return -1;
    }

    @Override
    public String toString() {
        return "ArrayList: " +
                "elementContainer=" + Arrays.toString(elementContainer) +
                '}';
    }
}
