package ru.aston.sort_app.services.comparators.car_comparators;

import ru.aston.sort_app.core.Car;

import java.util.Comparator;

public class CarModelComparator implements Comparator<Car> {
    @Override
    public int compare(Car car1, Car car2) {
        return car1.getModel().compareTo(car2.getModel());
    }
}
