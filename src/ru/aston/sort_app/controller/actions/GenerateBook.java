package ru.aston.sort_app.controller.actions;

import ru.aston.sort_app.controller.MenuAction;
import ru.aston.sort_app.core.Book;
import ru.aston.sort_app.core.UserInputChoice;
import ru.aston.sort_app.services.Service;
import ru.aston.sort_app.view.InputValidator;
import ru.aston.sort_app.view.MessagePrinter;
import ru.aston.sort_app.view.Reader;

import java.util.List;

public class GenerateBook implements MenuAction {
    private final MessagePrinter messagePrinter;
    private final Reader reader;
    private final Service<Book> bookService;
    private final List<Book> books;

    public GenerateBook(MessagePrinter messagePrinter, Reader reader, Service<Book> bookService, List<Book> books) {
        this.messagePrinter = messagePrinter;
        this.reader = reader;
        this.bookService = bookService;
        this.books = books;
    }

    @Override
    public void execute(UserInputChoice choice) {
        if (choice == UserInputChoice.ACTION_BOOK_MANUAL_GENERATED) {
            messagePrinter.printMessage("Введите данные для книги. Для завершения ввода введите 'exit' в поле названия.");
            int count = 0;
            while (true) {
                messagePrinter.printMessage("Введите название:");
                String title = reader.getStringInput();
                if ("exit".equalsIgnoreCase(title)) {
                    break;
                }
                messagePrinter.printMessage("Введите автора:");
                String author = reader.getStringInput();
                messagePrinter.printMessage("Введите количество страниц:");
                int pageCount = Integer.parseInt(reader.getStringInput());

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
            messagePrinter.printMessage("Введите количество элементов (не более 30):");
            int size = InputValidator.getValidatedInput(30);
            books.addAll(bookService.generate(choice, size));
            messagePrinter.printMessage(books.toString());
        }
    }
}
