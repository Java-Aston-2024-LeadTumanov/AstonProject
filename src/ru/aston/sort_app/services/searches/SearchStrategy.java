package ru.aston.sort_app.services.searches;

import java.util.ArrayList;
import java.util.List;

public interface SearchStrategy<T> {
    List<T> find(ArrayList<T> array, T item);
}
