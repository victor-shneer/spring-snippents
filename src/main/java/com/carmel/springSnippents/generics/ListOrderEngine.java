package com.carmel.springSnippents.generics;

import java.io.Closeable;
import java.util.Collections;
import java.util.List;


// see GenericTest to this in action
// ? super says that everything that extends smth that implements Comparable can be used
public class ListOrderEngine<T extends Comparable<? super T> & Closeable> {
    // with ? wildcard we ensure that we can sort any type that extends T
    public void sort(List<? extends T> list){
        Collections.sort(list);
    }

    public void randomize(List<T> list){
        Collections.shuffle(list);
    }
}

