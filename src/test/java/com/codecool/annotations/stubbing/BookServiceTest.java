package com.codecool.annotations.stubbing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
    @InjectMocks
    private BookService bookService;

    @Mock
    private BookDao bookDao;

    @Test
    public void testCalculateTotalCostOfBooks() {
        List<String> bookIds = new ArrayList<>();
        bookIds.add("1234");
        bookIds.add("1235");

        Book book1 = new Book("1234", "Mockito In Action", 500, LocalDate.now());
        Book book2 = new Book("1235", "JUnit5 In Action", 400, LocalDate.now());

/*        when(bookDao.findBookById("1234")).thenReturn(book1);
        when(bookDao.findBookById("1235")).thenReturn(book2);*/

        doReturn(book1).when(bookDao).findBookById("1234");
        doReturn(book2).when(bookDao).findBookById("1235");

        int actualCost = bookService.calculateTotalCost(bookIds);
        assertEquals(900, actualCost);
    }

    @Test
    public void testSaveBook() {
        Book book1 = new Book(null, "Mockito In Action", 500, LocalDate.now());
        doNothing().when(bookDao).save(book1); // book1 from line 46 == book1 from line 47
        bookService.addBook(book1);
    }

    @Test
    public void testSaveBookWithBookRequest() {
        BookRequest bookRequest = new BookRequest("Mockito In Action", 500, LocalDate.now());
        Book book = new Book(null, "Mockito In Action", 500, LocalDate.now());
        doNothing().when(bookDao).save(book);  // book == bookRequest
        bookService.addBook(bookRequest);
    }
}
