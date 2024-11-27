package ru.aston.sort_app.services.sorts.shell;

import ru.aston.sort_app.core.Car;
import ru.aston.sort_app.services.comparators.car_comparators.CarComparator;

public class CarShellSort extends ShellSort<Car>{
    public CarShellSort() {
        this.comparator = new CarComparator();
    }
}
