package ru.aston.sort_app.controller.actions;

import java.io.Reader;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import ru.aston.sort_app.services.Service;
import ru.aston.sort_app.services.RootCropService;
import ru.aston.sort_app.view.InputValidator;
import ru.aston.sort_app.core.RootCrop;
import java.util.Scanner;

import ru.aston.sort_app.controller.MenuAction;
import ru.aston.sort_app.core.UserInputChoice;




public class GenerateRootCrop implements MenuAction{


    private final Service<RootCrop> RootCropService;
    private final List<RootCrop> rootCrops;
    private static final Scanner scanner = new Scanner(System.in);

    public GenerateRootCrop(Scanner scanner,  Service<RootCrop> RootCropService, List<RootCrop> rootcrops) {
        this.RootCropService = RootCropService;
        this.rootCrops = rootCrops;
    }


     @Override
    public void execute(UserInputChoice choice) {

        if (choice == UserInputChoice.ACTION_ROOTCROP_MANUAL_GENERATED) {
            System.out.print("Введите данные для корнеплода. Для завершения ввода введите 'exit' в поле модели.");
            int count = 0;

        //loop through all rootcrops that user inputs
            while (true) {
                
               // Get a single RootCrop via user input
        
            System.out.print("Enter root crop type: ");
            String type = scanner.nextLine();
            System.out.print("Enter root crop weight (in grams): ");
            int weight = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter root crop color: ");
            String color = scanner.nextLine();

            RootCrop rootCrop = new RootCrop.Builder()
                    .setType(type)
                    .setWeight(weight)
                    .setColor(color)
                    .build();

            RootCropService.add(rootCrop);
            count++;
            }

            rootCrops.addAll(RootCropService.generate(choice, count));
        } 

        else {
            System.out.print("Введите количество элементов (не более 30):");
            int size = InputValidator.getValidatedInput(30);
            rootCrops.addAll(RootCropService.generate(choice, size));
            System.out.print(rootCrops.toString());
        }
    }

}
