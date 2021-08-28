package com.luizalabs.spongebob.exception;

public class ConflictException extends RuntimeException {
    public ConflictException(String details) {
        super(details);
    }
}