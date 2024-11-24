package ru.aston.sort_app;

import ru.aston.sort_app.controller.DefaultMenuController;
import ru.aston.sort_app.controller.MenuAction;
import ru.aston.sort_app.controller.MenuController;
import ru.aston.sort_app.controller.menu_actions.GenerateCarsFromFile;
import ru.aston.sort_app.controller.menu_actions.GenerateCarsRandom;
import ru.aston.sort_app.core.UserInputChoice;
import ru.aston.sort_app.view.ConsolePrinter;
import ru.aston.sort_app.view.MenuView;
import ru.aston.sort_app.view.MessagePrinter;
import ru.aston.sort_app.view.menu.MainMenuView;
import ru.aston.sort_app.view.menu.SubMenuCreateCollectionView;
import ru.aston.sort_app.view.menu.SubMenuTypeGen;

import java.util.HashMap;
import java.util.Map;


public class Runner {
    public static void main(String[] args) {
        MessagePrinter messagePrinter = new ConsolePrinter();


        Map<UserInputChoice, MenuAction> actions = new HashMap<>();
        actions.put(UserInputChoice.CAR_FILE, new GenerateCarsFromFile(messagePrinter));
        actions.put(UserInputChoice.CAR_RANDOM, new GenerateCarsRandom(messagePrinter));

        Map<UserInputChoice, MenuView> menus = new HashMap<>();
        menus.put(UserInputChoice.MAIN, new MainMenuView());
       // menus.put(UserInputChoice.CREATE_COLLECTION, new SubMenuCreateCollectionView());
        menus.put(UserInputChoice.FILE, new SubMenuTypeGen());
        menus.put(UserInputChoice.RANDOM_GENERATION, new SubMenuTypeGen());


        MenuView mainMenuView = new MainMenuView();


        MenuController mainMenuController = new DefaultMenuController(mainMenuView, messagePrinter,  menus, actions);

        mainMenuController.handleMenu();


    }
}