package sorts;

/**
 * Created by Egor on 28-Feb-17.
 */
public class RecursiveBubbleSort {
    public static void doSort(int[] array) {
        recursiveSort(array, array.length);
    }

    private static void recursiveSort(int[] array, int length) {
        if (length < 1) {
            return;
        }
        for (int i = 0; i < length - 1; i++) {
            if (array[i] > array[i + 1]) {
                swapWithNext(array, i);
            }
        }
        recursiveSort(array, length - 1);
    }

    private static void swapWithNext(int[] array, int pos) {
        int tmp = array[pos];
        array[pos] = array[pos + 1];
        array[pos + 1] = tmp;
    }
}
