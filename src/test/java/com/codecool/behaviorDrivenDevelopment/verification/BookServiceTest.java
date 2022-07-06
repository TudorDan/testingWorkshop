package com.codecool.behaviorDrivenDevelopment.verification;

import com.codecool.annotations.behavior.Book;
import com.codecool.annotations.behavior.BookDao;
import com.codecool.annotations.behavior.BookRequest;
import com.codecool.annotations.behavior.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
    @InjectMocks
    private BookService bookService;

    @Mock
    private BookDao bookDao;

//    @Spy
//    private BookDao bookDao;

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
    public void test_Given_ABook_When_UpdatePriceIsCalledWithNewPrice_Then_BookPriceIsUpdated(){
        // Give - Arrange
        Book book = new Book("1234", "Mockito In Action", 600, LocalDate.now());
        given(bookDao.findBookById("1234")).willReturn(book);
        // When - Act
        bookService.updatePrice("1234", 500);

        // Then - Assert/Verify
        then(bookDao).should().save(book);
    }
}
