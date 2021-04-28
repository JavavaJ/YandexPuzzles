package some_playground.java_8.groupingBy;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


public class Example3 {

    public static void main(String[] args) {

        List<Fruit> fruits = Arrays.asList(
            new Fruit("apple", 10, new BigDecimal("9.99")),
            new Fruit("mango", 20, new BigDecimal("19.99")),
            new Fruit("melon", 10, new BigDecimal("29.99")),
            new Fruit("apple", 30, new BigDecimal("19.99")),
            new Fruit("orange", 10, new BigDecimal("9.99")),
            new Fruit("apple", 40, new BigDecimal("19.99")),
            new Fruit("banana", 10, new BigDecimal("29.99")),
            new Fruit("apple", 20, new BigDecimal("29.99"))
        );

        Set<String> uniqueFruits = fruits.stream()
            .collect(Collectors.mapping(Fruit::getName, Collectors.toSet()));

        Map<String, Long> name2count = fruits.stream()
            .collect(Collectors.groupingBy(Fruit::getName, Collectors.counting()));
        System.out.println(name2count); // {banana=1, orange=1, apple=4, melon=1, mango=1}

        Map<String, Integer> name2quantity = fruits.stream()
            .collect(Collectors.groupingBy(Fruit::getName, Collectors.summingInt(Fruit::getQuantity)));
        System.out.println(name2quantity); // {banana=10, orange=10, apple=100, melon=10, mango=20}

        Map<BigDecimal, List<Fruit>> price2fruit = fruits.stream()
            .collect(Collectors.groupingBy(Fruit::getPrice));


    }
}
