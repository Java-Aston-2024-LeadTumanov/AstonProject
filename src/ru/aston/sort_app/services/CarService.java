package ru.aston.sort_app.services;

import ru.aston.sort_app.core.Car;
import ru.aston.sort_app.core.UserInputChoice;
import ru.aston.sort_app.dao.FileDAO;

import java.util.List;

public class CarService   implements Generator<Car>, SearchStrategy<Car>, SortStrategy<Car> {
    private final FileDAO fileDao;

    public CarService(FileDAO fileDao) {
        this.fileDao = fileDao;
    }

    public List<Car> generate(UserInputChoice generateType) {
        switch (generateType){
            case UserInputChoice.ACTION_CAR_FILE_GENERATED:
                fileDao.read();
                break;
        }
        return List.of();
    }

    @Override
    public List<Car> find(Car item) {
        return List.of();
    }


    @Override
    public void sort(List<Car> collection) {

    }
}
