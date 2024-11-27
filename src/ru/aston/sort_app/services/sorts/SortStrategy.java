package ru.aston.sort_app.services.sorts;

import java.util.ArrayList;

public interface SortStrategy<T> {
    void sort(ArrayList<T> array);
}
