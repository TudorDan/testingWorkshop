package com.codecool.matchers;

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

/*    @Spy
    private BookDao bookDao;*/

    @Test
    public void testUpdatePriceWithBookId() {
        Book book1 = new Book("1234", "Mockito In Action", 600, LocalDate.now());
        Book book2 = new Book("1234", "Mockito In Action", 500, LocalDate.now());
//        when(bookDao.findBookById(any())).thenReturn(book1);
        when(bookDao.findBookById(any(String.class))).thenReturn(book1);
        bookService.updatePrice("xyz", 500);
        verify(bookDao).save(book2);
    }

    @Test
    public void testInvalidUseOfArgumentMatchers(){
        Book book = new Book("1234", "Mockito In Action", 600, LocalDate.now());
        // Argument Matchers should be provided for all arguments
        // Argument Matchers can't be used outside stubbing/verification
        when(bookDao.findBookByTitleAndPublishedDate(eq("Mockito In Action"), any())).thenReturn(book);
        Book actualBook = bookService.getBookByTitleAndPublishDate("Mockito In Action",
                LocalDate.of(2021, 10, 23));
        assertEquals("Mockito In Action", actualBook.getTitle());
    }

    @Test
    public void testSpecificTypeOfArgumentMatchers(){
        Book book = new Book("1234", "Mockito In Action", 600, LocalDate.now());
        when(bookDao.findBookByTitleAndPriceAndIsDigital(anyString(), anyInt(), anyBoolean()))
                .thenReturn(book);
        Book actualBook = bookService
                .getBookByTitleAndPriceAndIsDigital("Mockito In Action", 600, true);
        assertEquals("Mockito In Action", actualBook.getTitle());
    }

    @Test
    public void testCollectionTypeArgumentMatchers(){
        List<Book> books = new ArrayList<>();
        Book book1 = new Book("1234", "Mockito In Action", 600, LocalDate.now());
        books.add(book1);
        bookService.addBooks(books);
        verify(bookDao).saveAll(anyList()); // anySet, anyMap, anyCollection
    }

    @Test
    public void testStringTypeArgumentMatchers(){
        Book book = new Book("1234", "Mockito In Action", 600, LocalDate.now());
        when(bookDao.findBookByTitleAndPriceAndIsDigital(contains("Action"), anyInt(), anyBoolean()))
                .thenReturn(book);
        Book actualBook = bookService
                .getBookByTitleAndPriceAndIsDigital("Mockito In Action", 600, true);
        assertEquals("Mockito In Action", actualBook.getTitle());
    }
}
