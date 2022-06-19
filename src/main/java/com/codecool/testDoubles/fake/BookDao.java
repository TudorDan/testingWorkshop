package com.codecool.testDoubles.fake;

import java.util.Collection;

public interface BookDao {
    void save(Book book);
    Collection<Book> findAll();
}
