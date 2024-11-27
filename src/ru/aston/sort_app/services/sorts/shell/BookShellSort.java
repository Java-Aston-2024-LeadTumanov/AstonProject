package ru.aston.sort_app.services.sorts.shell;

import ru.aston.sort_app.core.Book;
import ru.aston.sort_app.services.comparators.book_comparators.BookComparator;

public class BookShellSort extends ShellSort<Book> {
    public BookShellSort() {
        this.comparator = new BookComparator();
    }
}
