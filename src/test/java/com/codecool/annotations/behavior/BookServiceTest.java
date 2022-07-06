package com.codecool.annotations.behavior;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
    @InjectMocks
    private BookService bookService;

//    @Mock
//    private BookDao bookDao;

    @Spy
    private BookDao bookDao;

    @Test
    public void testAddBook() {
        Book book1 = new Book(null, "Mockito In Action", 500, LocalDate.now());
        bookService.addBook(book1);
        bookService.addBook(book1);
        verify(bookDao, times(2)).save(book1);
    }

    @Test
    public void testSaveBookWithBookRequestWithSmallerPrice() {
        BookRequest bookRequest = new BookRequest("Mockito In Action", 500, LocalDate.now());
        Book book = new Book(null, "Mockito In Action", 500, LocalDate.now());
        bookService.addBook(bookRequest);
        verify(bookDao, never()).save(book);
    }

    @Test
    public void testSaveBookWithBookRequestWithGreaterPrice() {
        BookRequest bookRequest = new BookRequest("Mockito In Action", 600, LocalDate.now());
        Book book = new Book(null, "Mockito In Action", 600, LocalDate.now());
        bookService.addBook(bookRequest);
        verify(bookDao, times(1)).save(book);
    }

    @Test
    public void testUpdatePriceNullValue() {
        bookService.updatePrice(null, 600);
        verifyNoInteractions(bookDao);
    }

    @Test
    public void testUpdatePriceWithBookId() {
        Book book = new Book("1234", "Mockito In Action", 600, LocalDate.now());
        when(bookDao.findBookById("1234")).thenReturn(book);
        bookService.updatePrice("1234", 500);
        verify(bookDao).findBookById("1234");
        verify(bookDao).save(book);
        verifyNoMoreInteractions(bookDao);
    }

    @Test
    public void testUpdatePriceInOrder() {
        Book book = new Book("1234", "Mockito In Action", 600, LocalDate.now());
        when(bookDao.findBookById("1234")).thenReturn(book);
        bookService.updatePrice("1234", 500);

        InOrder inOrder = inOrder(bookDao);
        inOrder.verify(bookDao).findBookById("1234");
        inOrder.verify(bookDao).save(book);
    }

    @Test
    public void testSaveBookWithBookRequestWithAtMost() {
        BookRequest bookRequest = new BookRequest("Mockito In Action", 550, LocalDate.now());
        Book book = new Book(null, "Mockito In Action", 550, LocalDate.now());
        bookService.addBook(bookRequest);
        bookService.addBook(bookRequest);
        bookService.addBook(bookRequest);
        verify(bookDao, atMost(3)).save(book);
    }
}
