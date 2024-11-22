package ru.aston.sort_app.services;

import ru.aston.sort_app.core.GenerateType;

import java.util.List;

public interface Generator<T> {
    List<T> generate(GenerateType generateType);
}
