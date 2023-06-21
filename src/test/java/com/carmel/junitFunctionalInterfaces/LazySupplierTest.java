package com.carmel.junitFunctionalInterfaces;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LazySupplierTest {

    // method to create an error message
    // could add a delay to simulate complex process
    private String createErrorMessage(){
        System.out.println("Creating error message...");
        return "Error message";
    }

    // error message created even when test passes
    @Test
    public void eagerTest(){
        assertTrue(true, createErrorMessage());
    }

    // laze message created only of test fails
    @Test
    public void lazyTest(){
        assertTrue(true, this::createErrorMessage);
    }
}
