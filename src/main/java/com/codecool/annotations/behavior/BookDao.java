package com.codecool.annotations.behavior;

public interface BookDao {

    void save(Book book);
    Book findBookById(String bookId);
}
