package ru.aston.sort_app.services.comparators.book_comparators;

import ru.aston.sort_app.core.Book;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {
    Comparator<Book> bookAuthorComparator = new BookAuthorComparator(),
            bookTitleComparator = new BookTitleComparator(),
            bookPageCountComparator = new BookPageCountComparator();

    @Override
    public int compare(Book book1, Book book2) {
        return bookAuthorComparator
                .thenComparing(bookTitleComparator)
                .thenComparing(bookPageCountComparator)
                .compare(book1, book2);
    }
}
