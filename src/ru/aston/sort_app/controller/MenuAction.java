package ru.aston.sort_app.controller;

import ru.aston.sort_app.core.UserInputChoice;

public interface MenuAction {
    void execute(UserInputChoice choice);
}
