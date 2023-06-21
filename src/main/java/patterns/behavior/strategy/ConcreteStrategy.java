package patterns.behavior.strategy;

import java.util.Arrays;

public class ConcreteStrategy implements Strategy{
    @Override
    public int[] sort(int[] array) {
        // some sort algo
        Arrays.sort(array);
        return array;
    }
}
