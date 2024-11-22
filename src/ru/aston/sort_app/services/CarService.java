package ru.aston.sort_app.services;

import ru.aston.sort_app.core.Car;
import ru.aston.sort_app.core.GenerateType;
import ru.aston.sort_app.dao.FileDAO;

import java.util.List;

public class CarService implements Generator<Car>{
    FileDAO dao;
    Generator<Car> carGenerator;
    @Override
    public List<Car> generate(GenerateType generateType) {
        dao.read();
        return List.of();
    }
}
