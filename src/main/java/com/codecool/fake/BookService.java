package com.codecool.fake;

public class BookService {
    private final BookDao bookDao;

    public BookService(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public void addBook(Book book){
        bookDao.save(book);
    }

    public int findNumberOfBooks(){
        return bookDao.findAll().size();
    }
}
