package ru.aston.sort_app.dao;

import ru.aston.sort_app.core.Book;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookFileDAO implements FileDAO<Book> {
    private static final String FILE_NAME = "src/resources/books.csv";

    @Override
    public List<Book> get(int amount) {
        List<Book> books = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            br.readLine();

            String line;
            int listSize = 0;

            while (listSize < amount && ((line = br.readLine()) != null)) {
                String[] values = line.split(";");
                Book book = new Book.Builder()
                        .setAuthor(values[0])
                        .setTitle(values[1])
                        .setPageCount(Integer.parseInt(values[2]))
                        .build();
                books.add(book);
                listSize++;
            }

        } catch (IOException e) {
            throw new RuntimeException("Ошибка при работе с файлом: " + FILE_NAME, e);
        }

        return books;
    }
}
