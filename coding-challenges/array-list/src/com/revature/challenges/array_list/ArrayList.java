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
    private static final int DEFAULT_CAPACITY = 0;
    private Object[] elementContainer = new Object[DEFAULT_CAPACITY];
    private int currentSize = 0;

    /**
     * Appends the specified element to the end of this list.
     *
     * @param element element to be appended to this list
     * @return true
     */
    @Override
    public boolean add(T element)
    {
        this.currentSize = DEFAULT_CAPACITY + this.currentSize + 1;
        elementContainer = Arrays.copyOf(elementContainer, currentSize);
        elementContainer[currentSize - 1] = element;
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
    @Override
    public boolean contains(T element) {
        for (Object t : elementContainer) {
            if (t.equals(element)) {
                return true;
            }
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
        for (Object o : elementContainer) {
            if (o != null)
                return false;
        }
        return true;
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
        boolean flag = false;
        for (int i = 0; i < currentSize; i++) {
            if (element.equals(elementContainer[i])) {
                flag = true;
                if (i != currentSize - 1) {
                    elementContainer[i] = elementContainer[i+1];
                } else {
                    elementContainer[i] = null;
                }
                currentSize--;
            }
        }
        Object[] tmp = Arrays.copyOf(elementContainer, currentSize);
        elementContainer = tmp;
        return flag;
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    @Override
    public int size() {
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
        this.currentSize++;
        elementContainer = Arrays.copyOf(elementContainer, currentSize);
        for (int i = currentSize - 1; i > index; i--)
        {
            elementContainer[i] = elementContainer[i-1];
        }
            elementContainer[index] = element;
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
        T tmp = (T) elementContainer[index];
        elementContainer[index] = element;
        return tmp;
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
        Object tmp = new Object();
        tmp = elementContainer[index];
        for (int i = index; i < currentSize - 1; i++) {
            elementContainer[i] = elementContainer[i + 1];
        }
        this.currentSize--;
        elementContainer = Arrays.copyOf(elementContainer, currentSize);

        return (T) tmp;
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
        int counter = 0;
        for(Object o : elementContainer) {
            if (o == element)
                return counter;
            counter++;
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
     *         or -1 if this list does not contain the element
     */
    @Override
    public int lastIndexOf(T element) {
        //System.out.println(elementContainer.length);
        for(int counter = elementContainer.length - 1; counter > 0; counter-- ){
            if (elementContainer[counter].equals(element))
                return counter;
        }
        return -1;
    }

    @Override
    public String toString() {
        return "ArrayList: " +
                "elementContainer=" + Arrays.toString(elementContainer) +
                '}';
    }
}
