package com.codecool.mock;

import java.time.LocalDate;

public class Book {
    private final String bookId;
    private final String title;
    private final int price;
    private final LocalDate publishDate;

    public Book(String bookId, String title, int price, LocalDate publishDate) {
        this.bookId = bookId;
        this.title = title;
        this.price = price;
        this.publishDate = publishDate;
    }

    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }
}
