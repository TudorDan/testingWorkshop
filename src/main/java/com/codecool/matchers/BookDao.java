package com.codecool.matchers;

import java.time.LocalDate;
import java.util.List;

public interface BookDao {

    void save(Book book);
    Book findBookById(String bookId);

    Book findBookByTitleAndPublishedDate(String title, LocalDate localDate);

    Book findBookByTitleAndPriceAndIsDigital(String title, int price, boolean isDigital);

    void saveAll(List<Book> books);
}
