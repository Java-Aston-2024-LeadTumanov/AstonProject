package ru.aston.sort_app.controller.actions;

import ru.aston.sort_app.controller.MenuAction;
import ru.aston.sort_app.core.RootCrop;
import ru.aston.sort_app.core.UserInputChoice;
import ru.aston.sort_app.services.Service;
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
        messagePrinter.printMessage("Введите данные для корнеплода: ");
        messagePrinter.printMessage("Введите тип:");
        String type = reader.getStringInput();

        messagePrinter.printMessage("Введите вес:");
        int weight = Integer.parseInt(reader.getStringInput());

        messagePrinter.printMessage("Введите цвет:");
        String color = reader.getStringInput();

        RootCrop rootCrop = new RootCrop.Builder()
                .setType(type)
                .setWeight(weight)
                .setColor(color)
                .build();

        messagePrinter.printMessage(rootCropService.find(rootCrops, rootCrop).toString());
    }
}
