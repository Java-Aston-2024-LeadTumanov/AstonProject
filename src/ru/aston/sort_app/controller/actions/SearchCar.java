package ru.aston.sort_app.controller.actions;

import ru.aston.sort_app.controller.MenuAction;
import ru.aston.sort_app.core.Car;
import ru.aston.sort_app.core.UserInputChoice;
import ru.aston.sort_app.services.Service;
import ru.aston.sort_app.services.validators.CarValidator;
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
        String model;
        int power;
        int year;

        messagePrinter.printMessage("Введите данные для автомобиля: ");

        do {
            messagePrinter.printMessage("Введите модель:");
            model = reader.getStringInput();
            if (CarValidator.validateModel(model))
                break;
            else messagePrinter.printMessage("Данные не прошли валидацию");
        } while (true);

        do {
            messagePrinter.printMessage("Введите мощност:");
            String powerStr = reader.getStringInput();
            if (CarValidator.validatePower(powerStr)) {
                power = Integer.parseInt(powerStr);
                break;
            }
            else messagePrinter.printMessage("Данные не прошли валидацию");
        } while (true);

        do {
            messagePrinter.printMessage("Введите год:");
            String yearStr = reader.getStringInput();
            if (CarValidator.validateYear(yearStr)) {
                year = Integer.parseInt(yearStr);
                break;
            }
            else messagePrinter.printMessage("Данные не прошли валидацию");
        } while (true);

        Car car = new Car.Builder()
                .setModel(model)
                .setPower(power)
                .setYear(year)
                .build();

        messagePrinter.printMessage(carService.find(cars, car).toString());
    }
}
