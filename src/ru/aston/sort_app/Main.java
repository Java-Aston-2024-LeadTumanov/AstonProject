package ru.aston.sort_app;

import ru.aston.sort_app.controller.DefaultMenuController;
import ru.aston.sort_app.controller.MenuAction;
import ru.aston.sort_app.controller.MenuController;
import ru.aston.sort_app.core.UserInputChoice;
import ru.aston.sort_app.view.MenuView;
import ru.aston.sort_app.view.menus.*;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<UserInputChoice, MenuView> menus = new HashMap<>();
        Map<UserInputChoice, MenuAction> actions = new HashMap<>();
        menus.put(UserInputChoice.MENU_MAIN, new MainMenu());
        menus.put(UserInputChoice.ADD_DATA, new AddMenu());
        menus.put(UserInputChoice.SEARCH, new SearchMenu());
        menus.put(UserInputChoice.SORT, new SortMenu());
        menus.put(UserInputChoice.FILE_GENERATED, new FileMenu());
        menus.put(UserInputChoice.USER_GENERATED, new MainMenu());
        menus.put(UserInputChoice.RANDOM_GENERATION, new GenerateMenu());

//        actions.put(UserInputChoice.CAR_SORT, new AddMenu());
//        actions.put(UserInputChoice.BOOK_SORT, new MainMenu());
//        actions.put(UserInputChoice.ROOTCROP_SORT, new SearchMenu());
//        actions.put(UserInputChoice.CAR_FILE, new SortMenu());
//        actions.put(UserInputChoice.BOOK_FILE, new FileMenu());
//        actions.put(UserInputChoice.ROOTCROP_FILE, new MainMenu());
//        actions.put(UserInputChoice.CAR_SEARCH, new SortMenu());
//        actions.put(UserInputChoice.BOOK_SEARCH, new FileMenu());
//        actions.put(UserInputChoice.ROOTCROP_SEARCH, new MainMenu());
//        actions.put(UserInputChoice.BACK_MENU, new GenerateMenu());
//        actions.put(UserInputChoice.CAR_MANUAL, new FileMenu());
//        actions.put(UserInputChoice.BOOK_MANUAL, new MainMenu());
//        actions.put(UserInputChoice.ROOTCROP_MANUAL, new GenerateMenu());
//        actions.put(UserInputChoice.CAR_RANDOM, new FileMenu());
//        actions.put(UserInputChoice.BOOK_RANDOM, new MainMenu());
//        actions.put(UserInputChoice.ROOTCROP_RANDOM, new GenerateMenu());
//        actions.put(UserInputChoice.RANDOM_GENERATION, new GenerateMenu());
//        actions.put(UserInputChoice.EXIT, new GenerateMenu());

       // MenuView mainMenuView = new MainMenu();
        //MenuController mainMenuController = new DefaultMenuController(mainMenuView, menus, actions);
       // mainMenuController.handleMenu();
    }
}