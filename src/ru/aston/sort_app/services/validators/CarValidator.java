package ru.aston.sort_app.services.validators;

import java.time.Year;

public class CarValidator {
    public static boolean validatePower(String powerStr) {
        if (powerStr == null || powerStr.isBlank())
            return false;

        int power;
        try {
            power = Integer.parseInt(powerStr);
        }
        catch (Exception _) {
            return false;
        }
        return power > 0;
    }

    public static boolean validateModel(String modelStr) {
        return modelStr != null && !modelStr.isBlank();
    }

    public static boolean validateYear(String yearStr) {
        if (yearStr == null || yearStr.isBlank())
            return false;

        int year;
        try {
            year = Integer.parseInt(yearStr);
        }
        catch (Exception _) {
            return false;
        }
        return year >= 1900 && year <= Year.now().getValue();
    }
}
