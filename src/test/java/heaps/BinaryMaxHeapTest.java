package heaps;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryMaxHeapTest {

    @Test
    public void test() {
        BinaryMaxHeap heap = new BinaryMaxHeap();

        assertFalse(heap.isEmpty());

        // delete from empty heap
        assertNull(heap.delMax());

        // peek in empty heap
        assertNull(heap.peek());

        // search in empty heap
        assertEquals(-1, heap.search(0));

        heap.insert(5);
        heap.insert(6);
        heap.insert(7);
        heap.insert(8);
        heap.insert(9);

        // search element that is not in heap
        assertEquals(-1, heap.search(0));

        assertEquals((Integer)9, heap.peek());

        assertEquals(0, heap.search(9));
        assertEquals(1, heap.search(8));
        assertEquals(2, heap.search(6));
        assertEquals(3, heap.search(5));
        assertEquals(4, heap.search(7));

        heap.delMax();
        assertEquals((Integer)8, heap.peek());
    }

}