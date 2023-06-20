package com.carmel;

import org.junit.jupiter.api.Test;

import java.io.*;

public class ExceptionHandlingTest {
    /**
     * try with resources
     */
    @Test
    void exceptionHandlingTest(){
        try(InputStream stream = new FileInputStream((new File("pathDoNotExist")))){
            // do smth with the stream
        } catch (IOException e){
            e.printStackTrace();

        }
    }
}
