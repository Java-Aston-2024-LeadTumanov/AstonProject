package ru.aston.sort_app.view.menus;

import ru.aston.sort_app.core.UserInputChoice;
import ru.aston.sort_app.view.MenuView;

import java.util.Scanner;

public class AddMenu implements MenuView {
    private final Scanner scanner = new Scanner(System.in);
    @Override
    public void showMenu() {
        System.out.println("Меню: Добавление данных");
        System.out.println("1 - Ввести данные вручную");
        System.out.println("2 - Добавить данные из файла");
        System.out.println("3 - Сгенерировать данные");
        System.out.println("4 - Вернуться в меню");
    }

    @Override
    public UserInputChoice getUserInputChoice() {
        System.out.println("Введите число для действия:");
        return switch (scanner.next().trim()){
            case "1" -> UserInputChoice.USER_GENERATED;
            case "2" -> UserInputChoice.FILE_GENERATED;
            case "3" -> UserInputChoice.RANDOM_GENERATION;
            case "4" -> UserInputChoice.BACK_MENU;
            default -> null;
        };
    }
}
