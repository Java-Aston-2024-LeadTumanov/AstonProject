package ru.aston.sort_app.controller.actions;

import ru.aston.sort_app.controller.MenuAction;
import ru.aston.sort_app.core.Car;
import ru.aston.sort_app.core.UserInputChoice;
import ru.aston.sort_app.services.Generator;
import ru.aston.sort_app.view.InputValidator;
import ru.aston.sort_app.view.MessagePrinter;

import java.util.List;

public class GenerateCar implements MenuAction {
    private final MessagePrinter messagePrinter;
    private final Generator<Car> carService;
    private final List<Car> cars;

    public GenerateCar(MessagePrinter messagePrinter, Generator<Car> carService, List<Car> cars) {
        this.messagePrinter = messagePrinter;
        this.carService = carService;
        this.cars = cars;
    }

    @Override
    public void execute(UserInputChoice choice) {
        messagePrinter.printMessage("Введите количество элементов (не более 30):");
        int size = InputValidator.getValidatedInput(30);
        cars.addAll(carService.generate(choice, size));
        messagePrinter.printMessage(cars.toString());
        messagePrinter.printMessage("Данные успешно добавлены в коллекцию");
    }
}
