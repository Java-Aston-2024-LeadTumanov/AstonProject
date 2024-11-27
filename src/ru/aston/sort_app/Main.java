package ru.aston.sort_app;

import ru.aston.sort_app.controller.DefaultMenuController;
import ru.aston.sort_app.controller.MenuAction;
import ru.aston.sort_app.controller.MenuController;
import ru.aston.sort_app.controller.actions.GenerateCar;
import ru.aston.sort_app.core.UserInputChoice;
import ru.aston.sort_app.dao.CarFileDAO;
import ru.aston.sort_app.dao.DAO;
import ru.aston.sort_app.services.CarService;
import ru.aston.sort_app.view.ConsolePrinter;
import ru.aston.sort_app.view.MenuView;
import ru.aston.sort_app.view.MessagePrinter;
import ru.aston.sort_app.view.menus.AddMenu;
import ru.aston.sort_app.view.menus.FileMenu;
import ru.aston.sort_app.view.menus.GenerateMenu;
import ru.aston.sort_app.view.menus.MainMenu;
import ru.aston.sort_app.view.menus.ManualMenu;
import ru.aston.sort_app.view.menus.SearchMenu;
import ru.aston.sort_app.view.menus.SortMenu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        List<Car> cars = new ArrayList<>();
        MessagePrinter messagePrinter = new ConsolePrinter();
        DAO<Car> carFileDAO = new CarFileDAO();
        CarService carService = new CarService(carFileDAO);
        GenerateCar generateCar = new GenerateCar(messagePrinter, carService, cars);

        Map<UserInputChoice, MenuView> menus = new HashMap<>();
        menus.put(UserInputChoice.MENU_MAIN, new MainMenu());
        menus.put(UserInputChoice.MENU_ADD_DATA, new AddMenu());
        menus.put(UserInputChoice.MENU_SEARCH, new SearchMenu());
        menus.put(UserInputChoice.MENU_SORT, new SortMenu());
        menus.put(UserInputChoice.MENU_FILE_GENERATED, new FileMenu());
        menus.put(UserInputChoice.MENU_USER_GENERATED, new ManualMenu());
        menus.put(UserInputChoice.MENU_RANDOM_GENERATION, new GenerateMenu());

        Map<UserInputChoice, MenuAction> actions = new HashMap<>();
        actions.put(UserInputChoice.ACTION_CAR_FILE_GENERATED, generateCar);
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


        MenuController defaultMenuController = new DefaultMenuController(messagePrinter, menus, actions);
        defaultMenuController.handleMenu();
    }
}