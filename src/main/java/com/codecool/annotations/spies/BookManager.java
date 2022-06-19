package com.codecool.annotations.spies;

public class BookManager {
    private BookService bookService;

    public BookManager(BookService bookService) {
        this.bookService = bookService;
    }

    public int applyDiscountOnBook(String bookId, int discountRate){
        Book book = bookService.findBook(bookId); // We need to Mock
        int discountedPrice = bookService.getAppliedDiscount(book, discountRate); // We need to actually call
        return discountedPrice;
    }
}
