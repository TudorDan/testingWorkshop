package com.codecool.behaviorDrivenDevelopment.verification;

public interface BookDao {

    void save(Book book);
    Book findBookById(String bookId);
}
