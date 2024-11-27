package ru.aston.sort_app.services;

import ru.aston.sort_app.core.UserInputChoice;

import java.util.List;

public interface Generator<T> {
    List<T> generate(UserInputChoice generateType, int size);
}
