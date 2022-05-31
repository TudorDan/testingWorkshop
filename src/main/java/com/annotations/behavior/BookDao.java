package com.annotations.behavior;

import java.util.List;

public interface BookDao {

    void save(Book book);
    Book findBookById(String bookId);
}
