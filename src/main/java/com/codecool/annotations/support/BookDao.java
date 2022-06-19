package com.codecool.annotations.support;

import java.util.List;

public interface BookDao {

    List<Book> findNewBooks(int days);
}
