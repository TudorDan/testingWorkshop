package com.annotations.support;

import com.annotations.support.Book;
import com.annotations.support.BookDao;
import com.annotations.support.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AnnotationsTest {
    @InjectMocks
    private BookService bookService;

    @Mock
    private BookDao bookDaoStub;

    @Test
    public void demoCreateMocksUsingAnnotations() {
        Book book1 = new Book("1234", "Testing in Action", 500, LocalDate.now());
        Book book2 = new Book("1235", "JUnit in Action", 400, LocalDate.now());
        List<Book> newBooks = new ArrayList<>();
        newBooks.add(book1);
        newBooks.add(book2);

        when(bookDaoStub.findNewBooks(7)).thenReturn(newBooks);

        List<Book> newBooksWithAppliedDiscount = bookService.getNewBooksWithAppliedDiscount(10, 7);

        assertEquals(2, newBooksWithAppliedDiscount.size());
        assertEquals(450, newBooksWithAppliedDiscount.get(0).getPrice());
        assertEquals(360, newBooksWithAppliedDiscount.get(1).getPrice());
    }
}
