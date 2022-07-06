package com.codecool.behaviorDrivenDevelopment.verification;

public class BookService {
    private final BookDao bookDao;

    public BookService(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public void updatePrice(String bookId, int updatedPrice){
        Book book = bookDao.findBookById(bookId);
        book.setPrice(updatedPrice);
        bookDao.save(book);
    }
}
