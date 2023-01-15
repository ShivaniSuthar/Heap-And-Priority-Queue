

/**
 * Heap Sort implementation
 *
 */
public class HeapSort {

    private static final int BINARY = 2;

    /**
     * Sorting algorithm that uses the heap structure to sort the input integer array
     * @param arr The integer array
     * @param start The place to start sorting (an int)
     * @param end The place to end sorting (an int)
     */
    public static void heapSort(int[] arr, int start, int end) {
        dHeap<Integer> heap = new dHeap<Integer>(BINARY, end-start + 1, false);
        //adding numbers from start to end to heap
        for (int i = start; i <= end; i++) {
            heap.add(arr[i]);
        }
        //assigning arr[i] to heap.remove()
        for (int i = start; i <= end; i++) {
            arr[i] = heap.remove();
        }
    }
}
