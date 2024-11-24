package ru.aston.sort_app.services;

import ru.aston.sort_app.core.Car;
import ru.aston.sort_app.core.UserInputChoice;
import ru.aston.sort_app.dao.FileDAO;

import java.util.ArrayList;
import java.util.List;

public class CarService implements Generator<Car>, SearchStrategy<Car>, SortStrategy<Car> {
    private final FileDAO<Car> fileDao;

    public CarService(FileDAO fileDao) {
        this.fileDao = fileDao;
    }

    @Override
    public List<Car> generate(UserInputChoice generateType, int size) {
        List<Car> cars = new ArrayList<>();
        switch (generateType) {
            case UserInputChoice.ACTION_CAR_FILE_GENERATED:
                cars = fileDao.get(size);
                break;
            case UserInputChoice.ACTION_BOOK_RANDOM_GENERATED:
                //вызов метода для генерации
                break;
            case UserInputChoice.ACTION_CAR_MANUAL_GENERATED:
                //вызов метода для генерации
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
}
