package com.carmel;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsTest {
    record Car(String type, String make, String model, Integer engineCapacity){}

    private final List<Car> cars = List.of(
            new Car("sedan", "BMW", "530", 1998),
            new Car("sedan", "Audi", "A5", 1998),
            new Car("sedan", "Mercedes", "E", 2500),
            new Car("hatchback", "Skoda", "Octavia", 1600),
            new Car("hatchback", "Toyota", "TypeR", 1450)
    );

    @Test
    void streams(){
        List<Car> sedanCars = cars.stream().filter(car -> car.type.equals("sedan")).toList();

        // extract field from list of objects
        List<String> carMakeList = cars.stream().map(car -> car.make).toList();

        // Audi, A5, Mercedes, E
        List<String> carMakeModelList = cars.stream().flatMap(car -> Stream.of(car.make, car.model)).toList();
        System.out.println(carMakeModelList);

        Stream<Integer> integerStream = Stream.of(10,11,12,13,14);

        // lazy evaluation
        Stream<Integer> fIntegerStream = integerStream.filter(i->{
            System.out.println(i);
            return i % 2 == 0;
        });

        // code above will be executed only after execution flow reaches this point
        // because it is terminal operation
        // everything that is not returning a stream is a terminal operation
        System.out.println(fIntegerStream.count());

        Map<Boolean, List<Car>> partitionCars = cars.stream().collect(Collectors.partitioningBy(car -> Objects.equals(car.type, "sedan")));

        // (type, (model, engineCapacity))
        Map<String, Map<String, Integer>> groupedCars = cars.stream().collect(
                Collectors.groupingBy(
                        car -> car.type, // key selector, you can use cleaner version: Car::type
                        Collectors.toMap(
                                Car::model,
                                Car::engineCapacity // same as: car -> car.engineCapacity
                        )
                )
        );

        // you can run streams in multi thread mode
        cars.parallelStream()
                .sequential() // back to sequential
                .parallel()   // BUT you CANNOT switch one pipe in a half and say 1half parallel second seq.
                .forEach(System.out::println); // the hole pipe will be in a way of the last modifier
    }
}
