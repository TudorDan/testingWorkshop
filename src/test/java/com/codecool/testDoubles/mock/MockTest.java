package com.codecool.testDoubles.mock;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.mockito.Mockito.*;

public class MockTest {
    @Test
    public void demoMock() {
        BookRepositoryMock bookRepositoryMock = new BookRepositoryMock();
        BookService bookService = new BookService(bookRepositoryMock);

        Book book1 = new Book("1234", "Mockito in Action", 500, LocalDate.now());
        Book book2 = new Book("1235", "JUnit5 in Action", 400, LocalDate.now());

        bookService.addBook(book1); // return
        bookService.addBook(book2); // save will be called

        bookRepositoryMock.verify(book2, 1);
    }

    @Test
    public void demoMockWithMockito() {
        BookRepository bookRepositoryMock = mock(BookRepository.class);
        BookService bookService = new BookService(bookRepositoryMock);

        Book book1 = new Book("1234", "Mockito in Action", 500, LocalDate.now());
        Book book2 = new Book("1235", "JUnit5 in Action", 400, LocalDate.now());

        bookService.addBook(book1); // return
        bookService.addBook(book2); // save will be called

        verify(bookRepositoryMock, times(1)).save(book2);
        verify(bookRepositoryMock, times(0)).save(book1);
    }
}
