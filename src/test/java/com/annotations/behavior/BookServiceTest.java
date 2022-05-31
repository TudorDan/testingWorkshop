package com.annotations.behavior;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
    @InjectMocks
    private BookService bookService;

    @Mock
    private BookDao bookDao;

    @Test
    public void testAddBook(){
        Book book1 = new Book(null, "Mockito In Action", 500, LocalDate.now());
        bookService.addBook(book1);
        bookService.addBook(book1);
        verify(bookDao, times(2)).save(book1);
    }

    @Test
    public void testSaveBookWithBookRequest(){
        BookRequest bookRequest = new BookRequest("Mockito In Action", 500, LocalDate.now());
        Book book = new Book(null, "Mockito In Action", 500, LocalDate.now());
        bookService.addBook(bookRequest);
        verify(bookDao, never()).save(book);
    }

    @Test
    public void testUpdatePrice(){
        bookService.updatePrice(null, 600);
        verifyNoInteractions(bookDao);
    }
}
