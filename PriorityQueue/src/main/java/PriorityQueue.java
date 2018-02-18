import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class PriorityQueue<T> implements Iterable<T> {

    private Comparator<T> comparator;  // optional comparator
    private T[] pq;
    private int n = 0;

    public PriorityQueue(int capacity) {
        pq = (T[]) new Object[capacity + 1];
    }

    public PriorityQueue(int initCapacity, Comparator<T> comparator) {
        this.comparator = comparator;
        pq = (T[]) new Object[initCapacity + 1];
        n = 0;
    }

    public void insert(T item) {
        // check capacity and if needed do a resize
        if (n == pq.length - 1) resize(2 * pq.length);

        // add item to pq and put it in place
        pq[++n] = item;
        siftUp(n);
    }

    // - returns the max item, without removing it
    public T getMax() {
        return pq[1];
    }

    // - return number of elements stored
    public int getSize() {
        return n;
    }

    //  - returns the max item, removing it
    public T extractMax() {
        T maxItem = pq[1];
        exch(1, n--);
        siftDown(1);
        pq[n + 1] = null;
        // resize of capacity is at 25%
        if ((n > 0) && (n == (pq.length - 1) / 4)) resize(pq.length / 2);
        return maxItem;
    }

    // - needed for insert
    private void siftUp(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }

    // - needed for extract_max
    private void siftDown(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(j, j + 1)) j++;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    private void siftDown(T[] pq, int k, int n) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(pq, j, j + 1)) j++;
            if (!less(pq, k, j)) break;
            exch(pq, k, j);
            k = j;
        }
    }

    // - removes item at index x
    public T remove(int i) {
        T maxItem = pq[i];
        exch(i, n--);
        siftDown(i);
        pq[n + 1] = null;
        // resize of capacity is at 25%
        if ((n > 0) && (n == (pq.length - 1) / 4)) resize(pq.length / 2);
        return maxItem;
    }

    // - take an unsorted array and turn it into a sorted array in-place using a max heap
    public void heapSort(T[] items) {
        int n = items.length;
        heapify(items);
        while (n > 1) {
            exch(items, 1, n--);
            siftDown(items, 1, n);
        }
    }

    // - create a heap from an array of elements, needed for heap_sort
    private void heapify(T[] items) {
        int n = items.length;
        for (int k = n / 2; k >= 1; k--)
            siftDown(items, k, n);
    }

    private boolean less(T[] pq, int i, int j) {
        if (comparator == null) {
            return ((Comparable<T>) pq[i]).compareTo(pq[j]) < 0;
        } else {
            return comparator.compare(pq[i], pq[j]) < 0;
        }
    }

    private boolean less(int i, int j) {
        if (comparator == null) {
            return ((Comparable<T>) pq[i]).compareTo(pq[j]) < 0;
        } else {
            return comparator.compare(pq[i], pq[j]) < 0;
        }
    }

    private void exch(T[] pq, int i, int j) {
        T swap = pq[i - 1];
        pq[i - 1] = pq[j - 1];
        pq[j - 1] = swap;
    }

    private void exch(int i, int j) {
        T swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

    public Iterator<T> iterator() {
        return new HeapIterator();
    }

    public boolean isEmpty() {
        return n == 0;
    }


    private class HeapIterator implements Iterator<T> {

        private PriorityQueue<T> copy;

        public HeapIterator() {
            if (comparator == null) copy = new PriorityQueue<>(getSize());
            else copy = new PriorityQueue<>(getSize(), comparator);
            for (int i = 1; i <= n; i++)
                copy.insert(pq[i]);
        }

        public boolean hasNext() {
            return !copy.isEmpty();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            return copy.extractMax();
        }
    }

    // helper function to double the size of the heap array
    private void resize(int capacity) {
        assert capacity > n;
        T[] temp = (T[]) new Object[capacity];
        for (int i = 1; i <= n; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }

}
