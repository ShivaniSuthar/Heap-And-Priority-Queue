import org.junit.Test;
import static org.junit.Assert.*;
import java.util.NoSuchElementException;


public class dHeapTester {

    dHeap emptyHeap = new dHeap();
    dHeap maxHeap = new dHeap(2, 3, true);
    dHeap minHeap = new dHeap(3, 4, false);
    dHeap maxD4 = new dHeap(4, 6, true);

    @Test (expected = IllegalArgumentException.class)
    public void constructor1() {
        dHeap emptyHeap = new dHeap(0, 3, true);
    }
    @Test (expected = IllegalArgumentException.class)
    public void constructor2() {
        dHeap emptyHeap = new dHeap(0, 3, false);
    }
    @Test (expected = IllegalArgumentException.class)
    public void constructor3() {
        dHeap emptyHeap = new dHeap(-1, 3, true);
    }
    @Test (expected = IllegalArgumentException.class)
    public void constructor4() {
        dHeap emptyHeap = new dHeap(-1, 3, false);
    }
    @Test (expected = IllegalArgumentException.class)
    public void constructor5() {
        dHeap emptyHeap = new dHeap(0, 6, true);
    }
    @Test (expected = IllegalArgumentException.class)
    public void constructor6() {
        dHeap emptyHeap = new dHeap(0, 6, false);
    }
    @Test (expected = IllegalArgumentException.class)
    public void constructor7() {
        dHeap emptyHeap = new dHeap(0, 50, true);
    }
    @Test (expected = IllegalArgumentException.class)
    public void constructor8() {
        dHeap emptyHeap = new dHeap(0, 50, false);
    }
    @Test (expected = IllegalArgumentException.class)
    public void constructor9() {
        dHeap emptyHeap = new dHeap(0, 0, false);
    }

    //testing the size method:
    @Test
    public void sizeTests() {
        
        assertEquals(0, emptyHeap.size());
        emptyHeap.add(2);
        
        assertEquals(1, emptyHeap.size());
        emptyHeap.remove();
        
        assertEquals(0, emptyHeap.size());
        emptyHeap.add(5);
        
        assertEquals(1, emptyHeap.size());
        minHeap.add(1);
        
        assertEquals(1, minHeap.size());
        maxHeap.add(1);
        
        assertEquals(1, maxHeap.size());
        maxD4.add(1);
       
        assertEquals(1, maxD4.size());
    }

    //testing the add method's NPE (adding null data):
    @Test (expected = NullPointerException.class)
    public void addExceptionTest() {
        maxD4.add(null);
    }

    //testing the add method:
    @Test
    public void addTests() {
        maxHeap.clear();
        maxHeap.add(2);
        maxHeap.add(6);
        maxHeap.add(4);
        maxHeap.add(50);
        maxHeap.add(1);
        maxHeap.add(0);
        
        assertEquals(50, maxHeap.element());
        
        assertEquals(6, maxHeap.size());

        minHeap.clear();
        minHeap.add(2);
        minHeap.add(6);
        minHeap.add(4);
        minHeap.add(50);
        minHeap.add(1);
        minHeap.add(0);
        
        assertEquals(0, minHeap.element());
        
        assertEquals(6, minHeap.size());

        emptyHeap.clear();
        emptyHeap.add(2);
        emptyHeap.add(6);
        emptyHeap.add(4);
        emptyHeap.add(50);
        emptyHeap.add(1);
        emptyHeap.add(0);
        
        assertEquals(50, emptyHeap.element());
        
        assertEquals(6, emptyHeap.size());

        maxD4.clear();
        maxD4.add(2);
        maxD4.add(6);
        maxD4.add(4);
        maxD4.add(50);
        maxD4.add(1);
        maxD4.add(0);
        maxD4.remove();
       
        assertEquals(6, maxD4.element());
        
        assertEquals(5, maxD4.size());
    }

    //testing the remove method's NSE (removing from an empty heap):
    @Test (expected = NoSuchElementException.class)
    public void sizeExceptionTest() {
        emptyHeap.remove();
    }

    //testing the remove method:
    @Test
    public void removeTests() {
        maxHeap.clear();
        maxHeap.add(5);
        maxHeap.remove();
        
        assertEquals(0, maxHeap.size());

        minHeap.clear();
        minHeap.add(6);
        minHeap.add(0);
        minHeap.remove();
        
        assertEquals(1, minHeap.size());

        maxD4.clear();
        maxD4.add(5);
        maxD4.add(1000);
        maxD4.remove();
        
        assertEquals(5, maxD4.element());
    }

    //testing the clear method:
    @Test
    public void clearTests() {
        maxHeap.add(2);
        maxHeap.add(3);
        maxHeap.add(1);
        maxHeap.clear();
       
        assertEquals(0, maxHeap.size());

        minHeap.add(2);
        minHeap.add(3);
        minHeap.add(1);
        minHeap.clear();
       
        assertEquals(0, minHeap.size());

        emptyHeap.add(2);
        emptyHeap.add(3);
        emptyHeap.add(1);
        emptyHeap.clear();
        
        assertEquals(0, emptyHeap.size());
    }

    //testing the element method's NSE (if the heap is empty):
    @Test (expected = NoSuchElementException.class)
    public void elementExceptionTest() {
        emptyHeap.element();
    }

    //testing the element method:
    @Test
    public void elementTests() {
        maxD4.clear();
        maxD4.add(1);
        maxD4.add(5);
        maxD4.remove();
        maxD4.add(100);
        maxD4.remove();
        
        assertEquals(1, maxD4.element());

        minHeap.clear();
        minHeap.add(1);
        minHeap.add(5);
        minHeap.remove();
        minHeap.add(100);
        minHeap.remove();
        
        assertEquals(100, minHeap.element());

        emptyHeap.clear();
        emptyHeap.add(1);
        emptyHeap.add(5);
        emptyHeap.remove();
        emptyHeap.add(100);
        emptyHeap.remove();
       
        assertEquals(1, emptyHeap.element());
    }
}
