package ru.aston.sort_app.services.comparators.car_comparators;

import ru.aston.sort_app.core.Car;

import java.util.Comparator;

public class CarModelComparator implements Comparator<Car> {
    @Override
    public int compare(Car car1, Car car2) {
        //TODO change to correct when Car class is finished

        //return car1.getModel().compareTo(car2.getModel());
        if (car1.hashCode() == car2.hashCode())
            return 0;
        else return car1.hashCode() < car2.hashCode() ? -1 : 1;
    }
}
