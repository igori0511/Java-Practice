package com.queue;

public class QueueArray<T> {

    private T[] circularArray;
    private int read, write = 0;

    public QueueArray(int capacity) {
        this.circularArray = (T[]) new Object[capacity];
    }

    public void enqueue(T value) {
        if (read < write || empty()) {
            write = (write == circularArray.length ? (write % circularArray.length) - 1 : write);
            circularArray[write++] = value;
        }
    }

    public T dequeue() {
        read = (read == circularArray.length ? (read % circularArray.length) - 1 : read);
        return circularArray[read++];
    }

    public boolean empty() {
        return full();
    }

    public boolean full() {
        return read == write;
    }

}
