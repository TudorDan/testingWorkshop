package com.codecool.fake;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FakeTest {
    @Test
    public void testFake() {
        BookDao bookDaoFake = new FakeBookDao();
        BookService bookService = new BookService(bookDaoFake);

        bookService.addBook(new Book("1234", "Testing in Action", 250, LocalDate.now()));
        bookService.addBook(new Book("1235", "JUnit in Action", 200, LocalDate.now()));

        assertEquals(2, bookService.findNumberOfBooks());
    }
}
