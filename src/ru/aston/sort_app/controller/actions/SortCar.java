package ru.aston.sort_app.controller.actions;

import ru.aston.sort_app.controller.MenuAction;
import ru.aston.sort_app.core.Car;
import ru.aston.sort_app.core.UserInputChoice;
import ru.aston.sort_app.services.Service;
import ru.aston.sort_app.view.InputValidator;
import ru.aston.sort_app.view.MessagePrinter;
import ru.aston.sort_app.view.Reader;

import java.util.List;

public class SortCar implements MenuAction {
    private final MessagePrinter messagePrinter;
    private final Reader reader;

    private final Service<Car> carService;
    private final List<Car> cars;

    public SortCar(MessagePrinter messagePrinter, Reader reader, Service<Car> carService, List<Car> cars) {
        this.messagePrinter = messagePrinter;
        this.reader = reader;
        this.carService = carService;
        this.cars = cars;
    }

    @Override
    public void execute(UserInputChoice choice) {
        carService.sort(cars);
        //cars.addAll(carService.generate(choice, size));
        messagePrinter.printMessage(cars.toString());
    }

}
