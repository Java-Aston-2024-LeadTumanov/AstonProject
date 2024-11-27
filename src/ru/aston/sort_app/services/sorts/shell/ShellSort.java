package ru.aston.sort_app.services.sorts.shell;

import ru.aston.sort_app.services.sorts.SortStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ShellSort<T> implements SortStrategy<T> {
    Comparator<T> comparator;

    @Override
    public void sort(List<T> list) {
        ArrayList<T> array = (ArrayList<T>) list;
        int size = array.size(), d = size / 2;
        while (d >= 1) {
            for (int i = d; i < size; i++) {
                for (int j = i; j >= d; j -= d) {
                    if (comparator.compare(array.get(j - d), array.get(j)) > 0)
                        Collections.swap(array, j - d, j);
                }
            }
            d /= 2;
        }
    }
}
