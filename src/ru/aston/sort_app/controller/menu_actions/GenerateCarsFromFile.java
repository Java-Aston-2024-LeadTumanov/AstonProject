package ru.aston.sort_app.controller.menu_actions;

import ru.aston.sort_app.controller.MenuAction;
import ru.aston.sort_app.view.AmountEle;
import ru.aston.sort_app.view.MessagePrinter;

public class GenerateCarsFromFile implements MenuAction {
    private final MessagePrinter messagePrinter;
    private final AmountEle amountEle = new AmountEle();

    public GenerateCarsFromFile(MessagePrinter messagePrinter) {
        this.messagePrinter = messagePrinter;
    }

    @Override
    public void execute() {
        amountEle.getAmount();
        messagePrinter.printMessage("Данные успешно добавлены в коллекцию");
    }
}
