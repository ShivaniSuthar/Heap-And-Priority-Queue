
/**
 * MyPriorityQueue implementation
 * @param <T> Generic type
 *
 */
public class MyPriorityQueue<T extends Comparable<? super T>> {

    private dHeap<T> pQueue;
    private static final int FIVE_ARY = 5;

    /**
     * Constructor that creates a new priority queue
     * 
     * @param initialSize the given size
     */
    public MyPriorityQueue(int initialSize) {
        pQueue = new dHeap<T>(FIVE_ARY, initialSize, true);
    }

    /**
     * Inserts an element into the Priority Queue. The element received cannot be
     * null.
     *
     * @param element Element to be inserted.
     * @throws NullPointerException if the element received is null.
     * @return returns true
     */
    public boolean offer(T element) throws NullPointerException {
        pQueue.add(element);
        return true;
    }

    /**
     * Retrieves the head of this Priority Queue (largest element), or null if the
     * queue is empty.
     *
     * @return The head of the queue (largest element), or null if queue is empty.
     */
    public T poll() {
        //returns null if size is zero
        if (pQueue.size() == 0) {
            return null;
        }
        //else, retrieves head
        else {
            return pQueue.remove();
        }
    }

    /**
     * Clears the contents of the queue
     */
    public void clear() {
        pQueue.clear();
    }

    /**
     * Retrieves, but does not remove, the head of this queue, or returns null if
     * this queue is empty.
     * 
     * @return the next item to be removed, null if the queue is empty
     */
    public T peek() {
        //returns null if size is 0
        if (pQueue.size() == 0) {
            return null;
        }
        //else retrieves head
        else {
            return pQueue.element();
        }
    }

    /**
     * Indicates whether the queue is empty.
     * @return true is the queue is empty, false otherwise
     */
    public boolean isEmpty() {
        return pQueue.size() == 0;
    }

}
