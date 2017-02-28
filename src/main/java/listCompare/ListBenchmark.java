package listCompare;

import java.util.*;

/**
 * Created by Egor on 26-Feb-17.
 */
public class ListBenchmark {
    public static List<Integer> insertElementsAtHead(int elementsCount, List<Integer> list) {
        long start = System.nanoTime();

        for (int i = 0; i < elementsCount; i++) {
            list.add(0, new Integer(1));
        }

        long stop = System.nanoTime();
        System.out.println("Elapsed insertElementsAtHead(" + elementsCount + "):" + (stop - start));

        return list;
    }

    public static List<Integer> insertElementsAtMiddle(int elementsCount, List<Integer> list) {
        long start = System.nanoTime();

        for (int i = 0; i < elementsCount; i++) {
            list.add((i + 1) / 2, new Integer(1));
        }

        long stop = System.nanoTime();
        System.out.println("Elapsed insertElementsAtMiddle(" + elementsCount + "):" + (stop - start));

        return list;
    }

    public static List<Integer> insertElementsAtEnd(int elementsCount, List<Integer> list) {
        long start = System.nanoTime();

        for (int i = 0; i < elementsCount; i++) {
            list.add(i, new Integer(1));
        }

        long stop = System.nanoTime();
        System.out.println("Elapsed insertElementsAtEnd(" + elementsCount + "):" + (stop - start));

        return list;
    }

    public static void deleteElementsAtHead(int elementsCount, List<Integer> list) {
        long start = System.nanoTime();

        for (int i = 0; i < elementsCount; i++) {
            list.remove(0);
        }

        long stop = System.nanoTime();
        System.out.println("Elapsed deleteElementsAtHead(" + elementsCount + "):" + (stop - start));
    }

    public static void deleteElementsAtMiddle(int elementsCount, List<Integer> list) {
        long start = System.nanoTime();

        for (int i = elementsCount - 1; i >= 0; i--) {
            list.remove((i + 1) / 2);
        }

        long stop = System.nanoTime();
        System.out.println("Elapsed deleteElementsAtMiddle(" + elementsCount + "):" + (stop - start));
    }

    public static void deleteElementsAtEnd(int elementsCount, List<Integer> list) {
        long start = System.nanoTime();

        for (int i = elementsCount - 1; i >= 0; i--) {
            list.remove(i);
        }

        long stop = System.nanoTime();
        System.out.println("Elapsed deleteElementsAtEnd(" + elementsCount + "):" + (stop - start));
    }

    public static void setElementsAtHead(int elementsCount, List<Integer> list) {
        long start = System.nanoTime();

        for (int i = 0; i < elementsCount; i++) {
            list.set(0, new Integer(0));
        }

        long stop = System.nanoTime();
        System.out.println("Elapsed setElementsAtHead(" + elementsCount + "):" + (stop - start));
    }

    public static void setElementsAtMiddle(int elementsCount, List<Integer> list) {
        long start = System.nanoTime();

        for (int i = elementsCount - 1; i >= 0; i--) {
            list.set((i + 1) / 2, new Integer(0));
        }

        long stop = System.nanoTime();
        System.out.println("Elapsed setElementsAtMiddle(" + elementsCount + "):" + (stop - start));
    }

    public static void setElementsAtEnd(int elementsCount, List<Integer> list) {
        long start = System.nanoTime();

        for (int i = elementsCount - 1; i >= 0; i--) {
            list.set(i, new Integer(0));
        }

        long stop = System.nanoTime();
        System.out.println("Elapsed setElementsAtEnd(" + elementsCount + "):" + (stop - start));
    }

    public static void getElementsAtHead(int elementsCount, List<Integer> list) {
        long start = System.nanoTime();

        for (int i = 0; i < elementsCount; i++) {
            list.get(0);
        }

        long stop = System.nanoTime();
        System.out.println("Elapsed getElementsAtHead(" + elementsCount + "):" + (stop - start));
    }

    public static void getElementsAtMiddle(int elementsCount, List<Integer> list) {
        long start = System.nanoTime();

        for (int i = elementsCount - 1; i >= 0; i--) {
            list.get((i + 1) / 2);
        }

        long stop = System.nanoTime();
        System.out.println("Elapsed getElementsAtMiddle(" + elementsCount + "):" + (stop - start));
    }

    public static void getElementsAtEnd(int elementsCount, List<Integer> list) {
        long start = System.nanoTime();

        for (int i = elementsCount - 1; i >= 0; i--) {
            list.get(i);
        }

        long stop = System.nanoTime();
        System.out.println("Elapsed getElementsAtEnd(" + elementsCount + "):" + (stop - start));
    }
}
