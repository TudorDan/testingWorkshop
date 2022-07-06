package com.codecool.annotations.exception;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
    @InjectMocks
    BookService bookService;

    @Mock
    BookDao bookDao;

    @Test
    public void testTotalPriceOfBooks() throws SQLException {
        when(bookDao.findAllBooks()).thenThrow(SQLException.class);
        assertThrows(DatabaseReadException.class, () -> bookService.getTotalPriceOfBooks());
    }

    @Test
    public void testTotalPriceOfBooks2() throws SQLException {
        when(bookDao.findAllBooks()).thenThrow(new SQLException("Database not available"));
        assertThrows(DatabaseReadException.class, () -> bookService.getTotalPriceOfBooks());
    }

    @Test
    public void testTotalPriceOfBooks3() throws SQLException {
//        when(bookDao.findAllBooks()).thenThrow(SQLException.class);
        given(bookDao.findAllBooks()).willThrow(SQLException.class);
        assertThrows(DatabaseReadException.class, () -> bookService.getTotalPriceOfBooks());
    }

    @Test
    public void testAddBook() throws SQLException {
        Book book = new Book(null, "Mockito In Action", 600, LocalDate.now());
        doThrow(SQLException.class).when(bookDao).save(book);
        assertThrows(DatabaseWriteException.class, () -> bookService.addBook(book));
    }
}
