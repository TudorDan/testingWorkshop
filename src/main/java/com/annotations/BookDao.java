package com.annotations;

import java.util.List;

public interface BookDao {

    List<Book> findNewBooks(int days);
}
