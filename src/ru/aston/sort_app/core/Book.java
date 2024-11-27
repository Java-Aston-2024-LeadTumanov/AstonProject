package ru.aston.sort_app.core;

import java.util.Objects;

public class Book {
    private final String author;
    private final String title;
    private final int pageCount;

    private Book(Builder builder) {
        this.author = builder.author;
        this.title = builder.title;
        this.pageCount = builder.pageCount;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getPageCount() {
        return pageCount;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", pageCount=" + pageCount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return pageCount == book.pageCount &&
                Objects.equals(author, book.author) &&
                Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, title, pageCount);
    }

    public static class Builder {
        private String author;
        private String title;
        private int pageCount;

        public Builder setAuthor(String author) {
            if (author == null || author.isBlank()) {
                throw new IllegalArgumentException("Автор не может быть пустым.");
            }
            this.author = author;
            return this;
        }

        public Builder setTitle(String title) {
            if (title == null || title.isBlank()) {
                throw new IllegalArgumentException("Название книги не может быть пустым.");
            }
            this.title = title;
            return this;
        }

        public Builder setPageCount(int pageCount) {
            if (pageCount <= 0) {
                throw new IllegalArgumentException("Количество страниц должно быть положительным числом больше ноля.");
            }
            this.pageCount = pageCount;
            return this;
        }

        public Book build() {
            if (author == null || title == null) {
                throw new IllegalStateException("Автор и название книги обязательны.");
            }
            return new Book(this);
        }
    }
}

