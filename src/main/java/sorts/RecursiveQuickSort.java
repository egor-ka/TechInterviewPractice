package sorts;

/**
 * Created by Egor on 02-Mar-17.
 */
public class RecursiveQuickSort {

    public static void doSort(int[] array) {
        recursiveSort(array, 0, array.length - 1);
    }

    private static void recursiveSort(int[] array, int left, int right) {
        int pivot = right;

        for (int l = left; l < pivot; ) {
            if (array[l] <= array[pivot]) {
                l++;
            } else {
                if (l == pivot - 1) {
                    swap(array, l, pivot);
                } else {
                    swap(array, l, pivot - 1, pivot);
                }
                pivot--;
            }
        }
        if (pivot - left > 1) {
            recursiveSort(array, left, pivot - 1);
        }
        if (right - pivot > 1) {
            recursiveSort(array, pivot + 1, right);
        }
    }

    // shift down (3 -> 2, 2 -> 1, 1 -> 3)
    private static void swap(int[] array, int posOne, int posTwo, int posThree) {
        int tmp = array[posOne];
        array[posOne] = array[posTwo];
        array[posTwo] = array[posThree];
        array[posThree] = tmp;
    }

    private static void swap(int[] array, int posOne, int posTwo) {
        int tmp = array[posOne];
        array[posOne] = array[posTwo];
        array[posTwo] = tmp;
    }
}
