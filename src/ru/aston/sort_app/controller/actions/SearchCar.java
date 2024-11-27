package ru.aston.sort_app.controller.actions;

import ru.aston.sort_app.controller.MenuAction;
import ru.aston.sort_app.core.Car;
import ru.aston.sort_app.core.UserInputChoice;
import ru.aston.sort_app.services.Service;
import ru.aston.sort_app.view.MessagePrinter;
import ru.aston.sort_app.view.Reader;

import java.util.List;

public class SearchCar implements MenuAction {
    private final MessagePrinter messagePrinter;
    private final Reader reader;

    private final Service<Car> carService;
    private final List<Car> cars;

    public SearchCar(MessagePrinter messagePrinter, Reader reader, Service<Car> carService, List<Car> cars) {
        this.messagePrinter = messagePrinter;
        this.reader = reader;
        this.carService = carService;
        this.cars = cars;
    }

    @Override
    public void execute(UserInputChoice choice) {
        messagePrinter.printMessage("Введите данные для автомобиля: ");
        System.out.println("Введите модель:");
        String model = reader.getStringInput();

        messagePrinter.printMessage("Введите мощность:");
        int power = Integer.parseInt(reader.getStringInput());

        messagePrinter.printMessage("Введите год:");
        int year = Integer.parseInt(reader.getStringInput());

        Car car = new Car.Builder()
                .setModel(model)
                .setPower(power)
                .setYear(year)
                .build();

        messagePrinter.printMessage(carService.find(cars, car).toString());
    }
}
