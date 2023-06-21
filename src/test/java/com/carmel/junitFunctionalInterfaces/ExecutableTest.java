package com.carmel.junitFunctionalInterfaces;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class ExecutableTest {

    @Test
    public void testExecutable(){
        assertAll(
                () -> assertTimeout(Duration.ofMillis(100), () -> Thread.sleep(50)),
                () -> assertTimeoutPreemptively(Duration.ofMillis(100), () -> Thread.sleep(50)),
                () -> assertThrows(Exception.class, () -> {throw new NullPointerException();}),
                () -> assertThrowsExactly(NullPointerException.class, () -> {throw new NullPointerException();}
        ));
    }
}
