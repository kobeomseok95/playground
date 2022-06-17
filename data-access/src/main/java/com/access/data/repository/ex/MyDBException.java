package com.access.data.repository.ex;

public class MyDBException extends RuntimeException {
    public MyDBException() {
    }

    public MyDBException(String message) {
        super(message);
    }

    public MyDBException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyDBException(Throwable cause) {
        super(cause);
    }
}
