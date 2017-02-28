package listsCompare;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static listCompare.ListBenchmark.*;

/**
 * Created by Egor on 28-Feb-17.
 */
public class ListBenchmarkTest {

    @Test
    public void testBenchmark() {
        List<Integer> arraysLengths = Arrays.asList(1000, 100000);

        List<Integer> arrayList, linkedList;

        for (int length: arraysLengths) {
            //Operations at the beginning of the list
            System.out.println("ArrayList");
            arrayList = insertElementsAtHead(length, new ArrayList<>());
            System.out.println("LinkedList");
            linkedList = insertElementsAtHead(length, new LinkedList<>());

            System.out.println("ArrayList");
            setElementsAtHead(length, arrayList);
            System.out.println("LinkedList");
            setElementsAtHead(length, linkedList);

            System.out.println("ArrayList");
            getElementsAtHead(length, arrayList);
            System.out.println("LinkedList");
            getElementsAtHead(length, linkedList);

            System.out.println("ArrayList");
            deleteElementsAtHead(length, arrayList);
            System.out.println("LinkedList");
            deleteElementsAtHead(length, linkedList);

            // Operations at the middle of the list
            System.out.println("ArrayList");
            arrayList = insertElementsAtMiddle(length, new ArrayList<>());
            System.out.println("LinkedList");
            linkedList = insertElementsAtMiddle(length, new LinkedList<>());

            System.out.println("ArrayList");
            setElementsAtMiddle(length, arrayList);
            System.out.println("LinkedList");
            setElementsAtMiddle(length, linkedList);

            System.out.println("ArrayList");
            getElementsAtMiddle(length, arrayList);
            System.out.println("LinkedList");
            getElementsAtMiddle(length, linkedList);

            System.out.println("ArrayList");
            deleteElementsAtMiddle(length, arrayList);
            System.out.println("LinkedList");
            deleteElementsAtMiddle(length, linkedList);

            // Operations at the end of the list
            System.out.println("ArrayList");
            arrayList = insertElementsAtEnd(length, new ArrayList<>());
            System.out.println("LinkedList");
            linkedList = insertElementsAtEnd(length, new LinkedList<>());

            System.out.println("ArrayList");
            setElementsAtEnd(length, arrayList);
            System.out.println("LinkedList");
            setElementsAtEnd(length, linkedList);

            System.out.println("ArrayList");
            getElementsAtEnd(length, arrayList);
            System.out.println("LinkedList");
            getElementsAtEnd(length, linkedList);

            System.out.println("ArrayList");
            deleteElementsAtEnd(length, arrayList);
            System.out.println("LinkedList");
            deleteElementsAtEnd(length, linkedList);
        }
    }
}
