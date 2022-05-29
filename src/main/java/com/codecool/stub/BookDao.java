package com.codecool.stub;

import java.util.List;

public interface BookDao {

    List<Book> findNewBooks(int days);
}
