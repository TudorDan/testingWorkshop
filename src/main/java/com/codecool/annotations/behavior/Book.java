package com.codecool.annotations.behavior;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return price == book.price && Objects.equals(title, book.title) && Objects.equals(publishDate, book.publishDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, price, publishDate);
    }
}
