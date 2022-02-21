package com.revature.challenges.array_list;

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
    private static final int DEFAULT_CAPACITY = 10;
    public Object[] elementContainer = new Object[DEFAULT_CAPACITY];
    //private int currentSize = 0;
    public int currentSize = 0;

    /**
     * Appends the specified element to the end of this list.
     *
     * @param element element to be appended to this list
     * @return true
     */
    @Override
    //add 'A'
    public boolean add(T element) {
        //if currentSize < 10, then there is a space to store the element.
        if (currentSize <10){
            elementContainer[currentSize] = element;
            //['A', null,null, null,null, null,null, null,null, null]
            currentSize++;
        }else{ //otherwise, create a new Object[],and increase the size, then update the container
            Object[] newElementContainer = new Object[++currentSize];
            //remove the items from old container to the new container
            System.arraycopy(elementContainer, 0, newElementContainer, 0, elementContainer.length);
            newElementContainer[currentSize-1] = element;
            elementContainer = newElementContainer;
        }
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
        boolean containItem = false;
        for (Object item : elementContainer){
            if(item == element){
                containItem = true;
                break;
            }
        }
        return containItem;
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
        //check if the item is existed or not
        if (contains(element)){
            //two cases if the item is existed:
            //case1: if the total items <= 10; Keep DEFAULT_CAPACITY = 10;
            boolean shift = false;
            if (currentSize <=10){
                for (int i=0; i<currentSize-1; i++){
                    if (shift){ //shift everything to the left
                        elementContainer[i] = elementContainer[i+1];
                    }else if (elementContainer[i] == element){
                        //remove the first item founds
                        elementContainer[i] = elementContainer[i+1];
                        shift = true;
                    }
                }
                elementContainer[currentSize-1] = null;
            }else{
            //case2: if the total items >10; decreasing the capacity;
                Object[] newElementContainer = new Object[currentSize-1];
                for(int i=0; i<currentSize-1; i++){
                    if (shift){ //added everything from the right
                        newElementContainer[i] = elementContainer[i+1];
                    }else if (elementContainer[i] == element){
                        //don't add the remove item to the new container, added the next one
                        newElementContainer[i] = elementContainer[i+1];
                        shift=true;
                    }else{
                        newElementContainer[i] = elementContainer[i];
                    }
                }
                elementContainer = newElementContainer;
            }
            currentSize--;
            return true;
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
        //Out of Range
        if (index <0 || index >= currentSize)
            throw (new IndexOutOfBoundsException("Out of Range"));

        Object element = elementContainer[index];


        return (T) element;
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
        if (index <0 || index > currentSize)
            throw (new IndexOutOfBoundsException("Out of Range"));

        //if the capacity is not full;
        int currentIndex = currentSize;
        if(currentSize+1 <=10){
            //0 1 3 4 5 6  --> add 2 in position 2.
            //0 1 2 3 4 5 6
            System.arraycopy(elementContainer, index, elementContainer, index + 1, currentIndex - index);
            elementContainer[index] = element;
        }else{
            Object[] newElementContainer = new Object[currentSize+1];
            //added all elements from the left side
            System.arraycopy(elementContainer, 0, newElementContainer, 0, index);
            //insert the element
            newElementContainer[index] = element;
            //added all elements from the right side
            if (currentSize + 1 - (index + 1) >= 0)
                System.arraycopy(elementContainer, index + 1 - 1, newElementContainer, index + 1, currentSize + 1 - (index + 1));
            elementContainer = newElementContainer;
        }
        currentSize++;
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
        if (index <0 || index > currentSize)
            throw (new IndexOutOfBoundsException("Out of Range"));

        Object item = elementContainer[index];
        elementContainer[index] = element;
        return (T)item;
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
        if (index <0 || index > currentSize-1)
            throw (new IndexOutOfBoundsException("Out of Range"));

        //save the remove item
        Object item = elementContainer[index];

        //if the currentSize <=10; then no worry about the capacity.
        if (currentSize<=10){
            //0 1 2 3 4 5 -> remove index 1
            //0 2 3 4 5
            if (currentSize - 1 - index >= 0)
                System.arraycopy(elementContainer, index + 1, elementContainer, index, currentSize - 1 - index);
            //mark the last element as null;
            elementContainer[currentSize-1] = null;
        }else{
            //else, decrease the capacity.
            Object[] newElementContainer = new Object[currentSize-1];
            System.arraycopy(elementContainer, 0, newElementContainer, 0, index);
            if (currentSize - 1 - index >= 0)
                System.arraycopy(elementContainer, index + 1, newElementContainer, index, currentSize - 1 - index);
            elementContainer=newElementContainer;
        }
        currentSize--;
        return (T)item;
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

        for(int i=0; i<currentSize; i++){
            if(elementContainer[i] == element)
                return i;
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

        for(int i=currentSize-1; i>0; i--){
            if(elementContainer[i] == element)
                return i;
        }
        return -1;
    }

}
