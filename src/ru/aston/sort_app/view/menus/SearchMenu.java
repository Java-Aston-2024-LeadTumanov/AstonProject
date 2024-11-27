package ru.aston.sort_app.view.menus;

import ru.aston.sort_app.core.UserInputChoice;
import ru.aston.sort_app.view.MenuView;
import ru.aston.sort_app.view.InputValidator;

import java.util.Scanner;

public class SearchMenu implements MenuView {
    private final Scanner scanner = new Scanner(System.in);
    @Override
    public void showMenu() {
        System.out.println("Меню: Выбор класса для поиска");
        System.out.println("1 - Машина");
        System.out.println("2 - Книга");
        System.out.println("3 - Корнеплод");
        System.out.println("4 - Вернуться в меню");
    }

    @Override
    public UserInputChoice getUserInputChoice() {
        System.out.println("Введите число для действия:");
        return switch (InputValidator.getValidatedInput(4)){
            case 1 -> UserInputChoice.ACTION_CAR_SEARCH;
            case 2 -> UserInputChoice.ACTION_BOOK_SEARCH;
            case 3 -> UserInputChoice.ACTION_ROOTCROP_SEARCH;
            case 4 -> UserInputChoice.MENU_MAIN;
            default -> null;
        };
    }
}
