package com.codecool.behaviorDrivenDevelopment.stubbing;

import com.codecool.testDoubles.stub.Book;
import com.codecool.testDoubles.stub.BookDao;
import com.codecool.testDoubles.stub.BookService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StubTest {
    @InjectMocks
    private BookService bookService;

    @Mock
    private BookDao bookDao;

    @Test
    public void demoStubbingWithMockitoTraditionalStyle() {
        Book book1 = new Book("1234", "Testing in Action", 500, LocalDate.now());
        Book book2 = new Book("1235", "JUnit in Action", 400, LocalDate.now());
        List<Book> newBooks = new ArrayList<>();
        newBooks.add(book1);
        newBooks.add(book2);

        when(bookDao.findNewBooks(7)).thenReturn(newBooks);

        List<Book> newBooksWithAppliedDiscount = bookService.getNewBooksWithAppliedDiscount(10, 7);

        assertEquals(2, newBooksWithAppliedDiscount.size());
        assertEquals(450, newBooksWithAppliedDiscount.get(0).getPrice());
        assertEquals(360, newBooksWithAppliedDiscount.get(1).getPrice());
    }

    @Test
    @DisplayName("Given - New Books, When - Applied discount method is called, The - New discount books is returned")
    public void test_Given_NewBooks_When_GetNewBooksWithAppliedDiscountIsCalled_Then_NewBooksWithAppliedDiscountIsReturned() {
        // Arrange - Given
        Book book1 = new Book("1234", "Testing in Action", 500, LocalDate.now());
        Book book2 = new Book("1235", "JUnit in Action", 400, LocalDate.now());
        List<Book> newBooks = new ArrayList<>();
        newBooks.add(book1);
        newBooks.add(book2);

        given(bookDao.findNewBooks(7)).willReturn(newBooks);

        // Act - When
        List<Book> newBooksWithAppliedDiscount = bookService.getNewBooksWithAppliedDiscount(10, 7);

        // Assert - Then
        then(newBooksWithAppliedDiscount).isNotNull();
        then(newBooksWithAppliedDiscount.size()).isEqualTo(2);
        then(newBooksWithAppliedDiscount.get(0).getPrice()).isEqualTo(450);
    }
}
