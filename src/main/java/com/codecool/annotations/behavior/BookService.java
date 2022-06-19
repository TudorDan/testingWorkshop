package com.codecool.annotations.behavior;

public class BookService {
    private final BookDao bookDao;

    public BookService(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public void addBook(Book book){
        bookDao.save(book);
    }

    public void addBook(BookRequest bookRequest){
        if (bookRequest.getPrice() <= 500) {
            return;
        }
        Book book = new Book();
        book.setTitle(bookRequest.getTitle());
        book.setPrice(bookRequest.getPrice());
        book.setPublishDate(bookRequest.getPublishedDate());
        bookDao.save(book);
    }

    public void updatePrice(String bookId, int updatedPrice){
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
}
