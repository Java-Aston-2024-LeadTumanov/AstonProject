package ru.aston.sort_app.services;

import java.util.List;

public interface SortStrategy<T> {
    void sort(List<T> collection);
}
