package com.codecool.fake;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FakeTest {
    @Test
    public void testFake() {
        BookDao bookDaoFake = new FakeBookDao();
        BookService bookService = new BookService(bookDaoFake);

        bookService.addBook(new Book("1234", "Testing in Action", 250, LocalDate.now()));
        bookService.addBook(new Book("1235", "JUnit in Action", 200, LocalDate.now()));

        assertEquals(2, bookService.findNumberOfBooks());
    }

    @Test
    public void testFakeWithMockito() {
        BookDao bookDao = mock(BookDao.class);
        BookService bookService = new BookService(bookDao);

        Book book1 = new Book("1234", "Testing in Action", 250, LocalDate.now());
        Book book2 = new Book("1235", "JUnit in Action", 200, LocalDate.now());

        Collection<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);

        when(bookDao.findAll()).thenReturn(books);

        assertEquals(2, bookService.findNumberOfBooks());
    }
}
