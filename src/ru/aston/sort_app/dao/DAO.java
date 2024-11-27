package ru.aston.sort_app.dao;

import java.util.List;

public interface DAO<T> {
    List<T> get(int amount);
}
