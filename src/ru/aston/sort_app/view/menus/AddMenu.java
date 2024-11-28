package ru.aston.sort_app.view.menus;

import ru.aston.sort_app.core.UserInputChoice;
import ru.aston.sort_app.view.MenuView;
import ru.aston.sort_app.view.InputValidator;

import java.util.Scanner;

public class AddMenu implements MenuView {
    @Override
    public void showMenu() {
        System.out.println("Меню: Добавление данных");
        System.out.println("1 - Ввести данные вручную");
        System.out.println("2 - Добавить данные из файла");
        System.out.println("3 - Сгенерировать данные");
        System.out.println("4 - Вернуться назад");
    }

    @Override
    public UserInputChoice getUserInputChoice() {
        System.out.println("Введите число для действия:");
        return switch (InputValidator.getValidatedInput(4)){
            case 1 -> UserInputChoice.MENU_USER_GENERATED;
            case 2 -> UserInputChoice.MENU_FILE_GENERATED;
            case 3 -> UserInputChoice.MENU_RANDOM_GENERATION;
            case 4 -> UserInputChoice.MENU_MAIN;
            default -> null;
        };
    }
}
