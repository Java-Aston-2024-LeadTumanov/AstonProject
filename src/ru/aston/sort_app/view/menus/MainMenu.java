package ru.aston.sort_app.view.menus;

import ru.aston.sort_app.core.UserInputChoice;
import ru.aston.sort_app.view.MenuView;
import ru.aston.sort_app.view.UserInputValidation;

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
        return switch (UserInputValidation.InValidation(5)){
            case 1 -> UserInputChoice.ADD_DATA;
            case 2 -> UserInputChoice.SORT;
            case 3 -> UserInputChoice.SEARCH;
            case 4 -> UserInputChoice.SAVE_DATA;
            case 5 -> UserInputChoice.EXIT;
            default -> null;
        };
    }
}
