package com.codecool.testDoubles.stub;

import java.util.List;

public interface BookDao {

    List<Book> findNewBooks(int days);
}
