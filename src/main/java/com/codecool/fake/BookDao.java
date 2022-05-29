package com.codecool.fake;

import java.util.Collection;

public interface BookDao {
    void save(Book book);
    Collection<Book> findAll();
}
