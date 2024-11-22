package ru.aston.sort_app.controller;

import ru.aston.sort_app.services.CarService;
import ru.aston.sort_app.view.MenuView;
import ru.aston.sort_app.core.UserInputChoice;

import java.util.Map;

public class DefaultMenuController implements MenuController {
    private final MenuView view;
    private final Map<UserInputChoice, MenuAction> mapChoice;
    private final CarService carService;

    public DefaultMenuController(MenuView view, Map<UserInputChoice, MenuAction> mapChoice, CarService carService) {
        this.view = view;
        this.mapChoice = mapChoice;
        this.carService = carService;
    }

    @Override
    public void handleMenu() {
        while (true) {
            view.showMenu();
            UserInputChoice choice = view.getUserInputChoice();
//            1. Ввести данные вручную
//            2. Загрузить данные из файла
//            3. Сгенерировать случайные данные
//            4. Выполнить сортировку
//            5. Найти элемент
//            6. Сохранить данные в файл
//            7. Выйти из программы
            switch (choice) {
                default:
            }
        }
    }
}
