package ru.aston.sort_app.view;

public class ConsolePrinter implements MessagePrinter{
    public void printMessage(String message) {
        System.out.println(message);
    }
}
