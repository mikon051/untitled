package org.example;

import java.util.Arrays;

public class CarArrayList implements CarList {

    private Car[] massive = new Car[10];
    private int size = 0;


    @Override
    public Car get(int index) {
        checkIndex(index);
        return massive[index];
    }


    @Override
    public void add(Car car) {
        increaseArray();
        massive[size] = car;
        size = size + 1;
    }

    @Override
    public void add(Car car, int index) {
        increaseArray();
            for (int i = size; i > index; i--) {
                massive[i] = massive[i - 1];
            }
            massive[index] = car;
            size = size + 1;
    }

    @Override
    public boolean remove(Car car) {
        for (int i = 0; i < size; i++) {
            if (massive[i].equals(car)) {
                return removeAt(i);
            }
        }
        return false;
    }

    @Override
    public boolean removeAt(int index) {
        for (int i = index; i < size - 1; i++) {
            massive[i] = massive[i + 1];
        }
        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        massive = new Car[10];
        size = 0;
    }

    public void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
    }
    private void increaseArray(){
        if (size >= massive.length) {
            massive = Arrays.copyOf(massive, massive.length * 2);
        }
    }

}
