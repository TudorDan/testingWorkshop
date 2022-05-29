package com.codecool.dummy;

import java.util.Collection;

public interface BookDao {
    void save(Book book);
    Collection<Book> findAll();
}
