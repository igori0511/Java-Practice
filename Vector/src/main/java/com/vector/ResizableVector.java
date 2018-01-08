package com.vector;

import java.util.Arrays;

public class ResizableVector<T> implements Vector {

    private T innerResizableArray[];
    private int INITIAL_ARRAY_LENGTH = 2;
    private int numberOfItems = 0;

    @SuppressWarnings("unchecked")
    public ResizableVector() {
        this.innerResizableArray = (T[]) new Object[INITIAL_ARRAY_LENGTH];
    }

    // - number of items
    public int size() {
        return numberOfItems;
    }

    // - number of items it can hold
    public int capacity() {
        return this.innerResizableArray.length;
    }

    // - capacity()
    public boolean is_empty() {
        return size() == 0;
    }

    //- returns item at given index, blows up if index out of bounds
    public T at(int index) {
        return this.innerResizableArray[index];
    }

    // push item at the end
    public void push(T item) {
        // check capacity and resize
        resize();
        // increment number of items
        this.innerResizableArray[numberOfItems++] = item;
    }

    //- inserts item at index, shifts that index's value and trailing elements to the right
    public void insert(int index, T item) {
        // check capacity and resize
        resize();
        // shift items to the right if index is in current boundaries
        // if not there is no reason to shift
        if (index > size() || index < 0)
            throw new IndexOutOfBoundsException();

        System.arraycopy(this.innerResizableArray, index, this.innerResizableArray, index + 1,
                size() - index);

        // add item to specified index
        this.innerResizableArray[index] = item;
        // increase size
        numberOfItems++;
    }

    // - can use insert above at index 0
    public void prepend(T item) {
        insert(0, item);
    }

    // - remove from end, return value
    public T pop() {
        T item = this.innerResizableArray[size() - 1];
        this.innerResizableArray[size() - 1] = null;
        numberOfItems--;
        shrink();
        return item;
    }

    // - delete item at index, shifting all trailing elements left
    public void delete(int index) {
        // move items to the left
        int numMoved = size() - index - 1;
        if (numMoved > 0)
            System.arraycopy(this.innerResizableArray, index + 1, this.innerResizableArray, index,
                    numMoved);
        this.innerResizableArray[--numberOfItems] = null;
        // shrink the array if needed
        shrink();
    }

    // - looks for value and removes index holding it (even if in multiple places)
    public void remove(T item) {
        // remove all items in the array. Specified by item parameter
        for (int i = 0; i < size(); i++) {
            if (this.innerResizableArray[i].equals(item)) {
                fastRemove(i);
            }
        }
        // shrink if needed
        shrink();
    }

    // - looks for value and returns first index with that value, -1 if not found
    public int find(int item) {
        for (int i = 0; i < size(); i++) {
            if (this.innerResizableArray[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    // double the size of the array
    private void resize() {
        // check capacity
        if (size() >= capacity()) {
            // when you reach capacity, resize to double the numberOfItems
            // log(n) resize
            resize(capacity() * 2);
        }
    }

    // when popping an item, if numberOfItems is 1/4 of capacity, resize to half
    private void shrink() {
        // check capacity
        if (size() == capacity() / 4) {
            // when you reach capacity, resize to double the numberOfItems
            // log(n) resize
            resize(capacity() / 2);
        }
    }

    /*
     * Private remove method that skips bounds checking and does not
     * return the value removed.
     */
    private void fastRemove(int index) {
        int numMoved = numberOfItems - index - 1;
        if (numMoved > 0)
            System.arraycopy(this.innerResizableArray, index + 1, this.innerResizableArray, index,
                    numMoved);
        this.innerResizableArray[--numberOfItems] = null; // clear to let GC do its work
    }

    // actual resize logic
    private void resize(int new_capacity) {
        this.innerResizableArray = Arrays.copyOf(this.innerResizableArray, new_capacity);
    }

}