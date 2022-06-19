package com.codecool.annotations.stubbing;

import java.util.List;

public class BookService {
    private final BookDao bookDao;

    public BookService(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public List<Book> getNewBooksWithAppliedDiscount(int discountRate, int days) {
        List<Book> newBooks = bookDao.findNewBooks(days);
        // 500 apply 10% -> 10% of 500 -> 50 -> 500 - 50 -> 450
        for (Book newBook : newBooks) {
            int price = newBook.getPrice();
            int newPrice = price - (discountRate * price / 100);
            newBook.setPrice(newPrice);
        }
        return newBooks;
    }

    public int calculateTotalCost(List<String> booksIds) {
        int total = 0;
        for (String bookId : booksIds) {
            Book book = bookDao.findBookById(bookId);
            total = total + book.getPrice();
        }
        return total;
    }

    public void addBook(Book book){
        bookDao.save(book);
    }

    public void addBook(BookRequest bookRequest){
        Book book = new Book();
        book.setTitle(bookRequest.getTitle());
        book.setPrice(bookRequest.getPrice());
        book.setPublishDate(bookRequest.getPublishedDate());
        bookDao.save(book);
    }
}
