package ru.aston.sort_app.services.validators;

public class RootCropValidator {
    public static boolean validateType(String typeStr) {
        return typeStr != null && !typeStr.isBlank();
    }

    public static boolean validateColor(String colorStr) {
        return colorStr != null && !colorStr.isBlank();
    }

    public static boolean validateWeight(String weightStr) {
        if (weightStr == null || weightStr.isBlank())
            return false;

        int weight;
        try {
            weight = Integer.parseInt(weightStr);
        }
        catch (Exception _) {
            return false;
        }
        return weight > 0;
    }
}
