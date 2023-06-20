package com.carmel.collections;

import org.junit.jupiter.api.Test;

import java.util.*;

public class ListTest {

//    @Test
    void list(){
        List<Object> objs = new ArrayList<>();
        objs.add(4);
        objs.add("4");
        objs.add(4.0);
        objs.add(true);
        objs.remove(2); // remove by index
        objs.remove(Integer.valueOf(4)); // remove by value

        objs.get(0); // get by index
        int size = objs.size();

        objs.forEach(System.out::println);

        //or for loop
        for (Object obj : objs) {
            System.out.println(obj);
        }


        //old-fashioned
        Iterator<Object> iterator = objs.iterator();
        while(iterator.hasNext()){
            // iterator is not a copy
            // iterator is a link, so if you modify original list from iterator
            // iterator "content" will be affected

            // you can remove using iterator
            iterator.remove(); // will remove elements from original list
            System.out.println(iterator.next());
        }

        // extends Iterator, but now you can iterate backwards
        ListIterator<Object> listIterator = objs.listIterator();
        listIterator.forEachRemaining(System.out::println); // iterates over remaining elements in the iterator

        objs.clear();

        // Linked list hasn't length limit but search is slow
        List<Object> links = new LinkedList<>();
        links.add(1);
        links.add("1");
        links.add(true);

        MyListIterator<String> myListIterator = new MyListIterator<>(List.of("1","2"));
        MyIterable myIterable = new MyIterable(List.of("1","2"));
        myIterable.forEach(System.out::println);
        // also I can obtain iterator from it
        // or spliterator
    }
}
