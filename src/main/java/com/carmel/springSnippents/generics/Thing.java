package com.carmel.springSnippents.generics;

import java.io.Closeable;
import java.io.IOException;

public class Thing implements Comparable<Thing>, Closeable {

    private final Integer number;

    public Thing(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    @Override
    public int compareTo(Thing o) {
        return number.compareTo(o.getNumber());
    }

    @Override
    public void close() throws IOException {

    }
}