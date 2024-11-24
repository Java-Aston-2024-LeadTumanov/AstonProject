package ru.aston.sort_app.view.menus;

import ru.aston.sort_app.core.UserInputChoice;
import ru.aston.sort_app.view.MenuView;
import ru.aston.sort_app.view.UserInputValidation;

import java.util.Scanner;

public class SortMenu implements MenuView {
    private final Scanner scanner = new Scanner(System.in);
    @Override
    public void showMenu() {
        System.out.println("Меню: Выбор класса для сортировки");
        System.out.println("1 - Машина");
        System.out.println("2 - Книга");
        System.out.println("3 - Корнеплод");
        System.out.println("4 - Вернуться в меню");
    }

    @Override
    public UserInputChoice getUserInputChoice() {
        System.out.println("Введите число для действия:");
        return switch (UserInputValidation.InValidation(5)){
            case 1 -> UserInputChoice.ACTION_CAR_SORT;
            case 2 -> UserInputChoice.ACTION_BOOK_SORT;
            case 3 -> UserInputChoice.ACTION_ROOTCROP_SORT;
            case 4 -> UserInputChoice.BACK_MENU;
            default -> null;
        };
    }
}
