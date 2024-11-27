package ru.aston.sort_app.view;

import java.util.Scanner;

public class InputValidator {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getValidatedInput(int maxLimit) {
        while (true) {
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                if (value >= 1 && value <= maxLimit) {
                    return value;
                } else {
                    System.out.println("Ошибка: число должно быть в диапазоне от 1 до " + maxLimit + ".");
                }
            } else {
                System.out.println("Ошибка: введите корректное целое число.");
                scanner.next();
            }
        }
    }
}
