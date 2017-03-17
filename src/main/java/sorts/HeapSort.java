package sorts;

public class HeapSort {

    public static void doSort(int[] array) {
        buidlMaxHeap(array);
        int heapSize = array.length;
        for (int i = heapSize - 1; i > 0; i--) {
            swap(array, 0, i);
            heapSize--;
            maxHeapify(array, 0, heapSize);
        }
    }
    
    private static void buidlMaxHeap(int[] array) {
        for (int i = array.length / 2; i >= 0; i--) {
            maxHeapify(array, i, array.length);
        }
    }

    private static void maxHeapify(int[] array, int index, int heapSize) {
        if (heapSize == 1) {
            return;
        }
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int largest = index;
        if (left < heapSize && array[left] > array[index]) {
            largest = left;
        }
        if (right < heapSize && array[right] > array[largest]) {
            largest = right;
        }
        if (largest != index) {
            swap(array, index, largest);
            maxHeapify(array, largest, heapSize);
        }
    }

    private static void swap(int[] array, int indexOne, int indexTwo) {
        int tmp = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] =  tmp;
    }
}
