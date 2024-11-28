package ru.aston.sort_app.controller.actions;

import ru.aston.sort_app.controller.MenuAction;
import ru.aston.sort_app.core.RootCrop;
import ru.aston.sort_app.core.UserInputChoice;
import ru.aston.sort_app.services.Service;
import ru.aston.sort_app.services.validators.RootCropValidator;
import ru.aston.sort_app.view.MessagePrinter;
import ru.aston.sort_app.view.Reader;

import java.util.List;

public class SearchRootCrop implements MenuAction {
    private final MessagePrinter messagePrinter;
    private final Reader reader;

    private final Service<RootCrop> rootCropService;
    private final List<RootCrop> rootCrops;

    public SearchRootCrop(MessagePrinter messagePrinter, Reader reader, Service<RootCrop> rootCropService, List<RootCrop> rootCrops) {
        this.messagePrinter = messagePrinter;
        this.reader = reader;
        this.rootCropService = rootCropService;
        this.rootCrops = rootCrops;
    }

    @Override
    public void execute(UserInputChoice choice) {
        String type;
        int weight;
        String color;

        messagePrinter.printMessage("Введите данные для корнеплода: ");

        do {
            messagePrinter.printMessage("Введите тип:");
            type = reader.getStringInput();
            if (RootCropValidator.validateType(type))
                break;
            else messagePrinter.printMessage("Данные не прошли валидацию");
        } while (true);

        do {
            messagePrinter.printMessage("Введите вес (в граммах):");
            String weightStr = reader.getStringInput();
            if (RootCropValidator.validateWeight(weightStr)) {
                weight = Integer.parseInt(weightStr);
                break;
            }
            else messagePrinter.printMessage("Данные не прошли валидацию");
        } while (true);

        do {
            messagePrinter.printMessage("Введите цвет:");
            color = reader.getStringInput();
            if (RootCropValidator.validateColor(color))
                break;
            else messagePrinter.printMessage("Данные не прошли валидацию");
        } while (true);

        RootCrop rootCrop = new RootCrop.Builder()
                .setType(type)
                .setWeight(weight)
                .setColor(color)
                .build();

        messagePrinter.printMessage(rootCropService.find(rootCrops, rootCrop).toString());
    }
}
