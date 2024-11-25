package ru.aston.sort_app.services.comparators.book_comparators;

import ru.aston.sort_app.core.Book;

import java.util.Comparator;

public class BookAuthorComparator implements Comparator<Book> {
    @Override
    public int compare(Book book1, Book book2) {
        return book1.getAuthor().compareTo(book2.getAuthor());
    }
}
