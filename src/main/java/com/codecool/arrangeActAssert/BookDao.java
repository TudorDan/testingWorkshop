package com.codecool.arrangeActAssert;

import java.util.List;

public interface BookDao {

    List<Book> findNewBooks(int days);
}
