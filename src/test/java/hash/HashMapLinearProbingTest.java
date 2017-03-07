package hash;

import javafx.util.Pair;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Egor on 07-Mar-17.
 */
public class HashMapLinearProbingTest {

    private HashMapLinearProbing hashMap;
    private String keyOne;
    private String keyTwo;

    @Before
    public void setUp() {
        hashMap = new HashMapLinearProbing();
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

        hashMap.put(new Pair<>("poiuiodsdf", 8));
        hashMap.put(new Pair<>("mjhghfghsdf", 18));
        hashMap.put(new Pair<>("aqwegfhgfghsdf", 28));
        hashMap.put(new Pair<>("gfdsaaert", 38));
        hashMap.put(new Pair<>("trtdfdfydsdf", 48));
        hashMap.put(new Pair<>("xvcbdsdf", 58));
        hashMap.put(new Pair<>("erertydsdf", 78));
        hashMap.put(new Pair<>("qwdfdfdffdfddsdf", 88));

        assertFalse(hashMap.put(new Pair<>("EXCEED_CAPACITY", 666)));

        assertEquals(new Integer(1), hashMap.get(keyOne));
        assertEquals(new Integer(2), hashMap.get(keyTwo));

        hashMap.delete(keyOne);
        assertEquals(null, hashMap.get(keyOne));
    }
}