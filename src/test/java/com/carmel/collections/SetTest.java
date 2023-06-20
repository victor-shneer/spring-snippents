package com.carmel.collections;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;

public class SetTest {

    @Test
    void sets(){
        // no order, no duplicates
        Set<String> set = new HashSet<>();

        set.add("Hello"); //returns a boolean
        set.add("Buy"); //returns a boolean
        set.add("Shalom"); //returns a boolean
        set.add("Erev tov"); //returns a boolean

        boolean added = set.add("Hello"); // added == false
        boolean removed = set.add("Hello"); // removed == true
        set.addAll(Set.of("1","2","3","4")); // add batch
        set.forEach(System.out::println);

        System.out.println("--");
        set.retainAll(Set.of("1","2","3","4")); // intersection
        int size = set.size();
        boolean isEmpty = set.isEmpty();
        boolean contains = set.contains("?");
        set.removeAll(Set.of("1","2","3","4")); // remove batch
        set.clear();

        Set<String> newSet = Set.of("1","2","3","4"); // order is not preserved
        newSet.forEach(System.out::println);

        System.out.println("--");
        Set<String> set2 = new TreeSet<>(Set.of("1","2","3","4")); //does order
        set2.forEach(System.out::println);

        List<String> list = new ArrayList<>(set2);
    }
}
