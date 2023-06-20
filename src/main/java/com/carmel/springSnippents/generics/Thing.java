package com.carmel.springSnippents.generics;

import java.io.Closeable;
import java.io.IOException;

public class Thing implements Comparable<Thing>, Closeable {

    private final Integer number;
    private final String name;

    public Thing(Integer number, String name) {
        this.number = number;
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }
    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Thing o) {
        return number.compareTo(o.getNumber());
    }

    @Override
    public void close() throws IOException {

    }
}