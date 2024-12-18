package ru.aston.sort_app.services.comparators.car_comparators;

import ru.aston.sort_app.core.Car;

import java.util.Comparator;

public class CarYearComparator implements Comparator<Car> {
    @Override
    public int compare(Car car1, Car car2) {
        if (car1.getYear() == car2.getYear())
            return 0;
        else return car1.getYear() < car2.getYear() ? -1 : 1;
    }
}
