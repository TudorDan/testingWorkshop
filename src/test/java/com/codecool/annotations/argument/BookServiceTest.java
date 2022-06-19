package com.codecool.annotations.argument;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
    @InjectMocks
    private BookService bookService;

    @Mock
    private BookDao bookDao;

    @Captor
    private ArgumentCaptor<Book> bookArgumentCaptor;

    @Test
    public void testSaveBook() {
        BookRequest bookRequest = new BookRequest("Mockito In Action", 600, LocalDate.now());
//        ArgumentCaptor<Book> bookArgumentCaptor = ArgumentCaptor.forClass(Book.class);

        bookService.addBook(bookRequest);
        verify(bookDao, times(1)).save(bookArgumentCaptor.capture());
        Book book = bookArgumentCaptor.getValue();
        assertEquals("Mockito In Action", book.getTitle());
    }
}
