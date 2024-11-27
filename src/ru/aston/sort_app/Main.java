package ru.aston.sort_app;

import ru.aston.sort_app.controller.DefaultMenuController;
import ru.aston.sort_app.controller.MenuAction;
import ru.aston.sort_app.controller.MenuController;
import ru.aston.sort_app.controller.actions.GenerateBook;
import ru.aston.sort_app.controller.actions.GenerateCar;
import ru.aston.sort_app.core.Book;
import ru.aston.sort_app.core.Car;
import ru.aston.sort_app.core.UserInputChoice;
import ru.aston.sort_app.dao.BookFileDAO;
import ru.aston.sort_app.dao.CarFileDAO;
import ru.aston.sort_app.dao.CarMemoryDAO;
import ru.aston.sort_app.dao.FileDAO;
import ru.aston.sort_app.dao.MemoryDAO;
import ru.aston.sort_app.services.BookService;
import ru.aston.sort_app.services.CarService;
import ru.aston.sort_app.services.Service;
import ru.aston.sort_app.view.ConsolePrinter;
import ru.aston.sort_app.view.ConsoleReader;
import ru.aston.sort_app.view.MenuView;
import ru.aston.sort_app.view.MessagePrinter;
import ru.aston.sort_app.view.Reader;
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
        MessagePrinter messagePrinter = new ConsolePrinter();
        Reader reader = new ConsoleReader();

        List<Car> cars = new ArrayList<>();
        List<Book> books = new ArrayList<>();

        FileDAO<Car> carFileDAO = new CarFileDAO();
        FileDAO<Book> bookFileDAO = new BookFileDAO();

        MemoryDAO<Car> carMemoryDAO = new CarMemoryDAO();

        Service<Car> carService = new CarService(carFileDAO, carMemoryDAO);
        BookService bookService = new BookService(bookFileDAO);

        GenerateCar generateCar = new GenerateCar(messagePrinter, reader, carService, cars);
        GenerateBook generateBook = new GenerateBook(messagePrinter, bookService, books);

        Map<UserInputChoice, MenuView> menus = new HashMap<>();
        menus.put(UserInputChoice.MENU_MAIN, new MainMenu());
        menus.put(UserInputChoice.MENU_ADD_DATA, new AddMenu());
        menus.put(UserInputChoice.MENU_SEARCH, new SearchMenu());
        menus.put(UserInputChoice.MENU_SORT, new SortMenu());
        menus.put(UserInputChoice.MENU_FILE_GENERATED, new FileMenu());
        menus.put(UserInputChoice.MENU_USER_GENERATED, new ManualMenu());
        menus.put(UserInputChoice.MENU_RANDOM_GENERATION, new GenerateMenu());

        Map<UserInputChoice, MenuAction> actions = new HashMap<>();
        actions.put(UserInputChoice.ACTION_CAR_MANUAL_GENERATED, generateCar);
        actions.put(UserInputChoice.ACTION_CAR_FILE_GENERATED, generateCar);
        actions.put(UserInputChoice.ACTION_CAR_RANDOM_GENERATED, generateCar);
        actions.put(UserInputChoice.ACTION_BOOK_FILE_GENERATED, generateBook);
        actions.put(UserInputChoice.ACTION_BOOK_RANDOM_GENERATED, generateBook);



        MenuController defaultMenuController = new DefaultMenuController(messagePrinter, menus, actions);
        defaultMenuController.handleMenu();
    }
}