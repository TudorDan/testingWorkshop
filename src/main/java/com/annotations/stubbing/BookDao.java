package com.annotations.stubbing;

import java.util.List;

public interface BookDao {

    List<Book> findNewBooks(int days);
    Book findBookById(String bookId);
    void save(Book book);
}
