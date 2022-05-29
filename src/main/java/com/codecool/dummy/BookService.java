package com.codecool.dummy;

public class BookService {
    private final BookDao bookDao;
    private final EmailService emailService;

    public BookService(BookDao bookDao, EmailService emailService) {
        this.bookDao = bookDao;
        this.emailService = emailService;
    }

    public void addBook(Book book){
        bookDao.save(book);
    }

    public int findNumberOfBooks(){
        return bookDao.findAll().size();
    }

    // Other methods which use EmailService
}
