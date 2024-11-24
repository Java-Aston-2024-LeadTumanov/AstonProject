package ru.aston.sort_app.controller;

import ru.aston.sort_app.services.CarService;
import ru.aston.sort_app.view.MenuView;
import ru.aston.sort_app.core.UserInputChoice;

import java.io.Console;
import java.util.Map;

public class DefaultMenuController implements MenuController {
    private MenuView menuView;
    private final Map<UserInputChoice, MenuView> menus;
    //private final Map<UserInputChoice, MenuAction> actions;

    public DefaultMenuController(MenuView menuView,  Map<UserInputChoice, MenuView> menus, Map<UserInputChoice, MenuAction> actions) {
        this.menuView = menuView;
        this.menus = menus;
        //this.actions = actions;
    }

    @Override
    public void handleMenu() {
        UserInputChoice choice;
        do {
            menuView.showMenu();
            choice = menuView.getUserInputChoice();
            if (choice == null){
                System.out.println("Введённой команды не существует");
            }
            if (menus.containsKey(choice)){
                menuView = menus.get(choice);
            }
//            else if(actions.containsKey(choice)) {
//                actions.get(choice).execute();
//            }
        }
        while (choice!= UserInputChoice.EXIT);
    }
}
