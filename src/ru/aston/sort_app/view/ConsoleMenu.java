package ru.aston.sort_app.view;

import ru.aston.sort_app.core.UserInputChoice;

public class ConsoleMenu implements MenuView {

    @Override
    public void showMenu() {
        System.out.println("Выберите способ генерации данных: 1");
    }

    @Override
    public UserInputChoice getUserInputChoice() {

        return UserInputChoice.RANDOM_GENERATION;
    }
}
