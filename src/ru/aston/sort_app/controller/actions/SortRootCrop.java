package ru.aston.sort_app.controller.actions;

import ru.aston.sort_app.controller.MenuAction;
import ru.aston.sort_app.core.RootCrop;
import ru.aston.sort_app.core.UserInputChoice;
import ru.aston.sort_app.services.Service;
import ru.aston.sort_app.view.MessagePrinter;
import ru.aston.sort_app.view.Reader;

import java.util.List;

public class SortRootCrop implements MenuAction {
    private final MessagePrinter messagePrinter;
    private final Reader reader;

    private final Service<RootCrop> rootCropService;
    private final List<RootCrop> rootCrops;

    public SortRootCrop(MessagePrinter messagePrinter, Reader reader, Service<RootCrop> rootCropService, List<RootCrop> rootCrops) {
        this.messagePrinter = messagePrinter;
        this.reader = reader;
        this.rootCropService = rootCropService;
        this.rootCrops = rootCrops;
    }

    @Override
    public void execute(UserInputChoice choice) {
        rootCropService.sort(rootCrops);
        messagePrinter.printMessage(rootCrops.toString());
    }
}
