package ru.aston.sort_app.services.searches;

import java.util.List;

public interface SearchStrategy<T> {
    List<T> find(List<T> list, T item);
}
