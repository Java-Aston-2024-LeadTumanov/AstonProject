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
        //TODO Доделать
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
