package ru.aston.sort_app.services.sorts.shell;

import ru.aston.sort_app.services.sorts.SortStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ShellSort<T> implements SortStrategy<T> {
    Comparator<T> comparator;

    @Override
    public void sort(ArrayList<T> array) {
        int size = array.size(), d = size / 2;
        while (d >= 1) {
            for (int i = 0; i < size / d - 1; i++) {
                if (comparator.compare(array.get(i * d), array.get((i + 1) * d)) > 0)
                    Collections.swap(array, i * d, (i + 1) * d);
            }
            d /= 2;
        }
    }
}
