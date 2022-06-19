package com.codecool.testDoubles.dummy;

import java.time.LocalDate;

public class Book {
    private String bookId;
    private String title;
    private int price;
    private LocalDate publishDate;

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
