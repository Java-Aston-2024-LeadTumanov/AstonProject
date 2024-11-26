package ru.aston.sort_app.dao;

import java.util.List;

public interface DAO<T> {
//    T read();
//    void write(String str);
    List<T> get(int amount);
}
