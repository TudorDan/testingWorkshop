package com.codecool.dummy;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DummyBookDao implements BookDao {
    // In memory db, HashMap or List
    Map<String, Book> bookStore = new HashMap<>();

    @Override
    public void save(Book book) {
        bookStore.put(book.getBookId(), book);
    }

    @Override
    public Collection<Book> findAll() {
        return bookStore.values();
    }
}
