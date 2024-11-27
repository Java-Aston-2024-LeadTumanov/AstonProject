package ru.aston.sort_app.dao;

import ru.aston.sort_app.core.Car;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CarFileDAO implements FileDAO<Car> {
    private static final String FILE_NAME = "src/resources/cars.csv";

    @Override
    public List<Car> get(int amount) {
        List<Car> cars = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            br.readLine();

            String line;
            int listSize = 0;

            while (listSize < amount && ((line = br.readLine()) != null)) {
                String[] values = line.split(";");
                Car car = new Car.Builder()
                        .setPower(Integer.parseInt(values[0]))
                        .setModel(values[1])
                        .setYear(Integer.parseInt(values[2]))
                        .build();
                cars.add(car);
                listSize++;
            }

        } catch (IOException e) {
            throw new RuntimeException("Ошибка при работе с файлом: " + FILE_NAME, e);
        }

        return cars;
    }
}
