package ru.aston.sort_app.view;

import java.util.Scanner;

public class UserInputValidation {
    private static final Scanner scanner = new Scanner(System.in);
    public static int InValidation(int count){
        if (scanner.hasNextInt()){
           int value = scanner.nextInt();
            if (value >=1 && value<=count){
                return value;
            }
        }
        else{
            scanner.next();
        }
        return 0;
    }
}
