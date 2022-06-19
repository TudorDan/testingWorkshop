package com.codecool.annotations.exception;

import java.sql.SQLException;
import java.util.List;

public interface BookDao {

    void save(Book book) throws SQLException;

    List<Book> findAllBooks() throws SQLException;
}
