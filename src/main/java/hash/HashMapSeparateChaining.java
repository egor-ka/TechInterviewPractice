package hash;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Egor on 07-Mar-17.
 */
public class HashMapSeparateChaining {
    private static final int MAP_CAPACITY = 5;

    private List<List<Pair<String, Integer>>> separateChainMap;

    HashMapSeparateChaining() {
        separateChainMap = new ArrayList<>(MAP_CAPACITY);
        for (int i = 0; i < MAP_CAPACITY; i++) {
            separateChainMap.add(new LinkedList<>());
        }
    }

    public boolean put(Pair<String, Integer> element) {
        List<Pair<String, Integer>> list = separateChainMap.get(hash(element.getKey()));
        for (Pair<String, Integer> pair: list) {
            if (pair.getKey().equals(element.getKey())) {
                return false;
            }
        }
        return list.add(element);
    }

    public Integer get(String key) {
        List<Pair<String, Integer>> list = separateChainMap.get(hash(key));
        for (Pair<String, Integer> pair : list) {
            if (pair.getKey().equals(key)) {
                return pair.getValue();
            }
        }
        return null;
    }

    public void delete(String key) {
        List<Pair<String, Integer>> list = separateChainMap.get(hash(key));
        for (Pair<String, Integer> pair : list) {
            if (pair.getKey().equals(key)) {
                list.remove(pair);
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
