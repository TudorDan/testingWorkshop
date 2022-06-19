package com.codecool.annotations.exception;

import java.sql.SQLException;
import java.util.List;

public class BookService {
    private final BookDao bookDao;

    public BookService(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public void addBook(Book book) {
        try {
            bookDao.save(book);
        } catch (SQLException e) {
            // log exception
            throw new DatabaseWriteException("Unable to write in database due to - " + e.getMessage());
        }
    }

    public int getTotalPriceOfBooks() {
        List<Book> books = null;
        try {
            books =  bookDao.findAllBooks();
        } catch (SQLException e) {
            // log exception
            throw new DatabaseReadException("Unable to read from database due to - " + e.getMessage());
        }
        int totalPrice = 0;
        for (Book book : books) {
            totalPrice = totalPrice + book.getPrice();
        }
        return totalPrice;
    }
}
