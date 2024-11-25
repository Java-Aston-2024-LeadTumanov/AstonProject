package ru.aston.sort_app.services.comparators.book_comparators;

import ru.aston.sort_app.core.Book;

import java.util.Comparator;

public class BookPageCountComparator implements Comparator<Book> {
    @Override
    public int compare(Book book1, Book book2) {
        if (book1.getPageCount() == book2.getPageCount())
            return 0;
        else return book1.getPageCount() < book2.getPageCount() ? -1 : 1;
    }
}
