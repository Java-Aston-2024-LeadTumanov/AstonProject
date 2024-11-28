package ru.aston.sort_app.controller.actions;

import ru.aston.sort_app.controller.MenuAction;
import ru.aston.sort_app.core.Book;
import ru.aston.sort_app.core.UserInputChoice;
import ru.aston.sort_app.services.Service;
import ru.aston.sort_app.services.validators.BookValidator;
import ru.aston.sort_app.view.InputValidator;
import ru.aston.sort_app.view.MessagePrinter;
import ru.aston.sort_app.view.Reader;

import java.util.List;

public class GenerateBook implements MenuAction {
    private final MessagePrinter messagePrinter;
    private final Reader reader;
    private final Service<Book> bookService;
    private final List<Book> books;
    private int count;

    public GenerateBook(MessagePrinter messagePrinter, Reader reader, Service<Book> bookService, List<Book> books) {
        this.messagePrinter = messagePrinter;
        this.reader = reader;
        this.bookService = bookService;
        this.books = books;
        count = 0;
    }

    @Override
    public void execute(UserInputChoice choice) {
        if (choice == UserInputChoice.ACTION_BOOK_MANUAL_GENERATED) {
            messagePrinter.printMessage("Введите данные для книги. Для завершения ввода введите 'exit' в поле названия.");
            while (true) {
                String title;
                String author;
                int pageCount;
                do {
                    messagePrinter.printMessage("Введите название:");
                    title = reader.getStringInput();
                    if (BookValidator.validateTitle(title))
                        break;
                    else messagePrinter.printMessage("Данные не прошли валидацию");
                } while (true);
                if ("exit".equalsIgnoreCase(title)) {
                    break;
                }

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

                bookService.add(book);
                count++;
            }
            books.addAll(bookService.generate(choice, count));
            messagePrinter.printMessage(books.toString());
        } else {
            messagePrinter.printMessage("Введите количество элементов:");
            int size = InputValidator.getValidatedInput(Integer.MAX_VALUE);
            books.addAll(bookService.generate(choice, size));
            messagePrinter.printMessage(books.toString());
        }
    }
}
