package ru.aston.sort_app.services;

import ru.aston.sort_app.core.Car;
import ru.aston.sort_app.services.searches.SearchStrategy;
import ru.aston.sort_app.services.sorts.SortStrategy;

public interface Service<T> extends Generator<T>, SearchStrategy<T>, SortStrategy<T> {
    void add(T item);
}
