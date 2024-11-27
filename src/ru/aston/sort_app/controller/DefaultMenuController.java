package ru.aston.sort_app.controller;

import ru.aston.sort_app.core.UserInputChoice;
import ru.aston.sort_app.view.MenuView;
import ru.aston.sort_app.view.MessagePrinter;

import java.util.Map;

public class DefaultMenuController implements MenuController {

    private final MessagePrinter messagePrinter;
    private final Map<UserInputChoice, MenuView> menus;
    private final Map<UserInputChoice, MenuAction> actions;

    private MenuView menuView;

    public DefaultMenuController(MessagePrinter messagePrinter, Map<UserInputChoice, MenuView> menus, Map<UserInputChoice, MenuAction> actions) {
        this.menuView = menus.get(UserInputChoice.MENU_MAIN);
        this.messagePrinter = messagePrinter;
        this.menus = menus;
        this.actions = actions;

    }

    @Override
    public void handleMenu() {
        UserInputChoice choice;
        do {
            menuView.showMenu();
            choice = menuView.getUserInputChoice();

            if (menus.containsKey(choice)) {
                menuView = menus.get(choice);
            } else if (actions.containsKey(choice)) {
                actions.get(choice).execute(choice);
                menuView = menus.get(UserInputChoice.MENU_MAIN);
            }
        } while (choice != UserInputChoice.EXIT);

        messagePrinter.printMessage(("Программа завершена."));
    }
}


