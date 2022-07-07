package com.codecool.matchers;

import java.time.LocalDate;
import java.util.List;

public class BookService {
    private final BookDao bookDao;

    public BookService(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public void addBook(Book book) {
        bookDao.save(book);
    }

    public void addBook(BookRequest bookRequest) {
        if (bookRequest.getPrice() <= 500) {
            return;
        }
        Book book = new Book();
        book.setTitle(bookRequest.getTitle());
        book.setPrice(bookRequest.getPrice());
        book.setPublishDate(bookRequest.getPublishedDate());
        bookDao.save(book);
    }

    public void updatePrice(String bookId, int updatedPrice) {
        if (bookId == null) {
            return;
        }
        Book book = bookDao.findBookById(bookId);
        if (book.getPrice() == updatedPrice) {
            return;
        }
        book.setPrice(updatedPrice);
        bookDao.save(book);
    }

    public Book getBookByTitleAndPublishDate(String title, LocalDate localDate) {
        return bookDao.findBookByTitleAndPublishedDate(title, localDate);
    }

    public Book getBookByTitleAndPriceAndIsDigital(String title, int price, boolean isDigital) {
        return bookDao.findBookByTitleAndPriceAndIsDigital(title, price, isDigital);
    }

    public void addBooks(List<Book> books) {
        bookDao.saveAll(books);
    }
}
