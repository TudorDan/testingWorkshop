package com.codecool.annotations.argument;

import java.time.LocalDate;
import java.util.Objects;

public class Book {
    private String bookId;
    private String title;
    private int price;
    private LocalDate publishDate;

    public Book() {
    }

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

    public void setPrice(int price) {
        this.price = price;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }
}
