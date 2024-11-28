package ru.aston.sort_app.view.menus;

import ru.aston.sort_app.core.UserInputChoice;
import ru.aston.sort_app.view.MenuView;
import ru.aston.sort_app.view.InputValidator;

import java.util.Scanner;

public class SortMenu implements MenuView {
    @Override
    public void showMenu() {
        System.out.println("Меню: Выбор класса для сортировки");
        System.out.println("1 - Машина");
        System.out.println("2 - Книга");
        System.out.println("3 - Корнеплод");
        System.out.println("4 - Вернуться назад");
    }

    @Override
    public UserInputChoice getUserInputChoice() {
        System.out.println("Введите число для действия:");
        return switch (InputValidator.getValidatedInput(4)){
            case 1 -> UserInputChoice.ACTION_CAR_SORT;
            case 2 -> UserInputChoice.ACTION_BOOK_SORT;
            case 3 -> UserInputChoice.ACTION_ROOTCROP_SORT;
            case 4 -> UserInputChoice.MENU_MAIN;
            default -> null;
        };
    }
}
