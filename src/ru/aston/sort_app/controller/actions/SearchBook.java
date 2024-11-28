package ru.aston.sort_app.controller.actions;

import ru.aston.sort_app.controller.MenuAction;
import ru.aston.sort_app.core.Book;
import ru.aston.sort_app.core.UserInputChoice;
import ru.aston.sort_app.services.Service;
import ru.aston.sort_app.services.validators.BookValidator;
import ru.aston.sort_app.view.MessagePrinter;
import ru.aston.sort_app.view.Reader;

import java.util.List;

public class SearchBook implements MenuAction {
    private final MessagePrinter messagePrinter;
    private final Reader reader;
    private final Service<Book> bookService;
    private final List<Book> books;

    public SearchBook(MessagePrinter messagePrinter, Reader reader, Service<Book> bookService, List<Book> books) {
        this.messagePrinter = messagePrinter;
        this.reader = reader;
        this.bookService = bookService;
        this.books = books;
    }

    @Override
    public void execute(UserInputChoice choice) {
        String title;
        String author;
        int pageCount;

        messagePrinter.printMessage("Введите данные для поиска книги: ");

        do {
            messagePrinter.printMessage("Введите название:");
            title = reader.getStringInput();
            if (BookValidator.validateTitle(title))
                break;
            else messagePrinter.printMessage("Данные не прошли валидацию");
        } while (true);

        do {
            messagePrinter.printMessage("Введите автора:");
            author = reader.getStringInput();
            if (BookValidator.validateAuthor(author))
                break;
            else messagePrinter.printMessage("Данные не прошли валидацию");
        } while (true);

        do {
            messagePrinter.printMessage("Введите количество страниц:");
            String pageCountStr = reader.getStringInput();
            if (BookValidator.validatePageCount(pageCountStr)) {
                pageCount = Integer.parseInt(pageCountStr);
                break;
            }
            else messagePrinter.printMessage("Данные не прошли валидацию");
        } while (true);

        Book book = new Book.Builder()
                .setTitle(title)
                .setAuthor(author)
                .setPageCount(pageCount)
                .build();

        messagePrinter.printMessage(bookService.find(books, book).toString());
    }
}
