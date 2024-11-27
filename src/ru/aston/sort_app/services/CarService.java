package ru.aston.sort_app.services;

import ru.aston.sort_app.core.Car;
import ru.aston.sort_app.core.UserInputChoice;
import ru.aston.sort_app.dao.FileDAO;
import ru.aston.sort_app.dao.MemoryDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarService implements Service<Car> {
    private final FileDAO<Car> fileDao;
    private final MemoryDAO<Car> memoryDAO;


    public CarService(FileDAO fileDao, MemoryDAO<Car> memoryDAO) {
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
    public List<Car> find(ArrayList<Car> array, Car item) {
        return List.of();
    }


    @Override
    public void sort(ArrayList<Car> collection) {

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
