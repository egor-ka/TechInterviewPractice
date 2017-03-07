package hash;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Egor on 07-Mar-17.
 */
public class HashMapLinearProbing {
    private static final int MAP_CAPACITY = 10;

    private List<Pair<String, Integer>> linearProbingMap;

    HashMapLinearProbing() {
        linearProbingMap = new ArrayList<>(MAP_CAPACITY);
        for (int i = 0; i < MAP_CAPACITY; i++) {
            linearProbingMap.add(null);
        }
    }

    public boolean put(Pair<String, Integer> element) {
        Pair<String, Integer> currentElement;
        int hashValue = hash(element.getKey());
        int i = hashValue;
        while (true) {
            currentElement = linearProbingMap.get(i);
            if (currentElement != null && currentElement.getKey().equals(element.getKey())) {
                return false;
            }
            if (currentElement == null) {
                linearProbingMap.set(i, element);
                return true;
            }
            i++;
            if (i == MAP_CAPACITY) {
                i = 0;
            }
            if (i == hashValue) {
                return false;
            }
        }
    }

    public Integer get(String key) {
        Pair<String, Integer> currentElement;
        int hashValue = hash(key);
        int i = hashValue;
        while (true) {
            currentElement = linearProbingMap.get(i);
            if (currentElement != null && currentElement.getKey().equals(key)) {
                return currentElement.getValue();
            }
            i++;
            if (i == MAP_CAPACITY) {
                i = 0;
            }
            if (i == hashValue) {
                return null;
            }
        }
    }

    public void delete(String key) {
        Pair<String, Integer> currentElement;
        int hashValue = hash(key);
        int i = hashValue;
        while (true) {
            currentElement = linearProbingMap.get(i);
            if (currentElement != null && currentElement.getKey().equals(key)) {
                linearProbingMap.set(i, null);
                return;
            }
            i++;
            if (i == MAP_CAPACITY) {
                i = 0;
            }
            if (i == hashValue) {
                return;
            }
        }
    }

    private int hash(String key) {
        int hash = 0;
        char val[] = key.toCharArray();

        for (int i = 0; i < key.length(); i++) {
            hash += val[i];
        }
        return hash % MAP_CAPACITY;
    }
}
