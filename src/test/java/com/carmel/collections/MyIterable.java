package com.carmel.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class MyIterable implements Iterable<String> {
    private final List<String> list;

    public MyIterable(List<String> list){
        this.list = list;
    }

    // not part of iterable interface
    public void add(String element){
        this.list.add(element);
    }
    @Override
    public Iterator<String> iterator() {
        return this.list.iterator();
    }
}
