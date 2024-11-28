package ru.aston.sort_app.services;

import ru.aston.sort_app.core.Car;
import ru.aston.sort_app.core.UserInputChoice;
import ru.aston.sort_app.dao.FileDAO;
import ru.aston.sort_app.dao.MemoryDAO;
import ru.aston.sort_app.services.searches.SearchStrategy;
import ru.aston.sort_app.services.sorts.SortStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarService extends Service<Car> {
    private final FileDAO<Car> fileDao;
    private final MemoryDAO<Car> memoryDAO;

    public CarService(FileDAO<Car> fileDao,
                      MemoryDAO<Car> memoryDAO,
                      SortStrategy<Car> sortStrategy,
                      SearchStrategy<Car> searchStrategy) {
        super(searchStrategy, sortStrategy);
        this.fileDao = fileDao;
        this.memoryDAO = memoryDAO;
    }


    @Override
    public List<Car> generate(UserInputChoice generateType, int size) {
        List<Car> cars = new ArrayList<>();
        switch (generateType) {
            case UserInputChoice.ACTION_CAR_FILE_GENERATED:
                cars = fileDao.get(size);
                break;
            case UserInputChoice.ACTION_CAR_RANDOM_GENERATED:
                cars = generateRandomCars(size);
                break;
            case UserInputChoice.ACTION_CAR_MANUAL_GENERATED:
                cars = memoryDAO.get(size);
                break;
        }
        return cars;
    }

    @Override
    public List<Car> find(List<Car> cars, Car car) {
        return super.getSearchStrategy().find(cars, car);
    }


    @Override
    public void sort(List<Car> list) {
        super.getSortStrategy().sort(list);
    }

    @Override
    public void add(Car car) {
        memoryDAO.add(car);
    }


    private List<Car> generateRandomCars(int count) {
        Random random = new Random();
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            int power = 100 + random.nextInt(300);
            String model = "Модель " + random.nextInt(count * 2);
            int year = 1930 + random.nextInt(90);

            Car car = new Car.Builder()
                    .setPower(power)
                    .setModel(model)
                    .setYear(year)
                    .build();
            cars.add(car);
        }
        return cars;
    }

}
