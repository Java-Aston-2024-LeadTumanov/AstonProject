package ru.aston.sort_app.controller.actions;

import ru.aston.sort_app.controller.MenuAction;
import ru.aston.sort_app.core.Book;
import ru.aston.sort_app.core.UserInputChoice;
import ru.aston.sort_app.services.Generator;
import ru.aston.sort_app.view.MessagePrinter;

public class GenerateBook implements MenuAction {
    private final MessagePrinter messagePrinter;
    private final Generator<Book> bookService;

    public GenerateBook(MessagePrinter messagePrinter, Generator<Book> bookService) {
        this.messagePrinter = messagePrinter;
        this.bookService = bookService;
    }

    @Override
    public void execute(UserInputChoice choice) {
        bookService.generate(choice); // Генерация книг
        messagePrinter.printMessage("Данные успешно добавлены в коллекцию");
    }
}
