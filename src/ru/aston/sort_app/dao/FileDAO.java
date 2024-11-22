package ru.aston.sort_app.dao;

public interface FileDAO<T> {
    T read();
    void write(String str);
}
