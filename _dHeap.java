
import java.util.*;

/**
 * dHeap implementation
 * @param <T> Generic type
 *
 */
public class dHeap<T extends Comparable<? super T>> implements dHeapInterface<T> {

    private T[] heap; // heap array
    private int d; // branching factor
    private int nelems; // number of elements
    private boolean isMaxHeap; // boolean to indicate whether heap is max or min
    private int heapSize;
    private static final int DEFAULT_SIZE = 6;
    private static final int BINARY = 2;
    private static final int ADD_FACTOR = 2;
    private static final int RESIZE_MULTIPLIER = 2;

    /**
     * Initializes a binary max heap with capacity = 6
     */
    @SuppressWarnings("unchecked")
    public dHeap() {
        this(BINARY, DEFAULT_SIZE, true);
    }

    /**
     * Initializes a binary max heap with a given initial capacity.
     *
     * @param heapSize The initial capacity of the heap.
     */
    @SuppressWarnings("unchecked")
    public dHeap(int heapSize) {
        this(BINARY, heapSize, true);
    }

    /**
     * Initializes a d-ary heap (with a given value for d), with a given initial
     * capacity.
     *
     * @param d         The number of child nodes each node in the heap should have.
     * @param heapSize  The initial capacity of the heap.
     * @param isMaxHeap indicates whether the heap should be max or min
     * @throws IllegalArgumentException if d is less than one.
     */
    @SuppressWarnings("unchecked")
    public dHeap(int d, int heapSize, boolean isMaxHeap) throws IllegalArgumentException {
        //throws IAE if d is < 1
        if (d < 1) {
            throw new IllegalArgumentException();
        }
        heap = (T[]) new Comparable[heapSize];
        nelems = 0;
        this.d = d;
        this.heapSize = heapSize;
        this.isMaxHeap = isMaxHeap;
    }

    /**
     * This returns the number of elements stored in the heap
     * @return Returns the number of elements stored in the heap
     */
    @Override
    public int size() {
        return nelems;
    }

    /**
     * This adds the given data to the heap
     * @param data The given data
     * @throws NullPointerException thrown if data is null
     */
    @Override
    public void add(T data) throws NullPointerException {
        //throws NPE if data is null
        if (data == null) {
            throw new NullPointerException();
        }
        //doubles the size of array if full
        if (nelems == heapSize) {
            resize();
        }
        //adding the data to the heap
        heap[nelems] = data;
        nelems = nelems + 1;
        bubbleUp(nelems - 1);
    }

    /**
     * This returns and removes the root element from the heap
     * @return Returns and removes the root element from the heap
     * @throws NoSuchElementException thrown if the heap is empty
     */
    @Override
    public T remove() throws NoSuchElementException {
        //if nelems is 0, NSEE thrown
        if (nelems == 0) {
            throw new NoSuchElementException();
        }
        T returnValue = heap[0];
        //shifts the heap to the left one position
        for (int i = 1; i < heap.length; i++) {
            heap[i-1] = heap[i];
        }
        //returning the root element
        nelems = nelems - 1;
        trickleDown(0);
        return returnValue;
    }

    /**
     * Clears all elements in the heap.
     */
    @SuppressWarnings("unchecked")
    @Override
    public void clear() {
        T[] array = (T[]) new Comparable[heapSize];
        nelems = 0;
    }

    /**
     * This returns the root element of the heap
     * @return Returns the root element of the heap
     * @throws NoSuchElementException thrown if the heap is empty
     */
    public T element() throws NoSuchElementException {
        //if nelems is 0, NSEE thrown
        if (nelems == 0) {
            throw new NoSuchElementException();
        }
        //returning the root element
        return heap[0];
    }

    /**
     * Helps the implementation for removing a node at index
     * @param index Specifies the index at which to remove a node
     */
    private void trickleDown(int index) {
        //checks if the index is greater than or equal
        // to the number of elements. If so, returns
        if (index >= nelems) {
            return;
        }
        //setting variable for an extreme (max or min) child
        int extremeChild = d*index+1;
        //checking if the extreme (max or min) child is greater than or equal to nelems
        if (extremeChild >= nelems) {
            return;
        }
        //implementation if parent is not greater than child
        for (int child = d*index+ADD_FACTOR; child <= d*index+d; child++) {
            if (child < nelems && !compareCorrect(heap[extremeChild], heap[child])) {
                extremeChild = child;
            }
        }
        //implementation if parent is greater than child
        if (!compareCorrect(heap[index], heap[extremeChild])) {
            T temp = heap[extremeChild];
            heap[extremeChild] = heap[index];
            heap[index] = temp;
        }
        //recursive call to TrickleDown
        for (int child = d*index+1; child <= d*index+d; child++) {
            trickleDown(child);
        }
    }

    /**
     * Helps the implementation for inserting a node
     * @param index Specifies the index at which to continue bubbling up
     */
    private void bubbleUp(int index) {
        if (index <= 0) {
            return;
        }
        int pIndex = parent(index);
        //implementation for switching elements if necessary when bubbling up
        if (!compareCorrect(heap[pIndex], heap[index])) {
            T temp = heap[pIndex];
            heap[pIndex] = heap[index];
            heap[index] = temp;
            //recursive call to bubble up
            if (pIndex > 0) {
                bubbleUp(pIndex);
            }
        }
    }

    /**
     * This doubles the size of array before adding if is full
     */
    @SuppressWarnings("unchecked")
    private void resize() {
        heapSize *= RESIZE_MULTIPLIER;
        T[] temp = (T[]) new Comparable[heapSize];
        //assigning values to temp[i]
        for (int i = 0; i < heap.length; i++) {
            temp[i] = heap[i];
        }
        heap = temp;
    }

    /**
     * This finds the index of parent
     * @param index Specifies the index to find
     * @return returns the index of the parent
     */
    private int parent(int index) {
        return (index - 1)/d;
    }

    /**
     * Helper method to differentiate between a min-dHeap and a max-dHeap
     * @param p Represents the "parent"
     * @param c Represents the "child"
     * @return Returns a boolean, true if max heap
     */
    private boolean compareCorrect(T p, T c) {
        //if isMaxHeap is true, returns true
        if (isMaxHeap) {
            return c.compareTo(p) < 0;
        }
        //else, returns false
        else {
            return c.compareTo(p) > 0;
        }
    }
}
