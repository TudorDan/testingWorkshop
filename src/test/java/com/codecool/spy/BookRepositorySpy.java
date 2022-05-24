package com.codecool.spy;

public class BookRepositorySpy implements BookRepository{
    int saveCalled = 0;
    Book lastAddedBook = null;

    @Override
    public void save(Book book) {
        saveCalled++;
        lastAddedBook = book;
    }

    public int getSaveCalled() {
        return saveCalled;
    }

    public boolean isCalledWith(Book book){
        return lastAddedBook.equals(book);
    }
}
