package ru.aston.sort_app.services.comparators.car_comparators;

import ru.aston.sort_app.core.Car;

import java.util.Comparator;

public class CarPowerComparator implements Comparator<Car> {
    @Override
    public int compare(Car car1, Car car2) {
        if (car1.getPower() == car2.getPower())
            return 0;
        else return car1.getPower() < car2.getPower() ? -1 : 1;
    }
}
