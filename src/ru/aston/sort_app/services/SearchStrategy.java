package ru.aston.sort_app.services;

import java.util.List;

public interface SearchStrategy<T> {
    List<T> find(T item);
}
