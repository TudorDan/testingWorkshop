package com.codecool.behaviorDrivenDevelopment.stubbing;

import java.util.List;

public interface BookDao {

    List<Book> findNewBooks(int days);
}
