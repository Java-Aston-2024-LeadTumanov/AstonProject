package ru.aston.sort_app.services.validators;

public class BookValidator {
    public static boolean validateAuthor(String authorStr) {
        return authorStr != null && !authorStr.isBlank();
    }

    public static boolean validateTitle(String titleStr) {
        return titleStr != null && !titleStr.isBlank();
    }

    public static boolean validatePageCount(String pageCountStr) {
        if (pageCountStr == null || pageCountStr.isBlank())
            return false;

        int pageCount;
        try {
            pageCount = Integer.parseInt(pageCountStr);
        }
        catch (Exception _) {
            return false;
        }
        return pageCount > 0;
    }
}
