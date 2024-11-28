package ru.aston.sort_app.services;

import ru.aston.sort_app.core.Book;
import ru.aston.sort_app.core.UserInputChoice;
import ru.aston.sort_app.dao.FileDAO;
import ru.aston.sort_app.dao.MemoryDAO;
import ru.aston.sort_app.services.searches.SearchStrategy;
import ru.aston.sort_app.services.sorts.SortStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BookService extends Service<Book> {
    private final FileDAO<Book> fileDao;
    private final MemoryDAO<Book> memoryDAO;

    public BookService(FileDAO<Book> fileDao,
                       MemoryDAO<Book> memoryDAO,
                       SortStrategy<Book> sortStrategy,
                       SearchStrategy<Book> searchStrategy) {
        super(searchStrategy, sortStrategy);
        this.fileDao = fileDao;
        this.memoryDAO = memoryDAO;
    }

    @Override
    public List<Book> generate(UserInputChoice generateType, int size) {
        List<Book> books = new ArrayList<>();
        switch (generateType) {
            case UserInputChoice.ACTION_BOOK_FILE_GENERATED:
                books = fileDao.get(size);
                break;
            case UserInputChoice.ACTION_BOOK_RANDOM_GENERATED:
                books = generateRandomBooks(size);
                break;
            case UserInputChoice.ACTION_BOOK_MANUAL_GENERATED:
                books = memoryDAO.get(size);
                break;
        }
        return books;
    }

    @Override
    public List<Book> find(List<Book> books, Book item) {
        return super.getSearchStrategy().find(books, item);
    }

    @Override
    public void sort(List<Book> list) {
        super.getSortStrategy().sort(list);
    }

    @Override
    public void add(Book item) {
        memoryDAO.add(item);
    }

    private List<Book> generateRandomBooks(int count) {
        Random random = new Random();
        List<Book> books = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            String author = "Автор " + random.nextInt(10);
            String title = "Книга " + random.nextInt(50);
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
