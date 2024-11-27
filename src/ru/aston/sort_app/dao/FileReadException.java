package ru.aston.sort_app.dao;

public class FileReadException extends RuntimeException {
    public FileReadException(String message) {
        super(message);
    }

    public FileReadException(String message, Throwable cause) {
        super(message, cause);
    }
}
