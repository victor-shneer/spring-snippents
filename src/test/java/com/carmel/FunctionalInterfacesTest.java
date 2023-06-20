package com.carmel;

import com.carmel.json.pojo.JsonPojo;
import com.carmel.springSnippents.entity.User;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FunctionalInterfacesTest {

    @Test
    void predicate(){
        Predicate<String> checkLength = str -> str.length()>6;

        assertThat(checkLength.test("asd")).isFalse();
        assertThat(checkLength.test("VictorVictorVictor")).isTrue();
    }

    @Test
    void consumer(){
        Consumer<JsonPojo> setCode = obj -> obj.setCode("code");

        JsonPojo jsonPojo = new JsonPojo();
        setCode.accept(jsonPojo);

        assertThat(jsonPojo.getCode()).isEqualTo("code");

    }

    @Test
    void function(){
        Function<Integer, String> getInt = t-> (t * 10) + " was multiplied by 10";

        assertThat(getInt.apply(10)).isEqualTo("100 was multiplied by 10");
    }

    @Test
    void supplier(){
        Supplier<Double> getRandomDouble = Math::random;

        assertThat(getRandomDouble.get()).isNotNaN();
    }
}
