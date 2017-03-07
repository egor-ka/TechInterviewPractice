package hash;

import javafx.util.Pair;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Egor on 07-Mar-17.
 */
public class HashMapSeparateChainingTest {

    private HashMapSeparateChaining hashMap;
    private String keyOne;
    private String keyTwo;

    @Before
    public void setUp() {
        hashMap = new HashMapSeparateChaining();
        keyOne = "KEY_ONE";
        keyTwo = "KEY_TWO";
    }

    @Test
    public void test() {
        Pair<String, Integer> pairOne = new Pair<>(keyOne, 1);
        Pair<String, Integer> pairTwo = new Pair<>(keyTwo, 2);
        Pair<String, Integer> duplicateKeyPair = new Pair<>(keyOne, 3);

        assertTrue(hashMap.put(pairOne));
        assertTrue(hashMap.put(pairTwo));
        assertFalse(hashMap.put(duplicateKeyPair));

        assertEquals(new Integer(1), hashMap.get(keyOne));
        assertEquals(new Integer(2), hashMap.get(keyTwo));

        hashMap.delete(keyOne);
        assertEquals(null, hashMap.get(keyOne));
    }
}