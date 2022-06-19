package com.codecool.annotations.exception;

public class DatabaseWriteException extends RuntimeException {
    public DatabaseWriteException(String message) {
        super(message);
    }
}
