package ru.aston.sort_app;

import ru.aston.sort_app.controller.DefaultMenuController;
import ru.aston.sort_app.controller.MenuAction;
import ru.aston.sort_app.controller.MenuController;
import ru.aston.sort_app.controller.actions.*;
import ru.aston.sort_app.core.Book;
import ru.aston.sort_app.core.Car;
import ru.aston.sort_app.core.RootCrop;
import ru.aston.sort_app.core.UserInputChoice;
import ru.aston.sort_app.dao.*;
import ru.aston.sort_app.services.BookService;
import ru.aston.sort_app.services.CarService;
import ru.aston.sort_app.services.RootCropService;
import ru.aston.sort_app.services.Service;
import ru.aston.sort_app.services.searches.SearchStrategy;
import ru.aston.sort_app.services.searches.binary.BookBinarySearch;
import ru.aston.sort_app.services.searches.binary.CarBinarySearch;
import ru.aston.sort_app.services.searches.binary.RootCropBinarySearch;
import ru.aston.sort_app.services.sorts.SortStrategy;
import ru.aston.sort_app.services.sorts.shell.BookShellSort;
import ru.aston.sort_app.services.sorts.shell.CarShellSort;
import ru.aston.sort_app.services.sorts.shell.RootCropShellSort;
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

        SortStrategy<Car> carSortStrategy = new CarShellSort();
        SortStrategy<Book> bookSortStrategy = new BookShellSort();
        SortStrategy<RootCrop> rootCropSortStrategy = new RootCropShellSort();

        SearchStrategy<Car> carSearchStrategy = new CarBinarySearch();
        SearchStrategy<Book> bookSearchStrategy = new BookBinarySearch();
        SearchStrategy<RootCrop> rootCropSearchStrategy = new RootCropBinarySearch();

        List<Car> cars = new ArrayList<>();
        List<Book> books = new ArrayList<>();
        List<RootCrop> rootCrops = new ArrayList<>();

        FileDAO<Car> carFileDAO = new CarFileDAO();
        FileDAO<Book> bookFileDAO = new BookFileDAO();
        FileDAO<RootCrop> rootCropFileDAO = new RootCropDAO();

        MemoryDAO<Car> carMemoryDAO = new CarMemoryDAO();
        MemoryDAO<Book> bookMemoryDAO = new BookMemoryDAO();
        MemoryDAO<RootCrop> rootCropMemoryDAO = new RootCropMemoryDAO();

        Service<Car> carService = new CarService(carFileDAO, carMemoryDAO, carSortStrategy, carSearchStrategy);
        Service<Book> bookService = new BookService(bookFileDAO, bookMemoryDAO, bookSortStrategy, bookSearchStrategy);
        Service<RootCrop> rootCropService = new RootCropService(rootCropFileDAO, rootCropMemoryDAO, rootCropSortStrategy, rootCropSearchStrategy);

        MenuAction generateCar = new GenerateCar(messagePrinter, reader, carService, cars);
        MenuAction generateBook = new GenerateBook(messagePrinter, bookService, books);
        MenuAction generateRootCrop = new GenerateRootCrop(messagePrinter, reader, rootCropService, rootCrops);


        MenuAction searchCar = new SearchCar(messagePrinter, reader, carService, cars);


        MenuAction sortCar = new SortCar(messagePrinter, reader, carService, cars);


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
        actions.put(UserInputChoice.ACTION_ROOTCROP_MANUAL_GENERATED, generateRootCrop);
        actions.put(UserInputChoice.ACTION_ROOTCROP_FILE_GENERATED, generateRootCrop);
        actions.put(UserInputChoice.ACTION_ROOTCROP_RANDOM_GENERATED, generateRootCrop);
        actions.put(UserInputChoice.ACTION_CAR_SORT, sortCar);
        actions.put(UserInputChoice.ACTION_CAR_SEARCH, searchCar);



        MenuController defaultMenuController = new DefaultMenuController(messagePrinter, menus, actions);
        defaultMenuController.handleMenu();
    }
}