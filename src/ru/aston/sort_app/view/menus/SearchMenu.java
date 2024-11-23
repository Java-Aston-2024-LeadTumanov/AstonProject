package ru.aston.sort_app.view.menus;

import ru.aston.sort_app.core.UserInputChoice;
import ru.aston.sort_app.view.MenuView;

import java.util.Scanner;

public class SearchMenu implements MenuView {
    private final Scanner scanner = new Scanner(System.in);
    @Override
    public void showMenu() {
        System.out.println("Меню: Выбор класса для поиска");
        System.out.println("1 - Машина");
        System.out.println("2 - Книга");
        System.out.println("3 - Корнеплод");
        System.out.println("4 - Выйти из программы");

    }

    @Override
    public UserInputChoice getUserInputChoice() {
        System.out.println("Введите число для действия:");
        return switch (scanner.next().trim()){
            case "1" -> UserInputChoice.CAR_SEARCH;
            case "2" -> UserInputChoice.BOOK_SEARCH;
            case "3" -> UserInputChoice.ROOTCROP_SEARCH;
            case "4" -> UserInputChoice.BACK_MENU;
            default -> null;
        };
    }
}
