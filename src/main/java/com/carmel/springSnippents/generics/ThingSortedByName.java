package com.carmel.springSnippents.generics;

import java.util.Comparator;

public class ThingSortedByName implements Comparator<Thing> {
    @Override
    public int compare(Thing one, Thing two) {
//        Thing one = (Thing) o1;
//        Thing two = (Thing) o2;

        String nameOne = one.getName();
        String nameTwo = two.getName();

        // descending
        return nameOne.compareTo(nameTwo);
    }
}
