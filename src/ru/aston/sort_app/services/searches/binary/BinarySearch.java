package ru.aston.sort_app.services.searches.binary;

import ru.aston.sort_app.services.searches.SearchStrategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class BinarySearch<T> implements SearchStrategy<T> {
    Comparator<T> comparator;

    @Override
    public List<T> find(List<T> list, T item) {
        ArrayList<T> array = (ArrayList<T>) list;
        int begin = 0,
                end = array.size() - 1,
                middle = (begin + end) / 2,
                compareResult,
                requiredItemIndex = -1;
        while (begin < end) {
            compareResult = comparator.compare(item, array.get(middle));
            if (compareResult == 0) {
                requiredItemIndex = middle;
                break;
            }
            if (compareResult < 0)
                end = middle - 1;
            else
                begin = middle + 1;
            middle = (begin + end) / 2;
        }

        if (begin == end && comparator.compare(item, array.get(end)) == 0) {
            requiredItemIndex = end;
        }

        ArrayList<T> result = new ArrayList<>();
        if (requiredItemIndex == -1)
            return result;
        begin = requiredItemIndex - 1;
        end = requiredItemIndex + 1;
        while (begin >= 0 && item.equals(array.get(begin)))
            begin--;
        while (end < array.size() && item.equals(array.get(end)))
            end++;
        for (int i = begin + 1; i < end; i++) {
            result.add(array.get(i));
        }
        return result;
    }
}
