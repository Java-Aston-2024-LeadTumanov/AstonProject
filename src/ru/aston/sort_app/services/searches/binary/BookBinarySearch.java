package ru.aston.sort_app.services.searches.binary;

import ru.aston.sort_app.core.Book;
import ru.aston.sort_app.services.comparators.book_comparators.BookComparator;

public class BookBinarySearch extends BinarySearch<Book> {
    public BookBinarySearch() {
        this.comparator = new BookComparator();
    }
}
