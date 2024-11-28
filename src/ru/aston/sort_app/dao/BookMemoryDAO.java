package ru.aston.sort_app.dao;

import ru.aston.sort_app.core.Book;

import java.util.ArrayList;
import java.util.List;

public class BookMemoryDAO implements MemoryDAO<Book> {
    private final List<Book> books = new ArrayList<>();

    @Override
    public List<Book> get(int amount) {
        return books.subList(0, Math.min(amount, books.size()));
    }

    public void add(Book book) {
        books.add(book);
    }

}
