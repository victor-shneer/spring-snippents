package com.carmel;

import com.carmel.springSnippents.generics.ChildThing;
import com.carmel.springSnippents.generics.ListOrderEngine;
import com.carmel.springSnippents.generics.Thing;
import com.carmel.springSnippents.generics.ThingSortedByName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericTest {
    ListOrderEngine<Thing> engine = new ListOrderEngine<>();

    @Test
    public void thingTests(){
        List<Thing> things = new ArrayList<>();
        things.add(new Thing(0, "name"));
        things.add(new Thing(1, "name"));
        things.add(new Thing(2, "name"));


        engine.sort(things);
    }

    @Test
    public void comparatorTest(){
        Thing[] thingies = {
                new Thing(0, "name"),
                new Thing(0, "name"),
                new Thing(0, "name")
        };

        Arrays.sort(thingies, new ThingSortedByName());
    }

    @Test
    public void childThingTests(){
        List<ChildThing> childThings = new ArrayList<>();

        childThings.add(new ChildThing(0, "name"));
        childThings.add(new ChildThing(1,"name"));
        childThings.add(new ChildThing(2, "name"));


        engine.sort(childThings);
    }
}
