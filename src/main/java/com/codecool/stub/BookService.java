package com.codecool.stub;

import java.util.List;

public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getNewBooksWithAppliedDiscount(int discountRate, int days) {
        List<Book> newBooks = bookRepository.findNewBooks(days);
        // 500 apply 10% -> 10% of 500 -> 50 -> 500 - 50 -> 450
        for (Book newBook : newBooks) {
            int price = newBook.getPrice();
            int newPrice = price - (discountRate * price / 100);
            newBook.setPrice(newPrice);
        }
        return newBooks;
    }
}
