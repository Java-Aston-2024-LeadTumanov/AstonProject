package ru.aston.sort_app.controller.actions;

import ru.aston.sort_app.controller.MenuAction;
import ru.aston.sort_app.core.RootCrop;
import ru.aston.sort_app.core.UserInputChoice;
import ru.aston.sort_app.services.Service;
import ru.aston.sort_app.view.InputValidator;
import ru.aston.sort_app.view.MessagePrinter;
import ru.aston.sort_app.view.Reader;

import java.util.List;


public class GenerateRootCrop implements MenuAction {
    private final MessagePrinter messagePrinter;
    private final Reader reader;

    private final Service<RootCrop> rootCropService;
    private final List<RootCrop> rootCrops;
    private int count;

    public GenerateRootCrop(MessagePrinter messagePrinter, Reader reader, Service<RootCrop> rootCropService, List<RootCrop> rootCrops) {
        this.messagePrinter = messagePrinter;
        this.reader = reader;
        this.rootCropService = rootCropService;
        this.rootCrops = rootCrops;
        count = 0;
    }


    @Override
    public void execute(UserInputChoice choice) {

        if (choice == UserInputChoice.ACTION_ROOTCROP_MANUAL_GENERATED) {
            messagePrinter.printMessage("Введите данные для автомобиля. Для завершения ввода введите 'exit' в поле модели.");

            //loop through all rootCrops that user inputs
            while (true) {

                // Get a single RootCrop via user input
                messagePrinter.printMessage("Enter root crop type: ");
                String type = reader.getStringInput();
                if ("exit".equalsIgnoreCase(type)) {
                    break;
                }
                messagePrinter.printMessage("Enter root crop weight (in grams): ");
                int weight = Integer.parseInt(reader.getStringInput());
                messagePrinter.printMessage("Enter root crop color: ");
                String color = reader.getStringInput();

                RootCrop rootCrop = new RootCrop.Builder()
                        .setType(type)
                        .setWeight(weight)
                        .setColor(color)
                        .build();

                rootCropService.add(rootCrop);
                count++;
            }
            rootCrops.addAll(rootCropService.generate(choice, count));
            messagePrinter.printMessage(rootCrops.toString());
        } else {
            messagePrinter.printMessage("Введите количество элементов (не более 6):");
            int size = InputValidator.getValidatedInput(6);
            rootCrops.addAll(rootCropService.generate(choice, size));
            messagePrinter.printMessage(rootCrops.toString());
        }
    }

}
