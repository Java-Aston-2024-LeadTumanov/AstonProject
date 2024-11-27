package ru.aston.sort_app.view;

import java.util.Scanner;

public class ConsoleReader implements Reader{
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String getStringInput() {
        return scanner.nextLine();
    }

}
