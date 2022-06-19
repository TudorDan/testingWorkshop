package com.codecool.testDoubles.dummy;

import java.util.Collection;

public interface BookDao {
    void save(Book book);
    Collection<Book> findAll();
}
