package ru.aston.sort_app.controller.actions;

import ru.aston.sort_app.controller.MenuAction;
import ru.aston.sort_app.core.Book;
import ru.aston.sort_app.core.UserInputChoice;
import ru.aston.sort_app.services.Generator;
import ru.aston.sort_app.view.InputValidator;
import ru.aston.sort_app.view.MessagePrinter;

import java.util.List;

public class GenerateBook implements MenuAction {
    private final MessagePrinter messagePrinter;
    private final Generator<Book> bookService;
    private final List<Book> books;

    public GenerateBook(MessagePrinter messagePrinter, Generator<Book> bookService, List<Book> books) {
        this.messagePrinter = messagePrinter;
        this.bookService = bookService;
        this.books = books;
    }

    @Override
    public void execute(UserInputChoice choice) {

        messagePrinter.printMessage("Введите количество элементов (не более 30):");
        int size = InputValidator.getValidatedInput(30);
        books.addAll(bookService.generate(choice, size));
        messagePrinter.printMessage(books.toString());
    }
}
