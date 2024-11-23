package ru.aston.sort_app.view.menus;

import ru.aston.sort_app.core.UserInputChoice;
import ru.aston.sort_app.view.MenuView;

import java.util.Scanner;

public class GenerateMenu implements MenuView {
    private final Scanner scanner = new Scanner(System.in);
    @Override
    public void showMenu() {
        System.out.println("Меню: Выбор класса");
        System.out.println("1 - Машина");
        System.out.println("2 - Книга");
        System.out.println("3 - Корнеплод");
        System.out.println("4 - Выйти из программы");

    }

    @Override
    public UserInputChoice getUserInputChoice() {
        System.out.println("Введите число для действия:");
        return switch (scanner.next().trim()){
            case "1" -> UserInputChoice.CAR_RANDOM;
            case "2" -> UserInputChoice.BOOK_RANDOM;
            case "3" -> UserInputChoice.ROOTCROP_RANDOM;
            case "4" -> UserInputChoice.BACK_MENU;
            default -> null;
        };
    }
}
