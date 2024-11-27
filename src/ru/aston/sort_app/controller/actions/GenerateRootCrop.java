package ru.aston.sort_app.controller.actions;

import java.util.Random;
import java.util.Scanner;

import ru.aston.sort_app.core.RootCrop;

import java.util.Scanner;


public class GenerateRootCrop{

    private static final Scanner scanner = new Scanner(System.in);

    // Get a single RootCrop via user input
    public static RootCrop userInputRootCrop() {
        System.out.print("Enter root crop type: ");
        String type = scanner.nextLine();
        System.out.print("Enter root crop weight (in grams): ");
        int weight = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter root crop color: ");
        String color = scanner.nextLine();
        return new RootCrop.Builder()
                .setType(type)
                .setWeight(weight)
                .setColor(color)
                .build();
    }

}
