package ru.aston.sort_app.view.menus;

import ru.aston.sort_app.core.UserInputChoice;
import ru.aston.sort_app.view.MenuView;
import ru.aston.sort_app.view.InputValidator;

import java.util.Scanner;

public class ManualMenu implements MenuView {
    private final Scanner scanner = new Scanner(System.in);
    @Override
    public void showMenu() {
        System.out.println("Меню: Выбор класса");
        System.out.println("1 - Машина");
        System.out.println("2 - Книга");
        System.out.println("3 - Корнеплод");
        System.out.println("4 - Вернуться назад");
    }

    @Override
    public UserInputChoice getUserInputChoice() {
        System.out.println("Введите число для действия:");
        return switch (InputValidator.getValidatedInput(4)){
            case 1 -> UserInputChoice.ACTION_CAR_MANUAL_GENERATED;
            case 2 -> UserInputChoice.ACTION_BOOK_MANUAL_GENERATED;
            case 3 -> UserInputChoice.ACTION_ROOTCROP_MANUAL_GENERATED;
            case 4 -> UserInputChoice.MENU_ADD_DATA;
            default -> null;
        };
    }
}
