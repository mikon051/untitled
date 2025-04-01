package org.example;

import java.util.ArrayList;

public class Car {
    private String name;

    private int number;

    public Car(String name, int number) {
        this.name = name;
        this.number = number;
    }


    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }


    public static ArrayList addCar(Car car, ArrayList arrayList){
        arrayList.add(car);
        return arrayList;
    }

    public static String getCarInfo(ArrayList<Car> arrayList, int number) {
        for (Car obj : arrayList) {
            if (obj.getNumber() == number) {
                String allInfoCar = obj.getName() + obj.getNumber();
                return allInfoCar; // Возвращаем всю информацию объекта, если индекс совпадает
            }
        }
        return null; // Возвращаем null, если объект с таким индексом не найден
    }

    public String drive() {
        return "Drive";
    }

    public static void clearAll(ArrayList arrayList){
        arrayList.clear();
    }


}
