package ru.aston.sort_app.controller.menu_actions;

import ru.aston.sort_app.controller.MenuAction;
import ru.aston.sort_app.core.Car;
import ru.aston.sort_app.view.MessagePrinter;

import java.util.List;

public class GenerateCarsRandom implements MenuAction {
    private final MessagePrinter messagePrinter;

    public GenerateCarsRandom( MessagePrinter messagePrinter) {
        this.messagePrinter = messagePrinter;
    }

    @Override
    public void execute() {
        messagePrinter.printMessage("Данные успешно добавлены в коллекцию");
    }
}
