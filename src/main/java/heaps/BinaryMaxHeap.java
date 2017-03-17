package heaps;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryMaxHeap {

    List<Integer> heap = new ArrayList<>();

    public void insert(Integer value) {
        heap.add(heap.size(), value);
        swim();
    }

    public Integer peek() {
        return heap.get(0);
    }

    //if element is found returns it's index, or -1 if not
    public int search(Integer value) {
        Deque<Integer> stack = new LinkedList<>();
        stack.add(0);

        int index;
        while (!stack.isEmpty()) {
            index = stack.poll();
            if (index > heap.size() || heap.get(index) < value) {
                continue;
            }
            stack.add(2 * index + 1);
            stack.add(2 * index + 2);
            if (heap.get(index) == value) {
                return index;
            }
        }
        return -1;
    }

    public Integer delMax() {
        Integer tmp = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        sink();
        return tmp;
    }

    public boolean isEmpty() {
        return heap.size() > 0;
    }

    private void swim() {
        int index = heap.size() - 1;
        int parentIndex;
        while (true) {
            parentIndex = (index - 1) / 2;
            if (heap.get(parentIndex) < heap.get(index)) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                return;
            }
        }
    }

    private void sink() {
        int index = 0;
        int left;
        int right;
        int largest = index;

        while (index < heap.size()) {
            left = 2 * index + 1;
            right = 2 * index + 2;
            if (left < heap.size() && heap.get(left) > heap.get(index)) {
                largest = left;
            }
            if (right < heap.size() && heap.get(right) > heap.get(largest)) {
                largest = right;
            }
            if (largest != index) {
                swap(index, largest);
                index = largest;
            } else {
                return;
            }
        }
    }

    private void swap(int indexOne, int indexTwo) {
        Integer tmp = heap.get(indexOne);
        heap.set(indexOne, heap.get(indexTwo));
        heap.set(indexTwo, tmp);
    }
}
