package ru.aston.sort_app.view.menus;

import ru.aston.sort_app.core.UserInputChoice;
import ru.aston.sort_app.view.MenuView;
import ru.aston.sort_app.view.InputValidator;

import java.util.Scanner;

public class MainMenu implements MenuView {
    private final Scanner scanner = new Scanner(System.in);
    @Override
    public void showMenu() {
        System.out.println("Меню");
        System.out.println("1 - Добавить данные");
        System.out.println("2 - Выполнить сортировку");
        System.out.println("3 - Найти элемент");
        System.out.println("4 - Сохранить данные в файл");
        System.out.println("5 - Выйти из программы");
    }

    @Override
    public UserInputChoice getUserInputChoice() {
        System.out.println("Введите число для действия:");
        return switch (InputValidator.getValidatedInput(5)){
            case 1 -> UserInputChoice.MENU_ADD_DATA;
            case 2 -> UserInputChoice.MENU_SORT;
            case 3 -> UserInputChoice.MENU_SEARCH;
            case 4 -> UserInputChoice.ACTION_SAVE_DATA;
            case 5 -> UserInputChoice.EXIT;
            default -> null;
        };
    }
}
