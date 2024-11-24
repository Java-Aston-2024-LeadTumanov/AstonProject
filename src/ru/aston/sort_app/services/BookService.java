package ru.aston.sort_app.services;

import ru.aston.sort_app.core.Book;
import ru.aston.sort_app.core.UserInputChoice;
import ru.aston.sort_app.dao.FileDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BookService implements Generator<Book>, SearchStrategy<Book>, SortStrategy<Book> {
    private final FileDAO fileDao;

    public BookService(FileDAO fileDao) {
        this.fileDao = fileDao;
    }

    @Override
    public List<Book> generate(UserInputChoice generateType) {
        switch (generateType) {
            case ACTION_BOOK_FILE_GENERATED:
                fileDao.read();
                break;
            case ACTION_BOOK_RANDOM_GENERATED:
                return generateRandomBooks(10);
            case ACTIN_BOOK_MANUAL_GENERATED:
                break;
            default:
                break;
        }
        return List.of();
    }

    @Override
    public List<Book> find(Book item) {
        return List.of();
    }

    @Override
    public void sort(List<Book> collection) {
    }

    private List<Book> generateRandomBooks(int count) {
        Random random = new Random();
        List<Book> books = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            String author = "Автор " + random.nextInt(100);
            String title = "Книга " + random.nextInt(1000);
            int pageCount = 50 + random.nextInt(950);

            Book book = new Book.Builder()
                    .setAuthor(author)
                    .setTitle(title)
                    .setPageCount(pageCount)
                    .build();

            books.add(book);
        }

        return books;
    }
}
