package com.codecool.annotations.argument;

public interface BookDao {

    void save(Book book);
    Book findBookById(String bookId);
}
