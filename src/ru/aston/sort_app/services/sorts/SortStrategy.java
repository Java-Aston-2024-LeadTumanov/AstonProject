package ru.aston.sort_app.services.sorts;

import java.util.ArrayList;
import java.util.List;

public interface SortStrategy<T> {
    void sort(List<T> list);
}
