package ru.aston.sort_app.services;

import ru.aston.sort_app.services.searches.SearchStrategy;
import ru.aston.sort_app.services.sorts.SortStrategy;

public abstract class Service<T> implements Generator<T>, SearchStrategy<T>, SortStrategy<T> {
    private final SearchStrategy<T> searchStrategy;
    private final SortStrategy<T> sortStrategy;

    protected Service(SearchStrategy<T> searchStrategy, SortStrategy<T> sortStrategy) {
        this.searchStrategy = searchStrategy;
        this.sortStrategy = sortStrategy;
    }

    public SearchStrategy<T> getSearchStrategy() {
        return searchStrategy;
    }

    public SortStrategy<T> getSortStrategy() {
        return sortStrategy;
    }

    public abstract void add(T item);

}
