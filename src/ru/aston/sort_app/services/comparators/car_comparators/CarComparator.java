package ru.aston.sort_app.services.comparators.car_comparators;

import ru.aston.sort_app.core.Car;

import java.util.Comparator;

public class CarComparator implements Comparator<Car> {
    Comparator<Car> carPowerComparator = new CarPowerComparator(),
            carModelComparator = new CarModelComparator(),
            carYearComparator = new CarYearComparator();

    @Override
    public int compare(Car car1, Car car2) {
        return carPowerComparator
                .thenComparing(carModelComparator)
                .thenComparing(carYearComparator)
                .compare(car1, car2);
    }
}
