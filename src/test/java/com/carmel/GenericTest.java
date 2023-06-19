package com.carmel;

import com.carmel.springSnippents.generics.ChildThing;
import com.carmel.springSnippents.generics.ListOrderEngine;
import com.carmel.springSnippents.generics.Thing;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {
    ListOrderEngine<Thing> engine = new ListOrderEngine<>();

    @Test
    public void thingTests(){
        List<Thing> things = new ArrayList<>();

        things.add(new Thing(0));
        things.add(new Thing(1));
        things.add(new Thing(2));


        engine.sort(things);
    }

    @Test
    public void childThingTests(){
        List<ChildThing> childThings = new ArrayList<>();

        childThings.add(new ChildThing(0));
        childThings.add(new ChildThing(1));
        childThings.add(new ChildThing(2));


        engine.sort(childThings);
    }
}
