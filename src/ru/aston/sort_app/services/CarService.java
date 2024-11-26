package ru.aston.sort_app.services;

import ru.aston.sort_app.core.Car;
import ru.aston.sort_app.core.UserInputChoice;
import ru.aston.sort_app.dao.DAO;

import java.util.ArrayList;
import java.util.List;

public class CarService implements Generator<Car>, SearchStrategy<Car>, SortStrategy<Car> {
    private final DAO<Car> dao;


    public CarService(DAO dao) {
        this.dao = dao;
    }

    @Override
    public List<Car> generate(UserInputChoice generateType, int size) {
        List<Car> cars = new ArrayList<>();
        switch (generateType) {
            case UserInputChoice.ACTION_CAR_FILE_GENERATED:
                cars = dao.get(size);
                break;
            case UserInputChoice.ACTION_CAR_RANDOM_GENERATED:
                //service
                break;
            case UserInputChoice.ACTION_CAR_MANUAL_GENERATED:

                break;
        }
        return cars;
    }

    @Override
    public List<Car> find(Car item) {
        return List.of();
    }


    @Override
    public void sort(List<Car> collection) {

    }


    public void add(Car car) {

    }

}
