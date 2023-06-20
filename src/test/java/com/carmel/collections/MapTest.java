package com.carmel.collections;

import org.assertj.core.data.MapEntry;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapTest {

    @Test
    void maps(){
        Map<String, Integer> map = new HashMap<>();
        Map<String, String> tree = new TreeMap<>(); // Order guarantied. All keys inserted into the map must implement the Comparable interface

        // SortedMap also exists

        map.put("abc", Integer.valueOf(1));
        map.put("abc", 0); // will replace the first value
        map.put(null, 123); // null is a valid key
        Integer oldValue = map.replace("abc",4); // a cool way to update key and get old value in one line

        Map<String, Integer> newMap = new HashMap<>(map); // the same is possible with newMap.putAll(map);

        int length =  map.size(); // length of map entries
        map.remove("abc");
        map.containsKey("abc");
        map.clear();

        newMap.forEach((key, value) -> System.out.println("do what ever you like with key and value"));
        // or
        for(Map.Entry<String, Integer> entry: map.entrySet()){
            entry.getKey();
            entry.getValue();
        }

        map.entrySet().stream().filter((entry) -> entry.getValue() > 0 ); // filter your map with streams
    }
}
