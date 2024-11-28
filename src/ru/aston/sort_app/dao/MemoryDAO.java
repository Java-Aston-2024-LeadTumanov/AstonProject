package ru.aston.sort_app.dao;

public interface MemoryDAO<T> extends DAO<T> {
    void add(T item);
}
