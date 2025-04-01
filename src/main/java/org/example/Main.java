package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Car car = new Car("Porche", 100);
        List<Car> carsShop = List.of(
                new Car("Alice", 30),
                new Car("Bob", 25),
                new Car("Charlie", 35),
                null // Добавлено null для демонстрации обработки
        );

    }
}