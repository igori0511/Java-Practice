package com.linkedlist;

public class LinkedList<T> {

    private class Node {
        Node next;
        T item;
        Node prev;
    }

    private int size;
    private Node front;
    private Node back;

    public LinkedList() {
        this.size = 0;
    }

    // returns number of data elements in list
    public int size() {
        return this.size;
    }

    // bool returns true if empty
    public boolean empty() {
        return size() == 0;
    }

    // returns the value of the nth item (starting at 0 for first)
    public T valueAt(int index) {
        if (empty()) return null;
        checkBoundaries(index);

        Node startNode = front;
        int i = 0;
        while (startNode != null && i++ != index) startNode = startNode.next;
        return startNode != null ? startNode.item : null;
    }


    // adds an item to the front of the list
    public void pushFront(T value) {
        if (empty()) {
            Node firstNode = new Node();
            firstNode.item = value;
            front = back = firstNode;
        } else {
            Node nthNode = new Node();
            nthNode.item = value;
            nthNode.next = front;
            front.prev = nthNode;
            front = nthNode;
        }
        size++;
    }

    // remove front item and return its value
    public T popFront() {
        if (empty()) return null;
        T item = front.item;
        if (size() == 1) {
            front = back = null;
        } else {
            front.next.prev = null;
            front = front.next;
        }
        size--;
        return item;
    }

    // adds an item at the end
    public void pushBack(T value) {
        if (empty()) {
            Node firstNode = new Node();
            firstNode.item = value;
            front = back = firstNode;
        } else {
            Node nthNode = new Node();
            nthNode.item = value;
            nthNode.prev = back;
            back.next = nthNode;
            back = nthNode;
        }
        size++;
    }

    // removes end item and returns its value
    public T popBack() {
        if (empty()) return null;
        T item = back.item;
        if (size() == 1) {
            front = back = null;
        } else {
            back.prev.next = null;
            back = back.prev;
        }
        size--;
        return item;
    }

    // get value of front item
    public T front() {
        if (empty()) return null;
        return front.item;
    }

    // get value of end item
    public T back() {
        if (empty()) return null;
        return back.item;
    }

    // insert value at index, so current item at that index is pointed to by new item at index
    public void insert(int index, T value) {
        checkBoundaries(index);

        Node foundNode = front;
        int i = 0;
        while (foundNode != null && i++ != index) foundNode = foundNode.next;

        if (foundNode != null) {
            Node nodeAtIndex = new Node();
            nodeAtIndex.item = value;
            foundNode.prev.next = nodeAtIndex;
            nodeAtIndex.next = foundNode;
            nodeAtIndex.prev = foundNode.prev;
            foundNode.prev = nodeAtIndex;
            size++;
        }
    }

    //  removes node at given index
    public void erase(int index) {
        checkBoundaries(index);
        if (size() == 1) {
            front = back = null;
        } else {
            Node foundNode = front;
            int i = 0;
            while (foundNode != null && i++ != index) foundNode = foundNode.next;

            if (foundNode != null) {
                foundNode.prev.next = foundNode.next;
                foundNode.next.prev = foundNode.prev;
                foundNode.prev = null;
                foundNode.next = null;
                size--;
            }
        }
    }

    // returns the value of the node at nth position from the end of the list
    public T valueNFromEnd(int n) {
        Node foundNode = back;
        int i = n;
        while (foundNode != null && i-- != 0) foundNode = foundNode.prev;

        if (foundNode != null) {
            size--;
            return foundNode.item;
        }

        return null;
    }

    // reverses the list
    public void reverse() {
        if (size() > 1) {
            Node current = front;
            while (current != null) {
                Node prev = current.prev;
                current.prev = current.next;
                current.next = prev;
                current = current.prev;
            }
            Node temp = front;
            front = back;
            back = temp;
        }
    }

    // removes the first item in the list with this value
    public void removeValue(T value) {
        Node foundNode = front;
        while (foundNode != null) {
            if (foundNode.item.equals(value)) {
                foundNode.prev.next = foundNode.next;
                foundNode.next.prev = foundNode.prev;
                foundNode.prev = null;
                foundNode.next = null;
                size--;
                break;
            }
            foundNode = foundNode.next;
        }
    }

    private void checkBoundaries(int index) {
        if (!(index >= 0 && index < size())) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
    }
}
