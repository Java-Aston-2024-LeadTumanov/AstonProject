package ru.aston.sort_app.dao;

import ru.aston.sort_app.core.Car;

import java.util.ArrayList;
import java.util.List;

public class CarMemoryDAO implements MemoryDAO<Car>{
    private final List<Car> cars = new ArrayList<>();
    @Override
    public List<Car> get(int amount) {
        ///цикл
        return new ArrayList<>();
    }

    public void add(Car car){
        cars.add(car);
    }
}
