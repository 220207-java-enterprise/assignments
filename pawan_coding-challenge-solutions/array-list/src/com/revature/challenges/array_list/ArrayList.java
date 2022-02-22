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

    // The following three lines are provided for your convenience
<<<<<<< HEAD:pawan_coding-challenge-solutions/array-list/src/com/revature/challenges/array_list/ArrayList.java
//    private static final int DEFAULT_CAPACITY = 10;
    public int DEFAULT_CAPACITY = 10;
    private Object[] elementContainer = new Object[DEFAULT_CAPACITY];
=======
    private int pointer = 0;

    private static final int DEFAULT_CAPACITY = 10;
    private final int index = 0;
>>>>>>> 7003f927bd4c1c02b60113caf08c39d4b1693093:coding-challenges/array-list/src/com/revature/challenges/array_list/ArrayList.java
    private int currentSize = 0;
    private Object[] elementContainer = new Object[currentSize];

    /**
     * Appends the specified element to the end of this list.
     *
     * @param element element to be appended to this list
     * @return true
     */
    @Override
    public boolean add(T element) {
<<<<<<< HEAD:pawan_coding-challenge-solutions/array-list/src/com/revature/challenges/array_list/ArrayList.java
       if(size() <= DEFAULT_CAPACITY)
           elementContainer[currentSize++] = element;
           return true;
=======
        Object[] tempContainer = new Object[currentSize];

        System.arraycopy(elementContainer, 0, tempContainer, 0, elementContainer.length);

        currentSize += 1;
        elementContainer = new Object[currentSize];

        System.arraycopy(tempContainer, 0, elementContainer, 0, tempContainer.length);

        elementContainer[elementContainer.length - 1] = element;

        return true;
>>>>>>> 7003f927bd4c1c02b60113caf08c39d4b1693093:coding-challenges/array-list/src/com/revature/challenges/array_list/ArrayList.java
    }

    /**
     * Returns true if this list contains the specified element. More formally,
     * returns true if and only if this list contains at least one element e
     * such that (o==null ? e==null : o.equals(e)).
     *
     * @param element element whose presence in this list is to be tested
     * @return true if this list contains the specified element
     */
    @Override
    public boolean contains(T element) {
<<<<<<< HEAD:pawan_coding-challenge-solutions/array-list/src/com/revature/challenges/array_list/ArrayList.java

        for(int i = 0; i < size(); i++){
            if (elementContainer[i] == null && element == null)
                return true;
            if (elementContainer[i].equals(element))
                return true;
        }
=======
        for (Object t : elementContainer) {
            if (t.equals(element)) {
                return true;
            }
        }

>>>>>>> 7003f927bd4c1c02b60113caf08c39d4b1693093:coding-challenges/array-list/src/com/revature/challenges/array_list/ArrayList.java
        return false;
    }

    /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements
     */
    @Override
    public boolean isEmpty() {
       return currentSize == 0;
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
        for(int i = 0; i < size(); i++){
            if(elementContainer[i] == element) {
                remove(i);
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
<<<<<<< HEAD:pawan_coding-challenge-solutions/array-list/src/com/revature/challenges/array_list/ArrayList.java
        return currentSize;
=======
        int count = 0;

        for (Object o : elementContainer) {
            if ( o != null) {
                count++;
            }
        }

        return count;
>>>>>>> 7003f927bd4c1c02b60113caf08c39d4b1693093:coding-challenges/array-list/src/com/revature/challenges/array_list/ArrayList.java
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
<<<<<<< HEAD:pawan_coding-challenge-solutions/array-list/src/com/revature/challenges/array_list/ArrayList.java
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();
        return (T)elementContainer[index];
=======
        return (T) elementContainer[index];
>>>>>>> 7003f927bd4c1c02b60113caf08c39d4b1693093:coding-challenges/array-list/src/com/revature/challenges/array_list/ArrayList.java
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
        T previous = (T) elementContainer[index];
        elementContainer[index] = element;
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
<<<<<<< HEAD:pawan_coding-challenge-solutions/array-list/src/com/revature/challenges/array_list/ArrayList.java

        if(index < 0 || index >= size())
            throw new IndexOutOfBoundsException("Index out of bound");

        T removeElement = (T) elementContainer[index];

        for(int i = index; i < size() -1; i++){
            elementContainer[i] = elementContainer[i +1];
        }
        elementContainer[size() -1 ] = null;
        currentSize--;
        return (T) removeElement;
=======
        Object[] tempContainer = new Object[currentSize];

        System.arraycopy(elementContainer, 0, tempContainer, 0, elementContainer.length);

        currentSize -= 1;
        elementContainer = new Object[currentSize];

        int j = 0;
        int k = 0;
        while (j < tempContainer.length) {
            if (j != index) {
                elementContainer[k] = tempContainer[j];
                k++;
            }
            j++;
        }

        return (T) elementContainer;
>>>>>>> 7003f927bd4c1c02b60113caf08c39d4b1693093:coding-challenges/array-list/src/com/revature/challenges/array_list/ArrayList.java
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
        int index = -1;
        for (int i = 0; i < size(); i++) {
            if (elementContainer[i] == element)
                index = i;
        }
        return index;
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

        int index = -1;

        for (int i = 0; i < size(); i++) {
            if (elementContainer[i] == element){
                index = i;
                continue;
            }
        }
        return index;
    }

    public int getDEFAULT_CAPACITY(){
        return DEFAULT_CAPACITY;
    }

    @Override
    public String toString() {
        return "ArrayList: " +
                "elementContainer=" + Arrays.toString(elementContainer) +
                '}';
    }
}
