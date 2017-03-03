package sorts;

import org.junit.Test;


/**
 * Created by Egor on 03-Mar-17.
 */
public class RecursiveQuickSortTest {
    @Test
    public void testSort() {
        int[] array = {7, 2, 0, 9, 10, 8, 3, 6, 5, 4, 1};

        RecursiveQuickSort.doSort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
