package ru.aston.sort_app.core;

import java.util.Comparator;

public class Book {
    private final String author;
    private final String title;
    private final int pages;

    // Private constructor for Builder
    private Book(Builder builder) {
        this.author = builder.author;
        this.title = builder.title;
        this.pages = builder.pages;
    }

    // Getters
    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getPages() {
        return pages;
    }

    // Override toString
    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", pages=" + pages +
                '}';
    }

    // Builder class
    public static class Builder {
        private String author;
        private String title;
        private int pages;

        public Builder setAuthor(String author) {
            this.author = author;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setPages(int pages) {
            this.pages = pages;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }

    //Comparators 
    public static final Comparator<Book> byAuthor = Comparator.comparing(Book::getAuthor);
    public static final Comparator<Book> byTitle = Comparator.comparing(Book::getTitle);
    public static final Comparator<Book> byPages = Comparator.comparingInt(Book::getPages);
    public static final Comparator<Book> byAuthorThenTitleThenPages =
        byAuthor.thenComparing(byTitle).thenComparing(byPages);
}
    

