package com.carmel.collections;

import java.util.Arrays;


/**
 * Developer can use this class as a wrapper for int[]
 * With this wrapper developer can use result object as a HashMap key
 */
public class IntArrayToMapKeyWrapper {
    private final int[] array;

    public IntArrayToMapKeyWrapper(int[] array){
        this.array = array;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        IntArrayToMapKeyWrapper other = (IntArrayToMapKeyWrapper) obj;
        return Arrays.equals(array, other.array);
    }

    @Override
    public int hashCode(){
        return Arrays.hashCode(array);
    }
}
