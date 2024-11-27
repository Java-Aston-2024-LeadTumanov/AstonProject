package ru.aston.sort_app.services.searches.binary;

import ru.aston.sort_app.core.Car;
import ru.aston.sort_app.services.comparators.car_comparators.CarComparator;

public class CarBinarySearch extends BinarySearch<Car> {
    public CarBinarySearch() {
        this.comparator = new CarComparator();
    }
}
