
package utils;

import ru.aston.sort_app.core.RootCrop;

import java.util.Random;
import java.util.Scanner;

public class RootCropInputHandler {

    private static final Random random = new Random();
    private static final Scanner scanner = new Scanner(System.in);
    
    private static final String[] rootCropTypes = {
        "Морковь", "Картофель", "Свекла", "Редька", "Топинамбур", "Батат"
    };

    private static final String[] rootCropColors = {
        "Оранжевый", "Коричневый", "Красный", "Белый", "Желтый", "Зеленый"
    };


    // Generate a single random RootCrop
    public static RootCrop randomRootCrop() {

         // Pick a random root crop type from the array
        String type = rootCropTypes[random.nextInt(rootCropTypes.length)];
    
        // Generate a random weight between 100 and 1100 grams
        int weight = random.nextInt(1000) + 100;

        // Pick a random color from the array
        String color = rootCropColors[random.nextInt(rootCropColors.length)];

        return new RootCrop.Builder()
            .setType(type)
            .setWeight(weight)
            .setColor(color)
            .build();
 }

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

    // Parse a single RootCrop from a file line
    public static RootCrop parseRootCropFromFile(String line) {
        try {
            // Assuming file line format: "Type,Weight,Color"
            String[] parts = line.split(",");
            String type = parts[0].trim();
            int weight = Integer.parseInt(parts[1].trim());
            String color = parts[2].trim();
            return new RootCrop.Builder()
                    .setType(type)
                    .setWeight(weight)
                    .setColor(color)
                    .build();
        } catch (Exception e) {
            System.err.println("Error parsing RootCrop from line: " + line);
            return null; 
        }
    }

}