package com.linkedlist;

public class QueueLinkedList<T> {

    private class Node {
        Node next;
        T item;
    }

    private Node front;
    private Node back;
    private int size;

    public void enqueue(T value) {
        if (empty()) {
            Node firstNode = new Node();
            firstNode.item = value;
            front = back = firstNode;
        } else {
            Node nthNode = new Node();
            nthNode.item = value;
            back.next = nthNode;
            back = nthNode;
        }
        size++;
    }

    public T dequeue() {
        if (empty()) return null;
        T item = front.item;
        if (size == 1) {
            front = back = null;
        } else {
            front = front.next;
        }
        size--;
        return item;
    }

    public boolean empty() {
        return front == null && back == null;
    }

}
