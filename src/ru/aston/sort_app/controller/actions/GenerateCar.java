package ru.aston.sort_app.controller.actions;

import ru.aston.sort_app.controller.MenuAction;
import ru.aston.sort_app.core.Car;
import ru.aston.sort_app.core.UserInputChoice;
import ru.aston.sort_app.services.Generator;
import ru.aston.sort_app.view.MessagePrinter;

public class GenerateCar implements MenuAction {
    private final MessagePrinter messagePrinter;
    private final Generator<Car> carService;


    public GenerateCar(MessagePrinter messagePrinter, Generator<Car> carService) {
        this.messagePrinter = messagePrinter;
        this.carService = carService;
    }

    @Override
    public void execute(UserInputChoice choice) {
        carService.generate(choice);
        messagePrinter.printMessage("Данные успешно добавлены в коллекцию");
    }
}
