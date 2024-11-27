package ru.aston.sort_app.controller.actions;

import ru.aston.sort_app.controller.MenuAction;
import ru.aston.sort_app.core.Book;
import ru.aston.sort_app.core.UserInputChoice;
import ru.aston.sort_app.services.Service;
import ru.aston.sort_app.view.MessagePrinter;
import ru.aston.sort_app.view.Reader;

import java.util.List;

public class SortBook implements MenuAction {
    private final MessagePrinter messagePrinter;
    private final Reader reader;

    private final Service<Book> bookService;
    private final List<Book> books;

    public SortBook(MessagePrinter messagePrinter, Reader reader, Service<Book> bookService, List<Book> books) {
        this.messagePrinter = messagePrinter;
        this.reader = reader;
        this.bookService = bookService;
        this.books = books;
    }

    @Override
    public void execute(UserInputChoice choice) {
        /*messagePrinter.printMessage("Выберите критерий сортировки:");
        messagePrinter.printMessage("1 - По названию");
        messagePrinter.printMessage("2 - По автору");
        messagePrinter.printMessage("3 - По количеству страниц");

        int sortChoice = Integer.parseInt(reader.getStringInput());

        switch (sortChoice) {
            case 1:
                bookService.sort(books);
                break;
            case 2:
                bookService.sort(books);
                break;
            case 3:
                bookService.sort(books);
                break;
            default:
                messagePrinter.printMessage("Некорректный выбор.");
                return;
        }*/
        bookService.sort(books);
        messagePrinter.printMessage(books.toString());
    }
}
