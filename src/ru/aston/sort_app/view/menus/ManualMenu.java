package ru.aston.sort_app.view.menus;

import ru.aston.sort_app.core.UserInputChoice;
import ru.aston.sort_app.view.MenuView;
import ru.aston.sort_app.view.UserInputValidation;

import java.util.Scanner;

public class ManualMenu implements MenuView {
    private final Scanner scanner = new Scanner(System.in);
    @Override
    public void showMenu() {
        System.out.println("Меню: Выбор класса");
        System.out.println("1 - Машина");
        System.out.println("2 - Книга");
        System.out.println("3 - Корнеплод");
        System.out.println("4 - Вернуться в меню");
    }

    @Override
    public UserInputChoice getUserInputChoice() {
        System.out.println("Введите число для действия:");
        return switch (UserInputValidation.InValidation(4)){
            case 1 -> UserInputChoice.CAR_MANUAL;
            case 2 -> UserInputChoice.BOOK_MANUAL;
            case 3 -> UserInputChoice.ROOTCROP_MANUAL;
            case 4 -> UserInputChoice.BACK_MENU;
            default -> null;
        };
    }
}
