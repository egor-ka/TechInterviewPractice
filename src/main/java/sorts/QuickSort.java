package sorts;

import java.util.*;

/**
 * Created by Egor on 02-Mar-17.
 */
public class QuickSort {
    public static void doSort(int[] array) {
        Queue<int[]> queue = new LinkedList<>();
        int[] start = {0, array.length - 1};
        queue.add(start);

        int left, right, pivot;

        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            left = pair[0];
            right = pair[1];
            pivot = right;

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
                int[] borders = {left, pivot - 1};
                queue.add(borders);
            }
            if (right - pivot > 1) {
                int[] borders = {pivot + 1, right};
                queue.add(borders);
            }
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
