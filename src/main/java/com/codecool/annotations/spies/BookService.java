package com.codecool.annotations.spies;

public class BookService {

    public Book findBook(String bookId) {
/*        // Code to bring book from database
        return null; // "Method not implemented"*/
        throw new RuntimeException("Method not implemented");
    }

    public int getAppliedDiscount(Book book, int discountRate) {
        int price = book.getPrice();
        int newPrice = price - (price * discountRate / 100);
        return newPrice;
    }
}
